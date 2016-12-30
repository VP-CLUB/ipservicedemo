package cn.vpclub.ipaddress.api;

import cn.vpclub.spring.boot.grpc.GRpcService;
import cn.vpclub.spring.boot.hazelcast.utils.HIdGenerator;
import com.hazelcast.core.HazelcastInstance;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.net.InetAddress;

/**
 * Created by  vpclub on 16-12-9.
 * PackageName cn.vpclub.ipaddress.service
 * ModifyDate  16-12-9
 * Description (to do)
 * ProjectName ipservice
 */
@GRpcService
public class IpAddressServiceServer extends IpAddressOptionGrpc.IpAddressOptionImplBase {
    private static Logger logger = LoggerFactory.getLogger(IpAddressServiceServer.class);
    private int counter;
    @Autowired
    private ApplicationContext context;

    private static HazelcastInstance instance;


    public HazelcastInstance getHazelcastInstance() {
        return instance = (HazelcastInstance) context.getBean("hazelcastInstance");
    }

    @Override
    public void getAddress(IpAddressOuterClass.HelloRequest request, StreamObserver<IpAddressOuterClass.HelloReply> responseObserver) {
        logger.info("receive client request " + request.getName());
        if (null == instance) {
            this.getHazelcastInstance();
        }
        Long id = HIdGenerator.newTimeId(instance, "instance: id ");

        logger.info("hazelcast generator id is " + id);
        IpAddressOuterClass.IpAddress.Builder ipAddressBuilder = null;
        try {
            ipAddressBuilder = IpAddressOuterClass.IpAddress.newBuilder()
                    .setIpAddress("this is from server : ip ==" + InetAddress.getLocalHost().getHostAddress())
                    .setMessage("message is : " + request.getMessage()).setId(counter++);

        } catch (Exception e) {
            logger.error("" + e);
        }
        final IpAddressOuterClass.HelloReply.Builder responseBuilder = IpAddressOuterClass.HelloReply.newBuilder().setIpAddress(ipAddressBuilder);

        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
    }
}