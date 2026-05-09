public class EntregadorMoto extends Entregador {

    public EntregadorMoto(String nome) {

        super(nome, "Moto", 60);

    }


    @Override
    public double calcularTempoEntrega(double distancia) {

        return distancia / getVelocidadeMedia();

    }

}