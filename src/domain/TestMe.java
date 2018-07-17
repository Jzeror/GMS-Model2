package domain;

import java.util.ArrayList;
import java.util.List;

import dao.TestDAOMe;
import sun.applet.Main;

public class TestMe {
	public static void main(String[] args) {

		List<String> list = TestDAOMe.getInstance().list();
		String[] ssn = new String[20];
		int a = 0, c = 0;
		for (int i = 0; i < list.size(); i++) {
			for (int s = 0; s < 10; s++) {
				a = (int) ((Math.random() * 12) + 1);
				c = (int) ((Math.random() * 12) + 1);
			}
			ssn[i] = String
					.valueOf(119 - Integer.parseInt(list.get(i)) 
							+ String.format("%02d", a) 
							+ String.format("%02d", c));
		}
		for (int i = 0; i < 20; i++) {
			System.out.println("[" + i + "] : " + ssn[i]);
		}
	}
}
