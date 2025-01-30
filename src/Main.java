import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
WordParser fileParser=new WordParser("text.txt");
fileParser.parser();
Map<String,Integer>frequency=fileParser.frequency();
try (FileWriter fileWriter=new FileWriter("result.txt")){
    String M = null;
    int max1= 0;
    for (Map.Entry<String,Integer>entry:frequency.entrySet()){
        if (entry.getValue() > max1) {
            max1 = entry.getValue();
            M = entry.getKey();
        }

        String s=String.format("Слово %s встречается %d раз\n",entry.getKey(),entry.getValue());
        fileWriter.write(s);
        String max=String.format("Самое встречаемое слово %s -%d раз\n",M,max1);
        fileWriter.write(max);
    }
}
catch (IOException ex){
    System.out.println(ex.getMessage());
}

    }
}