import java.util.Random;
import java.util.Set;
import java.util.HashSet;

public class Conjuntos {
	public static void main(String[] args){
		Set<Integer> vinteImpares = new HashSet<>();
		Set<Integer> aleatorios = new HashSet<>();

		Random rd = new Random();

		for(int i = 1; i < 40; i+=2){
			vinteImpares.add(i);
		}

		for(int i = 1; i <= 20; i++){
			aleatorios.add(rd.nextInt(40)+1);
		}
		System.out.println("Vinte primeiros ímpares: " + vinteImpares);
		System.out.println("Números aleatórios: " + aleatorios);
		System.out.println("União: " + Conjuntos.union(vinteImpares, aleatorios));
		System.out.println("Intersecção: " + Conjuntos.intersection(vinteImpares, aleatorios));
		System.out.println("Diferença: " + Conjuntos.difference(vinteImpares, aleatorios));
	}

	public static Set<Integer> union(Set<Integer> conjunto1, Set<Integer> conjunto2){
		Set<Integer> temp = new HashSet<>(conjunto1);
		temp.addAll(conjunto2);
		return temp;
	}

	public static Set<Integer> intersection(Set<Integer> conjunto1, Set<Integer> conjunto2){
		Set<Integer> temp = new HashSet<>(conjunto1);
		temp.retainAll(conjunto2);
		return temp;
	}

	public static Set<Integer> difference(Set<Integer> conjunto1, Set<Integer> conjunto2){
		Set<Integer> temp = new HashSet<>();
		Set<Integer> union = Conjuntos.union(conjunto1, conjunto2);
		Set<Integer> intersection = Conjuntos.intersection(conjunto1, conjunto2);

		for(Integer num : union){
			if(!intersection.contains(num)){
				temp.add(num);
			}
		}
		return temp;
	}
}