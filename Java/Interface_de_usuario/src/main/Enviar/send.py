import pyodbc
import sys


nome = sys.argv[1]
username = sys.argv[2]
email = sys.argv[3]
senha = sys.argv[4]


dados_conexao = "DRIVER={SQL Server};Server=LAPTOP-M2IQMHKV\SQLEXPRESS;Database=Users;uid=NONE;PWD=none;TRUSTED_CONNECTION=yes"
conexao = pyodbc.connect(dados_conexao)


cursor = conexao.cursor()


sql = "INSERT INTO usuarios ( nome, username, email, senha) VALUES( ?, ?, ?, ?)"


cursor.execute(sql,(nome,username,email,senha))


conexao.commit()


cursor.close()
conexao.close()