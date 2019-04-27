import java.util.Map;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Map.Entry;

public class Agenda {
	public Map<String, List<String>> agenda = new TreeMap<>();

	public static void main(String[] args){
		Agenda minhaAgenda = new Agenda();

		minhaAgenda.addContato("Tarcisio", "99711-2172");
		minhaAgenda.addTelefone("Tarcisio","2104-6427");
		System.out.println(minhaAgenda);
		minhaAgenda.addContato("Bom Dia & Companhia", "4002-8922");
		minhaAgenda.addContato("HMJ Produções", "9325-6666");
		System.out.println(minhaAgenda);
		minhaAgenda.removeTelefone("Tarcisio", "3249-2282");
		minhaAgenda.removeTelefone("Tarcisio", "99711-2172");
		System.out.println(minhaAgenda);
		minhaAgenda.removeContato("Bom Dia & Companhia");
		System.out.println(minhaAgenda);


	}

	public void addContato(String nome, String telefone){
		List<String> telefones = this.getTelefones(nome);
		if(telefones == null){
			this.agenda.put(nome, new ArrayList<String>());
		}
		this.addTelefone(nome, telefone);
	}

	public void addTelefone(String nome, String telefone){
		List<String> telefones = this.getTelefones(nome);
		if(telefones != null && !telefones.contains(telefone)){
			telefones.add(telefone);
		}
	}

	public List<String> getTelefones(String nome){
		return this.agenda.get(nome);
	}

	public void removeContato(String nome){
		this.agenda.remove(nome);
	}

	public void removeTelefone(String nome, String telefone){
		List<String> telefones = this.getTelefones(nome);
		if(telefones != null){
			telefones.remove(telefone);
		}
	}

	public String toString(){
		StringBuffer output = new StringBuffer("--Contatos--\n");
		for(Entry<String, List<String>> contatos : this.agenda.entrySet()){
			List<String> telefones = contatos.getValue();
			output.append(String.format("%-40s", contatos.getKey()));
			for(String telefone : telefones){
				output.append(String.format("%s ", telefone));
			}
			output.append("\n");
		}
		return output.toString();

	}

}