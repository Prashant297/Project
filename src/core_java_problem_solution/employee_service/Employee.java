package core_java_problem_solution.employee_service;

public class Employee {
     private int employeeId;
    private String name;
    private String branch;
    private double rating;
    private boolean comTansport;

    public Employee() {

    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isComTansport() {
        return comTansport;
    }

    public void setComTansport(boolean comTansport) {
        this.comTansport = comTansport;
    }

}
