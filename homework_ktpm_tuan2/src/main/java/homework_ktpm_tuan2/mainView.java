package homework_ktpm_tuan2;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.github.javaparser.StaticJavaParser;
import com.google.common.base.Strings;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.io.File;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class mainView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JButton btnNewButton;
	private JButton btnKimTraCu;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainView frame = new mainView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void checkFormartProject() {
		File projectDir = new File(textField.getText());
		if (projectDir.exists()) {
			new DirExplorer((level, path, file) -> path.endsWith(".java"), (level, path, file) -> {
				textArea.append(path.toString() + "\n");
				textArea.append(Strings.repeat("=", path.length()) + "\n");
				try {
					new checkPackage().visit(StaticJavaParser.parse(file), textArea);
					new checkClass().visit(StaticJavaParser.parse(file), textArea);
					new checkField().visit(StaticJavaParser.parse(file), textArea);
					new checkMethod().visit(StaticJavaParser.parse(file), textArea);
				} catch (Exception e) {
					new RuntimeException(e);
				}
			}).explore(projectDir);
		}else {
			JOptionPane.showMessageDialog(null, "Can not find " + projectDir.getAbsolutePath());
		}
	}

	/**
	 * Create the frame.
	 */
	public mainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 916, 564);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Chọn dự án");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 93, 30);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(10, 52, 880, 30);
		contentPane.add(textField);
		textField.setColumns(10);

		btnNewButton = new JButton("Chọn");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				int returnValue = fileChooser.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					if (file.exists()) {
						textField.setText(file.getAbsolutePath());
					}
				}
			}
		});
		btnNewButton.setBounds(113, 11, 93, 30);
		contentPane.add(btnNewButton);

		btnKimTraCu = new JButton("Kiểm tra cấu trúc dự án");
		btnKimTraCu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkFormartProject();
			}
		});
		btnKimTraCu.setBounds(216, 11, 193, 30);
		contentPane.add(btnKimTraCu);

		textArea = new JTextArea();
		textArea.setLineWrap(true);

		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(10, 93, 880, 421);
		contentPane.add(scrollPane);

	}
}
