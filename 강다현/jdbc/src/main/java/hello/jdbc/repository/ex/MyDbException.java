package hello.jdbc.repository.ex;

//runtimeException을 상속 받았기에 이는 런타임(언체크)예외가 된다.
public class MyDbException extends RuntimeException{
    public MyDbException(){

    }
    public MyDbException(String message){
        super(message);
    }
    public MyDbException(String message, Throwable cause){
        super(message, cause);
    }
    public MyDbException(Throwable cause){
        super(cause);
    }
}
