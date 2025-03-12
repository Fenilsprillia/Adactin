package org.execute;

import org.base.Baseclassjunit;
import org.junit.*;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.page.Bookingconfirm;
import org.page.Loginpage;
import org.page.Searchhotel;
import org.page.SelectHotel;

public class Testmain extends Baseclassjunit {
	public static Baseclassjunit baseclass = new Baseclassjunit();

	@BeforeClass
	public static void login() {
		baseclass.launch();
		baseclass.website("https://adactinhotelapp.com/index.php");
		baseclass.maxim();
		Loginpage page = new Loginpage();
		baseclass.sendkeysByJava(page.getUserid(), "fenilastro");
		baseclass.sendkeysByJava(page.getPassword(), "N43ZW0");
		baseclass.click(page.getLogin());
		
		System.out.println("github dev sucessful");
		System.out.println("next qa want to work");
		
	}

	@Before
	public void search() {
		Searchhotel searchpage = new Searchhotel();
		baseclass.required(searchpage.getLocation(), "value", "Sydney");
		baseclass.required(searchpage.getHotel(), "text", "Hotel Creek");
		baseclass.required(searchpage.getRoomtype(), "value", "Deluxe");
		baseclass.required(searchpage.getRoom_nos(), "text", "3 - Three");
		baseclass.required(searchpage.getAdult_room(), "value", "4");
		baseclass.required(searchpage.getChild_room(), "text", "1 - One");
		baseclass.sendkeysByJava(searchpage.getDatepick_in(), "23/03/2025");
		baseclass.sendkeysByJava(searchpage.getDatepick_out(), "28/03/2025");
		baseclass.sleep(2000);
		baseclass.click(searchpage.getSearch());

	}

	@Test
	public void select() {
		SelectHotel sh = new SelectHotel();
		baseclass.click(sh.getRadio());
		baseclass.sleep(3000);
		baseclass.click(sh.getCont());
		baseclass.sendkeysByJava(sh.getFirstname(), "fenil");
		baseclass.sendkeysByJava(sh.getLastname(), "sprillia");
		baseclass.sleep(2000);
		baseclass.sendkeysByJava(sh.getAddress(), "31,3rd street,Duraisamypuram,palakrari,Trichy-620001");
		baseclass.sendkeysByJava(sh.getCcnum(), "1234123443211234");
		baseclass.required(sh.getCtype(), "value", "MAST");
		baseclass.required(sh.getExpmonth(), "value", "3");
		baseclass.required(sh.getExpyear(), "text", "2027");
		baseclass.sendkeysByJava(sh.getCvv(), "834");
		baseclass.sleep(2000);
		baseclass.click(sh.getBooknow());
		baseclass.sleep(3000);

	}

	@AfterClass
	public static void bookingconfirmation() {
		Bookingconfirm bc = new Bookingconfirm();
		baseclass.sleep(10000);
		baseclass.click(bc.getMyltineray());
		baseclass.click(bc.getSelecancel());
		baseclass.click(bc.getCancel());
		baseclass.sleep(2000);
		baseclass.confirmalert("ok");
		baseclass.click(bc.getLogout());

	}
}