import java.time.LocalDate;

public abstract class Transacao {
    private int id;
    private String descricao;
    private double valor;
    private LocalDate data;
    private String categoria;

    public Transacao(int id, String descricao, double valor, LocalDate data, String categoria) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.categoria = categoria;
    }

    // Método abstrato para aplicar o Polimorfismo
    public abstract String exibirResumo();

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }
    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
}
