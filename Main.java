import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();

        int choice = 0;

        while (choice != 4) {

            System.out.println();
            System.out.println("===== Student Management System =====");
            System.out.println("1. Ajouter un étudiant");
	    System.out.println("2. Afficher les étudiants");
	    System.out.println("3. Rechercher un étudiant");
	    System.out.println("4. Quitter");

            System.out.print("Choisissez une option : ");
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {

                System.out.print("Nom de l'étudiant : ");
                String name = scanner.nextLine();

                System.out.print("Age de l'étudiant : ");
                int age = scanner.nextInt();

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

    		System.out.println("Au revoir !");

        } else {

              	System.out.println("Option invalide.");
            	}
        }

        scanner.close();
    }
}