package org.example.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.example.pages.DictionaryPageWebsite;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class EndUserWebsite {
    DictionaryPageWebsite dictionaryPageWebsite;
    @Step
    public void enters(String keyword) {
        dictionaryPageWebsite.enter_keywords(keyword);
    }

    @Step
    public void enterEmail(String email){
        dictionaryPageWebsite.enter_email(email);
    }
    @Step
    public void should_enter_new_page(String nr_card){
        System.out.println(dictionaryPageWebsite.getAfterClick());
        System.out.println(nr_card);
        assertThat(dictionaryPageWebsite.getAfterClick(),hasItem(containsString(nr_card)));

    }

    @Step
    public void doneazaPrimulButon(){
        dictionaryPageWebsite.doneaza();
    }

    @Step
    public void doneazaAlDoileaButon(){
        dictionaryPageWebsite.butonDoneaza();
    }
    @Step
    public void starts_search() {
        dictionaryPageWebsite.lookup_terms();
    }

    @Step
    public void should_see_definition(String definition) {
        System.out.println(dictionaryPageWebsite.getDefinitions());
        System.out.println(definition);
        List<String> def= dictionaryPageWebsite.getDefinitions();

        assertThat(def, hasItem(containsString(definition)));
    }

    @Step
    public void is_the_home_page() {
        dictionaryPageWebsite.open();
    }

    @Step
    public void donam(String email){
        doneazaPrimulButon();
        enterEmail(email);
        doneazaAlDoileaButon();

    }

    @Step
    public void looks_for(String term) {
        enters(term);
        starts_search();
    }
}
