from datetime import datetime

titulo = input("Digite o titulo: ")
print('No seguinte formato 11:00 ')
horario = input("Digite a hora quer ser notificado: ")

eventos = {
    "title":titulo,
    "hora":horario
}

if len(horario) == 5 and ':' in horario:
    while(True):
        data = datetime.now()
        hours = data.strftime('%H:%M')
        if eventos["hora"] == hours:
            print(f'\nAlarme para {eventos["title"]}')
            break
else:
    print('Formato invalido')