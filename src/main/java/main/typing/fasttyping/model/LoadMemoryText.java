/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.typing.fasttyping.model;

import java.io.File;
import java.util.Random;
import lombok.Getter;


/**
 *
 * @author artemefimov
 */
@Getter
public class LoadMemoryText {
    public enum Languages{
        ru, en
    };
    private final String BASE_DIR = "src/main/java/resources";
    private File [] files;
    private Languages language;
    
    public LoadMemoryText(Languages language){
       this.language = language; 
       uploadTexts();
    }
    
    public void setLanguage(Languages language){
        this.language = language;
        uploadTexts();
    }
    
    public String getNext(){
        String result = "";
        File file = getRandomFile();
        if (file != null) result = TextLoader.loadTextFromFile(file);
        return result;
    }
    
    private void uploadTexts(){
       String path = BASE_DIR;
       path += language.name().equals("ru") ? "/ru":"/en";
       File dir = new File(path);
       files = dir.listFiles();
    }
    
    private File getRandomFile(){
        File result = null;
        int rnd;
        if (files != null){
            rnd = new Random().nextInt(files.length);
            if (files.length > 0) result = files[rnd];
        }
        return result;
    }
}
