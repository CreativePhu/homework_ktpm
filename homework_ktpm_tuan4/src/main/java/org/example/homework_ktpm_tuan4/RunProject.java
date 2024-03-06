package org.example.homework_ktpm_tuan4;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javafx.stage.FileChooser;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class RunProject extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RunProject frame = new RunProject();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RunProject() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 522, 216);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Your Project");
		lblNewLabel.setFont(new Font("Segoe UI Historic", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 11, 108, 38);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(10, 60, 486, 38);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Choose Project");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int returnValue = fileChooser.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					String pathProject = fileChooser.getSelectedFile().getAbsolutePath().toString();
					textField.setText(pathProject);
				}
			}
		});
		btnNewButton.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		btnNewButton.setBounds(373, 11, 123, 35);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("View your package prefix");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Runnable runnable = new Runnable() {

					@Override
					public void run() {
						try {
							if (textField.getText().isEmpty()) {
								JOptionPane.showMessageDialog(null, "Please choose your project !");
							} else {
								MainSequence mainSequence = new MainSequence();
								mainSequence.setYourProject(textField.getText());
								mainSequence.viewInformationPorject();
							}
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
				};

				Thread thread = new Thread(runnable);
				thread.run();

			}
		});
		btnNewButton_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		btnNewButton_1.setBounds(10, 128, 209, 38);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_1_1_1 = new JButton("Main Sequence");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String baseDir = System.getProperty("user.dir");
				String relativePath = "reports\\report.xml";
				String absolutePath = baseDir + File.separator + relativePath;
				File file = new File(absolutePath);

				if (textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please choose your project !");
				} else {
					MainSequence mainSequence = new MainSequence();
					mainSequence.setYourProject(textField.getText());
					try {
						mainSequence.partXMLProject();
						String input = JOptionPane.showInputDialog(null, "Enter your package prefix:", "Enter Input", JOptionPane.PLAIN_MESSAGE);
						if (input != null) {
							RunCMD.run(input);
							try {
								OpenHtmlFileInBrowser.run();
							} catch (URISyntaxException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
				        }
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		btnNewButton_1_1_1.setBounds(287, 128, 209, 38);
		contentPane.add(btnNewButton_1_1_1);
	}
}
