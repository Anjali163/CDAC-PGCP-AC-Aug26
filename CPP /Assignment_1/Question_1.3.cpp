//============================================================================
// Name        : 4.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================



#include <iostream>
#include <cmath>
using namespace std;

int main() {
	double temperature[3][3];


	    for (int floor = 0; floor < 3; floor++)
	    {
	        cout << "Enter temperatures for Floor " << floor + 1 << ":" << endl;


	        for (int room = 0; room < 3; room++)
	        {
	            cout << "Room " << room + 1 << ": ";
	            cin >> temperature[floor][room];
	        }
	    }


	    cout << "\n        Room1  Room2  Room3" << endl;

	    for (int floor = 0; floor < 3; floor++)
	    {
	        cout << "Floor " << floor + 1 << " : ";

	        for (int room = 0; room < 3; room++)
	        {
	            cout << temperature[floor][room] << "   ";
	        }

	        cout << endl;
	    }
	    double hottest = temperature[0][0];
	       int hottestFloor = 0;
	       int hottestRoom = 0;

	       for (int floor = 0; floor < 3; floor++)
	       {
	           for (int room = 0; room < 3; room++)
	           {
	               if (temperature[floor][room] > hottest)
	               {
	                   hottest = temperature[floor][room];
	                   hottestFloor = floor;
	                   hottestRoom = room;
	               }
	           }
	       }

	       cout << "Hottest Room : Floor "
	            << hottestFloor + 1
	            << ", Room "
	            << hottestRoom + 1
	            << " → "
	            << hottest << "°C" << endl;

	       double highestAverage = 0;
	       int hottestFloorNumber = 0;

	          for (int floor = 0; floor < 3; floor++)
	          {
	              double sum = 0;

	              for (int room = 0; room < 3; room++)
	              {
	                  sum = sum + temperature[floor][room];
	              }

	              double average = sum / 3;

	              if (floor == 0 || average > highestAverage)
	              {
	                  highestAverage = average;
	                  hottestFloorNumber = floor;
	              }
	          }

	          cout << "Hottest Floor : Floor "
	                  << hottestFloorNumber + 1
	                  << " (avg "
	                  << highestAverage
	                  << "°C)" << endl;

	        int warningRooms = 0;

	    for (int floor = 0; floor < 3; floor++)
	      {
	          for (int room = 0; room < 3; room++)
	               {
	                   if (temperature[floor][room] >= 30)
	                     {
	                         warningRooms++;
	                     }
	                 }
	             }
	   cout << "Rooms at WARNING or above : "
			 << warningRooms << endl;

	return 0;
}











