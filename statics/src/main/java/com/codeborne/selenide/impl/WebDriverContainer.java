package com.codeborne.selenide.impl;

import com.codeborne.selenide.DownloadsFolder;
import com.codeborne.selenide.proxy.SelenideProxyServer;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.WebDriverListener;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public interface WebDriverContainer {
  void addListener(WebDriverListener listener);
  void removeListener(WebDriverListener listener);
  void setWebDriver(WebDriver webDriver);
  void setWebDriver(WebDriver webDriver, @Nullable SelenideProxyServer selenideProxy);
  void setWebDriver(WebDriver webDriver, @Nullable SelenideProxyServer selenideProxy, DownloadsFolder browserDownloadsFolder);

  /**
   * @deprecated This method is intended only for private usage.
   * Use method {@link #using(WebDriver, SelenideProxyServer, DownloadsFolder, Runnable)} instead.
   */
  @Deprecated
  void resetWebDriver();

  @CheckReturnValue
  @Nonnull
  WebDriver getWebDriver();

  @CheckReturnValue
  @Nonnull
  SelenideProxyServer getProxyServer();

  void setProxy(@Nullable Proxy webProxy);

  @CheckReturnValue
  @Nonnull
  WebDriver getAndCheckWebDriver();

  @CheckReturnValue
  @Nullable
  DownloadsFolder getBrowserDownloadsFolder();

  void closeWindow();
  void closeWebDriver();
  boolean hasWebDriverStarted();

  void using(WebDriver driver, @Nullable SelenideProxyServer proxy, @Nullable DownloadsFolder downloadsFolder, Runnable lambda);
  void inNewBrowser(Runnable lambda);

  void clearBrowserCache();

  @CheckReturnValue
  @Nonnull
  String getPageSource();

  @CheckReturnValue
  @Nonnull
  String getCurrentUrl();

  @CheckReturnValue
  @Nonnull
  String getCurrentFrameUrl();
}
