import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;

public class TestHutool {
    public static void main(String[] args) {
        String a = "[a,b,c]";
        String strip = StrUtil.strip(a, "[", "]");
        String[] strings = Convert.toStrArray(strip);
        System.out.println(strings);
    }
}
