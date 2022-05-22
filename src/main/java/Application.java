import app.config.ApplicationConfigurer;
import app.config.ApplicationProperties;

public class Application {

    public static void main(String[] args) {
        //reading application configuration from configuration.json
        ApplicationConfigurer appConfig = new ApplicationConfigurer();
        ApplicationProperties appProperties = appConfig.parseConfigurationObject(appConfig.readJSONFile());
        //running with properties
        System.out.println(appProperties.toString());

        Galaxy galaxy = new Galaxy(1,2);

        for (int i = 0; i < 5; i++) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Generation " + (i + 1) + ":");

            galaxy.makeStep();
            galaxy.print();
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
