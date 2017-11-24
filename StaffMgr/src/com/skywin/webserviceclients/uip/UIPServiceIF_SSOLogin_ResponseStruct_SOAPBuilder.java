// Helper class generated by xrpcc, do not edit.
// Contents subject to change without notice.

package com.skywin.webserviceclients.uip;

import com.sun.xml.rpc.encoding.*;
import java.lang.IllegalArgumentException;

public class UIPServiceIF_SSOLogin_ResponseStruct_SOAPBuilder implements SOAPInstanceBuilder {
    private UIPServiceIF_SSOLogin_ResponseStruct _instance;
    private com.skywin.webserviceclients.uip.AuthResult result;
    private static final int myRESULT_INDEX = 0;
    
    public UIPServiceIF_SSOLogin_ResponseStruct_SOAPBuilder() {
    }
    
    public void setResult(com.skywin.webserviceclients.uip.AuthResult result) {
        this.result = result;
    }
    
    public int memberGateType(int memberIndex) {
        switch (memberIndex) {
            case myRESULT_INDEX:
                return GATES_INITIALIZATION | REQUIRES_CREATION;
            default:
                throw new IllegalArgumentException();
        }
    }
    
    public void construct() {
    }
    
    public void setMember(int index, Object memberValue) {
        switch(index) {
            case myRESULT_INDEX:
                _instance.setResult((com.skywin.webserviceclients.uip.AuthResult)memberValue);
                break;
            default:
                throw new IllegalArgumentException();
        }
    }
    
    public void initialize() {
    }
    
    public void setInstance(Object instance) {
        _instance = (UIPServiceIF_SSOLogin_ResponseStruct)instance;
    }
    
    public Object getInstance() {
        return _instance;
    }
}
