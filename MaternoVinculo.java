import java.util.Base64;
import java.util.Scanner;

public class MaternoVinculo {

    public static void main(String[] args) {
        int escolhaMenu, logado = 1;
        double userLeite;
        String userNome, userCPF, userEmail, userSenha, userBairro;
        
        mae mae = null;
        bancoLeite banco = new bancoLeite("Banco de Leite - Pindaré Mirim", "pindare@leite.com", "senhaMuitoSeguraDisplay", "apeadouro", 15);
        do{
            Scanner entrada = new Scanner(System.in);
            System.out.println("Ordem de execução:\n1 - Cadastro \n2 - Login \n3 - Localizar banco \n4 - Sair \n5 - Apagar conta");
            
            //cadastro de usuário
            System.out.println("\nCADASTRO\n");
            System.out.println("Insira seu nome: ");
            userNome = entrada.nextLine();
            System.out.println("Insira seu cpf: ");
            userCPF = entrada.nextLine();
            System.out.println("Insira seu email: ");
            userEmail = entrada.nextLine();
            System.out.println("Crie uma senha: ");
            userSenha = Base64.getEncoder().encodeToString(entrada.nextLine().getBytes());
            System.out.println("Insira seu bairro: ");
            userBairro = entrada.nextLine();
            mae = new mae(userNome, userCPF, userEmail, userSenha, userBairro);
            
            //login
            System.out.println("\nLOGIN\n");
            System.out.println("Insira seu email: ");
            userEmail = entrada.nextLine();
            System.out.println("Insira sua senha:");
            userSenha = Base64.getEncoder().encodeToString(entrada.nextLine().getBytes());
            try{
                logado = mae.login(userEmail, userSenha);
            }catch(Exception e){
                System.out.println("O usuário não foi encontrado!");
            }
            
            //localizar banco
            System.out.println("\nLOCALIZAR BANCO\n");
            if(mae.localizacao.equals(banco.localizacao)){
                System.out.println("O banco mais próximo de você encontra-se em " + banco.localizacao + "!");
            }
            else{
                System.out.println("Não há bancos de leite próximos");
            }

            //logout
            logado = 1;

            //apagar conta
            System.out.println("\nAPAGAR CONTA\n");
            System.out.println("Insira o email: ");
            userEmail = entrada.nextLine();
            System.out.println("Insira a senha:");
            userSenha = Base64.getEncoder().encodeToString(entrada.nextLine().getBytes()); 
            try{
                logado = mae.verificacao(userEmail, userSenha);
                if(logado == 2){
                    mae.deletaUsuario(userSenha);
                }
                else{
                    System.out.println("Não foi possível deletar o usuário\n");   
                }
            }catch(Exception e){
                System.out.println("Usuário não foi encontrado");
            }
           
            userSenha = "";
            logado = 1;

        }while(true);
    }
}
