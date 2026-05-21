public class Usuario {
    private String nome; [span_4](start_span)//[span_4](end_span)
    private String email; [span_5](start_span)//[span_5](end_span)
    private double saldoAtual; [span_6](start_span)//[span_6](end_span)

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.saldoAtual = 0.0; // Saldo inicial zerado
    }

    // Métodos de Negócio
    [span_7](start_span)public void adicionarReceita(double valor) { //[span_7](end_span)
        if (valor > 0) {
            this.saldoAtual += valor;
        }
    }

    [span_8](start_span)public void deduzirDespesa(double valor) { //[span_8](end_span)
        if (valor > 0) {
            this.saldoAtual -= valor;
        }
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public double getSaldoAtual() { return saldoAtual; }
    // Não incluímos setSaldoAtual para proteger a integridade do saldo.
}
