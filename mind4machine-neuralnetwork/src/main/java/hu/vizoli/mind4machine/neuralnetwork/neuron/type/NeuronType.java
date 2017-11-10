package hu.vizoli.mind4machine.neuralnetwork.neuron.type;

import hu.vizoli.mind4machine.neuralnetwork.neuron.AbstractNeuron;
import hu.vizoli.mind4machine.neuralnetwork.neuron.BiasNeuron;
import hu.vizoli.mind4machine.neuralnetwork.neuron.HiddenNeuron;
import hu.vizoli.mind4machine.neuralnetwork.neuron.InputNeuron;
import hu.vizoli.mind4machine.neuralnetwork.neuron.OutputNeuron;

/**
 * Contains the possible Neuron types.
 * 
 * @author Zoltan Viski (vizoli)
 */
public enum NeuronType {
	INPUT, HIDDEN, OUTPUT, BIAS;

	/**
	 * Returns the Class corresponding to type.
	 * 
	 * @return the Class
	 */
	public Class<? extends AbstractNeuron> getTypeClass() {
		switch (this) {
		case INPUT:
			return InputNeuron.class;

		case HIDDEN:
			return HiddenNeuron.class;

		case OUTPUT:
			return OutputNeuron.class;

		case BIAS:
			return BiasNeuron.class;
		}

		return null;
	}
}
