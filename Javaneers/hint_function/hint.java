package hint_function;
import boggle.Position;

import java.lang.reflect.Array;
import java.util.*;

public class hint {

    public String get_hint(Map<String,ArrayList<Position>> words, Set<String> used) {
        Set<String> temp = words.keySet();
        Object[] temp1 = temp.toArray();
        if (used.size() == temp.size()) {
            return "There are no more words left to hint at";
        }
        int chosen_index = new Random().nextInt(temp.size());
        while (used.contains(temp1[chosen_index].toString())) {
            chosen_index = new Random().nextInt(temp.size());
        }
        String temp_word = temp1[chosen_index].toString();
        used.add(temp_word);
        return "Your hint is: " + temp_word.charAt(0) + temp_word.charAt(1);
    }
}
