package Question1_Similarity;

import Question1_Similarity.Features.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question1Main {
    public static void main(String[] args) {
        List<FeaturesObject> featuresObjects = inputFeaturesFromUser();
        program(featuresObjects);
    }
    public static void program(List<FeaturesObject> featuresObjects) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            int index = 1;
            for (FeaturesObject featuresObject : featuresObjects) {
                System.out.println(index + ". " + featuresObject);
                index++;
            }
            System.out.println("Choose objects by number to compare(enter -1 to end program): ");
            try {
                int index1 = scanner.nextInt();
                if (index1 == -1) {
                    break;
                }
                int index2 = scanner.nextInt();
                FeaturesObject featuresObject1 = featuresObjects.get(index1 - 1);
                FeaturesObject featuresObject2 = featuresObjects.get(index2 - 1);
                if (featuresObject1 == null || featuresObject2 == null) {
                    System.out.println("Please choose valid objects");
                    continue;
                }
                System.out.println("Similarity: " +
                        FeaturesObject.compareFeatures(featuresObject1, featuresObject2) +
                        "/7");
            }
            catch (Exception e) {
                System.out.println("Please enter valid indexes");
            }
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //Clear Screen
            for (int i = 1; i <= 30; i++){
                System.out.println();
            }
        }

    }

    public static List<FeaturesObject> inputFeaturesFromUser() {
        Scanner scanner = new Scanner(System.in);
        List<FeaturesObject> objects = new ArrayList<>();
        System.out.println("In order to use a good form of comparison later\n" +
                "between the compared objects,\n" +
                "it is necessary to use standard units of measurement\n" +
                "such as meters, kilograms, and seconds (m/kg/s)");
        System.out.println();

        while (true) {
            System.out.print("Enter object name (or 'done' to finish): ");
            String objectName = scanner.nextLine().trim();
            if (objectName.equalsIgnoreCase("done")) break;

            FeaturesObject obj = new FeaturesObject(objectName);

            System.out.println("  Enter features names and values (or 'done' to finish features): ");
            String featuresLine = scanner.nextLine().trim();
            String[] featureTokens = featuresLine.split("##");

            for (String token : featureTokens) {
                token = token.trim();
                if (token.equalsIgnoreCase("done")) break;

                String[] parts = token.split(",");
                if (parts.length != 2) {
                    System.out.println("  Invalid format: " + token + " (expected: name, value)");
                    continue;
                }

                String featureName = parts[0].trim();
                String valueStr = parts[1].trim();
                double value;

                try {
                    value = Double.parseDouble(valueStr);
                } catch (NumberFormatException e) {
                    System.out.println("  Invalid number in: " + token);
                    continue;
                }

                if (featureName.startsWith("*")) {
                    obj.addFeature(new ImportantFeature(featureName.substring(1), value));
                } else if (featureName.startsWith("!")) {
                    obj.addFeature(new LessImportantFeature(featureName.substring(1), value));
                } else {
                    obj.addFeature(new Feature(featureName, value));
                }
            }

            objects.add(obj);
        }

        return objects;
    }
}
//Enter object name (or 'done' to finish): Parrot
//  Enter features names and values (or 'done' to finish features):
//  *Color, 1.00 ## !Weight, 1.20 ## !WingSpan, 2.43 ## done
//
//Enter object name (or 'done' to finish): Desk
//  Enter features names and values (or 'done' to finish features):
//  *Color, 2.00 ## !Height, 0.75 ## !Weight, 20.00 ## done
//
//Enter object name (or 'done' to finish): Car
//  Enter features names and values (or 'done' to finish features):
//  *Color, 3.00 ## !Speed, 150.00 ## !Weight, 1000.00 ## done
//
//Enter object name (or 'done' to finish): Truck
////  Enter features names and values (or 'done' to finish features):
////  *Color, 3.00 ## !Speed, 150.00 ## !Weight, 2000.00 ## done
//Enter object name (or 'done' to finish): done