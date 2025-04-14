public class PetMachine {

    private boolean clean = true;

    private int water = 30;

    private int shampoo = 10;

    private Pet pet;



    public void takeAShower() {
        if(this.pet == null){
            System.out.println("Coloque o pet na máquina para iniciar o banho");
            return;
        }
        pet.setClean(true);
        System.out.println("O pet "+ pet.getName() + "está limpo");

        this.water -= 10;
        this.shampoo -= 2;
    }

    public void addWater(){
        if(water == 30){
            System.out.println("A capacidade máqima da água da máquina está no máximo");
            return;
        }

        if(water < 30){
            water +=2;
        }
    }

    public void addShampoo(){
        if(shampoo == 10){
            System.out.println("A capacidade máqima da shampoo da máquina está no máximo");
            return;
        }

        if(shampoo < 10){
            water +=2;
        }
    }

    public int getShampoo() {
        return shampoo;
    }

    public int getWater() {
        return water;
    }

    public boolean hasPet(){
        return pet != null;
    }

    public void setPet(Pet pet) {
        if(hasPet()){
            System.out.println("O pet " + this.pet.getName() + " está na máquina nesse momento");
            return;
        }
        if(!this.clean){
            System.out.println("A máquina está suja, para colocar o pet é necessário limpá-la");
            return;
        }

        this.pet = pet;
    }

    public void removePet(){
        this.clean = this.pet.isClean();
        System.out.println("O pet " + this.pet.getName() + " está limpo");

        this.pet = null;
    }

    public void whash() {
        this.water -= 10;
        this.shampoo -= 2;
        this.clean = true;
        System.out.println("A máquina está limpa");
    }
}
