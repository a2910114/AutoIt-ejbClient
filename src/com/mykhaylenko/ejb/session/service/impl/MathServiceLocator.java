/**
 * MathServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.mykhaylenko.ejb.session.service.impl;

public class MathServiceLocator extends org.apache.axis.client.Service implements com.mykhaylenko.ejb.session.service.impl.MathService {

    public MathServiceLocator() {
    }


    public MathServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public MathServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for MathBeanImplPort
    private java.lang.String MathBeanImplPort_address = "http://10.105.30.58:7004/MathBeanImpl/MathService";

    public java.lang.String getMathBeanImplPortAddress() {
        return MathBeanImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String MathBeanImplPortWSDDServiceName = "MathBeanImplPort";

    public java.lang.String getMathBeanImplPortWSDDServiceName() {
        return MathBeanImplPortWSDDServiceName;
    }

    public void setMathBeanImplPortWSDDServiceName(java.lang.String name) {
        MathBeanImplPortWSDDServiceName = name;
    }

    public com.mykhaylenko.ejb.session.service.impl.MathBeanImpl getMathBeanImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(MathBeanImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getMathBeanImplPort(endpoint);
    }

    public com.mykhaylenko.ejb.session.service.impl.MathBeanImpl getMathBeanImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.mykhaylenko.ejb.session.service.impl.MathBeanImplPortBindingStub _stub = new com.mykhaylenko.ejb.session.service.impl.MathBeanImplPortBindingStub(portAddress, this);
            _stub.setPortName(getMathBeanImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setMathBeanImplPortEndpointAddress(java.lang.String address) {
        MathBeanImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.mykhaylenko.ejb.session.service.impl.MathBeanImpl.class.isAssignableFrom(serviceEndpointInterface)) {
                com.mykhaylenko.ejb.session.service.impl.MathBeanImplPortBindingStub _stub = new com.mykhaylenko.ejb.session.service.impl.MathBeanImplPortBindingStub(new java.net.URL(MathBeanImplPort_address), this);
                _stub.setPortName(getMathBeanImplPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("MathBeanImplPort".equals(inputPortName)) {
            return getMathBeanImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://impl.service.session.ejb.mykhaylenko.com/", "MathService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://impl.service.session.ejb.mykhaylenko.com/", "MathBeanImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("MathBeanImplPort".equals(portName)) {
            setMathBeanImplPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
