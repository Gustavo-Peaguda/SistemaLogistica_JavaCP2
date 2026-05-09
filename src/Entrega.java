public class Entrega {

    private int id;
    private String endereco;
    private double distancia;
    private String status;
    private Entregador entregador;

    public Entrega(int id, String endereco, double distancia) {

        this.id = id;

        endereco = endereco.trim();

        if (endereco.isEmpty()) {

            System.out.println("Endereço inválido.");
            this.endereco = "";

        } else {

            this.endereco = endereco;

        }

        if (distancia <= 0) {

            System.out.println("A distância não pode ser 0 ou negativa.");
            this.distancia = 0;

        } else {

            this.distancia = distancia;

        }

        this.status = "PENDENTE";

    }


    public void atualizarStatus() {

        this.status = "EM ROTA";

    }


    public void atualizarStatus(String status) {

        this.status = status.toUpperCase().trim();

    }


    public void atualizarStatus(String status, boolean mensagem) {

        this.status = status.toUpperCase().trim();

        if (mensagem) {

            System.out.println("Status atualizado para: " + this.status);

        }

    }


    public void atualizarStatus(int opcaoStatus) {

        if (opcaoStatus == 1) {

            this.status = "PENDENTE";

        } else if (opcaoStatus == 2) {

            this.status = "EM ROTA";

        } else if (opcaoStatus == 3) {

            this.status = "ENTREGUE";

        } else if (opcaoStatus == 4) {

            this.status = "CANCELADA";

        } else {

            System.out.println("Status inválido.");

        }

    }

    public void atribuirEntregador(Entregador entregador) {

        this.entregador = entregador;

    }

    public void exibirEntrega() {

        System.out.println("\n========== ENTREGA ==========");
        System.out.println("ID: " + id);
        System.out.println("Endereço: " + endereco);
        System.out.println("Distância: " + distancia + " km");
        System.out.println("Status: " + status);

        if (entregador != null) {

            System.out.println("Entregador: " + entregador.getNome());
            System.out.println("Veículo: " + entregador.getVeiculo());

        } else {

            System.out.println("Nenhum entregador atribuído.");

        }

        System.out.println("=============================");

    }

    public int getId() {

        return id;

    }

    public String getStatus() {

        return status;

    }

    public double getDistancia() {

        return distancia;

    }

    public Entregador getEntregador() {

        return entregador;

    }

}