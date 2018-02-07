package web.id.gosoft.automation.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import web.id.gosoft.automation.tasks.OpenBlibli;
import web.id.gosoft.automation.tasks.SearchProduct;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.CoreMatchers.containsString;

@RunWith(SerenityRunner.class)
public class ArgoSearchComputerInBlibli {
    Actor argo = Actor.named("argo");
    @Managed(uniqueSession = true)
    public WebDriver firefox;

    @Steps
    SearchProduct searchProduct;

    @Steps
    OpenBlibli openBlibli;

    @Before
    public void argoCanOpenBrowserPage() {
        argo.can(BrowseTheWeb.with(firefox));
    }

    @Test
    public void argoSearchMobil() {
        givenThat(argo).wasAbleTo(openBlibli);
        when(argo).attemptsTo(searchProduct.forTerms("mobil"));
        then(argo).should(seeThat(searchProduct.searchResult(), (Question<String>)containsString("Mobil")));
    }

}
