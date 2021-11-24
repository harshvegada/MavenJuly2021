package com.technocredits.orghrm.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.technocredits.orghrm.base.PredefinedActions;

public class DashboardPage extends PredefinedActions{
	
	public String getPageHeaderTile() {
		return getPageTitle();
	}
	
	public String getPageTitle() {
		WebElement element = getElement("XPATH", "//li[@class='page-title']", false);
		return getElementText(element);
	}
	
	public int getTotalWidgets() {
		//return driver.findElements(By.xpath("//div[@id='widget.id']")).size();
		return getElements("XPATH", "//div[@id='widget.id']", false).size();
	}
	
	public List<String> getAllWidgetsText(){
		/*List<WebElement> widgetsListElements = driver.findElements(By.xpath("//div[@class='widget-header']/span[2]"));
		List<String> widgetsList = new ArrayList<String>();
		
		for(WebElement widgetElement : widgetsListElements) {
			widgetsList.add(widgetElement.getText());
		}
		return widgetsList;*/
		return getTextOfAllElements("XPATH","//div[@class='widget-header']/span[2]",false);
	}
	
	public String getWidgetTextBasedOnIndex(int index){
		List<String> widgetsList = getAllWidgetsText();
		return widgetsList.get(index);
	}
	
}
