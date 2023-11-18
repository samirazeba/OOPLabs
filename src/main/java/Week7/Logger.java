package Week7;

@FunctionalInterface
interface Logger {
    String logMessage(String message);
}
record RecordLogger (String loggerName) implements Logger {
    @Override
    public String logMessage(String message) {
        return message + " - " + this.loggerName;
    }
}

class ClassLogger implements Logger {
    private String loggerName;

    public ClassLogger(String loggerName) {
        this.loggerName = loggerName;
    }

    @Override
    public String logMessage(String message) {
        return message + " - " + this.loggerName;
    }

}
class StartLog {

    public static void main(String[] args) {

        Logger recordLogger = (message) -> new RecordLogger("Record").logMessage(message);
        Logger classLogger = (message) -> new ClassLogger("Class").logMessage(message);

        System.out.println(recordLogger.logMessage("Welcome"));
        System.out.println(classLogger.logMessage("Welcome"));
    }
}
