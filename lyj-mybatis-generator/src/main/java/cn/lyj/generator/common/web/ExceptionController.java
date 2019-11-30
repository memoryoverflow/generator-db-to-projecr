package cn.lyj.generator.common.web;

import cn.lyj.generator.common.exception.Error;
import cn.lyj.generator.common.exception.MyException;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * <p>
 * 主要处理404响应JSON
 * </p>
 *
 * @author 永健
 * @since 2019-05-24 10:52
 */
@RestController
public class ExceptionController implements ErrorController
{

    @GetMapping("/error")
    public void notFound(HttpServletRequest request) throws Exception
    {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == 404)
        {
            throw new MyException(Error.请求路径异常);
        }
        throw new Exception();
    }

    @Override
    public String getErrorPath()
    {
        return "/error";
    }
}