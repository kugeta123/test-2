#include<bits/stdc++.h>
using namespace std;
int c;
int main(){
	void stat(); 
	void stack();
	void heap();
	
    clock_t startTime,endTime;
	startTime = clock();
	for (int i = 0; i < 2 * 1e6; i++) stat();
	endTime = clock();
	cout << "Static Time : " <<(double)(endTime - startTime) / CLOCKS_PER_SEC << "s" << endl;

	startTime = clock();
	for (int i = 0; i < 2 * 1e6; i++) stack();
	endTime = clock();
	cout << "Stack Time : " <<(double)(endTime - startTime) / CLOCKS_PER_SEC << "s" << endl;

	startTime = clock();
	for (int i = 0; i < 2 * 1e6; i++) heap();
	endTime = clock();
	cout << "Heap Time : " <<(double)(endTime - startTime) / CLOCKS_PER_SEC << "s" << endl;

    return 0;
}

void stat()
{
	static int array[200000];
}
void stack()
{
	int array[200000];
}
void heap()
{
	int *array[200000]; 
}
