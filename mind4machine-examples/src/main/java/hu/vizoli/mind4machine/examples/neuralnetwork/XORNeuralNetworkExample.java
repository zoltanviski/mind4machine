package hu.vizoli.mind4machine.examples.neuralnetwork;

import java.util.ArrayList;
import java.util.List;

import hu.vizoli.mind4machine.examples.neuralnetwork.data.DataForXORNeuralNetworkSample;
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
import hu.vizoli.mind4machine.neuralnetwork.trainer.event.TrainerEvent;
import hu.vizoli.mind4machine.neuralnetwork.trainer.event.TrainerObserver;
import hu.vizoli.mind4machine.neuralnetwork.trainingstrategy.BackPropagation;

public class XORNeuralNetworkExample implements TrainerObserver {

	private NeuralNetwork neuralNetwork;

	/**
	 * Main.
	 * 
	 * @param args
	 */
	public static void main(final String[] args) {
		final XORNeuralNetworkExample xorNeuralNetworkExample = new XORNeuralNetworkExample();
		xorNeuralNetworkExample.main();
	}

	/**
	 * Main.
	 */
	private void main() {
		neuralNetwork = getNeuralNetwork();

		final DataSet dataSet = new DataSet(DataForXORNeuralNetworkSample.getTrainingInput(),
				DataForXORNeuralNetworkSample.getTrainingIdealOutput());

		neuralNetwork.train(dataSet);
	}

	/**
	 * Returns a Neural Network.
	 * 
	 * @return the Neural Network
	 */
	private NeuralNetwork getNeuralNetwork() {
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
				.setActivationFunctionType(ActivationFunctionType.LINEAR);

		// Layer configurations
		final LayerConfiguration inputLayerConfiguration = new LayerConfiguration()
				.setNeuronConfiguration(inputNeuronConfiguration)
				.setNeuronCount(2)
				.setHasHasBiasNeuron(true);

		final LayerConfiguration hiddenLayerConfiguration = new LayerConfiguration()
				.setNeuronConfiguration(hiddenNeuronConfiguration)
				.setNeuronCount(4)
				.setHasHasBiasNeuron(true);

		final LayerConfiguration outputLayerConfiguration = new LayerConfiguration()
				.setNeuronConfiguration(outputNeuronConfiguration)
				.setNeuronCount(1)
				.setHasHasBiasNeuron(false);

		// Hidden layers configuration
		final List<LayerConfiguration> hiddenLayersConfiguration = new ArrayList<>();
		hiddenLayersConfiguration.add(hiddenLayerConfiguration);

		// Trainer configuration
		final TrainerConfiguration trainerConfiguration = new TrainerConfiguration()
				.setEta(0.1)
				.setTrainingStrategy(new BackPropagation())
				.setLossFunction(new MeanSquaredError())
				.addStopCriteria(new EpochLimitStop(100000))
				.addStopCriteria(new MinLossStop(0.001));

		final Trainer trainer = new IterativeTrainer(trainerConfiguration);
		trainer.subscribe(TrainerEvent.Type.EPOCH_FINISHED, this);
		trainer.subscribe(TrainerEvent.Type.TRAINING_FINISHED, this);

		// Neural Nework configuration
		final NeuralNetworkConfiguration neuralNetworkConfiguration = new NeuralNetworkConfiguration()
				.setInputLayerConfiguration(inputLayerConfiguration)
				.setHiddenLayersConfiguration(hiddenLayersConfiguration)
				.setOutputLayerConfiguration(outputLayerConfiguration)
				.setTrainer(trainer);

		final NeuralNetwork result = new NeuralNetworkImpl(neuralNetworkConfiguration);

		return result;
	}

	@Override
	public void handleTrainerEvent(final TrainerEvent.Type trainerEventType) {
		switch (trainerEventType) {
		case EPOCH_FINISHED:
			epochFinishedHandler();

			break;

		case TRAINING_FINISHED:
			trainingFinishedHandler();

			break;

		default:
			break;
		}
	}

	/**
	 * Handle the EPOCH_FINISHED event.
	 */
	private void epochFinishedHandler() {
		final int currentEpoch = neuralNetwork.getTrainer().getCurrentEpochCount();
		if (currentEpoch % 100 == 0) {
			System.out.println(
					"Epoch #" + currentEpoch + " Loss: " + neuralNetwork.getTrainer().getLossFunction().getTotalLoss());
		}
	}

	/**
	 * Handle the TRAINING_FINISHED event.
	 */
	private void trainingFinishedHandler() {
		System.out.println("----------------------------------------------");
		System.out.println(neuralNetwork.getPrediction(DataForXORNeuralNetworkSample.getInput())[0]);
	}

}
