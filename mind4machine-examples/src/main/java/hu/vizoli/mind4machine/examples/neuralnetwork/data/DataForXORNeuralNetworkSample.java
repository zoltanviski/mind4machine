package hu.vizoli.mind4machine.examples.neuralnetwork.data;

public class DataForXORNeuralNetworkSample {

	public static double[][] getTrainingInput() {
		final double[][] result = { { 1, 0 }, { 0, 1 }, { 1, 1 }, { 0, 0 } };

		return result;
	}

	public static double[] getTrainingIdealOutput() {
		final double[] result = { 1, 1, 0, 0 };

		return result;
	}

	public static double[] getInput() {
		final double[] result = { 0, 1 };

		return result;
	}
}
