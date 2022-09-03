package local.example.outcome;

import io.quarkus.grpc.GrpcClient;
import io.smallrye.mutiny.Uni;
import local.example.hello.grpc.Greeter;
import local.example.hello.grpc.HelloRequest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/outcome")
public class OutcomeResource {

    @GrpcClient
    Greeter greeter;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello\n";
    }

    @GET
    @Path("/{name}")
    public Uni<String> hello(String name) {
        return greeter.sayHello(
                HelloRequest.newBuilder().setName(name).build()
        ).onItem().transform(
                helloReply -> helloReply.getMessage()
        );
    }
}
