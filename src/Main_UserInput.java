import java.util.Scanner;

/**
 * @author : jzagabe
 * @Description :Classe pour exécuter les différentes méthodes en utilisant
 * les entrées fournies par l'usager
 * @created : 2024-04-23, Tuesday
 **/
public class Main_UserInput
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String rep = "O";
        CarManager carManager = new CarManager();
        carManager.loadCarsFromTextFile("cars.txt");
        while (rep.equals("O"))
        {

                System.out.println("Donner le numéro de la voiture");
                int carId = getValidNumber(sc);
                sc.nextLine();
                System.out.println("Donner la marque de la voiture");
                String make = sc.nextLine();
                System.out.println("Donner le modèle de la voiture");
                String model = sc.nextLine();
                System.out.println("Donner l'année de fabrication de la voiture");
                int year = getValidNumber(sc);
                // Ajouter la nouvelle voiture
                carManager.addCar(new Car(carId, make, model, year));
                sc.nextLine();
                System.out.println("Voudrais-tu continuer ? (O/N)");
                rep = sc.nextLine().toUpperCase();

        }
        carManager.saveCarsToTextFile("cars.txt");
        //Afficher toutes les voitures

        carManager.displayAllCars();

    }

    // Vérifier si l'usager a entré un nombre entier
    private static int getValidNumber(Scanner sc) {
        while (true) {
            if (sc.hasNextInt()) {
                return sc.nextInt();
            } else {
                System.out.println("Tu dois entrer un nombre valide.");
                sc.next();
            }
        }
    }



}

