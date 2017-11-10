package hu.vizoli.mind4machine.neuralnetwork.dataset;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * This class represents the data for the Machine Learnings.
 * It can be used as training data and for prediction purpose as well.
 * 
 * @author Zoltan Viski (vizoli)
 */
public class DataSet implements Serializable {

	/**
	 * Serial id.
	 */
	private static final long serialVersionUID = 15L;

	/**
	 * List of the elements of the DataSet.
	 */
	private final List<DataSetElement> dataSetElements;

	/**
	 * Constructor.
	 * 
	 * @param inputsCount the count of the input
	 * @param idealOutputCount the count of the output
	 */
	public DataSet(final int inputsCount, final int idealOutputCount) {
		this.dataSetElements = new ArrayList<DataSetElement>();
	}

	/**
	 * Constructor.
	 * 
	 * @param input the input array
	 * @param idealOutput the ideal output array
	 */
	public DataSet(final double[][] input, final double[] idealOutput) {
		dataSetElements = new ArrayList<DataSetElement>();

		final int n = input.length;
		for (int i = 0; i < n; i++) {
			addDataSetElement(input[i], new double[] { idealOutput[i] });
		}
	}

	/**
	 * Adds a DataSetElement to the list.
	 * 
	 * @param input the input array of the element
	 * @param idealOutput the ideal output array of the element
	 */
	public void addDataSetElement(final double[] input, final double[] idealOutput) {
		final DataSetElement dataSetElement = new DataSetElement(input, idealOutput);

		dataSetElements.add(dataSetElement);
	}

	/**
	 * Creates a DataSet from .CSV file.
	 * 
	 * @param filePath the path to a file
	 * @param inputsCount the count of the input
	 * @param outputsCount the count of the output
	 * @return the DataSet
	 */
	public static DataSet createFromCSV(final String filePath, final int inputsCount, final int outputsCount) {
		return createFromDelimitedFormat(filePath, inputsCount, outputsCount, ",");
	}

	/**
	 * Creates a DataSet from delimited file.
	 * 
	 * @param filePath the path to a file
	 * @param inputsCount the count of the input
	 * @param outputsCount the count of the output
	 * @param delimiter the delimiter of the columns
	 * @return the DataSet
	 */
	private static DataSet createFromDelimitedFormat(final String filePath, final int inputsCount,
			final int outputsCount, final String delimiter) {
		final File file = new File(filePath);

		final List<List<String>> lines = new ArrayList<List<String>>();
		Scanner inputStream;

		try {
			inputStream = new Scanner(file);

			while (inputStream.hasNext()) {
				final String line = inputStream.next();
				final String[] values = line.split(delimiter);

				lines.add(Arrays.asList(values));
			}

			inputStream.close();
		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		}

		final DataSet result = new DataSet(inputsCount, outputsCount);

		for (final List<String> line : lines) {
			final double[] input = new double[inputsCount];
			final double[] idealOutput = new double[outputsCount];

			for (int i = 0; i < inputsCount; i++) {
				input[i] = Double.parseDouble(line.get(i));
			}

			final int n = inputsCount + outputsCount;
			for (int i = inputsCount; i < n; i++) {
				idealOutput[i - inputsCount] = Double.parseDouble(line.get(i));
			}

			result.addDataSetElement(input, idealOutput);
		}

		return result;
	}

	/**
	 * Returns the size of the DataSet.
	 * 
	 * @return the size
	 */
	public int getSize() {
		return dataSetElements.size();
	}

	/**
	 * Returns a DataSetElement on the given index.
	 * 
	 * @param index the idec of the DataSetElement in the list
	 * @return the DataSetElement
	 */
	public DataSetElement getDataSetElement(final int index) {
		return dataSetElements.get(index);
	}
}
