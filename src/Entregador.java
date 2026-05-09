public abstract class Entregador implements Calculavel {

    private String nome;
    private String veiculo;
    private double velocidadeMedia;

    public Entregador(String nome, String veiculo, double velocidadeMedia) {

        this.nome = nome;
        this.veiculo = veiculo;
        this.velocidadeMedia = velocidadeMedia;

    }


    public void exibirDados(int id) {

        System.out.println("\n========== ENTREGADOR ==========");
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Veículo: " + veiculo);
        System.out.println("Velocidade Média: " + velocidadeMedia + " km/h");
        System.out.println("===============================");

    }


    @Override
    public abstract double calcularTempoEntrega(double distancia);

    public String getNome() {

        return nome;

    }

    public String getVeiculo() {

        return veiculo;

    }

    public double getVelocidadeMedia() {

        return velocidadeMedia;

    }

}