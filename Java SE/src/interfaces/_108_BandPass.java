package interfaces;

public class _108_BandPass extends _105_Filter {

    double lowCutoff;
    double highCutoff;

    public _108_BandPass(double lowCut, double highCut) {
        lowCutoff = lowCut;
        highCutoff = highCut;
    }

    @Override
    public _104_Waveform process(_104_Waveform input) {
        return input;
    }

}
