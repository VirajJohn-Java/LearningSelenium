package stepDefinitions;

import io.cucumber.core.gherkin.Feature;
import io.cucumber.core.gherkin.Step;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.plugin.event.StepDefinedEvent;
import org.testng.annotations.BeforeTest;

public class CucumberListener  {


   @Before
    public  void BeforeTest(Scenario scenario)
   {
       System.out.println("" + scenario.getName());
   }

   





   //@AfterStep




}
