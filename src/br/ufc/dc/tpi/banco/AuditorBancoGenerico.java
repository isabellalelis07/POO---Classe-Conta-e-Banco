package br.ufc.dc.tpi.banco;

public class AuditorBancoGenerico {
	public void auditar(IBanco banco) {
        if ((banco.saldoTotal() / banco.numeroContas()) > 500){
          System.out.println("Aprovado!");
        }else {
          System.out.println("Não aprovado!");
        }
    }


}
