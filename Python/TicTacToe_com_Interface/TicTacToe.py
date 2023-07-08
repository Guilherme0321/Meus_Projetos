import tkinter as tk


class Jogo:

  def __init__(self):
    self.iniciado = False
    self.dados = [['_' for i in range(0, 3)] for x in range(0, 3)]
    self.player1 = False

  def getPlayer(self):
    return self.player1

  def start(self):
    if self.iniciado:
      for a in lista:
        a.grid_forget()

      self.iniciado = False
      botao1.config(text='Ligar')
      print('Is not running')
    else:
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
    else:
      print('Não está ligado')

  def show(self):
    for i in self.dados:
      print(i, end='\n')


x = Jogo()
x.show()
janela = tk.Tk()
janela.title('Jogo da Velha')
janela.geometry('500x500')
def invalido():
  print('Ja foi clicado')


def set1(a, b, bot):
  if x.iniciado:
    x.set(a, b)
    if x.getPlayer():
      bot.config(text='x', command=invalido)
    else:
      bot.config(text='o', command=invalido)


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

btn1 = tk.Button(janela,width=5, text='', command=chamar01)

btn2 = tk.Button(janela,width=5, text='', command=chamar02)

btn3 = tk.Button(janela,width=5, text='', command=chamar03)

btn4 = tk.Button(janela,width=5, text='', command=chamar04)

btn5 = tk.Button(janela,width=5, text='', command=chamar05)

btn6 = tk.Button(janela,width=5, text='', command=chamar06)

btn7 = tk.Button(janela,width=5, text='', command=chamar07)

btn8 = tk.Button(janela,width=5, text='', command=chamar08)

btn9 = tk.Button(janela,width=5, text='', command=chamar09)

lista = [btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9]
for i in lista:
  i.grid_forget()
janela.mainloop()
