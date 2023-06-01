public class bancoLeite extends usuario{
    protected double quantidadeLeite;
    protected static int nivel = 3;
    
    public bancoLeite(String nome, String email, String senha, String localizacao, double quantLeite){
        super(nome, email, senha, localizacao);
        this.quantidadeLeite = quantLeite;
    }
    
    /*public int login(String email, String senha){
        try{
            if(nivel < 2){
                if (this.senha.equals(Base64.getEncoder().encodeToString(senha.getBytes()))){
                    System.out.println("Usuário logado com sucesso! Bem-vindo(a), " + this.nome);
                    return this.nivel; // não sei se deve retornar o nível (pra saber as permissões mais facil) ou se passa o id (no sistema completo seria algum id pra identificar q foi logado)
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
    }*/
    
    public void atualizaLeite(double quantLeite){
        this.quantidadeLeite = quantLeite;
    }
    
}
