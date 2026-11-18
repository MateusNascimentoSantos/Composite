package listatecnica;

import java.util.ArrayList;
import java.util.List;

public class Conjunto extends Componente {

    private List<Componente> componentes;

    public Conjunto(String codigo, String descricao, int quantidade) {
        super(codigo, descricao, quantidade);
        this.componentes = new ArrayList<Componente>();
    }

    public void addComponente(Componente componente) {
        this.componentes.add(componente);
    }

    public float getCustoUnitario() {
        float total = 0;
        for (Componente componente : componentes) {
            total += componente.getCustoTotal();
        }
        return total;
    }

    public int getPesoUnitario() {
        int total = 0;
        for (Componente componente : componentes) {
            total += componente.getPesoTotal();
        }
        return total;
    }

    public int getTotalPecas() {
        int total = 0;
        for (Componente componente : componentes) {
            total += componente.getTotalPecas();
        }
        return total * this.getQuantidade();
    }

    public String getEstrutura(int nivel) {
        String saida = this.getRecuo(nivel) + "Conjunto " + this.getCodigo() + ": " + this.getDescricao() +
                " - qtd: " + this.getQuantidade() + " - custo: " + this.getCustoTotal() + "\n";
        for (Componente componente : componentes) {
            saida += componente.getEstrutura(nivel + 1);
        }
        return saida;
    }

    public Componente localizar(String codigo) {
        if (this.getCodigo().equals(codigo)) {
            return this;
        }
        for (Componente componente : componentes) {
            Componente encontrado = componente.localizar(codigo);
            if (encontrado != null) {
                return encontrado;
            }
        }
        return null;
    }
}
