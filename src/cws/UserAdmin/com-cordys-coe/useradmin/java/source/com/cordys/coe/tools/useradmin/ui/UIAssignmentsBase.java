/*
  This class has been generated by the Code Generator
*/

package com.cordys.coe.tools.useradmin.ui;

import com.cordys.cpc.bsf.busobject.BusObjectConfig;
import com.cordys.cpc.bsf.busobject.BusObjectIterator;
import com.cordys.cpc.bsf.classinfo.ClassInfo;
import com.cordys.cpc.bsf.classinfo.RelationInfo_Composite;


public abstract class UIAssignmentsBase extends com.cordys.cpc.bsf.busobject.CustomBusObject
{
    // tags used in the XML document
    private final static String REL_UIListItem = "AGGR:UIListItem";
    private static ClassInfo s_classInfo = null;
    public static ClassInfo _getClassInfo()//NOPMD framework ensures this is thread safe
    {
        if ( s_classInfo == null )//NOPMD
        {
            s_classInfo = newClassInfo(UIAssignments.class);
            s_classInfo.setUIDElements(new String[]{});
            {
                RelationInfo_Composite ri = new RelationInfo_Composite(REL_UIListItem);
                ri.setName("UIListItem");
                ri.setMultiOcc(true);
                ri.setRelatedClass(com.cordys.coe.tools.useradmin.ui.UIListItem.class);
                s_classInfo.addRelationInfo(ri);
            }
        }
        return s_classInfo;
    }

    public UIAssignmentsBase(BusObjectConfig config)
    {
        super(config);
    }

    public BusObjectIterator<UIListItem> getUIListItemObjects()
    {
        return getMultiRelationObjects(REL_UIListItem);
    }

    public UIListItem addUIListItemObject(UIListItem a_UIListItem)
    {
        return (UIListItem)_getMultiRelation(REL_UIListItem, true).addObject(a_UIListItem);
    }

    public void removeUIListItemObject(UIListItem a_UIListItem)
    {
        _getMultiRelation(REL_UIListItem, true).removeObject(a_UIListItem);
    }

}