import java.util.ArrayList;

public class StudentManager {

    private ArrayList<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayStudents() {

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
    }

    public void searchStudent(String name) {

        boolean found = false;

        for (Student student : students) {

            if (student.getName().equalsIgnoreCase(name)) {

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
    }

    public void deleteStudent(String name) {

        boolean deleted = false;

        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).getName().equalsIgnoreCase(name)) {

                students.remove(i);

                System.out.println("Étudiant supprimé !");
                deleted = true;
                break;
            }
        }

        if (!deleted) {
            System.out.println("Étudiant introuvable.");
        }
    }

    public void editStudent(String name, int newAge) {

        boolean edited = false;

        for (Student student : students) {

            if (student.getName().equalsIgnoreCase(name)) {

                student.setAge(newAge);

                System.out.println("Étudiant modifié !");
                edited = true;
                break;
            }
        }

        if (!edited) {
            System.out.println("Étudiant introuvable.");
        }
    }
}