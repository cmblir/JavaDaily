package cond.ex;

import java.util.Scanner;

public class GradeEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String grade = scanner.nextLine();
        switch (grade) {
            case "A":
                System.out.println("\"" + grade + "\" : \" 탁월한 성과입니다!\"");
                break;
            case "B":
                System.out.println("\"" + grade + "\" : \" 좋은 성과입니다!\"");
                break;
            case "C":
                System.out.println("\"" + grade + "\" : \" 준수한 성과입니다!\"");
                break;
            case "D":
                System.out.println("\"" + grade + "\" : \" 향상이 필요합니다.\"");
                break;
            case "F":
                System.out.println("\"" + grade + "\" : \" 불합격입니다.\"");
                break;
            default:
                System.out.println("나머지 : \"잘못된 학점입니다.\"");
                break;
        }
    }
}
