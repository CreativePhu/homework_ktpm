package homework_ktpm_tuan2;

import java.util.List;

import javax.swing.JTextArea;

import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.comments.Comment;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class checkMethod extends VoidVisitorAdapter<JTextArea>{
	
	@Override
	public void visit(MethodDeclaration n, JTextArea jTextArea) {
		super.visit(n, jTextArea);
		if(!isValidMethodName(n.getNameAsString())) {
			jTextArea.append(" [L " + n.getBegin() + "] Method " + n.getNameAsString() + " phải bắt đầu bằng một động từ và phải là chữ thường\n");
		}
		
		if(!checkMethodComment(n)) {
			jTextArea.append(" [L " + n.getBegin() + "] Method " + n.getNameAsString() + " chưa có ghi chú mô tả công việc\n");
		}
		
		
	}
	
	private boolean isValidMethodName(String methodName) {
        return methodName.matches("^[a-z]+[a-zA-Z0-9]*$");
    }
	
	
	private boolean checkMethodComment(MethodDeclaration method) {
        List<Comment> comments = method.getAllContainedComments();
        if (comments.isEmpty()) {
            return false;
        }
        return true;
    }
}
