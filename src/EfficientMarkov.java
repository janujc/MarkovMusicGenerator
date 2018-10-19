import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class EfficientMarkov extends BaseMarkov {
    private static Map<String, ArrayList<String>> myMap;

    public EfficientMarkov(int order) {
        super(order);
    }

    public EfficientMarkov() {
        this(3);
    }

    @Override
    public ArrayList<String> getFollows(String key) {    //FIXME
        if(myMap.get(key) != null){
            return myMap.get(key);
        }
        else throw new NoSuchElementException(key + " not in map");
    }

    @Override
    public void setTraining(String text) {
        myText = text;
        myMap = new HashMap<>();
        for (int index = 0; index < text.length(); index++) {
            if ((index + myOrder) >= myText.length()) {
                String str = myText.substring(index, index + myOrder);
                if (!myMap.containsKey(str)) {
                    myMap.put(str, new ArrayList<String>());
                }
                myMap.get(str).add(PSEUDO_EOS);
                break;
            }
            String str = myText.substring(index, index + myOrder);
            String nextChar = myText.substring(index + myOrder, index + myOrder + 1);
            if (! myMap.containsKey(str)) {
                myMap.put(str, new ArrayList<String>());
            }
            myMap.get(str).add(nextChar);
        }
    }
//    public static void main(String[] args) {
//        String s = "bbbabbabbbbaba";
//        EfficientMarkov test = new EfficientMarkov();
//        test.setTraining(s);
//        System.out.println(myMap.get("aba"));
//    }
}