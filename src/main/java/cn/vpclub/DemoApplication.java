package cn.vpclub;

import com.alibaba.druid.filter.config.ConfigTools;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws Exception{
        SpringApplication.run(DemoApplication.class, args);
        System.out.println("args = [" + ConfigTools.encrypt("@vpclubdev").trim() + "]");
    }


}

@RestController
class IPAddressController {
    private int counter;
    @Value("${ipservice.message}")
    private String message;
    @RequestMapping(value = "/ip", method = RequestMethod.GET)
    public IPAddress ipaddress() throws Exception {
        return new IPAddress(message, ++counter, InetAddress.getLocalHost().getHostAddress());
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