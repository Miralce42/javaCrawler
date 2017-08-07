import java.io.IOException;

/**
 * Created by 韩壮 on 2017/8/3.
 */
public class run {
    public static void main(String[] agrs) throws IOException{
     //   wanglaoju w = new wanglaoju();
    //    w.visit();
       AddCsdnBlogPV AC = new AddCsdnBlogPV();
        AC.addBlogUrl();
        AC.visitBlog();
    }
}
