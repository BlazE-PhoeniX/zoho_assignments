public class Student extends Row implements Printable {
    private final String name;
    private final String dept;

    private Student(int id, String name, String dept) {
        setId(id);
        this.dept = dept;
        this.name = name;
    }

    public static Student createStudent(int id, String name, String dept) {
        return new Student(id, name, dept);
    }

    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }

    @Override
    public void print() {
        System.out.println("Student {" +
                "\n\tId: " + getId() +
                "\n\tName: " + getName() +
                "\n\tDept: " + getDept() +
                "\n}" +
                "\n");
    }

    @Override
    public void sortAndPrint() {
        print();
    }

    @Override
    public int compareTo(Row student) {
        return name.compareTo(((Student) student).getName());
    }
}
