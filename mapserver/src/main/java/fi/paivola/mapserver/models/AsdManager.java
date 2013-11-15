package fi.paivola.mapserver.models;

import fi.paivola.mapserver.core.GameManager;
import fi.paivola.mapserver.core.MapObject;
import fi.paivola.mapserver.core.ModelManager;

public class AsdManager extends ModelManager {

    public AsdManager(GameManager gm) {
        super(gm);
        
        gm.addModel("asd", Asd.class);
        
    }
    
}
