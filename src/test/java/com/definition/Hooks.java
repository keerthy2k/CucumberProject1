package com.definition;


import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.baseclass.BaseClass;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;

public class Hooks extends BaseClass
{

	

	@After
	private void afterScenario(Scenario sc) {
	TakesScreenshot tk=(TakesScreenshot)driver;
	byte[] b = tk.getScreenshotAs(OutputType.BYTES);
	sc.embed(b, "image/png");
	}
	
	private void as1() throws IOException {	
	TakesScreenshot tk1=(TakesScreenshot)driver;
	File src = tk1.getScreenshotAs(OutputType.FILE);
	File dest=new File("E:\\");
	FileHandler.copy(src, dest);
	
	}
	
	@Override
	public void quitBrowser() {
		// TODO Auto-generated method stub
		super.quitBrowser();
	}

	
	
}
