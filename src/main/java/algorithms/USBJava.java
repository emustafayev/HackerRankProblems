package algorithms;


import javax.usb.UsbClaimException;
import javax.usb.UsbConfiguration;
import javax.usb.UsbDevice;
import javax.usb.UsbDeviceDescriptor;
import javax.usb.UsbDisconnectedException;
import javax.usb.UsbEndpoint;
import javax.usb.UsbException;
import javax.usb.UsbHostManager;
import javax.usb.UsbHub;
import javax.usb.UsbInterface;
import javax.usb.UsbInterfacePolicy;
import javax.usb.UsbNotActiveException;
import javax.usb.UsbPipe;
import javax.usb.UsbServices;
import javax.usb.event.UsbPipeDataEvent;
import javax.usb.event.UsbPipeErrorEvent;
import javax.usb.event.UsbPipeListener;
import java.util.Iterator;

public class USBJava {

    public static void main(String[] args) {
        USBJava usbJava = new USBJava();
//        usbJava.getUsbRootHoob();
//
//        for (var device: Usb.getDevices()){
//            System.out.println(device);
//        }
    }

    byte[] data = null;


    public UsbDevice getUsbRootHoob() {
        try {
            UsbServices services = UsbHostManager.getUsbServices();
            return services.getRootUsbHub();
        } catch (SecurityException var2) {
            var2.printStackTrace();
        } catch (UsbException var3) {
            var3.printStackTrace();
        }

        return null;
    }

    public UsbDevice findDevice(short vendorId, short productId) {
        return this.findDevice((UsbHub)this.getUsbRootHoob(), vendorId, productId);
    }

    public UsbDevice findDevice(UsbHub hub, short vendorId, short productId) {
        Iterator var4 = hub.getAttachedUsbDevices().iterator();

        while(var4.hasNext()) {
            UsbDevice device = (UsbDevice)var4.next();
            UsbDeviceDescriptor desc = device.getUsbDeviceDescriptor();
            if (desc.idVendor() == vendorId && desc.idProduct() == productId) {
                return device;
            }

            if (device.isUsbHub()) {
                device = this.findDevice((UsbHub)device, vendorId, productId);
                if (device != null) {
                    return device;
                }
            }
        }

        return null;
    }

    public void readMessage(UsbInterface iface, int endPoint) {
        UsbPipe pipe = null;

        try {
            iface.claim(new UsbInterfacePolicy() {
                public boolean forceClaim(UsbInterface usbInterface) {
                    return true;
                }
            });
            UsbEndpoint endpoint = (UsbEndpoint)iface.getUsbEndpoints().get(endPoint);
            pipe = endpoint.getUsbPipe();
            pipe.open();
            byte[] data = new byte[8];
            int received = pipe.syncSubmit(data);
            System.out.println("" + received + " bytes received");
            pipe.close();
        } catch (Exception var27) {
            var27.printStackTrace();
        } finally {
            try {
                iface.release();
            } catch (UsbClaimException var23) {
                var23.printStackTrace();
            } catch (UsbNotActiveException var24) {
                var24.printStackTrace();
            } catch (UsbDisconnectedException var25) {
                var25.printStackTrace();
            } catch (UsbException var26) {
                var26.printStackTrace();
            }

        }

    }

    public void readMessageAsynch(UsbInterface iface, int endPoint) {
        UsbPipe pipe = null;

        try {
            iface.claim(new UsbInterfacePolicy() {
                public boolean forceClaim(UsbInterface usbInterface) {
                    return true;
                }
            });
            UsbEndpoint endpoint = (UsbEndpoint)iface.getUsbEndpoints().get(endPoint);
            pipe = endpoint.getUsbPipe();
            pipe.open();
            pipe.addUsbPipeListener(new UsbPipeListener() {
                public void errorEventOccurred(UsbPipeErrorEvent event) {
                    UsbException error = event.getUsbException();
                    error.printStackTrace();
                }

                public void dataEventOccurred(UsbPipeDataEvent event) {
                    USBJava.this.data = event.getData();
                    System.out.println(USBJava.this.data + " bytes received");
                }
            });
        } catch (Exception var25) {
            var25.printStackTrace();
        } finally {
            try {
                iface.release();
            } catch (UsbClaimException var21) {
                var21.printStackTrace();
            } catch (UsbNotActiveException var22) {
                var22.printStackTrace();
            } catch (UsbDisconnectedException var23) {
                var23.printStackTrace();
            } catch (UsbException var24) {
                var24.printStackTrace();
            }

        }

    }

    public UsbInterface getDeviceInterface(UsbDevice device, int index) {
        UsbConfiguration configuration = device.getActiveUsbConfiguration();
        UsbInterface iface = (UsbInterface)configuration.getUsbInterfaces().get(index);
        return iface;
    }

    public void sendBulkMessage(UsbInterface iface, byte[] message, int index) {
        UsbPipe pipe = null;

        try {
            iface.claim(new UsbInterfacePolicy() {
                public boolean forceClaim(UsbInterface usbInterface) {
                    return true;
                }
            });
            UsbEndpoint endpoint = (UsbEndpoint)iface.getUsbEndpoints().get(index);
            pipe = endpoint.getUsbPipe();
            pipe.open();
            int sent = pipe.syncSubmit(message);
            System.out.println("" + sent + " bytes sent");
            pipe.close();
        } catch (Exception var27) {
            var27.printStackTrace();
        } finally {
            try {
                iface.release();
            } catch (UsbClaimException var23) {
                var23.printStackTrace();
            } catch (UsbNotActiveException var24) {
                var24.printStackTrace();
            } catch (UsbDisconnectedException var25) {
                var25.printStackTrace();
            } catch (UsbException var26) {
                var26.printStackTrace();
            }

        }

    }
}
