package org.example.features.search;


import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.example.steps.serenity.EndUserSteps;
import org.example.steps.serenity.EndUserWebsite;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/UbbTestData.csv")
public class SearchOnWebsite {
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "https://dexonline.ro")
    public Pages pages;

    public String name;
    public String definition;
    public String email="korodiandreea@yahoo.com";
    public String nr_card="Numărul de card";

    public String getNr_card() {
        return nr_card;
    }

    public void setNr_card(String nr_card) {
        this.nr_card = nr_card;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Qualifier
    public String getQualifier() {
        return name;
    }
//    @Qualifier
//    public String getQualifier

    @Steps
    public EndUserWebsite endUser;


    @Issue("#dex")
    @Test
    public void searchUbbByKeywordTestDDT() {
        endUser.is_the_home_page();
        endUser.looks_for(getName());
        endUser.should_see_definition(getDefinition());
    }
    @Test
    public void searchDoneaza(){
        endUser.is_the_home_page();
        endUser.donam(getEmail());
        endUser.should_enter_new_page(getNr_card());

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

}
