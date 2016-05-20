import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;


public class ComparatorCounter implements Comparator<Map.Entry<String, Integer>>, Serializable {
    public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
        return e1.getValue().compareTo(e2.getValue());
    }
}