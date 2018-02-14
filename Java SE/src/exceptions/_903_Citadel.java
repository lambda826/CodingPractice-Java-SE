/**
 *  @author  Yunxiang He
 *  @date    Feb 13, 2018 11:22:50 PM
 */

package exceptions;

/*



 */

public class _903_Citadel {
    public void openDrawbridge() throws RuntimeException {
        try {
            throw new KnightAttackingException();
        } catch (Exception e) {
            throw new ClassCastException();
        } finally {
            // the method declaration doesn't throw this exception
            //            throw new CastleUnderSiegeException();
        }
    }
}

class CastleUnderSiegeException extends Exception {
}

class KnightAttackingException extends CastleUnderSiegeException {
}
