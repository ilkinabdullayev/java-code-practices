package info.ilkinabdullayev.serializable.complex;

import java.io.Serializable;

public class Telephone implements Serializable {

    private static final long serialVersionUID = 2276411054808124643L;

    private int id;
    private String number;

    public Telephone(int id, String number) {
        this.id = id;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Telephone{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }
}
