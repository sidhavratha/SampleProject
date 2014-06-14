import org.junit.Test;

/**
 * Created by Sidhavratha on 29/3/14.
 */
public class CommandTest {

    @Test
    public void testAdd() throws InterruptedException {
        ApplicationRunner runner = new ApplicationRunner() ;
        runner.startApp(PrintCommand.class);
        runner.hasDisplayed("Choose among options : \n 1. Add \n 2. Substract");
        runner.userEnters("1");
        runner.hasDisplayed("Input two digits to add");
        runner.userEnters("1 2");
        runner.hasDisplayed("3");
    }

    @Test
    public void testSubstract() throws InterruptedException {
        ApplicationRunner runner = new ApplicationRunner() ;
        runner.startApp(PrintCommand.class);
        runner.hasDisplayed("Choose among options : \n 1. Add \n 2. Substract");
        runner.userEnters("2");
        runner.hasDisplayed("Input two digits to substract");
        runner.userEnters("5 1");
        runner.hasDisplayed("4");
    }

}
