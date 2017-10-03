package programmer.box.utilityhelper;

import android.util.Log;

/**
* Created by Jacob on 10/3/17.
*/

public class UtilLog {

    private static void showLogCat(String tag, String msg) {

        StackTraceElement[] stackTraceElement = Thread.currentThread()
                .getStackTrace();
        int currentIndex = -1;
        for (int i = 0; i < stackTraceElement.length; i++) {
            if (stackTraceElement[i].getMethodName().compareTo("showLogCat") == 0) {
                currentIndex = i + 1;
                break;
            }
        }

        String fullClassName = stackTraceElement[currentIndex].getClassName();
        String className = fullClassName.substring(fullClassName
                .lastIndexOf(".") + 1);
        String methodName = stackTraceElement[currentIndex].getMethodName();
        String lineNumber = String
                .valueOf(stackTraceElement[currentIndex].getLineNumber());

        Log.i(tag, msg);
        Log.i(tag + " position", "at " + fullClassName + "." + methodName + "("
                + className + ".java:" + lineNumber + ")");

    }

    /**
     * i - INFO log with the location of where it was called
     * @param tag The tag
     * @param msg The message
     */
    public static void i(String tag, String msg) {
        StackTraceElement[] stackTraceElement = Thread.currentThread()
                .getStackTrace();
        int currentIndex = -1;
        for (int i = 0; i < stackTraceElement.length; i++) {
            if (stackTraceElement[i].getMethodName().compareTo("i") == 0) {
                currentIndex = i + 1;
                break;
            }
        }

        String fullClassName = stackTraceElement[currentIndex].getClassName();
        String className = fullClassName.substring(fullClassName
                .lastIndexOf(".") + 1);
        String methodName = stackTraceElement[currentIndex].getMethodName();
        String lineNumber = String
                .valueOf(stackTraceElement[currentIndex].getLineNumber());

        Log.i(tag, msg + "\tat " + fullClassName + "." + methodName + "("
                + className + ".java:" + lineNumber + ")");
    }

    /**
     * i - INFO log with the location of where it was called and the line number as the tag
     * @param msg The message
     */
    public static void i(String msg) {
        StackTraceElement[] stackTraceElement = Thread.currentThread()
                .getStackTrace();
        int currentIndex = -1;
        for (int i = 0; i < stackTraceElement.length; i++) {
            if (stackTraceElement[i].getMethodName().compareTo("i") == 0) {
                currentIndex = i + 1;
                break;
            }
        }

        String fullClassName = stackTraceElement[currentIndex].getClassName();
        String className = fullClassName.substring(fullClassName
                .lastIndexOf(".") + 1);
        String methodName = stackTraceElement[currentIndex].getMethodName();
        String lineNumber = String
                .valueOf(stackTraceElement[currentIndex].getLineNumber());

        Log.i("Line_"+lineNumber, msg + "\tat " + fullClassName + "." + methodName + "("
                + className + ".java:" + lineNumber + ")");
    }

    /**
     * w - WARNING log with the location of where it was called
     * @param tag The tag
     * @param msg The message
     */
    public static void w(String tag, String msg) {
        StackTraceElement[] stackTraceElement = Thread.currentThread()
                .getStackTrace();
        int currentIndex = -1;
        for (int i = 0; i < stackTraceElement.length; i++) {
            if (stackTraceElement[i].getMethodName().compareTo("w") == 0) {
                currentIndex = i + 1;
                break;
            }
        }

        String fullClassName = stackTraceElement[currentIndex].getClassName();
        String className = fullClassName.substring(fullClassName
                .lastIndexOf(".") + 1);
        String methodName = stackTraceElement[currentIndex].getMethodName();
        String lineNumber = String
                .valueOf(stackTraceElement[currentIndex].getLineNumber());

        Log.w(tag, msg + "\tat " + fullClassName + "." + methodName + "("
                + className + ".java:" + lineNumber + ")");
    }

    /**
     * w - WARNING log with the location of where it was called and the line number as the tag
     * @param msg The message
     */
    public static void w(String msg) {
        StackTraceElement[] stackTraceElement = Thread.currentThread()
                .getStackTrace();
        int currentIndex = -1;
        for (int i = 0; i < stackTraceElement.length; i++) {
            if (stackTraceElement[i].getMethodName().compareTo("w") == 0) {
                currentIndex = i + 1;
                break;
            }
        }

        String fullClassName = stackTraceElement[currentIndex].getClassName();
        String className = fullClassName.substring(fullClassName
                .lastIndexOf(".") + 1);
        String methodName = stackTraceElement[currentIndex].getMethodName();
        String lineNumber = String
                .valueOf(stackTraceElement[currentIndex].getLineNumber());

        Log.w("Line_"+lineNumber, msg + "\tat " + fullClassName + "." + methodName + "("
                + className + ".java:" + lineNumber + ")");
    }

    /**
     * e - ERROR log with the location of where it was called
     * @param tag The tag
     * @param msg The message
     */
    public static void e(String tag, String msg) {
        StackTraceElement[] stackTraceElement = Thread.currentThread()
                .getStackTrace();
        int currentIndex = -1;
        for (int i = 0; i < stackTraceElement.length; i++) {
            if (stackTraceElement[i].getMethodName().compareTo("e") == 0) {
                currentIndex = i + 1;
                break;
            }
        }

        String fullClassName = stackTraceElement[currentIndex].getClassName();
        String className = fullClassName.substring(fullClassName
                .lastIndexOf(".") + 1);
        String methodName = stackTraceElement[currentIndex].getMethodName();
        String lineNumber = String
                .valueOf(stackTraceElement[currentIndex].getLineNumber());

        Log.e(tag, msg + "\tat " + fullClassName + "." + methodName + "("
                + className + ".java:" + lineNumber + ")");
    }

    /**
     * e - ERROR log with the location of where it was called and the line number as the tag
     * @param msg The message
     */
    public static void e(String msg) {
        StackTraceElement[] stackTraceElement = Thread.currentThread()
                .getStackTrace();
        int currentIndex = -1;
        for (int i = 0; i < stackTraceElement.length; i++) {
            if (stackTraceElement[i].getMethodName().compareTo("e") == 0) {
                currentIndex = i + 1;
                break;
            }
        }

        String fullClassName = stackTraceElement[currentIndex].getClassName();
        String className = fullClassName.substring(fullClassName
                .lastIndexOf(".") + 1);
        String methodName = stackTraceElement[currentIndex].getMethodName();
        String lineNumber = String
                .valueOf(stackTraceElement[currentIndex].getLineNumber());

        Log.e("Line_"+lineNumber, msg + "\tat " + fullClassName + "." + methodName + "("
                + className + ".java:" + lineNumber + ")");
    }

    /**
     * v - VERBOSE log with the location of where it was called
     * @param tag The tag
     * @param msg The message
     */
    public static void v(String tag, String msg) {
        StackTraceElement[] stackTraceElement = Thread.currentThread()
                .getStackTrace();
        int currentIndex = -1;
        for (int i = 0; i < stackTraceElement.length; i++) {
            if (stackTraceElement[i].getMethodName().compareTo("v") == 0) {
                currentIndex = i + 1;
                break;
            }
        }

        String fullClassName = stackTraceElement[currentIndex].getClassName();
        String className = fullClassName.substring(fullClassName
                .lastIndexOf(".") + 1);
        String methodName = stackTraceElement[currentIndex].getMethodName();
        String lineNumber = String
                .valueOf(stackTraceElement[currentIndex].getLineNumber());

        Log.v(tag, msg + "\tat " + fullClassName + "." + methodName + "("
                + className + ".java:" + lineNumber + ")");
    }

    /**
     * v - VERBOSE log with the location of where it was called and the line number as the tag
     * @param msg The message
     */
    public static void v(String msg) {
        StackTraceElement[] stackTraceElement = Thread.currentThread()
                .getStackTrace();
        int currentIndex = -1;
        for (int i = 0; i < stackTraceElement.length; i++) {
            if (stackTraceElement[i].getMethodName().compareTo("v") == 0) {
                currentIndex = i + 1;
                break;
            }
        }

        String fullClassName = stackTraceElement[currentIndex].getClassName();
        String className = fullClassName.substring(fullClassName
                .lastIndexOf(".") + 1);
        String methodName = stackTraceElement[currentIndex].getMethodName();
        String lineNumber = String
                .valueOf(stackTraceElement[currentIndex].getLineNumber());

        Log.v("Line_"+lineNumber, msg + "\tat " + fullClassName + "." + methodName + "("
                + className + ".java:" + lineNumber + ")");
    }

    /**
     * d - DEBUG log with the location of where it was called
     * @param tag The tag
     * @param msg The message
     */
    public static void d(String tag, String msg) {
        StackTraceElement[] stackTraceElement = Thread.currentThread()
                .getStackTrace();
        int currentIndex = -1;
        for (int i = 0; i < stackTraceElement.length; i++) {
            if (stackTraceElement[i].getMethodName().compareTo("d") == 0) {
                currentIndex = i + 1;
                break;
            }
        }

        String fullClassName = stackTraceElement[currentIndex].getClassName();
        String className = fullClassName.substring(fullClassName
                .lastIndexOf(".") + 1);
        String methodName = stackTraceElement[currentIndex].getMethodName();
        String lineNumber = String
                .valueOf(stackTraceElement[currentIndex].getLineNumber());

        Log.d(tag, msg + "\tat " + fullClassName + "." + methodName + "("
                + className + ".java:" + lineNumber + ")");

        //Log.d(tag, msg + "\t" + "("+ className + ".java:" + lineNumber + ")");

    }

    /**
     * d - DEBUG log with the location of where it was called and the line number as the tag
     * @param msg The message
     */
    public static void d(String msg) {
        StackTraceElement[] stackTraceElement = Thread.currentThread()
                .getStackTrace();
        int currentIndex = -1;
        for (int i = 0; i < stackTraceElement.length; i++) {
            if (stackTraceElement[i].getMethodName().compareTo("d") == 0) {
                currentIndex = i + 1;
                break;
            }
        }

        String fullClassName = stackTraceElement[currentIndex].getClassName();
        String className = fullClassName.substring(fullClassName
                .lastIndexOf(".") + 1);
        String methodName = stackTraceElement[currentIndex].getMethodName();
        String lineNumber = String
                .valueOf(stackTraceElement[currentIndex].getLineNumber());

        Log.d("Line_"+lineNumber, msg + "\tat " + fullClassName + "." + methodName + "("
                + className + ".java:" + lineNumber + ")");
    }

}