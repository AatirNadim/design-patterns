package design_patterns.behavioural;

import java.util.ArrayList;
import java.util.List;

// Originator class
class TextEditor {
    private String text;

    public TextEditor(String text) {
        this.text = text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public Memento saveState() {
        return new Memento(text);
    }

    public void restoreState(Memento memento) {
        text = memento.getText();
    }
}

// Memento class
class Memento {
    private String text;

    public Memento(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

// Caretaker class
class Caretaker {
    private List<Memento> mementos;

    public Caretaker() {
        this.mementos = new ArrayList<>();
    }

    public void addMemento(Memento memento) {
        mementos.add(memento);
    }

    public Memento getMemento(int index) {
        return mementos.get(index);
    }
}

// Client code
class Main {
    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor("Initial text");
        Caretaker caretaker = new Caretaker();

        System.out.println("Initial text: " + textEditor.getText());

        // Save state
        Memento memento1 = textEditor.saveState();
        caretaker.addMemento(memento1);

        // Change text
        textEditor.setText("New text");
        System.out.println("New text: " + textEditor.getText());

        // Save state
        Memento memento2 = textEditor.saveState();
        caretaker.addMemento(memento2);

        // Restore state
        textEditor.restoreState(memento1);
        System.out.println("Restored text: " + textEditor.getText());
    }
}