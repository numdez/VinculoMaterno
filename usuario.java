import java.util.Base64;
import java.util.Scanner;

public class usuario {
    protected static int count = 0;
    protected String nome;
    protected int id;
    protected String email;
    protected String senha;
    
    public usuario(String nome, String email, String senha){
        this.nome = nome;
        this.id = ++count;
        this.email = email;
        this.senha = Base64.getEncoder().encodeToString(senha.getBytes());
    }
    
    public int loginUsuario(String email, String senha){
        if (this.senha.equals(Base64.getEncoder().encodeToString(senha.getBytes()))){
            System.out.println("Usuário logado com sucesso! Bem-vindo(a), " + this.nome);
            return this.id;
        }
        else{
            System.out.println("E-mail ou senha incorretos!");
            return 0;
        }
    }
    
    public int logoutUsuario(){
        return 0;
    }
    
    public int deletaUsuario(String senha){
        if(this.senha.equals(Base64.getEncoder().encodeToString(senha.getBytes()))){
            System.out.println("Senha correta! Deletando usuário...");
            return 1;
        }
        else{
            System.out.println("Senha incorreta! O usuário não foi deletado.");
            return 0;
        }
    }
}


