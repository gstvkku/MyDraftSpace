import java.util.*;

public class CompositionHistogram implements Iterable<String> {

    private HashMap<String, Integer> hashMap;

    public CompositionHistogram(String string) {
        hashMap = new HashMap<String, Integer>();
        String[] separatedWords = string.split(" ");
        initHashMap(separatedWords);
    }

    public void initHashMap(String[] stringArray) {
        for (String word : stringArray) {
            if (hashMap.containsKey(word)) {
                hashMap.replace(word, hashMap.get(word) + 1);
                continue;
            }
            hashMap.put(word, 1);
        }
    }

    public int size() {
        return hashMap.keySet().size();
    }

    public Integer get(String string) {
        return hashMap.get(string);
    }

    @Override
    public Iterator iterator() {
        return hashMap.keySet().iterator();
    }
}
