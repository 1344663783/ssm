package com.ssm.base.common;

        import com.ssm.base.util.JsonUtil;
        import org.springframework.stereotype.Component;
        import org.springframework.web.servlet.HandlerExceptionResolver;
        import org.springframework.web.servlet.ModelAndView;

        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;
        import java.io.PrintWriter;

@Component
public class ExceptionHandler implements HandlerExceptionResolver{

    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object o, Exception e) {
        PrintWriter writer=null ;
        try {
            writer = response.getWriter();
            writer.print(JsonUtil.error("服务端异常"));
            writer.flush();
        } catch (IOException e1) {
        }finally {
            writer.close();
        }
        return null;
    }
}
