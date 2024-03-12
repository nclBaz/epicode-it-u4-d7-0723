import entities.User;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
	public static void main(String[] args) {

		User aldo = new User("Aldo", "Baglio", 30);
		User giovanni = new User("Giovanni", "Storti", 40);
		User giacomo = new User("Giacomo", "Poretti", 50);

		List<User> usersList = new ArrayList<>(); // UPCASTING

		System.out.println("La lista ha " + usersList.size() + " elementi.");
		// Tra le parentesi angolari <> vado a specificare il tipo di dato che sarà conservato nella lista
		usersList.add(aldo);
		usersList.add(giovanni);
		usersList.add(giacomo);
		usersList.add(0, aldo);
		usersList.add(new User("Ajeje", "Brazorf", 60));

		System.out.println("La lista ha " + usersList.size() + " elementi.");

		for(User user: usersList) {
			System.out.println(user);
		}

		try  {
			System.out.println("-------------------------------- GET -------------------------------");
			User found = usersList.get(4);
			System.out.println("L'elemento con indice 4 è: " + found);
			System.out.println("L'indice di Ajeje è: " + usersList.indexOf(found));
		} catch (IndexOutOfBoundsException ex) {
			System.err.println(ex.getMessage());
		}


		System.out.println("-------------------------------- CONTAINS -------------------------------");
		if(usersList.contains(aldo)) {
			// .contains() internamente utilizza il metodo .equals() degli oggetti in questione, quindi ovviamente possiamo sovrascriverlo per avere un criterio di comparazione personalizzato
			System.out.println("La lista contiene Aldo");
		} else {
			System.out.println("La lista non contiene Aldo");
		}

		System.out.println("-------------------------------- REMOVE -------------------------------");
		usersList.remove(0);
		usersList.remove(aldo);

		System.out.println("La lista ha " + usersList.size() + " elementi.");

		for(User user: usersList) {
			System.out.println(user);
		}

		System.out.println("-------------------------------- ADD ALL -------------------------------");

		User[] usersArray = {aldo, giovanni, giacomo};
		usersList.addAll(Arrays.asList(usersArray)); // <-- non posso passare direttamente un array a addAll perché vuole una Collection
		// La soluzione è quella di convertire l'array in una Collection come ad esempio in una Lista con Arrays.asList
		System.out.println("La lista ha " + usersList.size() + " elementi.");

		for(User user: usersList) {
			System.out.println(user);
		}


		System.out.println("-------------------------------- CLEAR -------------------------------");
		System.out.println("La lista è vuota? " + usersList.isEmpty());
		usersList.clear(); // Svuoto la lista
		System.out.println("La lista è vuota? " + usersList.isEmpty());

		List<User> userLinkedList = new LinkedList<>();
		// Qua non sto usando l'upcasting, il che vuol dire che potrò usare i metodi più specifici che solo le LinkedList possiedono
		// Di contro però in futuro non avrò probabilmente la possibilità di poter sostituire questa LinkedList con un ArrayList cambiando una sola riga di codice

		// ArrayList<int> listaNumeri = new ArrayList<>(); // Nelle Collection non posso inserire dati primitivi, solo oggetti
		ArrayList<Integer> listaNumeri = new ArrayList<>();
		listaNumeri.add(2);

		ArrayList<String> listaStringhe = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
/*		for(String lettera: listaStringhe){
			if(lettera.equals("b")) listaStringhe.remove(lettera); // Java lancia un'eccezione quando provo a rimuovere un elemento da una lista durante l'iterazione
			else System.out.println(lettera);
		}*/

		// Se voglio rimuovere elementi durante le iterazioni di un ciclo devo usare gli ITERATORS
		Iterator<String> iterator = listaStringhe.iterator();
		while(iterator.hasNext()) { // finchè ci sono ulteriori elementi, continua a ciclare
			String lettera = iterator.next(); // .next() mi ritorna l'elemento corrente
			if(lettera.equals("b")) iterator.remove(); // N.B. non sto facendo listaStringhe.remove() ma iterator.remove()
			else System.out.println(lettera);
		}

		// ***************************************************** SET *******************************************************
		Set<User> usersSet = new HashSet<>();
		usersSet.add(aldo);
		usersSet.add(giovanni);
		usersSet.add(giacomo);
		usersSet.add(aldo);
		// Java non mi avverte se ci sono duplicati dandomi un errore, ci sarà intellij che al massimo mi darà un warning

		for (User user : usersSet){
			System.out.println(user);
		}

		Set<String> lettereSet = new TreeSet<>();
		lettereSet.add("f");
		lettereSet.add("q");
		lettereSet.add("a");
		lettereSet.add("a");
		lettereSet.add("f");

		for(String lettera: lettereSet){
			System.out.println(lettera);
		}

		Set<User> usersTreeSet = new TreeSet<>();
		usersTreeSet.add(giacomo);
		usersTreeSet.add(aldo);
		usersTreeSet.add(giovanni);

		for(User u: usersTreeSet){
			System.out.println(u);
		}

		// ***************************************************** MAPS *******************************************************
		Map<Integer, User> usersMap = new HashMap<>(); // Ogni elemento della mappa sarà rappresentato da una coppia <Chiave, Valore>
		// In questo caso specifico sto dichiarando che ogni elemento di questa mappa avrà chiave di tipo Intero e valore di tipo User
		// Ogni elmento sarà tipo:
		// 1231321 - Aldo Baglio
		// 1232132 - Giovanni Storti

		Map<String, String> dizionario = new HashMap<>(); // Qua abbiamo sia Chiavi che Valori in formato String

		System.out.println("----------------------------------- AGGIUNTA ELEMENTI ---------------------------------");
		usersMap.put(123, aldo);
		usersMap.put(124, giovanni);

		System.out.println(usersMap);

		dizionario.put("albero", "Definizione di albero");
		dizionario.put("casa", "Definizione di casa");
		dizionario.put("casa", "blablabla");
		System.out.println(dizionario);

		System.out.println(dizionario.get("albero"));
		dizionario.replace("albero", "Definizione più aggiornata di albero");
		//dizionario.remove("casa");
		System.out.println(dizionario);

		Set<String> chiavi = dizionario.keySet(); // mi ritorna l'elenco di tutte le chiave
		for(String chiave: chiavi) {
			System.out.println("Chiave " + chiave);
			System.out.println("Valore " + dizionario.get(chiave));
		}
		
	}
}