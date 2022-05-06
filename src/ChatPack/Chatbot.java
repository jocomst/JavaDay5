package ChatPack;

public class Chatbot implements ScannerFactory{
    private User user;

    public Chatbot() {
        this.user = new User();
        this.greetUser();
    }

    public void greetUser() {
        System.out.println("Hello!");
        this.repeatName();
    }

    public void repeatName() {
        System.out.println("Please repeat your name!");
        String name = scanner.nextLine();
        this.user.setName(name);
        this.getBounds(user);
    }

    public void getBounds(User user) {
        System.out.println("Ok " + user.getName() + ", time to guess your age...");
        System.out.println("Give me a lower bound...");
        int lowerBound = Integer.valueOf(scanner.nextLine());
        System.out.println("Ok now give me an upper bound");
        int upperBound = Integer.valueOf(scanner.nextLine());
        System.out.println("So your age is between " + lowerBound + " and " + upperBound + "...");
        this.guessAge(lowerBound, upperBound);
        this.testing();
        this.tellStory();
        this.dayOfTheWeek();
    }

    public void guessAge(int lower, int upper) {
        if (lower > 0 && upper > 0 && lower < upper) {
            while (true) {
                System.out.println("Is " + lower + " your age?");
                System.out.println("Enter yes or no");
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("yes")) {
                    this.user.setAge(lower);
                    this.countToNumber();
                    break;
                } else {
                    System.out.println("Hm ok...");
                    lower++;
                }
            }

        } else {
            System.out.println("Numbers invalid, please try again");
            this.getBounds(this.user);
        }
    }

    public void countToNumber() {
        System.out.println("So you are " + this.user.getAge() + " years old");
        System.out.println("Time to count to a number");
        System.out.println("Choose a number!");
        int number = Integer.valueOf(scanner.nextLine());
        if (number < 0) {
            System.out.println("Number less than zero, we don't count backwards!");
            System.out.println("Try again");
            this.countToNumber();
        }

        for (int i = 1; i <= number; i++) {
            if (i == number) {
                System.out.println("We have reached your number! " + number);
            } else {
                System.out.println(i);
            }

        }
    }

    public void testing() {
        System.out.println("Time for a short test!");
        System.out.println("Which method can be used to return a string in upper case letters?");
        String a = "A: toUpperCase()";
        String b = "B: upperCase()";
        String c = "C: tuc()";
        String d = "D: touppercase()";
        String correct = "a";
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        String input = scanner.nextLine();
        if (!(input.equalsIgnoreCase("a") ||
                input.equalsIgnoreCase("b") ||
                input.equalsIgnoreCase("c") ||
                input.equalsIgnoreCase("d"))) {
            System.out.println("Invalid input please try again.");
            this.testing();
        }

        System.out.println("You chose " + input + "!");
        if (correct.equalsIgnoreCase(input)){
            System.out.println("That is correct!");
        } else {
            System.out.println("Sorry, study up and try again later");
            this.testing();
        }


    }

    public void tellStory() {
        System.out.println("Time for a quick story..");
        System.out.println("Your name is " + this.user.getName() + " and you are " + this.user.getAge() + " years old");
        System.out.println(this.user.getName() + " is a participant in the CTAC program as a part of Carolina Fintech Hub.");

    }

    public void dayOfTheWeek() {
        System.out.println("Choose a day and hear my thoughts");
        System.out.println("Pick a number between 1 and 7");
        int number = Integer.valueOf(scanner.nextLine());
        if (number < 1 || number > 7) {
            System.out.println("Invalid input, please try again");
            this.dayOfTheWeek();
        }

        String dayString = "";
        switch (number) {
            case 1: dayString = "On Mondays I like to relax and chill";
            break;
            case 2: dayString = "Tuesdays are important to be productive and energetic";
            break;
            case 3: dayString = "The middle of the week is my peak! On Wednesday I grind out as much as I can";
            break;
            case 4: dayString = "Thursdays are often gloomy but I still keep it real";
            break;
            case 5: dayString = "An exciting day! Friday is the gateway to the weekend!";
            break;
            case 6: dayString = "Saturdays are for day trips or relaxing, gotta enjoy your free time!";
            break;
            case 7: dayString = "Prepare for the upcoming week and enjoy a nice walk on Sunday";
            break;
        }
        System.out.println(dayString);
    }


}
