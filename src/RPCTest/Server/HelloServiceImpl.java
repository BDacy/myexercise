package RPCTest.Server;

import RPCTest.HelloService;

public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "Hello "+name;
    }

    @Override
    public String hi(String msg) {
        return "Hi "+msg;
    }
}
