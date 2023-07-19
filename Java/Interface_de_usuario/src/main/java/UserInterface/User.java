package UserInterface;

class User {
    private String userName;
    private String nome;
    private String email;
    private String senha;

    public User(String userName, String nome, String email, String senha){
        this.userName = userName;
        this.senha = senha;
        this.email = email;
        this.nome = nome;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}





