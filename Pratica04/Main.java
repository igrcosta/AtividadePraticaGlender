import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<Pedido> pedidos = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static int proximoId = 1;

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n===== GERENCIADOR DE PEDIDOS =====");
            System.out.println("1 - Cadastrar pedido");
            System.out.println("2 - Alterar status de um pedido");
            System.out.println("3 - Processar pedidos");
            System.out.println("4 - Remover cancelados");
            System.out.println("5 - Exibir lista de pedidos");
            System.out.println("6 - Exibir pedidos entregáveis");
            System.out.println("0 - Encerrar");
            opcao = lerInt("Opção: ");

            switch (opcao) {
                case 1 -> cadastrar();
                case 2 -> alterarStatus();
                case 3 -> processarTodos();
                case 4 -> removerCancelados();
                case 5 -> exibirLista();
                case 6 -> exibirEntregaveis();
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private static void cadastrar() {
        System.out.print("Nome do cliente: ");
        String nome = scanner.nextLine();
        Categoria categoria = lerEnum("Categoria", Categoria.values());
        double valor = lerDouble("Valor: ");
        try {
            Pedido p = switch (categoria) {
                case ELETRONICO -> new PedidoEletronico(proximoId, nome, valor);
                case ROUPA -> new PedidoRoupa(proximoId, nome, valor);
                case ALIMENTO -> new PedidoAlimento(proximoId, nome, valor);
            };
            pedidos.add(p);
            proximoId++;
            System.out.println("Pedido cadastrado: " + p);
        } catch (ValorInvalidoException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void alterarStatus() {
        Pedido p = buscar(lerInt("ID do pedido: "));
        if (p == null) {
            System.out.println("Pedido não encontrado.");
            return;
        }
        try {
            p.alterarStatus(lerEnum("Novo status", StatusPedido.values()));
            System.out.println("Status alterado: " + p);
        } catch (PedidoInvalidoException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void processarTodos() {
        Iterator<Pedido> it = pedidos.iterator();
        while (it.hasNext()) {
            Pedido p = it.next();
            try {
                p.processarPedido();
                System.out.println("Processado: " + p);
            } catch (PedidoInvalidoException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    private static void removerCancelados() {
        Iterator<Pedido> it = pedidos.iterator();
        int removidos = 0;
        while (it.hasNext()) {
            if (it.next().getStatus() == StatusPedido.CANCELADO) {
                it.remove();
                removidos++;
            }
        }
        System.out.println(removidos + " pedido(s) removido(s).");
    }

    private static void exibirLista() {
        boolean achou = false;
        for (Pedido p : pedidos) {
            if (p.getStatus() != StatusPedido.CANCELADO) {
                System.out.println(p);
                achou = true;
            }
        }
        if (!achou) System.out.println("Nenhum pedido para exibir.");
    }

    private static void exibirEntregaveis() {
        boolean achou = false;
        for (Pedido p : pedidos) {
            if (p instanceof Entregavel e) {
                System.out.printf("%s | frete R$ %.2f%n", p, e.calcularFrete());
                achou = true;
            }
        }
        if (!achou) System.out.println("Nenhum pedido entregável.");
    }

    private static Pedido buscar(int id) {
        for (Pedido p : pedidos) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    private static int lerInt(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Número inválido.");
            }
        }
    }

    private static double lerDouble(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return Double.parseDouble(scanner.nextLine().trim().replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.println("Número inválido.");
            }
        }
    }

    private static <T extends Enum<T>> T lerEnum(String titulo, T[] valores) {
        while (true) {
            System.out.println(titulo + ":");
            for (int i = 0; i < valores.length; i++) {
                System.out.println((i + 1) + " - " + valores[i]);
            }
            int op = lerInt("Escolha: ");
            if (op >= 1 && op <= valores.length) return valores[op - 1];
            System.out.println("Opção inválida.");
        }
    }
}
