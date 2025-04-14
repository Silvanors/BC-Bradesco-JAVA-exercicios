import java.util.Scanner;

public class Main {

    private final static Scanner scanner = new Scanner(System.in);

    public static Carro carro = new Carro();

    public static void main(String[] args) {


        //carro.criarCarro();
        carro.ligarCarro();
        carro.acelerar();
        /*carro.trocarMarcha();

        carro.desacelerarCarrro();*/
        carro.virarVolante();
        carro.mostrarVelocidade();

    }




}