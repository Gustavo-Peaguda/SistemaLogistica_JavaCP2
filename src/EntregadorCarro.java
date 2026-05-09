public class EntregadorCarro extends Entregador {

    public EntregadorCarro(String nome) {

        super(nome, "Carro", 45);

    }

    @Override
    public double calcularTempoEntrega(double distancia) {

        return (distancia / getVelocidadeMedia()) + 0.5;

    }

}