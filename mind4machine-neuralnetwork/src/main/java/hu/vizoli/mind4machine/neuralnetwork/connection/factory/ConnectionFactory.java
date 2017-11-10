package hu.vizoli.mind4machine.neuralnetwork.connection.factory;

import hu.vizoli.mind4machine.neuralnetwork.connection.Connection;
import hu.vizoli.mind4machine.neuralnetwork.connection.configuration.ConnectionConfiguration;
import hu.vizoli.mind4machine.neuralnetwork.layer.Layer;
import hu.vizoli.mind4machine.neuralnetwork.neuron.AbstractNeuron;
import hu.vizoli.mind4machine.neuralnetwork.weight.Weight;

/**
 * Factory for the Connections.
 * 
 * @author Zoltan Viski (vizoli)
 */
public class ConnectionFactory {

	/**
	 * Returns a Connection based on the given configuration.
	 * 
	 * @param connectionConfiguration the configuration of the Connection
	 * @return the connection
	 */
	public static Connection getConnection(final ConnectionConfiguration connectionConfiguration) {
		final Connection connection = new Connection(connectionConfiguration);

		return connection;
	}

	/**
	 * Creates full connection topology between the two given Layers.
	 * 
	 * @param fromLayer the input Layer of the Connections
	 * @param toLayer the target Layer of the Connections
	 */
	public static void fullConnect(final Layer fromLayer, final Layer toLayer) {
		for (final AbstractNeuron fromNeuron : fromLayer.getNeurons()) {
			for (final AbstractNeuron toNeuron : toLayer.getNeurons()) {
				final ConnectionConfiguration connectionConfiguration = new ConnectionConfiguration();
				connectionConfiguration.setFromNeuron(fromNeuron);
				connectionConfiguration.setToNeuron(toNeuron);
				connectionConfiguration.setWeight(new Weight());

				final Connection connection = getConnection(connectionConfiguration);

				fromNeuron.addOutputConnection(connection);
				toNeuron.addInputConnection(connection);
			}
		}
	}
}
