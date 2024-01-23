package homework_ktpm_tuan2;

import javax.swing.JTextArea;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.comments.Comment;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class checkClass extends VoidVisitorAdapter<JTextArea>{

	@Override
	public void visit(ClassOrInterfaceDeclaration n, JTextArea jTextArea) {
		// TODO Auto-generated method stub
		super.visit(n, jTextArea);
		if(!isStartsWithUppercase(n.getNameAsString())) {
			jTextArea.append("Class " + n.getNameAsString() + " không bắt đầu bằng chữ hoa \n");
		}
		
		for (Comment comment : n.getAllContainedComments()) {
            String commentContent = comment.getContent().toLowerCase();
            if (!commentContent.contains("created-date") || !commentContent.contains("author")) {
            	jTextArea.append("Class " + n.getNameAsString() + " không chứa thông tin created-date hoặc author \n");
                break;
            }
        }
		
		
	}
	
	
	private boolean isStartsWithUppercase(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        char firstChar = str.charAt(0);

        return Character.isUpperCase(firstChar);
    }
}
