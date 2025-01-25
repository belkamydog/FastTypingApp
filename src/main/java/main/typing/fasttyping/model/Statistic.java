/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.typing.fasttyping.model;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;

/**
 *
 * @author artemefimov
 */
public class Statistic {
    private Map <Character , Key> keys;
    
    public Statistic(){
       keys = new HashMap <Character, Key>();
       initRusKeys();
       initEnKeys();
    }
    
    public double getKeyPrecision(char ch){
        return keys.get(ch).getRightPushedPercent();
    }
    
    public void pushRightKey(char key){
        if (keys.get(key)!= null)
            keys.get(key).addRightPush();
    }
    
    public void pushWrongKey(char key){
        if (keys.get(key) != null)
            keys.get(key).addWrongPush();
    }
    
    private void initEnKeys(){
        keys.put('a', new Key('a'));
        keys.put('b', new Key('b'));
        keys.put('c', new Key('c'));
        keys.put('d', new Key('d'));
        keys.put('e', new Key('e'));
        keys.put('f', new Key('f'));
        keys.put('g', new Key('g'));
        keys.put('h', new Key('h'));
        keys.put('i', new Key('i'));
        keys.put('j', new Key('j'));
        keys.put('k', new Key('k'));
        keys.put('l', new Key('l'));
        keys.put('m', new Key('m'));
        keys.put('n', new Key('n'));
        keys.put('o', new Key('o'));
        keys.put('p', new Key('p'));
        keys.put('q', new Key('q'));
        keys.put('r', new Key('r'));
        keys.put('s', new Key('s'));
        keys.put('t', new Key('t'));
        keys.put('u', new Key('u'));
        keys.put('v', new Key('v'));
        keys.put('w', new Key('w'));
        keys.put('x', new Key('x'));
        keys.put('y', new Key('y'));
        keys.put('z', new Key('z'));
    }
    
    private void initRusKeys(){
        keys.put('й', new Key('й'));
        keys.put('ц', new Key('ц'));
        keys.put('у', new Key('у'));
        keys.put('к', new Key('к'));
        keys.put('е', new Key('е'));
        keys.put('н', new Key('н'));
        keys.put('г', new Key('г'));
        keys.put('ш', new Key('ш'));
        keys.put('щ', new Key('щ'));
        keys.put('з', new Key('з'));
        keys.put('х', new Key('х'));
        keys.put('ъ', new Key('ъ'));
        keys.put('ф', new Key('ф'));
        keys.put('ы', new Key('ы'));
        keys.put('в', new Key('в'));
        keys.put('а', new Key('а'));
        keys.put('п', new Key('п'));
        keys.put('р', new Key('р'));
        keys.put('о', new Key('о'));
        keys.put('л', new Key('л'));
        keys.put('д', new Key('д'));
        keys.put('ж', new Key('ж'));
        keys.put('э', new Key('э'));
        keys.put('я', new Key('я'));
        keys.put('ч', new Key('ч'));
        keys.put('с', new Key('с'));
        keys.put('м', new Key('м'));
        keys.put('и', new Key('и'));
        keys.put('т', new Key('т'));
        keys.put('ь', new Key('ь'));
        keys.put('б', new Key('б'));
        keys.put('ю', new Key('ю'));
        keys.put('?', new Key('?'));
        keys.put('1', new Key('1'));
        keys.put('2', new Key('2'));
        keys.put('3', new Key('3'));
        keys.put('4', new Key('4'));
        keys.put('5', new Key('5'));
        keys.put('6', new Key('6'));
        keys.put('7', new Key('7'));
        keys.put('8', new Key('8'));
        keys.put('9', new Key('9'));
        keys.put('0', new Key('0'));
        keys.put('.', new Key('.'));
        keys.put(',', new Key(','));
        keys.put(' ', new Key(' '));
    }
    
    @Getter
    public class Key{
       private char key;
       private int wrongPushCount;
       private int totalPushedCount;
       private double rightPushedPercent;
       
       public Key(char key){
           this.key = key;
           totalPushedCount = 0;
           wrongPushCount = 0;
           rightPushedPercent = 100;
       }
       public void addRightPush(){
           totalPushedCount++;
           calculatePushedPercent();
           normalisation();
       }
        public void addWrongPush(){
           wrongPushCount++;
           totalPushedCount++;
           calculatePushedPercent();
           normalisation();
       }
        
       private void calculatePushedPercent(){
           int a = totalPushedCount-wrongPushCount;
           if (a > 0) rightPushedPercent = 100 - ((wrongPushCount*100)/a);
       }
        
       private void normalisation(){
           if (totalPushedCount % 2 == 0 && wrongPushCount % 2 == 0){
               totalPushedCount/= 2;
               wrongPushCount /= 2;
           }
       }
    }
}
