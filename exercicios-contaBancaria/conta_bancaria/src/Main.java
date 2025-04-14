import java.util.Scanner;

public class Main {

    private final static Scanner scanner = new Scanner(System.in);

    private final static ContaBancaria contaBancaria = new ContaBancaria();



    public static void main(String[] args) {

        scanner.useDelimiter("\\n");
        var option = -1;

        /*contaBancaria.consultarSaldo();
        contaBancaria.depositarDineiro();
        contaBancaria.consultarSaldo();
        contaBancaria.sacarDinheiro();
        contaBancaria.pagarBoleto();*/

        do {
            System.out.println("===Escolha uma das opções===");
            System.out.println("1 - Criar conta.");
            System.out.println("2 - Consultar Saldo.");
            System.out.println("3 - Consultar saldo do Cheque Especial.");
            System.out.println("4 - Depositar dinheiro.");
            System.out.println("5 - Sacar dinheiro.");
            System.out.println("6 - Pagar boleto.");
            System.out.println("7 - Verificar se utiliza Cheque Especial.");
            System.out.println("0 - Sair");
            option = scanner.nextInt();

            switch (option){
                case 1 -> contaBancaria.criarConta();
                case 2 -> contaBancaria.consultarSaldo();
                case 3 -> contaBancaria.consultarChequeEspecial();
                case 4 -> contaBancaria.depositarDineiro();
                case 5 -> contaBancaria.sacarDinheiro();
                case 6 -> contaBancaria.pagarBoleto();
                case 7 -> contaBancaria.verificaChequeEspecial();
                case 0 -> System.exit(0);
                default -> System.out.println("Opção inválida");

            }
        }while (true);

    }
}