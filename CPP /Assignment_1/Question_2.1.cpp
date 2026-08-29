//============================================================================
// Name        : 1.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;


void resetSensorPairV1(int reading1, int reading2)
{
    int temp;

    temp = reading1;
    reading1 = reading2;
    reading2 = temp;
}


void resetSensorPairV2(int &reading1, int &reading2)
{
    int temp;

    temp = reading1;
    reading1 = reading2;
    reading2 = temp;
}


void resetSensorPairV3(int *reading1, int *reading2)
{
    int temp;

    temp = *reading1;
    *reading1 = *reading2;
    *reading2 = temp;
}

int main()
{
    /*
       V1 fails because it uses Call by Value.
       The function receives copies of the original values.
       The swap happens only on those copies.
       The original variables in main() are not changed.
    */

    int A = 55;
    int B = 12;

    cout << "--- V1: Call by Value ---" << endl;

    cout << "Before : A=" << A
         << " B=" << B << endl;

    resetSensorPairV1(A, B);

    cout << "After : A=" << A
         << " B=" << B << endl;


    cout << "\n--- V2: Call by Reference ---" << endl;

    A = 55;
    B = 12;

    cout << "Before : A=" << A
         << " B=" << B << endl;

    resetSensorPairV2(A, B);

    cout << "After : A=" << A
         << " B=" << B << endl;


    cout << "\n--- V3: Call by Pointer ---" << endl;

    A = 12;
    B = 55;

    cout << "Before : A=" << A
         << " B=" << B << endl;

    resetSensorPairV3(&A, &B);

    cout << "After : A=" << A
         << " B=" << B << endl;

    return 0;
}
