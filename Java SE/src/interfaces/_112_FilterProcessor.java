package interfaces;

class FilterAdapter implements _109_Processor {

    _105_Filter filter;

    public FilterAdapter(_105_Filter filter) {
        this.filter = filter;
    }

    public String name() {
        return filter.name();
    }

    // delegation
    public _104_Waveform process(Object input) {
        return filter.process((_104_Waveform) input);
    }
}

public class _112_FilterProcessor {
    public static void main(String[] args) {
        _104_Waveform w = new _104_Waveform();
        _110_Apply.process(new FilterAdapter(new _106_LowPass(1.0)), w);
        _110_Apply.process(new FilterAdapter(new _107_HighPass(2.0)), w);
        _110_Apply.process(new FilterAdapter(new _108_BandPass(3.0, 4.0)), w);
    }
}