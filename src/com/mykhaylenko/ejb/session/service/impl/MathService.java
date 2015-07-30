/**
 * MathService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.mykhaylenko.ejb.session.service.impl;

public interface MathService extends javax.xml.rpc.Service {
    public java.lang.String getMathBeanImplPortAddress();

    public com.mykhaylenko.ejb.session.service.impl.MathBeanImpl getMathBeanImplPort() throws javax.xml.rpc.ServiceException;

    public com.mykhaylenko.ejb.session.service.impl.MathBeanImpl getMathBeanImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
