package setup;

public class DriverManagerFactory {

    public static DriverManager getDriverManager(DriverType driverType){
        DriverManager driverManager;

        switch (driverType){
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;

            default:
                driverManager = null;
                break;
        }
        return driverManager;
    }

}
