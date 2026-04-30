package br.ufc.dc.tpi.banco.contas;

public abstract class ContaAbstrata {
	protected String numero;
    protected double saldo;

    public ContaAbstrata(String numero)
    {
        this.numero = numero;
        this.saldo = 0;
    }
    public void creditar(double valor)
    {
        saldo += valor;
    }
    public abstract void debitar(double valor);

    public String numero()
    {
        return numero;
    }

    public double saldo()
    {
        return saldo;
    }
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
    

}
