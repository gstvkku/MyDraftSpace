import java.util.HashMap;
import java.util.Iterator;

public class InheritanceHistogram extends HashMap<String, Integer> implements Iterable<String> {


    public InheritanceHistogram (String string){
        String[] separatedWords = string.split(" ");
        initInherHistogram(separatedWords);
    }

    public void initInherHistogram(String[] stringArray) {
        for (String word : stringArray) {
            if (containsKey(word)) {
                Integer newValue = (Integer) get(word);
                replace(word, get(word), newValue + 1);
                continue;
            }
            put(word, 1);
        }
    }

    @Override
    public Iterator iterator() {
        return keySet().iterator();
    }
}
