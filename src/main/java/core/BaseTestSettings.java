package core;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTestSettings {

    @BeforeClass
    public void init() {
        Driver.init();
    }

    @AfterClass
    public void cleanup() {
        Driver.tearDown();
    }

}
