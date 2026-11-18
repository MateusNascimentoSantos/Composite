package listatecnica;

public class Produto {

    private Componente estrutura;

    public void setEstrutura(Componente estrutura) {
        this.estrutura = estrutura;
    }

    public String getListaTecnica() {
        if (this.estrutura == null) {
            throw new NullPointerException("Produto sem estrutura");
        }
        return this.estrutura.getEstrutura();
    }

    public float getCustoTotal() {
        if (this.estrutura == null) {
            throw new NullPointerException("Produto sem estrutura");
        }
        return this.estrutura.getCustoTotal();
    }

    public int getPesoTotal() {
        if (this.estrutura == null) {
            throw new NullPointerException("Produto sem estrutura");
        }
        return this.estrutura.getPesoTotal();
    }

    public int getTotalPecas() {
        if (this.estrutura == null) {
            throw new NullPointerException("Produto sem estrutura");
        }
        return this.estrutura.getTotalPecas();
    }

    public Componente localizar(String codigo) {
        if (this.estrutura == null) {
            throw new NullPointerException("Produto sem estrutura");
        }
        Componente encontrado = this.estrutura.localizar(codigo);
        if (encontrado == null) {
            throw new IllegalArgumentException("Componente nao encontrado: " + codigo);
        }
        return encontrado;
    }
}
