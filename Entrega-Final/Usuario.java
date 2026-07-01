public class Usuario {
    private String nome;
    private String email;
    private double saldoAtual;

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.saldoAtual = 0.0;
    }

    public void adicionarReceita(double valor) {
        if (valor > 0) {
            this.saldoAtual += valor;
        }
    }

    public void deduzirDespesa(double valor) {
        if (valor > 0) {
            this.saldoAtual -= valor;
        }
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public double getSaldoAtual() { return saldoAtual; }
}
