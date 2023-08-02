import random

letrasm = 'abcdefghijklmnopkrstuvwxyz'

letrasM = letrasm.upper()

simbolos = '!@#$%¨&*(){}[]()'

numeros = '0123456789'


senha = letrasm + letrasM + simbolos + numeros

password = ''

for i in range(random.randint(5,20)):
    password += random.choice(senha)
    
print(password)