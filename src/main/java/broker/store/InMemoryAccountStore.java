package broker.store;

import broker.model.WatchList;

import javax.inject.Singleton;
import java.util.HashMap;
import java.util.UUID;

@Singleton
public class InMemoryAccountStore {
    private final HashMap<UUID, WatchList> watchListPerAccount = new HashMap<>();
    public WatchList getWatchList(final UUID accountId) {
        return watchListPerAccount.getOrDefault(accountId, new WatchList());
    }
    public WatchList updateWatchList(final UUID accountId, WatchList watchList) {
        watchListPerAccount.put(accountId, watchList);
        return getWatchList(accountId);
    }
    public void deleteWatchList(UUID accountId) {
        watchListPerAccount.remove(accountId);
    }
}
