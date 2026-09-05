//============================================================================
// Name        : Q3_.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <string>
#include <iomanip>
#include <stdexcept>
#include <utility>

using namespace std;

class LedgerEntry {
private:
    string description;
    double* amounts;
    int days;

    static int totalEntries;

public:

    // Constructor
    LedgerEntry(const string& desc, int d)
        : description(desc), days(d)
    {
        if (days < 0) {
            throw invalid_argument("Days cannot be negative");
        }

        if (days > 0)
            amounts = new double[days];
        else
            amounts = nullptr;

        for (int i = 0; i < days; i++) {
            amounts[i] = 0.0;
        }

        totalEntries++;

        cout << "[LedgerEntry Created] "
             << description << " (" << days << " days)"
             << endl;
    }


    // Copy Constructor
    LedgerEntry(const LedgerEntry& other)
        : description(other.description),
          days(other.days)
    {
        if (days > 0)
            amounts = new double[days];
        else
            amounts = nullptr;

        for (int i = 0; i < days; i++) {
            amounts[i] = other.amounts[i];
        }

        totalEntries++;

        cout << "[Copy Constructor] "
             << description << endl;
    }


    // Move Constructor
    LedgerEntry(LedgerEntry&& other) noexcept
        : description(std::move(other.description)),
          amounts(other.amounts),
          days(other.days)
    {
        other.amounts = nullptr;
        other.days = 0;
        other.description = "";

        totalEntries++;

        cout << "[Move Constructor] Ownership transferred from: "
             << description << endl;
    }


    // Copy Assignment Operator
    LedgerEntry& operator=(const LedgerEntry& other)
    {
        if (this != &other) {

            double* newAmounts = nullptr;

            if (other.days > 0) {
                newAmounts = new double[other.days];

                for (int i = 0; i < other.days; i++) {
                    newAmounts[i] = other.amounts[i];
                }
            }

            delete[] amounts;

            description = other.description;
            amounts = newAmounts;
            days = other.days;
        }

        return *this;
    }


    // Move Assignment Operator
    LedgerEntry& operator=(LedgerEntry&& other) noexcept
    {
        if (this != &other) {

            delete[] amounts;

            description = std::move(other.description);
            amounts = other.amounts;
            days = other.days;

            other.amounts = nullptr;
            other.days = 0;
            other.description = "";

            cout << "[Move Assignment] Ownership transferred from: "
                 << description << endl;
        }

        return *this;
    }


    // Destructor
    ~LedgerEntry()
    {
        delete[] amounts;

        totalEntries--;

        cout << "[Destructor] "
             << (description.empty() ? "Empty LedgerEntry"
                                     : description)
             << " destroyed"
             << endl;
    }


    // operator+
    LedgerEntry operator+(const LedgerEntry& other) const
    {
        if (days != other.days) {
            throw invalid_argument(
                "Cannot add ledgers with different number of days"
            );
        }

        LedgerEntry result(
            description + " + " + other.description,
            days
        );

        for (int i = 0; i < days; i++) {
            result.amounts[i] =
                amounts[i] + other.amounts[i];
        }

        return result;
    }

    bool isEmpty() const
    {
        return amounts == nullptr && days == 0;
    }

    // operator==
    bool operator==(const LedgerEntry& other) const
    {
        if (days != other.days)
            return false;

        return getTotal() == other.getTotal();
    }


    // operator>
    bool operator>(const LedgerEntry& other) const
    {
        return getTotal() > other.getTotal();
    }


    // Non-const subscript
    double& operator[](int index)
    {
        if (index < 0 || index >= days) {
            throw out_of_range("Ledger index out of range");
        }

        return amounts[index];
    }


    // Const subscript
    const double& operator[](int index) const
    {
        if (index < 0 || index >= days) {
            throw out_of_range("Ledger index out of range");
        }

        return amounts[index];
    }


    // Calculate total
    double getTotal() const
    {
        double total = 0.0;

        for (int i = 0; i < days; i++) {
            total += amounts[i];
        }

        return total;
    }


    // Static getter
    static int getTotalEntries()
    {
        return totalEntries;
    }


    // Friend stream insertion
    friend ostream& operator<<(
        ostream& out,
        const LedgerEntry& entry
    );


    // Friend stream extraction
    friend istream& operator>>(
        istream& in,
        LedgerEntry& entry
    );
};


// Definition of static member
int LedgerEntry::totalEntries = 0;


// operator<<
ostream& operator<<(
    ostream& out,
    const LedgerEntry& entry
)
{
    out << entry.description << " : [";

    for (int i = 0; i < entry.days; i++) {

        out << fixed << setprecision(2)
            << entry.amounts[i];

        if (i < entry.days - 1)
            out << ", ";
    }

    out << "] Total: "
        << fixed << setprecision(2)
        << entry.getTotal();

    return out;
}


// operator>>
istream& operator>>(
    istream& in,
    LedgerEntry& entry
)
{
    for (int i = 0; i < entry.days; i++) {
        in >> entry.amounts[i];
    }

    return in;
}


// MAIN
int main()
{
    // Objective 1
    LedgerEntry jan("January Sales", 5);

    jan[0] = 1200.50;
    jan[1] = 3400.00;
    jan[2] = 800.75;
    jan[3] = 2100.00;
    jan[4] = 650.25;


    LedgerEntry feb("February Sales", 5);

    feb[0] = 900.00;
    feb[1] = 2200.50;
    feb[2] = 1750.00;
    feb[3] = 3000.00;
    feb[4] = 475.50;


    cout << jan << endl;
    cout << feb << endl;


    // Objective 2
    LedgerEntry combined = jan + feb;

    cout << "Combined: "
         << combined
         << endl;


    // Objective 3
    cout << "Jan == Feb : "
         << (jan == feb ? "Yes" : "No")
         << endl;

    cout << "Jan > Feb : "
         << (jan > feb ? "Yes" : "No")
         << endl;


    // Objective 4
    LedgerEntry moved = std::move(jan);

    cout << "After move, jan.amounts is null: "
         << (jan.isEmpty() ? "YES" : "NO")
         << endl;

    cout << "Moved entry: "
         << moved
         << endl;


    // Objective 5
    LedgerEntry q1("Q1 Total", 5);

    q1 = std::move(feb);

    cout << "Q1 (moved from feb): "
         << q1
         << endl;


    // Objective 6
    cout << "Live LedgerEntry objects: "
         << LedgerEntry::getTotalEntries()
         << endl;


    return 0;
}
