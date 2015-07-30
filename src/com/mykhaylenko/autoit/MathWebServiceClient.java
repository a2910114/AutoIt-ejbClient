package com.mykhaylenko.autoit;

import java.rmi.RemoteException;

import org.apache.axis.AxisFault;

import com.mykhaylenko.ejb.session.service.impl.MathBeanImplProxy;

public class MathWebServiceClient {

    public static void main(String[] args) throws AxisFault {
        MathBeanImplProxy proxy = new MathBeanImplProxy();
        try {
            System.out.println(proxy.add(2, 2));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
