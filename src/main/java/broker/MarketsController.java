package broker;

import broker.model.Symbol;
import broker.store.InMemoryStore;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.List;

@Controller("/markets")
public class MarketsController {

    private final InMemoryStore store;

    public MarketsController(InMemoryStore store) {
        this.store = store;
    }

    @Get("/")
    public List<Symbol> all(){
        return store.getAllSymbols();
    }
}