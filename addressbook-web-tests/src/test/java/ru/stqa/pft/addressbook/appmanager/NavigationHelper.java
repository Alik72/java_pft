package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Homosapiens on 03.05.2016.
 */
public class NavigationHelper extends HelperBase{


  public NavigationHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void gotoContactPage() {
    click(By.linkText("home"));

  }
}
