package assignments.zoho._01_Dec_21;

public class Student extends Row{
    private final String name;
    private final String dept;

    public Student(int id, String name, String dept) {
        super(id);
        this.dept = dept;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }

    public void printStudent() {
        System.out.println("Student {\n\tId: " + getId() + "\n\tName: " + getName() + "\n\tDept: " + getDept() + "\n}\n");
    }
}
