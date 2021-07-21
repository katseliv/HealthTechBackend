package team.healthtech.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team.healthtech.db.HelloWorldProvider;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    private final HelloWorldProvider provider;

    @Autowired
    public HelloWorldController(HelloWorldProvider provider) {
        this.provider = provider;
    }

    @GetMapping("/world/") // строки 12 и 13 эквивалентны, обе писать не нужно
    //@RequestMapping(method = RequestMethod.GET)
    public String helloWorld(@RequestParam(name = "name", defaultValue = "anonymous") String name) {
        return provider.sayHello(name);
    }

    @GetMapping("/{name}")
    public String hello(@PathVariable("name") String name) {
        return provider.sayHello(name);
    }
}
