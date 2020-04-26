#include<iostream>
#include<string>
#include<stdlib.h>
using namespace std;
enum shape {equilateral_triangle = 1, square = 2, circle = 3};
enum Comp {Larger = 1, Equal = 0, Smaller = -1};
void Comp(int comp);
int main()
{
while (true)
{
shape p;
int userInput, choice, perimeter, area, diff, opt;
cout << "enter the code for the shape you like: " << endl;
cout << "1 for equilateral triangle" << endl;
cout << "2 for square" << endl;
cout << "3 for circle" << endl;

cout << "shape:";
cin >> choice;
switch (choice)
{
case equilateral_triangle:
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

case square:
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

case circle:
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
if (comp == Larger) result = "The shape you chose is that the perimeter is larger than the area";
if (comp == Equal) result = "The shape you chose is that the perimeter is equal to the area";
if (comp == Smaller) result = "The shape you chose is that the perimeter is smaller than the area";
cout <<result << endl;
}
