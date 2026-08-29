//============================================================================
// Name        : Day_4.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;


int reading(double range){
	 if(range<0){
		 return -1;
	 }else if(range>=0 && range<=29){
		 return 0;
	 }else if(range>=30 && range<=44){
		 return 1;
	 }else if(range>=45 && range<=59){
		 return 2;
	 }else{
		 return 3;
	 }

}

 void statuslabel(int statuscode){

	 switch(statuscode){
		 case -1:
			         cout<<"Status : SENSOR_ERROR "<<endl;
			         cout<<"Action : Sensor fault — check wiring "<<endl;
			         break;
		 case 0:
		 			 cout<<"Status : NORMAL "<<endl;
		 			 cout<<"Action : No action required "<<endl;
		 			 break;
		 case 1:
		 			 cout<<"Status : WARNING "<<endl;
		 			 cout<<"Action : Alert sent to supervisor "<<endl;
		 			 break;
		 case 2:
		 			 cout<<"Status : CRITICAL "<<endl;
		 			 cout<<"Action : Cooling system triggered "<<endl;
		 			 break;
		default:
		 			 cout<<"Status : SHUTDOWN "<<endl;
		 			 cout<<"Action : Emergency shutdown initiated "<<endl;
		 			 break;

	 }

}


int main() {

	double range;
	cout<<"Enter the reading: "<<endl;

	cin>> range;

	 double F = (range * 9 / 5) + 32;

	cout<< "Temperature : " <<range << "C / "<< F <<"F" << endl;
	int statuscode = reading(range);


	statuslabel(statuscode);

	(range >= 25) ? cout << "Reading : Above Average" << endl : cout << "Reading : Below Average" << endl;


	return 0;
}
