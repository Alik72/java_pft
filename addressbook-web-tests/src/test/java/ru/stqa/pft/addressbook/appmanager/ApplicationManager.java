package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

/**
 * Created by Homosapiens on 01.05.2016.
 */
public class ApplicationManager {
  FirefoxDriver wd;
  private boolean acceptNextAlert = true;

  public static boolean isAlertPresent(FirefoxDriver wd) {
      try {
          wd.switchTo().alert();
          return true;
      } catch (NoAlertPresentException e) {
          return false;
      }
  }

  public boolean isElementPresent(By by) {
      try {
          wd.findElement(by);
          return true;
      } catch (NoSuchElementException e) {
          return false;
      }
  }

  public void init() {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/");
    login("admin", "secret");
  }

  public void login(String username, String password) {
      wd.findElement(By.name("user")).click();
      wd.findElement(By.name("user")).clear();
      wd.findElement(By.name("user")).sendKeys(username);
      wd.findElement(By.name("pass")).click();
      wd.findElement(By.name("pass")).clear();
      wd.findElement(By.name("pass")).sendKeys(password);
      wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
  }

  public void submitContactCreation() {
      wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  public void fillContactForm(ContactData contactData) {
      wd.findElement(By.name("lastname")).click();
      wd.findElement(By.name("lastname")).clear();
      wd.findElement(By.name("lastname")).sendKeys(contactData.getLastname());
      wd.findElement(By.name("firstname")).click();
      wd.findElement(By.name("firstname")).clear();
      wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstname());
      wd.findElement(By.name("middlename")).click();
      wd.findElement(By.name("middlename")).clear();
      wd.findElement(By.name("middlename")).sendKeys(contactData.getMiddlename());
      wd.findElement(By.name("nickname")).click();
      wd.findElement(By.name("nickname")).clear();
      wd.findElement(By.name("nickname")).sendKeys(contactData.getNickname());
  }

  public void initContactCreation() {
      wd.findElement(By.linkText("add new")).click();
  }

  public void gotoContactPage() {
      wd.findElement(By.linkText("home")).click();
  }

  public void stop() {
    wd.quit();
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
      wd.findElement(By.xpath("//div[@id='content']/form[2]/div[2]/input")).click();
      assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
  }

  public void selectContact() {
      wd.findElement(By.name("selected[]")).click();
  }
}
