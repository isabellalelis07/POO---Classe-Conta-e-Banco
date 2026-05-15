package br.ufc.dc.tpi.banco.contas;

import br.ufc.dc.tpi.banco.exceptions.CIException;

public interface IRepositorioConta {
	public void inserir(ContaAbstrata conta);
    public void remover(String numero) throws CIException;
    public ContaAbstrata procurar(String numero);
    public ContaAbstrata[] listar();
    public int tamanho();

}
