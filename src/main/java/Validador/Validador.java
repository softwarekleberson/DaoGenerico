package Validador;

public class Validador {
	
	public static String ExcecaoTamanhoMinimo(String valor, int minimo, String nome)throws Validacao.ExcecaoTamanhoMinimo {
		valor = valor.trim();
		if(valor.length() <= minimo) 
			throw new Validacao.ExcecaoTamanhoMinimo("O campo " + nome +" nao pode ser menor que 3 caracteres");
		return valor;
	}
	
	public static Long ExcecaoTamanhoMinimo(Long valor, int minimo, String nome)throws Validacao.ExcecaoTamanhoMinimo {
		if(valor < minimo) {
			throw new Validacao.ExcecaoTamanhoMinimo("O campo " + nome + "não pode ser menor que 3 caracteres");
		}
		return valor;
	}
	
	public static Integer ExcecaoTamanhoMinimo(Integer valor, int minimo, String nome)throws Validacao.ExcecaoTamanhoMinimo {
		if(valor < minimo) {
			throw new Validacao.ExcecaoTamanhoMinimo("O campo " + nome + "não pode ser menor que 3 caracteres");
		}
		return valor;
	}
	
	public static String ExcecaoNaoPodeSerNulo(String valor, String nome)throws Validacao.ExcecaoNaoPodeSerNulo{
		if(valor == null) {
			throw new Validacao.ExcecaoNaoPodeSerNulo("Campo " + nome + "não pode ser nulo ");
		}
		return valor;
	}
	
	public static Double ExcecaoNaoPodeSerNulo(Double valor, String nome)throws Validacao.ExcecaoNaoPodeSerNulo{
		if(valor == null) {
			throw new Validacao.ExcecaoNaoPodeSerNulo("Campo " + nome + "não pode ser nulo");
		}
		return  valor;
	}
	
	public static Double ExcecaoValorMinimo(Double valor, double valor_Minimo, String nome) throws Validacao.ExcecaoValorMinimo{
		if(valor < valor_Minimo) {
			throw new  Validacao.ExcecaoValorMinimo("O campo " + nome + "deve ser igual ou superir a : " + valor_Minimo);
		}
		return valor;
	}
	
	public static Integer ExcecaoValorMinimo(Integer valor, double valor_Minimo, String nome) throws Validacao.ExcecaoValorMinimo{
		if(valor < valor_Minimo) {
			throw new  Validacao.ExcecaoValorMinimo("O campo " + nome + "deve ser igual ou superir a : " + valor_Minimo);
		}
		return valor;
	}
	
	
}
