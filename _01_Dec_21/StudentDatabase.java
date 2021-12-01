import java.util.Objects;

public class StudentDatabase extends Database<Student> {
    public StudentDatabase(String name) {
        super(name);
    }

    public int getNoOfStudents() {
        return super.getLength();
    }

    public boolean addStudent(String name, String dept) {
        Student student = super.getRow(name);
        if(Objects.isNull(student)) {
            int id = getNoOfStudents() + 1;
            while(!super.addRow(new Student(id, name, dept))) {
                id++;
            }
            System.out.println("Success: Student " + name + " added\n");
            return true;

        } else {
            System.out.println("Error: Student " + name + " exists, Try a different name.\n");
            return false;
        }
    }

    public Student getStudent(int id) {
        Student student = super.getRow(id);
        if(!Objects.isNull(student)) {
            System.out.println("Success: Student fetched successfully\n");
            return student;
        } else {
            System.out.println("Error: Student not found\n");
            return null;
        }
    }

    public Student getStudent(String name) {
        Student student = super.getRow(name);
        if(!Objects.isNull(student)) {
            System.out.println("Success: Student fetched successfully\n");
            return student;
        } else {
            System.out.println("Error: Student not found\n");
            return null;
        }
    }

    public boolean deleteStudent(int id) {
        if(super.deleteRow(id)) {
            System.out.println("Success: Student deleted successfully\n");
            return true;
        } else {
            System.out.println("Error: Student not found\n");
            return false;
        }
    }

    public boolean deleteStudent(String name) {
        if(super.deleteRow(name)) {
            System.out.println("Success: Student deleted successfully\n");
            return true;
        } else {
            System.out.println("Error: Student not found\n");
            return false;
        }
    }

    public void printDatabase() {
        System.out.println("Database name: " + name);
        System.out.println("----------------------------");
        System.out.println("  id  |  name  |  dept  ");
        System.out.println("----------------------------");
        for(Student st: super.rows) {
            System.out.printf("  %2d  |  %s  |  %s  \n", st.getId(), st.getName(), st.getDept());
        }
        System.out.println("----------------------------\n");
    }
}
