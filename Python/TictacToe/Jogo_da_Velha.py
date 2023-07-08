import random
import os
def vencedor():
    tst = ['x','O']
    for a in tst:
        listagemH = [0,3,6]
        listagemV = [0,1,2]
        for j in listagemH:
            if a in jogo[j] and a in jogo[j+1] and a in jogo[j+2]:
                if(a == 'x'):
                    print('\nComputador é o vencedor')
                else:
                    print('\nVocê venceu')
                return True
        for j in listagemV:
            if a in jogo[j] and a in jogo[j+3] and a in jogo[j+6]:
                if(a == 'x'):
                    print('\nComputador é o vencedor')
                else:
                    print('\nVocê venceu')
                return True
        if (a in jogo[0] and a in jogo[4] and a in jogo[8]) or (a in jogo[6] and a in jogo[4] and a in jogo[2]):
            if(a == 'x'):
                print('\nComputador é o vencedor')
            else:
                print('\nVocê venceu')
            return True
def iniciar():
    global jogo
    jogo = ['0' for i in range(1,10)]
    
    
def mostrar():
    os.system('cls')
    ta = 1
    for i in jogo:
        print(i,end="\t")
        if ta == 3:
            ta = 0
            print('')
        ta+=1
    print('\n')

def MovC(lista):
    movc = random.choice(lista)
    moveC(movc)

def moveC(movc):
    if('0' != jogo[movc-1]):
        MovC(lista)
    else:
        jogo[movc-1] = 'x'
        mostrar()
        verificar_valor()
def moveP():
    try:
        mov = int(input('Digite onde deseja marcar: '))
        move(mov)
    except ValueError:
        print('\n Valor Invalido \n')
        moveP()
    except IndexError:
        print('\n Valor Invalido \n')
        moveP()
def move(mov):
    if('0' != jogo[mov-1] or mov == 0):
        print(f'\n{mov} já esta marcado, escolha outro\n')
        moveP()
    else:
        jogo[mov-1] = 'O'
        mostrar()
        verificar_valor()

def verificar_valor():
    for i in jogo:
        if(i == '0'):
            return True
    print('\nEmpate')
    return False
    
iniciar()
while verificar_valor():
    if vencedor():
        break
    lista = [1,2,3,4,5,6,7,8,9]
    for i in lista:
        if i in jogo:
            lista.remove(i)
    MovC(lista)
    if vencedor() or not verificar_valor():
        break
    moveP()
        