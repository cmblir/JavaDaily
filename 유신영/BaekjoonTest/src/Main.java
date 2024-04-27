public class Main {
    static class Parent {
        int a;
        int b;
        void config(int a, int b) {
            this.a = a;
            this.b = b;
        }
        int getCount() {
            return (a + b);
        }
    }

    static class Child extends Parent {
        int a = 3;
        int b = 3;
        Child(int a) {
            super.config(a, a + 1);
        }
        int getCount() {
            return (a * b);
        }
    }
    public static void main(String[] args) {
        Parent parent = new Child(10);
        Child child = new Child(10);
        System.out.println(parent.getCount());
        System.out.println(child.getCount());
    }
}