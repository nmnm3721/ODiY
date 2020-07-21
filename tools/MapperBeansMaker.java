import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * @filename : MapperBeansMaker.java
 * @description :
 * @author : 박 통 영 (zawookmist@gmail.com)
 */
public class MapperBeansMaker {

	public static void main(String[] args) {

		String tablename = JOptionPane.showInputDialog("테이블 이름을 입력하세요.");

		String colnum = JOptionPane.showInputDialog("컬럼 갯수를 입력하세요.");
		int colcount = Integer.parseInt(colnum);

		ArrayList<String> beansmaker = new ArrayList<String>();

		for (int i = 0; i < colcount; i++) {
			String cols = JOptionPane.showInputDialog("컬럼 이름을 순서대로 입력하세요 : ", i + 1);
			beansmaker.add(cols);
		}

		System.out.println("==== 텍스트 입력 완료 ====");
		System.out.println();

		// 자바빈즈와 컬럼 연결하기용 텍스트
		System.out.println("====JAVA BEANS====");
		System.out.println();

		for (int i = 0; i < beansmaker.size(); i++) {
			System.out.printf("<result property=\"%s\" column=\"%s\" />\n", beansmaker.get(i), beansmaker.get(i));
		}
		System.out.println();

		// insert용 텍스트
		System.out.println("====INSERT====");
		System.out.println();

		String insertText1 = "INSERT INTO " + tablename + " (";
		String insertText2 = ") VALUES (#{";
		String insertText3 = "});";

		for (int i = 0; i < beansmaker.size(); i++) {
			insertText1 += beansmaker.get(i);
			if (i < beansmaker.size() - 1) {
				insertText1 += ", ";
			}
		}
		for (int i = 0; i < beansmaker.size(); i++) {
			insertText2 += beansmaker.get(i);
			if (i < beansmaker.size() - 1) {
				insertText2 += "}, #{";
			}
		}
		System.out.println(insertText1 + insertText2 + insertText3);
		System.out.println();

		// delete용 텍스트
		System.out.println("====DELETE====");
		System.out.println();

		System.out
				.println("DELETE FROM " + tablename + " WHERE " + beansmaker.get(0) + "=#{" + beansmaker.get(0) + "};");
		System.out.println();

		// update용 텍스트
		System.out.println("====UPDATE====");
		System.out.println();
		
		String updateText1 = "UPDATE " + tablename + " SET ";

		for (int i = 0; i < beansmaker.size(); i++) {
			if (i < beansmaker.size() - 2) {
				updateText1 += beansmaker.get(i + 1);
				updateText1 += "=#{";
				updateText1 += beansmaker.get(i + 1);
				updateText1 += "}, ";
			} else if (i < beansmaker.size() - 1) {
				updateText1 += beansmaker.get(i + 1);
				updateText1 += "=#{";
				updateText1 += beansmaker.get(i + 1);
				updateText1 += "} WHERE ";
			}
		}
		System.out.println(updateText1 + beansmaker.get(0) + "=#{" + beansmaker.get(0) + "};");
		System.out.println();

		// selectOne용 텍스트
		System.out.println("====SELECT ONE====");
		System.out.println();
		
		String selectOneText = "SELECT ";

		for (int i = 0; i < beansmaker.size(); i++) {
			selectOneText += beansmaker.get(i);
			if (i < beansmaker.size() - 1) {
				selectOneText += ", ";
			}
		}
		System.out.println(selectOneText + " FROM " + tablename + " WHERE " + beansmaker.get(0) + "=#{"
				+ beansmaker.get(0) + "};");
		System.out.println();

		// 다중 select용 텍스트
		System.out.println("====SELECT====");
		System.out.println();
		
		String selectText = "SELECT ";
		for (int i = 0; i < beansmaker.size(); i++) {
			selectText += beansmaker.get(i);
			if (i < beansmaker.size() - 1) {
				selectText += ", ";
			}
		}
		System.out.println(selectText + " FROM " + tablename + ";");
	}
}
