package exercise.tracker;

import java.util.Scanner;

/**
 *
 * @author Your Name Here
 */
public class EmployeeApp {

    EmployeeDAO empList = new EmployeeDAO();
    Scanner sc = new Scanner(System.in);

    public EmployeeApp() {
        menuLoop();
    }

    private void menuLoop() {
        int id;
        int memnum, exminutes;
        String homePhone, extype, comment, dtime;
        double salary;
        String choice = "1";
        while (!choice.equals("0")) {
            System.out.println("\nEmployee App");
            System.out.println("0 = Quit");
            System.out.println("1 = List All Records");
            System.out.println("2 = Create New Record");
            System.out.println("3 = Retrieve Record");
            System.out.println("4 = Update Record");
            System.out.println("5 = Delete Record");
            choice = Validator.getLine(sc, "Number of choice: ", "^[0-5]$");

            switch (choice) {
                case "1":
                    System.out.println(empList.toString());
                    break;
                case "2":
                    id = Validator.getInt(sc, "ID: ");
                    memnum = Validator.getInt(sc, "Member ID: ");
                    dtime = Validator.getLine(sc, "Enter Date and Time: ");
                    extype = Validator.getLine(sc, "Exercise Type: ");
                    exminutes = Validator.getInt(sc, "Exercise Minutes: ");
                    comment = Validator.getLine(sc, "Comments: ");
                    empList.createRecord(new Employee(id, memnum, dtime, extype, exminutes, comment));
                    break;
                case "3":
                    id = Validator.getInt(sc, "ID to retrieve: ");
                    System.out.println(empList.retrieveRecord(id));
                    break;
                case "4":
                    id = Validator.getInt(sc, "Employee ID to update: ");
                    memnum = Validator.getInt(sc, "Member ID: ");
                    dtime = Validator.getLine(sc, "Enter Date and Time: ");
                    extype = Validator.getLine(sc, "Exercise Type: ");
                    exminutes = Validator.getInt(sc, "Exercise Minutes: ");
                    comment = Validator.getLine(sc, "Comments: ");
                    empList.updateRecord(new Employee(id, memnum, dtime, extype, exminutes, comment));
                    break;
                case "5":
                    id = Validator.getInt(sc, "ID to delete: ");
                    System.out.println(empList.retrieveRecord(id));
                    String ok = Validator.getLine(sc, "Deleter this record? (y/n) ", "^[yYnN]$");
                    if (ok.equalsIgnoreCase("Y")) {
                        empList.deleteRecord(id);
                    }
                    break;
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new EmployeeApp();
    }
}
