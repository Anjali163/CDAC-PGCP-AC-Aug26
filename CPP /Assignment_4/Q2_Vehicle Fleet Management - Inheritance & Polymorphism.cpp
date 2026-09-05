//============================================================================
// Name        : Q2_Vehicle.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <string>
#include <vector>
#include <iomanip>

using namespace std;

// BASE CLASS

class Vehicle {
protected:
    string registrationNo;
    string ownerName;
    int yearOfManufacture;
    double kmDriven;

public:

    Vehicle(const string& reg,
            const string& owner,
            int year,
            double km)
        : registrationNo(reg),
          ownerName(owner),
          yearOfManufacture(year),
          kmDriven(km)
    {
        cout << "[Vehicle Constructor] "
             << registrationNo << " : "
             << ownerName << endl;
    }


    // Pure virtual function
    virtual double fuelCost(double kmToTravel) const = 0;


    // Virtual function
    virtual void describe() const
    {
        cout << "Registration: " << registrationNo << endl;
        cout << "Owner: " << ownerName << endl;
        cout << "Year: " << yearOfManufacture << endl;
        cout << "Km Driven: " << kmDriven << endl;
    }


    // Pure virtual function
    virtual string vehicleType() const = 0;


    // Virtual destructor
    virtual ~Vehicle()
    {
        cout << "[Vehicle Destructor] "
             << registrationNo << endl;
    }


    double getKmDriven() const
    {
        return kmDriven;
    }


    string getRegNo() const
    {
        return registrationNo;
    }


    string getOwnerName() const
    {
        return ownerName;
    }
};



// CAR


class Car : public Vehicle {
private:
    string fuelType;
    double mileageKmpl;

public:

    Car(const string& reg,
        const string& owner,
        int year,
        double km,
        const string& fuel,
        double mileage)
        : Vehicle(reg, owner, year, km),
          fuelType(fuel),
          mileageKmpl(mileage)
    {
        cout << "[Car Constructor] "
             << registrationNo << endl;
    }


    double fuelCost(double kmToTravel) const override
    {
        double fuelPrice;

        if (fuelType == "Petrol")
            fuelPrice = 106.00;
        else
            fuelPrice = 93.00;

        double litres = kmToTravel / mileageKmpl;

        return litres * fuelPrice;
    }


    string vehicleType() const override
    {
        return "Car";
    }


    void describe() const override
    {
        Vehicle::describe();

        cout << "Fuel Type: " << fuelType << endl;
        cout << "Mileage: " << mileageKmpl << " km/L" << endl;
    }


    ~Car()
    {
        cout << "[Car Destructor] "
             << registrationNo << endl;
    }
};


// TRUCK


class Truck : public Vehicle {
protected:
    double payloadCapacityTons;
    double fuelEfficiencyKmpl;

public:

    Truck(const string& reg,
          const string& owner,
          int year,
          double km,
          double payload,
          double efficiency)
        : Vehicle(reg, owner, year, km),
          payloadCapacityTons(payload),
          fuelEfficiencyKmpl(efficiency)
    {
        cout << "[Truck Constructor] "
             << registrationNo << endl;
    }


    double fuelCost(double kmToTravel) const override
    {
        // Efficiency drops by 5% per ton
        double effectiveEfficiency =
            fuelEfficiencyKmpl *
            (1 - 0.05 * payloadCapacityTons);

        double litres =
            kmToTravel / effectiveEfficiency;

        // Assume diesel
        return litres * 93.00;
    }


    string vehicleType() const override
    {
        return "Truck";
    }


    void describe() const override
    {
        Vehicle::describe();

        cout << "Payload: "
             << payloadCapacityTons
             << " tons" << endl;

        cout << "Fuel Efficiency: "
             << fuelEfficiencyKmpl
             << " km/L" << endl;
    }


    ~Truck()
    {
        cout << "[Truck Destructor] "
             << registrationNo << endl;
    }
};



// ELECTRIC TRUCK


class ElectricTruck : public Truck {
private:
    double batteryCapacityKWh;
    double rangePerChargeKm;
    double batteryPercentage;

public:

    ElectricTruck(const string& reg,
                  const string& owner,
                  int year,
                  double km,
                  double payload,
                  double efficiency,
                  double batteryCapacity,
                  double range,
                  double battery)
        : Truck(reg, owner, year, km,
                payload, efficiency),
          batteryCapacityKWh(batteryCapacity),
          rangePerChargeKm(range),
          batteryPercentage(battery)
    {
        cout << "[ElectricTruck Constructor] "
             << registrationNo << endl;
    }


    double fuelCost(double kmToTravel) const override
    {
        double energyUsed =
            (kmToTravel / rangePerChargeKm)
            * batteryCapacityKWh;

        return energyUsed * 9.50;
    }


    string vehicleType() const override
    {
        return "Electric Truck";
    }


    void describe() const override
    {
        Vehicle::describe();

        cout << "Payload: "
             << payloadCapacityTons
             << " tons" << endl;

        cout << "Battery Capacity: "
             << batteryCapacityKWh
             << " kWh" << endl;

        cout << "Range: "
             << rangePerChargeKm
             << " km" << endl;

        cout << "Battery: "
             << batteryPercentage
             << "% charged" << endl;
    }


    double getBatteryPercentage() const
    {
        return batteryPercentage;
    }


    ~ElectricTruck()
    {
        cout << "[ElectricTruck Destructor] "
             << registrationNo << endl;
    }
};


// VAN

class Van : public Vehicle {
private:
    int seatingCapacity;
    double mileageKmpl;

public:

    Van(const string& reg,
        const string& owner,
        int year,
        double km,
        int seats,
        double mileage)
        : Vehicle(reg, owner, year, km),
          seatingCapacity(seats),
          mileageKmpl(mileage)
    {
        cout << "[Van Constructor] "
             << registrationNo << endl;
    }


    double fuelCost(double kmToTravel) const override
    {
        double litres =
            kmToTravel / mileageKmpl;

        return litres * 106.00;
    }


    string vehicleType() const override
    {
        return "Van";
    }


    void describe() const override
    {
        Vehicle::describe();

        cout << "Seats: "
             << seatingCapacity << endl;

        cout << "Mileage: "
             << mileageKmpl << " km/L" << endl;
    }


    ~Van()
    {
        cout << "[Van Destructor] "
             << registrationNo << endl;
    }
};


// FLEET REPORT

void printFleetReport(
    const vector<Vehicle*>& fleet,
    double tripKm)
{
    cout << "\n========================================\n";
    cout << "FLEET REPORT — Trip Distance: "
         << tripKm << " km\n";
    cout << "========================================\n";

    cout << left
         << setw(15) << "Reg"
         << setw(20) << "Type"
         << setw(25) << "Owner"
         << "Km Driven"
         << endl;

    cout << "-------------------------------------------------------\n";

    for (Vehicle* v : fleet)
    {
        cout << left
             << setw(15) << v->getRegNo()
             << setw(20) << v->vehicleType()
             << setw(25) << v->getOwnerName()
             << v->getKmDriven()
             << endl;
    }


    cout << "\n========================================\n";
    cout << "FUEL / CHARGE COST ESTIMATE\n";
    cout << "========================================\n";


    double minimumCost = 1e9;
    Vehicle* mostEfficient = nullptr;


    for (Vehicle* v : fleet)
    {
        double cost = v->fuelCost(tripKm);

        cout << v->getRegNo()
             << " (" << v->vehicleType() << ") : Rs. "
             << fixed << setprecision(2)
             << cost;


        // Check whether vehicle is ElectricTruck
        ElectricTruck* electric =
            dynamic_cast<ElectricTruck*>(v);


        if (electric != nullptr)
        {
            cout << " [Battery: "
                 << electric->getBatteryPercentage()
                 << "% charged]";
        }


        cout << endl;


        if (cost < minimumCost)
        {
            minimumCost = cost;
            mostEfficient = v;
        }
    }


    cout << "\nMost Efficient Vehicle: "
         << mostEfficient->getRegNo()
         << " (" << mostEfficient->vehicleType()
         << ") — Rs. "
         << fixed << setprecision(2)
         << minimumCost
         << " for " << tripKm
         << " km"
         << endl;
}



// MAIN

int main()
{
    cout << "===== CONSTRUCTOR ORDER TEST =====\n";

    ElectricTruck test(
        "V-ET001",
        "Green Logistics",
        2024,
        50000,
        5,
        3.5,
        100,
        400,
        85
    );

    cout << "\n...scope ends...\n";


    cout << "\n===== POLYMORPHIC FLEET =====\n";

    vector<Vehicle*> fleet;


    fleet.push_back(
        new Car(
            "KA01AA001",
            "Ramesh Kumar",
            2020,
            45200,
            "Petrol",
            18
        )
    );


    fleet.push_back(
        new Truck(
            "MH04BB002",
            "Shyam Logistics",
            2019,
            123500,
            2,
            4
        )
    );


    fleet.push_back(
        new ElectricTruck(
            "GJ07CC003",
            "Green Fleet Co",
            2024,
            89000,
            3,
            4,
            100,
            400,
            85
        )
    );


    fleet.push_back(
        new Van(
            "DL05DD004",
            "City Services",
            2021,
            67000,
            8,
            15
        )
    );


    fleet.push_back(
        new Car(
            "MH12EE005",
            "Priya Shah",
            2022,
            25000,
            "Diesel",
            20
        )
    );


    printFleetReport(fleet, 200);


    cout << "\n===== CLEANUP =====\n";

    for (Vehicle* v : fleet)
    {
        delete v;
    }


    return 0;
}
