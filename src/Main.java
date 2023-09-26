/* Person B wants to have dinner every day with person A. Person A wants to avoid person B.
At the university there are two restaurants, a regular one (dining time 20 min), and a fancy one (dining time 50 min). For simplicity, we assume that, at 12.00 each day, A and B each choose a restaurant and go to lunch; they never choose not to eat, and they do not change their choice of restaurant that day.

What strategy should A use to choose a restaurant in order to minimize the time spent with B? What strategy should B use to maximize the amount of time spent with A? If they both use the strategies you have chosen, how much time do they spend together per day on average?

Hint: Spend some time thinking about the problem intuitively before you start trying to solve it mathematically.
*/

public class Main {
    public static void main(String[] args) {

        for(double i = 100 ; i < 300 ; i ++) {
            double frequency = i/1000;
            System.out.println(frequency + ": " + tonsOfDays(frequency));
        }

        //System.out.println(getRandom(0.5));
    }

    public static double tonsOfDays(double frequency) {
        int timeSpentPerDay = 0;

        for(int i = 0 ; i < 10000000 ; i++) {
            timeSpentPerDay += oneDay(frequency);
        }

        return (double) timeSpentPerDay/10000000;
    }

    public static int oneDay(double frequency) {
        boolean fancyRunner = getRandom(frequency);
        boolean fancyStalker = getRandom(frequency);

        if (fancyRunner && fancyStalker) {
            // System.out.println("Fancy dinner together <3");
            return 50;
        } else if(fancyStalker == fancyRunner) {
            // System.out.println("Regular dinner together <3");
            return 20;
        } else {
            // System.out.println("No dinner together </3");
            return 0;
        }
    }

    public static boolean getRandom(double odds) {
        return Math.random() < odds;
    }

}