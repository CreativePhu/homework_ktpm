package org.example.Task1;

import java.io.File;
import java.util.List;

public class Drivers {
	public static void main(String[] args) throws Exception {
		LCOM4Calculation calculation = new LCOM4Calculation();
		File file = new File(
				"D:\\NoiLamViec\\Kien Truc Phan Mem\\Home Work\\homework_ktpm\\homework_ktpm_tuan3\\src\\main\\java\\org\\example\\Task1\\Group.class");
		List<Group> lst = calculation.loadGroups(file);
		lst.forEach(System.out::println);
		int lcom4 = calculation.loadGroups(file).size();
		System.out.printf("LCOM4 of class %s is %d\n", file.getName(), lcom4);
	}
}
