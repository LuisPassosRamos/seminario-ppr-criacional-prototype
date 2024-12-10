# Builder

## Intenção
Separar a construção de um objeto complexo da sua representação de modo que o
mesmo processo de construção possa criar diferentes representações.
## Motivação 

Imagine que você está construindo casas. Cada casa pode ter diferentes características, como materiais, design, número de cômodos, ou até mesmo o estilo arquitetônico (moderno, clássico, minimalista).

Em vez de construir cada casa do zero manualmente e misturar todos os detalhes da construção, você contrata um arquiteto (o Builder). Esse arquiteto é especializado em planejar e organizar os passos para criar casas específicas de acordo com as suas necessidades. Um gerente de obra (o Director) coordena o trabalho do arquiteto, garantindo que a construção siga o plano correto.

Se você quiser construir uma casa moderna, contrata um arquiteto especializado em design moderno. Se preferir uma casa clássica, escolhe outro arquiteto. O gerente de obras é sempre o mesmo, mas ele coordena o trabalho com base no arquiteto selecionado.

Aplicando ao software:
O Builder é útil quando você precisa criar diferentes representações ou versões de um objeto complexo, mas quer manter o processo de criação (a lógica de montagem) separado dos detalhes específicos de cada versão. Ele permite que você:

Reaproveite a lógica do "gerente" (o Director) para criar objetos diferentes.
Simplifique a manutenção e a adição de novos tipos de representações sem modificar o processo principal.

## Participantes do Builder: references GOF

- **Builder(TextConverter)**
    -  especifica uma interface abstrata para criação de partes de um objetoproduto.
    
- **ConcreteBuilder** (ASCIIConverter, TeXConverter, TextWidgetConverter)
    -  constrói e monta partes do produto pela implementação da interface de Builder;
    -  define e mantém a representação que cria;
    -  Fornece uma interface para recuperação do produto (por exemplo, GetASCIIText, GetTextWidget).
    
- **Director (RTFReader)**
    - constrói um objeto usando a interface de Builder.
    
- **Product (ASCIIText, TeXText, TextWidget)**.
    -  representa o objeto complexo em construção. ConcreteBuilder constrói a representação interna do produto e define o processo pelo qual ele é montado;
    -  inclui classes que definem as partes constituintes, inclusive as interfaces para a montagem das partes no resultado final.
      
## Estrutura
![image](https://github.com/user-attachments/assets/61d9ebe7-e9a8-4beb-845a-50c1f66427c7)

## Participantes da motivação:

- **Builder (Arquiteto)**  
  - Especifica uma interface abstrata para projetar e montar as partes de uma casa (ou produto).  
  - **Exemplo**: Planeja os cômodos, o telhado, as portas e outros detalhes estruturais.

- **ConcreteBuilder (Arquiteto de Casa Moderna, Arquiteto de Casa Clássica)**  
  - Implementa a interface do Builder para criar partes específicas da casa.  
  - Define e mantém os detalhes e o design específico da casa sendo construída.  
  - Fornece o método para recuperar a casa pronta (por exemplo, `GetModernHouse()` ou `GetClassicHouse()`).  
  - **Exemplo**: Um arquiteto especializado em casas modernas cria designs com janelas amplas e linhas retas, enquanto o de casas clássicas prioriza ornamentos e telhados inclinados.

- **Director (Gerente de Obras)**  
  - Coordena o processo de construção seguindo um plano pré-definido.  
  - Não se preocupa com os detalhes de cada tipo de casa, apenas segue o plano do arquiteto escolhido.  
  - **Exemplo**: O gerente supervisiona os trabalhadores para garantir que as casas modernas ou clássicas sejam construídas corretamente.

- **Product (Casa)**  
  - Representa o objeto final criado.  
  - É o resultado do trabalho coordenado pelo Director e definido pelo ConcreteBuilder.  
  - **Exemplo**: A casa moderna com janelas amplas e linhas retas, ou a casa clássica com ornamentos e telhado inclinado.

## Estrutura:

```mermaid
---
title: Padrão Builder - Construção de Casas
classDiagram
    class Diretor {
        +construir(builder: Construtor)
    }
    class Construtor {
        <<interface>>
        +construirFundacao()
        +construirParedes()
        +construirTelhado()
        +obterResultado(): Casa
    }
    class ConstrutorCasaModerna {
        +construirFundacao()
        +construirParedes()
        +construirTelhado()
        +obterResultado(): CasaModerna
    }
    class Casa {
    }
    Diretor o-- Construtor : builder
    Construtor <|-- ConstrutorCasaModerna
    ConstrutorCasaModerna --> Casa

```
### Exemplo:

```java

class Casa {
    private String fundacao;
    private String paredes;
    private String telhado;

    public void setFundacao(String fundacao) {
        this.fundacao = fundacao;
    }

    public void setParedes(String paredes) {
        this.paredes = paredes;
    }

    public void setTelhado(String telhado) {
        this.telhado = telhado;
    }

    @Override
    public String toString() {
        return "Casa com fundação: " + fundacao + ", paredes: " + paredes + ", telhado: " + telhado;
    }
}

// Interface Builder
abstract class ConstrutorCasa {
    protected Casa casa;

    public void criarNovaCasa() {
        casa = new Casa();
    }

    public Casa getCasa() {
        return casa;
    }

    public abstract void construirFundacao();
    public abstract void construirParedes();
    public abstract void construirTelhado();
}

// ConcreteBuilder: ConstrutorCasaModerna
class ConstrutorCasaModerna extends ConstrutorCasa {

    @Override
    public void construirFundacao() {
        casa.setFundacao("Fundação de concreto reforçado");
    }

    @Override
    public void construirParedes() {
        casa.setParedes("Paredes de vidro e aço");
    }

    @Override
    public void construirTelhado() {
        casa.setTelhado("Telhado plano com painéis solares");
    }
}

// ConcreteBuilder: ConstrutorCasaClassica
class ConstrutorCasaClassica extends ConstrutorCasa {

    @Override
    public void construirFundacao() {
        casa.setFundacao("Fundação de concreto tradicional");
    }

    @Override
    public void construirParedes() {
        casa.setParedes("Paredes de tijolo");
    }

    @Override
    public void construirTelhado() {
        casa.setTelhado("Telhado inclinado de telhas cerâmicas");
    }
}

// Diretor
class Diretor {
    private ConstrutorCasa construtor;

    public void setConstrutor(ConstrutorCasa construtor) {
        this.construtor = construtor;
    }

    public void construirCasa() {
        construtor.criarNovaCasa();
        construtor.construirFundacao();
        construtor.construirParedes();
        construtor.construirTelhado();
    }

    public Casa getCasa() {
        return construtor.getCasa();
    }
}

public class BuilderExample {
    public static void main(String[] args) {
        Diretor diretor = new Diretor();

        // Construir uma casa moderna
        ConstrutorCasa construtorModerno = new ConstrutorCasaModerna();
        diretor.setConstrutor(construtorModerno);
        diretor.construirCasa();
        System.out.println(diretor.getCasa());

        // Construir uma casa clássica
        ConstrutorCasa construtorClassico = new ConstrutorCasaClassica();
        diretor.setConstrutor(construtorClassico);
        diretor.construirCasa();
        System.out.println(diretor.getCasa());
    }
}
```
[Mermaid Class Diagram.html](https://mermaid.js.org/syntax/classDiagram.html)

[Markdown](https://docs.github.com/pt/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax)
