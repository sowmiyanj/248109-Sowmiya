import creational.factory.FactoryPatternDemo;
import utils.AppLogger;

public class Main {
    public static void main(String[] args) {
        AppLogger.info("Application started");

        FactoryPatternDemo demo = new FactoryPatternDemo();
        demo.run();

        AppLogger.info("Application finished");
    }
}
