package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.testng.Assert.assertTrue;

/**
 * Created by Homosapiens on 03.05.2016.
 */
public class ContactHelper extends HelperBase{

  private boolean acceptNextAlert = true;

  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("middlename"), contactData.getMiddlename());
    type(By.name("nickname"), contactData.getNickname());
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public String closeAlertAndGetItsText() {
      try {
          Alert alert = wd.switchTo().alert();
          String alertText = alert.getText();
          if (acceptNextAlert) {
              alert.accept();
          } else {
              alert.dismiss();
          }
          return alertText;
      } finally {
          acceptNextAlert = true;
      }
  }

  public void deleteSelectedContacts() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
  }

  public void selectContact() {
    click(By.name("selected[]"));
  }

  public void initContactModification() {
    click(By.cssSelector("img[alt=\"Edit\"]"));


  }

  public void submitContactModification() {
    click(By.cssSelector("input[value=\"Update\"]"));
    //click(By.xpath("//input[22]"));// тот же локатор только на xpath

  }
}
