import java.util.Base64;

public class mae extends usuario{
    protected String cpf;
    protected String localizacao;
    protected static int nivel = 1;
    
    public mae(String nome, String cpf, String email, String senha, String localizacao){
        super(nome, email, senha);
        this.cpf = cpf;
        this.localizacao = localizacao;    
    }
    
    public int loginMae(String email, String senha, int nivel){
        try{
            if(nivel == 0){
                if (this.senha.equals(Base64.getEncoder().encodeToString(senha.getBytes()))){
                    System.out.println("Usuário logado com sucesso! Bem-vindo(a), " + this.nome);
                    return this.id;
                }
                else{
                    System.out.println("E-mail ou senha incorretos!");
                    return 0;
                }
            }
            else{
                System.out.println("Você não possui permissão para fazer isso! ");
                return 0;
            }
        }
        catch(Exception e){
            return 404;
        }
    }
    
}
