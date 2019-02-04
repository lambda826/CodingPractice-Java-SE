package clazz.innerClazz;

//Creating an inner class directly using the .new syntax.
public class _05_DotNew {
    
    public class Inner {
    }

    public static void main(String[] args) {
        _05_DotNew dn = new _05_DotNew();
        _05_DotNew.Inner dni = dn.new Inner();
    }
} 
