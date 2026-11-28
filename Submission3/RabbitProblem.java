
import java.util.Scanner;

public class RabbitProblem {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int first = 1;
        int second = 1;
        int next;

        System.out.print("Enter number of months: ");
        int months = input.nextInt();

        if (months <= 0) {
            System.out.println("Invalid number of months");
        } else {

            System.out.println("Rabbit pairs:");

            for (int i = 1; i <= months; i++) {

                System.out.print(first + " ");

                next = first + second;
                first = second;
                second = next;
            }
        }

        input.close();
    }
}
