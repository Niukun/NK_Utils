package tfidf.src.test.org.akgul.tfidf;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import tfidf.src.org.akgul.MutableInt;
import tfidf.src.org.akgul.TfIdf;

public class TfIdfTest {

  private static final double EPSILON = 1e-100;

  @Test
  public void testDocumentsListNotNull() {
    String document1 = "one two";
    String document2 = "three four";
    List<String> list = new ArrayList<String>();
    list.add(document1);
    list.add(document2);
    TfIdf tfIdf = new TfIdf(list);
    System.out.println(tfIdf.getDocuments());
    assertNotNull("list", tfIdf.getDocuments());
  }

  @Test
  public void testDocumentsListElements() {
    String document1 = "one two";
    String document2 = "three four";
    List<String> list = new ArrayList<String>();
    list.add(document1);
    list.add(document2);
    TfIdf tfIdf = new TfIdf(list);
    assertEquals(tfIdf.getDocuments().size(), 2);
  }

  @Test
  public void testTf() throws Exception {
    String document1 = "one one two four";
    String document2 = "three three one three four five five";
    List<String> list = new ArrayList<String>();
    list.add(document1);
    list.add(document2);
    TfIdf tfIdf = new TfIdf(list);
    Map<String, MutableInt> map = tfIdf.tf();
    assertNotNull(map);
    System.out.println(map.get("one").getCounter());
    assertEquals(map.get("one").getCounter(), 3);
    assertEquals(map.get("two").getCounter(), 1);
    assertEquals(map.get("three").getCounter(), 3);
    assertEquals(map.get("four").getCounter(), 2);
    assertEquals(map.get("five").getCounter(), 2);
  }
  
  @Test
  public void testTfDoc() throws Exception {
	  String document1 = "one one two three three";
	  String document2 = "three three three four five five";
	  List<String> list = new ArrayList<String>();
	  list.add(document1);
	  list.add(document2);
	  TfIdf tfIdf = new TfIdf(list);
	  Map<String, MutableInt> map = tfIdf.tf(document2);
	  assertNotNull(map);
	  System.out.println("map.get(three).getCounter()" + map.get("three").getCounter());
	  assertEquals(map.get("three").getCounter(), 3);
	  assertEquals(map.get("four").getCounter(), 1);
	  assertEquals(map.get("five").getCounter(), 2);
  }

  @Test
  public void testDf() throws Exception {
    String document1 = "one two one one one one";
    String document2 = "one four five two";
    String document3 = "four five two";
    List<String> list = new ArrayList<String>();
    list.add(document1);
    list.add(document2);
    list.add(document3);
    TfIdf tfIdf = new TfIdf(list);
    Map<String, MutableInt> map = tfIdf.df(list);
    assertNotNull(map);
    assertEquals(map.get("one").getCounter(), 2);
    assertEquals(map.get("two").getCounter(), 3);
    assertEquals(map.get("four").getCounter(),2);
  }

  @Test
  public void testIdf() throws Exception {
    String document1 = "one two one";
    String document2 = "one four five";
    String document3 = "one six seven two";
    List<String> list = new ArrayList<String>();
    list.add(document1);
    list.add(document2);
    list.add(document3);
    TfIdf tfIdf = new TfIdf(list);
    Map<String, Double> map = tfIdf.idf();
    assertNotNull(map);
    assertEquals(map.get("one"), 0.3333333333333333, EPSILON);
    assertEquals(map.get("two"), 0.5, EPSILON);
    assertEquals(map.get("four"), 1.0, EPSILON);
  }

  @Test
  public void testTfidf() throws Exception {
    String document1 = "one two one";
    String document2 = "one four five";
    String document3 = "one six seven two";
    List<String> list = new ArrayList<String>();
    list.add(document1);
    list.add(document2);
    list.add(document3);
    TfIdf tfIdf = new TfIdf(list);
    Map<String, Double> map = tfIdf.idf();
    assertNotNull(map);
    assertEquals(map.get("two"), 0.5, EPSILON);
    assertEquals(map.get("one"), 0.3333333333333333, EPSILON);
    assertEquals(map.get("four"), 1.0, EPSILON);
  }

  @Test
  public void testTfidf_tweak1() throws Exception {
    String document1 = "one two one";
    String document2 = "one four five";
    String document3 = "one six seven two";
    List<String> list = new ArrayList<String>();
    list.add(document1);
    list.add(document2);
    list.add(document3);
    TfIdf tfIdf = new TfIdf(list);
    Map<String, Double> map = tfIdf.idf();
    assertNotNull(map);
    assertEquals(map.get("one"), 0.3333333333333333, EPSILON);
    assertEquals(map.get("four"), 1.0, EPSILON);
  }
}
