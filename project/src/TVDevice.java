public class TVDevice  implements Device{
    @Override
    public String applySettings(int volume) {
        return "Type: TV, Power: on, Volume: "+volume;
    }
}
