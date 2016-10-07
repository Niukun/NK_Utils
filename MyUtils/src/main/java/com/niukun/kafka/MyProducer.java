package com.niukun.kafka;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

public class MyProducer {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		Properties props = new Properties();
		props.put("bootstrap.servers", "192.168.1.12:9092");//172.21.219.0 //59.78.100.126
		props.put("acks", "all");
		// props.put("group.id", "final_test");
		props.put("retries", 0);
		props.put("batch.size", 16384);
		props.put("linger.ms", 1);
		props.put("buffer.memory", 33554432);
		props.put("request.timeout.ms", 30000);
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		Producer<String, String> producer = new KafkaProducer<String, String>(props);
		BufferedReader bufr = new BufferedReader(new FileReader("fmproject.json"));
		String line = "";
		int i = 1;
		while ((line = bufr.readLine()) != null) {
			producer.send(new ProducerRecord<String, String>("erp", Integer.toString(i++), line),
					new Callback() {
						public void onCompletion(RecordMetadata metadata, Exception e) {
							if (e != null)
								e.printStackTrace();
							System.out.println("The offset of the record just sent is: " + metadata.offset());
						}
					});
		}
		System.out.println(props.toString());
		producer.close();
	}
}
