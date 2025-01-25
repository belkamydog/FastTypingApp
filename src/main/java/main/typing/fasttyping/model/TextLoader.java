package main.typing.fasttyping.model;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.*;

public class TextLoader {
    public static String loadTextFromFile(File file){
        String result = "";
        try (InputStream in = new FileInputStream(file);
             Reader reader = new InputStreamReader(in)) {
            int c;
            while ((c = reader.read()) != -1) {
                if ((char) c != '\n') result = result.concat(String.valueOf((char) c));
                else result = result.concat(String.valueOf(' '));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return preparing(result);
    }

    public static String loadTextFromBuffer(){
        String result = "";
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        try {
            result = (String) clipboard.getData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException | IOException ex) {
            throw new RuntimeException(ex);
        }
        return preparing(result);
    }

    private static String preparing(String text){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++){
             result.append(changeE(text.charAt(i)));
        }
        return result.toString();
    }

    private static char changeE(char c){
        if (c == 'ё') c = 'е';
        else if (c == 'Ё') c = 'Е';
        return c;
    }
}
