package Stepfiles;

import Common.Utils;
import Pages.LoginPage;
import Readers.ConfigReader;
import io.cucumber.java.en.Given;

public class LoginStep extends Utils {
    LoginPage login=new LoginPage();
    @Given(": User navigate to url")
    public void user_navigate_to_url() {
        System.out.println(ConfigReader.getProp("url"));
        url(ConfigReader.getProp("url"));


    }

}
