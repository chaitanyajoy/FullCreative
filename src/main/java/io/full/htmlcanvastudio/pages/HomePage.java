package io.full.htmlcanvastudio.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import io.full.htmlcanvastudio.exceptions.DrawNotPerfomedException;
import io.full.htmlcanvastudio.exceptions.EraseNotPerformedException;

public class HomePage {

	WebDriver driver;
	Actions action;
	public static final By canvasArea = By.cssSelector("canvas#imageTemp");
	public static final By pencilIcon = By.cssSelector("input.pencil");
	public static final By lineIcon = By.cssSelector("input.line");
	public static final By rectangleIcon = By.cssSelector("input.rectangle");
	public static final By eraserIcon = By.cssSelector("input.eraser");

	public HomePage(WebDriver driver) {
		this.driver = driver;
		initActions();
	}

	public void initActions() {
		this.action = new Actions(driver);
	}

	public void clickLineIcon() {
		driver.findElement(this.lineIcon).click();
	}

	public void clickPencilIcon() {
		driver.findElement(this.pencilIcon).click();
	}

	public void clickRectangleIcon() {
		driver.findElement(this.rectangleIcon).click();
	}

	public void clickEraserIcon() {
		driver.findElement(this.eraserIcon).click();
	}

	public void drawShape(int fromX, int fromY, int toX, int toY, String... logComment) {
		try {
			action.moveToElement(driver.findElement(this.canvasArea), fromX, fromY)
			.clickAndHold()
			.moveByOffset(toX, toY)
			.click()
			.build()
			.perform();
		}catch(Exception e) {
			throw new DrawNotPerfomedException();
		}
	}

	// skip co-ordinates feature can be added
	public void eraseShape(int fromX, int fromY, int toX, int toY, String... logComment) {
		try {
			action.moveToElement(driver.findElement(this.canvasArea), fromX, fromY)
			.clickAndHold()
			.moveByOffset(toX, toY)
			.click()
			.build()
			.perform();
		}catch(Exception e) {
			throw new EraseNotPerformedException();
		}
	}
}
