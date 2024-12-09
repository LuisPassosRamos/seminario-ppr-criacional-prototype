# Seminario Prototype

## introdução 

- Documento (abstrato)
- Contrato (clone)
- Relatorio (clone)

```mermaid
---
title: Sistema de Documentos
---
classDiagram
    Documento <|-- Relatorio
    Documento <|-- Contrato
    class Documento {
        +String titulo
        +String conteudo
        +clone() Documento
        +exibirDetalhes() void
    }
    class Relatorio {
        +String autor
        +exibirDetalhes() void
    }
    class Contrato {
        +String nomeCliente
        +exibirDetalhes() void
    }
    note for Relatorio "Relatórios personalizados como Relatório Financeiro"
    note for Contrato "Contratos específicos como Compra e Venda"


```

[Mermaid Class Diagram.html](https://mermaid.js.org/syntax/classDiagram.html)

[Markdown](https://docs.github.com/pt/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax)
