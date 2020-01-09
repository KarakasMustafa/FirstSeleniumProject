package tests.day11;

public class Synchronization {
    /*

    Waits in Selenium:
        Implicit, Explicit, Fluent
    If selenium is coming before element appear - you will get NoSuchElementException Error

    Synchronization is one of the biggest issues in selenium WebDriver. Selenium doesnt adjust automatically. To overcome these
    issues, we used to use Thread.sleep(2000)

    What is the solution for that?
        Thread.sleep(2000) will stop your test script, no matter element is available or no for fixed amount of the time

      Thread.sleep(20000) let's say we put on pause our test for 20 sec. Even if element was available after 3 sec, still the scripts will be
      on hold for 20 sec. We are increasing execution time, thus we are losing money.


        ImplicitWait  -- will help to wait for appearance of element, within given time-frame.
      let's say you specified implicit wait time 10 seconds, and if element was found faster, lets say in 2 sec, your test will continue running
      and will not wait for extra 8 sec, if after 10 seconds element was not found, you will get NoSuchElementException.

        ImplicitWait should be specified only once at the beginning, it will apply automatically before every findElement() method call,
         but not findElements() method.
            Thread.sleep(10000) ====> always and only 10 seconds wait
            implicitWait(10, TimeUnits.SECONDS)===> up to 10 seconds.

        ExplicitWait  ====> it works in similar way as am implicit wait, but explicit wait targets specific element with a specific condition.
            implicit resolves only one problem;
                presence of element.
            Explicit wait resolves more problems:
                presence of element,visibility, clickability, staleness of element, etc..

            Every 500 milliseconds selenium will check if the condition is met. if no, it will keep checking within the given time frame.
            wait until page is loaded handled automatically by selenium, but other conditions - no (like visibility or clickability).

            Page is fully loaded,

     */
}
