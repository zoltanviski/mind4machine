package hu.vizoli.mind4machine.neuralnetwork.neuron.factory;

import hu.vizoli.mind4machine.neuralnetwork.activationfunction.ActivationFunction;
import hu.vizoli.mind4machine.neuralnetwork.inputfunction.InputFunction;
import hu.vizoli.mind4machine.neuralnetwork.neuron.AbstractNeuron;
import hu.vizoli.mind4machine.neuralnetwork.neuron.configuration.NeuronConfiguration;
import hu.vizoli.mind4machine.neuralnetwork.neuron.type.NeuronType;

/**
 * Factory for the Neuron related operations.
 * 
 * @author Zoltan Viski (vizoli)
 */
public class NeuronFactory {

	/**
	 * Returns a Neuron based on the given Neuron configuration.
	 * 
	 * @param neuronConfiguration the configuration
	 * @return the Neuron
	 */
	public static AbstractNeuron getNeuron(final NeuronConfiguration neuronConfiguration) {
		final AbstractNeuron result = getNeuronInstance(neuronConfiguration.getNeuronType().getTypeClass());

		if (neuronConfiguration.getInputFunctionType() != null) {
			result.setInputFunction(getInputFunction(neuronConfiguration.getInputFunctionType().getTypeClass()));
		}

		if (neuronConfiguration.getActivationFunctionType() != null) {
			result.setActivationFunction(
					getActivationFunction(neuronConfiguration.getActivationFunctionType().getTypeClass()));
		}

		return result;
	}

	/**
	 * Returns a Bias Neuron.
	 * 
	 * @return the Bias Neuron
	 */
	public static AbstractNeuron getBiasNeuron() {
		final NeuronConfiguration neuronConfiguration = new NeuronConfiguration();
		neuronConfiguration.setNeuronType(NeuronType.BIAS);

		final AbstractNeuron result = getNeuronInstance(neuronConfiguration.getNeuronType().getTypeClass());

		return result;
	}

	/**
	 * Returns a Neuron based on a given Neuron type Class.
	 * 
	 * @param neuronType the Neuron's type Class
	 * @return the Neuron
	 */
	public static AbstractNeuron getNeuronInstance(final Class<? extends AbstractNeuron> neuronType) {
		AbstractNeuron result = null;

		try {
			result = neuronType.newInstance();
		} catch (final InstantiationException e) {
			// TODO
		} catch (final IllegalAccessException e) {
			// TODO
		}

		return result;
	}

	/**
	 * Returns an Activation function based on a given Activation function Class.
	 * 
	 * @param activationFunctionClass the Activation function Class.
	 * @return the Activation function
	 */
	public static ActivationFunction getActivationFunction(
			final Class<? extends ActivationFunction> activationFunctionClass) {
		ActivationFunction result = null;

		try {
			result = activationFunctionClass.newInstance();
		} catch (final InstantiationException e) {
			// TODO
		} catch (final IllegalAccessException e) {
			// TODO
		}

		return result;
	}

	/**
	 * Returns an Input function based on a given input function Class.
	 * 
	 * @param inputFunctionClass the Activation function Class.
	 * @return the input function
	 */
	public static InputFunction getInputFunction(final Class<? extends InputFunction> inputFunctionClass) {
		InputFunction result = null;

		try {
			result = inputFunctionClass.newInstance();
		} catch (final InstantiationException e) {
			// TODO
		} catch (final IllegalAccessException e) {
			// TODO
		}

		return result;
	}

}
