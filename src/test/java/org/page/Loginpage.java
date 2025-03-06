package org.page;

import org.base.Baseclassjunit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class Loginpage extends Baseclassjunit {
	public Loginpage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='username']")
	private WebElement userid;

	public WebElement getUserid() {
		return userid;
	}

	@FindBy(xpath = "//input[@id='password']")
	private WebElement password;

	public WebElement getPassword() {
		return password;
	}

	@FindBy(xpath = "//input[@class='login_button']")
	private WebElement login;

	public WebElement getLogin() {
		return login;
	}

}
