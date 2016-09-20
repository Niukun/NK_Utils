package com.niukun.neo4j;

import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;

public class Test {

	public static void main(String[] args) {
		Driver driver = GraphDatabase.driver("bolt://localhost", AuthTokens.basic("neo4j", "123"));
		Session session = driver.session();
//		session.run("CREATE (a:Person {name:'Arthur', title:'King'})");
		StatementResult result = session
				.run("MATCH (a:Person) WHERE a.name = 'Arthur' RETURN a.name AS name, a.title AS title");
//		System.out.println(result.list());
		System.out.println(result.hasNext());
//		System.out.println(result.next());
		while (result.hasNext()) {
			Record record = result.next();
			System.out.println(record.get("title").asString() + " " + record.get("name"));
		}
		session.close();
		driver.close();

	}

}
