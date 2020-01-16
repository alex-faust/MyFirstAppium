package com.platform.project.steps;

import com.platform.project.commons.TestContext;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks
{
    TestContext testContext;

    public Hooks(TestContext context)
    {
        testContext = context;
    }

    @Before
    public void BeforeSteps() {}

    @After
    public void AfterSteps()
    {
        testContext.getAppiumDriverManager().closeDriver();
    }
}
