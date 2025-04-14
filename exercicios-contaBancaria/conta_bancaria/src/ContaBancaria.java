import java.util.Scanner;

public class ContaBancaria {



    private final static Scanner scanner = new Scanner(System.in);

    private Pessoa cliente;
    private float saldo = 0;
    private float chequeEspecial = 0;
    private float chequeEspecialInicial = 0;

    public void ContaBancaria (Pessoa cliente, float saldo, float chequeEspecial){

    };

    public void consultarSaldo(){
        var saldoAtual = saldo;
        System.out.println("O saldo atual da sua conta é R$ " + saldoAtual);
    }

    public void consultarChequeEspecial(){
        var saldoChequeEspecial = chequeEspecial;
        System.out.println("O valor do Cheque Especial é R$ "+ saldoChequeEspecial );
    }

    public void depositarDineiro(){
        float valorDeposito = scanner.nextFloat();
        saldo += valorDeposito;
        System.out.println("Você depositou R$ " + valorDeposito);
        consultarSaldo();
    }

    public void sacarDinheiro(){
        float valorSaque = scanner.nextFloat();
        if (valorSaque <= saldo) {
            saldo -= valorSaque;
            System.out.println("O valor do saque é de R$ " + valorSaque);
            consultarSaldo();
            return;
        }
        if(valorSaque > saldo){
            System.out.println("Saldo insuficiente. Saque R$"+valorSaque +" Saldo R$"+ saldo);
            return;
        }

    }

    public void pagarBoleto(){
        float valorBoleto = scanner.nextFloat();
        var saldoTotal = saldo + chequeEspecial;
        var diferenca = valorBoleto - saldo;

        if (valorBoleto <= saldo) {
            saldo -= valorBoleto;
            System.out.println("O valor do boleto pago foi de R$ " + valorBoleto);
            consultarSaldo();
            return;
        }
        if ((valorBoleto > saldo) && (diferenca <= chequeEspecial)){
                   float saldoAnterior = saldo;
                   saldo = 0;
                   chequeEspecial -= diferenca;
                   System.out.println("Saldo insuficiente. Boleto R$"+ valorBoleto +" Saldo R$"+ saldoAnterior);
                   System.out.println("Utilizou do cheque especial R$" + diferenca +"Saldo Cheque Especial R$"+ chequeEspecial);
                   return;
        }
        if((valorBoleto > saldo) && (diferenca > chequeEspecial)){
                   System.out.println("Você não tem saldo na conta nem limite liberado.");
                   return;
        }

    }

    public void criarConta(){
        var name = "";
        System.out.println("Digite o nome do titular:");
        name = scanner.next();

        var age = 0;
        System.out.println("Informe a idade:");
        age = scanner.nextInt();

        var cpf = "";
        System.out.println("Digite o CPF:");
        cpf = scanner.next();

        cliente = new Pessoa (name, age, cpf);


        System.out.println("Informe o valor do deposito de abertura da conta:");
        float depositoDaCriacao = scanner.nextFloat();
        saldo += depositoDaCriacao;

        if (depositoDaCriacao <= 500) {
            chequeEspecialInicial = 50;
            chequeEspecial = chequeEspecialInicial;
            return;
        }
        if (depositoDaCriacao > 500){
            chequeEspecialInicial = ((depositoDaCriacao)/2);
            chequeEspecial = chequeEspecialInicial;
            return;
        }

        System.out.println("Deposito de abertura R$ " + depositoDaCriacao);
        System.out.println("Seu limite inicial é de R$ " + chequeEspecialInicial);
    }

    public void verificaChequeEspecial(){
        if (chequeEspecial == chequeEspecialInicial){
            System.out.println("Você não está no cheque especial! Seu saldo na conta é de R$" + saldo);
            System.out.println("Você não está no cheque especial! Seu saldo no cheque especial é de R$" + chequeEspecialInicial);
            return;
        }
        if (chequeEspecialInicial != chequeEspecial) {
            while (chequeEspecial >= 0){

                    float debito = chequeEspecialInicial-chequeEspecial;
                    float debitoDevedor = 0;
                    chequeEspecial -= debito;
                    debitoDevedor = (float) (debito + (debito * 0.2));
                    System.out.println("Você entrou no cheque especial em R$ " + debito);
                    System.out.println("Valor para quitar cheque especial R$ " + debitoDevedor);
                    return;

            }
        }

    }


}
