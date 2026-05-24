import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Transacao> transacoes = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int contadorId = 1;

    public static void main(String[] args) {
        // Instanciando o usuário principal
        Usuario usuario = new Usuario("Aldo Filho", "aldo@ufrpe.br");
        
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n--- Gerenciador de Despesas Pessoais ---");
            System.out.println("Saldo Atual: R$ " + usuario.getSaldoAtual());
            System.out.println("1. Adicionar Transação");
            System.out.println("2. Listar Transações");
            System.out.println("3. Editar Transação");
            System.out.println("4. Remover Transação");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1: adicionarTransacao(usuario); break;
                case 2: listarTransacoes(); break;
                case 3: editarTransacao(usuario); break;
                case 4: removerTransacao(usuario); break;
                case 0: System.out.println("Encerrando..."); break;
                default: System.out.println("Opção inválida!");
            }
        }
    }

    private static void adicionarTransacao(Usuario usuario) {
        System.out.print("Descrição: ");
        String desc = scanner.nextLine();
        
        System.out.print("Valor: ");
        double valor = Double.parseDouble(scanner.nextLine());
        
        System.out.print("Categoria (Ex: Alimentação, Lazer): ");
        String categoria = scanner.nextLine();
        
        System.out.print("Tipo (Receita/Despesa): ");
        String tipo = scanner.nextLine();

        Transacao novaTransacao = new Transacao(contadorId++, desc, valor, LocalDate.now(), categoria, tipo);
        novaTransacao.registrarTransacao();
        transacoes.add(novaTransacao);

        // Atualizando saldo do usuário
        if (tipo.equalsIgnoreCase("Receita")) {
            usuario.adicionarReceita(valor);
        } else if (tipo.equalsIgnoreCase("Despesa")) {
            usuario.deduzirDespesa(valor);
        }
        System.out.println("Adicionada com sucesso!");
    }

    private static void listarTransacoes() {
        if (transacoes.isEmpty()) {
            System.out.println("Nenhuma transação registrada.");
            return;
        }
        System.out.println("\n--- Lista de Transações ---");
        for (Transacao t : transacoes) {
            System.out.println("ID: " + t.getId() + " | " + t.exibirResumo());
        }
    }

    private static void editarTransacao(Usuario usuario) {
        listarTransacoes();
        System.out.print("Informe o ID da transação que deseja editar: ");
        int id = Integer.parseInt(scanner.nextLine());

        for (Transacao t : transacoes) {
            if (t.getId() == id) {
                // Reverte o saldo antigo antes de editar
                if (t.getTipo().equalsIgnoreCase("Receita")) usuario.deduzirDespesa(t.getValor());
                else usuario.adicionarReceita(t.getValor());

                System.out.print("Nova Descrição: ");
                t.setDescricao(scanner.nextLine());
                
                System.out.print("Novo Valor: ");
                double novoValor = Double.parseDouble(scanner.nextLine());
                t.setValor(novoValor);

                // Aplica o novo saldo
                if (t.getTipo().equalsIgnoreCase("Receita")) usuario.adicionarReceita(novoValor);
                else usuario.deduzirDespesa(novoValor);

                System.out.println("Transação editada com sucesso!");
                return;
            }
        }
        System.out.println("Transação não encontrada.");
    }

    private static void removerTransacao(Usuario usuario) {
        listarTransacoes();
        System.out.print("Informe o ID da transação que deseja remover: ");
        int id = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < transacoes.size(); i++) {
            Transacao t = transacoes.get(i);
            if (t.getId() == id) {
                // Reverte o saldo antes de apagar
                if (t.getTipo().equalsIgnoreCase("Receita")) usuario.deduzirDespesa(t.getValor());
                else usuario.adicionarReceita(t.getValor());

                transacoes.remove(i);
                System.out.println("Transação removida com sucesso!");
                return;
            }
        }
        System.out.println("Transação não encontrada.");
    }
}
