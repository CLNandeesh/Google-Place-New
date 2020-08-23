package stepdefnitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import setup.BaseClass;

public class Hooks extends BaseClass {

	@Before
	public void beforeScenario(Scenario scenario) {
		logger.info(scenario.getName() + " started execution ");

	}

	@After
	public void afterScenario(Scenario scenario) {
		logger.info(scenario.getName() + " finished execution and the status is: " + scenario.getStatus());

	}

}
