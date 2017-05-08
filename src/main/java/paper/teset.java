package paper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class teset {

	public static void main(String[] args) {

		try {
			BufferedReader bufr = new BufferedReader(new FileReader(new File("nasdf.txt")));
		} catch (FileNotFoundException e1) {
			System.out.println(e1.getMessage());
		}
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		try {
			for (int i = 0; i < list.size() + 2; i++) {
				System.out.println(list.get(i));
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("ending .. . . ");
	}
}
