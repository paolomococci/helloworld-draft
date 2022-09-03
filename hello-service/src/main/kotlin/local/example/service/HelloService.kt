package local.example.service

import io.quarkus.grpc.GrpcService
import io.smallrye.mutiny.Uni

import local.example.gprc.Greeter
import local.example.gprc.HelloRequest
import local.example.grpc.HelloReply

@GrpcService
class HelloService : Greeter {
    override fun sayHello(request: HelloRequest): Uni<HelloReply> {
        return Uni.createFrom().item {
            HelloReply.newBuilder().setMessage("Hello " + request.name).build()
        }
    }
}