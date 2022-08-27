package com.example.broker;

import com.example.broker.persistence.jpa.SymbolEntity;
import com.example.broker.persistence.jpa.SymbolsRepository;
import com.example.model.Symbol;
import com.example.store.InMemoryStore;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.reactivex.Single;

import java.util.List;

@Secured(SecurityRule.IS_ANONYMOUS)
@Controller("/markets")
public class MarketsController {

    private final InMemoryStore store;
    private final SymbolsRepository symbols;

    public MarketsController(InMemoryStore store, SymbolsRepository symbols) {
        this.store = store;
        this.symbols = symbols;
    }

    @Get("/")
    public Single<List<Symbol>> index(){
        return Single.just(store.getAllSymbols());
    }

    @Get("/jpa")
    public Single<List<SymbolEntity>> allSymbolsViaJPA(){
        return Single.just(symbols.findAll());
    }

}
