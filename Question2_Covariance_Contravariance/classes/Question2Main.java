package Question2_Covariance_Contravariance;

import Question2_Covariance_Contravariance.classes.*;
import java.util.ArrayList;
import java.util.List;

public class Question2Main {
    public static void main(String[] args) {
        // רשימה של Dogs
        List<Dog> dogList = new ArrayList<>();
        dogList.add(new Dog("Buddy"));
        dogList.add(new Dog("Max"));

        // רשימה של Animals
        List<Animal> animalList = new ArrayList<>();
        animalList.add(new Animal("Lion"));
        animalList.add(new Dog("Charlie"));

        // Covariance - הדפסת שמות החיות
        System.out.println("Printing dog list:");
        VarianceUtils.printAnimalNames(dogList);

        System.out.println("\nPrinting animal list:");
        VarianceUtils.printAnimalNames(animalList);

        // Contravariance - הוספת כלב
        List<Animal> animalsForAdding = new ArrayList<>();
        List<Object> objectsForAdding = new ArrayList<>();

        VarianceUtils.addDogToList(animalsForAdding);
        VarianceUtils.addDogToList(objectsForAdding);

        // הדפסת התוצאות אחרי הוספה
        System.out.println("\nAfter adding dog to Animal list:");
        for (Object obj : animalsForAdding) {
            if (obj instanceof Animal) {
                System.out.println(((Animal) obj).getName());
            }
        }

        System.out.println("\nAfter adding dog to Object list:");
        for (Object obj : objectsForAdding) {
            if (obj instanceof Animal) {
                System.out.println(((Animal) obj).getName());
            }
        }
    }
}
