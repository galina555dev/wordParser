import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class WordParser implements Parser{
private final Map<String, Integer> wordsFrequency;
private final String filename;
public  WordParser(String filename){
    this.filename=filename;
    this.wordsFrequency=new TreeMap<>();
}
    @Override
    public void parser() {
    if(!wordsFrequency.isEmpty()){
        return;
    }
        try(FileReader fileReader=new FileReader(filename);
            BufferedReader bufferedReader=new BufferedReader(fileReader)) {
            String s=null;
            while ((s=bufferedReader.readLine())!=null){
                String[] words=s.split("[^A-Za-z]+");
                for (String word:words){
                    if(!word.equals("")){
                        if (wordsFrequency.get(word.toLowerCase())==null){
                            wordsFrequency.put(word.toLowerCase(), 1);
                        }
                        else {
                            Integer oldFrequency=wordsFrequency.get(word.toLowerCase());
                            wordsFrequency.replace(word.toLowerCase(),oldFrequency+1);
                        }
                    }

                }
            }


        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }

    }

    public Map<String, Integer> frequency() {
        return wordsFrequency;
    }

}
