package Personagem;

public class Main {
    public static void main(String[] args) {
        Guerreiro guerreiro1 = new Guerreiro("Thor", 10, 200, 50, 40, 80, 100);
        Mago mago1 = new Mago("Merlin", 12, 100, 40, 30, 150, 200);

        Guerreiro guerreiro2 = (Guerreiro) guerreiro1.clone();
        Guerreiro guerreiro3 = (Guerreiro) guerreiro2.clone();
        guerreiro3.setArmadura(200);
        guerreiro3.setForça(200);

        Mago mago2 = (Mago) mago1.clone();
        Mago mago3 = (Mago) mago2.clone();
        mago3.setMana(300);
        mago3.setPoderMagico(500);

        System.out.println("Detalhes do Guerreiro 1:");
        guerreiro1.exibirDetalhes();
        System.out.println();

        System.out.println("Detalhes do Guerreiro 2 (Clone):");
        guerreiro2.exibirDetalhes();
        System.out.println();

        System.out.println("Detalhes do Guerreiro 3 (Clone do clone melhorado):");
        guerreiro3.exibirDetalhes();
        System.out.println();



        System.out.println("Detalhes do Mago 1:");
        mago1.exibirDetalhes();
        System.out.println();

        System.out.println("Detalhes do Mago 2 (Clone):");
        mago2.exibirDetalhes();
        System.out.println();

        System.out.println("Detalhes do Mago 3 (Clone do clone melhorado):");
        mago3.exibirDetalhes();
        System.out.println();

    }
}
