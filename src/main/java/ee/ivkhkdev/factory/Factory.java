package ee.ivkhkdev.factory;

import java.lang.module.Configuration;
import java.util.HashMap;
import java.util.Map;

public class Factory {
    private static Factory FACTORY = null;
    private static Configuration configuration;

    private Factory() {
    }
    public static void getInstance(Configuration configuration) {
        Factory.configuration = configuration;
        if (FACTORY == null) {
            Factory.FACTORY = new Factory();
        }
    }
    public <T> T getObject(String name){
        return (T) this.configuration.getMap.get(name);
    }
}
