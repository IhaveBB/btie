import java.util.Scanner;

public class Demo4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			String line = sc.nextLine();
			if (line.equals("ENDOFINPUT")) {
				break;
			} else if (line.equals("START") || line.equals("END")) {
				continue;
			}else {
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < line.length(); i++) {
					char c = line.charAt(i);
					if (c >= 'A' && c <= 'Z') {
						if (c >= 'F') {
							sb.append((char) (c - 5));
						} else {
							sb.append((char) (c + 21));
						}
					} else {
						sb.append(c);
					}
				}
				System.out.println(sb.toString());
			}
		}
	}
}