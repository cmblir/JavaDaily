package class1.ex;

import java.util.Scanner;

public class MovieReviewMain1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MovieReview movie = new MovieReview();
        movie.title = scanner.nextLine();
        movie.review = scanner.nextLine();

        System.out.println(movie.title);
        System.out.println(movie.review);
    }
}
