package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		
		features= {".//Features/login.feature"},
		features= {"@target/rerun.txt"},
		glue="stepDefinations";
//it is used to generate report		
		plugin= {"pretty","html:reports/myreport.html",
			"rerun:target/rerun.txt",
				
		},
		
	dryRun=false;//checks mapping between scenario steps and step defination methods
	monochrome=true;//to avooid junk character in op
	publish=true//to publish report in cucumber server
	tags="@sanity"	
	//tags="@sanity and not @regression"	
		
		
		)














public class TestRun {

}
