#include <iostream>
#include <vector>
#include <algorithm>
//Idea algorithm: https://www.youtube.com/watch?v=geTFdPHucNc&t=1277s
using namespace std;


void printArray(vector<int> mass) {
    std::cout << "\n";
    for (int i = 0; i < mass.size(); i++) {
        std:
        cout << mass[i] << " ";
    }
    std::cout << "\n";
}

void findElementsForDelete(vector<int> mass) {
    vector<int> Fs(mass.size());
    vector<int> Fp(mass.size());
    Fs[0] = 1;
    Fp[0] = 1;
    for (int i = 1; i < mass.size(); i++) {
        int maxS=0;
        int maxP=0;
        for (int j = 0; j < i; j++) {
            if(mass[j]<mass[i] && maxS<Fs[j]){
                maxS=Fs[j];
            }
            if(mass[j]>mass[i] && maxP<Fp[j]){
                maxP=Fp[j];
            }
        }
            Fp[i] = maxS+1;
            Fs[i] = maxP+1;
    }
//    printArray(Fp);
//    printArray(Fs);
    std::cout<< mass.size()-std::max(Fs[mass.size()-1],Fp[mass.size()-1]);

}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int size;
    std::cin >> size;
    vector<int> mass(size);

    for (int i = 0; i < size; i++) {
        std::cin >> mass[i];
    }
//    printArray(mass);
    findElementsForDelete(mass);
    return 0;
}
