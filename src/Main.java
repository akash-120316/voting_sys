import java.util.Scanner;
public class Main {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(" enter 1 to add/update/delete/display user details");
            System.out.println(" enter 2 to add/update/delete/display candidate details");
            int choice = sc.nextInt();
            switch (choice) {

                    case 1:
                        AddUser.main(null);
                        break;
                    case 2:
                        AddCandidate.main(null);
                        break;
                    default:
                        System.out.println("Enter valid");
                        break;
            }
        }
        }


    }
