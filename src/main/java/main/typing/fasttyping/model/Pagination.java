package main.typing.fasttyping.model;

import lombok.Getter;

public class Pagination {
    private  String text;
    private final int PAGE_SIZE;
    @Getter
    private int currentPartSize;
    private int partCursorIndex;
    private boolean next = true;
    private String page;
    
    public Pagination(int partMaxSize){
        this.partCursorIndex = 0;
        PAGE_SIZE = partMaxSize;
    }
    
    public int getTotalTextSize(){
        int result = 0;
        if (text != null) result = text.length();
        return result;
    }
    
    public int getPageSize(){
        int result = 0;
        if (text != null) result = page.length();
        return result;
    }
    
    public String getPage(){
      getSymbolPage();
      return page;
    }
    
    public void setAllText(String text){
        this.text = text;
        partCursorIndex = 0;
        next = true;
    }

    public boolean hasNext(){
        return next;
    }

    private void getSymbolPage(){
        int end;
        if ((partCursorIndex + PAGE_SIZE) >= text.length()){
            end = text.length();
            page = text.substring(partCursorIndex, end);
            next = false;
        }
        else {
            end = partCursorIndex + PAGE_SIZE;
            page = text.substring(partCursorIndex, end);
            partCursorIndex += PAGE_SIZE;
        }
        currentPartSize = page.length();
    }
    
    
}
