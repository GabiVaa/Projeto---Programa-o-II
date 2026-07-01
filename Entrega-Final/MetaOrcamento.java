public class MetaOrcamento {
    private String categoria;
    private double valorLimite;
    private double valorConsumido;

    public MetaOrcamento(String categoria, double valorLimite) {
        this.categoria = categoria;
        this.valorLimite = valorLimite;
        this.valorConsumido = 0.0;
    }

    public void atualizarGasto(double valor) {
        if (valor > 0) {
            this.valorConsumido += valor;
        }
    }

    public boolean verificarLimiteAtingido() {
        return this.valorConsumido >= this.valorLimite;
    }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public double getValorLimite() { return valorLimite; }
    public void setValorLimite(double valorLimite) { this.valorLimite = valorLimite; }
    public double getValorConsumido() { return valorConsumido; }
}
