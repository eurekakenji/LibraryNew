package ee.ivkhkdev.factory;

import java.util.HashMap;
import java.util.Map;

import static java.lang.module.ModuleFinder.of;

public class JavaConfiguration implements Configuration{
    private Map<String,Object> map = new HashMap<>();

    public JavaConfiguration() {
        init();
    }
    private void init() {
        this.map.put("emptyObject",new Object());
    }

    @Override
    public Map<String, Object> getMap() {
        try {

        } catch (Exception e) {
            throw new RuntimeException("No such class exists");
        }
        return this.map;
    }
}
