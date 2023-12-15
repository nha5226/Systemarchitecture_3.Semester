package readside;

import readside.readStore.Storage;
import readside.readStore.StorageRepository;

public class ServiceLocator {

    private static StorageRepository storageRepository;

    public static StorageRepository getStorageRepository() {
        if(storageRepository == null){
            storageRepository = new Storage();
        }
        return storageRepository;
    }


}
