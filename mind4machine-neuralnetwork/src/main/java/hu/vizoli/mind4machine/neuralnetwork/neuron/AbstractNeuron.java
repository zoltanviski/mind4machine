package hu.vizoli.mind4machine.neuralnetwork.neuron;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import hu.vizoli.mind4machine.neuralnetwork.activationfunction.ActivationFunction;
import hu.vizoli.mind4machine.neuralnetwork.connection.Connection;
import hu.vizoli.mind4machine.neuralnetwork.inputfunction.InputFunction;
import hu.vizoli.mind4machine.neuralnetwork.neuron.configuration.NeuronConfiguration;

/**
 * Abstract class for all of the Neuron's implementations.
 * 
 * @author Zoltan Viski (vizoli)
 */
public class AbstractNeuron implements Serializable {

	/**
	 * Serial id.
	 */
	private static final long serialVersionUID = 5L;

	/**
	 * List of the input Connections of the Neuron.
	 */
	protected final List<Connection> inputConnections;

	/**
	 * List of the output Connections of the Neuron.
	 */
	protected List<Connection> outputConnections;

	/**
	 * The Neuron's configuration.
	 */
	protected NeuronConfiguration neuronConfiguration;

	/**
	 * The Activation function of the Neuron.
	 */
	protected ActivationFunction activationFunction;

	/**
	 * The Input function of the Neuron.
	 */
	protected InputFunction inputFunction;

	/**
	 * The Neuron's output value.
	 * This value is calculated by the Activation function.
	 */
	protected double outputValue = 0.0;

	/**
	 * The Neuron's total input values.
	 * This value is calculated by the Input function.
	 */
	protected double totalInputValue = 0.0;

	/**
	 * The error of the Neuron.
	 * Trainer of the Neural Network uses this value
	 * for calculating the better Weight of the Neuron.
	 */
	protected double error = 0.0;

	/**
	 * The Id of the Neuron.
	 */
	protected String id;

	/**
	 * Constructor.
	 */
	public AbstractNeuron() {
		inputConnections = new ArrayList<Connection>();
		outputConnections = new ArrayList<Connection>();
	}

	/**
	 * Constructor.
	 * 
	 * @param neuronConfiguration the Neuron's configuration
	 */
	public AbstractNeuron(final NeuronConfiguration neuronConfiguration) {
		inputConnections = new ArrayList<Connection>();
		outputConnections = new ArrayList<Connection>();
	}

	/**
	 * Returns the Neuron's configuration.
	 * 
	 * @return the configuration
	 */
	public NeuronConfiguration getNeuronConfiguration() {
		return neuronConfiguration;
	}

	/**
	 * Calculates the input and the output values.
	 * The Neural Network uses it for prediction and the Trainer
	 * uses it for train the Neural Network.
	 */
	public void forward() {
		totalInputValue = inputFunction.getOutput(inputConnections);
		outputValue = activationFunction.getOutput(totalInputValue);
	}

	/**
	 * Sets the error.
	 * 
	 * @param error the value
	 */
	public void setError(final double error) {
		this.error = error;
	}

	/**
	 * Sets the Neuron's configuration.
	 * 
	 * @param neuronConfiguration the value
	 */
	public void setNeuronConfiguration(final NeuronConfiguration neuronConfiguration) {
		this.neuronConfiguration = neuronConfiguration;
	}

	/**
	 * Returns the list of the input Connections.
	 * 
	 * @return the list
	 */
	public List<Connection> getInputConnections() {
		return inputConnections;
	}

	/**
	 * Returns the Activation function.
	 * 
	 * @return the activation function
	 */
	public ActivationFunction getActivationFunction() {
		return activationFunction;
	}

	/**
	 * Sets the Activation function.
	 * 
	 * @param activationFunction the value
	 */
	public void setActivationFunction(final ActivationFunction activationFunction) {
		this.activationFunction = activationFunction;
	}

	/**
	 * Returns the Input function.
	 * 
	 * @return the input function
	 */
	public InputFunction getInputFunction() {
		return inputFunction;
	}

	/**
	 * Sets the Input function.
	 * 
	 * @param inputFunction the value
	 */
	public void setInputFunction(final InputFunction inputFunction) {
		this.inputFunction = inputFunction;
	}

	/**
	 * Returns the output value of the Neuron.
	 * 
	 * @return the value
	 */
	public double getOutputValue() {
		return outputValue;
	}

	/**
	 * Sets the output value of the Neuron.
	 * 
	 * @param outputValue the value
	 */
	public void setOutputValue(final double outputValue) {
		this.outputValue = outputValue;
	}

	/**
	 * Returns the total input value of the Neuron.
	 * 
	 * @return the value
	 */
	public double getTotalInputValue() {
		return totalInputValue;
	}

	/**
	 * Sets the total input value of the Neuron.
	 * 
	 * @param totalInputValue the value
	 */
	public void setTotalInputValue(final double totalInputValue) {
		this.totalInputValue = totalInputValue;
	}

	/**
	 * Returns the error.
	 * 
	 * @return the value
	 */
	public double getError() {
		return error;
	}

	/**
	 * Returns the list of the output Connections of the Neuron.
	 * 
	 * @return the list
	 */
	public List<Connection> getOutputConnections() {
		return outputConnections;
	}

	/**
	 * Adds output Connection.
	 * 
	 * @param connection the output connection
	 */
	public void addOutputConnection(final Connection connection) {
		outputConnections.add(connection);
	}

	/**
	 * Adds input Connection.
	 * 
	 * @param connection the input connection
	 */
	public void addInputConnection(final Connection connection) {
		inputConnections.add(connection);
	}

	/**
	 * Returns the id.
	 * 
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id the value
	 */
	public void setId(final String id) {
		this.id = id;
	}
}
