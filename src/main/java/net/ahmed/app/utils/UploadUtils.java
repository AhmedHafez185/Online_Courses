/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ahmed.app.utils;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Ahmed Hafez
 */
public class UploadUtils {
    final String ROOT_PATH;
    public UploadUtils(String rootPath) {
        ROOT_PATH = rootPath;
    }
    public void uploadFile(String type,MultipartFile file) throws IOException, Exception{
       if(ROOT_PATH == "" || ROOT_PATH == null){
           throw new Exception("Root Path Not Found");
       }
       String relativePath = "resources\\"+type+"\\";
       String filePath = "";
        try {
            filePath = ROOT_PATH+relativePath+file.getOriginalFilename();
            file.transferTo(new File(filePath));
            System.out.println("filePath : "+ filePath);
        } catch (IOException ex) {
            throw ex;
        } catch (IllegalStateException ex) {
           throw ex;
        }
       
    }
}
