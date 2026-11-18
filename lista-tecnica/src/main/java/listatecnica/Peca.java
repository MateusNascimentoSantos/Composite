package listatecnica;

public class Peca extends Componente {

    private float custo;
    private int peso;

    public Peca(String codigo, String descricao, int quantidade, float custo, int peso) {
        super(codigo, descricao, quantidade);
        this.custo = custo;
        this.peso = peso;
    }

    public void setCusto(float custo) {
        this.custo = custo;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public float getCustoUnitario() {
        return custo;
    }

    public int getPesoUnitario() {
        return peso;
    }

    public int getTotalPecas() {
        return this.getQuantidade();
    }

    public String getEstrutura(int nivel) {
        return this.getRecuo(nivel) + "Peca " + this.getCodigo() + ": " + this.getDescricao() +
                " - qtd: " + this.getQuantidade() + " - custo: " + this.getCustoTotal() + "\n";
    }

    public Componente localizar(String codigo) {
        if (this.getCodigo().equals(codigo)) {
            return this;
        }
        return null;
    }
}
