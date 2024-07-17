package Collections;

public class MyPratice {
    public static void main(String[] args) {
        String cidrString = "/172.0.1.0/22/";
        String[] splits = cidrString.split("/", -2);
        System.out.println("splits " + splits + ", length " + splits.length);
    }
}
