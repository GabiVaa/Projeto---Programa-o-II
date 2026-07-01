import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Transacao> transacoes = new ArrayList<>();
    private static ArrayList<MetaOrcamento> metas = new ArrayList<>(); 
    private static Scanner scanner = new Scanner(System.in);
    private static int contadorId = 1;

    public static void main(String[] args) {
        Usuario usuario = new Usuario("Aldo Filho", "aldo@ufrpe.br");
        
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n=== Gerenciador de Despesas Pessoais ===");
            System.out.println("Saldo Atual: R$ " + usuario.getSaldoAtual());
            System.out.println("1. Adicionar Transação (Receita/Despesa)");
            System.out.println("2. Listar Transações");
            System.out.println("3. Criar Meta de Orçamento");
            System.out.println("4. Listar Metas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            
            try {
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1: adicionarTransacao(usuario); break;
                    case 2: listarTransacoes(); break;
                    case 3: criarMeta(); break;
                    case 4: listarMetas(); break;
                    case 0: System.out.println("Encerrando..."); break;
                    default: System.out.println("Opção inválida!");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERRO: Por favor, digite apenas números no menu (Exceção: NumberFormatException).");
            } catch (Exception e) {
                System.out.println("ERRO INESPERADO: " + e.getMessage());
            }
        }
    }

    private static void adicionarTransacao(Usuario usuario) throws Exception {
        System.out.print("Descrição: ");
        String desc = scanner.nextLine();
        
        System.out.print("Valor: R$ ");
        double valor = Double.parseDouble(scanner.nextLine());
        
        // Tratamento de Exceção para regras de negócio
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor da transação não pode ser negativo ou zero.");
        }
        
        System.out.print("Categoria (Ex: Alimentação, Salário): ");
        String categoria = scanner.nextLine();
        
        System.out.print("Tipo (1 para Receita, 2 para Despesa): ");
        int tipo = Integer.parseInt(scanner.nextLine());

        if (tipo == 1) {
            Receita novaReceita = new Receita(contadorId++, desc, valor, LocalDate.now(), categoria);
            transacoes.add(novaReceita); 
            usuario.adicionarReceita(valor);
            System.out.println("Receita adicionada com sucesso!");
        } else if (tipo == 2) {
            Despesa novaDespesa = new Despesa(contadorId++, desc, valor, LocalDate.now(), categoria);
            transacoes.add(novaDespesa); 
            usuario.deduzirDespesa(valor);
            System.out.println("Despesa adicionada com sucesso!");
            
            verificarMetas(categoria, valor);
            
        } else {
            System.out.println("Tipo inválido. Operação cancelada.");
        }
    }

    private static void listarTransacoes() {
        if (transacoes.isEmpty()) {
            System.out.println("Nenhuma transação registrada.");
            return;
        }
        System.out.println("\n--- Lista de Transações ---");
        for (Transacao t : transacoes) {
            // Polimorfismo: O Java decide automaticamente se chama o resumo da Receita ou da Despesa
            System.out.println("ID: " + t.getId() + " | " + t.exibirResumo());
        }
    }

    private static void criarMeta() {
        System.out.print("Categoria da Meta (Ex: Alimentação): ");
        String categoria = scanner.nextLine();
        System.out.print("Valor Limite: R$ ");
        double limite = Double.parseDouble(scanner.nextLine());
        
        if (limite <= 0) throw new IllegalArgumentException("O limite deve ser maior que zero.");
        
        metas.add(new MetaOrcamento(categoria, limite));
        System.out.println("Meta criada com sucesso!");
    }

    private static void listarMetas() {
        if (metas.isEmpty()) {
            System.out.println("Nenhuma meta registrada.");
            return;
        }
        System.out.println("\n--- Suas Metas ---");
        for (MetaOrcamento m : metas) {
            System.out.println("Categoria: " + m.getCategoria() + " | Limite: R$ " + m.getValorLimite() + " | Consumido: R$ " + m.getValorConsumido());
        }
    }

    private static void verificarMetas(String categoria, double valorGasto) {
        for (MetaOrcamento m : metas) {
            if (m.getCategoria().equalsIgnoreCase(categoria)) {
                m.atualizarGasto(valorGasto);
                if (m.verificarLimiteAtingido()) {
                    System.out.println("⚠️ ALERTA: Você atingiu ou ultrapassou o limite da sua meta para a categoria " + categoria + "!");
                }
            }
        }
    }
}
