import tkinter as tk


class Jogo:

    def __init__(self):
        self.iniciado = False
        self.dados = []
        self.player1 = False

    def getPlayer(self):
        return self.player1

    def start(self):
        if self.iniciado:
            btnRestart.grid_forget()
            winner.grid_forget()
            self.deleteDados()
            self.desligar()
        else:
            btnRestart.grid(row=6, column=2)
            winner.grid_forget()
            btn1.grid(row=2, column=1, pady=2, padx=2)
            btn2.grid(row=2, column=2, pady=2, padx=2)
            btn3.grid(row=2, column=3, pady=2, padx=2)
            btn4.grid(row=3, column=1, pady=2, padx=2)
            btn5.grid(row=3, column=2, pady=2, padx=2)
            btn6.grid(row=3, column=3, pady=2, padx=2)
            btn7.grid(row=4, column=1, pady=2, padx=2)
            btn8.grid(row=4, column=2, pady=2, padx=2)
            btn9.grid(row=4, column=3, pady=2, padx=2)
            self.iniciado = True
            botao1.config(text='Desligar')
            print('Running')
            self.dados = [['_' for i in range(0, 3)] for x in range(0, 3)]
    def reiniciar(self):
      self.deleteDados()
      self.desligar()
      self.start()
      print("Stopping")
      print("Inicialized")
    def deleteDados(self):
      self.dados = []
      self.player1 = False
      for i in range(9):
        lista[i].config(command=listaCommands[i])
        lista[i].config(text='')
    def desligar(self):
      for a in lista:
        a.grid_forget()

      self.iniciado = False
      botao1.config(text='Ligar')
      print('Is not running')

    def set(self, l, c):
        if self.iniciado:
            if self.player1:
                self.dados[l][c] = 'o'
                self.player1 = False
                print(self.dados)
            else:
                self.dados[l][c] = 'x'
                self.player1 = True
                print(self.dados)
            if self.ifVelha():
                winner.config(text="Empate\nDuplo click em 'Desligar'\n para desligar")
                winner.grid(row=5,column=2,columnspan=1)
                self.iniciado = False
            result = self.thereIsWinner()
            if len(result) > 1:
                winner.config(text=result)
                winner.grid(row=5,column=2)
                self.iniciado = False
        else:
            print('Não está ligado')

    def thereIsWinner(self):
        countx = 0
        county = 0
        countdx = 0
        countdy = 0
        index = 0
        tamanho = len(self.dados)
        for i in range(len(self.dados)):
            for j in range(tamanho-1):
                if self.dados[i][j] == self.dados[i][j+1] and not(self.dados[i][j] == '_') and self.dados[i][-1] != '_':
                    countx += 1
                    index = self.dados[i][0]
                if self.dados[j][i] == self.dados[j+1][i] and not(self.dados[j+1][i] == '_') and self.dados[-1][i] != '_':
                    county += 1
                    index = self.dados[j][0]
                if self.dados[j][j] == self.dados[j+1][j+1] and not(self.dados[j][i] == '_') and self.dados[-1][-1] != '_':
                    countdx += 1
                    index = self.dados[0][0]
                if self.dados[tamanho-1-j][j] == self.dados[tamanho-j-2][j-1] and not(self.dados[tamanho-1-j][j] == '_') and self.dados[-1][0] != '_':
                    countdy+=1
                    index = self.dados[-1][0]
            if countx == 2 or county == 2 or countdx == 2 or countdy == 2:
                if index == 'x':
                    return "Jogador X venceu!"
                else:
                    return "Jogador O venceu!"
            countx = county = countdx = countdy = 0
        return ""
    def ifVelha(self):
        isEnd = True
        for i in self.dados:
            for j in i:
                if j == '_':
                    isEnd = False
        return isEnd

    def show(self):
        for i in self.dados:
            print(i, end='\n')


x = Jogo()
x.show()
janela = tk.Tk()
janela.title('Jogo da Velha')
janela.geometry('300x300')


def invalido():
    print('Ja foi clicado')


def set1(a, b, bot):
    if x.iniciado:
        x.set(a, b)
        if x.getPlayer():
            bot.config(text='X', command=invalido)
        else:
            bot.config(text='O', command=invalido)


def chamar01():
    set1(0, 0, btn1)


def chamar02():
    set1(0, 1, btn2)


def chamar03():
    set1(0, 2, btn3)


def chamar04():
    set1(1, 0, btn4)


def chamar05():
    set1(1, 1, btn5)


def chamar06():
    set1(1, 2, btn6)


def chamar07():
    set1(2, 0, btn7)


def chamar08():
    set1(2, 1, btn8)


def chamar09():
    set1(2, 2, btn9)


botao1 = tk.Button(janela, text='Ligar', command=x.start)
botao1.grid(row=1, column=2)

btn1 = tk.Button(janela, width=5, text='', command=chamar01)

btn2 = tk.Button(janela, width=5, text='', command=chamar02)

btn3 = tk.Button(janela, width=5, text='', command=chamar03)

btn4 = tk.Button(janela, width=5, text='', command=chamar04)

btn5 = tk.Button(janela, width=5, text='', command=chamar05)

btn6 = tk.Button(janela, width=5, text='', command=chamar06)

btn7 = tk.Button(janela, width=5, text='', command=chamar07)

btn8 = tk.Button(janela, width=5, text='', command=chamar08)

btn9 = tk.Button(janela, width=5, text='', command=chamar09)

winner = tk.Label(janela, text="")
btnRestart = tk.Button(janela,text="Recomeçar",command=x.reiniciar)

lista = [btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9]
listaCommands = [chamar01, chamar02, chamar03, chamar04, chamar05, chamar06, chamar07, chamar08, chamar09]
for i in lista:
    i.grid_forget()
janela.mainloop()
