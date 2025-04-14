import java.util.Scanner;

public class Carro {

    private final static Scanner scanner = new Scanner(System.in);

    //private Pessoa motorista;
    private String nomeCarro;
    private boolean chave;
    private boolean acelerador;
    private String volante;
    private int marcha;
    private int velocimetro;

    public Carro(String nomeCarro){
        this.chave = false;
        this.velocimetro = 0;
        this.marcha = 0;
    }

    public Carro() {

    }

    public String getNomeCarro() {
        return nomeCarro;
    }

    public void setNomeCarro(String nomeCarro) {
        this.nomeCarro = nomeCarro;
    }

    public int getMarcha() {
        return marcha;
    }

    public void setMarcha(int marcha) {
        this.marcha = marcha;
    }

    public void criarCarro(){
        var nomeCarro = "";
        System.out.println("Digite o modelo do carro:");
        nomeCarro = scanner.next();

        Carro carro = new Carro(nomeCarro);
        return;
    }

    public void ligarCarro(){
        if(chave){
            System.out.println("O carro já está ligado");
            return;
        }
        if(!chave) {
            chave = true;
            System.out.println("Carro ligado com sucesso!");

        }
    }

    public void desligarCarro(){
        if(chave && marcha == 0 && velocimetro == 0){
            chave = false;
            System.out.println("O carro desligado com sucesso!");
        }
    }

    public void acelerarCarrro(){
        if(chave && acelerador){
            for (velocimetro = 0; velocimetro <=120; velocimetro ++){
                System.out.println("Velocidade: "+ velocimetro);
            }
            velocimetro--;
        }
    }

    public void acelerar(){
        acelerador = true;
        if(chave){
            acelerarCarrro();
        }
    }

    public void desacelerarCarrro(){
        if (chave && !acelerador){
            for (velocimetro = velocimetro; velocimetro > 0; velocimetro--) {
                System.out.println("Velocidade: "+ velocimetro);
            }
        }
    }

    public void virarVolante(){
        if (chave && (velocimetro > 0 && velocimetro <= 40)){
            var volante = "";
            System.out.println("Vire para direita com D ou esquerda com E:");
            volante = scanner.next().toUpperCase();
            if(volante.equals("D")){
                System.out.println("Volante virado para direita");
            }
            if(volante.equals("E")){
                System.out.println("Volante virado para esquerda");
            }
        }
        if(chave && !(velocimetro > 0 && velocimetro <= 40)){
            System.out.println("Não pode virar o volante!");
        }
    }

    public void mostrarVelocidade(){
        System.out.println("Velocidade: " + velocimetro);
    }

    public void trocarMarcha(){
        System.out.println("Marcha Atual é: "+ marcha);
        var visorMarcha = marcha;
        System.out.println("Engate a marcha:");
        marcha = scanner.nextInt();

        if(marcha - visorMarcha > 1 || visorMarcha - marcha > 1 ){
            System.out.println("Marcha errada!");
        }
        if(marcha - visorMarcha == 1 || visorMarcha - marcha == 1){

            if(chave && marcha == 0){
                acelerador = false;
            }
            if(chave && marcha == 1){
                acelerador = true;
                while(velocimetro > 0 && velocimetro <= 20){
                    acelerarCarrro();
                }
            }
            if(chave && marcha == 2){
                acelerador = true;
                acelerarCarrro();
                while(velocimetro > 20 && velocimetro <= 40){
                    acelerarCarrro();
                }
            }
            if(chave && marcha == 3){
                acelerador = true;
                acelerarCarrro();
                while(velocimetro > 40 && velocimetro <= 60){
                    acelerarCarrro();
                }
            }
            if(chave && marcha == 4){
                acelerador = true;
                acelerarCarrro();
                while(velocimetro > 60 && velocimetro <= 80){
                    acelerarCarrro();
                }
            }
            if(chave && marcha == 5){
                acelerador = true;
                acelerarCarrro();
                while(velocimetro > 80 && velocimetro <= 100){
                    acelerarCarrro();
                }
            }
            if(chave && marcha == 6){
                acelerador = true;
                acelerarCarrro();
                while(velocimetro > 100 && velocimetro <= 120){
                    acelerarCarrro();
                }
            }
        }

    }


}

