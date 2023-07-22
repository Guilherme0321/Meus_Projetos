package com.lista.listagem;
import java.sql.*;
import java.util.ArrayList;

public class LerSQL {
    public ArrayList<User> getData(String url, String username, String senha) {
        ArrayList<User> usuarios= new ArrayList<>();
        try{
            Connection connection = DriverManager.getConnection(url, username, senha);
            Class.forName("com.mysql.cj.jdbc.Driver");
            Statement statement = connection.createStatement();
            System.out.println("Acessado");

            String sql = "SELECT * FROM users";
            ResultSet resul = statement.executeQuery(sql);
            while(resul.next()){
                int id = resul.getInt(1);
                String firstName = resul.getString(2);
                String lastName = resul.getString(3);
                String email = resul.getString(4);
                String password = resul.getString(5);
                User user = new User(id,firstName,lastName,email,password);
                usuarios.add(user);
            }

        } catch (SQLException e) {
            System.out.println("Banco de dados não encontrado");
        } catch (ClassNotFoundException e) {
            System.out.println("Não conseguiu pegar a classe");
        }
        return usuarios;
    }
}
