/**
 *  @author  Yunxiang He
 *  @date    Feb 10, 2018 2:14:47 AM
 */

package inheritance_Interface.ocp;

public class Violin extends StringInstrument implements MusicCreator {
    
    // has to be compatible with StringInstrument#play()
    public Long play() {
        return 12L;
    }
}

interface MusicCreator {
    public Number play();
}

abstract class StringInstrument {
    public Long play() {
        return 3L;
    }
}
