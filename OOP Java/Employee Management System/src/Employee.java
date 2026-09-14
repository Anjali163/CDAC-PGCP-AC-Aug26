package practise;

import java.util.Arrays;
import java.util.Comparator;

// ABSTRACT EMPLOYEE CLASS

abstract class Employee {

    protected String name;
    protected String address;
    protected int age;
    protected boolean gender;
    protected float basicSalary;


    // Constructor
    public Employee(String name, String address, int age,
                    boolean gender, float basicSalary) {

        super();

        this.name = name;
        this.address = address;
        setAge(age);
        this.gender = gender;
        this.basicSalary = basicSalary;
    }


    
    // GETTER / SETTER - NAME
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    
    // GETTER / SETTER - ADDRESS
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    // GETTER / SETTER - AGE
   
    
    public int getAge() {
        return age;
    }

    public void setAge(int age) {

        if (age < 18 || age > 65)
            this.age = 21;
        else
            this.age = age;
    }


    
    // GETTER / SETTER - GENDER
    

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }


    
    // GETTER / SETTER - BASIC SALARY
   
    
    public float getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(float basicSalary) {
        this.basicSalary = basicSalary;
    }


    
    // ABSTRACT DESIGNATION
    

    public abstract String getDesignation();


    
    // DISPLAY
   
    
    public void display() {

        System.out.println("--------------------------------------");

        System.out.println("Name         : " + name);
        System.out.println("Address      : " + address);
        System.out.println("Age          : " + age);
        System.out.println("Gender       : "
                + (gender ? "Male" : "Female"));
        System.out.println("Basic Salary : " + basicSalary);
        System.out.println("Designation  : " + getDesignation());
    }
}



// MANAGER CLASS


class Manager extends Employee {

    protected float hra;


    // Constructor
    public Manager(String name, String address, int age,
                   boolean gender, float basicSalary,
                   float hra) {

        super(name, address, age, gender, basicSalary);

        this.hra = hra;
    }


    // Getter
    public float getHra() {
        return hra;
    }


    // Setter
    public void setHra(float hra) {
        this.hra = hra;
    }


    // Override designation
    @Override
    public String getDesignation() {

        return "Manager";
    }


    // Override display
    @Override
    public void display() {

        super.display();

        System.out.println("HRA          : " + hra);

        System.out.println("--------------------------------------");
    }
}



// ENGINEER CLASS


class Engineer extends Employee {


    // Constructor
    public Engineer(String name, String address, int age,
                    boolean gender, float basicSalary) {

        super(name, address, age, gender, basicSalary);
    }


    // Override designation
    @Override
    public String getDesignation() {

        return "Engineer";
    }


    // Override display
    @Override
    public void display() {

        super.display();

        System.out.println("--------------------------------------");
    }
}



// SALES PERSON CLASS


class SalesPerson extends Employee {


    // Constructor
    public SalesPerson(String name, String address, int age,
                       boolean gender, float basicSalary) {

        super(name, address, age, gender, basicSalary);
    }


    // Override designation
    @Override
    public String getDesignation() {

        return "Sales Person";
    }


    // Override display
    @Override
    public void display() {

        super.display();

        System.out.println("--------------------------------------");
    }
}



// ENTRY CLASS


 class Entry {

    // Array of Employee references
    static Employee[] arrEmployee = new Employee[40];

    // Number of employees
    static int count = 0;


    
    // MAIN
    
    public static void main(String[] args) {

        int choice;

        do {

            System.out.println();
            System.out.println("======================================");
            System.out.println("      EMPLOYEE MANAGEMENT SYSTEM");
            System.out.println("======================================");

            System.out.println("1. Add");
            System.out.println("2. Display");
            System.out.println("3. Delete");
            System.out.println("4. Sort");

            System.out.println("======================================");

            System.out.println("Enter your choice");

            choice = ConsoleInput.getInt();


            switch (choice) {

                case 1:
                    addEmployee();
                    break;

                case 2:
                    displayEmployees();
                    break;

                case 3:
                    deleteEmployee();
                    break;

                case 4:
                    sortEmployee();
                    break;

                default:
                    System.out.println("Invalid choice");

            }

        } while (true);
    }


   
    // 1. ADD EMPLOYEE
   

    public static void addEmployee() {

        System.out.println();
        System.out.println("========== ADD EMPLOYEE ==========");

        System.out.println("1. Manager");
        System.out.println("2. Engineer");
        System.out.println("3. Sales Person");
        System.out.println("4. Exit");

        System.out.println("Enter your choice");

        int choice = ConsoleInput.getInt();


        if (choice == 4) {
            return;
        }


        if (choice < 1 || choice > 3) {

            System.out.println("Invalid choice");
            return;
        }


        if (count >= arrEmployee.length) {

            System.out.println("Employee array is full");
            return;
        }


        
        // COMMON DETAILS
       

        System.out.println("Enter the name");
        String name = ConsoleInput.getstring();


        System.out.println("Enter the address");
        String address = ConsoleInput.getstring();


        System.out.println("Enter the age");
        int age = ConsoleInput.getInt();


        System.out.println("Enter gender");
        System.out.println("true = Male");
        System.out.println("false = Female");

        System.out.println("Enter gender (M/F)");
        String genderInput = ConsoleInput.getstring();

        boolean gender;

        if (genderInput.equalsIgnoreCase("M"))
            gender = true;
        else
            gender = false;
        


        System.out.println("Enter the basic salary");
        float basicSalary = ConsoleInput.getFloat();


       
        // CREATE OBJECT ACCORDING TO CHOICE
      
        switch (choice) {

            case 1:

                System.out.println("Enter HRA");

                float hra = ConsoleInput.getFloat();


                arrEmployee[count] =
                        new Manager(
                                name,
                                address,
                                age,
                                gender,
                                basicSalary,
                                hra
                        );

                count++;

                System.out.println(
                        "Manager added successfully"
                );

                break;


            case 2:

                arrEmployee[count] =
                        new Engineer(
                                name,
                                address,
                                age,
                                gender,
                                basicSalary
                        );

                count++;

                System.out.println(
                        "Engineer added successfully"
                );

                break;


            case 3:

                arrEmployee[count] =
                        new SalesPerson(
                                name,
                                address,
                                age,
                                gender,
                                basicSalary
                        );

                count++;

                System.out.println(
                        "Sales Person added successfully"
                );

                break;
        }
    }


   
    // 2. DISPLAY EMPLOYEE
    

    public static void displayEmployees() {

        System.out.println();
        System.out.println("========== DISPLAY EMPLOYEES ==========");


        if (count == 0) {

            System.out.println("No employees available");

            return;
        }


        for (int i = 0; i < count; i++) {

            System.out.println();
            System.out.println("Employee " + (i + 1));

            /*
             * Runtime Polymorphism
             *
             * arrEmployee is Employee reference
             * but actual object can be:
             *
             * Manager
             * Engineer
             * SalesPerson
             */

            arrEmployee[i].display();
        }
    }


   
    // 3. DELETE EMPLOYEE
    
    public static void deleteEmployee() {

        System.out.println();
        System.out.println("========== DELETE EMPLOYEE ==========");


        if (count == 0) {

            System.out.println("No employees available");

            return;
        }


        System.out.println("Enter employee name to delete");

        String name = ConsoleInput.getstring();


        int index = -1;


       
        // SEARCH EMPLOYEE
        

        for (int i = 0; i < count; i++) {

            if (arrEmployee[i]
                    .getName()
                    .equalsIgnoreCase(name)) {

                index = i;

                break;
            }
        }


        
        // EMPLOYEE NOT FOUND
        
        
        if (index == -1) {

            System.out.println("Employee not found");

            return;
        }


        
        // SHIFT ARRAY ELEMENTS
        
        for (int i = index; i < count - 1; i++) {

            arrEmployee[i] = arrEmployee[i + 1];
        }


        // Remove last duplicate reference
        arrEmployee[count - 1] = null;

        count--;


        System.out.println(
                "Employee deleted successfully"
        );
    }


   
    // 4. SORT
   

    public static void sortEmployee() {

        if (count == 0) {

            System.out.println("No employees available");

            return;
        }


        while (true) {

            System.out.println();
            System.out.println("========== SORT ==========");

            System.out.println("a. By Name Ascending");
            System.out.println("b. By Name descending");
            System.out.println("c. By Designation");
            System.out.println("d. Exit");


            System.out.println("Enter your choice");

            String choice = ConsoleInput.getstring();


            
            // NAME ASCENDING
           
            if (choice.equalsIgnoreCase("a")) {

                Arrays.sort(
                        arrEmployee,
                        0,
                        count,
                        Comparator.comparing(
                                Employee::getName,
                                String.CASE_INSENSITIVE_ORDER
                        )
                );


                System.out.println(
                        "Sorted by Name Ascending"
                );

                displayEmployees();
            }


            
            // NAME DESCENDING
            

            else if (choice.equalsIgnoreCase("b")) {

                Arrays.sort(
                        arrEmployee,
                        0,
                        count,
                        Comparator.comparing(
                                Employee::getName,
                                String.CASE_INSENSITIVE_ORDER
                        ).reversed()
                );


                System.out.println(
                        "Sorted by Name Descending"
                );

                displayEmployees();
            }


           
            // DESIGNATION
           

            else if (choice.equalsIgnoreCase("c")) {

               System.out.println(
                        "Sort by Designation is not implemented"
               );
           }


            
            // EXIT SORT MENU
           

            else if (choice.equalsIgnoreCase("d")) {

                return;
            }


            else {

                System.out.println("Invalid choice");
            }
        }
    }
}
