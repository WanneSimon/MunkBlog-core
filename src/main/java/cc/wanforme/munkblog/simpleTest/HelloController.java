package cc.wanforme.munkblog.simpleTest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * @author wanne
 * 2020年4月26日
 * 
 */
@Controller
@RequestMapping("/test")
public class HelloController {

//	@Autowired
//	private UserMapper mapper;
	
	@GetMapping("/hello")
	@ResponseBody
	public String helloWorld() throws JsonProcessingException {
//		User user = mapper.getUser(1);
//		System.out.println(JsonUtil.toJsonString(user));
		return "hello world !";
	}
	
}
