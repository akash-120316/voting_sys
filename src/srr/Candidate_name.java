// import java.util.Scanner;

// public class Candidate_name {


//     String global;

//     public void initialise(String a) {
//         global = a;
//     }

//     public void update(String a) {
//         global = a;
//     }

//     public String display() {
//         return global;
//     }

//     public void delete() {
//         global = "";
//     }

//     public static void main(String[] args) {
// //        Main ob = new Main();
//         Candidate_name os = new Candidate_name();
//         Scanner sc = new Scanner(System.in);
//         while (true) {
//             int choice = sc.nextInt();
//             sc.nextLine();
//             switch (choice) {
//                 case 1:
//                     String num = sc.nextLine();
//                     os.initialise(num);
//                     break;
//                 case 2:
//                     num = sc.nextLine();
//                     os.update(num);
//                     break;
//                 case 3:

//                     System.out.println(os.display());
//                     break;
//                 case 4:
//                     os.delete();
//                     break;
//                 case 5:
//                     sc.close();
//                     break;
//                 default:
//                     System.out.println("Enter valid");
//                     break;
//             }
//         }
//     }
// }
