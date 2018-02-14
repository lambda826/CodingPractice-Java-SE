/**
 *  @author  Yunxiang He
 *  @date    Feb 13, 2018 6:35:34 PM
 */

package exceptions;

/*

When you override a method, you can throw only the exceptions that have been specified in the base-class version of the method. 
This is a useful restriction, since it means that code that works with the base class will automatically work with any object derived from the base class (a fundamental OOP concept, of course), including exceptions.

The restriction on exceptions does not apply to constructors. 
You can see in Stormylnning that a constructor can throw anything it wants, regardless of what the base-class constructor throws. 
However, since a base-class constructor must always be called one way or another (here, the default constructor is called automatically), the derived-class constructor must declare any base-class constructor exceptions in its exception specification.

A derived-class constructor cannot catch exceptions thrown by its base-class constructor.

 */

class BaseballException extends Exception {
}

class Foul extends BaseballException {
}

class Strike extends BaseballException {
}

abstract class Inning {
    public Inning() throws BaseballException {
    }

    public void event() throws BaseballException {
        // Doesn’t actually have to throw anything
    }

    public abstract void atBat() throws Strike, Foul;

    public void walk() {
    } // Throws no checked exceptions
}

class StormException extends Exception {
}

class RainedOut extends StormException {
}

class PopFoul extends Foul {
}

interface Storm {
    public void event() throws RainedOut;

    public void rainHard() throws RainedOut;
}

public class StormyInning extends Inning implements Storm {
    // OK to add new exceptions for constructors, but you must deal with the base constructor exceptions (BaseballException):
    public StormyInning() throws RainedOut, BaseballException {
    }

    public StormyInning(String s) throws Foul, BaseballException {
    }

    // Regular methods must conform to base class:
    //! void walk() throws PopFoul {} //Compile error

    // Interface CANNOT add exceptions to existing methods from the base class:
    //! public void event() throws RainedOut {}

    // If the method doesn’t already exist in the base class, the exception is OK:
    public void rainHard() throws RainedOut {
    }

    // You can choose to not throw any exceptions,
    //even if the base version does:
    public void event() {
    }

    //Overridden methods can throw inherited exceptions:
    public void atBat() throws PopFoul {
    }

    public static void main(String[] args) {
        try {
            StormyInning si = new StormyInning();
            si.atBat();
        } catch (PopFoul e) {
            System.out.println("Pop foul");
        } catch (RainedOut e) {
            System.out.println("Rained out");
        } catch (BaseballException e) {
            System.out.println("Generic baseball exception");
        }
        //Strike not thrown in derived version.
        try {
            //What happens if you upcast?
            Inning i = new StormyInning();
            i.atBat();
            //You must catch the exceptions from the
            //base-class version of the method:
        } catch (Strike e) {
            System.out.println("Strike");
        } catch (Foul e) {
            System.out.println("Foul");
        } catch (RainedOut e) {
            System.out.println("Rained out");
        } catch (BaseballException e) {
            System.out.println("Generic baseball exception");
        }
    }
}
