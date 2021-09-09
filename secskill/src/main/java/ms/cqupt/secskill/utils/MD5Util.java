package ms.cqupt.secskill.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.springframework.stereotype.Component;

@Component
public class MD5Util {

    public static String md5(String src){
        return DigestUtils.md5Hex(src);
    }

    private static final String salt = "1a2b3c4d";

    /**
     * 对前端传输数据进行加密
     * @param inputPass
     * @return
     */
    public static String inputPassToFromPass(String inputPass){
        String str = salt.charAt(1)+salt.charAt(3)+inputPass+salt.charAt(2)+salt.charAt(4);
        return md5(str);
    }

    /**
     * 存入数据库之前进行再次加密
     * @param fromPass
     * @param salt
     * @return
     */
    public static String fromPassToDBPass(String fromPass,String salt){
        String str = salt.charAt(1)+salt.charAt(3)+fromPass+salt.charAt(2)+salt.charAt(4);
        return md5(str);
    }

    /**
     * 调用两次不同的加密过程对前端传输的数据进行加密 & 对存入数据库的数据进行再次加密
     * @param inputPass
     * @param salt
     * @return
     */
    public static String inputPassToDBPass(String inputPass,String salt){
        String fromPass = inputPassToFromPass(inputPass);
        String dbPass = fromPassToDBPass(fromPass,salt);
        return dbPass;
    }

    @Test
    public void test(){
        System.out.println(inputPassToFromPass("123456"));
        System.out.println(fromPassToDBPass("frer9f98ff8f0d8f09d8fd","1a2b3c4d"));
        System.out.println(inputPassToDBPass("123456","1a2b3c4d"));
    }
}
