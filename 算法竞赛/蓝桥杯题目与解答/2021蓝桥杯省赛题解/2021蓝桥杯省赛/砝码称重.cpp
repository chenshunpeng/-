#include <iostream>
#include <bitset> 
using namespace std;
const int N = 15, M = 1e5 + 10; 
int w[N];
bitset<M> b;
int main(){
	int n;
	cin >> n;
	for(int i = 0; i < n; ++i)
		cin >> w[i];
	b[0] = 1;
	//bitset������������
	for(int i = 0; i < n; ++i)
		b |= b << w[i];
	//bitset������������
	for(int i = 0; i < n; ++i) 
		b |= b >> w[i];
	//��0��ȥ
	cout << b.count() - 1 << endl;
	return 0;
}
