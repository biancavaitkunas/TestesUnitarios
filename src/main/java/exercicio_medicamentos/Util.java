package exercicio_medicamentos;

import java.util.ArrayList;
import java.util.List;

public class Util {

	private List<Pessoa> pessoa = new ArrayList<Pessoa>();
	private List<Medicamento> medicamentos = new ArrayList<Medicamento>();

	public Pessoa add(Pessoa p) {

		pessoa.add(p);
		return p;

	}

	public Medicamento add(Medicamento m) {

		medicamentos.add(m);
		return m;

	}

	public Pessoa escolhePessoa(String nome) {

		return pessoa.stream().filter(p -> p.getNome().equals(nome)).findAny().orElse(null);

	}
	
	public Prescricao prescreve(String nome) {
		
		Pessoa pessoa = escolhePessoa(nome);
		Prescricao prescricao = new Prescricao(pessoa, medicamentos);
		
		for (Medicamento indicacao: medicamentos) {
			if (pessoa.sintoma.equals(indicacao.indicacoes)) {
				prescricao = new Prescricao(pessoa, medicamentos);
			}
			
		}
		
		return prescricao;
		
	}
	
	public boolean verificaAlergia(String nome) {
		
		Prescricao prescricao = prescreve(nome);
		boolean prescreve = true;
		
		for (Medicamento contraIndicacoes: medicamentos) {
			if (prescricao.getPessoa().alergias.equals(contraIndicacoes.contraindicacoes)) {
				prescreve = false;
			}
			
		}
		return prescreve;
		
	}


}
