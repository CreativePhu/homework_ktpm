package homework_ktpm_tuan2;
import javax.swing.JTextArea;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class checkField extends VoidVisitorAdapter<JTextArea> {

	@Override
	public void visit(FieldDeclaration n, JTextArea textArea) {
		super.visit(n, textArea);
		if (!n.isFinal() && !startsWithLowercase(n.getVariables().get(0).getNameAsString())) {
			textArea.append(" [L " + n.getBegin() + "] Field " + n.getVariables().get(0).getNameAsString()
					+ " không bắt đầu bằng chữ thường\n");
		}
		
		if(n.isFinal() && !isAllUpperCase(n.getVariables().get(0).getNameAsString())){
			textArea.append(" [L " + n.getBegin() + "] Final " + n.getVariables().get(0).getNameAsString()
					+ " phải được viết hoa\n");
		}

	}

	private boolean startsWithLowercase(String str) {
		if (str == null || str.isEmpty()) {
			return false;
		}
		char firstChar = str.charAt(0);
		return Character.isLowerCase(firstChar);
	}
	
	private static boolean isAllUpperCase(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isUpperCase(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}
