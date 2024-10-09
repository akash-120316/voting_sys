import java.util.Scanner;
public class Main {
    int global;

    public void initialise(int a) {
        global = a;
    }

    public void update(int a) {
        global = a;
    }

    public int display() {
        return global;
    }

    public void delete() {
        global = 0;
    }

    public static void main(String[] args) {
        Main ob = new Main();

        Scanner sc = new Scanner(System.in);
        while (true) {
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    int num = sc.nextInt();
                    ob.initialise(num);
                    break;
                case 2:
                    num = sc.nextInt();
                    ob.initialise(num);
                    break;
                case 3:
                    num = sc.nextInt();
                    System.out.println(ob.display());
                    break;
                case 4:
                    ob.delete();
                    break;
                case 5:
                    sc.close();
                    break;
                default:
                    System.out.println("Enter valid");
                    break;
            }
        }
    }
}