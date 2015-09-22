package exercise.tracker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Your Name Here
 */
public class EmployeeDAO {

    private final String fileName;
    protected final List<Employee> myList;

    public EmployeeDAO() {
        this("empdata.txt");
    }

    public EmployeeDAO(String fileName) {
        this.fileName = fileName;
        this.myList = new ArrayList<>();
        try {
            Files.createFile(Paths.get(fileName));
        } catch (FileAlreadyExistsException fae) {
            ;
        } catch (IOException ioe) {
            System.out.println("Create file error with " + ioe.getMessage());
        }
        readList();
    }

    public void createRecord(Employee employee) {
        myList.add(employee);
        writeList();
    }

    public Employee retrieveRecord(int id) {
        for (Employee employee : myList) {
            if (employee.getEmpId() == id) {
                return employee;
            }
        }
        return null;
    }

    public void updateRecord(Employee updatedEmployee) {
        for (Employee employee : myList) {
            if (employee.getEmpId() == updatedEmployee.getEmpId()) {
                employee.setMemnum(updatedEmployee.getMemnum());
                employee.setDtime(updatedEmployee.getDtime());
                employee.setExtype(updatedEmployee.getExtype());
                employee.setExminutes(updatedEmployee.getExminutes());
                employee.setComment(updatedEmployee.getComment());
                break;
            }
        }
        writeList();
    }

    public void deleteRecord(int id) {
        for (Employee employee : myList) {
            if (employee.getEmpId() == id) {
                myList.remove(employee);
                break;
            }
        }
        writeList();
    }

    public void deleteRecord(Employee employee) {
        myList.remove(employee);
        writeList();
    }

    protected void readList() {
        Path path = Paths.get(fileName);
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                int memnum = Integer.parseInt(data[1]);
                String dtime = data[2];
                String extype = data[3];
                int exminutes = Integer.parseInt(data[4]);
                String comment = data[5];
                Employee employee = new Employee(id, memnum, dtime, extype, exminutes, comment);
                myList.add(employee);
            }
        } catch (IOException ioe) {
            System.out.println("Read file error with " + ioe.getMessage());
        }
    }

    protected void writeList() {
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            for (Employee employee : myList) {
                writer.write(String.format("%d,%d,%s,%s,%d,%s\n",
                        employee.getEmpId(),
                        employee.getMemnum(),
                        employee.getDtime(),
                        employee.getExtype(),
                        employee.getExminutes(),
                        employee.getComment()));
            }
        } catch (IOException ioe) {
            System.out.println("Write file error with " + ioe.getMessage());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        myList.stream().forEach((employee) -> {
            sb.append(String.format("%d,%d,%s,%s,%d,%s\n", employee.getEmpId(),
                        employee.getMemnum(),
                        employee.getDtime(),
                        employee.getExtype(),
                        employee.getExminutes(),
                        employee.getComment()));
        });

        return sb.toString();
    }
}
