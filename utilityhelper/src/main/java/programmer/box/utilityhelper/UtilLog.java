package programmer.box.utilityhelper;

import android.util.Log;

/**
 * Created by Jacob on 10/3/17.
 */

public class UtilLog {

    public static boolean SHOW_PRETTY = true;
    public static String FILTER_BY_CLASS_NAME = "";
    private static String HELPER_NAME = "programmer.box.utilityhelper";
    public static String TAG = "UtilLog";

    private static void prettyLog(String msg, int level) {
        String methodEnd = "prettyLog";
        //the main message to be logged
        StringBuilder logged = new StringBuilder(msg);
        //the arrow for the stack trace
        String arrow = "" + ((char) 9552) + ((char) 9655) + "\t";
        //the stack trace
        StackTraceElement[] stackTraceElement = Thread.currentThread().getStackTrace();
        //the location of the stack
        StringBuilder location = new StringBuilder("\n");
        //lets go through the stack
        for (int i = stackTraceElement.length - 1; i >= 0; i--) {
            //until we get to this method
            if (stackTraceElement[i].getMethodName().compareTo(methodEnd) == 0) {
                break;
            }
            //get the full class name
            String fullClassName = stackTraceElement[i].getClassName();
            //only add method if its apart of the crestron modules (for now)
            if (fullClassName.contains(FILTER_BY_CLASS_NAME) && !fullClassName.contains(HELPER_NAME)) {
                //get the method name
                String methodName = stackTraceElement[i].getMethodName();
                //get the file name
                String fileName = stackTraceElement[i].getFileName();
                //get the line number
                String lineNumber = String.valueOf(stackTraceElement[i].getLineNumber());
                //add this to location in a format where we can click on the number in the console
                location.append(fullClassName)
                        .append(".").append(methodName)
                        .append("(").append(fileName)
                        .append(":").append(lineNumber).append(")");
                //if the next method is not prettyLog and i is not 0
                if (stackTraceElement[i - 1].getMethodName().compareTo(methodEnd) != 0 && i != 0
                        && !stackTraceElement[i - 1].getClassName().contains(HELPER_NAME)) {
                    //if there are more calls in the chain, get ready to add more
                    char typeOfArrow;
                    if (stackTraceElement[i - 2].getMethodName().compareTo(methodEnd) != 0)
                        typeOfArrow = 9568; //middle arrow
                    else
                        typeOfArrow = 9562; //ending arrow
                    location.append("\n\t").append(typeOfArrow).append(arrow);
                }
            }
        }
        //add the location to what we will be logging
        logged.append(location);

        Log.println(level, TAG, logged.toString());
    }

    //---------------------------------EVERYTHING BELOW WORKS FINE----------------------------------

    private static void log(String msg, int level) {
        StackTraceElement[] stackTraceElement = Thread.currentThread().getStackTrace();
        int currentIndex = -1;
        for (int i = 0; i < stackTraceElement.length; i++) {
            if (stackTraceElement[i].getMethodName().compareTo("log") == 0) {
                currentIndex = i + 1;
                break;
            }
        }
        currentIndex++;

        String fullClassName = stackTraceElement[currentIndex].getClassName();
        String methodName = stackTraceElement[currentIndex].getMethodName();
        String fileName = stackTraceElement[currentIndex].getFileName();
        String lineNumber = String.valueOf(stackTraceElement[currentIndex].getLineNumber());
        String logged = msg + "\tat " + fullClassName + "." + methodName + "(" + fileName + ":" + lineNumber + ")";

        Log.println(level, TAG, logged);

    }

    //Console Log-------------------------------------------------

    /**
     * Error log
     *
     * @param msg the message to log
     */
    public static void e(String msg) {
        if (SHOW_PRETTY)
            prettyLog(msg, Log.ERROR);
        else
            log(msg, Log.ERROR);
    }

    /**
     * Info log
     *
     * @param msg the message to log
     */
    public static void i(String msg) {
        if (SHOW_PRETTY)
            prettyLog(msg, Log.INFO);
        else
            log(msg, Log.INFO);
    }

    /**
     * Assert log
     *
     * @param msg the message to log
     */
    public static void a(String msg) {
        if (SHOW_PRETTY)
            prettyLog(msg, Log.ASSERT);
        else
            log(msg, Log.ASSERT);
    }

    /**
     * What a Terrible Failure log
     *
     * @param msg the message to log
     */
    public static void wtf(String msg) {
        if (SHOW_PRETTY)
            prettyLog(msg, Log.ASSERT);
        else
            log(msg, Log.ASSERT);
    }

    /**
     * Warning log
     *
     * @param msg the message to log
     */
    public static void w(String msg) {
        if (SHOW_PRETTY)
            prettyLog(msg, Log.WARN);
        else
            log(msg, Log.WARN);
    }

    /**
     * Debug log
     *
     * @param msg the message to log
     */
    public static void d(String msg) {
        if (SHOW_PRETTY)
            prettyLog(msg, Log.DEBUG);
        else
            log(msg, Log.DEBUG);
    }

    /**
     * Verbose log
     *
     * @param msg the message to log
     */
    public static void v(String msg) {
        if (SHOW_PRETTY)
            prettyLog(msg, Log.VERBOSE);
        else
            log(msg, Log.VERBOSE);
    }

}