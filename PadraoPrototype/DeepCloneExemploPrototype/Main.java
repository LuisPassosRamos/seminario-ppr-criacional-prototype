public class Main {
    public static void main(String[] args) {
        Endereco enderecoOriginal = new Endereco("Rua Enersto Melo", "SAJ");
        Pessoa pessoaOriginal = new Pessoa("João", 30, enderecoOriginal);

        Pessoa pessoaCopia = pessoaOriginal.clone();

        pessoaCopia.nome = "Maria";
        pessoaCopia.endereco.rua = "Rua Ipe Rosa";
        pessoaCopia.idade = 25;

        System.out.println("Pessoa Original: " + pessoaOriginal);
        System.out.println("Pessoa Cópia: " + pessoaCopia);
    }
}
