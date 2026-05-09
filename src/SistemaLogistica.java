import java.util.ArrayList;

public class SistemaLogistica {

    private ArrayList<Entregador> entregadores;
    private ArrayList<Entrega> entregas;

    public SistemaLogistica() {

        entregadores = new ArrayList<>();
        entregas = new ArrayList<>();

    }

    public void cadastrarEntregador(Entregador entregador) {

        entregadores.add(entregador);

    }


    public void criarEntrega(String endereco, double distancia) {

        int id = entregas.size();

        Entrega entrega = new Entrega(id, endereco, distancia);

        entregas.add(entrega);

    }

    public void listarEntregadores() {

        if (entregadores.isEmpty()) {

            System.out.println("Nenhum entregador cadastrado.");
            return;

        }

        for (int i = 0; i < entregadores.size(); i++) {

            entregadores.get(i).exibirDados(i);

        }

    }

    public void listarEntregas() {

        if (entregas.isEmpty()) {

            System.out.println("Nenhuma entrega cadastrada.");
            return;

        }

        for (int i = 0; i < entregas.size(); i++) {

            entregas.get(i).exibirEntrega();

        }

    }

    public ArrayList<Entregador> getEntregadores() {

        return entregadores;

    }

    public ArrayList<Entrega> getEntregas() {

        return entregas;

    }

}