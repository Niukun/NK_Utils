package paper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilterAddress {

	public static void main(String[] args) {
		try {
			addressSorted();
			System.out.println("End...");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception...");
		}
	}

	private static void addressSorted() throws IOException {
		BufferedReader bufr = new BufferedReader(new FileReader("D:/NLPIR/paper/address.txt"));
		BufferedWriter bufwf = new BufferedWriter(new FileWriter("D:/NLPIR/paper/address_patter_f.txt"));
		BufferedWriter bufwt = new BufferedWriter(new FileWriter("D:/NLPIR/paper/address_patter_t.txt"));
		Set<String> addressSet = new TreeSet<String>();
		String line = null;
		int maxLineLength = 1;
		while ((line = bufr.readLine()) != null) {
			Pattern pattern = Pattern.compile(".*[路街道村].*[号支弄].*");
			Matcher matcher = pattern.matcher(line);
			if (matcher.find()) {
				if (line != null) {
					if (line.length() > maxLineLength) {
						maxLineLength = line.length();
					}
				}
				addressSet.add(line);
				// bufwt.write(line);
				// bufwt.newLine();
				// bufwt.flush();
			} else {
				bufwf.write(line);
				bufwf.newLine();
				bufwf.flush();
			}
		}
		for (int i = 10; i < maxLineLength; i++) {

			Iterator<String> iter = addressSet.iterator();
			while (iter.hasNext()) {
				line = iter.next();
				if (line.length() == i) {
					bufwt.write(line);
					bufwt.newLine();
					bufwt.flush();
				}
			}
		}
		if (bufwt != null) {
			bufwt.close();
		}
		if (bufwf != null) {
			bufwf.close();
		}
		if (bufr != null) {
			bufr.close();
		}
		System.out.println("maxLineLength is: " + maxLineLength);
	}
}
