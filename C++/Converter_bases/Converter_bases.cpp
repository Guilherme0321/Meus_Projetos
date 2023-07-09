#include <iostream>
#include <string>
#include <cmath>
using namespace std;

int h_toDec(string hex){
    int resul = 0;
    int len = 0;
    char element = ' ';
    try{
        while(hex[len] != '\0' && hex[len] != '\n'){
            if(!('a' <= hex[len] && hex[len] <= 'f') && !('A' <= hex[len] && hex[len] <= 'F') && !('0' <= hex[len] && hex[len] <= '9')){
                throw runtime_error("Conversao de hexadecimal, so entre (-9,9) e entre (a,f) ou (A,F)");
            }else{
                element = hex[len];
                if('0' <= element && element <= '9'){
                    resul += (element - '0')*pow(16,len);
                }else{
                    switch(element){
                    case 'a':
                    case 'A':
                        resul += (10)*pow(16,len);
                        break;
                    case 'b':
                    case 'B':
                        resul += (11)*pow(16,len);
                        break;
                    case 'c':
                    case 'C':
                        resul += (12)*pow(16,len);
                        break;
                    case 'd':
                    case 'D':
                        resul += (13)*pow(16,len);
                        break;
                    case 'e':
                    case 'E':
                        resul += (14)*pow(16,len);
                        break;
                    case 'f':
                    case 'F':
                        resul += (15)*pow(16,len);
                        break;
                    }
                }
            }
            len++;
        }
            return resul;
    }
    catch(exception& e){
        cout << "Ocorreu um erro! " << e.what() << endl;
        return -1;
    }
}

int o_toDec(int oct){
    int resul = 0;
    int len = 0;
    try{
    while(oct > 0){
        if(!(0 <= oct % 10) && !(oct % 10 < 8)){
            throw runtime_error("Conversao de octal, so 0 <= number <= 7");
          }else{
            resul += (oct % 10)*pow(8,len);
            oct /= 10;
            len++;
          }
        }
        return resul;
    }
    catch(exception& e){
        cout << "Ocorreu um erro! " << e.what() << endl;
        return -1;
    }
}

int b_toDec(int bin){
    int resul = 0;
    int len = 0;
    try{
        while(bin > 0){
        if((bin % 10) != 0 && (bin % 10) != 1 ){
            throw runtime_error("Conversao para binario, so 0 ou 1");
        }else{
            resul += (bin%10)*pow(2,len);
            bin /= 10;
            len++;
            }
        }
            return resul;
    }catch(exception& e){
        cout << "Ocorreu um erro! " << e.what() << endl;
        return -1;
    }
}
void vnoc(){
    int resul = 0;
    bool menor_0 = false;
    string text = "";
    int b = 0;
    int y = 0;
    string hex = "";
    cout << "Converte\n2 - binario > decimal\n8 - octal > decimal\n16 - hexa > decimal\n";
    cin >> y;
    cout<<"Digite um valor para ser convertido para decimal: ";
    if(y != 16){
        cin >> b;
        if(b < 0){
            b*=-1;
            menor_0 = true;
        }
    }else{
        cin >> hex;
        if(hex[0] == '-'){
            hex.erase(-1);
        }
    }
    switch(y){
    case 0:
        break;
    case 2:
        b = b_toDec(b);
        text = "Binario";
        break;
    case 8:
        b = o_toDec(b);
        text = "Octal";
        break;
    case 16:
        b = h_toDec(hex);
        text = "Hexadecimal";
        break;
    }
    if(!menor_0){
        cout << text << " > Decimal : " << b << endl;
    }else{
        cout << text << " > Decimal : " << "-" << b << endl;
    }
}

void show(int z[], int i){
    for(int j=i-1;j>=0;j--){
      cout << z[j];
    }
    cout << endl;
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
  if(y==8){ cout << x << " em octal e ";
    while(x>0){
      z[i]=x%8;
      x/=8;
      i++;
    }
    show(z,i);
  }

  if(y==2){ printf("%d em binario= ",x);
    while(x>0){
      z[i]=x%2;
      x/=2;
      i++;
    }
    show(z,i);
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
