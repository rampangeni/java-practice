package LeetCode75;

/*
 * Floyd's Cycle-Finding Algorithm
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while (fastRunner != 1 && fastRunner != slowRunner) {
            System.out.println(slowRunner + "=>" + fastRunner);
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }

        return (fastRunner == 1);
    }

    public int getNext(int n) {
        int sum = 0;
        while(n > 0) {
            int digit = n%10;
            sum += (digit*digit);
            n = n/10;
        }
        return sum;
    }

    public static void main(String[] args) {
        HappyNumber hn = new HappyNumber();
        boolean isHappy = hn.isHappy(7);
        System.out.println(isHappy);
    }
}
