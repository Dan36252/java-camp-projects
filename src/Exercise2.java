import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int mins = sc.nextInt();
            int days = mins/1440;
            int hours = (mins%1440)/60;
            mins = (mins%1440)%60;
            System.out.println(days + "d, " + hours + "h, " + mins + "m");
        }
    }
}
