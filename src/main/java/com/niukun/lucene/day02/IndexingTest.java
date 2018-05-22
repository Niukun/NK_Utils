package com.niukun.lucene.day02;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.nio.file.Paths;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Before;
import org.junit.Test;

public class IndexingTest {
	private String ids[] = {"1","2","3"};
	private String cities[] = {"qingdao","nanjing","shanghai"};
	private String descs[] = {
			"qingdao is a beautiful city",
			"nanjing is a history city",
			"shanghai is a money city"
	};

	
	private Directory dir;
	
	@Before
	public void setUp() throws Exception {
		dir = FSDirectory.open(Paths.get("d:\\lucene2"));
		IndexWriter writer = getWriter();
		for(int i = 0;i < ids.length;i++) {
			
		}
		
		
	}
	
	/**
	 * 获取IndexWriter实例
	 * @return
	 * @throws IOException 
	 */
	private IndexWriter getWriter() throws IOException {
		Analyzer anlyzer = new StandardAnalyzer();
		IndexWriterConfig iwc = new IndexWriterConfig(anlyzer);
		IndexWriter writer = new IndexWriter(dir,iwc);
		return writer;
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
