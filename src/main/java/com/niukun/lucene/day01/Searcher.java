package com.niukun.lucene.day01;

import java.nio.file.Paths;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class Searcher {
	public static void search(String indexDir,String q) throws Exception {
		Directory dir = FSDirectory.open(Paths.get(indexDir));
		IndexReader reader = DirectoryReader.open(dir);
		IndexSearcher is = new IndexSearcher(reader);
		Analyzer anlyzer = new StandardAnalyzer();
		QueryParser parser = new QueryParser("contents",anlyzer);
		Query query = parser.parse(q);
		long start = System.currentTimeMillis();
		TopDocs hits = is.search(query, 60);
		long time = System.currentTimeMillis() - start;
		System.out.println("Time spending " + time + "ms. And numberis :"+hits.totalHits);
		for(ScoreDoc scoreDoc : hits.scoreDocs) {
			Document  doc = is.doc(scoreDoc.doc);
			System.out.println(doc.get("fullPath"));
		}
		reader.close();
	}
	
	public static void main(String[] args) throws Exception {
		String indexDir = "D:\\lucene";
		String q = "niukun";
		search(indexDir, q);
		
		
	}

}
