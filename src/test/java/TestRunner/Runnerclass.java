package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import static Common.Utils.*;
@RunWith(Cucumber.class)
@CucumberOptions(
        features ="",glue = "",dryRun = true,plugin = {""}
)
public class Runnerclass {
    @BeforeClass
    public static void start(){
        browserLaunch();
        url("");

    }    @AfterClass
    public static void stop(){
        close();

    }



}
