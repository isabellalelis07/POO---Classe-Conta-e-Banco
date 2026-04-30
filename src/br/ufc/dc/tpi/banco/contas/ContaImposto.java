package br.ufc.dc.tpi.banco.contas;

public class ContaImposto extends ContaAbstrata {

	private double imposto;
    public ContaImposto(String numero)
    {
        super(numero);
        imposto = 1.0;
    }

    public void setImposto(double taxa)
    {
        imposto = taxa;
    }

    public double getImposto(double taxa)
    {
        return imposto;
    }

    public void debitar(double valor)
    {
        saldo = (saldo - valor) * imposto;
    }
}
