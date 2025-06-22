class Logger {
    private static Logger instance;
    private Logger() {}
    public static Logger getInstance() {
        if (instance == null) instance = new Logger();
        return instance;
    }
    public void log(String msg) {
        System.out.println("Log: " + msg);
    }
}

class SingleTon {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        logger1.log("This is a log message. \n By Meenakshi A J - 6420952");
        System.out.println(logger1 == logger2); // true
    }
}