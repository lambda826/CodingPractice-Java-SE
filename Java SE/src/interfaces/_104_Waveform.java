package interfaces;

public class _104_Waveform {

    private static long counter;
    private final long id = counter++;

    public String toString() {
        return "Waveform " + id;
    }

}