public abstract class Pedido implements Processavel {
    private final int id;
    private final String nomeCliente;
    private final double valor;
    private StatusPedido status;
    private final Categoria categoria;

    public Pedido(int id, String nomeCliente, double valor, Categoria categoria) throws ValorInvalidoException {
        if (valor <= 0) {
            throw new ValorInvalidoException("O valor do pedido deve ser maior que zero.");
        }
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.valor = valor;
        this.categoria = categoria;
        this.status = StatusPedido.PENDENTE;
    }

    @Override
    public void processarPedido() throws PedidoInvalidoException {
        if (status == StatusPedido.CANCELADO) {
            throw new PedidoInvalidoException("Pedido " + id + " está cancelado e não pode ser processado.");
        }
        if (status == StatusPedido.PENDENTE) {
            status = StatusPedido.PROCESSANDO;
        }
    }

    public void alterarStatus(StatusPedido novoStatus) throws PedidoInvalidoException {
        if (status == StatusPedido.ENTREGUE) {
            throw new PedidoInvalidoException("Pedido " + id + " já foi entregue e não pode mudar de status.");
        }
        status = novoStatus;
    }

    public int getId() { return id; }
    public String getNomeCliente() { return nomeCliente; }
    public double getValor() { return valor; }
    public StatusPedido getStatus() { return status; }
    public Categoria getCategoria() { return categoria; }

    @Override
    public String toString() {
        return String.format("#%d | %s | %s | R$ %.2f (final R$ %.2f) | %s",
                id, nomeCliente, categoria, valor, calcularValorFinal(), status);
    }
}
