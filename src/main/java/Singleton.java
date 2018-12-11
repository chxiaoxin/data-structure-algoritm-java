public class Singleton {
   private Singleton() {}
   private static Singleton singletonObject = null;
   public static Singleton getSingleton() {
       synchronized (Singleton.class) {
           if (singletonObject == null) {
               singletonObject = new Singleton();
               return singletonObject;
           } else {
               return singletonObject;
           }
       }
   }

    public static void main(String[] args) {
        Singleton single = Singleton.getSingleton();
    }
}
