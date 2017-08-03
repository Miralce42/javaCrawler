import java.io.IOException;
import java.io.InputStream;

/**
 * Created by 韩壮 on 2017/8/3.
 */
public class StreamUtil {
    public static String inputStreamToString(InputStream is,String charset) throws IOException{
        byte[] bytes = new byte[1024];
        int byteLength = 0;
        StringBuffer sb = new StringBuffer();
        while((byteLength = is.read(bytes)) != -1) {
            sb.append(new String(bytes, 0, byteLength, charset));
        }
        return sb.toString();
    }
}
