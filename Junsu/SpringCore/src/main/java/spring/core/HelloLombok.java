package spring.core;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok lombok = new HelloLombok();
        lombok.setName("ag");

        String name = lombok.getName();
        System.out.println(name);
        System.out.println(lombok);
    }
}
