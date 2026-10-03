public class QuietRemote extends Remote {
    public QuietRemote(String id, Device device) {
        super(id, device);
        this.volumePreset=5;
    }
}
