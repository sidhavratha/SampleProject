import sun.launcher.resources.launcher_sv;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by Sidhavratha on 29/3/14.
 */
public class ApplicationRunner {

    private PipedOutputStream pipedOutputStream;
    private PipedInputStream pipedInputStream;
    private ByteArrayOutputStream outputStream;
    private int lastSize;


    public ApplicationRunner(){
        pipedOutputStream = new PipedOutputStream();
        try {
            pipedInputStream = new PipedInputStream(pipedOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.setIn(pipedInputStream);

        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    public void startApp(final Class classToInvokeMain) {

        Thread thread = new Thread("Test Application"){
            @Override public void run(){
                Class<?> cls = classToInvokeMain;
                Method meth = null;
                try {
                    meth = cls.getMethod("main", String[].class);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
                String[] params = null;
                try {
                    meth.invoke(null, (Object) params);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                //PrintCommand.main(null);
            }
        };
        thread.setDaemon(true);
        thread.start();
    }

    public void hasDisplayed(String text) {
        int tries = 20;
        String found = null;
        while(tries>0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String console = outputStream.toString();
            if(console.length()>lastSize)
            {
                found = console.substring(lastSize);
                lastSize = console.length();
                break;
            }
            tries--;
        }
        if (found==null || !found.trim().equals(text.trim())){
            throw new AssertionError("Missing text in output: ##" + text+ "## Instead found ##"+ found+"##");
        }
    }

    public void userEnters(String userInput) {
        try {
            pipedOutputStream.write(userInput.concat("\n").getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}