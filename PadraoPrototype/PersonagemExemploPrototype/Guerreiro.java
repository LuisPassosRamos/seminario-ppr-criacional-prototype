package PersonagemExemploPrototype;

public class Guerreiro extends Personagem {
    private int forca;
    private int armadura;

    public Guerreiro(String nome, int nivel, int vida, int ataque, int defesa, int forca, int armadura) {
        super(nome, nivel, vida, ataque, defesa);
        this.forca = forca;
        this.armadura = armadura;
    }

    @Override
    public Guerreiro clone() {
        Guerreiro clone = (Guerreiro) super.clone();
        clone.forca = this.forca;
        clone.armadura = this.armadura;
        return clone;
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Força: " + forca);
        System.out.println("Armadura: " + armadura);
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getArmadura() {
        return armadura;
    }

    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }
}