import java.io.*;
import java.util.Scanner;

public class ReplaceText {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// 获取用户输入的文件路径和替换字符串
		System.out.print("请输入源文件路径: ");
		String sourceFilePath = scanner.nextLine();

		System.out.print("请输入目标文件路径: ");
		String targetFilePath = scanner.nextLine();

		System.out.print("请输入要替换的旧字符串: ");
		String oldString = scanner.nextLine();

		System.out.print("请输入新的字符串: ");
		String newString = scanner.nextLine();

		replaceTextInFile(sourceFilePath, targetFilePath, oldString, newString);
	}

	public static void replaceTextInFile(String sourceFilePath, String targetFilePath, String oldString, String newString) {
		// 读取源文件并替换文本
		try (
				BufferedReader reader = new BufferedReader(new FileReader(sourceFilePath));
				BufferedWriter writer = new BufferedWriter(new FileWriter(targetFilePath))
		) {
			String line;
			while ((line = reader.readLine()) != null) {
				// 替换旧字符串为新字符串
				String replacedLine = line.replace(oldString, newString);
				// 写入目标文件
				writer.write(replacedLine);
				writer.newLine();
			}
			System.out.println("文件替换完成，结果已写入目标文件: " + targetFilePath);
		} catch (IOException e) {
			System.out.println("文件处理过程中出现错误: " + e.getMessage());
		}
	}
}
