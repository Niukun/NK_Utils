package com.niukun.csv;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * 此类中所有方法均为静态方法
 * 
 * @author Niukun
 * 
 */
public class testCsv {
	// just for test
	public static void main(String[] args) throws IOException {
		// ReadAndWriteCSV("E:/12.csv");
		CSVToxlsFull("E:/123.csv", "E:/123.xls");
	}

	/**
	 * 此方法是读取csv文件并且把结果输出到txt文件中
	 * 
	 * @throws IOException
	 */
	public static List<String> ReadAndWriteCSV(String filepath) throws IOException {
		FileInputStream fis = new FileInputStream(filepath);
		FileOutputStream fos = new FileOutputStream("E:/123_copy.txt");

		InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
		OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");

		BufferedReader br = new BufferedReader(isr);
		PrintWriter pw = new PrintWriter(osw);

		String input;
		int i = 0;
		long start = System.currentTimeMillis();
		input = br.readLine();
		pw.println(input);

		List<String> list = new ArrayList<String>();
		String str = null;
		while ((input = br.readLine()) != null) {
			i++;
			str = input.trim();
			// System.out.println(str);
			list.add(str);
			pw.println(list.get(i - 1).toCharArray());
			// System.out.println(i+":"+list.get(i-1).toString());
			System.out.println(i);
		}
		System.out.println("总计用时：" + (float) (System.currentTimeMillis() - start) / 1000 + "s");
		System.out.println("list长度为" + ":" + list.size());
		pw.close();
		br.close();
		osw.close();
		isr.close();
		fos.close();
		fis.close();
		return list;
	}

	/**
	 * 简单的表格创建，从POI中复制过来
	 * 
	 * @throws IOException
	 */
	public static void createExcel() throws IOException {
		@SuppressWarnings("resource")
		Workbook wb = new HSSFWorkbook();
		Sheet sheet1 = (Sheet) wb.createSheet("niukun");

		Row row = sheet1.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue("Niukun's Excel!!!");
		row.createCell(1).setCellValue("Two!");
		row.createCell(2).setCellValue("This is a kind of apple,calles i-phone.");
		row.createCell(3).setCellValue(true);

		FileOutputStream fileOut = new FileOutputStream("E:/work.xls");
		wb.write(fileOut);
		fileOut.close();
		System.out.println("All Works Finished!");
	}

	/**
	 * 完整实现csv到xls的转换，以英文“,”作为分隔符 但是因为是xls限制65536行
	 * 
	 * @param oldpath
	 * @param newpath
	 */
	public static void CSVToxls(String oldpath, String newpath) {
		try {
			FileInputStream fis = new FileInputStream(oldpath);
			FileOutputStream fos = new FileOutputStream(newpath);

			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");

			BufferedReader br = new BufferedReader(isr);
			PrintWriter pw = new PrintWriter(osw);

			@SuppressWarnings("resource")
			Workbook wb = new HSSFWorkbook();
			Sheet sheet1 = (Sheet) wb.createSheet("niukun");

			String input;
			int i = 0;
			String str = br.readLine();
			int unitlengh = str.split(",").length;
			String temp[] = new String[unitlengh];
			temp = str.split(",");

			List<String[]> list = new ArrayList<String[]>();
			String strlist[] = new String[unitlengh];

			long start = System.currentTimeMillis();
			// 先输出第一行标题
			Row row0 = sheet1.createRow(0);
			for (int j = 0; j < unitlengh; j++) {
				Cell cell = row0.createCell(j);
				cell.setCellValue(temp[j]);
			}
			// 以下是数据主体部分
			while ((input = br.readLine()) != null) {
				i++;
				str = input.trim();
				strlist = str.split(",");
				System.out.println(i + ":" + strlist.length);
				list.add(strlist);
				Row row = sheet1.createRow(i);
				for (int j = 0; j < unitlengh; j++) {
					Cell cell = row.createCell(j);
					// 为了防止最后一列为空
					if (j < strlist.length) {
						cell.setCellValue(strlist[j]);
					} else {
						cell.setCellValue("");
					}
				}
				// 此部分为xls行数限制，只能输出65535行，但是修改后的xlsx没有此项限制
				if (i == 65535) {
					wb.write(fos);
					break;
				}
			}
			wb.write(fos);
			System.out.println("总计用时：" + (float) (System.currentTimeMillis() - start) / 1000 + "s");
			System.out.println("list长度为" + ":" + list.size());
			pw.close();
			br.close();
			osw.close();
			isr.close();
			fos.close();
			fis.close();

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 完整实现csv到xls的转换，以英文“,”作为分隔符,实现分页保存，摆脱行数限制 完成：可以读入40万条数据
	 * 
	 * @param oldpath
	 * @param newpath
	 */
	public static void CSVToxlsFull(String oldpath, String newpath) {
		try {
			FileInputStream fis = new FileInputStream(oldpath);
			FileOutputStream fos = new FileOutputStream(newpath);

			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");

			BufferedReader br = new BufferedReader(isr);
			PrintWriter pw = new PrintWriter(osw);

			@SuppressWarnings("resource")
			Workbook wb = new HSSFWorkbook();
			Sheet sheet1 = (Sheet) wb.createSheet("niukun1");
			Sheet sheet2 = (Sheet) wb.createSheet("niukun2");
			Sheet sheet3 = (Sheet) wb.createSheet("niukun3");
			Sheet sheet4 = (Sheet) wb.createSheet("niukun4");
			Sheet sheet5 = (Sheet) wb.createSheet("niukun5");
			Sheet sheet6 = (Sheet) wb.createSheet("niukun6");

			String input;
			int i = 0;
			String str = br.readLine();
			int unitlengh = str.split(",").length;
			String temp[] = new String[unitlengh];
			temp = str.split(",");

			List<String[]> list = new ArrayList<String[]>();
			String strlist[] = new String[unitlengh];

			long start = System.currentTimeMillis();
			// 先输出第一行标题
			Row row1 = sheet1.createRow(0);

			for (int j = 0; j < unitlengh; j++) {
				Cell cell1 = row1.createCell(j);
				cell1.setCellValue(temp[j]);
			}
			// 以下是数据主体部分
			while ((input = br.readLine()) != null) {
				i++;
				if (i < 65536) {
					str = input.trim();
					strlist = str.split(",");
					System.out.println(i + ":" + strlist.length);
					list.add(strlist);
					Row row = sheet1.createRow(i);
					for (int j = 0; j < unitlengh; j++) {
						Cell cell = row.createCell(j);
						// 为了防止最后一列为空
						if (j < strlist.length) {
							cell.setCellValue(strlist[j]);
						} else {
							cell.setCellValue("");
						}
					}
				} else if (i < 65536 * 2) {
					str = input.trim();
					strlist = str.split(",");
					System.out.println(i + ":" + strlist.length);
					list.add(strlist);
					Row row = sheet2.createRow((i % 65536));
					for (int j = 0; j < unitlengh; j++) {
						Cell cell = row.createCell(j);
						// 为了防止最后一列为空
						if (j < strlist.length) {
							cell.setCellValue(strlist[j]);
						} else {
							cell.setCellValue("");
						}
					}
				} else if (i < 65536 * 3) {
					str = input.trim();
					strlist = str.split(",");
					System.out.println(i + ":" + strlist.length);
					list.add(strlist);
					Row row = sheet3.createRow((i % 65536));
					for (int j = 0; j < unitlengh; j++) {
						Cell cell = row.createCell(j);
						// 为了防止最后一列为空
						if (j < strlist.length) {
							cell.setCellValue(strlist[j]);
						} else {
							cell.setCellValue("");
						}
					}
				} else if (i < 65536 * 4) {
					str = input.trim();
					strlist = str.split(",");
					System.out.println(i + ":" + strlist.length);
					list.add(strlist);
					Row row = sheet4.createRow((i % 65536));
					for (int j = 0; j < unitlengh; j++) {
						Cell cell = row.createCell(j);
						// 为了防止最后一列为空
						if (j < strlist.length) {
							cell.setCellValue(strlist[j]);
						} else {
							cell.setCellValue("");
						}
					}
				} else if (i < 65536 * 5) {
					str = input.trim();
					strlist = str.split(",");
					System.out.println(i + ":" + strlist.length);
					list.add(strlist);
					Row row = sheet5.createRow((i % 65536));
					for (int j = 0; j < unitlengh; j++) {
						Cell cell = row.createCell(j);
						// 为了防止最后一列为空
						if (j < strlist.length) {
							cell.setCellValue(strlist[j]);
						} else {
							cell.setCellValue("");
						}
					}
				} else if (i < 65536 * 6) {
					str = input.trim();
					strlist = str.split(",");
					System.out.println(i + ":" + strlist.length);
					list.add(strlist);
					Row row = sheet6.createRow((i % 65536));
					for (int j = 0; j < unitlengh; j++) {
						Cell cell = row.createCell(j);
						// 为了防止最后一列为空
						if (j < strlist.length) {
							cell.setCellValue(strlist[j]);
						} else {
							cell.setCellValue("");
						}
					}
				} else {
					break;
				}
			}
			System.out.println("读取用时：" + (float) (System.currentTimeMillis() - start) / 1000 + "s");
			wb.write(fos);
			System.out.println("总计用时：" + (float) (System.currentTimeMillis() - start) / 1000 + "s");
			System.out.println("list长度为" + ":" + list.size());
			pw.close();
			br.close();
			osw.close();
			isr.close();
			fos.close();
			fis.close();

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 专门处理zybl 未完成
	 * 
	 * @param oldpath
	 * @param newpath
	 */
	public static void CSVToxlsWithStrings(String oldpath, String newpath) {
		try {
			FileInputStream fis = new FileInputStream(oldpath);
			FileOutputStream fos = new FileOutputStream(newpath);

			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");

			BufferedReader br = new BufferedReader(isr);
			PrintWriter pw = new PrintWriter(osw);

			@SuppressWarnings("resource")
			Workbook wb = new HSSFWorkbook();
			Sheet sheet1 = (Sheet) wb.createSheet("niukun");

			String input;
			int i = 0;
			String str = br.readLine();
			String temp[] = new String[5];
			temp = str.split(",");

			List<String[]> list = new ArrayList<String[]>();
			String substr = null;
			String removecode = null;

			long start = System.currentTimeMillis();
			Row row0 = sheet1.createRow(0);
			for (int j = 0; j < 5; j++) {
				Cell cell = row0.createCell(j);
				cell.setCellValue(temp[j]);
			}
			while ((input = br.readLine()) != null) {
				i++;
				System.out.println(input);
				removecode = input.replaceAll("\"", " ");
				System.out.println(i);
				list.add(input.trim().split(","));
				Row row = sheet1.createRow(i);
				for (int j = 0; j < 5; j++) {
					substr = removecode.substring(0, input.indexOf(","));
					System.out.println(substr);
					str = input.substring(input.indexOf(","));
					if (j < 4) {
						Cell cell = row.createCell(j);
						cell.setCellValue(substr);
					} else {
						Cell cell = row.createCell(j);
						cell.setCellValue(str);
					}
				}
				if (i == 65) {
					wb.write(fos);
					break;
				}
			}
			wb.write(fos);
			System.out.println("总计用时：" + (float) (System.currentTimeMillis() - start) / 1000 + "s");
			System.out.println("list长度为" + ":" + list.size());
			pw.close();
			br.close();
			osw.close();
			isr.close();
			fos.close();
			fis.close();

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
