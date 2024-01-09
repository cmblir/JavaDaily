package hello.core.singleton;

public class SingletonService {
    /*
    Singleton Pattern
    클래스의 인스턴스가 딱 1개만 생성되는 것을 보장하는 디자인 패턴이다. ( 객체 인스턴스를 2개 이상 생성하지 못하도록 막음 )
    즉, 생성자를 private을 이용해서 외부에서 접근할 수 없도록 해야 한다.
     */

    private static final SingletonService instance = new SingletonService();
    private SingletonService(){

    }
    public static SingletonService getInstance(){
        return instance;
    }
    public void loginc(){
        System.out.println("싱글톤 객체 로직 호출");
    }

}
