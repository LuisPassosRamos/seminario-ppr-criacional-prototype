class Pessoa implements Cloneable {
    String nome;
    int idade;
    Endereco endereco;

    public Pessoa(String nome, int idade, Endereco endereco) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

    @Override
    public Pessoa clone() {
        try {
            Pessoa copia = (Pessoa) super.clone();
            copia.endereco = this.endereco.clone();
            return copia;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "Pessoa{nome='" + nome + "', idade=" + idade + ", endereco=" + endereco + "}";
    }
}
