import java.util.Scanner;

public class practical2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter start: ");
        int start = input.nextInt();
        System.out.print("Enter end: ");
        int end = input.nextInt();
        if (start <= end) {
            int sum = 0;
            for (int counter = start; counter <= end; counter++) {
                sum += counter;
            }
            System.out.println(sum);
        } else {
            System.out.println("Error: The start is greater than the end.");
        }
    }
}
