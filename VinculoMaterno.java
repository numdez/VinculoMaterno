import java.util.Base64;
import java.util.Scanner;

public class VinculoMaterno {
    public static void main(String[] args) {
        int escolhaMenu, logado = 0;
        double userLeite;
        String userNome, userCPF, userEmail, userSenha, userBairro;
        Scanner entrada = new Scanner(System.in);
        mae mae = null;
        bancoLeite banco = null;
        //
        //integrar usuário do tipo banco de leite (nivel 2) e ajustar o sistema cíclico
        do{
            System.out.println("1 - Cadastro \n2 - Login \n3 - Apagar conta \n4 - Localizar banco \n5 - Informações gerais");
            //integrar a opção de localizar banco de leite e informações gerais sobre amamentação (e opcionalmente coisas básicas de gravidez)
            escolhaMenu = entrada.nextInt();
            entrada.nextLine();
            if(escolhaMenu == 1){
                if(logado == 0){ //checar se a variavel foi iniciada e pular a parte inicial
                    System.out.println("1 - Mãe \n2 - Banco de Leite");
                    escolhaMenu = entrada.nextInt();
                    entrada.nextLine();
                    if(escolhaMenu == 1){
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
                    }
                    else if(escolhaMenu == 2){
                        System.out.println("Insira o nome do banco: ");
                        userNome = entrada.nextLine();
                        System.out.println("Insira o email do banco: ");
                        userEmail = entrada.nextLine();
                        System.out.println("Crie uma senha: ");
                        userSenha = Base64.getEncoder().encodeToString(entrada.nextLine().getBytes());
                        System.out.println("Insira a localização: ");
                        userBairro = entrada.nextLine();
                        System.out.println("Insira a quantidade de leite (em litros) disponível no banco:");
                        userLeite = entrada.nextDouble();
                        userBairro = entrada.nextLine();
                        banco = new bancoLeite(userNome, userEmail, userSenha, userBairro, userLeite);
                    }
                    else{
                        System.out.println("Escolha uma opção válida!");
                        
                    }
                    
                }
                else{
                    ;
                }
            }
            if(escolhaMenu == 2){
                if(logado == 0){ //botar try exception pra tentar logar como mãe e dps como banco
                    System.out.println("Insira seu email: ");
                    userNome = entrada.nextLine();
                    System.out.println("Insira sua senha:");
                    userSenha = Base64.getEncoder().encodeToString(entrada.nextLine().getBytes());
                    logado = mae.login(userNome, userSenha, 0);
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
                    if(mae.deletaUsuario(userSenha) == 1){
                        mae = null;
                    }
                }
                else if(logado == 2){
                    if(banco.deletaUsuario(userSenha) == 1){
                        banco = null;
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