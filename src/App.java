import java.util.Scanner;

/**
 * Instructions:
 * - Complete the WeeklyData.java class first.
 * - Use this App class to collect user input and test your WeeklyData methods.
 * - Follow all TODOs carefully.
 * - Do NOT hard-code values — use loops and method calls.
 */
public class App {

    public static void main(String[] args) {

        // Create a Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Give information about the program
        System.out.println("========================================");
        System.out.println("   RUNNING MILES TRACKER - WEEKLY DATA");
        System.out.println("========================================\n");

        // Collect user information
        System.out.print("What is your username? ");
        String userName = scanner.nextLine();

        System.out.print("Are you a beginner, intermediate, or advanced runner? ");
        String skillLevel = scanner.nextLine().toLowerCase();

        // Validate skill level
        while (!skillLevel.equals("beginner") && !skillLevel.equals("intermediate") && !skillLevel.equals("advanced")) {
            System.out.print("Please enter 'beginner', 'intermediate', or 'advanced': ");
            skillLevel = scanner.nextLine().toLowerCase();
        }

        System.out.print("What is your goal for running this week? ");
        String goal = scanner.nextLine();

        System.out.println("\n========================================");
        System.out.println("ENTER YOUR DAILY RUNNING MILES");
        System.out.println("========================================\n");

        // Create an array to hold 7 days of data
        double[] weekData = new double[7];
        double maxAllowed = getMaxMilesForSkill(skillLevel);

        // Use a for loop to collect data for each day of the week
        for (int day = 1; day <= 7; day++) {
            boolean validInput = false;

            while (!validInput) {
                System.out.print("Enter miles for Day " + day + ": ");

                try {
                    double miles = Double.parseDouble(scanner.nextLine());

                    // Validate input
                    if (miles < 0) {
                        System.out.println("ERROR: Miles cannot be negative. Try again.");
                    } else if (miles > maxAllowed) {
                        System.out.println("ERROR: Your skill level (" + skillLevel + ") allows max " + maxAllowed + " miles/week. Try again.");
                    } else {
                        weekData[day - 1] = miles;
                        validInput = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("ERROR: Please enter a valid number. Try again.");
                }
            }
        }

        // Create a WeeklyData object
        WeeklyData runningData = new WeeklyData(weekData, userName, skillLevel);

        // Display the results of the analysis
        System.out.println("\n========================================");
        System.out.println("END OF WEEK STATS AND TIPS");
        System.out.println("========================================\n");

        System.out.println("Runner: " + userName);
        System.out.println("Skill Level: " + skillLevel);
        System.out.println("Weekly Goal: " + goal);
        System.out.println();

        // Calculate and display statistics
        double total = runningData.getTotal();
        double average = runningData.getAverage();
        double maxMiles = runningData.getMax();
        double minMiles = runningData.getMin();

        System.out.printf("Total Miles This Week: %.2f miles\n", total);
        System.out.printf("Average Miles Per Day: %.2f miles\n", average);
        System.out.printf("Your Longest Run: %.2f miles\n", maxMiles);
        System.out.printf("Your Shortest Run: %.2f miles\n\n", minMiles);

        // Display the full week of data
        System.out.println("DAILY BREAKDOWN:");
        System.out.println(runningData.toString());

        // Give the user insights about their week
        giveWeeklyInsights(userName, skillLevel, total, maxAllowed, average, maxMiles, minMiles);

        scanner.close();
    }

    /**
     * Returns the maximum miles allowed per week based on skill level
     */
    private static double getMaxMilesForSkill(String skillLevel) {
        switch (skillLevel.toLowerCase()) {
            case "beginner":
                return 20.0;
            case "intermediate":
                return 40.0;
            case "advanced":
                return Double.MAX_VALUE; // No limit
            default:
                return 20.0;
        }
    }

    /**
     * Provides personalized insights and tips based on the week's data
     */
    private static void giveWeeklyInsights(String userName, String skillLevel, double total,
                                           double maxAllowed, double average, double maxMiles, double minMiles) {
        System.out.println("========================================");
        System.out.println("PERSONALIZED INSIGHTS FOR YOU");
        System.out.println("========================================\n");

        // Percentage of max allowed
        double percentageOfMax = (total / maxAllowed) * 100;

        if (percentageOfMax >= 100) {
            System.out.println("Great job, " + userName + "! You've reached your weekly goal!");
            System.out.println("You're pushing your limits and building excellent endurance!");
        } else if (percentageOfMax >= 75) {
            System.out.println("Excellent effort, " + userName + "! You're " + String.format("%.0f", percentageOfMax) + "% of your target.");
            System.out.println("Keep this momentum going next week!");
        } else if (percentageOfMax >= 50) {
            System.out.println("Good start, " + userName + "! You're " + String.format("%.0f", percentageOfMax) + "% of your target.");
            System.out.println("Try to add a few more miles next week to reach your goal.");
        } else {
            System.out.println("You're " + String.format("%.0f", percentageOfMax) + "% of your target, " + userName + ".");
            System.out.println("Consider adding more running days or longer distances next week!");
        }

        // Consistency feedback
        if (maxMiles == 0 && minMiles == 0) {
            System.out.println("\nYou didn't run this week. Get back on the track!");
        } else if (maxMiles - minMiles < 2.0 && average > 0) {
            System.out.println("\nGreat consistency! Your runs were very balanced throughout the week.");
        } else {
            System.out.println("\nWork on consistency. Try to keep your daily distances more uniform.");
        }

        // Endurance feedback
        if (average > 0 && average < 3.0) {
            System.out.println("Focus on shorter, regular runs to build a solid base.");
        } else if (average >= 3.0 && average < 6.0) {
            System.out.println("You're building good endurance. Keep it up!");
        } else if (average >= 6.0) {
            System.out.println("Impressive! You're building strong aerobic capacity.");
        }

        System.out.println("\n========================================");
        System.out.println("Keep running, " + userName + "! See you next week!");
        System.out.println("========================================\n");
    }
}
