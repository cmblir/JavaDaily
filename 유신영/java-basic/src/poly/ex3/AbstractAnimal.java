package poly.ex3;

public abstract class AbstractAnimal {
    /*
    추상 클래스는 오버라이딩을 해서 쓰는 경우 유리하다.
    추상 메서드는 오버라이딩을 하지 않는 실수를 방지할 수 있다.

     */
    public abstract void sound();

    public void move() {
        System.out.println("동물이 움직입니다.");
    }
}
