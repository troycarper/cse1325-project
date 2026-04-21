package menu;

import java.util.*;

import exercisetracker.*;
import macrotracker.*;

public class Main {
    static Scanner sc = new Scanner(System.in);

    static ArrayList<Day> foodDays = new ArrayList<>();
    static ArrayList<Workout> workouts = new ArrayList<>();


    protected int calGoal;
    protected int carbGoal;
    protected int fatGoal;
    protected int proteinGoal;

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

                case "1":
                    foodLog();
                    break;

                case "2":
                    viewFoodLog();
                    break;

                case "3":
                    workoutLog();
                    break;

                case "4":
                    viewWorkouts();
                    break;

                case "5":
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    // ================= FOOD LOG =================
    static void foodLog() {

        System.out.print("Enter date (e.g. Monday): ");
        Day day = new Day(sc.nextLine());
        foodDays.add(day);

        while (true) {

            System.out.println("\nFOOD MENU");
            System.out.println("1. Add Meal");
            System.out.println("0. Back");
            System.out.print("Choice: ");

            String input = sc.nextLine();

            if (input.equals("0")) return;

            if (input.equals("1")) {

                System.out.print("Meal name: ");
                Meal meal = new Meal(sc.nextLine());

                System.out.print("How many foods? ");
                int count = Integer.parseInt(sc.nextLine());

                for (int i = 0; i < count; i++) {

                    System.out.print("Food name: ");
                    String name = sc.nextLine();

                    System.out.print("Calories: ");
                    int cal = Integer.parseInt(sc.nextLine());

                    System.out.print("Protein (g): ");
                    int protein = Integer.parseInt(sc.nextLine());

                    System.out.print("Carbs (g): ");
                    int carbs = Integer.parseInt(sc.nextLine());

                    System.out.print("Fat (g): ");
                    int fat = Integer.parseInt(sc.nextLine());

                    meal.addFood(new Food(name, cal, protein, carbs, fat));
                }

                day.addMeal(meal);
                System.out.println("Meal added!");
            }
        }
    }

    // ================= VIEW FOOD =================
    static void viewFoodLog() {

        System.out.println("\n===== FOOD HISTORY =====");

        for (Day d : foodDays) {
            System.out.println(d.toString());
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

                System.out.print("Reps: ");
                int reps = Integer.parseInt(sc.nextLine());

                System.out.print("Sets: ");
                int sets = Integer.parseInt(sc.nextLine());

                System.out.print("RPE: ");
                int rpe = Integer.parseInt(sc.nextLine());

                System.out.print("Type (CHEST, BACK, LEGS, SHOULDERS, ARMS): ");
                TypeOfExercise type =
                        TypeOfExercise.valueOf(sc.nextLine().toUpperCase());

                workout.addExercise(new Exercise(name, reps, sets, rpe, type));

                System.out.println("Exercise added!");
            }
        }
    }

    // ================= VIEW WORKOUT =================
    static void viewWorkouts() {

        System.out.println("\n===== WORKOUT HISTORY =====");

        for (Workout w : workouts) {
            w.display();
        }

        System.out.println("\nPress Enter to go back...");
        sc.nextLine();
    }
}
