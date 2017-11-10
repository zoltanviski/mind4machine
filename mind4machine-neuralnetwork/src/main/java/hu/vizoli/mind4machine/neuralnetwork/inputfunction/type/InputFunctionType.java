package hu.vizoli.mind4machine.neuralnetwork.inputfunction.type;

import hu.vizoli.mind4machine.neuralnetwork.inputfunction.InputFunction;
import hu.vizoli.mind4machine.neuralnetwork.inputfunction.impl.WeightedSumInputFunction;

/**
 * Contains Input function types.
 * 
 * @author Zoltan Viski (vizoli)
 */
public enum InputFunctionType {
	WEIGHTED_SUM;

	/**
	 * Returns the corresponding Class to the given Type.
	 * 
	 * @return the class
	 */
	public Class<? extends InputFunction> getTypeClass() {
		switch (this) {
		case WEIGHTED_SUM:
			return WeightedSumInputFunction.class;
		}

		return null;
	}
}
