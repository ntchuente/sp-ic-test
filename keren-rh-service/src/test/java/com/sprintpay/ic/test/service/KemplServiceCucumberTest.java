package com.sprintpay.ic.test.service;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class) 
@CucumberOptions(plugin= { "pretty",
		"html:target/cucumber-pretty","json:target/cucumber.json" } ,
features= {"src/test/resources"} , glue="com.sprintpay.ic.test.service.test"
		)
public class KemplServiceCucumberTest {

}
