class Cadastro {
    private String cliente;
    private double renda;
    private double valorlimite = 0.0;

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCliente() {
        return this.cliente;
    }

    public void setRenda(double renda) {
        this.renda = renda;
    }

    public double getValorlimite() {
        return valorlimite;
    }

    public void calculoLimite(double renda) {
        if (renda >= 5000.0) {
            this.valorlimite = renda * 2;
        } else {
            this.valorlimite = renda * 1.5;
        }
    }
    public void deduzLimite(double valor) {
        this.valorlimite -= valor;
    }
}