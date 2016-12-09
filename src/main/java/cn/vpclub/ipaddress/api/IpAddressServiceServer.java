package cn.vpclub.ipaddress.api;

import cn.vpclub.spring.boot.grpc.GRpcService;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    @Override
    public void getAddress(IpAddressOuterClass.HelloRequest request, StreamObserver<IpAddressOuterClass.HelloReply> responseObserver) {
        logger.info("receive client request " + request.getName());
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