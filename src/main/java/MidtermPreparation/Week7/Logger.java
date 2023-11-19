package MidtermPreparation.Week7;

@FunctionalInterface
interface Logger {
    String logMessage(String message);
}
record RecordLogger (String logName) implements Logger {
    @Override
    public String logMessage(String message) {
        return "Message: " + message + " " + this.logName;
    }
}
class ClassLogger implements Logger {
    private String logName;

    public ClassLogger(String logName) {
        this.logName = logName;
    }
    @Override
    public String logMessage(String message) {
        return "Message: " + message + " " + this.logName;
    }
}
class RunLogger {
    public static void main(String[] args) {
        //use lambda functions
        Logger recordLogger = (message -> new RecordLogger("Record").logMessage(message));
        Logger classLogger = (message ->  new ClassLogger("Class").logMessage(message));

        System.out.println(recordLogger.logMessage("Welcome"));
        System.out.println(classLogger.logMessage("Welcome"));

    }
}
