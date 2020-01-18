package info.ilkinabdullayev.optional;

public class Input {
    private String text;

    public Input(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Input{" +
                "text='" + text + '\'' +
                '}';
    }
}
