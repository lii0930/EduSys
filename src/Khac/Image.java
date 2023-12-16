/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Khac;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

/**
 *
 * @author uynph
 */
public class Image {
   public static java.awt.Image getAppIcon() {
        URL url = Image.class.getResource("/com/edusys/icon/logo.png");
        return new ImageIcon(url).getImage();
    }

    public static void save(File src) {
        File dst = new File("src/Hinh/", src.getName());
        if (dst.getParentFile().exists()) {
            dst.getParentFile().mkdirs();// Tạo thư mục logos nếu chưa tồn tại
        }
        try {
            Path from = Paths.get(src.getAbsolutePath());
            Path to = Paths.get(dst.getAbsolutePath());
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING); // Copy file vào thư mục logos
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static ImageIcon read(String fileName) {
        File path = new File("src/Hinh/", fileName);
        return new ImageIcon(new ImageIcon(path.getAbsolutePath()).getImage().getScaledInstance(200, 250, java.awt.Image.SCALE_DEFAULT));
    } 
}
