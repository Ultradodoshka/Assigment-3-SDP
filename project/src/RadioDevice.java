public class RadioDevice implements Device{
    @Override
    public String applySettings(int volume) {
        return "Type: Radio, Power: on, Volume: "+volume;
    }
}
