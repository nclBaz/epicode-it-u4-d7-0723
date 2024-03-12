import entities.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {

		User aldo = new User("Aldo", "Baglio", 30);
		User giovanni = new User("Giovanni", "Storti", 40);
		User giacomo = new User("Giacomo", "Poretti", 50);

		ArrayList<User> usersList = new ArrayList<>();
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
	}
}