import java.util.Base64;
import java.util.Scanner;

public class VinculoMaterno {
    public static void main(String[] args) {
        int escolhaMenu, logado = 0;
        String userNome, userCPF, userEmail, userSenha, userBairro;
        Scanner entrada = new Scanner(System.in);
        mae user = new mae("", "", "", "", "");
        //integrar usuário do tipo banco de leite (nivel 2) e ajustar o sistema cíclico
        do{
            System.out.println("1 - Cadastro \n2 - Login \n3 - Apagar conta");
            escolhaMenu = entrada.nextInt();
            entrada.nextLine();
            if(escolhaMenu == 1){
                if(logado == 0){
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
                    user = new mae(userNome, userCPF, userEmail, userSenha, userBairro);

                }
            }
            if(escolhaMenu == 2){
                if(logado == 0){
                    System.out.println("Insira seu email: ");
                    userNome = entrada.nextLine();
                    System.out.println("Insira sua senha:");
                    userSenha = Base64.getEncoder().encodeToString(entrada.nextLine().getBytes());
                    logado = user.login(userNome, userSenha, 0);
                    if(logado == 404){
                        System.out.println("O usuário não foi encontrado!");
                    }
                }
                else{
                    System.out.println("O usuário já está logado no sistema!");
                }
                userSenha = "";
            }
            else if(escolhaMenu == 3){
                System.out.println("Insira a senha:");
                userSenha = Base64.getEncoder().encodeToString(entrada.nextLine().getBytes()); 
                if (logado == 1){
                    if(user.deletaUsuario(userSenha) == 1){
                        user = null;
                    }
                }
                else{
                    System.out.println("O usuário deve estar logado para deletar sua conta!");
                }
                userSenha = "";
            }
        }
        while(true);
    }
}