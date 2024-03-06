package org.example.homework_ktpm_tuan4;

import java.io.IOException;
import java.io.PrintWriter;

import jdepend.xmlui.JDepend;

public class MainSequence {
	private String yourProject;

	public MainSequence(String yourProject) {
		super();
		this.yourProject = yourProject;
	}

	public MainSequence() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getYourProject() {
		return yourProject;
	}

	public void setYourProject(String yourProject) {
		this.yourProject = yourProject;
	}
	
	public void partXMLProject() throws IOException {
		PartXMLProject.run(yourProject);
	}
	
	public void viewInformationPorject() throws IOException {
		ViewInformationProject.run(yourProject);
	}
}
