package design_patterns.structural;

import java.util.HashMap;
import java.util.Map;

interface Character {
    void display(int x, int y);
}


class ConcreteCharacter implements Character {

    private char symbol;
    private String font;

    ConcreteCharacter(char symbol, String font) {}

    @Override
    public void display(int x, int y) {}
}

class CharacterFactory {
    private final static Map<String, Character> mp = new HashMap<>();

    public static Character getCharacter(char symbol, String font) {
        String key = symbol + font;
        if(!mp.containsKey(key))
            mp.put(key, new ConcreteCharacter(symbol, font));
        return mp.get(key);
    }
}