package menu;

import exercisetracker.*;
import java.util.*;
import macrotracker.*;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Day> foodDays = new ArrayList<>();
    static ArrayList<Workout> workouts = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println(" Community Fitness & Wellness Tracker ");
        System.out.println("======================================");

        while (true) {

            System.out.println("\nMAIN MENU");
            System.out.println("1. Food Log");
            System.out.println("2. View Food Log (History)");
            System.out.println("3. Workout Log");
            System.out.println("4. View Workout Log (History)");
            System.out.println("5. Exit");
            System.out.print("Choice: ");

            String choice = sc.nextLine();

            switch (choice) {
                case "1" -> foodLog();
                case "2" -> viewFoodLog();
                case "3" -> workoutLog();
                case "4" -> viewWorkouts();
                case "5" -> {
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

    // ================= FOOD LOG =================
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
            }
        }
    }

    // ================= VIEW FOOD =================
    static void viewFoodLog() {

        System.out.println("\n===== FOOD HISTORY =====");

        if (foodDays.isEmpty()) {
            System.out.println("No food entries yet.");
        } else {
            for (Day d : foodDays) {
                System.out.println(d);
            }
        }

        System.out.println("\nPress Enter to go back...");
        sc.nextLine();
    }

    // ================= WORKOUT LOG =================
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

                int reps = readInt("Reps: ");
                int sets = readInt("Sets: ");
                int rpe  = readInt("RPE: ");

                TypeOfExercise type = null;
                while (type == null) {
                    System.out.print("Type (CHEST, BACK, LEGS, SHOULDERS, ARMS): ");
                    try {
                        type = TypeOfExercise.valueOf(sc.nextLine().toUpperCase().trim());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid type. Choose from: CHEST, BACK, LEGS, SHOULDERS, ARMS");
                    }
                }

                workout.addExercise(new Exercise(name, reps, sets, rpe, type));
                System.out.println("Exercise added!");
            }
        }
    }

    // ================= VIEW WORKOUT =================
    static void viewWorkouts() {

        System.out.println("\n===== WORKOUT HISTORY =====");

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
}
