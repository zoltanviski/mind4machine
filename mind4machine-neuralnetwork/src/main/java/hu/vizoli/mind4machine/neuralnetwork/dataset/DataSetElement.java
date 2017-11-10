package hu.vizoli.mind4machine.neuralnetwork.dataset;

import java.io.Serializable;

public class DataSetElement implements Serializable {

	/**
	 * Serial id.
	 */
	private static final long serialVersionUID = 18L;

	private final double[] inputs;
	private final double[] idealOutputs;

	public DataSetElement(final double[] input, final double[] idealOutput) {
		this.inputs = input;
		this.idealOutputs = idealOutput;
	}

	public DataSetElement(final double[] input, final double idealOutput) {
		this.inputs = input;

		this.idealOutputs = new double[1];
		idealOutputs[0] = idealOutput;
	}

	public double[] getInput() {
		return inputs;
	}

	public double[] getIdealOutput() {
		return idealOutputs;
	}

	@Override
	public String toString() {
		final StringBuilder result = new StringBuilder();

		result.append("Inputs: ");
		for (final double input : inputs) {
			result.append(input + ", ");
		}

		result.append(System.getProperty("line.separator"));
		result.append("IdealOutputs: ");
		for (final double output : idealOutputs) {
			result.append(output + ", ");
		}

		return result.toString();
	}
}
