import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transacao {
    private int id; // [cite: 20]
    private String descricao; // [cite: 20]
    private double valor; // [cite: 20]
    private LocalDate data; // Utilizando LocalDate conforme sugerido [cite: 20]
    private String categoria; // [cite: 20]
    private String tipo; // "Receita" ou "Despesa" [cite: 20]

    public Transacao(int id, String descricao, double valor, LocalDate data, String categoria, String tipo) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.categoria = categoria;
        this.tipo = tipo;
    }

    // Métodos de Negócio
    public void registrarTransacao() { // 
        System.out.println("Transação " + this.id + " validada e registrada no sistema.");
    }

    public String exibirResumo() { // 
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("[%s] %s - %s: R$ %.2f (Categoria: %s)", 
                this.data.format(formatter), this.tipo, this.descricao, this.valor, this.categoria);
    }

    // Getters e Setters
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

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}
