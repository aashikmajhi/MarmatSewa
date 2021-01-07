package com.example.marmatsewa.BDD.tests;

import cucumber.api.CucumberOptions;

@CucumberOptions
        (features = "features",
                glue = "com.sniper.bdd.cucumber.steps",
                tags = "@SmokeTest")
@SuppressWarnings("unused")
public class CucumberTestCase {

}
