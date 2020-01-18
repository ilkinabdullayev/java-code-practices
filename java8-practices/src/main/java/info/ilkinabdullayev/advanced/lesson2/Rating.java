package info.ilkinabdullayev.advanced.lesson2;

import java.util.ArrayList;
import java.util.List;

public class Rating {

    public static final Rating EMPTY = new Rating();

    double points;
    List<Review> reviewList = new ArrayList<>();

    public void add(Review review) {
        reviewList.add(review);
        computeRating();
    }

    private void computeRating() {
        double totalPoints = reviewList.stream()
                .map(Review::getPoints)
                .reduce(0, Integer::sum);
        this.points = totalPoints / reviewList.size();
    }

    public static Rating average(Rating r1, Rating r2) {
        Rating combined = new Rating();
        combined.reviewList = new ArrayList<>(r1.reviewList);
        combined.reviewList.addAll(r2.reviewList);
        combined.computeRating();
        return combined;
    }
}
