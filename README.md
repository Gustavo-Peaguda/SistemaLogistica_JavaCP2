# Sistema de Logística para Entregas

Projeto desenvolvido em Java utilizando conceitos de Programação Orientada a Objetos (POO), simulando o funcionamento de um sistema de logística de entregas para e-commerce.

---

# Integrantes

- Enzo Fernandes - RM563705
- Felipe Cerazi - RM562746
- Gustavo Peaguda - RM562923
- Lorenzo Coque - RM563385

---

# Explicação do Sistema

O sistema foi desenvolvido para simular uma operação de entregas de um e-commerce, permitindo o gerenciamento de entregadores e entregas.

O usuário consegue:
- cadastrar entregadores
- criar entregas
- listar entregadores
- listar entregas
- atribuir entregas para entregadores
- atualizar o status das entregas
- calcular o tempo estimado da entrega

O sistema possui diferentes tipos de entregadores:
- Moto
- Bicicleta
- Carro

Cada tipo possui regras próprias de velocidade e cálculo de tempo de entrega.

O projeto foi desenvolvido utilizando os principais conceitos de Programação Orientada a Objetos:
- Herança
- Interfaces
- Classe Abstrata
- Sobrescrita
- Sobrecarga
- Encapsulamento
- Polimorfismo

---

# Como Executar o Projeto

## Requisitos
- Java JDK 17 ou superior
- IntelliJ IDEA (recomendado)

## Passos para executar

1. Clone o repositório:

```bash
git clone LINK_DO_REPOSITORIO
```

2. Abra o projeto no IntelliJ IDEA.

3. Localize a classe:

```text
Main.java
```

4. Execute o método `main()`.

5. O sistema será iniciado no terminal com um menu interativo.

---

# Estrutura do Projeto

```text
src/
│
├── Main.java
├── SistemaLogistica.java
├── Entrega.java
├── Entregador.java
├── EntregadorMoto.java
├── EntregadorBike.java
├── EntregadorCarro.java
└── Calculavel.java
```

---

# Diagrama UML

## Explicação do Diagrama

O diagrama UML representa toda a estrutura do sistema e os relacionamentos entre as classes.

### Interface
A interface `Calculavel` define o método responsável pelo cálculo do tempo de entrega.

### Classe Abstrata
A classe `Entregador` representa um modelo genérico de entregador, contendo atributos e métodos compartilhados por todos os tipos de entregadores.

### Herança
As classes:
- `EntregadorMoto`
- `EntregadorBike`
- `EntregadorCarro`

herdam da classe `Entregador`.

### Associação
A classe `Entrega` possui associação com `Entregador`, pois uma entrega pode possuir um entregador responsável.

A classe `SistemaLogistica` possui relacionamento com:
- Entrega
- Entregador

pois ela gerencia as listas do sistema.

---

# Relações UML Utilizadas

| Relação | Utilização |
|---|---|
| Herança | Moto, Bike e Carro herdam de Entregador |
| Interface | Entregador implementa Calculavel |
| Associação | Entrega possui um Entregador |
| Dependência | Main utiliza SistemaLogistica |

---

# Perguntas Discursivas

## 1. Herança

No sistema desenvolvido, a herança foi utilizada para representar os diferentes tipos de entregadores existentes na operação logística.

Foi criada uma classe abstrata chamada `Entregador`, que contém os atributos e comportamentos comuns entre todos os entregadores, como:
- nome
- veículo
- velocidade média
- método de cálculo de tempo de entrega

A partir dela, foram criadas as classes:
- `EntregadorMoto`
- `EntregadorBike`
- `EntregadorCarro`

Essas classes herdam as características da classe `Entregador`, mas possuem comportamentos diferentes no método `calcularTempoEntrega()`.

A herança resolveu o problema de repetição de código, permitindo reutilizar atributos e métodos comuns, além de organizar melhor o sistema. Também facilitou a aplicação do polimorfismo, já que cada tipo de entregador possui uma forma diferente de calcular o tempo da entrega.

---

## 2. Interfaces

A interface criada no sistema foi a `Calculavel`.

Ela possui o método:

```java
double calcularTempoEntrega(double distancia);
```

A interface foi utilizada para garantir que todos os os tipos de entregadores implementassem obrigatoriamente o cálculo de tempo de entrega.

A principal vantagem da interface foi padronizar esse comportamento no sistema, garantindo que todas as classes relacionadas aos entregadores possuam esse método, mesmo que cada uma tenha sua própria implementação.

Além disso, a interface contribuiu para a aplicação de conceitos de Programação Orientada a Objetos, como abstração e polimorfismo.

---

## 3. Classe Abstrata

A classe abstrata do sistema é a classe `Entregador`.

Ela foi criada para representar um modelo genérico de entregador, contendo atributos e métodos comuns para todos os os tipos existentes no sistema.

A classe abstrata possui:
- nome
- veículo
- velocidade média
- método de exibição de dados

Além disso, ela possui o método abstrato:

```java
calcularTempoEntrega()
```

que é implementado de maneira diferente nas subclasses.

Ela não poderia ser uma classe comum porque não faz sentido existir um “Entregador genérico” no sistema. Todo entregador precisa ser de um tipo específico, como moto, bicicleta ou carro.

A utilização da classe abstrata também ajudou a evitar a criação de objetos incompletos e permitiu organizar melhor a herança do sistema.
