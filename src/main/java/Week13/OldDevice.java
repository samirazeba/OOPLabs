package Week13;

interface OldDevice {
    void operateOldFunction ();
}
interface NewDevice {
    void operateNewFunction();
}
class OldDeviceImpl implements OldDevice {
    @Override
    public void operateOldFunction() {
        System.out.println("Older version of a device.");
    }
}
class NewDeviceImpl implements NewDevice {
    @Override
    public void operateNewFunction() {
        System.out.println("Newer version of a device.");
    }
}
class DeviceAdapter implements NewDevice {
    private OldDevice oldDevice;

    public DeviceAdapter(OldDevice oldDevice) {
        this.oldDevice = oldDevice;
    }

    @Override
    public void operateNewFunction() {
        oldDevice.operateOldFunction();
        System.out.println("Translating old function to a new device.");
    }
}
class ClientCode {
    public static void main(String[] args) {
        OldDevice oldDevice = new OldDeviceImpl();
        NewDevice newDevice = new NewDeviceImpl();

        System.out.println("New device: ");
        newDevice.operateNewFunction();

        System.out.println("\nOld device through the adapter:");
        DeviceAdapter adapter = new DeviceAdapter(oldDevice);
        adapter.operateNewFunction();
    }
}
