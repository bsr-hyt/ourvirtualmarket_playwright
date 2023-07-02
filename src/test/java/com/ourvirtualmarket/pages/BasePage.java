package com.ourvirtualmarket.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.ElementHandle;

    public abstract class BasePage {
        protected Page page;

        public BasePage(Page page) {
            this.page = page;
        }



}
