package proxy;

public class proxyTest {
    public static void main(String[] args) {

        Browser browser = new Browser("www.naver.com");
        browser.show();
        browser.show();
        browser.show();
        browser.show();

        IBrowser browserProxy = new BrowserProxy("www.naver.com");

        browserProxy.show();
        browserProxy.show();
        browserProxy.show();
        browserProxy.show();





    }
}
