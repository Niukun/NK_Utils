package business.com.fzhong.service.kg.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;


public class FileOperation {

	/**
	 * 创建文件
	 * 
	 * @param fileName
	 * @return
	 */
	public boolean createFile(File fileName) throws Exception {
		boolean flag = false;
		try {
			if (!fileName.exists()) {
				fileName.createNewFile();
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * 读文件返回List<String>
	 * 
	 * @param fileName
	 * @return
	 */
	public List<String> readTxtFile(File fileName) throws Exception {
		List<String> ret = new ArrayList<String>();
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		try {
			fileReader = new FileReader(fileName);
			bufferedReader = new BufferedReader(fileReader);
			if (fileReader != null && bufferedReader != null)
				try {
					String read = null;
					while ((read = bufferedReader.readLine()) != null) {						
						ret.add(read);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bufferedReader != null) {
				bufferedReader.close();
			}
			if (fileReader != null) {
				fileReader.close();
			}
		}
		
		return ret;

	}
	
	/**
	 * 将内容写入文件
	 * 
	 * @param content
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public boolean writeTxtFile(String content, File fileName) throws Exception {
		RandomAccessFile mm = null;
		boolean flag = false;
		FileOutputStream o = null;
		try {
			o = new FileOutputStream(fileName);
			o.write(content.getBytes("UTF-8"));
			o.close();
			flag = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (mm != null) {
				mm.close();
			}
		}
		return flag;
	}

	/**
	 * 判断文件是否存在
	 * 
	 * @param f
	 * @return
	 */
	public static boolean fileExist(File f) {
		boolean ret = false;
		try {
			if (f.exists()) {
				System.out.print("文件存在");
				ret = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	/**
	 * 将内容写入文件
	 * 
	 * @param filePath
	 * @param writeType （写入类型，true则续写，反之为覆盖）
	 * @param content
	 */
	public void contentToTxt(String filePath, boolean writeType, String content) {
		try {
			File f = new File(filePath);
			if (!fileExist(f)) {
				f.createNewFile();
			} else {
				BufferedWriter output = new BufferedWriter(new FileWriter(f,
						writeType));
				output.write(content);
				output.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
