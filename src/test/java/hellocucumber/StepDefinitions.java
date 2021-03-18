package hellocucumber;

import hellocucumber.annotation.Group;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.CucumberOptions;

import static org.junit.Assert.*;

public class StepDefinitions {

    private String today;
    private String actualAnswer;


    @Group(id="someid")
    @Given("today is Sunday")
    public void today_is_Sunday() {
        today = "Sunday";
    }

    @Group(id="someid")
    @When("I ask whether it's Friday yet")
    public void i_ask_whether_it_s_Friday_yet() {
        actualAnswer = IsItFriday.isItFriday(today);
    }

    @Group(id="someid_1")
    @Then("I should be told {string}")
    public void i_should_be_told(String expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswer);
    }


}

class IsItFriday {
    static String isItFriday(String today) {
        return "Nope";
    }
}
