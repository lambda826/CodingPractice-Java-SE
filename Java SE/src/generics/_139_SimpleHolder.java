package generics;

public class _139_SimpleHolder {
    
    private Object obj;

    public void set(Object obj) {
        this.obj = obj;
    }

    public Object get() {
        return obj;
    }

    public static void main(String[] args) {
        _139_SimpleHolder holder = new _139_SimpleHolder();
        holder.set("Item");
        // The set() and get() methods simply store and produce the value, and the cast is checked at the point of the call to get().
        String s = (String) holder.get();
    }
}
