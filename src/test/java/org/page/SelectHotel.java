package org.page;

import org.base.Baseclassjunit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotel extends Baseclassjunit {
	public SelectHotel() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//table[@class='content']/tbody/tr[2]//table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]/input")
    private WebElement radio;
	public WebElement getRadio() {
		return radio;
	}
	@FindBy(xpath="//table[@class='content']/tbody/tr[2]//table/tbody/tr[3]/td/input[@id='continue']")
	private WebElement cont;
	public WebElement getCont() {
		return cont;
	}
	@FindBy(xpath="//table[@class='content']/tbody/tr[2]/td/form/table/tbody/tr[12]/td[2]/input")
	private WebElement firstname;
	public WebElement getFirstname() {
		return firstname;
	}
	@FindBy(xpath="//table[@class='content']/tbody/tr[2]/td/form/table/tbody/tr[13]/td[2]/input")
	private WebElement lastname;
	public WebElement getLastname() {
		return lastname;
	}
	@FindBy(xpath="//table[@class='content']/tbody/tr[2]/td/form/table/tbody/tr[14]/td[2]/textarea")
	private WebElement address;
	public WebElement getAddress() {
		return address;
	}
	@FindBy(xpath="//table[@class='content']/tbody/tr[2]/td/form/table/tbody/tr[15]/td[2]/input")
	private WebElement ccnum;
	public WebElement getCcnum() {
		return ccnum;
	}
	@FindBy(xpath="//table[@class='content']/tbody/tr[2]/td/form/table/tbody/tr[16]/td[2]/select")
	private WebElement ctype;
	public WebElement getCtype() {
		return ctype;
	}
	@FindBy(xpath="//table[@class='content']/tbody/tr[2]/td/form/table/tbody/tr[17]/td[2]/select")
	private WebElement expmonth;
	public WebElement getExpmonth() {
		return expmonth;
	}
	@FindBy(xpath="//table[@class='content']/tbody/tr[2]/td/form/table/tbody/tr[17]/td[2]/select[2]")
	private WebElement expyear;
	public WebElement getExpyear() {
		return expyear;
	}
	@FindBy(xpath="//table[@class='content']/tbody/tr[2]/td/form/table/tbody/tr[18]/td[2]/input")
	private WebElement cvv;
	public WebElement getCvv() {
		return cvv;
	}
	@FindBy(xpath="//table[@class='content']/tbody/tr[2]/td/form/table/tbody/tr[19]/td[2]/input")
	private WebElement booknow;
	public WebElement getBooknow() {
		return booknow;
	}
}
