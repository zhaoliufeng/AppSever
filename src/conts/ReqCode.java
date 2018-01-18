package conts;

public class ReqCode {
    //请求码
    public static final String OP_CODE = "op";
    /**版本管理基值0**/
    private static final int V_BASE = 0;
    //请求当前最新版本号
    public static final int VERSION_REQUEST_CODE = V_BASE;
    //设置当前最新版本号
    public static final int VERSION_SET_CODE = V_BASE + 1;

    /**用户管理基值100**/
    private static final int A_BASE = 100;
    //请求登录
    public static final int ADMIN_LOGIN = A_BASE;
    //请求添加管理员
    public static final int ADMIN_ADD = A_BASE + 1;
}
