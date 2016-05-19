import java.util.*;

public class Menu {
    private ArrayList<String> choices;


    public Menu() {
        choices = new ArrayList<String>();
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void addField(String choice) {

        if (choice != null && !choice.isEmpty()) {
            choices.add(choice);
        }
    }

    public List<String> getParams() {

        List<String> params = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        clearScreen();

        int i = 1;
        for (String s : choices) {
            System.out.print(s + ": ");
            i++;

            params.add(scanner.nextLine());
            System.out.print("\n");
        }


        return params;
    }

    public int presentChoices() {

        clearScreen();

        int last_index = choices.size() - 1;

        for (int i = 0; i < last_index; i++) {
            System.out.println("[" + (i + 1) + "] - " + choices.get(i));
        }

        System.out.println("[0] - " + choices.get(last_index));

        return getChoosenFromUser();
    }

    public int presentChoices(int max) {

        clearScreen();

        int choice = -1;

        for (int i = 0; i < choices.size() - 1; i++) {
            System.out.println("[" + (i + 1) + "] - " + choices.get(i));

            if (i % max == max - 1) {
                if (i != choices.size() - 2) {
                    System.out.println("[" + (i + 2) + "] - " + "Mais");
                }
                System.out.println("[" + 0 + "] - " + choices.get(choices.size() - 1));

                choice = getChoosenFromUser();
                if (choice != i + 2) {
                    return choice;
                }
            }


        }

        System.out.println("[" + 0 + "] - " + choices.get(choices.size() - 1));
        choice = getChoosenFromUser();
        return choice;
    }


    private int getChoosenFromUser() {

        System.out.print("Escolha a sua opção: ");
        int choice;
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 0 && choice <= choices.size()) {
                    return choice;
                }
            }
        }

        return -1;
    }
}
