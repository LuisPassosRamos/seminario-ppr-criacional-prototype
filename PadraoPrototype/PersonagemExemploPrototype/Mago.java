package PersonagemExemploPrototype;

public class Mago extends Personagem {
    private int mana;
    private int poderMagico;

    public Mago(String nome, int nivel, int vida, int ataque, int defesa, int mana, int poderMagico) {
        super(nome, nivel, vida, ataque, defesa);
        this.mana = mana;
        this.poderMagico = poderMagico;
    }

    @Override
    public Mago clone() {
        Mago clone = (Mago) super.clone();
        clone.mana = this.mana;
        clone.poderMagico = this.poderMagico;
        return clone;
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Mana: " + mana);
        System.out.println("Poder Mágico: " + poderMagico);
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getPoderMagico() {
        return poderMagico;
    }

    public void setPoderMagico(int poderMagico) {
        this.poderMagico = poderMagico;
    }
}