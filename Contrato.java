public class Contrato extends Documento {
    private String nomeCliente;

    public Contrato(String titulo, String conteudo, String nomeCliente) {
        super(titulo, conteudo);
        this.nomeCliente = nomeCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Contrato:");
        System.out.println("Título: " + getTitulo());
        System.out.println("Conteúdo: " + getConteudo());
        System.out.println("Cliente: " + nomeCliente);
        System.out.println();
    }
}
