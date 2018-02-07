package web.id.gosoft.automation.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.*;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("blibli.com")
public class BlibliPage extends PageObject{
    public static Target SEARCH_FIELD = Target.the("Product Field").located(By.name("s"));
}
