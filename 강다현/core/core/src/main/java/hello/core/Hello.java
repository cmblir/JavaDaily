package hello.core;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Hello {
    private String nama;
    private int age;

    public static void main(String[] args) {
        Hello hello = new Hello();
        hello.setNama("name");

        String name = hello.getNama();
        System.out.println("name = " + name);

    }
}
