package practise;

public class EmployeeData {

    private double salary;
    private int hours;

    // Getter and Setter for salary
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Getter and Setter for hours
    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void getInfo(double salary, int hours) {
        setSalary(salary);
        setHours(hours);
    }
    
    public void addSal() {
        if (getSalary() < 500) {
            setSalary(getSalary() + 10);
        }
    }
   
    public void addWork() {
        if (getHours() > 6) {
            setSalary(getSalary() + 5);
        }
    }
    
    public static void main(String[] args){

        ConsoleInput input = new ConsoleInput();

        EmployeeData emp = new EmployeeData();

        System.out.print("Enter salary: ");
        double salary = input.getDouble();

        System.out.print("Enter number of working hours per day: ");
        int hours = input.getInt();

        emp.getInfo(salary, hours);

        emp.addSal();

        emp.addWork();

        System.out.println("Final Salary = " + emp.getSalary());
    }
}