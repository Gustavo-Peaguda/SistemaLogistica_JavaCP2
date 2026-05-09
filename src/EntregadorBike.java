public class EntregadorBike extends Entregador {

    public EntregadorBike(String nome) {

        super(nome, "Bicicleta", 20);

    }

    @Override
    public double calcularTempoEntrega(double distancia) {

        return (distancia / getVelocidadeMedia()) + 1;

    }

}