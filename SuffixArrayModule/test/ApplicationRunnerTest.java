import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Sidhavratha on 30/3/14.
 */
public class ApplicationRunnerTest
{

    @Test
    public void testStartApp() throws InterruptedException {
        ApplicationRunner runner = new ApplicationRunner();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        runner.startApp(MockApp.class);
        Thread.sleep(100);
        Assert.assertEquals("Hello",outputStream.toString().trim());
    }

    @Test
    public void testHasDisplayed()
    {
        ApplicationRunner runner = new ApplicationRunner();
        runner.startApp(MockApp.class);
        runner.hasDisplayed("Hello");
    }

    @Test(expected = AssertionError.class)
    public void testHasDisplayedError()
    {
        ApplicationRunner runner = new ApplicationRunner();
        runner.startApp(MockApp.class);
        runner.hasDisplayed("Bye");
    }

    @Test
    public void testUserEnters() throws InterruptedException {
        ApplicationRunner runner = new ApplicationRunner();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        runner.startApp(MockAppUserEntersTest.class);
        runner.userEnters("Hello app");
        Thread.sleep(100);
        Assert.assertEquals("Found text : Hello app",outputStream.toString().trim());
    }

    public static class MockApp
    {
        public static void main(String args[])
        {
            System.out.println("Hello");
        }
    }

    public static class MockAppUserEntersTest
    {
        public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            System.out.println("Found text : "+s);
        }
    }
}
