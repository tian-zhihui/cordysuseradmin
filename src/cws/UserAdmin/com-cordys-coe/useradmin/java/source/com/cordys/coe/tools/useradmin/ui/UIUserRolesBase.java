/*
  This class has been generated by the Code Generator
*/

package com.cordys.coe.tools.useradmin.ui;

import com.cordys.cpc.bsf.busobject.BusObjectConfig;
import com.cordys.cpc.bsf.busobject.BusObjectIterator;
import com.cordys.cpc.bsf.classinfo.AttributeInfo;
import com.cordys.cpc.bsf.classinfo.ClassInfo;
import com.cordys.cpc.bsf.classinfo.RelationInfo_Composite;
import com.cordys.cpc.bsf.listeners.constraint.NumberValidator;


public abstract class UIUserRolesBase extends com.cordys.cpc.bsf.busobject.CustomBusObject
{
    // tags used in the XML document
    public final static String ATTR_OrgUserDN = "OrgUserDN";
    private final static String REL_Roles = "COMP:Roles";
    private static ClassInfo s_classInfo = null;
    public static ClassInfo _getClassInfo()//NOPMD framework ensures this is thread safe
    {
        if ( s_classInfo == null )//NOPMD
        {
            s_classInfo = newClassInfo(UIUserRoles.class);
            s_classInfo.setUIDElements(new String[]{ATTR_OrgUserDN});
            {
                AttributeInfo ai = new AttributeInfo(ATTR_OrgUserDN);
                ai.setJavaName(ATTR_OrgUserDN);
                ai.setAttributeClass(String.class);
                s_classInfo.addAttributeInfo(ai);
            }
            {
                RelationInfo_Composite ri = new RelationInfo_Composite(REL_Roles);
                ri.setName("Roles");
                ri.setMultiOcc(false);
                ri.setRelatedClass(com.cordys.coe.tools.useradmin.ui.UIUserRoles.Roles.class);
                s_classInfo.addRelationInfo(ri);
            }
        }
        return s_classInfo;
    }

    public UIUserRolesBase(BusObjectConfig config)
    {
        super(config);
    }

    public String getOrgUserDN()
    {
        return getStringProperty(ATTR_OrgUserDN);
    }

    public void setOrgUserDN(String value)
    {
        setProperty(ATTR_OrgUserDN, value, 0);
    }

    public UIUserRoles.Roles getRolesObject()
    {
        return (UIUserRoles.Roles)getSingleRelationObject(REL_Roles);
    }

    public UIUserRoles.Roles setRolesObject(UIUserRoles.Roles a_Roles)
    {
        return(UIUserRoles.Roles)_getSingleRelation(REL_Roles, true).setLocalObject(a_Roles);
    }



    public static abstract class RolesBase extends com.cordys.cpc.bsf.busobject.CustomBusObject
    {
        // tags used in the XML document
        private final static String REL_Role = "COMP:Role";
        private static ClassInfo s_classInfo = null;
        public static ClassInfo _getClassInfo()//NOPMD framework ensures this is thread safe
        {
            if ( s_classInfo == null )//NOPMD
            {
                s_classInfo = newClassInfo(UIUserRoles.Roles.class);
                s_classInfo.setUIDElements(new String[]{});
                {
                    RelationInfo_Composite ri = new RelationInfo_Composite(REL_Role);
                    ri.setName("Role");
                    ri.setMultiOcc(true);
                    ri.setRelatedClass(com.cordys.coe.tools.useradmin.ui.UIUserRoles.Roles.Role.class);
                    s_classInfo.addRelationInfo(ri);
                }
            }
            return s_classInfo;
        }

        public RolesBase(BusObjectConfig config)
        {
            super(config);
        }

        public BusObjectIterator<UIUserRoles.Roles.Role> getRoleObjects()
        {
            return getMultiRelationObjects(REL_Role);
        }

        public UIUserRoles.Roles.Role addRoleObject(UIUserRoles.Roles.Role a_Role)
        {
            return (UIUserRoles.Roles.Role)_getMultiRelation(REL_Role, true).addObject(a_Role);
        }

        public void removeRoleObject(UIUserRoles.Roles.Role a_Role)
        {
            _getMultiRelation(REL_Role, true).removeObject(a_Role);
        }

        public static abstract class RoleBase extends com.cordys.cpc.bsf.busobject.CustomBusObject
        {
            // tags used in the XML document
            public final static String ATTR_SeqNo = "SeqNo";
            public final static String ATTR_RoleDN = "RoleDN";
            public final static String ATTR_RoleName = "RoleName";
            public final static String ATTR_Assigned = "Assigned";
            private static ClassInfo s_classInfo = null;
            public static ClassInfo _getClassInfo()//NOPMD framework ensures this is thread safe
            {
                if ( s_classInfo == null )//NOPMD
                {
                    s_classInfo = newClassInfo(UIUserRoles.Roles.Role.class);
                    s_classInfo.setUIDElements(new String[]{});
                    {
                        AttributeInfo ai = new AttributeInfo(ATTR_SeqNo);
                        ai.setJavaName(ATTR_SeqNo);
                        ai.setAttributeClass(int.class);
                        NumberValidator v = new NumberValidator(ATTR_SeqNo);
                        ai.addConstraintHandler(v);
                        s_classInfo.addAttributeInfo(ai);
                    }
                    {
                        AttributeInfo ai = new AttributeInfo(ATTR_RoleDN);
                        ai.setJavaName(ATTR_RoleDN);
                        ai.setAttributeClass(String.class);
                        s_classInfo.addAttributeInfo(ai);
                    }
                    {
                        AttributeInfo ai = new AttributeInfo(ATTR_RoleName);
                        ai.setJavaName(ATTR_RoleName);
                        ai.setAttributeClass(String.class);
                        s_classInfo.addAttributeInfo(ai);
                    }
                    {
                        AttributeInfo ai = new AttributeInfo(ATTR_Assigned);
                        ai.setJavaName(ATTR_Assigned);
                        ai.setAttributeClass(boolean.class);
                        s_classInfo.addAttributeInfo(ai);
                    }
                }
                return s_classInfo;
            }

            public RoleBase(BusObjectConfig config)
            {
                super(config);
            }

            public int getSeqNo()
            {
                return getIntProperty(ATTR_SeqNo);
            }

            public void setSeqNo(int value)
            {
                setProperty(ATTR_SeqNo, value, 0);
            }

            public String getRoleDN()
            {
                return getStringProperty(ATTR_RoleDN);
            }

            public void setRoleDN(String value)
            {
                setProperty(ATTR_RoleDN, value, 0);
            }

            public String getRoleName()
            {
                return getStringProperty(ATTR_RoleName);
            }

            public void setRoleName(String value)
            {
                setProperty(ATTR_RoleName, value, 0);
            }

            public boolean getAssigned()
            {
                return getBooleanProperty(ATTR_Assigned);
            }

            public void setAssigned(boolean value)
            {
                setProperty(ATTR_Assigned, value, 0);
            }

        }
    }
}