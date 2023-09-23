import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Zoo myZoo = new Zoo("My Zoo", "Cityville", 5);

        while (true) {
            System.out.println("Zoo Management Menu:");
            System.out.println("1. Add an animal");
            System.out.println("2. Display zoo information");
            System.out.println("3. Search for an animal");
            System.out.println("4. Remove an animal");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter animal family: ");
                    String family = scanner.next();
                    System.out.print("Enter animal name: ");
                    String name = scanner.next();
                    System.out.print("Enter animal age: ");
                    int age = scanner.nextInt();
                    System.out.print("Is the animal a mammal? (true/false): ");
                    boolean isMammal = scanner.nextBoolean();

                    Animal animal = new Animal(family, name, age, isMammal);
                    if (myZoo.addAnimal(animal)) {
                        System.out.println("Animal added to the zoo.");
                    } else {
                        System.out.println("Failed to add animal. Zoo is full.");
                    }
                    break;

                case 2:
                    myZoo.displayZoo();
                    break;

                case 3:
                    System.out.print("Enter animal name to search: ");
                    String searchName = scanner.next();
                    Animal searchedAnimal = new Animal("", searchName, 0, false);
                    int index = myZoo.searchAnimal(searchedAnimal);
                    if (index != -1) {
                        System.out.println(searchName + " found at index: " + index);
                    } else {
                        System.out.println(searchName + " not found in the zoo.");
                    }
                    break;

                case 4:
                    System.out.print("Enter animal name to remove: ");
                    String removeName = scanner.next();
                    Animal removeAnimal = new Animal("", removeName, 0, false);
                    if (myZoo.removeAnimal(removeAnimal)) {
                        System.out.println(removeName + " removed from the zoo.");
                    } else {
                        System.out.println(removeName + " not found in the zoo.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting Zoo Management Program.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}