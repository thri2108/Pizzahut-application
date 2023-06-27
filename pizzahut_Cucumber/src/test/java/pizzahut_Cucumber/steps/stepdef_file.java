package pizzahut_Cucumber.steps;


import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pizzahut_Cucumber.page_objects.page_object_model;

public class stepdef_file extends page_object_model{
	 public WebDriver driver;

	page_object_model ele = new page_object_model();
	
	@Given("User launch Pizzahut application")
	public void user_launch_pizzahut_application_with() {
	    ele.openbrowser();  
	}
	@Then("User type address")
	public void user_type_address_as() {
		try {
			ele.location();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	   
	}
	@Then("User select first auto populate drop down option")
	public void user_select_first_auto_populate_drop_down_option() throws InterruptedException {
		ele.selectfirstoption();	  	    
	}
	@When("User navigate to deals page")
	public void user_navigate_to_deals_page() {
		ele.Actualtitle();   
	}
	@Then("User validate vegetarian radio button flag is off")
	public void user_validate_vegetarian_radio_button_flag_is_off() {
		ele.clickradiobtn();
		System.out.println("Vegetarian button is Off");   
	}
	@Then("User clicks on Pizzas menu bar option")
	public void user_clicks_on_pizzas_menu_bar_option() {
	  ele.navtoPizza();
	}
	@When("User select add button of any pizza from Recommended")
	public void user_select_add_button_of_any_pizza_from_recommended() {
		ele.addpizza();
	}
	@Then("User see that the pizza is getting added under Your Basket")
	public void user_see_that_the_pizza_is_getting_added_under_your_basket() {
		ele.validatebasket();
	}	
	@And("User validate pizza price plus Tax is checkout price")
	public void user_validate_pizza_price_plus_tax_is_checkout_price() {	
		ele.checkoutprice();
	}
	@Then("User validate checkout button contains Item count")
	public void user_validate_checkout_button_contains_item_count() {	
		ele.itemcount();
	}
	
	@Then("User clicks on Drinks option")
	public void user_clicks_on_drinks_option() {
		ele.drinkspage();
	   
	}
	@And("User select Pepsi option to add into the Basket")
	public void user_select_pepsi_option_to_add_into_the_basket() {
		ele.adddrinks();
	   
	}
	@Then("User see {int} items are showing under checkout button")
	public void user_see_items_are_showing_under_checkout_button(Integer int1) {
		ele.itemcount2();
	   
	}
	@And("User see total price is now more than before")
	public void user_see_total_price_is_now_more_than_before()  {
	   try {
		ele.price();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}	
	
	@Then("User remove the Pizza item from Basket")
	public void user_remove_the_pizza_item_from_basket() {
		ele.removeitems();
	}
	
	@And("see Price tag got removed from the checkout button")
	public void see_price_tag_got_removed_from_the_checkout_button() {
		
	   ele.cartPrice();
	}
	
	@And("User see {int} item showing in checkout button")
	public void user_see_item_showing_in_checkout_button(Integer int1) {
		ele.newcartitem();
	   
	}
	@Then("User Clicks on Checkout button")
	public void user_clicks_on_checkout_button() {
	    ele.checkout();
	}

	@And("User see minimum order required pop up is getting displayed")
	public void user_see_minimum_order_required_pop_up_is_getting_displayed() {
	 ele.pop_up();	
	}
	
	@Then("User closes the Browser")
	public void user_closed_the_browser() {
		ele.closebrowser();
	}
	
	
}


