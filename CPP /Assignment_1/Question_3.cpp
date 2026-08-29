//============================================================================
// Name        : Question_3.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <string>
#include <iomanip>

using namespace std;
class Employee
{
private:

    // Private data members
    int empId;
    string name;
    string department;
    char grade;
    double basicSalary;
    bool isActive;

    // Static variable
    static int employeeCount;
public:

    // Constructor
    Employee()
    {
        empId = 1000 + employeeCount + 1;

        employeeCount++;

        name = "";
        department = "";
        grade = 'D';
        basicSalary = 10001;
        isActive = true;
    }


    // -----------------------------
    // Set Name
    // -----------------------------

    void setName(const string& n)
    {
        if (n.empty())
        {
            cout << "ERROR: Name cannot be empty." << endl;
        }
        else
        {
            name = n;
        }
    }


    // -----------------------------
    // Set Department
    // -----------------------------

    void setDepartment(const string& dept)
    {
        if (dept == "Engineering" ||
            dept == "HR" ||
            dept == "Finance" ||
            dept == "Operations")
        {
            department = dept;
        }
        else
        {
            cout << "ERROR: '" << dept
                 << "' is not a registered department."
                 << endl;
        }
    }


    // -----------------------------
    // Set Grade
    // -----------------------------

    void setGrade(char g)
    {
        if (g == 'A' ||
            g == 'B' ||
            g == 'C' ||
            g == 'D')
        {
            grade = g;
        }
        else
        {
            cout << "ERROR: Invalid grade '"
                 << g
                 << "'. Accepted values: A, B, C, D."
                 << endl;
        }
    }


    // -----------------------------
    // Set Basic Salary
    // -----------------------------

    void setBasicSalary(double salary)
    {
        if (salary > 10000 && salary < 500000)
        {
            basicSalary = salary;
        }
        else
        {
            cout << "ERROR: Salary must be between "
                 << "Rs.10,000 and Rs.5,00,000. "
                 << "Value rejected." << endl;
        }
    }


    // -----------------------------
    // Deactivate Employee
    // -----------------------------

    void deactivate()
    {
        isActive = false;
    }


    // -----------------------------
    // Getters
    // -----------------------------

    int getEmpId() const
    {
        return empId;
    }


    string getName() const
    {
        return name;
    }


    string getDepartment() const
    {
        return department;
    }


    char getGrade() const
    {
        return grade;
    }


    double getBasicSalary() const
    {
        return basicSalary;
    }


    bool getIsActive() const
    {
        return isActive;
    }


    // -----------------------------
    // Calculate Allowances
    // -----------------------------

    double computeAllowances() const
    {
        double allowance = 0;

        if (grade == 'A')
        {
            allowance = basicSalary * 0.40;
        }
        else if (grade == 'B')
        {
            allowance = basicSalary * 0.30;
        }
        else if (grade == 'C')
        {
            allowance = basicSalary * 0.20;
        }
        else if (grade == 'D')
        {
            allowance = basicSalary * 0.10;
        }

        return allowance;
    }


    // -----------------------------
    // Calculate Gross Salary
    // -----------------------------

    double computeGrossSalary() const
    {
        return basicSalary + computeAllowances();
    }


    // -----------------------------
    // Calculate Tax
    // -----------------------------

    double computeTax() const
    {
        double gross = computeGrossSalary();

        double tax = 0;

        if (gross <= 50000)
        {
            tax = 0;
        }
        else if (gross <= 100000)
        {
            tax = (gross - 50000) * 0.10;
        }
        else
        {
            tax = 5000 + (gross - 100000) * 0.20;
        }

        return tax;
    }


    // -----------------------------
    // Calculate Net Salary
    // -----------------------------

    double computeNetSalary() const
    {
        return computeGrossSalary() - computeTax();
    }


    // -----------------------------
    // Accept Details
    // -----------------------------

    void acceptDetails()
    {
        string inputName;
        string inputDepartment;
        char inputGrade;
        double inputSalary;


        cout << "\nEnter name: ";
        getline(cin >> ws, inputName);

        setName(inputName);


        cout << "Enter department: ";
        getline(cin, inputDepartment);

        setDepartment(inputDepartment);


        cout << "Enter grade: ";
        cin >> inputGrade;

        setGrade(inputGrade);


        cout << "Enter basic salary: ";
        cin >> inputSalary;

        setBasicSalary(inputSalary);
    }


    // -----------------------------
    // Print Payslip
    // -----------------------------

    void printPayslip() const
    {
        cout << "\n============================================"
             << endl;

        cout << " EMPLOYEE PAYSLIP — AUG 2026"
             << endl;

        cout << "============================================"
             << endl;

        cout << "Emp ID : "
             << empId << endl;

        cout << "Name : "
             << name << endl;

        cout << "Department : "
             << department << endl;

        cout << "Grade : "
             << grade << endl;

        cout << "Status : "
             << (isActive ? "Active" : "Inactive")
             << endl;

        cout << "--------------------------------------------"
             << endl;

        cout << fixed << setprecision(2);

        cout << "Basic Salary : Rs. "
             << basicSalary << endl;

        cout << "Allowances : Rs. "
             << computeAllowances() << endl;

        cout << "Gross Salary : Rs. "
             << computeGrossSalary() << endl;

        cout << "--------------------------------------------"
             << endl;

        cout << "Tax Deduction : Rs. "
             << computeTax() << endl;

        cout << "Net Salary : Rs. "
             << computeNetSalary() << endl;

        cout << "============================================"
             << endl;
    }


    // -----------------------------
    // Static Employee Count
    // -----------------------------

    static int getEmployeeCount()
    {
        return employeeCount;
    }
};


// Define static variable
int Employee::employeeCount = 0;


// ============================================
// MAIN
// ============================================

int main()
{
    // One object on stack
    Employee e1;

    // Two objects on heap
    Employee* e2 = new Employee();
    Employee* e3 = new Employee();


    // Accept details
    e1.acceptDetails();

    e2->acceptDetails();

    e3->acceptDetails();


    /*
       These lines are intentionally commented.

       They will produce compiler errors because
       empId and basicSalary are private members.

       Private data can only be accessed through
       public member functions such as getters/setters.

       e1.empId = 999;
       e1.basicSalary = -1000;
    */


    // Print payslips
    e1.printPayslip();

    e2->printPayslip();

    e3->printPayslip();


    // Deactivate employee 3
    e3->deactivate();


    if (!e3->getIsActive())
    {
        cout << e3->getName()
             << " is no longer active. "
             << "Payroll skipped."
             << endl;
    }


    // Display employee count
    cout << "Total Employees : "
         << Employee::getEmployeeCount()
         << endl;


    // Delete heap objects
    delete e2;
    delete e3;


    return 0;
}
