//============================================================================
// Name        : 3.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

int main()
{
    int statusReg = 0b10110001;
    int controlReg = 0b00000000;
    int dataReg = 0b11001010;


    // ------------------------------------------------
    // regPtr1 : Pointer to constant integer
    // ------------------------------------------------

    const int* regPtr1 = &statusReg;

    cout << "Status Register : "
         << *regPtr1 << endl;

    /*
       *regPtr1 = 10;
       ERROR:
       Cannot modify the value through a pointer
       to const integer.
    */

    /*
       regPtr1 = &dataReg;
       This is allowed because the pointer itself
       is not constant.
    */


    // ------------------------------------------------
    // regPtr2 : Constant pointer to integer
    // ------------------------------------------------

    int* const regPtr2 = &controlReg;

    *regPtr2 = 25;

    cout << "Control Register : "
         << *regPtr2 << endl;

    /*
       regPtr2 = &dataReg;
       ERROR:
       regPtr2 is a constant pointer.
       It cannot point to another address.
    */


    // ------------------------------------------------
    // regPtr3 : Constant pointer to constant integer
    // ------------------------------------------------

    const int* const regPtr3 = &statusReg;

    cout << "Status Register using regPtr3 : "
         << *regPtr3 << endl;

    /*
       *regPtr3 = 50;
       ERROR:
       Value cannot be changed because integer is const.
    */

    /*
       regPtr3 = &dataReg;
       ERROR:
       Pointer cannot be changed because pointer is const.
    */


    return 0;
}
