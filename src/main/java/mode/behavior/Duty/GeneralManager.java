package mode.behavior.Duty;

/**
 * 总经理的权限很大
 * Created by Think on 2017/11/24.
 */
public class GeneralManager extends Handler {
    @Override
    public String handleRequest(String user, int fee) {
        String str = "";
        //总经理的权限很大，只要请求到了这里，他都可以处理
        if(fee >= 1000)
        {
            //为了测试，简单点，只同意张三的请求
            if("张三".equals(user))
            {
                str = "成功：总经理同意【" + user + "】的聚餐费用，金额为" + fee + "元";
            }else
            {
                //其他人一律不同意
                str = "失败：总经理不同意【" + user + "】的聚餐费用，金额为" + fee + "元";
            }
        }else
        {
            //如果还有后继的处理对象，继续传递
            if(getSuccessor() != null)
            {
                return getSuccessor().handleRequest(user, fee);
            }
        }
        return str;
    }
}
