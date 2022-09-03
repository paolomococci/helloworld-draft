package local.example.service;

import io.quarkus.grpc.GrpcService;
import io.smallrye.mutiny.Uni;

import local.example.hello.grpc.Greeter;
import local.example.hello.grpc.HelloReply;
import local.example.hello.grpc.HelloRequest;

@GrpcService
public class HelloService implements Greeter {

    @Override
    public Uni<HelloReply> sayHello(HelloRequest helloRequest) {
        return Uni.createFrom().item(
                () -> HelloReply.newBuilder().setMessage(
                        "Hello " + helloRequest.getName()
                ).build()
        );
    }
}
