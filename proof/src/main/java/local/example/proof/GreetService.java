package local.example.proof;

import javax.enterprise.context.Dependent;

@Dependent
public class GreetService {

    public String greet(String name) {
        if (name == null || name.isEmpty()) {
            return "Hello, kind guest!";
        } else {
            return "Hello " + name + "!";
        }
    }
}
