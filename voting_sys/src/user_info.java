import java.util.Scanner;

public class user_info {


    String[] name = new String[4];
    int[] phone = new int[4];
    int[] age = new int[4];

    //int index=0;
    public void initialise(int id, String a, int p, int ag) {

        name[id] = a;
        phone[id] = p;
        age[id] = ag;


    }

    public void update(int id, String a, int p, int ag) {
        name[id] = a;
        phone[id] = p;
        age[id] = ag;
    }

    public void display(int i) {
        System.out.println("ID=" + i);
        System.out.println("ID=" + name[i]);
        System.out.println("ID=" + phone[i]);
        System.out.println("ID=" + age[i]);
    }

    public void delete(int i) {
        name[i] = "";
        phone[i] = 0;
        age[i] = 0;
    }

    public static void main(String[] args) {

        user_info ob = new user_info();

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter choice");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the id to register");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the name");
                    String name = sc.nextLine();
                    System.out.println("Enter the phone");
                    int phone = sc.nextInt();
                    System.out.println("Enter the age");
                    int age = sc.nextInt();
                    ob.initialise(id, name, phone, age);
                    break;
                case 2:
                    System.out.println("Enter the id to update");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the name");
                    name = sc.nextLine();
                    System.out.println("Enter the phone");
                    phone = sc.nextInt();
                    System.out.println("Enter the age");
                    age = sc.nextInt();
                    ob.update(id, name, phone, age);
                    break;
                case 3:

                    System.out.println("Enter the id to display");
                    id = sc.nextInt();

                    ob.display(id);
                    break;
                case 4:
                    System.out.println("Enter the id to delete");
                    id = sc.nextInt();

                    ob.delete(id);

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
