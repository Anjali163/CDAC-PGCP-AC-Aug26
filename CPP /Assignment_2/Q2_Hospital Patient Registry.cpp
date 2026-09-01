//============================================================================
// Name        : Q2_Hospital.cpp
// Author      : Anjali Nanavare
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <string>
using namespace std;

class Patient{
private:

	int patientId;
	string name;
	int age;
	string ward;
	const string bloodGroup;


public:



// Constructor 1 — Default: id=0, name="Unknown", age=0, ward="General",bloodGroup="O+"
Patient(): patientId(0), name("Unknown"),  age(0),  ward("General"), bloodGroup("O+")
	    {
	 cout << "[Constructor] Default patient registered."<< endl;

    }


// Constructor 2 — Emergency admission: only id and name known
Patient(int id, const string& name): patientId(id), name(name),age(0), ward("Emergency"),bloodGroup("O+")
    {
        cout << "[Constructor] Emergency: "
             << this->name
             << endl;
    }

// Constructor 3 — Full admission details
Patient(int id, const string& name, int age, const string& ward, const string& bg) : patientId(id),
        name(name),age(age),ward(ward), bloodGroup(bg)
  {
      cout << "[Constructor] Full admission: "
           << this->name
           << endl;
  }



// Destructor — print "Patient <name> discharged." when object is destroyed
~Patient(){
    cout << "[Destructor] Patient "<< name<< " discharged." <<endl;
}


void displayRecord() const
   {
       cout << "\nPatient Record:\n";

       cout << "ID        : " << patientId << endl;
       cout << "Name      : " << name << endl;
       cout << "Age       : " << age << endl;
       cout << "Ward      : " << ward << endl;
       cout << "Blood Grp : " << bloodGroup << endl;
   }

void transferWard(const string& newWard)
    {
        cout << "Ward Transfer: "
             << name
             << " -> "
             << newWard
             << endl;

        ward = newWard;
    }
};



int main()
{
    cout << "===== HOSPITAL PATIENT REGISTRY =====\n\n";
    cout << "Creating stack patients...\n\n";

       Patient patient1(
           1001,
           "Meera Joshi",
           34,
           "Cardiology",
           "B+"
       );

       Patient patient2(
           1002,
           "Raj Patel"
       );

       Patient patient3;

       patient1.displayRecord();
       patient2.displayRecord();
       patient3.displayRecord();

       cout << "\n\n===== DYNAMIC PATIENT ARRAY =====\n";

          Patient* patients = new Patient[4];

          for (int i = 0; i < 4; i++)
             {
                 patients[i].displayRecord();
             }

          cout << "\n===== WARD TRANSFER =====\n";

             patients[1].transferWard("ICU");

             cout << "\n===== DELETE DYNAMIC ARRAY =====\n";

                delete[] patients;
                cout << "\n===== END OF MAIN =====\n";

                   return 0;

}




















