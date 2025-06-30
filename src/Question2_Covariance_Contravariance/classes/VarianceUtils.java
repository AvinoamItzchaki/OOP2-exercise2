package Question2_Covariance_Contravariance.classes;

import java.util.List;

public class VarianceUtils {

    // Covariance - קריאה בלבד
    public static void printAnimalNames(List<? extends Animal> animals) {
        for (Animal animal : animals) {
            System.out.println("Animal: " + animal.getName());
        }
    }

    // Contravariance - הוספה בלבד
    public static void addDogToList(List<? super Dog> dogs) {
        dogs.add(new Dog("New Dog"));
    }
}

