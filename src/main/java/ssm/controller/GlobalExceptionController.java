package ssm.controller;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.HashMap;
import java.util.Map;

/**
 * 这个类用来处理各种异常，避免产生过于严重的错误
 * 不过限于时间有限，只是做了简单的返回空JSON串的处理
 */
@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Object globalExceptionHandler(Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        FastJsonJsonView view = new FastJsonJsonView();
        Map<String, Object> attributes =new HashMap<>();
        attributes.put("code", "-1");
        view.setAttributesMap(attributes);
        modelAndView.setView(view);
        return modelAndView;
    }
}
