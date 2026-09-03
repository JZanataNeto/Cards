class Compras {
    private String produto;
    private double valor;

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return this.valor;
    }

    @Override
    public String toString() {
        return produto + " - R$ " + valor;
    }
}
