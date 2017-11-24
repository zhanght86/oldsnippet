// Decompiled by DJ v2.9.9.60 Copyright 2000 Atanas Neshkov  Date: 2003-11-13 19:14:33
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3)
// Source File Name:   Request.java

package com.sunrise.boss.web.common.batch.download;

import java.util.Enumeration;
import java.util.Hashtable;

import com.sunrise.boss.web.common.batch.download.*;

public class Request
{

    Request()
    {
        m_parameters = new Hashtable();
        m_counter = 0;
    }

    protected void putParameter(String s, String s1)
    {
        if(s == null)
            throw new IllegalArgumentException("The name of an element cannot be null.");
        if(m_parameters.containsKey(s))
        {
            Hashtable hashtable = (Hashtable)m_parameters.get(s);
            hashtable.put(new Integer(hashtable.size()), s1);
        } else
        {
            Hashtable hashtable1 = new Hashtable();
            hashtable1.put(new Integer(0), s1);
            m_parameters.put(s, hashtable1);
            m_counter++;
        }
    }

    public String getParameter(String s)
    {
        if(s == null)
            throw new IllegalArgumentException("Form's name is invalid or does not exist (1305).");
        Hashtable hashtable = (Hashtable)m_parameters.get(s);
        if(hashtable == null)
            return null;
        else
            return (String)hashtable.get(new Integer(0));
    }

    public Enumeration getParameterNames()
    {
        return m_parameters.keys();
    }

    public String[] getParameterValues(String s)
    {
        if(s == null)
            throw new IllegalArgumentException("Form's name is invalid or does not exist (1305).");
        Hashtable hashtable = (Hashtable)m_parameters.get(s);
        if(hashtable == null)
            return null;
        String as[] = new String[hashtable.size()];
        for(int i = 0; i < hashtable.size(); i++)
            as[i] = (String)hashtable.get(new Integer(i));

        return as;
    }

    private Hashtable m_parameters;
    private int m_counter;
}