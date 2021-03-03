package algo20210105;

public class Reentrancy {
    // b가 Synchronized로 선언되어 있더라도, a 진입시 lock을 획득하였음.
    // b를 호출할 수 있게 됨.
    public synchronized void a() {
        System.out.println("a");
        b();
    }
    
    public synchronized void b() {
        System.out.println("b");
    }
    
    public static void main (String[] args) {
        new Reentrancy().a();
    }
}