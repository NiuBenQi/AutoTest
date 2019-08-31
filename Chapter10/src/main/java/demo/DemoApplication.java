package demo;

/**
 * Created by Administrator on 2019/4/7.
 */


@Controller
@EnableAutoConfiguration
public class DemoApplication {

    @RequestMapping("/")
    @ResponseBody
    String home(){
        return "Hello World!"
    }
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}