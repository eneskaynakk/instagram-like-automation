import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Please enter your username");
        String userName = scanner.nextLine();
        System.out.println("Please enter your username");
        String password = scanner.nextLine();
        System.out.println("Please enter your profile name");
        String profileName = scanner.nextLine();

        App app = new App();
        app.application();
        app.loginWith(userName,password);
        app.profileSearch(profileName);
        app.likeAllPost();


    }

}
