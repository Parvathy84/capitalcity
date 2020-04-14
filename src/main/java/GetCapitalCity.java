import utils.GetCapital;
import utils.InputVerification;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.exit;

public class GetCapitalCity {

    public static void main(String[] args) throws IOException, InterruptedException {

        String countryName, countryCode = "";
        //get input
        System.out.println("Enter Country Name (Enter to skip) :");
        Scanner in = new Scanner(System.in);
        countryName = in.nextLine();
        if (countryName.isEmpty()) {
            System.out.println("Enter Country Code :");
            countryCode = in.nextLine();
        }
        Map<String, String> capital;
        if (InputVerification.verifyInput(countryName, countryCode)) {
            if (countryCode.isEmpty())
                capital = GetCapital.getCapitalByName(countryName);
            else
                capital = GetCapital.getCapitalByCode(countryCode);
            System.out.println("***********Capital************");
            for (Map.Entry<String, String> entry : capital.entrySet()) {
                System.out.println(entry.getKey() + "->" + entry.getValue());
            }
            exit(0);
        }
        System.out.println("invalid input");
        exit(1);

    }
}
