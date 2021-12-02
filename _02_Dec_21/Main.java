public class Main {
    public static void main(String[] args) {

        // create databsae
        StudentDatabase myDB = new StudentDatabase("Test database");

        // Add 4 students
        myDB.addStudent("Hari", "cse");
        myDB.addStudent("Surya", "cse");
        myDB.addStudent("Edward", "cse");
        myDB.addStudent("Chandru", "cse");

        // shows error
        myDB.addStudent("Surya", "cse");

        // print
        myDB.print();

        // check if sortable and print
        myDB.sortAndPrint();

        // fetch and print student
        myDB.getStudent("Hari").print();

        // delete student with name
        myDB.deleteStudent("Hari");
        myDB.print();

        // delete student with id
        myDB.deleteStudent(4);
        myDB.print();

    }
}
