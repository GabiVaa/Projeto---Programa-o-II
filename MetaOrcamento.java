public class MetaOrcamento {
    private String categoria; // [cite: 20]
    private double valorLimite; // [cite: 20]
    private double valorConsumido; // [cite: 20]

    public MetaOrcamento(String categoria, double valorLimite) {
        this.categoria = categoria;
        this.valorLimite = valorLimite;
        this.valorConsumido = 0.0;
    }

    // Métodos de Negócio
    public void atualizarGasto(double valor) { // 
        if (valor > 0) {
            this.valorConsumido += valor;
        }
    }

    public boolean verificarLimiteAtingido() { // 
        return this.valorConsumido >= this.valorLimite;
    }

    // Getters e Setters
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public double getValorLimite() { return valorLimite; }
    public void setValorLimite(double valorLimite) { this.valorLimite = valorLimite; }

    public double getValorConsumido() { return valorConsumido; }
    // Sem setValorConsumido para manter o encapsulamento seguro.
}
