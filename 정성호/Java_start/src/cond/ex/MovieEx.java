package cond.ex;

public class MovieEx {
    public static void main(String[] args) {
        double rating = 9;
        String movieName = null;
        if (rating >= 9) {
            movieName = "어바웃타임";
        } else if (rating >= 8) {
            movieName = "토이 스토리";
        } else if (rating >= 7) {
            movieName = "고질라";
        }
        System.out.println("rating : " + rating);
        System.out.println("출력 : ");
        System.out.println("'" + movieName + "'을 추천합니다.");
    }
}
