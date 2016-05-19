import java.util.*;

public class Menu {
    private ArrayList<String> choices;


    public Menu() {
        choices = new ArrayList<String>(10);
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

    public void presentChoices() {

        clearScreen();

        int i = 1;
        for (String s : choices) {
            System.out.println("[" + i + "] - " + s);
            i++;
        }


    }


    public int getChoosen() {

        System.out.print("Escolha a sua opção: ");
        int choice;
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice > 0 && choice <= choices.size()) {
                    return choice;
                }
            }
        }

        return -1;
    }
}
