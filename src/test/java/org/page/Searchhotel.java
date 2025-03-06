package org.page;

import org.base.Baseclassjunit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Searchhotel extends Baseclassjunit{
	public Searchhotel() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.NAME,using="location")
	private WebElement location;
	public WebElement getLocation() {
		return location;
	}
	@FindBy(id="hotels")
	private WebElement hotel;
	public WebElement getHotel() {
		return hotel;
	}
	@FindBy(name="room_type")
	private WebElement roomtype;
	public WebElement getRoomtype() {
		return roomtype;
	}
	@FindBy(id="room_nos")
	private WebElement room_nos;
	public WebElement getRoom_nos() {
		return room_nos;
	}
	@FindBy(name="adult_room")
	private WebElement adult_room;
	public WebElement getAdult_room() {
		return adult_room;
	}
	@FindBy(id="child_room")
	private WebElement child_room;
	public WebElement getChild_room() {
		return child_room;
	}
	@FindBy(name="datepick_in")
	private WebElement datepick_in;
	public WebElement getDatepick_in() {
		return datepick_in;
	}
	@FindBy(name="datepick_out")
	private WebElement datepick_out;
	public WebElement getDatepick_out() {
		return datepick_out;
	}
	@FindBy(id="Submit")
	private WebElement search;
	public WebElement getSearch() {
		return search;
	}
	

}
