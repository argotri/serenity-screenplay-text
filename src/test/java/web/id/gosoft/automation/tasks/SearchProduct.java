package web.id.gosoft.automation.tasks;

import net.bytebuddy.asm.Advice;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;
import web.id.gosoft.automation.ui.BlibliPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.openqa.selenium.Keys.ENTER;

public class SearchProduct implements Task {

    private String productTerms;

    protected SearchProduct(String productTerms) {
        this.productTerms = productTerms;
    }

    public static SearchProduct forTerms(String productTerms) {
        return instrumented(SearchProduct.class,productTerms);
    }

    @Step("Search for #searchterms")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(productTerms).into(BlibliPage.SEARCH_FIELD).thenHit(ENTER)
        );
    }

    public String searchResult() {
        return "";
    }
}
