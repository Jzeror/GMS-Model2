package domain;

import java.util.List;
import dao.TestDAO;

public class Test {
	public static void main(String[] args) {
		List<String> list = TestDAO.getInstance().list();
		String[] ssn = new String[20];
		for (int i = 0; i < list.size(); i++) {
			ssn[i] = String.valueOf(
					119 - Integer.parseInt(list.get(i)) + String.format("%02d", (int) ((Math.random() * 12) + 1))
							+ String.format("%02d", (int) ((Math.random() * 31) + 1)));
		}
		for (int i = 0; i < 20; i++) {
			System.out.println("[" + i + "] : " + ssn[i]);
		}
	}
}
