package web.id.gosoft.automation.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import web.id.gosoft.automation.ui.BlibliPage;

public class OpenBlibli implements Task {
    BlibliPage blibliPage;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(blibliPage)
        );
    }
}
