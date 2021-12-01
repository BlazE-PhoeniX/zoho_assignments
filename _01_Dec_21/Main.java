public class Main {
    public static void main(String[] args) {
        StudentDatabase myDB = new StudentDatabase("Test database");
        myDB.addStudent("Hari", "cse");
        myDB.addStudent("Surya", "cse");
        myDB.addStudent("Edward", "cse");
        myDB.addStudent("Chandru", "cse");
        myDB.printDatabase();
        myDB.getStudent("Hari").printStudent();
        myDB.deleteStudent("Hari");
        myDB.printDatabase();
    }
}
