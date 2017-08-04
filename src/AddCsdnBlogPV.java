import java.io.IOException;
import java.io.InputStream;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Thread.sleep;

/**
 * Created by 韩壮 on 2017/8/3.
 */
public class AddCsdnBlogPV {
    private String csdnBlogUrl = "http://blog.csdn.net/";
    private String BlogListPageUrl = "http://blog.csdn.net/han_zhuang?viewmode=contents";
    private String artlUrl = "/han_zhuang/article/details/[0-9]{8,8}";

    private Set<String> blogUrls = new TreeSet<>();

    public void visitBlog() throws IOException {
        int n = 0;
        while(n < 500) {
            int idx = (int) (Math.random() * blogUrls.size());
            Object ary[] = blogUrls.toArray();
            String blogUrl = ary[idx].toString();
            String artlUrl = csdnBlogUrl + blogUrl;
            InputStream is = HttpUtil.doGet(artlUrl);
            try {
                int times = (int) (Math.random()*10000)+50000;
                sleep(times);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (is != null) {
                System.out.println(artlUrl + "访问成功");
            }
            is.close();
        }
    }

    public void addBlogUrl() throws IOException{
        InputStream is = HttpUtil.doGet(BlogListPageUrl);
        String pageStr = StreamUtil.inputStreamToString(is,"UTF-8");
        System.out.println(pageStr);
        is.close();
        Pattern pattern = Pattern.compile(artlUrl);
        Matcher matcher = pattern.matcher(pageStr);//使用正则表达式进行匹配
        while(matcher.find()){
            String e = matcher.group(0);
            System.out.println("成功添加博客地址：" + e);
            blogUrls.add(e);
        }
    }
}
