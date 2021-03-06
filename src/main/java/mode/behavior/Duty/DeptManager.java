package mode.behavior.Duty;

/**
 * Created by Think on 2017/11/24.
 */
public class DeptManager extends Handler {
    @Override
    public String handleRequest(String user, int fee) {
        String str = "";
        if (fee < 1000) {
            //为了测试，简单点，只同意张三的请求
            if ("张三".equals(user)) {
                str = "成功：部门经理同意【" + user + "】的聚餐费用，金额为" + fee + "元";
            } else {
                //其他人一律不同意
                str = "失败：部门经理不同意【" + user + "】的聚餐费用，金额为" + fee + "元";
            }
        } else {
            //超过1000，继续传递给级别更高的人处理
            if(getSuccessor() != null)
            {
                return getSuccessor().handleRequest(user, fee);
            }
        }
        return str;
    }
}
