package main.typing.fasttyping.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CheckTypingSpeed {
    private String text;
    private int bpm = 0;
    private double precision = 100.0;
    private int wrongCounter = 0;
    private int totalTextLength;

    public void setCurrentData(int countSymbols, int time) {
        if (time != 0) {
            float x = (float) countSymbols / time;
            bpm = (int) (x * 60L);
        }
    }
   
    public void inputWrong(){
        wrongCounter++;
        precision = 100 - ((double) (wrongCounter * 100) / totalTextLength);
    }
    
    public void resetData(){
        text = "";
        bpm = 0;
        precision = 100;
        wrongCounter = 0;
        totalTextLength = 0;
    }
    
    
}
