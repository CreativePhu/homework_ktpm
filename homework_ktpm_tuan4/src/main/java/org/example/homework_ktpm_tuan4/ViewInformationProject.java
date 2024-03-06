package org.example.homework_ktpm_tuan4;

import java.io.IOException;

import jdepend.swingui.*;

public class ViewInformationProject {
	
	public static void run(String yourProject) throws IOException {
		JDepend depend = new JDepend();
		depend.addDirectory(yourProject);
		depend.analyze();
		System.out.println("DONE");
	}
	
}
