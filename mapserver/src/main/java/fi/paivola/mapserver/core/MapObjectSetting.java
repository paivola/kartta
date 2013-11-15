package fi.paivola.mapserver.core;

public class MapObjectSetting {
    public String name;
    public String type;
    public long min;
    public long max;
    public long def;
    
    public MapObjectSetting (String name, long min, long max, long def) {
        this.name = name;
        this.min = min;
        this.max = max;
        this.def = def;
    }
}
