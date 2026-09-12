import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();

        StudentManager manager = new StudentManager();

        int choice = 0;

        while (choice != 6) {

            System.out.println();
            System.out.println("===== Student Management System =====");
            System.out.println("1. Ajouter un étudiant");
            System.out.println("2. Afficher les étudiants");
            System.out.println("3. Rechercher un étudiant");
            System.out.println("4. Supprimer un étudiant");
            System.out.println("5. Modifier un étudiant");
            System.out.println("6. Quitter");

            System.out.print("Choisissez une option : ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Veuillez entrer un nombre entre 1 et 6.");
                scanner.nextLine();
                continue;
            }

            if (choice == 1) {

                String name;

                while (true) {

                    System.out.print("Nom de l'étudiant : ");
                    name = scanner.nextLine().trim();

                    if (!name.isEmpty()) {
                        break;
                    }

                    System.out.println("Le nom ne peut pas être vide.");
                }

                int age;

                while (true) {

                    System.out.print("Age de l'étudiant : ");

                    if (scanner.hasNextInt()) {
                        age = scanner.nextInt();
                        scanner.nextLine();

                        if (age >= 1 && age <= 120) {
                            break;
                        }

                        System.out.println(
                                "Veuillez entrer un âge entre 1 et 120."
                        );

                    } else {
                        System.out.println("Veuillez entrer un âge valide.");
                        scanner.nextLine();
                    }
                }

                Student student = new Student(name, age);

                manager.addStudent(student);

                System.out.println();
                System.out.println("Étudiant ajouté !");

            } else if (choice == 2) {

                System.out.println();
                System.out.println("Liste des étudiants :");

                manager.displayStudents();

            } else if (choice == 3) {

                System.out.print("Nom de l'étudiant à rechercher : ");
                String searchName = scanner.nextLine();

                manager.searchStudent(searchName);

            } else if (choice == 4) {

                System.out.print("Nom de l'étudiant à supprimer : ");
                String deleteName = scanner.nextLine();

                manager.deleteStudent(deleteName);

            } else if (choice == 5) {

                System.out.print("Nom de l'étudiant à modifier : ");
                String editName = scanner.nextLine();

                int newAge;

                while (true) {

                    System.out.print("Nouvel âge : ");

                    if (scanner.hasNextInt()) {
                        newAge = scanner.nextInt();
                        scanner.nextLine();

                        if (newAge >= 1 && newAge <= 120) {
                            break;
                        }

                        System.out.println(
                                "Veuillez entrer un âge entre 1 et 120."
                        );

                    } else {
                        System.out.println(
                                "Veuillez entrer un âge valide."
                        );
                        scanner.nextLine();
                    }
                }

                manager.editStudent(editName, newAge);

            } else if (choice == 6) {

                System.out.println("Au revoir !");

            } else {

                System.out.println("Option invalide.");
            }
        }

        scanner.close();
    }
}