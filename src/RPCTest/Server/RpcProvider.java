package RPCTest.Server;

import RPCTest.HelloService;

public class RpcProvider {
    public static void main(String[] args) throws Exception {
        HelloService helloService=new HelloServiceImpl();
        // RPC框架将服务暴露出来，供客户端消费
        RpcFramework.export(helloService, 1234);

    }
}
