# Prototype

## Intenção

Tem como objetivo permitir a criação de novos objetos a partir de um modelo (template) ou protótipo existente, em vez de criar uma nova instância do zero. Facilitando na criação de novos objetos que são complexos ou tem inicialização custosa, permitindo uma clonagem eficiente dos objetos, com a possibilidade de modificar ou customizar os novos objetos conforme necessário.



## Motivação




## Aplicabilidade



## Estrutura

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
## Participantes 
- Documento (abstrato)
- Contrato (clone)
- Relatorio (clone)

## Outro Exemplo


## Consequências
Prototype tem muitas das mesmas consequências que o Abstract Factory e Builder:
- Oculta as classes de produtos concretos do cliente, reduzindo a quantidade de informações que ele precisa conhecer, permitindo que o cliente crie novos objetos a partir de protótipos existentes, sem precisar entender ou interagir diretamente com o código das classes concretas.
  
### Benefícios adicionais do Prototype:

1.
2.
3.
4.
5.

- O ponto fraco do Prototype é a complexidade envolvida na clonagem de objetos com estruturas internas complexas. Quando um objeto possui referências a outros objetos ou contém um estado interno complexo, pode ser difícil garantir que a clonagem seja feita corretamente, sem gerar problemas como cópias superficiais em vez de cópias profundas (deep copies). Isso pode resultar em erros, como a modificação indesejada de objetos compartilhados entre o protótipo e suas cópias, além de aumentar a complexidade do código para gerenciar essas clonagens de maneira eficaz.





## Implementação 
-Pode ser um desafio implementar de maneira correta o padrão prototype, principalmente para implementar a operação clone, utilizar um gerenciador de prototipos
-Processo de clonagem
O processo de clonagem de um objeto pode ser feito usando duas abordagens:
1.Shallow Copy (ou cópia superficial): 
Copia os valores primitivos e as referências dos objetos, mas não os objetos em si. As referências no novo objeto apontam para os mesmos objetos que as do original, ou seja, o objeto pai é clonado, mas seus filhos são compartilhados entre os objetos.
2.Deep Copy (ou cópia profunda):
Copia o objeto e todos os objetos aos quais ele se refere, criando novas instâncias para todos os elementos. O objeto pai e todos os objetos contidos nele são clonados, garantindo que não haja referências compartilhadas.
## Exemplo de código 

## Usos Conhecidos 

## Padrões Relacionados 
Prototype e Abstract Factory têm em comum o objetivo de **abstrair a criação de objetos**, permitindo ao cliente criar instâncias sem conhecer detalhes de implementação. O Prototype cria objetos clonando um protótipo existente, enquanto o Abstract Factory cria famílias de objetos relacionados. Eles podem ser usados em conjunto, com o Abstract Factory coordenando e armazenando a criação de produtos (protótipos) e o Prototype permitindo clonar e personalizar esses objetos conforme necessário.

## Referências 

GAMMA, Erich; HELM, Richard; JOHNSON, Ralph; VLISSIDES, John. Padrões de Projetos: Soluções Reutilizáveis de Software Orientados a Objetos. Trad. Luiz A. Meirelles Salgado; Fabiano Borges Paulo. 1. ed. Porto Alegre: Bookman, 2000.


[Macoratti.net](https://macoratti.net/21/08/c_prototype1.htm#:~:text=Deep%20Copy%20(ou%20c%C3%B3pia%20profunda,os%20objetos%20que%20o%20cont%C3%AAm.)

[Mermaid Class Diagram.html](https://mermaid.js.org/syntax/classDiagram.html)

[Markdown](https://docs.github.com/pt/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax)
