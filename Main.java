public class Main {
    public static void main(String[] args) {

        Relatorio modeloRelatorio = new Relatorio("Modelo de Relatório", "Este é o modelo base de um relatório.", "Autor Genérico");
        Relatorio relatorioFinanceiro = (Relatorio) modeloRelatorio.clone();
        relatorioFinanceiro.setTitulo("Relatório Financeiro");
        relatorioFinanceiro.setConteudo("Dados financeiros atualizados para o ano de 2024.");
        relatorioFinanceiro.setAutor("Maria Lima");

        Contrato modeloContrato = new Contrato("Modelo de Contrato", "Este é o modelo base de um contrato.", "Cliente Padrão");
        Contrato contratoVenda = (Contrato) modeloContrato.clone();
        contratoVenda.setTitulo("Contrato de Compra e Venda");
        contratoVenda.setConteudo("Termos e condições em acordo com o vendedor e o comprador.");
        contratoVenda.setNomeCliente("Lucas Ribeiro");

        modeloRelatorio.exibirDetalhes();
        relatorioFinanceiro.exibirDetalhes();

        modeloContrato.exibirDetalhes();
        contratoVenda.exibirDetalhes();
    }
}
