package sqlserver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ConnectSQLServer {

	public static void main(String[] args) throws IOException {
		// Create a variable for the connection string.

		String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=FinallyCorpus;user=sa;password=123";// sa身份连接

		// Declare the JDBC objects.
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ResultSet rss = null;
		ArrayList classList = new ArrayList();
		BufferedWriter bufw = null;
		File file = null;

		try {
			// Establish the connection.
			System.out.println("begin.");
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(url);

			// Create and execute an SQL statement that returns some data.
			String sql_classes = "SELECT distinct Categorization  FROM [NewsTrainingCorpus]";
			stmt = con.createStatement();

			// 得到所有类别
			rs = stmt.executeQuery(sql_classes);
			while (rs.next()) {
				classList.add(rs.getString(1));
			}
			rs = null;
			System.out.println("classList长度是：" + classList.size());
			// 把每一类的数据存到本地
			for (int i = 0; i < classList.size(); i++) {
				System.out.println("***********************");
				String cla = ((String) classList.get(i)).trim();
				String sql_singleclass = "SELECT * FROM [NewsTrainingCorpus] where Categorization = '" + cla + "'";
				System.out.println(sql_singleclass);

				rss = stmt.executeQuery(sql_singleclass);
				System.out.println("正在处理：" + cla);
				// 写入文件
				while (rss.next()) {
					file = new File("D:/NLPIR/paper/files/trainnum/" + cla + "/"
							+ rss.getString(1).replaceAll("[:：/\\?*\"|<>]", " ") + ".txt");
					bufw = new BufferedWriter(new FileWriter(file));

					bufw.write(rss.getString(3));
					bufw.flush();
					bufw.close();
				}

			}
			System.out.println("end");
		}
		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}
	}

}
