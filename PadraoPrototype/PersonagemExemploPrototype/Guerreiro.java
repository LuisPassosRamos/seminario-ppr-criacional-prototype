package Personagem;

public class Guerreiro extends Personagem {
    private int força;
    private int armadura;

    public Guerreiro(String nome, int nivel, int vida, int ataque, int defesa, int força, int armadura) {
        super(nome, nivel, vida, ataque, defesa);
        this.força = força;
        this.armadura = armadura;
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Força: " + força);
        System.out.println("Armadura: " + armadura);
    }

    public int getForça() {
        return força;
    }

    public void setForça(int força) {
        this.força = força;
    }

    public int getArmadura() {
        return armadura;
    }

    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }
}
