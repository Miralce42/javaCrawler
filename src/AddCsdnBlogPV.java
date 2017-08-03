import java.io.IOException;
import java.io.InputStream;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 韩壮 on 2017/8/3.
 */
public class AddCsdnBlogPV {
    private String csdnBlogUrl = "http://blog.csdn.net/";
    private String BlogListPageUrl = "http://blog.csdn.net/han_zhuang?viewmode=contents";
    private String artlUrl = "/han_zhuang/article/details/[0-9]{8,8}";

    private Set<String> blogUrls = new TreeSet<>();

    public void visitBlog() throws IOException {
        addBlogUrl();
        for(String blogUrl : blogUrls) {
            String artlUrl = csdnBlogUrl + blogUrl;
            InputStream is = HttpUtil.doGet(artlUrl);
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
        Matcher matcher = pattern.matcher(pageStr);
        while(matcher.find()){
            String e = matcher.group(0);
            System.out.println("成功添加博客地址：" + e);
            blogUrls.add(e);
        }
    }
}
