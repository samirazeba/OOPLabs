package Week13;

class Logger {
    private static Logger instance;

    private Logger () {}

    public static Logger getInstance() {
        synchronized (Logger.class) {  //Thread safe
            if (instance == null) {
                instance = new Logger();
            }
        }
        return instance;
    }
    public void log(String message) {
        System.out.println("Log message: " + message);
    }
    public void logInfo(String message) {
        System.out.println("Info message: " + message);
    }
    public void logWarning(String message) {
        System.out.println("Warning message: " + message);
    }
    public void logError(String message) {
        System.out.println("Error message: " + message);
    }
}
class LoggerMain {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Welcome.");
        logger.logInfo("Information message.");
        logger.logWarning("Warning!");
        logger.logError("Error message.");
    }

}
