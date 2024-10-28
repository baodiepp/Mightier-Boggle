package difficulty_adaptor;

import boggle.Position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DifficultyAdaptor {

    double difficulty;

    Map<String, ArrayList<Position>> allWords;



    public DifficultyAdaptor(int difficulty, Map<String, ArrayList<Position>> allWords) {
        this.difficulty = difficulty*0.25;

        this.allWords = allWords;
    }

    public Map<String, ArrayList<Position>> getAdaptedAllWords() {

        double needed = Math.ceil(allWords.size() * difficulty);

        Map<String, ArrayList<Position>> adapted = new HashMap<>();

        ArrayList<String> temp = new ArrayList<String>(allWords.keySet());

        for (int i = 0; i < needed; i++) {
            int min = 0;
            int max = allWords.size();
            int rand = (int) ((Math.random() * (max - min)) + min);
            adapted.put(temp.get(rand), allWords.get(temp.get(rand)));
            allWords.remove(temp.get(rand));
            temp.remove(rand);
        }

        return adapted;
    }
}
