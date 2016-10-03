package uiLayer;

import core.Driver;
import org.openqa.selenium.support.PageFactory;


public abstract class PageFactorySettings {

    public PageFactorySettings() {
        PageFactory.initElements(Driver.get(), this);}

}
