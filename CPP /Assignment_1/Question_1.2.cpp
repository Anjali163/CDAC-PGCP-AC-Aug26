//============================================================================
// Name        : 2.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

int main()
{
    int N;

    cout << "Enter number of readings: ";
    cin >> N;

    if (N < 1 || N > 100)
    {
        cout << "Invalid number of readings." << endl;
        return 0;
    }

    double readings[100];


    for (int i = 0; i < N; i++)
    {
        cout << "Enter reading " << i << ": ";
        cin >> readings[i];
    }

    int skipped = 0;

    cout << "\nValid readings : ";

    for (int i = 0; i < N; i++)
    {
        if (readings[i] < 0)
        {
            skipped++;
            continue;
        }

        cout << readings[i] << " ";
    }

    cout << endl;
    cout << "Skipped (errors) : " << skipped << endl;


    bool foundCritical = false;

    for (int i = 0; i < N; i++)
    {
        if (readings[i] < 0)
        {
            continue;
        }

        if (readings[i] >= 45)
        {
            cout << "First CRITICAL : Index "
                 << i << " → "
                 << readings[i] << "°C" << endl;

            foundCritical = true;
            break;
        }
    }

    if (!foundCritical)
    {
        cout << "First CRITICAL : Not found" << endl;
    }

    double min = 0;
    double max = 0;
    double sum = 0;
    int validCount = 0;


    bool firstValue = true;

    int normal = 0;
    int warning = 0;
    int critical = 0;
    int shutdown = 0;

    for (int i = 0; i < N; i++)
    {
        if (readings[i] < 0)
        {
            continue;
        }


        if (firstValue)
        {
            min = readings[i];
            max = readings[i];
            firstValue = false;
        }
        else
        {
            if (readings[i] < min)
            {
                min = readings[i];
            }

            if (readings[i] > max)
            {
                max = readings[i];
            }
        }


        sum = sum + readings[i];


        validCount++;

        if (readings[i] < 30)
        {
            normal++;
        }
        else if (readings[i] < 45)
        {
            warning++;
        }
        else if (readings[i] < 60)
        {
            critical++;
        }
        else
        {
            shutdown++;
        }
    }


    double average = sum / validCount;

    cout << "Min : " << min
         << "°C Max : " << max
         << "°C Avg : " << average
         << "°C" << endl;

    cout << "Normal:" << normal
         << " Warning:" << warning
         << " Critical:" << critical
         << " Shutdown:" << shutdown << endl;

    return 0;
}
