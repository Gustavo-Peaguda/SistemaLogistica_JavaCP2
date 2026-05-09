import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        SistemaLogistica sistema = new SistemaLogistica();

        int opcao = -1;

        while (opcao != 0) {

            System.out.println("\n===== SISTEMA DE LOGÍSTICA =====");
            System.out.println("1 - Cadastrar entregador");
            System.out.println("2 - Criar entrega");
            System.out.println("3 - Listar entregadores");
            System.out.println("4 - Listar entregas");
            System.out.println("5 - Atribuir entrega");
            System.out.println("6 - Atualizar status");
            System.out.println("7 - Calcular tempo da entrega");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:

                    System.out.print("Nome do entregador: ");
                    String nome = scanner.nextLine().trim();

                    if (nome.isEmpty()) {

                        System.out.println("O nome do entregador não pode ser vazio.");
                        break;

                    }

                    System.out.println("1 - Moto");
                    System.out.println("2 - Bicicleta");
                    System.out.println("3 - Carro");

                    System.out.print("Escolha o tipo de entregador: ");
                    int tipo = scanner.nextInt();

                    scanner.nextLine();

                    Entregador entregador = null;

                    if (tipo == 1) {

                        entregador = new EntregadorMoto(nome);

                    } else if (tipo == 2) {

                        entregador = new EntregadorBike(nome);

                    } else if (tipo == 3) {

                        entregador = new EntregadorCarro(nome);

                    } else {

                        System.out.println("Tipo inválido.");
                        break;

                    }

                    sistema.cadastrarEntregador(entregador);

                    System.out.println("Entregador cadastrado com sucesso!");

                    break;

                case 2:

                    System.out.print("Endereço: ");
                    String endereco = scanner.nextLine().trim();


                    if (endereco.isEmpty()) {

                        System.out.println("O endereço não pode ser vazio.");
                        break;

                    }

                    System.out.print("Distância da entrega (km): ");
                    double distancia = scanner.nextDouble();

                    scanner.nextLine();


                    if (distancia <= 0) {

                        System.out.println("A distância não pode ser 0 ou negativa.");
                        break;

                    }

                    sistema.criarEntrega(endereco, distancia);

                    System.out.println("Entrega criada com sucesso!");

                    break;

                case 3:

                    sistema.listarEntregadores();

                    break;

                case 4:

                    sistema.listarEntregas();

                    break;

                case 5:

                    if (sistema.getEntregas().isEmpty() || sistema.getEntregadores().isEmpty()) {

                        System.out.println("Cadastre entregas e entregadores primeiro.");
                        break;

                    }

                    sistema.listarEntregas();

                    System.out.print("Escolha o ID da entrega: ");
                    int indiceEntrega = scanner.nextInt();

                    if (indiceEntrega < 0 || indiceEntrega >= sistema.getEntregas().size()) {

                        System.out.println("ID inválido.");
                        break;

                    }

                    sistema.listarEntregadores();

                    System.out.print("Escolha o ID do entregador: ");
                    int indiceEntregador = scanner.nextInt();

                    if (indiceEntregador < 0 || indiceEntregador >= sistema.getEntregadores().size()) {

                        System.out.println("ID inválido.");
                        break;

                    }

                    scanner.nextLine();


                    Entrega entrega = sistema.getEntregas().get(indiceEntrega);


                    Entregador entregadorSelecionado = sistema.getEntregadores().get(indiceEntregador);


                    entrega.atribuirEntregador(entregadorSelecionado);

                    System.out.println("Entrega atribuída com sucesso!");

                    break;

                case 6:

                    if (sistema.getEntregas().isEmpty()) {

                        System.out.println("Nenhuma entrega cadastrada.");
                        break;

                    }

                    sistema.listarEntregas();

                    System.out.print("Escolha o ID da entrega: ");
                    int indice = scanner.nextInt();

                    if (indice < 0 || indice >= sistema.getEntregas().size()) {

                        System.out.println("ID inválido.");
                        break;

                    }

                    System.out.println("\n===== STATUS =====");
                    System.out.println("1 - PENDENTE");
                    System.out.println("2 - EM ROTA");
                    System.out.println("3 - ENTREGUE");
                    System.out.println("4 - CANCELADA");

                    System.out.print("Escolha: ");
                    int novoStatus = scanner.nextInt();

                    scanner.nextLine();

                    Entrega entregaSelecionada =
                            sistema.getEntregas().get(indice);


                    entregaSelecionada.atualizarStatus(novoStatus);

                    System.out.println("Status atualizado com sucesso!");

                    break;

                case 7:

                    if (sistema.getEntregas().isEmpty()) {

                        System.out.println("Nenhuma entrega cadastrada.");
                        break;

                    }

                    sistema.listarEntregas();

                    System.out.print("Escolha o ID da entrega: ");
                    int indiceTempo = scanner.nextInt();

                    if (indiceTempo < 0 || indiceTempo >= sistema.getEntregas().size()) {

                        System.out.println("ID inválido.");
                        break;

                    }


                    Entrega entregaTempo = sistema.getEntregas().get(indiceTempo);

                    if (entregaTempo.getEntregador() == null) {

                        System.out.println("Essa entrega não possui entregador.");
                        break;

                    }


                    Entregador entregadorTempo = entregaTempo.getEntregador();


                    double distanciaEntrega = entregaTempo.getDistancia();


                    double tempo = entregadorTempo.calcularTempoEntrega(distanciaEntrega);


                    int horas = (int) tempo;

                    int minutos = (int) ((tempo - horas) * 60);

                    System.out.println(
                            "Tempo estimado:\n" + horas + " hora(s) e " + minutos + " minuto(s)");

                    break;

            }

        }

        scanner.close();

    }

}