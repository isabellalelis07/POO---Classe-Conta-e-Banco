package banksys;

public class Banco {
	private Conta [] contas;
	private int indice = 0;
	
	public Banco() {
		contas = new Conta[100];
	}
	
	public void cadastrar(Conta conta) {
		contas[indice] = conta;
		indice ++;
	}
	
	private Conta procurar(String numero) {
		int i = 0;
		boolean achou = false;
		while (!achou) && (i < indice){
			if(contas[i].numero().equals(numero)) {
				achou = true;
			} else {
				i++;
			}
		}
		if(achou == true) {
			return contas[i];
		} else {
			return null;
		}
	}
	
	public void debitar(String numero, double valor) {
		Conta conta;
		conta = procurar(numero);
		if(conta != null) {
			conta.debitar(valor);
		} else {
			System.out.println("Conta Inexistente");
		}
	}
	
	public void creditar(String numero, double valor) {
		Conta conta;
		conta = procurar(numero);
		if(conta != null) {
			conta.creditar(valor);
		} else {
			System.out.println("Conta Inexistente");
		}
	}
	
	public void transferir(String origem, String destino, double valor) {
		Conta c1;
		Conta c2;
		
		c1 = procurar(origem);
		c2 = procurar(destino);
		
		if((c1 != null) && (c2 != null)) {
			c1.debitar(valor);
			c2.creditar(valor);
		} else {
			System.out.println("Operação Inválida");
		}
	}

}


