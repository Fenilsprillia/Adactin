package org.page;

import org.base.Baseclassjunit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Bookingconfirm extends Baseclassjunit {
	public Bookingconfirm() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//table[@class='content']/tbody/tr[2]/td/form/table/tbody/tr[19]/td[2]/input[@id='my_itinerary']")
    private WebElement myltineray;
	public WebElement getMyltineray() {
		return myltineray;
	}
	@FindBy(xpath="//table[@class='content']/tbody/tr[2]/td/form/table/tbody/tr[2]/td/table/tbody/tr[2]/td/input")
	private WebElement selecancel;
	public WebElement getSelecancel() {
		return selecancel;
	}
	@FindBy(xpath="//table[@class='content']/tbody/tr[2]/td/form/table/tbody/tr[3]/td/input")
	private WebElement cancel;
	public WebElement getCancel() {
		return cancel;
	}
	@FindBy(xpath="//table[@class='content']/tbody/tr[2]/td/form/table/tbody/tr[3]/td/input[@id='logout']")
	private WebElement logout;
	public WebElement getLogout() {
		return logout;
	}
}
