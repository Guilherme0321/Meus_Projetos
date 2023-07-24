package com.lista.listagem;


import java.security.PrivateKey;
import java.sql.*;
import java.util.ArrayList;

public class LerSQL {
    private String url;
    private String username;
    private String senha;
    public LerSQL(String url, String username, String senha){
        this.senha = senha;
        this.url = url;
        this.username = username;
    }
    public void uptade(User user){
        String sql = "UPDATE users SET firstname = ?, lastname = ?, email = ?, senha = ? WHERE id = ?";
        try{
            Connection connection = DriverManager.getConnection(url,username,senha);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,user.getFirstName());
            statement.setString(2,user.getLastName());
            statement.setString(3,user.getEmail());
            statement.setString(4,user.getSenha());
            statement.setInt(5,user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Banco de dados não encontrado");
        }
    }

    public void sendData(User data){
        String sql = "INSERT INTO users (firstname,lastname,email,senha) VALUES (?,?,?,?)";
        try{
            Connection connection = DriverManager.getConnection(url,username,senha);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, data.getFirstName());
            statement.setString(2,data.getLastName());
            statement.setString(3,data.getEmail());
            statement.setString(4,data.getSenha());
            statement.executeUpdate();
            System.out.println("Enviado!");
        } catch (SQLException e) {
            System.out.println("Banco de dados não encontrado");
        }
    }
    public ArrayList<User> getData() {
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
    public void deleteData(int id){
        String sql = "DELETE FROM users WHERE id = ?";
        try{
            Connection connection = DriverManager.getConnection(url,username,senha);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Banco de dados não encontrado");
        }
    }
}
