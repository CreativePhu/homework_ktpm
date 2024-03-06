package org.example.homework_ktpm_tuan4;

import java.io.IOException;
import java.io.PrintWriter;
import jdepend.xmlui.JDepend;

public class PartXMLProject {
	
	public static void run(String yourProject) throws IOException {
		JDepend depend = new JDepend(new PrintWriter("reports/report.xml"));
		depend.addDirectory(yourProject);
		depend.analyze();
		System.out.println("Part XML project success");
	}
}
