package hu.vizoli.mind4machine.examples.neuralnetwork;

import java.util.ArrayList;
import java.util.List;

import hu.vizoli.mind4machine.neuralnetwork.activationfunction.type.ActivationFunctionType;
import hu.vizoli.mind4machine.neuralnetwork.dataset.DataSet;
import hu.vizoli.mind4machine.neuralnetwork.inputfunction.type.InputFunctionType;
import hu.vizoli.mind4machine.neuralnetwork.layer.configuration.LayerConfiguration;
import hu.vizoli.mind4machine.neuralnetwork.lossfunction.MeanSquaredError;
import hu.vizoli.mind4machine.neuralnetwork.network.NeuralNetwork;
import hu.vizoli.mind4machine.neuralnetwork.network.NeuralNetworkImpl;
import hu.vizoli.mind4machine.neuralnetwork.network.configuration.NeuralNetworkConfiguration;
import hu.vizoli.mind4machine.neuralnetwork.neuron.configuration.NeuronConfiguration;
import hu.vizoli.mind4machine.neuralnetwork.neuron.type.NeuronType;
import hu.vizoli.mind4machine.neuralnetwork.stopcriteria.EpochLimitStop;
import hu.vizoli.mind4machine.neuralnetwork.stopcriteria.MinLossStop;
import hu.vizoli.mind4machine.neuralnetwork.trainer.IterativeTrainer;
import hu.vizoli.mind4machine.neuralnetwork.trainer.Trainer;
import hu.vizoli.mind4machine.neuralnetwork.trainer.configuration.TrainerConfiguration;
import hu.vizoli.mind4machine.neuralnetwork.trainingstrategy.BackPropagation;

public class IrisClassificationNeuralNetworkExample {

	/**
	 * Main.
	 * 
	 * @param args
	 */
	public static void main(final String[] args) {
		final NeuralNetwork neuralNetwork = getNeuralNetwork();

		final DataSet dataSet = DataSet.createFromCSV(
				"src/main/java/hu/vizoli/mind4machine/examples/neuralnetwork/data/iris.full.dataset.normalized.csv",
				4, 3);

		neuralNetwork.train(dataSet);

		for (int i = 0; i < dataSet.getSize(); i++) {
			System.out.println("----------------------");
			final double[] prediction = neuralNetwork.getPrediction(dataSet.getDataSetElement(i).getInput());
			final int n = prediction.length;
			System.out.print("Ideal    : ");
			for (int j = 0; j < n; j++) {

				System.out.print(prediction[j] + " ");
			}
			System.out.println("");
			System.out.print("Predicted: ");
			for (int j = 0; j < n; j++) {
				System.out.print(dataSet.getDataSetElement(i).getIdealOutput()[j] + " ");
			}
			System.out.println("");
		}

		System.out.println("--------------------------------------------------------");
		System.out.println("Neural network accuracy: "
				+ (100 - neuralNetwork.getTrainer().getLossFunction().getTotalLoss()) + "%");
	}

	/**
	 * Returns a Neural Network.
	 * 
	 * @return the Neural Network
	 */
	private static NeuralNetwork getNeuralNetwork() {
		// Neuron configurations
		final NeuronConfiguration inputNeuronConfiguration = new NeuronConfiguration()
				.setNeuronType(NeuronType.INPUT);

		final NeuronConfiguration hiddenNeuronConfiguration = new NeuronConfiguration()
				.setNeuronType(NeuronType.HIDDEN)
				.setInputFunctionType(InputFunctionType.WEIGHTED_SUM)
				.setActivationFunctionType(ActivationFunctionType.SIGMOID);

		final NeuronConfiguration outputNeuronConfiguration = new NeuronConfiguration()
				.setNeuronType(NeuronType.OUTPUT)
				.setInputFunctionType(InputFunctionType.WEIGHTED_SUM)
				.setActivationFunctionType(ActivationFunctionType.BINARY_STEP);

		// Layer configurations 
		final LayerConfiguration inputLayerConfiguration = new LayerConfiguration()
				.setNeuronConfiguration(inputNeuronConfiguration).setNeuronCount(4)
				.setHasHasBiasNeuron(true);

		final LayerConfiguration hidden1LayerConfiguration = new LayerConfiguration()
				.setNeuronConfiguration(hiddenNeuronConfiguration).setNeuronCount(8)
				.setHasHasBiasNeuron(true);

		final LayerConfiguration outputLayerConfiguration = new LayerConfiguration()
				.setNeuronConfiguration(outputNeuronConfiguration).setNeuronCount(3)
				.setHasHasBiasNeuron(false);

		// Hidden layers configuration
		final List<LayerConfiguration> hiddenLayersConfiguration = new ArrayList<LayerConfiguration>();
		hiddenLayersConfiguration.add(hidden1LayerConfiguration);

		// Trainer configuration
		final TrainerConfiguration trainerConfiguration = new TrainerConfiguration()
				.setTrainingStrategy(new BackPropagation())
				.setLossFunction(new MeanSquaredError()).setEta(0.1)
				.addStopCriteria(new EpochLimitStop(100000))
				.addStopCriteria(new MinLossStop(0.001));

		final Trainer trainer = new IterativeTrainer(trainerConfiguration);

		// Neural Nework configuration
		final NeuralNetworkConfiguration neuralNetworkConfiguration = new NeuralNetworkConfiguration()
				.setInputLayerConfiguration(inputLayerConfiguration)
				.setHiddenLayersConfiguration(hiddenLayersConfiguration)
				.setOutputLayerConfiguration(outputLayerConfiguration).setTrainer(trainer);

		final NeuralNetwork result = new NeuralNetworkImpl(neuralNetworkConfiguration);

		return result;
	}

}
