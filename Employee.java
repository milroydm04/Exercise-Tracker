package exercise.tracker;

import java.util.logging.Logger;

/**
 *
 * @author Your Name Here
 */
public class Employee {

    private int empId;
    private String dtime;
    private int memnum;
    private String extype;
    private int exminutes;
    private String comment;

    public Employee() {
        empId = 0;
        dtime = "";
        memnum = 0;
        extype = "";
        exminutes = 0;
        comment = "";
    }

    public Employee(int empId, int memnum, String dtime,  String extype, int exminutes, String comment) {
        this.empId = empId;
        this.dtime = dtime;
        this.memnum = memnum;
        this.extype = extype;
        this.exminutes = exminutes;
        this.comment = comment;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getDtime() {
        return dtime;
    }

    public void setDtime(String dtime) {
        this.dtime = dtime;
    }

    public int getMemnum() {
        return memnum;
    }

    public void setMemnum(int memnum) {
        this.memnum = memnum;
    }

    public String getExtype() {
        return extype;
    }

    public void setExtype(String extype) {
        this.extype = extype;
    }

    public int getExminutes() {
        return exminutes;
    }

    public void setExminutes(int exminutes) {
        this.exminutes = exminutes;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Employee{" + "empId=" + empId + ", dtime=" + dtime + ", memnum=" + memnum + ", extype=" + extype + ", exminutes=" + exminutes + ", comment=" + comment + '}';
    }
}

