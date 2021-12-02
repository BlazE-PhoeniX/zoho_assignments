import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class StudentDatabase extends Database<Student> implements Sortable<Student> {
    public StudentDatabase(String name) {
        super(name);
    }

    public int getNoOfStudents() {
        return super.getLength();
    }

    public boolean addStudent(String name, String dept) {
        Student student = getStudent(name);
        if(Objects.isNull(student)) {
            int id = getNoOfStudents() + 1;
            while(!super.addRow(Student.createStudent(id, name, dept))) {
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
        return super.getRow(id);
    }

    public Student getStudent(String name) {
        for(Student r: rows) {
            if(r.getName().equals(name)) {
                return r;
            }
        }
        return null;
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
        for(Student r: rows) {
            if(r.getName().equals(name)) {
                rows.remove(r);
                System.out.println("Success: Student deleted successfully\n");
                return true;
            }
        }
        System.out.println("Error: Student not found\n");
        return false;
    }

    private void printDatabase(ArrayList<Student> rows) {
        System.out.println("Database name: " + getName());
        System.out.println("----------------------------");
        System.out.println("  id  |  name  |  dept  ");
        System.out.println("----------------------------");
        for(Student st: rows) {
            System.out.printf("  %2d  |  %s  |  %s  \n", st.getId(), st.getName(), st.getDept());
        }
        System.out.println("----------------------------\n");

    }

    @Override
    public void print() {
        printDatabase(super.rows);
    }

    @Override
    public void sortAndPrint() {
        printDatabase(cloneSort());
    }

    @Override
    public void sort() {
        Collections.sort(super.rows);
    }

    @Override
    public ArrayList<Student> cloneSort() {
        ArrayList<Student> clone =  new ArrayList<>(super.rows);
        Collections.sort(clone);
        return clone;
    }
}
