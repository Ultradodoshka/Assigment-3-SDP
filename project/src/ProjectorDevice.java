public class ProjectorDevice implements Device{
    @Override
    public String applySettings(int volume) {
        return "Type: Projector, Power: on, Volume: "+volume;
    }
}
