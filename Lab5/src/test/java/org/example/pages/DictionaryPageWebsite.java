package org.example.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.List;
import java.util.stream.Collectors;


@DefaultUrl("https://dexonline.ro")
public class DictionaryPageWebsite extends PageObject {
    @FindBy(id="searchField")
    private WebElementFacade searchTerms;

    @FindBy(id="searchButton")
    private WebElementFacade lookupButton;

    @FindBy(tagName = "a")
    private WebElementFacade doneaza;

    @FindBy(id="donateOnlineEmail")
    private WebElementFacade emailInput;

    @FindBy(name = "Doneaza")
    private WebElementFacade buttonDoneaza;


    public void doneaza(){
        doneaza.click();
    }

    public void enter_email(String email){
        emailInput.type(email);
    }

    public void butonDoneaza(){
        buttonDoneaza.click();
    }


    public void enter_keywords(String keyword) {
        searchTerms.type(keyword);
    }

    public void lookup_terms() {
        lookupButton.click();
    }

    public List<String> getDefinitions() {
        WebElementFacade definitionList = find(By.tagName("div"));
        return definitionList.findElements(By.tagName("span")).stream()
                .map( element -> element.getText() )
                .collect(Collectors.toList());
    }

    public List<String> getAfterClick(){
        WebElementFacade definitionList = find(By.name("frm"));
        return definitionList.findElements(By.tagName("label")).stream()
                .map( element -> element.getText() )
                .collect(Collectors.toList());
    }


}
