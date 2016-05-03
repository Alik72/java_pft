package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation() {

        app.gotoContactPage();
        app.initContactCreation();
        app.fillContactForm(new ContactData("Sadvakasov", "Arman", "Serikovich", "as"));
        app.submitContactCreation();
        app.gotoContactPage();
    }

}
