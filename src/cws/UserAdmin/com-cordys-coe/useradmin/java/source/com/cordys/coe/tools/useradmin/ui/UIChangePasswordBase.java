/*
  This class has been generated by the Code Generator
*/

package com.cordys.coe.tools.useradmin.ui;

import com.cordys.cpc.bsf.busobject.BusObjectConfig;
import com.cordys.cpc.bsf.classinfo.AttributeInfo;
import com.cordys.cpc.bsf.classinfo.ClassInfo;
import com.cordys.cpc.bsf.listeners.constraint.NumberValidator;


public abstract class UIChangePasswordBase extends com.cordys.cpc.bsf.busobject.CustomBusObject
{
    // tags used in the XML document
    public final static String ATTR_OldPasswordHA = "OldPasswordHA";
    public final static String ATTR_OldPassword = "OldPassword";
    public final static String ATTR_NewPassword = "NewPassword";
    public final static String ATTR_ConfirmPassword = "ConfirmPassword";
    public final static String ATTR_PasswordChanged = "PasswordChanged";
    private static ClassInfo s_classInfo = null;
    public static ClassInfo _getClassInfo()//NOPMD framework ensures this is thread safe
    {
        if ( s_classInfo == null )//NOPMD
        {
            s_classInfo = newClassInfo(UIChangePassword.class);
            s_classInfo.setUIDElements(new String[]{});
            {
                AttributeInfo ai = new AttributeInfo(ATTR_OldPasswordHA);
                ai.setJavaName(ATTR_OldPasswordHA);
                ai.setAttributeClass(int.class);
                NumberValidator v = new NumberValidator(ATTR_OldPasswordHA);
                ai.addConstraintHandler(v);
                s_classInfo.addAttributeInfo(ai);
            }
            {
                AttributeInfo ai = new AttributeInfo(ATTR_OldPassword);
                ai.setJavaName(ATTR_OldPassword);
                ai.setAttributeClass(String.class);
                s_classInfo.addAttributeInfo(ai);
            }
            {
                AttributeInfo ai = new AttributeInfo(ATTR_NewPassword);
                ai.setJavaName(ATTR_NewPassword);
                ai.setAttributeClass(String.class);
                s_classInfo.addAttributeInfo(ai);
            }
            {
                AttributeInfo ai = new AttributeInfo(ATTR_ConfirmPassword);
                ai.setJavaName(ATTR_ConfirmPassword);
                ai.setAttributeClass(String.class);
                s_classInfo.addAttributeInfo(ai);
            }
            {
                AttributeInfo ai = new AttributeInfo(ATTR_PasswordChanged);
                ai.setJavaName(ATTR_PasswordChanged);
                ai.setAttributeClass(boolean.class);
                s_classInfo.addAttributeInfo(ai);
            }
        }
        return s_classInfo;
    }

    public UIChangePasswordBase(BusObjectConfig config)
    {
        super(config);
    }

    public int getOldPasswordHA()
    {
        return getIntProperty(ATTR_OldPasswordHA);
    }

    public void setOldPasswordHA(int value)
    {
        setProperty(ATTR_OldPasswordHA, value, 0);
    }

    public String getOldPassword()
    {
        return getStringProperty(ATTR_OldPassword);
    }

    public void setOldPassword(String value)
    {
        setProperty(ATTR_OldPassword, value, 0);
    }

    public String getNewPassword()
    {
        return getStringProperty(ATTR_NewPassword);
    }

    public void setNewPassword(String value)
    {
        setProperty(ATTR_NewPassword, value, 0);
    }

    public String getConfirmPassword()
    {
        return getStringProperty(ATTR_ConfirmPassword);
    }

    public void setConfirmPassword(String value)
    {
        setProperty(ATTR_ConfirmPassword, value, 0);
    }

    public boolean getPasswordChanged()
    {
        return getBooleanProperty(ATTR_PasswordChanged);
    }

    public void setPasswordChanged(boolean value)
    {
        setProperty(ATTR_PasswordChanged, value, 0);
    }


}
