import java.util.Scanner;

public class Banco {
    public static void main(String[] args) {
        //Informações do usuário
        String nome = "Rafael";
        String tipoDeConta = "Corrente";
        double saldo = 5000;

        //Imprimir dados
        String mensagem = """
                *************************************
                Nome: %s
                Tipo de conta %s
                Saldo: R$%.2f
                *************************************
                """.formatted(nome, tipoDeConta, saldo);
        System.out.println(mensagem);

        //Iniciar operações
        int opcao = 0;
        while (opcao != 4) {
            //Imprimir o menu de opções
            String opcoes = """
                *************************************
                Digite sua opção
                1 - Verificar saldo atual
                2 - Transferir valor 
                3 - Receber valor
                4 - Sair
                *************************************
                """;
            System.out.println(opcoes);

            //Define que a opção será definida pelo usuário
            Scanner input = new Scanner(System.in);
            opcao = input.nextInt();

            //Verifica os casos
            if (opcao == 1) { //Mostra o saldo
                System.out.println(String.format("Seu saldo é de %.2f", saldo));
            }
            else if (opcao == 2) {  //Realiza a transferencia de acordo com o valor digitado pelo usuário
                System.out.println("Insira o valor que gostaria de transferir: ");
                double valor = input.nextDouble();
                if (valor > saldo) { //Verifica se o valor de tranferência é maior que o saldo atual
                    System.out.println("Você não tem dinheiro o suficiente para realizar uma tranferência");
                }
                else {
                    saldo -= valor;
                    System.out.println(String.format("Você transferiu R$%.2f",valor));
                }
            }
            else if (opcao == 3) { //Recebe um valor digitado pelo usuário
                System.out.println("Insira o valor que gostaria de receber: ");
                double valor = input.nextDouble();
                if (valor < 0) { //Vericica se o valor a receber é negativo
                    System.out.println("Você não pode transferir um valor negativo");
                }
                else {
                    saldo += valor;
                    System.out.println(String.format("Você recebeu R$%.2f", valor));
                }
            }
            else if (opcao == 4) { //Mostra mensagem de operação encerrada
                System.out.println("Operação encerrada");
            }
            else { //Mostra mensagem de opção inválida
                System.out.println("Operação inválida");
            }
        }

    }
}
