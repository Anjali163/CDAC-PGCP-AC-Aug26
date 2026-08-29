//============================================================================
// Name        : 2.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <cmath>
using namespace std;

double computeRMS(double* signal, int n)
{
    double sum = 0;

    for (int i = 0; i < n; i++)
    {
        sum = sum + (*(signal + i) * *(signal + i));
    }

    double mean = sum / n;

    return sqrt(mean);
}



void normalise(double* signal, int n)
{
    double maxAbsolute = 0;

    // Find maximum absolute value
    for (int i = 0; i < n; i++)
    {
        double value = fabs(*(signal + i));

        if (value > maxAbsolute)
        {
            maxAbsolute = value;
        }
    }


    for (int i = 0; i < n; i++)
    {
        *(signal + i) = *(signal + i) / maxAbsolute;
    }
}


int countZeroCrossings(double* signal, int n)
{
    int count = 0;

    for (int i = 0; i < n - 1; i++)
    {
        if ((*(signal + i) < 0 && *(signal + i + 1) > 0) ||
            (*(signal + i) > 0 && *(signal + i + 1) < 0))
        {
            count++;
        }
    }

    return count;
}



void applyGain(double* signal, int n, double gainFactor)
{
    for (int i = 0; i < n; i++)
    {
        *(signal + i) = *(signal + i) * gainFactor;
    }
}



void printArray(double* signal, int n)
{
    for (int i = 0; i < n; i++)
    {
        cout << *(signal + i) << " ";
    }

    cout << endl;
}


int main()
{
    double signal[] = {
        0.5,
        -1.2,
        0.8,
        -0.3,
        1.0,
        -0.9,
        0.1
    };

    int n = 7;

    cout << "Original signal : ";
    printArray(signal, n);

    double rms = computeRMS(signal, n);

    cout << "RMS : " << rms << endl;

    int crossings = countZeroCrossings(signal, n);

    cout << "Zero Crossings : "
         << crossings << endl;

    normalise(signal, n);

    cout << "After normalise : ";
    printArray(signal, n);

    applyGain(signal, n, 2.0);

    cout << "After gain : ";
    printArray(signal, n);

    return 0;
}
