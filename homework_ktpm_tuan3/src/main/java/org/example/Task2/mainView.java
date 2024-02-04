package org.example.Task2;

import jdepend.framework.PackageFilter;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.List;

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

    public void checkFormartProject() throws IOException, ParserConfigurationException, SAXException {
        File projectDir = new File(textField.getText());
        if (projectDir.exists()) {
            if(createFileXML(projectDir)){
                ParserXML parserXML = new ParserXML();
                List<Package> packages = parserXML.parser();
                for (Package pk : packages){
                    textArea.append(pk.checkPackageOk());
                }
            }
        }else {
            JOptionPane.showMessageDialog(null, "Can not find " + projectDir.getAbsolutePath());
        }
    }

    public Boolean createFileXML(File file) throws IOException {
        try {
            PrintWriter out = new PrintWriter(new FileOutputStream("results.xml"));
            jdepend.xmlui.JDepend xml = new jdepend.xmlui.JDepend(out);
            xml.addDirectory(file.getAbsolutePath());
            PackageFilter f = PackageFilter.all();
            f.excluding("org");
            xml.setFilter(f);
            xml.analyze();
            return true;
        }catch(Exception e){
            return false;
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
                try {
                    textArea.setText("");
                    checkFormartProject();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (ParserConfigurationException ex) {
                    throw new RuntimeException(ex);
                } catch (SAXException ex) {
                    throw new RuntimeException(ex);
                }
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
