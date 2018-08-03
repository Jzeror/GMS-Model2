package domain;

import java.util.ArrayList;
import java.util.List;

import dao.TestDAOMe;

public class TestMe {
	public static void main(String[] args) {

		

		int a = 0, c = 0, b=0;
		String  d="";
		for (int i = 0; i <5; i++) {
			for (int s = 0; s < 10; s++) {
				b= (int) ((Math.random() * 10) + 70);
				a = (int) ((Math.random() * 12) + 1);
				c = (int) ((Math.random() * 30) + 1);
				d = String.valueOf((int) ((Math.random() * 2) + 1));
			}
			String ssn = String.format("%02d", b)
							+ String.format("%02d", a) 
							+ String.format("%02d", c)
							+"-"+d;
		}
	
	}
}
