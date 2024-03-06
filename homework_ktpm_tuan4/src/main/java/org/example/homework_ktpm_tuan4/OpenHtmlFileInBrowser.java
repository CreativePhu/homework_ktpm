package org.example.homework_ktpm_tuan4;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class OpenHtmlFileInBrowser {
	
	public static void run() throws URISyntaxException {
		try {
			
			String baseDir = System.getProperty("user.dir");
			String relativePath = "jdepend-ui//index.html";
			String absolutePath = baseDir + File.separator + relativePath;
			
			// Tạo một đối tượng File từ đường dẫn
			File htmlFile = new File(absolutePath);

            // Kiểm tra xem Desktop có được hỗ trợ không
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                if (htmlFile.exists()) {
                    // Mở tệp HTML trong trình duyệt mặc định của hệ thống
                    desktop.browse(htmlFile.toURI());
                } else {
                    System.out.println("File not found: " + absolutePath);
                }
            } else {
                System.out.println("Desktop is not supported.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
