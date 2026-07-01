import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Receita extends Transacao {

    public Receita(int id, String descricao, double valor, LocalDate data, String categoria) {
        super(id, descricao, valor, data, categoria);
    }

    @Override
    public String exibirResumo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("[%s] 🟢 RECEITA: %s | R$ %.2f (Categoria: %s)", 
                this.getData().format(formatter), this.getDescricao(), this.getValor(), this.getCategoria());
    }
}
