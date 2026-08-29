//============================================================================
// Name        : Bonus_Question.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;


struct Layout1
{
    char c1;
    int i;
    char c2;
};


struct Layout2
{
    int i;
    char c1;
    char c2;
};


int main()
{
    cout << "Size of Layout1 : "
         << sizeof(Layout1)
         << " bytes" << endl;

    cout << "Size of Layout2 : "
         << sizeof(Layout2)
         << " bytes" << endl;


    /*
       Struct Padding Explanation:

       1. The members of a structure may require
          specific memory alignment.

       2. Padding means extra unused memory bytes
          added by the compiler between or after
          structure members.

       3. The compiler adds padding so that members
          are stored at suitable memory addresses.

       4. Member order can change the amount of
          padding, so two structures with the same
          members can have different sizes.

       5. This is important when defining network
          packet headers or hardware register maps
          because memory layout can be important.
    */


    return 0;
}
