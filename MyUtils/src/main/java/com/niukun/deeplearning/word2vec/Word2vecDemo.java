package com.niukun.deeplearning.word2vec;

import java.io.File;
import java.util.Collection;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.deeplearning4j.models.word2vec.Word2Vec;
import org.deeplearning4j.text.sentenceiterator.LineSentenceIterator;
import org.deeplearning4j.text.sentenceiterator.SentenceIterator;
import org.deeplearning4j.text.sentenceiterator.SentencePreProcessor;
import org.deeplearning4j.text.tokenization.tokenizer.TokenPreProcess;
import org.deeplearning4j.text.tokenization.tokenizer.preprocessor.EndingPreProcessor;
import org.deeplearning4j.text.tokenization.tokenizerfactory.DefaultTokenizerFactory;
import org.deeplearning4j.text.tokenization.tokenizerfactory.TokenizerFactory;

public class Word2vecDemo {
	private static Logger log = Logger.getLogger(Word2vecDemo.class);

	public static void main(String[] args) {
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
		log.info("Load data....");// 加载数据
		SentenceIterator iter = new LineSentenceIterator(new File("files/raw_sentences.txt"));
		iter.setPreProcessor(new SentencePreProcessor() {
			public String preProcess(String sentence) {
				return sentence.toLowerCase();
			}
		});
		log.info("Tokenize data....");// 数据分词
		final EndingPreProcessor preProcessor = new EndingPreProcessor();
		TokenizerFactory tokenizer = new DefaultTokenizerFactory();
		tokenizer.setTokenPreProcessor(new TokenPreProcess() {
			public String preProcess(String token) {
				token = token.toLowerCase();
				String base = preProcessor.preProcess(token);
				base = base.replaceAll("\\d", "d");
				if (base.endsWith("ly") || base.endsWith("ing"))
					System.out.println();
				return base;
			}
		});
		// 模型定型
		int batchSize = 1000;
        int iterations = 3;
        int layerSize = 150;
        log.info("Build model....");
        Word2Vec vec = new Word2Vec.Builder()
                .batchSize(batchSize) //# words per minibatch.
                .minWordFrequency(5) // 
                .useAdaGrad(false) //
                .layerSize(layerSize) // word feature vector size
                .iterations(iterations) // # iterations to train
                .learningRate(0.025) // 
                .minLearningRate(1e-3) // learning rate decays wrt # words. floor learning
                .negativeSample(10) // sample size 10 words
                .iterate(iter) //
                .tokenizerFactory(tokenizer)
                .build();
        vec.fit();
        
        // 用Word2vec评估模型
        log.info("Evaluate model....");
        double sim = vec.similarity("people", "money");
        log.info("Similarity between people and money:" + sim);
        Collection<String> similar = vec.wordsNearest("day", 10);
        log.info("Similar words to 'day' :" + similar);
        
	}
}
