public class AuthorDocExample { // Noncompliant
    /**
     * 名字
     */
    private String name;

    /**
     * 获得名字
     */
    public void getUserName() {
    }

    /**
     * 获得性别
     */
    public void getUserSex() {
    }
}

/**
 * 作者：lizw <br/>
 * 创建时间：2017/9/15 21:06 <br/>
 */
interface BaseClient {
    /**
     * 视图页面(JSP)的后缀
     */
    String JSON_SUFFIX = ".json";
}