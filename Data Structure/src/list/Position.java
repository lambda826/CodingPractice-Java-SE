/**
 *  @author  Yunxiang He
 *  @date    Feb 7, 2018 1:19:01 AM
 */

package list;

public interface Position<E> {

    /**
    * Returns the element stored at this position.
    * 
    * @return the stored element
    * @throws IllegalStateException ifposition no longer valid
    */

    E getElement() throws IllegalStateException;
}