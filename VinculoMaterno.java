import java.util.Base64;
import java.util.Scanner;

public class VinculoMaterno {
    /*
    public static void main(String[] args) {
        int logado = 1;
        double userLeite;
        String userNome, userCPF, userEmail, userSenha, userBairro;
        try (Scanner entrada = new Scanner(System.in)) {
            mae mae = null;
            bancoLeite banco = null;
            // de preferencia transformar o menu em uma função chamável pra eliminar redundância
            do{ 
                int escolhaMenu, escolhaSubMenu;                
                menu(logado);
                //integrar a opção de localizar banco de leite e informações gerais sobre amamentação (e opcionalmente coisas básicas de gravidez)
                entrada.nextLine();
                escolhaMenu = entrada.nextInt();
                entrada.nextLine();
                escolhaMenu = escolhaCorreta(escolhaMenu, logado);
                switch (escolhaMenu){
                    case 1:
                        if(logado < 2){ //checar se a variavel foi iniciada e pular a parte inicial (em teoria feito)
                            System.out.println("1 - Mãe \n2 - Banco de Leite \n3 - Cancelar");
                            escolhaSubMenu = entrada.nextInt();
                            entrada.nextLine();
                            switch (escolhaSubMenu) {
                                case 1:
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
                                    escolhaMenu = 0;
                                    break;

                                case 2:
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
                                    escolhaMenu = 0;
                                    break;
                                    
                                case 3:
                                    break;
                                    
                                default:
                                    System.out.println("Escolha uma opção válida!");
                                    break;          
                            }  
                        }
                        else{
                            System.out.println("Usuário já está logado!");
                        }
                    case 2:
                        if(logado < 2){ //botar try catch pra tentar logar como mãe e dps como banco (feito)
                            System.out.println("Insira seu email: ");
                            userEmail = entrada.nextLine();
                            System.out.println("Insira sua senha:");
                            userSenha = Base64.getEncoder().encodeToString(entrada.nextLine().getBytes());
                            try{
                                logado = mae.login(userEmail, userSenha);
                            }catch(Exception e){
                                System.out.println("O usuário não foi encontrado!");
                            }
                        }
                        else{
                            System.out.println("O usuário já está logado no sistema!");
                        }
                        userSenha = "";
                        break;
                                    
                    case 5:
                        System.out.println("Insira o email: ");
                        userEmail = entrada.nextLine();
                        System.out.println("Insira a senha:");
                        userSenha = Base64.getEncoder().encodeToString(entrada.nextLine().getBytes()); 
                        try{
                            logado = mae.verificacao(userEmail, userSenha);
                        }catch(Exception e){
                            logado = banco.verificacao(userEmail, userSenha);
                        }
                        switch (logado) {
                            case 2:
                                mae.deletaUsuario(userSenha);
                                userSenha = "";
                                logado = 0;
                                break;
                        
                            case 3:
                                banco.deletaUsuario(userSenha);
                                userSenha = "";
                                logado = 0;
                                break;
                        
                            default:
                                System.out.println("O usuário deve estar logado para deletar sua conta!");
                                userSenha = "";
                                logado = 0;
                                break;
                        }
                        break;

                    case 4:
                        //"implementar" localização de banco de leite
                        if(logado == 2){
                            if(mae.localizacao == banco.localizacao){
                                System.out.println("O banco mais próximo de você encontra-se em " + banco.localizacao + "!");
                            }
                            else{
                                System.out.println("Não há bancos de leite próximos");
                            }
                        }
                        else if(logado == 1){
                            System.out.println("Insira seu bairro: ");
                            if(banco.localizacao.equals(entrada.nextLine())){
                                System.out.println("O banco mais próximo de você encontra-se em " + banco.localizacao + "!");
                            }
                            else{
                                System.out.println("Não há bancos de leite próximos");
                            }
                        }
                        break;
                        
                    case 3:
                        System.out.println("Esta função ainda não foi propriamente implementada, por favor seja paciente.");
                        // no sistema de verdade seria mais fácil implementar isso com api ou web scraping, mas em java é complicaddo
                        break;
                        
                    case 6:
                        logado = 0;
                        if(logado > 0){
                            System.out.println("Usuário deslogado com sucesso!");
                        }
                        else{
                            System.out.println("Ocorreu um erro inesperado");
                        }
                        break;      
                }
              
            }
            while(true);
        }
    }

    public static void menu(int nivel){
        if(nivel == 2){
            System.out.println("1 - Cadastro \n2 - Login \n3 - Informações gerais \n4 - Localizar banco \n5 - Sair \n6 - Apagar conta");
        }
        else if(nivel == 3){
            System.out.println("1 - Cadastro \n2 - Login \n3 - Informações gerais \n4 - Sair \n5 - Apagar conta");
        }
        else if(nivel <= 1){
            System.out.println("1 - Cadastro \n2 - Login \n3 - Informações gerais \n4 - Localizar banco");
        }
        
    }

    public static int escolhaCorreta(int escolha, int nivel){
        if(nivel <= 1){
            if(escolha > 4){
                return 0;
            }
        }
        else if(nivel == 3){
            if(escolha == 4){
                return 5;
            }
            else if(escolha == 5){
                return 6;
            }
            else if(escolha > 5){
                return 0;
            }
        }
        return nivel;
    }
    
    */
}