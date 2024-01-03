package extends1.access.child;

import extends1.access.parent.Parent;

public class Child extends Parent{
    public void call() {
        publicValue = 1;
        protectedValue = 1;// 상속 관계 or 같은 패키지이므로 가능
        // defaultValue 불가능, 다른 패키지에 있으므로

        publicMethod();
        protectedMethod();

        printParent();
    }
}
