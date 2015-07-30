package com.mykhaylenko.ejb.session.service.impl;

public class MathBeanImplProxy implements com.mykhaylenko.ejb.session.service.impl.MathBeanImpl {
  private String _endpoint = null;
  private com.mykhaylenko.ejb.session.service.impl.MathBeanImpl mathBeanImpl = null;
  
  public MathBeanImplProxy() {
    _initMathBeanImplProxy();
  }
  
  public MathBeanImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initMathBeanImplProxy();
  }
  
  private void _initMathBeanImplProxy() {
    try {
      mathBeanImpl = (new com.mykhaylenko.ejb.session.service.impl.MathServiceLocator()).getMathBeanImplPort();
      if (mathBeanImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)mathBeanImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)mathBeanImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (mathBeanImpl != null)
      ((javax.xml.rpc.Stub)mathBeanImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.mykhaylenko.ejb.session.service.impl.MathBeanImpl getMathBeanImpl() {
    if (mathBeanImpl == null)
      _initMathBeanImplProxy();
    return mathBeanImpl;
  }
  
  public int add(int arg0, int arg1) throws java.rmi.RemoteException{
    if (mathBeanImpl == null)
      _initMathBeanImplProxy();
    return mathBeanImpl.add(arg0, arg1);
  }
  
  public int multiply(int arg0, int arg1) throws java.rmi.RemoteException{
    if (mathBeanImpl == null)
      _initMathBeanImplProxy();
    return mathBeanImpl.multiply(arg0, arg1);
  }
  
  public java.lang.String getHello() throws java.rmi.RemoteException{
    if (mathBeanImpl == null)
      _initMathBeanImplProxy();
    return mathBeanImpl.getHello();
  }
  
  
}