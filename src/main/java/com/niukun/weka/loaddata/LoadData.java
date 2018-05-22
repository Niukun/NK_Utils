package com.niukun.weka.loaddata;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import weka.core.Attribute;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.Utils;
import weka.core.converters.ConverterUtils.DataSink;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.unsupervised.attribute.Remove;

public class LoadData {
	private final String filePath = "E:\\Data\\weka\\load";
	private final String srcFilePath = "C:\\\\Weka-3-7\\\\data\\\\";
	Instances instants = null;

	@Before
	public void before() throws Exception {
		instants = DataSource.read(srcFilePath + "weather.nominal.arff");
	}

	@Test
	public void load01() throws Exception {
		for (Instance instant : instants) {
			int nums = instant.numAttributes();
			for (int i = 0; i < nums; i++) {
				Attribute a = instant.attribute(i);
				System.out.print(a + "\t");
			}
		}
		System.out.println(instants.classIndex());
		DataSink.write("D:/a.csv", instants);
	}

	/**
	 * 选项处理
	 * 
	 * @throws Exception
	 */
	@Test
	public void load02() throws Exception {
		String[] options = Utils.splitOptions("-R 1");
		Remove rm = new Remove();
		rm.setOptions(options);
		System.out.println(options);
	}

	/**
	 * 内存数据集处理
	 */
	@Test
	public void load03() {
		// 数值型
		Attribute numeric = new Attribute("attribute_numeric");
		// 日期型
		Attribute date = new Attribute("attribute_date", "yyyy-MM-dd");
		// 标称型
		ArrayList<String> labels = new ArrayList<String>();
		labels.add("label_a");
		labels.add("label_b");
		labels.add("label_c");
		labels.add("label_d");
		Attribute nominal = new Attribute("attribute_nominal", labels);
		// 字符串型
		Attribute string = new Attribute("attribute_string", (ArrayList<String>) null);
		// 关系型
		Attribute num1 = new Attribute("attribute_num1");
		Attribute num2 = new Attribute("attribute_num2");
		
		ArrayList<String> label = new ArrayList<String>();
		label.add("yes");
		label.add("no");
		Attribute cls = new Attribute("class", label);
		
		ArrayList<Attribute> attributes = new ArrayList<Attribute>();
		attributes.add(num1);
		attributes.add(num2);
		attributes.add(cls);
		
		Instances dataset = new Instances("relation_name", attributes, 0);
		int i = dataset.numAttributes();
		System.out.println(i);
	}

	/**
	 * 在内存中创建数据集
	 */
	@Test
	public void load04() {
		ArrayList<Attribute> atts;
		ArrayList<Attribute> attsRel;
		ArrayList<String> attVals;
		ArrayList<String> attValsRel;
		Instances data;
		Instances dataRel;
		double[] vals;
		double[] valsRel;
		int i;
		//1.设置属性
		atts =new ArrayList<Attribute>();
		//-数值型
		atts.add(new Attribute("att1"));
		//-标称型
		attVals = new ArrayList<String>();
		for(int a = 0;a<5;a++) {
			attVals.add("val" + (a+1));
			atts.add(new Attribute("att2",attVals));
		}
		//-字符型
		atts.add(new Attribute("att3",(ArrayList<String>)null));
		//-日期型
		atts.add(new Attribute("att4","yyyy-MM-dd"));
		//-关系型
		attsRel = new ArrayList<Attribute>();
		//----数值型
		attsRel.add(new Attribute("att5.1"));
		//----标称型
		attValsRel = new ArrayList<String>();
		for(int b =0;b<5;b++) {
			attValsRel.add("atts5." + (b+1));
		}
		attsRel.add(new Attribute("att5.2",attValsRel));
		dataRel = new Instances("att5",attsRel,0);

		atts.add(new Attribute("att5",dataRel));
		//2.创建Instance对象
		data = new Instances("MyRelation",atts,0);
		//3.添加数据
		//第一个实例
		
		//第二个实例
		
		//4.输出数据
		
		
		
		
	}

	@Test
	public void load05() {
	}

	@Test
	public void load06() {
	}

	@Test
	public void load07() {
	}

	@Test
	public void load08() {
	}

}
