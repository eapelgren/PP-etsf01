package user;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

import poker.Card_Interface;

public class User implements User_Interface {
	private String name;
	private InetAddress IP;
	
	public User() throws SocketException{
		this.name = name;
		this.IP = getFirstNonLoopbackAddress(true,false);
		
		
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Card_Interface getChoosenCard() {
		// TODO Auto-generated method stub
		return null;
	}



private static InetAddress getFirstNonLoopbackAddress(boolean preferIpv4, boolean preferIPv6) throws SocketException {
    Enumeration en = NetworkInterface.getNetworkInterfaces();
    while (en.hasMoreElements()) {
        NetworkInterface i = (NetworkInterface) en.nextElement();
        for (Enumeration en2 = i.getInetAddresses(); en2.hasMoreElements();) {
            InetAddress addr = (InetAddress) en2.nextElement();
            if (!addr.isLoopbackAddress()) {
                if (addr instanceof Inet4Address) {
                    if (preferIPv6) {
                        continue;
                    }
                    return addr;
                }
                if (addr instanceof Inet6Address) {
                    if (preferIpv4) {
                        continue;
                    }
                    return addr;
                }
            }
        }
    }
    return null;
}
}