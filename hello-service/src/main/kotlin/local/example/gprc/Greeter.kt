package local.example.gprc

import io.smallrye.mutiny.Uni
import local.example.grpc.HelloReply

interface Greeter {
    fun sayHello(request: HelloRequest): Uni<HelloReply>
}