package org.utils;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

import static org.config.ConfigurationManager.config;

public enum BrowserFactory {

    CHROMIUM {
        @Override
        public Browser createInstance(final Playwright playwright){
            return playwright.chromium().launch(options());
        }
    },
    FIREFOX {
        @Override
        public Browser createInstance(final Playwright playwright) {
            return playwright.firefox().launch(options());
        }
    },
    WEBKIT {
        @Override
        public Browser createInstance(final Playwright playwright) {
            return playwright.webkit().launch(options());
        }
    };

    public abstract Browser createInstance (final Playwright playwright);

    public BrowserType.LaunchOptions options(){
        return (new BrowserType.LaunchOptions()).setHeadless(config().headless()).setSlowMo(config().slowMotion());
    }

}
