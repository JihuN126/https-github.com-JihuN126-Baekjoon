#include <iostream>
using namespace std;
int main(void) {
	int N, k = 0;
	cin >> N;
	char* Str = new char[N];
	char* NewStr = new char[N];
	cin >> Str;
	for (int i = 0; i < N; i++) {
		if (Str[i] == 'A' || Str[i] == 'J' || Str[i]=='V');
		else NewStr[k++] = Str[i];
	}
	if (k == 0) cout << "nojava";
	else {
		for (int i = 0; i < k; i++) cout << NewStr[i];
	}
}