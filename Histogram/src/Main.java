import java.util.Map;

public class Main {
    public static final String STRING = "test word words test 1 10 1";

    public static void main(String[] args) {

/*        CompositionHistogram wordHistogram = new CompositionHistogram(STRING);
        System.out.println("MAP has " + wordHistogram.size() + " distinct words");

        for (String word : wordHistogram) {
            System.out.println(word + " : " + wordHistogram.get(word));
        }*/

        InheritanceHistogram inheritanceHistogram = new InheritanceHistogram(STRING);
        System.out.println("MAP has " + inheritanceHistogram.size() + " distinct words");

        for (String word : inheritanceHistogram.keySet()){
            System.out.println(word + " : " + inheritanceHistogram.get(word));
        }
    }
}