package fi.paivola.mapserver.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.parser.ParseException;

public class GameManager {
    
    public long tick_amount;
    public long tick_current;
    private Map<String, Object> models;
    private final List<DataFrame> frames;
    private SettingsParser sp;
    
    public GameManager(long tick_amount) {
        this.tick_amount = tick_amount;
        this.tick_current = 0;
        //this.models = new HashMap();
        this.frames = new ArrayList<>();
        
        try {
            this.sp = new SettingsParser();
            this.models = this.sp.getModels();
        } catch (IOException | ParseException ex) {
            Logger.getLogger(GameManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        clearFrames();
    }
    
    private void clearFrames() {
        frames.clear();
        for(long i = 0; i < this.tick_amount; i++) {
            frames.add( new DataFrame(i) );
        }
    }
    
    public int addModel(String id, Class clas) {
        if(   this.models.put(id, clas) == null) {
            return 0;
        }
        return 1;
    }
    
    public int createModel(String id) {
        
        return 0;
    }
    
    public int step() {
        
        return 0;
    }
    
}
