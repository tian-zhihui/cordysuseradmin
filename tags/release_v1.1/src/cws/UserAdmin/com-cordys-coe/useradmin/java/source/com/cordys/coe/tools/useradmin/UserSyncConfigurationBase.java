/*
  This class has been generated by the Code Generator
*/

package com.cordys.coe.tools.useradmin;

import com.cordys.cpc.bsf.busobject.BusObjectConfig;
import com.cordys.cpc.bsf.busobject.BusObjectIterator;
import com.cordys.cpc.bsf.classinfo.AttributeInfo;
import com.cordys.cpc.bsf.classinfo.ClassInfo;
import com.cordys.cpc.bsf.classinfo.RelationInfo_Composite;


public abstract class UserSyncConfigurationBase extends com.cordys.cpc.bsf.busobject.CustomBusObject
{
    // tags used in the XML document
    public final static String ATTR_IncludeSubgroups = "IncludeSubgroups";
    public final static String ATTR_DeleteObsoleteUsers = "DeleteObsoleteUsers";
    private final static String REL_Groups = "COMP:Groups";
    private final static String REL_MaintainUsers = "COMP:MaintainUsers";
    private static ClassInfo s_classInfo = null;
    public static ClassInfo _getClassInfo()//NOPMD framework ensures this is thread safe
    {
        if ( s_classInfo == null )//NOPMD
        {
            s_classInfo = newClassInfo(UserSyncConfiguration.class);
            s_classInfo.setUIDElements(new String[]{});
            {
                AttributeInfo ai = new AttributeInfo(ATTR_IncludeSubgroups);
                ai.setJavaName(ATTR_IncludeSubgroups);
                ai.setAttributeClass(boolean.class);
                s_classInfo.addAttributeInfo(ai);
            }
            {
                AttributeInfo ai = new AttributeInfo(ATTR_DeleteObsoleteUsers);
                ai.setJavaName(ATTR_DeleteObsoleteUsers);
                ai.setAttributeClass(boolean.class);
                s_classInfo.addAttributeInfo(ai);
            }
            {
                RelationInfo_Composite ri = new RelationInfo_Composite(REL_Groups);
                ri.setName("Groups");
                ri.setMultiOcc(false);
                ri.setRelatedClass(com.cordys.coe.tools.useradmin.UserSyncConfiguration.Groups.class);
                s_classInfo.addRelationInfo(ri);
            }
            {
                RelationInfo_Composite ri = new RelationInfo_Composite(REL_MaintainUsers);
                ri.setName("MaintainUsers");
                ri.setMultiOcc(false);
                ri.setRelatedClass(com.cordys.coe.tools.useradmin.UserSyncConfiguration.MaintainUsers.class);
                s_classInfo.addRelationInfo(ri);
            }
        }
        return s_classInfo;
    }

    public UserSyncConfigurationBase(BusObjectConfig config)
    {
        super(config);
    }

    public boolean getIncludeSubgroups()
    {
        return getBooleanProperty(ATTR_IncludeSubgroups);
    }

    public void setIncludeSubgroups(boolean value)
    {
        setProperty(ATTR_IncludeSubgroups, value, 0);
    }

    public boolean getDeleteObsoleteUsers()
    {
        return getBooleanProperty(ATTR_DeleteObsoleteUsers);
    }

    public void setDeleteObsoleteUsers(boolean value)
    {
        setProperty(ATTR_DeleteObsoleteUsers, value, 0);
    }

    public UserSyncConfiguration.Groups getGroupsObject()
    {
        return (UserSyncConfiguration.Groups)getSingleRelationObject(REL_Groups);
    }

    public UserSyncConfiguration.Groups setGroupsObject(UserSyncConfiguration.Groups a_Groups)
    {
        return(UserSyncConfiguration.Groups)_getSingleRelation(REL_Groups, true).setLocalObject(a_Groups);
    }

    public UserSyncConfiguration.MaintainUsers getMaintainUsersObject()
    {
        return (UserSyncConfiguration.MaintainUsers)getSingleRelationObject(REL_MaintainUsers);
    }

    public UserSyncConfiguration.MaintainUsers setMaintainUsersObject(UserSyncConfiguration.MaintainUsers a_MaintainUsers)
    {
        return(UserSyncConfiguration.MaintainUsers)_getSingleRelation(REL_MaintainUsers, true).setLocalObject(a_MaintainUsers);
    }


    public static abstract class GroupsBase extends com.cordys.cpc.bsf.busobject.CustomBusObject
    {
        // tags used in the XML document
        private final static String REL_Group = "COMP:Group";
        private static ClassInfo s_classInfo = null;
        public static ClassInfo _getClassInfo()//NOPMD framework ensures this is thread safe
        {
            if ( s_classInfo == null )//NOPMD
            {
                s_classInfo = newClassInfo(UserSyncConfiguration.Groups.class);
                s_classInfo.setUIDElements(new String[]{});
                {
                    RelationInfo_Composite ri = new RelationInfo_Composite(REL_Group);
                    ri.setName("Group");
                    ri.setMultiOcc(true);
                    ri.setRelatedClass(com.cordys.coe.tools.useradmin.UserSyncConfiguration.Groups.Group.class);
                    s_classInfo.addRelationInfo(ri);
                }
            }
            return s_classInfo;
        }

        public GroupsBase(BusObjectConfig config)
        {
            super(config);
        }

        public BusObjectIterator<UserSyncConfiguration.Groups.Group> getGroupObjects()
        {
            return getMultiRelationObjects(REL_Group);
        }

        public UserSyncConfiguration.Groups.Group addGroupObject(UserSyncConfiguration.Groups.Group a_Group)
        {
            return (UserSyncConfiguration.Groups.Group)_getMultiRelation(REL_Group, true).addObject(a_Group);
        }

        public void removeGroupObject(UserSyncConfiguration.Groups.Group a_Group)
        {
            _getMultiRelation(REL_Group, true).removeObject(a_Group);
        }

        public static abstract class GroupBase extends com.cordys.cpc.bsf.busobject.CustomBusObject
        {
            // tags used in the XML document
            public final static String ATTR_DN = "DN";
            public final static String ATTR_UserSearchRoot = "UserSearchRoot";
            private final static String REL_AssignRoles = "COMP:AssignRoles";
            private static ClassInfo s_classInfo = null;
            public static ClassInfo _getClassInfo()//NOPMD framework ensures this is thread safe
            {
                if ( s_classInfo == null )//NOPMD
                {
                    s_classInfo = newClassInfo(UserSyncConfiguration.Groups.Group.class);
                    s_classInfo.setUIDElements(new String[]{});
                    {
                        AttributeInfo ai = new AttributeInfo(ATTR_DN);
                        ai.setJavaName(ATTR_DN);
                        ai.setAttributeClass(String.class);
                        s_classInfo.addAttributeInfo(ai);
                    }
                    {
                        AttributeInfo ai = new AttributeInfo(ATTR_UserSearchRoot);
                        ai.setJavaName(ATTR_UserSearchRoot);
                        ai.setAttributeClass(String.class);
                        s_classInfo.addAttributeInfo(ai);
                    }
                    {
                        RelationInfo_Composite ri = new RelationInfo_Composite(REL_AssignRoles);
                        ri.setName("AssignRoles");
                        ri.setMultiOcc(false);
                        ri.setRelatedClass(com.cordys.coe.tools.useradmin.UserSyncConfiguration.Groups.Group.AssignRoles.class);
                        s_classInfo.addRelationInfo(ri);
                    }
                }
                return s_classInfo;
            }

            public GroupBase(BusObjectConfig config)
            {
                super(config);
            }

            public String getDN()
            {
                return getStringProperty(ATTR_DN);
            }

            public void setDN(String value)
            {
                setProperty(ATTR_DN, value, 0);
            }

            public String getUserSearchRoot()
            {
                return getStringProperty(ATTR_UserSearchRoot);
            }

            public void setUserSearchRoot(String value)
            {
                setProperty(ATTR_UserSearchRoot, value, 0);
            }

            public UserSyncConfiguration.Groups.Group.AssignRoles getAssignRolesObject()
            {
                return (UserSyncConfiguration.Groups.Group.AssignRoles)getSingleRelationObject(REL_AssignRoles);
            }

            public UserSyncConfiguration.Groups.Group.AssignRoles setAssignRolesObject(UserSyncConfiguration.Groups.Group.AssignRoles a_AssignRoles)
            {
                return(UserSyncConfiguration.Groups.Group.AssignRoles)_getSingleRelation(REL_AssignRoles, true).setLocalObject(a_AssignRoles);
            }

            public static abstract class AssignRolesBase extends com.cordys.cpc.bsf.busobject.CustomBusObject
            {
                // tags used in the XML document
                private final static String REL_Role = "COMP:Role";
                private static ClassInfo s_classInfo = null;
                public static ClassInfo _getClassInfo()//NOPMD framework ensures this is thread safe
                {
                    if ( s_classInfo == null )//NOPMD
                    {
                        s_classInfo = newClassInfo(UserSyncConfiguration.Groups.Group.AssignRoles.class);
                        s_classInfo.setUIDElements(new String[]{});
                        {
                            RelationInfo_Composite ri = new RelationInfo_Composite(REL_Role);
                            ri.setName("Role");
                            ri.setMultiOcc(true);
                            ri.setRelatedClass(com.cordys.coe.tools.useradmin.UserSyncConfiguration.Groups.Group.AssignRoles.Role.class);
                            s_classInfo.addRelationInfo(ri);
                        }
                    }
                    return s_classInfo;
                }

                public AssignRolesBase(BusObjectConfig config)
                {
                    super(config);
                }

                public BusObjectIterator<UserSyncConfiguration.Groups.Group.AssignRoles.Role> getRoleObjects()
                {
                    return getMultiRelationObjects(REL_Role);
                }

                public UserSyncConfiguration.Groups.Group.AssignRoles.Role addRoleObject(UserSyncConfiguration.Groups.Group.AssignRoles.Role a_Role)
                {
                    return (UserSyncConfiguration.Groups.Group.AssignRoles.Role)_getMultiRelation(REL_Role, true).addObject(a_Role);
                }

                public void removeRoleObject(UserSyncConfiguration.Groups.Group.AssignRoles.Role a_Role)
                {
                    _getMultiRelation(REL_Role, true).removeObject(a_Role);
                }

                public static abstract class RoleBase extends com.cordys.cpc.bsf.busobject.CustomBusObject
                {
                    // tags used in the XML document
                    public final static String ATTR_Value = "Value";
                    private static ClassInfo s_classInfo = null;
                    public static ClassInfo _getClassInfo()//NOPMD framework ensures this is thread safe
                    {
                        if ( s_classInfo == null )//NOPMD
                        {
                            s_classInfo = newClassInfo(UserSyncConfiguration.Groups.Group.AssignRoles.Role.class);
                            s_classInfo.setUIDElements(new String[]{});
                            {
                                AttributeInfo ai = new AttributeInfo(ATTR_Value);
                                ai.setJavaName(ATTR_Value);
                                ai.setAttributeClass(String.class);
                                s_classInfo.addAttributeInfo(ai);
                            }
                        }
                        return s_classInfo;
                    }

                    public RoleBase(BusObjectConfig config)
                    {
                        super(config);
                    }

                    public String getValue()
                    {
                        return getStringProperty(ATTR_Value);
                    }

                    public void setValue(String value)
                    {
                        setProperty(ATTR_Value, value, 0);
                    }

                }
            }
        }
    }
    public static abstract class MaintainUsersBase extends com.cordys.cpc.bsf.busobject.CustomBusObject
    {
        // tags used in the XML document
        public final static String ATTR_OnlyInsert = "OnlyInsert";
        private final static String REL_NewUserConfig = "COMP:NewUserConfig";
        private static ClassInfo s_classInfo = null;
        public static ClassInfo _getClassInfo()//NOPMD framework ensures this is thread safe
        {
            if ( s_classInfo == null )//NOPMD
            {
                s_classInfo = newClassInfo(UserSyncConfiguration.MaintainUsers.class);
                s_classInfo.setUIDElements(new String[]{});
                {
                    AttributeInfo ai = new AttributeInfo(ATTR_OnlyInsert);
                    ai.setJavaName(ATTR_OnlyInsert);
                    ai.setAttributeClass(boolean.class);
                    s_classInfo.addAttributeInfo(ai);
                }
                {
                    RelationInfo_Composite ri = new RelationInfo_Composite(REL_NewUserConfig);
                    ri.setName("NewUserConfig");
                    ri.setMultiOcc(false);
                    ri.setRelatedClass(com.cordys.coe.tools.useradmin.UserSyncConfiguration.MaintainUsers.NewUserConfig.class);
                    s_classInfo.addRelationInfo(ri);
                }
            }
            return s_classInfo;
        }

        public MaintainUsersBase(BusObjectConfig config)
        {
            super(config);
        }

        public boolean getOnlyInsert()
        {
            return getBooleanProperty(ATTR_OnlyInsert);
        }

        public void setOnlyInsert(boolean value)
        {
            setProperty(ATTR_OnlyInsert, value, 0);
        }

        public UserSyncConfiguration.MaintainUsers.NewUserConfig getNewUserConfigObject()
        {
            return (UserSyncConfiguration.MaintainUsers.NewUserConfig)getSingleRelationObject(REL_NewUserConfig);
        }

        public UserSyncConfiguration.MaintainUsers.NewUserConfig setNewUserConfigObject(UserSyncConfiguration.MaintainUsers.NewUserConfig a_NewUserConfig)
        {
            return(UserSyncConfiguration.MaintainUsers.NewUserConfig)_getSingleRelation(REL_NewUserConfig, true).setLocalObject(a_NewUserConfig);
        }

        public static abstract class NewUserConfigBase extends com.cordys.cpc.bsf.busobject.CustomBusObject
        {
            // tags used in the XML document
            public final static String ATTR_AuthenticationType = "AuthenticationType";
            public final static String ATTR_DefaultPassword = "DefaultPassword";
            private static ClassInfo s_classInfo = null;
            public static ClassInfo _getClassInfo()//NOPMD framework ensures this is thread safe
            {
                if ( s_classInfo == null )//NOPMD
                {
                    s_classInfo = newClassInfo(UserSyncConfiguration.MaintainUsers.NewUserConfig.class);
                    s_classInfo.setUIDElements(new String[]{});
                    {
                        AttributeInfo ai = new AttributeInfo(ATTR_AuthenticationType);
                        ai.setJavaName(ATTR_AuthenticationType);
                        ai.setAttributeClass(String.class);
                        s_classInfo.addAttributeInfo(ai);
                    }
                    {
                        AttributeInfo ai = new AttributeInfo(ATTR_DefaultPassword);
                        ai.setJavaName(ATTR_DefaultPassword);
                        ai.setAttributeClass(String.class);
                        s_classInfo.addAttributeInfo(ai);
                    }
                }
                return s_classInfo;
            }

            public NewUserConfigBase(BusObjectConfig config)
            {
                super(config);
            }

            public String getAuthenticationType()
            {
                return getStringProperty(ATTR_AuthenticationType);
            }

            public void setAuthenticationType(String value)
            {
                setProperty(ATTR_AuthenticationType, value, 0);
            }

            public String getDefaultPassword()
            {
                return getStringProperty(ATTR_DefaultPassword);
            }

            public void setDefaultPassword(String value)
            {
                setProperty(ATTR_DefaultPassword, value, 0);
            }

        }
    }
}