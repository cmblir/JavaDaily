package pack;
import pack.a.*;
public class PackageMain1 {
    public static void main(String[] args) {
        Data data = new Data();
        User userA = new User(); // package import
        pack.b.User userb = new pack.b.User();
    }
}
