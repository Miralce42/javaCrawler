/**
 * Created by 韩壮 on 2017/8/4.
 */


import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;
import java.util.List;

public class wanglaoju {
    public void visit() throws IOException{
        WebClient webClient=new WebClient(BrowserVersion.FIREFOX_52);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);
        HtmlPage page = webClient.getPage("http://www.bilibili.com/video/av12936513/");
        System.out.println(page.toString());
        System.out.println("\n\n\n\n-------------------------------分割线---------------------------\n\n\n\n");
       // HTMLDivElement div = page.getElementsByName("pause_button");
        List<DomElement> button = page.getElementsByName("play_button");
        HtmlPage page1 = button.get(0).click();
        System.out.println(page1.asXml());
        webClient.close();
    }
}
