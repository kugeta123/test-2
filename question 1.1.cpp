#include<iostream>
#include<string>
#include<stdlib.h>
using namespace std;
void Comp(int comp);
int main()
{
while (true)
{
int userInput, choice, perimeter, area, diff, opt;
cout << "enter the code for the shape you like: " << endl;
cout << "1 for equilateral triangle" << endl;
cout << "2 for square" << endl;
cout << "3 for circle" << endl;

cout << "shape:";
cin >> choice;
switch (choice)
{
case 1:
cout << "enter the side length: ";
cin >> userInput;
perimeter = userInput * 3;
area =  1.732 * userInput * userInput / 4; 
cout << "perimeter is " << perimeter << endl;
cout << "area is " << area << endl;
diff = perimeter - area;
if (diff < 0) opt = -1;
if (diff == 0) opt = 0;
if (diff > 0) opt = 1;
Comp(opt);
break;

case 2:
cout << "enter the side length: ";
cin >> userInput;
perimeter = userInput * 4;
area = userInput * userInput; 
cout << "perimeter is " << perimeter << endl;
cout << "area is " << area << endl;
diff = perimeter - area;
if (diff < 0) opt = -1;
if (diff == 0) opt = 0;
if (diff > 0) opt = 1;
Comp(opt);
break;

case 3:
cout << "Please enter the radus: ";
cin >> userInput;
perimeter = 2 * 3.14 * userInput;
area = 3.14 * userInput * userInput; 
cout << "perimeter is " << perimeter << endl;
cout << "area is " << area << endl;
diff = perimeter - area;
if (diff < 0) opt = -1;
if (diff == 0) opt = 0;
if (diff > 0) opt = 1;
Comp(opt);
break;

default:
cout << "Invalid" << endl;
exit(0);
break;
}
}
}
void Comp(int comp)
{
string result;
if (comp == 1) result = "The shape you chose is that the perimeter is larger than the area";
if (comp == 0) result = "The shape you chose is that the perimeter is equal to the area";
if (comp == -1) result = "The shape you chose is that the perimeter is smaller than the area";
cout <<result << endl;
}

