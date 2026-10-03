public abstract class Remote {
    private String id;
    protected int volumePreset;
    protected Device device;

    public Remote(String id, Device device){
        this.id=id;
        this.device=device;
    }

    public void setImplementation(Device device){
        this.device=device;
    }

    public String execute(){
        return device.applySettings(volumePreset);
    }

    public String getId(){return id;}
    public int getVolumePreset() {return volumePreset;}
}
