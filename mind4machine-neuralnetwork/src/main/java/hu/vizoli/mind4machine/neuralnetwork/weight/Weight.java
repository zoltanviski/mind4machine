package hu.vizoli.mind4machine.neuralnetwork.weight;

import java.io.Serializable;

/**
 * Weight of the Neuron.
 * 
 * @author Zoltan Viski (vizoli)
 */
public class Weight implements Serializable {

	/**
	 * Serial id.
	 */
	private static final long serialVersionUID = 6L;

	/**
	 * The value of the Weight.
	 */
	private double value;

	/**
	 * The new Weight value which calculated by the Trainer.
	 */
	private double tunedWeight;

	/**
	 * Constructor.
	 */
	public Weight() {
		value = Math.random() - 0.5d;
	}

	/**
	 * Returns the value.
	 * 
	 * @return the value
	 */
	public double getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 * 
	 * @param value the value
	 */
	public void setValue(final double value) {
		this.value = value;
	}

	/**
	 * Returns the tuned Weight.
	 * 
	 * @return the tunedWeight.
	 */
	public double getTunedWeight() {
		return tunedWeight;
	}

	/**
	 * Sets the tunedWeight.
	 * 
	 * @param tunedWeight the value.
	 */
	public void setTunedWeight(final double tunedWeight) {
		this.tunedWeight = tunedWeight;
	}
}
