/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.typing.fasttyping.controller;

import java.io.File;
import main.typing.fasttyping.model.TextLoader;
import main.typing.fasttyping.model.CheckTypingSpeed;
import main.typing.fasttyping.model.Pagination;
import main.typing.fasttyping.model.LoadMemoryText;
import main.typing.fasttyping.model.LoadMemoryText.Languages;
import main.typing.fasttyping.model.Statistic;
      
/**
 *
 * @author artemefimov
 */
public class TypingController {
    private final int PAGE_SIZE = 220;
    private TextLoader textLoader;
    private Pagination pagination;
    private CheckTypingSpeed checkTypingSpeed;
    private LoadMemoryText loadMemoryText;
    private Statistic statistic;
    
    public TypingController(){
        pagination = new Pagination(PAGE_SIZE);
        checkTypingSpeed = new CheckTypingSpeed();
        loadMemoryText = new LoadMemoryText(LoadMemoryText.Languages.ru);
        statistic = new Statistic();
    }
    
    public void getNextMemoryText(){
       checkTypingSpeed.resetData();
       pagination.setAllText(loadMemoryText.getNext());
       checkTypingSpeed.setTotalTextLength(pagination.getTotalTextSize());
    }
    
    public void loadFromFile(File file){
         checkTypingSpeed.resetData();
         pagination.setAllText(TextLoader.loadTextFromFile(file));
         checkTypingSpeed.setTotalTextLength(pagination.getTotalTextSize());
    }
    
    public void loadFromBuffer(){
        checkTypingSpeed.resetData();
        pagination.setAllText(TextLoader.loadTextFromBuffer());
        checkTypingSpeed.setTotalTextLength(pagination.getTotalTextSize());
    }
            
    public void setLanguage(Languages language){
        loadMemoryText.setLanguage(language);
    }
    
    public String getPage(){
        return pagination.getPage();
    }
    
    public void getDataFromGui(int currentIndex, int timeSeconds){
        checkTypingSpeed.setCurrentData(currentIndex, timeSeconds);
    }
    
    public int getBpm(){
        return checkTypingSpeed.getBpm();
    }
    
    public double getPrecision(){
        return checkTypingSpeed.getPrecision();
    }
    
    public void wrongInput(char ch){
        checkTypingSpeed.inputWrong();
        statistic.pushWrongKey(ch);
    }
    
    public void rightInput(char ch){
        statistic.pushRightKey(ch);
    }
    
    public double getPrecisionStatistic(char ch){
        return statistic.getKeyPrecision(ch);
    }
    
    public int getTextLength(){
        return pagination.getTotalTextSize();
    }
    
    public int getPartSize(){
        return pagination.getPageSize();
    }
    
    public boolean hasNextPage(){
        return pagination.hasNext();
    }
    
    public int getProgress(int globalIndex){
        return ((globalIndex+1) * 100)/(pagination.getTotalTextSize());
    }
    
    public void inputedSymbol(char ch){
        
    }
    
    public char getNext(){
        return ' ';
    }
}
