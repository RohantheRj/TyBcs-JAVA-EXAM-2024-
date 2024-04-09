import java.util.Scanner;

public class DisplayVowels {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        scanner.close();

        char[] characters = input.toCharArray();


        for (char ch : characters) {

            if (isVowel(ch)) {
                System.out.println(ch);
                try {
                    Thread.sleep(3000); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private static boolean isVowel(char ch) {
        ch = Character.toUpperCase(ch); 
        return ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
}

