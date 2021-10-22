package retoJava.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {


		
		//Pasar un string de biomas a una Lista.
		String[] biomas = new String[] {"Tundra", "Taiga", "Selva Tropical"};
		List<String> listBiomas = Arrays.asList(biomas);
		
		//Buscamos si en nuestra lista existe el bioma "Taiga"
		
		//---Método imperativo--
		if (checkBiomasImperativo(listBiomas)) {
			System.out.println("El bioma existe (imperativo)");
		} else {
			System.out.println("El bioma no existe (imperativo)");
		}
		
		//---Método funcional--
		if (checkBiomasFuncional(listBiomas)) {
			System.out.println("El bioma existe (funcional)");
		} else {
			System.out.println("El bioma no existe (funcional)");
		}
		
		
		//Suma los pares de la lista.
		List<Integer> listNumbers = new ArrayList<>(Arrays.asList(2,5,4,10,11));
		System.out.println(sumaPar(listNumbers));
		
		
		//Convierte los números de la anterior lista en el orden inverso.
		Stream<Integer> numberInverse = convertToInverseNumber(listNumbers);
		showListNumber(numberInverse);
		
	}
	
	/**
	 * Comprueba si un bioma existe en la lista. (Método Imperativo)
	 * @param listBiomas
	 * @return true si existe, false si no existe.
	 */
	public static boolean checkBiomasImperativo(List<String> listBiomas) {
		
		for (String item: listBiomas) {
			if (item.equals("Taiga")) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Comprueba si un bioma existe en la lista. (Método Funcional)
	 * @param listBiomas
	 * @return true si existe, false si no existe.
	 */
	public static boolean checkBiomasFuncional(List<String> listBiomas) {
		
		if (listBiomas.contains("Taiga")) {
			return true;
		}
		
		return false;
	}
	
	
	/**
	 * Suma los pares de una lista de números.
	 * @param number lista a sumar.
	 * @return la suma total.
	 */
	public static int sumaPar (List<Integer> number) {
		return number.stream()
				.filter( x -> x%2 == 0)
				.mapToInt(x -> x)
				.sum();
	}
	
	
	/**
	 * Convierte una lista de numeros decreciente.
	 * @param number lista a ordenar.
	 * @return
	 */
	public static Stream<Integer> convertToInverseNumber(List<Integer> number) {
		return number.stream().sorted(Comparator.reverseOrder());
	}
	
	/**
	 * Muestra la lista de números.
	 * @param number número a ver.
	 */
	public static void showListNumber(Stream<Integer> number) {
		number.forEach((final Integer numero) -> System.out.print(" "+numero));
	}
}
