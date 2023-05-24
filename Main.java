import java.util.Base64;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int escolhaMenu, logado = 0;
        String userNome, userCPF, userEmail, userSenha, userBairro;
        Scanner entrada = new Scanner(System.in);
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
        
        mae josue = new mae(userNome, userCPF, userEmail, userSenha, userBairro);
        do{
            if(josue == null){
                System.out.println("Não há mais usuários cadastrados no sistema!");
            }
            System.out.println("1 - Login \n2 - Apagar conta");
            escolhaMenu = entrada.nextInt();
            entrada.nextLine();
            if(escolhaMenu == 1){
                System.out.println("Insira o nome de usuário: ");
                userNome = entrada.nextLine();
                System.out.println("Insira a senha:");
                userSenha = Base64.getEncoder().encodeToString(entrada.nextLine().getBytes());
                logado = josue.loginMae(userNome, userSenha, 0);
                if(logado == 404){
                    System.out.println("O usuário não foi encontrado!");
                }
            }
            else{
                assert true;
            }
            if(escolhaMenu == 2){
                userSenha = Base64.getEncoder().encodeToString(entrada.nextLine().getBytes()); 
                if (logado == 1){
                    if(josue.deletaUsuario(userSenha) == 1){
                        josue = null;
                    }
                }
                else{
                    System.out.println("O usuário deve estar logado para deletar sua conta!");
                }
            }
        }
        while(true);
    }
}
