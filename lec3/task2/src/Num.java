import java.util.Random;

public class Num {
    private Integer num;
    private Integer sumDigits;

    public Integer getRandomNum() {
        Random random = new Random();
         num = 100 + random.nextInt(899);
        return num;
    }

    public void calcSum (Integer num) {
      sumDigits = 0;
        while(num != 0){
            sumDigits = sumDigits + (num % 10);
            num/=10;
    }
        System.out.print(toString());
}

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Random num: ").append(num).append("\n");
        sb.append("Sum of digits: ").append(sumDigits);
        return sb.toString();
    }
}
