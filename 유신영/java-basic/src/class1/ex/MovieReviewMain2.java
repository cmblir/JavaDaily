package class1.ex;

import java.util.ArrayList;
import java.util.Scanner;

public class MovieReviewMain2 {
    public static void main(String[] args) {
        ArrayList<String> movies = new ArrayList<>();
        ArrayList<String> movieReviews = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int count = 0;
        while (true) {
            System.out.println("옵션을 선택하세요.");
            System.out.println("1. 영화 리뷰 입력, 2. 종료");
            int number = scanner.nextInt();
            if (number == 2) {
                break;
            } else {
                System.out.print("영화 제목을 입력하세요 : ");
                scanner.nextLine();
                String movieName = scanner.nextLine();

                System.out.print("영화 리뷰을 입력하세요 : ");
                String movieReview = scanner.nextLine();

                movies.add(movieName);
                movieReviews.add(movieReview);
            }
        }

        int length = movies.size();
        for (int i = 0; i < length; i++) {
            MovieReview movie = new MovieReview();
            movie.title = movies.get(i);
            movie.review = movieReviews.get(i);
            System.out.println(movie.title + movie.review);
        }
    }
}
