package org.example;

import com.microsoft.playwright.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try (Playwright playwright = Playwright.create()) {
            BrowserType chromium = playwright.chromium();

            //Browser browser = chromium.launch();
            Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(100));

            Page page = browser.newPage();
            page.navigate("http://dzen.ru");
            // other actions...
            browser.close();

            playwright.close();             // remove redundant close
        }

        //System.out.println( "Hello World!" );


    }
}
