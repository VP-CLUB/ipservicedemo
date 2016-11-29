package cn.vpclub;

import cn.vpclub.mq.kafka.Listener;
import com.alibaba.druid.filter.config.ConfigTools;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.system.ApplicationPidFileWriter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.util.concurrent.atomic.AtomicLong;

@SpringBootApplication
public class DemoApplication {

    @Bean
    public Listener listener() {
        return new Listener();
    }
    public static void main(String[] args) throws Exception{
        SpringApplication.run(DemoApplication.class, args);
//        SpringApplication application = new SpringApplication(
//                DemoApplication.class);
//        application.run(args);

        String pwd = "vpclub.dev";
        System.out.println("encrypt = [" + ConfigTools.encrypt(pwd).trim() + "]");
        System.out.println("decrypt = [" + ConfigTools.decrypt(ConfigTools.encrypt(pwd).trim()).trim() + "]");
    }

}

@RestController
class IPAddressController {
    private int counter;
    @Value("${ipservice.message}")
    private String message;

    private static final String template = "Hello, %s!";

    private final AtomicLong counters = new AtomicLong();

    @RequestMapping(value = "/ip", method = RequestMethod.GET)
    public IPAddress ipaddress() throws Exception {
        return new IPAddress(message, ++counter, InetAddress.getLocalHost().getHostAddress());
    }
    @RequestMapping("/greeting-javaconfig")
    public Greeting greetingWithJavaconfig(@RequestParam(required=false, defaultValue="World") String name) {
        System.out.println("==== in greeting ====");
        return new Greeting(counters.incrementAndGet(), String.format(template, name));
    }
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(required=false, defaultValue="World") String name) {
        System.out.println("==== in greeting ====");
        return new Greeting(counters.incrementAndGet(), String.format(template, name));
    }
}
class IPAddress {

    private final long id;
    private  String ipAddress;
    private  String message;

    public IPAddress(String msg,long id, String ipAddress) {
        this.id = id;
        this.ipAddress = ipAddress;
        this.message = msg;
    }

    public long getId() {
        return id;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
class Greeting {

    private final long id;
    private final String content;

    public Greeting() {
        this.id = -1;
        this.content = "";
    }

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}