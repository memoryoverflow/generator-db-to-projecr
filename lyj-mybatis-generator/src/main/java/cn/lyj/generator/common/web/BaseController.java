package cn.lyj.generator.common.web;

/**
 * <br>
 *
 * @desr
 * @Author 永健
 * @since 2019-05-23 17:33
 */
public abstract class BaseController
{

    /**
     * 返回成功
     */
    protected R success()
    {
        return R.success();
    }

    /**
     * 返回失败消息
     */
    protected R error()
    {
        return R.error();
    }

    /**
     * 返回成功消息
     */
    protected R successMsg(String message)
    {
        return R.success(message);
    }

    /**
     * 返回成功消息
     */
    protected R success(Object data)
    {
        return R.success(data);
    }

    /**
     * 返回失败消息
     */
    protected R error(String message)
    {
        return R.error(message);
    }

    /**
     * 根据修改搜影响的行数返回结果
     */
    protected R result(boolean flag)
    {
        return flag == true ? success() : error();
    }

    protected R result(boolean flag, String msg)
    {
        return flag == true ? successMsg(msg) : error();
    }


    protected R result(int row)
    {
        return row > 0 ? success() : error();
    }

    protected R result(int row, String msg)
    {
        return row > 0 ? successMsg(msg) : error();
    }


}
