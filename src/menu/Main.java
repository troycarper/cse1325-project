package menu;

import exercisetracker.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import macrotracker.*;




public class Main {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Day> foodDays = new ArrayList<>();
    static ArrayList<Workout> workouts = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("\n\nCommunity Fitness & Wellness Tracker ");

        while (true) {

            System.out.println("\nMAIN MENU");
            System.out.println("1. Food Log");
            System.out.println("2. View Food Log (History)");
            System.out.println("3. Workout Log");
            System.out.println("4. View Workout Log (History)");
            System.out.println("5. Save Days of eating");
            System.out.println("6. Load Days of eating");
            System.out.println("7. Exit");
            System.out.print("Choice: ");

            String choice = sc.nextLine();

            switch (choice) {
                case "1" -> foodLog();
                case "2" -> viewFoodLog();
                case "3" -> workoutLog();
                case "4" -> viewWorkouts();
                case "5" -> saveFoodDays();
                case "6" -> loadFoodDays();

                case "7" -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
    static void foodLog() {

        System.out.print("Enter date: ");
        String date = sc.nextLine();

        int cal     = readInt("Enter calorie goal: ");
        int carb    = readInt("Enter carb goal: ");
        int fat     = readInt("Enter fat goal: ");
        int protein = readInt("Enter protein goal: ");

        Day day = new Day(date, cal, carb, fat, protein);
        foodDays.add(day);

        while (true) {

            System.out.println("\nFOOD MENU");
            System.out.println("1. Add Meal");
            System.out.println("0. Back");
            System.out.print("Choice: ");

            String input = sc.nextLine();

            if (input.equals("0")) return;

            if (input.equals("1")) {
                int numFoods = readInt("How many foods in this meal? ");
                day.addMeal(numFoods);
                System.out.println("Meal added!");
                System.out.println("You have " + day.getRemainingCal() + " calories remaining until your goal");
                System.out.println("You have " + day.getRemainingCarb() + " carbs remaining until your goal");
                System.out.println("You have " + day.getRemainingFat() + " grams of fat remaining until your goal");
                System.out.println("You have " + day.getRemainingProtein() + " grams of protein remaining until your goal");
            }
        }
    }

    static void viewFoodLog() {

        System.out.println("\nFOOD HISTORY");

        if (foodDays.isEmpty()) {
            System.out.println("No food entries yet.");
        } else {
            for (Day d : foodDays) {
                System.out.println(d+"\n");
            }
        }

        System.out.println("\nPress Enter to go back...");
        sc.nextLine();
    }

    static void workoutLog() {

        System.out.print("Enter workout date: ");
        Workout workout = new Workout(sc.nextLine());
        workouts.add(workout);

        while (true) {

            System.out.println("\nWORKOUT MENU");
            System.out.println("1. Add Exercise");
            System.out.println("0. Back");
            System.out.print("Choice: ");

            String input = sc.nextLine();

            if (input.equals("0")) return;

            if (input.equals("1")) {

                System.out.print("Exercise name: ");
                String name = sc.nextLine();
                
                System.out.print("Sets: ");
                int sets = sc.nextInt();

                System.out.print("Reps: ");
                int reps = sc.nextInt();

                System.out.print("RPE: ");
                int rpe = sc.nextInt();

                TypeOfExercise type = null;

                sc.nextLine();

                while (type == null) {
                    System.out.print("Type (CHEST, BACK, LEGS, SHOULDERS, ARMS): ");
                    try {
                        type = TypeOfExercise.valueOf(sc.nextLine().toUpperCase());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid type. Choose from: CHEST, BACK, LEGS, SHOULDERS, ARMS");
                    }
                }

                workout.addExercise(new Exercise(name, reps, sets, rpe, type));
                System.out.println("Exercise added!");
            }
        }
    }

    static void viewWorkouts() {

        System.out.println("\nWORKOUT HISTORY");

        if (workouts.isEmpty()) {
            System.out.println("No workout entries yet.");
        } else {
            for (Workout w : workouts) {
                w.display();
            }
        }

        System.out.println("\nPress Enter to go back...");
        sc.nextLine();
    }
    static void saveFoodDays() {
    try (PrintWriter writer = new PrintWriter(new FileWriter("days_index.txt"))) {

        writer.println(foodDays.size()); // save how many days

        for (int i = 0; i < foodDays.size(); i++) {
            String filename = "day_" + i + ".txt";
            writer.println(filename);

            foodDays.get(i).saveToFile(filename); // 🔥 USES YOUR Day METHOD
        }

        System.out.println("Food days saved!");

    } catch (IOException e) {
        System.out.println("Error saving: " + e.getMessage());
    }
}

static void loadFoodDays() {
    try {
        Scanner scanner = new Scanner(new File("days_index.txt"));

        int numDays = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numDays; i++) {
            String filename = scanner.nextLine();

            Day day = new Day(filename); // 🔥 USES YOUR CONSTRUCTOR
            foodDays.add(day);
        }

        scanner.close();
        System.out.println("Food days loaded!");

    } catch (FileNotFoundException e) {
        System.out.println("No save data found (starting fresh).");
    }
}

}
