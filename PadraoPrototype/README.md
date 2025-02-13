# Prototype

### Padrão de Projeto Criacional

## Intenção

Tem como objetivo permitir a criação de novos objetos a partir de um modelo (template) ou protótipo existente, em vez de criar uma nova instância do zero. Facilitando na criação de novos objetos que são complexos ou tem inicialização custosa, permitindo uma clonagem eficiente dos objetos, com a possibilidade de modificar ou customizar os novos objetos conforme necessário.



## Motivação

Imagine que você trabalha em uma empresa de automação de processos, e o desafio do momento é criar um sistema de gerenciamento de documentos. Cada documento pode ter um título e conteúdo personalizado, como contratos, atas de reunião e propostas comerciais.

Inicialmente, você planejou criar novas instâncias de documentos usando construtores para preencher manualmente o título e o conteúdo. Mas, à medida que os requisitos cresceram, ficou claro que certos documentos, como um contrato padrão ou uma ata de reunião básica, eram frequentemente reutilizados com pequenas alterações. Cada vez que um usuário queria criar um novo contrato, precisava preencher todos os detalhes novamente, o que era ineficiente e sujeito a erros.

Então, surge a ideia: e se você pudesse simplesmente clonar um modelo existente de documento, ajustando apenas as informações necessárias? É aqui que o padrão Prototype entra em cena.

No seu sistema, você implementa uma classe abstrata Documento que define o título e o conteúdo. Essa classe também implementa a interface Cloneable para permitir que instâncias de documentos sejam copiadas. Com isso, você pode criar protótipos de documentos (como "Contrato Padrão" ou "Ata Básica") e simplesmente cloná-los quando necessário.

Por exemplo:

Quando o departamento de vendas precisa de um novo contrato, o sistema clona o protótipo do contrato padrão e insere as informações do cliente.
Para atas de reunião, o sistema utiliza o protótipo da ata básica, ajustando o conteúdo com os detalhes da reunião específica.


## Aplicabilidade
O padrão Prototype é ideal em cenários onde se busca maior flexibilidade e eficiência no processo de criação de objetos. Ele é recomendado nos seguintes casos:

Independência da criação de objetos: Quando é necessário que o sistema funcione de forma independente de como os objetos são criados, compostos ou representados. Isso reduz o acoplamento e simplifica a manutenção.

Definição dinâmica das classes a serem instanciadas: Em situações onde as classes de objetos precisam ser especificadas durante a execução do programa, como em sistemas que utilizam carregamento dinâmico de dados ou componentes.

Evitar hierarquias de classes complexas: Quando seria necessário criar uma hierarquia paralela de classes de fábrica para suportar a criação de produtos. O Prototype elimina essa necessidade ao permitir que os objetos sejam clonados diretamente.

Gerenciamento eficiente de estados diferentes: Quando uma classe pode assumir apenas um número limitado de combinações de estados, é mais prático criar protótipos para cada configuração inicial e cloná-los conforme necessário, em vez de configurar manualmente cada instância repetidamente.


## Estrutura

```mermaid
---
title: Sistema de Documentos (Prototype)
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
        +clone() Documento
        +exibirDetalhes() void
    }
    note for Relatorio "Clone personalizado (ex: Relatório Financeiro)"
    class Contrato {
        +String nomeCliente
        +clone() Documento
        +exibirDetalhes() void
    }
    note for Contrato "Clone específico (ex: Contrato de Compra e Venda)"
```
## Participantes 

- Documento (abstrato): Define os atributos e métodos comuns de um documento. 
- Contrato (clone): Utiliza como modelo (template) a classe documento, e adiciona um atrituto específico do contrato.
- Relatorio (clone): Utiliza como modelo (template) a classe documento, e adiciona um atrituto específico do relatório.

## Outro Exemplo
```mermaid
---
title: Criação de Personagens (Prototype) com Clonagem
---
classDiagram
    Personagem <|-- Guerreiro
    Personagem <|-- Mago
    class Personagem {
        +String nome
        +int nivel
        +int vida
        +int ataque
        +int defesa
        +clone() Personagem
        +exibirDetalhes() void
    }
    note for Personagem "Classe base para todos os personagens"

    class Guerreiro {
        +int forca
        +int armadura
        +clone() Guerreiro
        +exibirDetalhes() void
        +setForca(int) void
        +setArmadura(int) void
    }
    note for Guerreiro "Personagem com alta defesa e força física"

    Guerreiro <|-- Guerreiro1
    Guerreiro1 <|-- Guerreiro2
    class Guerreiro1 {
        +nome: "Thor"
        +nivel: 10
        +vida: 200
        +ataque: 50
        +defesa: 40
        +forca: 80
        +armadura: 100
    }
    class Guerreiro2 {
        +nome: "Thor"
        +nivel: 10
        +vida: 200
        +ataque: 50
        +defesa: 40
        +forca: 200
        +armadura: 200
    }
    note for Guerreiro1 "Guerreiro original"
    note for Guerreiro2 "Clone melhorado (força e armadura aumentadas)"

    class Mago {
        +int mana
        +int poderMagico
        +clone() Mago
        +exibirDetalhes() void
        +setMana(int) void
        +setPoderMagico(int) void
    }
    note for Mago "Personagem com habilidades mágicas e alto poder de ataque"

    Mago <|-- Mago1
    Mago1 <|-- Mago2
    class Mago1 {
        +nome: "Merlin"
        +nivel: 12
        +vida: 100
        +ataque: 40
        +defesa: 30
        +mana: 150
        +poderMagico: 200
    }
    class Mago2 {
        +nome: "Merlin"
        +nivel: 12
        +vida: 100
        +ataque: 40
        +defesa: 30
        +mana: 300
        +poderMagico: 500
    }
    note for Mago1 "Mago original"
    note for Mago2 "Clone melhorado (mana e poder mágico aumentados)"
```
## Participantes

- Personagem (abstrato): Classe abstrata que define os atributos e métodos comuns para todos os personagens.
- Guerreiro: Representa um personagem do tipo Guerreiro, com atributos relacionados à força física e defesa.
- Guerreiro1: Representa o guerreiro original, com atributos iniciais, forca: 80, armadura: 100
- Guerreiro2 (clone): Representa o clone do Guerreiro1, com atributos melhorados, forca: 200, armadura: 200
- Mago: Representa um personagem do tipo Mago, com atributos relacionados à mana e habilidades mágicas.
- Mago1: Representa o mago original, com atributos iniciais, mana: 150, poderMagico: 200
- Mago2 (clone): Representa o clone do Mago1, com atributos melhorados, mana: 300, poderMagico: 500


## Diferença entre Herança e Clone 
- Herança: Define uma relação "é um" entre classes. A subclasse herda comportamentos e atributos da superclasse, mas o comportamento é fixo após a definição da classe.

- Prototype: Define uma relação "copia de" entre objetos. Você cria novos objetos clonando um protótipo existente e personalizando conforme seja necessário, o que permite flexibilidade em tempo de execução.


## Consequências
Prototype tem muitas das mesmas consequências que o Abstract Factory e Builder:
- Oculta as classes de produtos concretos do cliente, reduzindo a quantidade de informações que ele precisa conhecer, permitindo que o cliente crie novos objetos a partir de protótipos existentes, sem precisar entender ou interagir diretamente com o código das classes concretas.

##  Como linguagens que não são Orientadas a Objetos simulam herança utilizando o Padrão de Projeto Prototype
- Em linguagens que não são orientadas a objetos, o Padrão Prototype pode ser usado para simular herança através da clonagem de objetos ou estruturas de dados. A ideia central é criar um "protótipo" (um objeto ou estrutura base) e, a partir dele, gerar cópias que podem ser personalizadas com atributos ou comportamentos específicos.

- Por exemplo, em linguagens como JavaScript, Python ou até mesmo C, é possível usar dicionários, objetos literais, structs ou funções para criar um protótipo base. Esse protótipo é então clonado, e as cópias são modificadas para adicionar características únicas, simulando o conceito de herança.

- Essa abordagem permite reutilizar e estender funcionalidades sem a necessidade de classes ou herança tradicional, sendo uma solução flexível e eficaz em linguagens que não possuem suporte nativo a orientação a objetos.

### Benefícios adicionais do Prototype:

1. Modificação dinâmica de protótipos: O padrão permite modificar ou estender protótipos de objetos durante a execução do programa.
2. Criação de objetos com valores variados: Permite criar novos objetos com diferentes valores baseados em um protótipo, ajustando suas propriedades conforme necessário.
3. Variação de estrutura através de clonagem: A estrutura de um objeto pode ser alterada ao cloná-lo a partir de um protótipo e adicionar ou modificar seus atributos.
4. Redução de subclasses: Evita a criação de múltiplas subclasses, criando objetos a partir de protótipos e personalizando-os conforme necessário.
5. Criação dinâmica de objetos: O padrão Prototype permite criar e configurar objetos de maneira dinâmica, sem a necessidade de uma hierarquia rígida de classes.

- O ponto fraco do Prototype é a complexidade envolvida na clonagem de objetos com estruturas internas complexas. Quando um objeto possui referências a outros objetos ou contém um estado interno complexo, pode ser difícil garantir que a clonagem seja feita corretamente, sem gerar problemas como cópias superficiais em vez de cópias profundas (deep copies). Isso pode resultar em erros, como a modificação indesejada de objetos compartilhados entre o protótipo e suas cópias, além de aumentar a complexidade do código para gerenciar essas clonagens de maneira eficaz.





## Implementação 
 ### Pode ser um desafio implementar de maneira correta o padrão prototype, dentre eles:
1. Implementar a operação de clonagem corretamente : O padrão Prototype exige a implementação de uma operação de clonagem precisa para garantir que o novo objeto seja uma cópia exata do protótipo, sem causar problemas como referências compartilhadas inadvertidas.

2. Gerenciar protótipos de forma eficiente : Em sistemas complexos, pode ser difícil organizar e manter os protótipos de maneira eficiente, garantindo que eles sejam facilmente reutilizáveis e adaptáveis para diferentes tipos de objetos.

3. Garantir a inicialização adequada dos clones: Quando se clona um objeto, é importante garantir que a inicialização do clone seja feita corretamente, com todos os atributos e estados sendo copiados ou ajustados de acordo com o comportamento desejado.

### Processo de clonagem
  
O processo de clonagem de um objeto pode ser feito usando duas abordagens:

1. Shallow Copy (ou cópia superficial): 
Copia os valores primitivos e as referências dos objetos, mas não os objetos em si. As referências no novo objeto apontam para os mesmos objetos que as do original, ou seja, o objeto pai é clonado, mas seus filhos são compartilhados entre os objetos.

2. Deep Copy (ou cópia profunda):
Copia o objeto e todos os objetos aos quais ele se refere, criando novas instâncias para todos os elementos. O objeto pai e todos os objetos contidos nele são clonados, garantindo que não haja referências compartilhadas.

- Na implementação, você pode achar o prototype bastante parecido com a **Herança**, pois ambos permitem que objetos ou classes compartilhem propriedades e métodos. No entanto, eles são diferentes em sua implementação e estrutura.
  
- A herança clássica é baseada em classes e estabelece uma hierarquia fixa entre elas, onde as subclasses herdam os métodos e propriedades das classes pai. Já o prototype é baseado em objetos e referências de protótipos, permitindo que objetos compartilhem comportamento dinamicamente. A herança clássica é mais rígida e hierárquica, enquanto o prototype oferece flexibilidade, pois as relações podem ser modificadas em tempo de execução.
  
- Dito isso, no JavaScript, é possível simular o mecanismo da herança, utilizando o prototype para compartilhar propriedades e métodos entre objetos. Embora o JavaScript não tenha um sistema de classes como em linguagens tradicionais, ele permite que objetos "herdem" comportamentos de outros objetos por meio das suas referências de protótipo. Isso é feito de forma dinâmica, permitindo flexibilidade, como a capacidade de modificar ou substituir o protótipo de um objeto a qualquer momento, sem a necessidade de uma hierarquia fixa de classes.

## Exemplo de código 
### 1. Criando classe abstrata, que servirá como protótipo
```java
 public abstract class Documento implements Cloneable {
    private String titulo;
    private String conteudo;

    public Documento(String titulo, String conteudo) {
        this.titulo = titulo;
        this.conteudo = conteudo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}

public interface Phone {
    void getDetails();
}

public class AndroidPhone implements Phone {
    public void getDetails() {
        System.out.println("Telefone Android criado.");
    }
}

public class IPhone implements Phone {
    public void getDetails() {
        System.out.println("iPhone criado.");
    }
}

public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    @Override
    public Documento clone() {
        try {
            return (Documento) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Erro ao clonar documento!", e);
        }
    }

    public abstract void exibirDetalhes();
}
 
```
**Explicação: A classe Documento é abstrata e implementa a interface Cloneable, permitindo que objetos derivados sejam clonados. Ela possui dois atributos, titulo e conteudo, com métodos getters e setters para acesso e modificação. O método clone() é sobrescrito para criar uma cópia do documento utilizando o método super.clone(), realizando uma clonagem superficial. Além disso, a classe contém um método abstrato exibirDetalhes(), que deve ser implementado pelas subclasses para exibir informações específicas do documento. Essa estrutura facilita a criação de diferentes tipos de documentos com base em um modelo comum.**

### 2. Criando a classe Contrato, que é uma cópia da classe Documento
```java
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
```
**Explicação: A classe Contrato estende a classe Documento e adiciona um atributo específico, nomeCliente, que representa o nome do cliente associado ao contrato. O construtor da classe Contrato chama o construtor da classe pai Documento para inicializar os atributos titulo e conteudo, além de inicializar nomeCliente. Os métodos getNomeCliente() e setNomeCliente() permitem acessar e modificar o nome do cliente. O método exibirDetalhes() é uma implementação do método abstrato da classe pai, exibindo as informações completas do contrato, incluindo o título, o conteúdo e o nome do cliente, proporcionando uma exibição dos detalhes do contrato.**

### 3. Conclusão
O código define uma estrutura de documentos utilizando o padrão Prototype. A classe Documento é abstrata e implementa a interface Cloneable, permitindo a clonagem de objetos. Ela possui atributos básicos como titulo e conteudo, com métodos para acessá-los e modificá-los, e um método abstrato exibirDetalhes() que deve ser implementado nas subclasses. A classe Contrato estende Documento, adicionando o atributo nomeCliente e implementando o método exibirDetalhes() para mostrar informações específicas do contrato. Essa estrutura permite a criação de documentos clonáveis e personalizados, como contratos, facilitando a reutilização e modificação de objetos sem a necessidade de reescrever todo o conteúdo.






## Usos Conhecidos 

### O padrão Prototype está bastante presente nos dias atuais, exploraremos alguns exemplos práticos utilizados no dia a dia, tanto no desenvolvimento de software quanto em outras áreas, que por muitas vezes acabamos nem percebendo.

1. Desenvolvimento de Jogos:

Unity e Unreal Engine: Ao criar NPCs (personagens não jogáveis) em jogos, desenvolvedores geralmente definem um protótipo básico para cada tipo de personagem (ex.: soldado, mago). Depois, esses protótipos são clonados e ajustados com atributos específicos (como aparência, habilidades ou comportamento) para economizar tempo e recursos. Um mago genérico pode servir de base para criar variações como "Mago de Gelo" ou "Mago de Fogo", ajustando apenas as habilidades.

2. Gerenciamento de Documentos e Relatórios:

Microsoft Office Templates: Usuários criam um modelo de documento no Word ou Excel e depois clonam esse modelo para criar documentos ou planilhas específicos. O protótipo carrega o layout, estilos e formatos pré-definidos, economizando esforço.

3. Interfaces de Usuário (UI):

ReactJS e Angular: No desenvolvimento frontend, componentes reutilizáveis como botões, cards e formulários são criados como protótipos. Esses componentes são clonados e personalizados com propriedades específicas, como cor, texto ou comportamento.

Frameworks de design como Material UI ou Bootstrap fornecem protótipos básicos de elementos da interface que podem ser ajustados rapidamente.

4. Gerenciamento de Configurações:

Em sistemas que exigem configurações dinâmicas, como em plataformas de e-commerce ou jogos, o padrão Prototype pode ser usado para criar novas configurações baseadas em um modelo inicial. Isso é útil quando as configurações de diferentes módulos ou componentes são semelhantes, mas com pequenas variações.
Em jogos como The Sims, o padrão Prototype é usado para configurar objetos e suas variações (por exemplo, diferentes tipos de sofás com variações de cor e textura).

5. Fluxos de Trabalho e Processos:

O conceito de clonagem de fluxos de trabalho ou processos é uma aplicação interessante do padrão Prototype. Isso permite a criação de diferentes versões de um processo com variações mínimas, com base em um modelo genérico.

GitHub permite configurar templates (protótipos) para issues e pull requests, que podem ser clonados e personalizados para diferentes necessidades ou projetos.

GitHub Actions permite criar workflows (fluxos de trabalho) automatizados para CI/CD (Integração Contínua/Entrega Contínua). Um workflow pode ser criado como um protótipo para tarefas específicas, e versões clonadas desse protótipo podem ser personalizadas para diferentes repositórios ou projetos.

Jira (Gestão de Projetos):
No Jira, fluxos de trabalho padrão, como o de desenvolvimento de software, são criados como protótipos. Um fluxo típico pode incluir os estados "To Do", "In Progress", "In Review", e "Done", com transições pré-definidas entre eles. Esses fluxos podem ser clonados e ajustados para diferentes equipes ou projetos

6. Produção em Massa de Produtos:

Indústria Automobilística: Fabricantes de carros, como Toyota ou Tesla, utilizam protótipos para criar diferentes versões de um modelo base. Um carro protótipo pode servir de base para variações, como diferentes motores, cores ou funcionalidades.

No desenvolvimento de produtos digitais, impressoras 3D utilizam o conceito de protótipos para imprimir variações de um modelo básico com ajustes personalizados.


## Padrões Relacionados 
Prototype e Abstract Factory têm em comum o objetivo de **abstrair a criação de objetos**, permitindo ao cliente criar instâncias sem conhecer detalhes de implementação. O Prototype cria objetos clonando um protótipo existente, enquanto o Abstract Factory cria famílias de objetos relacionados. Eles podem ser usados em conjunto, com o Abstract Factory coordenando e armazenando a criação de produtos (protótipos) e o Prototype permitindo clonar e personalizar esses objetos conforme necessário.

## Referências 

GAMMA, Erich; HELM, Richard; JOHNSON, Ralph; VLISSIDES, John. Padrões de Projetos: Soluções Reutilizáveis de Software Orientados a Objetos. Trad. Luiz A. Meirelles Salgado; Fabiano Borges Paulo. 1. ed. Porto Alegre: Bookman, 2000.


[Macoratti.net](https://macoratti.net/21/08/c_prototype1.htm#:~:text=Deep%20Copy%20(ou%20c%C3%B3pia%20profunda,os%20objetos%20que%20o%20cont%C3%AAm. )