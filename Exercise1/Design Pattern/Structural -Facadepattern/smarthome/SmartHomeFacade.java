package smarthome;

public class SmartHomeFacade {
    private final Lights lights;
    private final AC ac;
    private final DoorLock door;

    public SmartHomeFacade() {
        this.lights = new Lights();
        this.ac = new AC();
        this.door = new DoorLock();
    }

    public void leavingHome() {
        lights.turnOff();
        ac.turnOff();
        door.lock();
        System.out.println("Leaving Home mode activated.");
    }

    public void arrivingHome() {
        door.unlock();
        lights.turnOn();
        ac.turnOn();
        System.out.println("Arriving Home mode activated.");
    }
}
