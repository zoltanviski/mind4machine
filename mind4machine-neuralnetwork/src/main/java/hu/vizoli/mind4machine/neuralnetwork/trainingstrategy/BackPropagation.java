package hu.vizoli.mind4machine.neuralnetwork.trainingstrategy;

import java.util.List;

import hu.vizoli.mind4machine.neuralnetwork.activationfunction.ActivationFunction;
import hu.vizoli.mind4machine.neuralnetwork.connection.Connection;
import hu.vizoli.mind4machine.neuralnetwork.dataset.DataSet;
import hu.vizoli.mind4machine.neuralnetwork.dataset.DataSetElement;
import hu.vizoli.mind4machine.neuralnetwork.layer.Layer;
import hu.vizoli.mind4machine.neuralnetwork.neuron.AbstractNeuron;
import hu.vizoli.mind4machine.neuralnetwork.trainer.Trainer;
import hu.vizoli.mind4machine.neuralnetwork.weight.Weight;

/**
 * Back propagation training strategy implementation.
 * It calculates the error of the output values and propagate it back to the 
 * first hidden Layer.
 * (Output layer -> Hidden layers -> first Hidden Layer)
 * 
 * @author Zoltan Viski (vizoli)
 */
public class BackPropagation implements TrainingStrategy {

	/**
	 * Serial id.
	 */
	private static final long serialVersionUID = 7L;

	/**
	 * The parent Trainer.
	 */
	private Trainer parentTrainer;

	@Override
	public void startEpoch(final DataSet trainingDataSet) {
		final int n = trainingDataSet.getSize();
		for (int j = 0; j < n; j++) {
			learnPattern(trainingDataSet.getDataSetElement(j));
		}
	}

	@Override
	public void finishEpoch() {

	}

	/**
	 * Learns the given dataSetElement.
	 * Tunes the Weights in order to the better accuracy.
	 * Sets the calculated new Weight values to the Neurons.
	 * 
	 * @param dataSetElement the DataSetElement
	 */
	private void learnPattern(final DataSetElement dataSetElement) {
		parentTrainer.getParentNeuralNetwork().setInputs(dataSetElement.getInput());
		parentTrainer.getParentNeuralNetwork().forwardPropagation();

		final double[] outputValues = parentTrainer.getParentNeuralNetwork().getOutputValues();
		final double[] patternLoss = parentTrainer.getLossFunction().calculatePatternLoss(outputValues,
				dataSetElement.getIdealOutput());

		tuneOutputNeurons(patternLoss);
		tuneHiddenNeurons();

		applyTunedWeights();
	}

	/**
	 * Calculates the error values of the Output Neurons.
	 * Updates the Neuron's Weight to the calculated new Weight.
	 * 
	 * @param patternLoss the output error
	 */
	private void tuneOutputNeurons(final double[] patternLoss) {
		final List<AbstractNeuron> outputNeurons = parentTrainer.getParentNeuralNetwork().getOuputLayer().getNeurons();

		final int n = outputNeurons.size();
		for (int i = 0; i < n; i++) {
			final AbstractNeuron neuron = outputNeurons.get(i);
			if (patternLoss[i] == 0) {
				outputNeurons.get(i).setError(0);

				continue;
			}

			final double delta = patternLoss[i] * neuron.getActivationFunction().getDerivative();
			neuron.setError(delta);

			saveNeuronTunedWeights(neuron);
		}
	}

	/**
	 * Calculates the error values of the Hidden  Neurons.
	 * Updates the Neuron's Weight to the calculated new Weight.
	 */
	private void tuneHiddenNeurons() {
		for (final Layer hiddenLayer : parentTrainer.getParentNeuralNetwork().getHiddenLayers()) {
			for (final AbstractNeuron neuron : hiddenLayer.getNeurons()) {
				final double delta = calculateHiddenNeuronError(neuron);
				neuron.setError(delta);

				saveNeuronTunedWeights(neuron);
			}
		}
	}

	/**
	 * Saves the tuned Weight of the given Neuron.
	 * 
	 * @param neuron the Neuron
	 */
	private void saveNeuronTunedWeights(final AbstractNeuron neuron) {
		final double delta = neuron.getError();

		for (final Connection connection : neuron.getInputConnections()) {
			final double input = connection.getInput();
			final double tunedWeight = -parentTrainer.getEta() * delta * input;

			final Weight weight = connection.getWeight();
			weight.setTunedWeight(tunedWeight);
		}
	}

	/**
	 * Applies the tuned Weights for the Output and Hidden Layers.
	 */
	private void applyTunedWeights() {
		for (int i = parentTrainer.getParentNeuralNetwork().getLayers().size() - 1; i > 0; i--) {
			for (final AbstractNeuron neuron : parentTrainer.getParentNeuralNetwork().getLayers().get(i).getNeurons()) {
				for (final Connection connection : neuron.getInputConnections()) {
					final Weight weight = connection.getWeight();

					final double newWeight = weight.getValue() + weight.getTunedWeight();
					weight.setValue(newWeight);

					weight.setTunedWeight(0);
				}
			}
		}
	}

	/**
	 * Calculates the Hidden Neuron's error.
	 * 
	 * @param neuron the Neuron
	 * @return the error
	 */
	private double calculateHiddenNeuronError(final AbstractNeuron neuron) {
		double deltaSum = 0.0;

		for (final Connection connection : neuron.getOutputConnections()) {
			final double delta = connection.getToNeuron().getError() * connection.getWeight().getValue();
			deltaSum += delta;
		}

		final ActivationFunction activationFunction = neuron.getActivationFunction();
		final double derivative = activationFunction.getDerivative();
		final double result = derivative * deltaSum;

		return result;
	}

	@Override
	public void setParentTrainer(final Trainer parentTrainer) {
		this.parentTrainer = parentTrainer;
	}

}
