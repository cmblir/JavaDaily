package src.method.ex;

public class MethodExRef1 {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 3;
        getAverage(a,b,c);
        int x = 15;
        int y = 25;
        int z = 35;
        getAverage(x,y,z);

    }
    public static void getAverage(int a,int b ,int c){
        int sumVal = a + b + c;
        System.out.println("평균값 : " + (sumVal / 3));
    }
}

