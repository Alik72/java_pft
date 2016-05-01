package ru.stqa.pft.addressbook;

public class ContactData {
  private final String lastname;
  private final String firstname;
  private final String middlename;
  private final String nickname;

  public ContactData(String lastname, String firstname, String middlename, String nickname) {
    this.lastname = lastname;
    this.firstname = firstname;
    this.middlename = middlename;
    this.nickname = nickname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getNickname() {
    return nickname;
  }
}
