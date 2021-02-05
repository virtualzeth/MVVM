package main.mvvm.model;

public class HeaderModel {
    private String text;

    public HeaderModel() {
        this.text = "Welcome";
    }

    public String getText() {
        return text;
    }

    public void setText(String header) {
        this.text = header;
    }
}
