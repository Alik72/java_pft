package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by Homosapiens on 03.05.2016.
 */
public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification(){
    app.getNavigationHelper().gotoContactPage();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Sadvakasov", "Arman", "Serikovich", "as"));
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoContactPage();

  }
}
