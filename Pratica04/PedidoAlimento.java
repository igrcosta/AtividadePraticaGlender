public class PedidoAlimento extends Pedido {
    public PedidoAlimento(int id, String nomeCliente, double valor) throws ValorInvalidoException {
        super(id, nomeCliente, valor, Categoria.ALIMENTO);
    }

    @Override
    public double calcularValorFinal() {
        return getValor();
    }

    // frete fixo de R$ 5 informado no enunciado, mas o pedido de alimento não é Entregavel
}
