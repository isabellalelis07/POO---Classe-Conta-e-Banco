package br.ufc.dc.tpi.banco;

import br.ufc.dc.tpi.banco.contas.ContaAbstrata;
import br.ufc.dc.tpi.banco.exceptions.CIException;
import br.ufc.dc.tpi.banco.exceptions.SIException;

public interface IBanco {
	public double saldoTotal();
	public int numeroContas();
	public void cadastrar(ContaAbstrata conta);
	public ContaAbstrata procurar(String numero) throws CIException;
	public void creditar(String numero, double valor) throws CIException;
	public void debitar(String numero, double valor) throws CIException, SIException;
	public double saldo(String numero) throws CIException;
	public void transferir(String origem, String destino, double valor) throws CIException, SIException; 
	
}

