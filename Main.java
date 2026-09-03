import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();

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
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {

                System.out.print("Nom de l'étudiant : ");
                String name = scanner.nextLine();

                System.out.print("Age de l'étudiant : ");
                int age = scanner.nextInt();
                scanner.nextLine();

                Student student = new Student(name, age);

                students.add(student);

                System.out.println();
                System.out.println("Étudiant ajouté !");

            } else if (choice == 2) {

                System.out.println();
                System.out.println("Liste des étudiants :");

                if (students.isEmpty()) {
                    System.out.println("Aucun étudiant enregistré.");
                } else {

                    for (Student student : students) {
                        System.out.println(
                                "Nom : " + student.getName() +
                                        " | Age : " + student.getAge()
                        );
                    }
                }

            } else if (choice == 3) {

                System.out.print("Nom de l'étudiant à rechercher : ");
                String searchName = scanner.nextLine();

                boolean found = false;

                for (Student student : students) {

                    if (student.getName().equalsIgnoreCase(searchName)) {

                        System.out.println();
                        System.out.println("Étudiant trouvé !");
                        System.out.println("Nom : " + student.getName());
                        System.out.println("Age : " + student.getAge());

                        found = true;
                    }
                }

                if (!found) {
                    System.out.println("Étudiant introuvable.");
                }

            } else if (choice == 4) {

                System.out.print("Nom de l'étudiant à supprimer : ");
                String deleteName = scanner.nextLine();

                boolean deleted = false;

                for (int i = 0; i < students.size(); i++) {

                    if (students.get(i).getName().equalsIgnoreCase(deleteName)) {

                        students.remove(i);

                        System.out.println("Étudiant supprimé !");
                        deleted = true;
                        break;
                    }
                }

                if (!deleted) {
                    System.out.println("Étudiant introuvable.");
                }

            } else if (choice == 5) {

                System.out.print("Nom de l'étudiant à modifier : ");
                String editName = scanner.nextLine();

                boolean edited = false;

                for (Student student : students) {

                    if (student.getName().equalsIgnoreCase(editName)) {

                        System.out.print("Nouvel âge : ");
                        int newAge = scanner.nextInt();
                        scanner.nextLine();

                        student.setAge(newAge);

                        System.out.println("Étudiant modifié !");
                        edited = true;
                        break;
                    }
                }

                if (!edited) {
                    System.out.println("Étudiant introuvable.");
                }

            } else if (choice == 6) {

                System.out.println("Au revoir !");

            } else {

                System.out.println("Option invalide.");
            }
        }

        scanner.close();
    }
}