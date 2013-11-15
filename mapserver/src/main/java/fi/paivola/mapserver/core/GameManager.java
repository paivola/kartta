package fi.paivola.mapserver.core;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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
    private final List<Model> active_models;
    private SettingsParser sp;
    public long current_id;
    
    public GameManager(long tick_amount) {
        this.tick_amount = tick_amount;
        this.tick_current = 0;
        this.frames = new ArrayList<>();
        this.active_models = new ArrayList<>();
        this.current_id = 0;
        
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

    public int createModel(String type) {
        Class cls;
        cls = (Class) models.get(type);
        if(cls == null) {
            return 1;
        }
        try {
            Constructor<Model> c;
            c = cls.getDeclaredConstructor(long.class);
            c.setAccessible(true);
            try {
                this.active_models.add(c.newInstance(this.current_id++));
            } catch (    InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                Logger.getLogger(GameManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(GameManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public int step() {
        
        return 0;
    }
    
}
