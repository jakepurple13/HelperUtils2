package programmer.box.utilityhelper;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Jacob on 10/3/17.
 */

public class UtilLog {

    public static boolean SHOW_PRETTY = true;
    public static String FILTER_BY_CLASS_NAME = "";
    private static String HELPER_NAME = "programmer.box.utilityhelper";
    public static String TAG = "UtilLog";

    private static void prettyLog(String msg, int level) {
        //the main message to be logged
        StringBuilder logged = new StringBuilder(msg);
        //the arrow for the stack trace
        String arrow = "" + ((char) 9552) + ((char) 9655) + "\t";
        //the stack trace
        StackTraceElement[] stackTraceElement = Thread.currentThread().getStackTrace();

        List<StackTraceElement> elements = Arrays.asList(stackTraceElement);
        List<StackTraceElement> wanted = new ArrayList<>();

        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getClassName().contains(FILTER_BY_CLASS_NAME) &&
                    !elements.get(i).getClassName().contains(HELPER_NAME)) {
                wanted.add(elements.get(i));
            }
        }

        StringBuilder loc = new StringBuilder("\n");

        for (int i = wanted.size() - 1; i >= 0; i--) {
            String fullClassName = wanted.get(i).getClassName();
            //get the method name
            String methodName = wanted.get(i).getMethodName();
            //get the file name
            String fileName = wanted.get(i).getFileName();
            //get the line number
            String lineNumber = String.valueOf(wanted.get(i).getLineNumber());
            //add this to location in a format where we can click on the number in the console
            loc.append(fullClassName)
                    .append(".").append(methodName)
                    .append("(").append(fileName)
                    .append(":").append(lineNumber).append(")");

            if (wanted.size() > 1 && i-1>=0) {
                char typeOfArrow;
                if (i - 1 > 0)
                    typeOfArrow = 9568; //middle arrow
                else
                    typeOfArrow = 9562; //ending arrow
                loc.append("\n\t").append(typeOfArrow).append(arrow);
            }
        }

        logged.append(loc);

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