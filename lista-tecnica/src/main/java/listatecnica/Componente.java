package listatecnica;

public abstract class Componente {

    private String codigo;
    private String descricao;
    private int quantidade;

    public Componente(String codigo, String descricao, int quantidade) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public abstract float getCustoUnitario();

    public abstract int getPesoUnitario();

    public abstract int getTotalPecas();

    public abstract String getEstrutura(int nivel);

    public abstract Componente localizar(String codigo);

    public float getCustoTotal() {
        return this.getCustoUnitario() * this.quantidade;
    }

    public int getPesoTotal() {
        return this.getPesoUnitario() * this.quantidade;
    }

    public String getEstrutura() {
        return this.getEstrutura(0);
    }

    public String getRecuo(int nivel) {
        String recuo = "";
        for (int i = 0; i < nivel; i++) {
            recuo += "  ";
        }
        return recuo;
    }
}
