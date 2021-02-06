package main.mvvm.model;

import java.util.Observable;

public class HeaderModel extends Observable {
    private String text;

    public HeaderModel() {
        this.text = "Welcome";
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        super.setChanged();
        super.notifyObservers();
    }
}
