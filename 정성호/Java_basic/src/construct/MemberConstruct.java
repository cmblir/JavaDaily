package construct;

public class MemberConstruct {
    String name;
    int age;
    int grade;

    /**
     * 생성자 오버로딩
     * @param name 이름
     * @param age 나이
     */

    MemberConstruct(String name, int age) {
        this(name, age, 50); // ~> 1번째 생성자가 2번째 생성자를 호출하게 된다.
    }
    /**
     * @param name 이름
     * @param age 나이
     * @param grade 점수
     */
    MemberConstruct(String name, int age, int grade) {
        System.out.println("생성자 호출 " + name + age + grade);
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

}
