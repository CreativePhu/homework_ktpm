package homework_ktpm_tuan2;

import javax.swing.JTextArea;

import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class checkPackage extends VoidVisitorAdapter<JTextArea> {

	@Override
	public void visit(PackageDeclaration n, JTextArea jTextArea) {
		super.visit(n, jTextArea);
		if(!checkFormartPackageName(n.getNameAsString())) {
			jTextArea.append("package " + n.getNameAsString() + " không bắt đầu bằng 'com.companyname.'\n");
		}
	}
	
	private boolean checkFormartPackageName(String namePackage) {
		if(namePackage.startsWith("com.companyname.")) {
			return true;
		}
		return false;
	}

}
