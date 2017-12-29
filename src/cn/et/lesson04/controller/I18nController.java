package cn.et.lesson04.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class I18nController {

	@Autowired
	private MessageSource ms;
	
	@RequestMapping(value = "i18n" , method = RequestMethod.GET)
	public String i18n(HttpServletResponse response , Locale locale) throws Exception{
		response.setContentType("text/html;charset=UTF-8");
		response.getOutputStream().write(ms.getMessage("key", null, locale).getBytes("UTF-8"));
		return null;
	}
}