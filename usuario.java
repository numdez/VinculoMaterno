import java.util.Base64;

abstract class usuario {
    protected static int count = 0;
    protected String nome;
    protected int id;
    protected String email;
    protected String senha;
    protected String localizacao;
    protected int nivel;
    
    public usuario(String nome, String email, String senha, String localizacao){
        this.nome = nome;
        this.id = ++count;
        this.email = email;
        this.senha = Base64.getEncoder().encodeToString(senha.getBytes());
        this.localizacao = localizacao;
    }
    
    public int login(String email, String senha){
        try{
            if (this.senha.equals(Base64.getEncoder().encodeToString(senha.getBytes()))){
                System.out.println("Usuário logado com sucesso! Bem-vindo(a), " + this.nome);
                return this.nivel; // não sei se deve retornar o nível (pra saber as permissões mais facil) ou se passa o id (no sistema completo seria algum id pra identificar q foi logado)
            }
            else{
                System.out.println("E-mail ou senha incorretos!");
                return 0;
            }
        }catch(Exception e){
            return 404;
        }
    }
    
    public int logout(){
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
    
    public int verificacao(String email, String senha){
        if(this.senha.equals(Base64.getEncoder().encodeToString(senha.getBytes())) && this.email.equals(email)){
            return this.nivel;
        }
        else{
            return 502;
        }
    }
}

