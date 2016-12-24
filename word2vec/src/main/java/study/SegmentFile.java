package study;

import java.math.BigDecimal;

import com.sun.jna.Native;

public class SegmentFile {
	public static void main(String[] args) throws Exception {
		// 初始化
		CLibrary instance = (CLibrary) Native.loadLibrary(System.getProperty("user.dir") + "\\source\\NLPIR",
				CLibrary.class);
		int init_flag = instance.NLPIR_Init("", 1, "0");
		String resultString = null;
		if (0 == init_flag) {
			resultString = instance.NLPIR_GetLastErrorMsg();
			System.err.println("初始化失败！\n" + resultString);
			return;
		}

		//以上部分的内容不用管
		String sInput = "曾经有一份真挚的感情摆在我的面前我没有珍惜，等我失去的时候才追悔莫及，人间最痛苦的事莫过于此，你的剑在我的咽喉上刺下去吧，不用在犹豫了！如果上天能给我一次再来一次的机会，我会对哪个女孩说三个字：我爱你，如果非要在这份爱上加一个期限，我希望是一万年！";

		try {
			resultString = instance.NLPIR_ParagraphProcess(sInput, 0);
			System.out.println("分词结果为：\n " + resultString);

			instance.NLPIR_AddUserWord("金刚圈");
//			instance.NLPIR_AddUserWord("曾经有一份");
			resultString = instance.NLPIR_ParagraphProcess(sInput, 0);
			System.out.println("增加用户词典后分词结果为：\n" + resultString);

//			instance.NLPIR_DelUsrWord("曾经有一份");
			instance.NLPIR_DelUsrWord("有一份");
			resultString = instance.NLPIR_ParagraphProcess(sInput, 0);
			System.out.println("删除用户词典后分词结果为：\n" + resultString);

			instance.NLPIR_ImportUserDict(System.getProperty("user.dir") + "/source/userdic.txt");
			resultString = instance.NLPIR_ParagraphProcess(sInput, 0);
			System.out.println("导入用户词典文件后分词结果为：\n" + resultString);

			resultString = instance.NLPIR_GetKeyWords(sInput, 10, false);
			System.out.println("从段落中提取的关键词：\n" + resultString);

			resultString = instance.NLPIR_GetNewWords(sInput, 10, false);
			System.out.println("新词提取结果为：\n" + resultString);

//			Double d = instance.NLPIR_FileProcess("D:/NLPIR/paper/files/bigfile/bigfile.txt", "D:/NLPIR/paper/files/bigfile/bigfileSegment.txt", 0);
//
//			System.out.println("对文件内容进行分词的运行速度为： ");
//			if (d.isInfinite())
//				System.out.println("无结果");
//			else {
//				BigDecimal b = new BigDecimal(d);
//				System.out.println(b.divide(new BigDecimal(1000), 2, BigDecimal.ROUND_HALF_UP) + "秒");
//			}
//			resultString = instance.NLPIR_GetFileKeyWords("source/3.txt", 10, false);
//			System.out.println("从3.txt文件中提取关键词的结果为：\n" + resultString);

			instance.NLPIR_Exit();

		} catch (Exception e) {
			System.out.println("错误信息：");
			e.printStackTrace();
		}

	}
}
