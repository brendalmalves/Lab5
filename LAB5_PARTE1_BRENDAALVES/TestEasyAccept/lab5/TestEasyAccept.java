package lab5;

import easyaccept.EasyAccept;

public class TestEasyAccept {
	
	public static void main(String[] args) {
		args = new String[] {"lab5.Facade", "TestEasyAccept/use_case_1.txt", "TestEasyAccept/use_case_2.txt", "TestEasyAccept/use_case_3.txt", "TestEasyAccept/use_case_4.txt"};
		EasyAccept.main(args);
	}
}
