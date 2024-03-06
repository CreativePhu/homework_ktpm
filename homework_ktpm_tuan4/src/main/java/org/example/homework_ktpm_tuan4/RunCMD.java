package org.example.homework_ktpm_tuan4;

import java.io.File;
import java.io.IOException;

public class RunCMD {
	public static void run(String your_packages_prefix) {
		try {
			String baseDir = System.getProperty("user.dir");
			String relativePath1 = "reports\\report.xml";
			String relativePath2 = "jdepend-ui";
			String absolutePath1 = baseDir + File.separator + relativePath1;
			String absolutePath2 = baseDir + File.separator + relativePath2;
			
            // Khởi tạo ProcessBuilder với lệnh cmd và tham số
            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", "npm run jdepend-ui "+ absolutePath1 + " " + your_packages_prefix);

            // Thiết lập thư mục làm việc nếu cần thiết
            processBuilder.directory(new File(absolutePath2));

            // Khởi chạy lệnh
            Process process = processBuilder.start();

            // Đợi cho lệnh kết thúc
            int exitCode = process.waitFor();

            // In ra output nếu cần thiết
            /* BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            } */

            // In ra exit code
//            System.out.println("Exit code: " + exitCode);
            
        } catch (IOException | InterruptedException e1) {
            e1.printStackTrace();
        }
	}
}
