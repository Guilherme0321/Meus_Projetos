#include <iostream>
#include <string>
using namespace std;
void vnoc(){
string b;
  int y=0;
  cout << "Converte\n2 - binario > decimal\n8 - octal > decimal\n16 - hexa > decimal\n";
cin >> y;
  cout<<"Digite um valor para ser convertido para decimal: ";
cin >> b;
    int dec = stoi(b,0,y);
    cout << b << " Na base " << y << "=" << dec << endl;
  
}
void conv(){
  cout << "Digite 0 e enter respectivamente duas vezes para terminar" << endl;
  int x=0, y=0,i=0;
  int z[32];
  do{
    x=0; y=0; i=0;
  cout << "Digite um valor em Decimal: ";
  cin >> x;
  cout << "Digite\n2 - para converter para binario\n8 - converter para octal\n16 - converter para hexadecimal\n";
  cin >> y;
  if(y==8){ printf("%d em octal e ",x);
    while(x>0){
      z[i]=x%8;
      x/=8;
      i++;
    }
    for(int j=i-1;j>=0;j--){
      cout << z[j];
    }cout << endl;
  }
     
  if(y==2){ printf("%d em binario= ",x);
    while(x>0){
      z[i]=x%2;
      x/=2;
      i++;
    }
    for(int j=i-1;j>=0;j--){
      cout << z[j];
    }
    cout << endl;
  }
  if(y==16){ printf("%d em hex= ",x);
    while(x>0){
      z[i]=x%16;
      x/=16;
      i++;
    }
  for(int j=i-1;j>=0;j--){
    if(z[j]==10){
       cout << "A";}
  else if(z[j]==11){
       cout <<"B";}
  else  if(z[j]==12){
       cout << "C";}
  else if(z[j]==13){
       cout << "D";}
  else if(z[j]==14){
       cout << "E";}
  else if(z[j]==15){
       cout << "F";
  }
  else{cout << z[j];}
}cout << endl;
  }
}while(y!=0);
    }


int main() {
  int t=0;
  cout << "0 - Sair\n1 - Decimal para 2 ou 8 ou 16\n2 - De 2 ou 8 ou 16 para decimal\n";
  cin >> t;
  switch(t){
    case 0: 
      break;
    case 1:
      conv();
    break;
    case 2:
      vnoc();
  }
}