// Helper class generated by xrpcc, do not edit.
// Contents subject to change without notice.

package com.skywin.webserviceclients.uip;

import com.sun.xml.rpc.encoding.*;
import java.lang.IllegalArgumentException;

public class UIPServiceIF_getUserInfoByOUID_RequestStruct_SOAPBuilder implements SOAPInstanceBuilder {
    private UIPServiceIF_getUserInfoByOUID_RequestStruct _instance;
    private int int_1;
    private boolean boolean_2;
    private java.lang.String string_3;
    private java.lang.String string_4;
    private static final int myINT_1_INDEX = 0;
    private static final int myBOOLEAN_2_INDEX = 1;
    private static final int mySTRING_3_INDEX = 2;
    private static final int mySTRING_4_INDEX = 3;
    
    public UIPServiceIF_getUserInfoByOUID_RequestStruct_SOAPBuilder() {
    }
    
    public void setInt_1(int int_1) {
        this.int_1 = int_1;
    }
    
    public void setBoolean_2(boolean boolean_2) {
        this.boolean_2 = boolean_2;
    }
    
    public void setString_3(java.lang.String string_3) {
        this.string_3 = string_3;
    }
    
    public void setString_4(java.lang.String string_4) {
        this.string_4 = string_4;
    }
    
    public int memberGateType(int memberIndex) {
        switch (memberIndex) {
            case mySTRING_3_INDEX:
                return GATES_INITIALIZATION | REQUIRES_CREATION;
            case mySTRING_4_INDEX:
                return GATES_INITIALIZATION | REQUIRES_CREATION;
            default:
                throw new IllegalArgumentException();
        }
    }
    
    public void construct() {
    }
    
    public void setMember(int index, Object memberValue) {
        switch(index) {
            case mySTRING_3_INDEX:
                _instance.setString_3((java.lang.String)memberValue);
                break;
            case mySTRING_4_INDEX:
                _instance.setString_4((java.lang.String)memberValue);
                break;
            default:
                throw new IllegalArgumentException();
        }
    }
    
    public void initialize() {
    }
    
    public void setInstance(Object instance) {
        _instance = (UIPServiceIF_getUserInfoByOUID_RequestStruct)instance;
    }
    
    public Object getInstance() {
        return _instance;
    }
}
