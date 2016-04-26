package example.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by vonzhou on 16/4/24.
 */
public class Client {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("client-context.xml");
        HelloService helloService = (HelloService) context.getBean("helloService");
        System.out.println(helloService.sayHi("zzzz"));
    }
}
