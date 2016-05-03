package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation() {

        app.getNavigationHelper().gotoContactPage();
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new ContactData("Sadvakasov", "Arman", "Serikovich", "as"));
        app.getContactHelper().submitContactCreation();
        app.getNavigationHelper().gotoContactPage();
    }

}
