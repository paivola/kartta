package fi.paivola.mapserver.core;

import java.util.HashMap;
import java.util.Map;

public class DataFrame {
    
    public long index;
    private Map<String, Object> data;
    
    public DataFrame(long index) {
        this.index = index;
        this.data = new HashMap();
    }
    
    public int saveEvent(Model model) {
        
        return 0;
    }
    
}
