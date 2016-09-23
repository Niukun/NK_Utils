package com.niukun.neuroph;

import org.neuroph.core.NeuralNetwork;

public class AndNeuroph {

	public static void main(String[] args) {
		// create new perceptron network
		NeuralNetwork neuralNetwork = NeuralNetwork.load("pro01.nnet");
		// calculate network
		double[][] data = new double[][]{{1,1},{0,1},{1,1},{0,1},{1,1},{0,1},{1,1},{0,1},{1,1},{0,1},{1,1},{0,1}};
		for (double[] d:data) {
			neuralNetwork.setInput(d);
			neuralNetwork.calculate();
			double[] networkOutput = neuralNetwork.getOutput();
			System.out.println(networkOutput[0]);
		}
			
	}

}
