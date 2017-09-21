import java.util.Random;

public class Num {
    public Integer calcNum() {
    Random random =  new Random();
    int n = 100 + random.nextInt(900);
        System.out.println("Случайное число " + n);
    int sum = 0;
        while(n != 0){
        sum = sum + (n % 10);
        n/=10;
    }
        return sum;
}
}
