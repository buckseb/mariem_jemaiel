public class Zoo {
    private Animal[] animals;
    private String name;
    private String city;
    private int nbrCages;
    private int animalCount;

    public Zoo(String name, String city, int nbrCages) {
        this.name = name;
        this.city = city;
        this.nbrCages = nbrCages;
        this.animals = new Animal[nbrCages];
        this.animalCount = 0;
    }

    public void displayZoo() {
        System.out.println("Zoo Name: " + name);
        System.out.println("City: " + city);
        System.out.println("Number of Cages: " + nbrCages);
    }

    public boolean addAnimal(Animal animal) {
        if (animalCount < nbrCages) {
            animals[animalCount++] = animal;
            return true;
        } else {
            System.out.println("The zoo is full. Cannot add more animals.");
            return false;
        }
    }

    public int searchAnimal(Animal animalToSearch) {
        for (int i = 0; i < animalCount; i++) {
            if (animals[i].equals(animalToSearch)) {
                return i;
            }
        }
        return -1;
    }

    public boolean removeAnimal(Animal animalToRemove) {
        int index = searchAnimal(animalToRemove);
        if (index != -1) {
            for (int i = index; i < animalCount - 1; i++) {
                animals[i] = animals[i + 1];
            }
            animals[animalCount - 1] = null; // Clear the last element
            animalCount--;
            return true;
        } else {
            System.out.println("Animal not found in the zoo.");
            return false;
        }
    }

}