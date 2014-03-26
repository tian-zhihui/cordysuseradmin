/*
  This class has been generated by the Code Generator
*/

package com.cordys.coe.tools.useradmin.ui;

import java.util.ArrayList;
import java.util.Vector;

import com.cordys.coe.tools.useradmin.cordys.CordysObject;
import com.cordys.coe.tools.useradmin.cordys.CordysObjectList;
import com.cordys.coe.tools.useradmin.cordys.CordysUser;
import com.cordys.coe.tools.useradmin.cordys.Organization;
import com.cordys.coe.tools.useradmin.cordys.Task;
import com.cordys.coe.tools.useradmin.cordys.TeamAssignment;
import com.cordys.coe.tools.useradmin.exception.UserAdminException;
import com.cordys.coe.tools.useradmin.util.Util;
import com.cordys.cpc.bsf.busobject.BSF;
import com.cordys.cpc.bsf.busobject.BusObjectArray;
import com.cordys.cpc.bsf.busobject.BusObjectConfig;
import com.cordys.cpc.bsf.busobject.BusObjectIterator;
import com.cordys.cpc.bsf.event.AccessMode;
import com.cordys.cpc.bsf.event.AfterAttributeChangeEvent;
import com.cordys.cpc.bsf.event.AttributeValuesEvent;
import com.cordys.cpc.bsf.event.ObjectAccessEvent;
import com.cordys.cpc.bsf.event.ObjectConstraintEvent;
import com.cordys.cpc.bsf.event.ObjectInitializeEvent;
import com.cordys.cpc.bsf.event.StdTriggers;


/**
 * UI class to support maintenance of Cordys users.
 * 
 * @author kekema
 *
 */
public class UIUser extends UIUserBase
{
	static final int UA_DISABLE_USERS = 10;
	static final int UA_ENABLE_USERS = 20;
	static final int UA_UPDATE_COMPANY = 30;	
	static final int UA_UPDATE_ADDRESS = 40;
	static final int UA_UPDATE_TELEPHONE= 50;
	static final int UA_UPDATE_TELEPHONE2= 60;
	
	private boolean userID_Changed = false;
	
    public UIUser()
    {
        this((BusObjectConfig)null);
    }

    public UIUser(BusObjectConfig config)
    {
        super(config);
    }
    
    @Override
    protected void onInitialize(ObjectInitializeEvent context) 
    {
    	super.onInitialize(context);    	
    	
    	String cloneOrgUserDN = this.getCloneOrgUserDN();
    	if (Util.isSet(cloneOrgUserDN))
    	{
        	CordysUser cloneCordysUser = CordysUser.getCordysUser(cloneOrgUserDN);
        	if (cloneCordysUser != null)
        	{    	
        		this.setAuthenticationType(cloneCordysUser.getAuthenticationType());
        		this.setDisabled(!cloneCordysUser.getEnable());
        		this.setDefaultOrg(cloneCordysUser.getDefaultcontext());
        		this.setCompany(cloneCordysUser.getCompany());
        		this.setAddress(cloneCordysUser.getRegisteredAddress());
        		this.setTelephone(cloneCordysUser.getTelephoneNumber());
        		this.setTelephone2(cloneCordysUser.getFacsimileTelephoneNumber());
        		this.setEmail(cloneCordysUser.getEmail());
        		this.setUserHomePage(cloneCordysUser.getLabeledURI());     
        		this.setCloneRoles(false);
        		this.setCloneTasks(false);
        		this.setCloneTeams(false);
        	}
    	}
    } 
    
    public void onValues_DefaultOrg(AttributeValuesEvent event)
    {
    	boolean inSystemOrg = inSystemOrg();
    	ArrayList<Organization> organizations = Organization.getOrganizationsForUser(this.getOrgUserDN());
    	for (Organization organization : organizations)
    	{
    		if (inSystemOrg || organization.getDefaultOrg())
    		{
    			event.addValue(organization.getDN(), organization.getDescription());
    		}
    	}
    }
    
    public void onAfterChange_UserID(AfterAttributeChangeEvent event)
    {
    	userID_Changed = true;
    }
    
    private boolean inSystemOrg()
    {
    	return(BSF.getOrganization().startsWith("o=system"));
    }

    /**
     * Get all Cordys users for current organization.
     * 
     * @return
     */
    public static BusObjectIterator<UIUser> getUIUserObjects()
    {
    	Vector<UIUser> result = new Vector<UIUser>();

    	String currentUser = BSF.getUser();
    	// query cordys org users
    	ArrayList<CordysUser> cordysUsers = CordysUser.getCordysUsers(null);
    	// put current user first
    	for (CordysUser cordysUser : cordysUsers)
    	{
    		if (cordysUser.getOrgUserDN().equals(currentUser))
    		{
   				result.add(constructUIUser(cordysUser));
   				break;
    		}
    	}
    	for (CordysUser cordysUser : cordysUsers)
    	{
    		if (!cordysUser.getOrgUserDN().equals(currentUser))
    		{ 	
  			
    			result.add(constructUIUser(cordysUser));
    		}
    	}
        return new BusObjectArray<UIUser>(result);
    }
    
    /**
     * Get UIUser
     * 
     * @param orgUserDN
     * @return
     */
    public static UIUser getUIUserObject(String orgUserDN)
    {
    	UIUser result = null;
    	CordysUser cordysUser = CordysUser.getCordysUser(orgUserDN);
    	if (cordysUser != null)
    	{
    		result = constructUIUser(cordysUser);
    	}
        return result;
    }
    
    private static UIUser constructUIUser(CordysUser cordysUser)
    {
		UIUser uiUser = new UIUser();
		uiUser.makeTransient();
		uiUser.setOrgUserDN(cordysUser.getOrgUserDN());
		uiUser.setAuthUserDN(cordysUser.getAuthUserDN());
		uiUser.setUserName(cordysUser.getCN());
		uiUser.setFullUserName(cordysUser.getDescription());
		uiUser.setUserID(cordysUser.getOSIdentity());
		// compose description from full user name + osidentity for non-anonymous users
		if ("anonymous".equals(cordysUser.getDescription()))
		{
			uiUser.setDescription(cordysUser.getDescription());
		}
		else
		{
			uiUser.setDescription(cordysUser.getDescription() + " (" + cordysUser.getOSIdentity() + ")");
		}
		uiUser.setAuthenticationType(cordysUser.getAuthenticationType());
		uiUser.setUserPassword(cordysUser.getUserPassword());
		uiUser.setConfirmPassword(cordysUser.getUserPassword());
		uiUser.setDisabled(!cordysUser.getEnable());
		uiUser.setDefaultOrg(cordysUser.getDefaultcontext());
		uiUser.setCompany(cordysUser.getCompany());
		uiUser.setAddress(cordysUser.getRegisteredAddress());
		uiUser.setTelephone(cordysUser.getTelephoneNumber());
		uiUser.setTelephone2(cordysUser.getFacsimileTelephoneNumber());
		uiUser.setEmail(cordysUser.getEmail());
		uiUser.setUserHomePage(cordysUser.getLabeledURI());
		return uiUser;
    }
    
    /**
     * Set access levels
     */
    public void onDisplay(ObjectAccessEvent event)
    {
    	String authenticationType = this.getAuthenticationType();
    	if (CordysUser.AT_CERTIFIED.equals(authenticationType))
    	{
    		event.setAccess(ATTR_UserID, AccessMode.READONLY);
    	}
    	if (CordysUser.AT_DOMAIN.equals(authenticationType))
    	{
    		event.setAccess(ATTR_UserPassword, AccessMode.HIDE);
    		event.setAccess(ATTR_ConfirmPassword, AccessMode.HIDE);
    	}
    	if (!inSystemOrg() || (!Util.isSet(this.getOrgUserDN())))
    	{
    		event.setAccess(ATTR_DefaultOrg, AccessMode.READONLY);
    	}
    	if (BSF.getUser().equals(this.getOrgUserDN()))
    	{
    		event.setAccess(ATTR_Disabled, AccessMode.READONLY);
    	}
    	String cloneOrgUserDN = this.getCloneOrgUserDN();
    	if (!Util.isSet(cloneOrgUserDN))
    	{
    		event.setAccess(ATTR_CloneRoles, AccessMode.HIDE);
    		event.setAccess(ATTR_CloneTasks, AccessMode.HIDE);
    		event.setAccess(ATTR_CloneTeams, AccessMode.HIDE);
    	}
    }
    
    @Override protected void onConstraint(ObjectConstraintEvent event)
    {
    	boolean differentUserID = userID_Changed;
    	if ((userID_Changed) && (this.getOriginalObject() != null))
    	{
    		UIUser oldUser = (UIUser)this.getOriginalObject();
    		String oldUserID = oldUser.getUserID();
    		if (Util.isSet(oldUserID) && oldUserID.equals(this.getUserID()))
    		{
    			differentUserID = false;
    		}
    	}
    	if (differentUserID || event.triggeredBy(StdTriggers.INSERT_OBJECT))
    	{
	    	String userID = this.getUserID();
	    	if (Util.isSet(userID))
	    	{
	    		CordysUser cordysUser = CordysUser.getCordysUserForID(userID);
	    		if (cordysUser != null)
	    		{
	    			event.addError(this, ATTR_UserID, "In current organization, Cordys user with ID '" + userID + "' already exists (" + cordysUser.getDescription() + ")");
	    		}
	    	}
    	}
    	if (event.triggeredBy(StdTriggers.INSERT_OBJECT) || event.triggeredBy(StdTriggers.UPDATE_OBJECT))
    	{
    		if (CordysUser.AT_CUSTOM.equals(this.getAuthenticationType()))
    		{
    			String pw = this.getUserPassword();
    			String cpw = this.getConfirmPassword();
    			if (!Util.isSet(pw))
    			{
    				event.addError(this, ATTR_UserPassword, "Pls enter the user password.");
    			}
    			if (!Util.isSet(cpw))
    			{
    				event.addError(this, ATTR_ConfirmPassword, "Pls confirm the user password.");
    			}
    			if (Util.isSet(pw) && (Util.isSet(cpw)))
    			{
    				if (!pw.equals(cpw))
    				{
    					event.addError(this, ATTR_ConfirmPassword, "Passwords do not match.");
    				}
    			}
    		}
    	}
    }

    public void onInsert()
    {
    	String cloneOrgUserDN = this.getCloneOrgUserDN();
    	try
    	{    	
	    	CordysUser cordysUser = new CordysUser();
			editCordysUser(cordysUser);
	    	if (Util.isSet(cloneOrgUserDN) && this.getCloneRoles())
	    	{
	    		CordysUser cloneCordysUser = CordysUser.getCordysUser(cloneOrgUserDN);
	    		if (cloneCordysUser != null)
	    		{
	    			cordysUser.setRoleDNs(cloneCordysUser.getRoleDNs());
	    		}
	    	}
			cordysUser.maintainUser(true);
			this.setDefaultOrg(cordysUser.getDefaultcontext());
			this.setDescription(this.getFullUserName() + " (" + this.getUserID() + ")");
			this.setUserPassword(cordysUser.getUserPassword());
			this.setConfirmPassword(cordysUser.getUserPassword());
			this.setOrgUserDN(cordysUser.getOrgUserDN());
			this.setNull(ATTR_CloneOrgUserDN);
    	}
    	catch (Exception e)
    	{
    		throw new UserAdminException("Not able to insert user " + this.getUserName(), e);
    	}	
    	if (Util.isSet(cloneOrgUserDN))
    	{
			CordysObjectList assignedTasks = null;
			CordysObjectList assignedTeams = null;
    		try
    		{
	    		if (this.getCloneTasks())
	    		{
	    			assignedTasks = Task.getAssignedTasks(cloneOrgUserDN);
					if (assignedTasks.getKeyList().size() > 0)
					{
						Task.maintainTasks(this.getOrgUserDN(), assignedTasks.getKeyList(), null);
					}   			
	    		}
	    		if (this.getCloneTeams() && this.getCloneRoles())
	    		{
	    			assignedTeams = TeamAssignment.getAssignments(cloneOrgUserDN, "", false); 
	    			// change teamsAssignents as per new orgUserDN
	    	        for (CordysObject cordysObject : assignedTeams.getList())
	    	        {
	    	        	TeamAssignment teamAssignment = (TeamAssignment)cordysObject;
	    	        	teamAssignment.setID("");
	    	        	teamAssignment.setUserDN(this.getOrgUserDN());
	    	        }
	    	        if (assignedTeams.getList().size() > 0)
	    	        {
	    	        	TeamAssignment.addAssignments(this.getOrgUserDN(), assignedTeams.getList());
	    	        }
	    		}    		
    		}
    		catch (Exception e)
    		{
    			throw new UserAdminException("Not able to (fully) clone tasks/teams for user " + this.getUserName(), e);
    		}
    		finally
    		{
        		if (assignedTasks != null)
        		{
        			assignedTasks.cleanup();
        		}
        		if (assignedTeams != null)
        		{
        			assignedTeams.cleanup();
        		}    			
    		}
    	}
    }

    public void onUpdate()
    {
		CordysObjectList assignedTasks = null;
		CordysObjectList assignedTeams = null;
    	try
    	{
	    	CordysUser cordysUser = CordysUser.getCordysUser(this.getOrgUserDN());
	    	if (cordysUser != null)
	    	{
	    		editCordysUser(cordysUser);
	    		boolean userRenamed = false;
	    		String oldOrgUserDN;
	    		// check if user was renamed as in that case, we need to move the task/team assignments as well
	    		UIUser oldUIUser = (UIUser)this.getOriginalObject();
	    		if (oldUIUser != null)
	    		{
	    			String oldUserName = oldUIUser.getUserName();
	    			if (!this.getUserName().equals(oldUserName))
	    			{
	    				userRenamed = true;
	    				oldOrgUserDN = oldUIUser.getOrgUserDN();
	    				assignedTasks = Task.getAssignedTasks(oldOrgUserDN);
	    				if (assignedTasks.getKeyList().size() > 0)
	    				{
	    					Task.deleteAllAssignedTasksForDN(oldOrgUserDN);
	    				}
	    				assignedTeams = TeamAssignment.getAssignments(oldOrgUserDN, "", false);
		    	        if (assignedTeams.getList().size() > 0)
		    	        {
		    	        	TeamAssignment.deleteAllAssignmentsForUser(oldOrgUserDN);
		    	        }
	    			}
	    		}
	    		cordysUser.maintainUser(false);
	    		this.setDescription(this.getFullUserName() + " (" + this.getUserID() + ")");
	    		this.setUserPassword(cordysUser.getUserPassword());
	    		this.setConfirmPassword(cordysUser.getUserPassword());
	    		// orgUserDN might have changed in case UserName (cn) was changed
	    		this.setOrgUserDN(cordysUser.getOrgUserDN());
	    		if (userRenamed)
	    		{
	    			String newOrgUserDN = this.getOrgUserDN();
    				if (assignedTasks.getKeyList().size() > 0)
    				{
	    				Task.maintainTasks(newOrgUserDN, assignedTasks.getKeyList(), null);
    				}
	    			// change teamsAssignents as per new orgUserDN
	    	        for (CordysObject cordysObject : assignedTeams.getList())
	    	        {
	    	        	TeamAssignment teamAssignment = (TeamAssignment)cordysObject;
	    	        	teamAssignment.setUserDN(newOrgUserDN);
	    	        }
	    	        if (assignedTeams.getList().size() > 0)
	    	        {
	    	        	TeamAssignment.addAssignments(newOrgUserDN, assignedTeams.getList());
	    	        }
	    		}
	    	}
    	}
    	catch (Exception e)
    	{
    		throw new UserAdminException("Not able to update user " + this.getOrgUserDN(), e);
    	}
    	finally
    	{
    		if (assignedTasks != null)
    		{
    			assignedTasks.cleanup();
    		}
    		if (assignedTeams != null)
    		{
    			assignedTeams.cleanup();
    		}
    	}
    }
    
    public void onDelete()
    {
    	// N.A.
    }
    
    private void editCordysUser(CordysUser cordysUser)
    {
    	cordysUser.setCN(this.getUserName());
    	cordysUser.setOSIdentity(this.getUserID());
		cordysUser.setAuthenticationType(this.getAuthenticationType());
		cordysUser.setEnable(!this.getDisabled());
		cordysUser.setUserPassword(this.getUserPassword());
		cordysUser.setDescription(this.getFullUserName());
		cordysUser.setCompany(this.getCompany());
		cordysUser.setRegisteredAddress(this.getAddress());
		cordysUser.setTelephoneNumber(this.getTelephone());
		cordysUser.setFacsimileTelephoneNumber(this.getTelephone2());
		cordysUser.setEmail(this.getEmail());
		cordysUser.setLabeleduri(this.getUserHomePage());
		if (inSystemOrg())
		{
			cordysUser.setDefaultcontext(this.getDefaultOrg());   	
		}
    }
    
    public static void deleteUIUser(String orgUserDN)
    {
    	try
    	{
	    	if (Util.isSet(orgUserDN))
	    	{
				if (orgUserDN.equals(BSF.getUser()))
				{
					throw new UserAdminException("Current user can not be deleted");
				}
				else
				{
					try
					{
						Task.deleteAllAssignedTasksForDN(orgUserDN);
						TeamAssignment.deleteAllAssignmentsForUser(orgUserDN);
					}
					catch (Exception e)
					{
						// ignore
					}
					CordysUser.deleteUser(orgUserDN);
				}
	    	}
    	}
		catch (UserAdminException e)
		{
			throw e;
		}
		catch (Exception e)
		{
			throw new UserAdminException("User can not be deleted ("+e.getMessage()+")");
		}
    }
    
    /**
     * Update a user attribute as per the action (including enabling/disabling user)
     * 
     * @param orgUserDN
     * @param action
     * @param newValue
     */
    public static void updateUIUserAttribute(String orgUserDN, int action, String newValue)
    {
    	try
    	{
	    	if (Util.isSet(orgUserDN))
	    	{
				if ((action == UA_DISABLE_USERS) && (orgUserDN.equals(BSF.getUser())))
				{
					throw new UserAdminException("Current user can not be disabled");
				}
				else
				{
			    	CordysUser cordysUser = CordysUser.getCordysUser(orgUserDN);
			    	if (cordysUser != null)
			    	{
			    		switch (action)
			    		{
			    			case UA_DISABLE_USERS:
			    			{
			    				cordysUser.setEnable(false);
			    				break;
			    			}
			    			case UA_ENABLE_USERS:
			    			{
			    				cordysUser.setEnable(true);
			    				break;
			    			}	
			    			case UA_UPDATE_COMPANY:
			    			{
			    				cordysUser.setCompany(newValue);
			    				break;
			    			}			    			
			    			case UA_UPDATE_ADDRESS:
			    			{
			    				cordysUser.setRegisteredAddress(newValue);
			    				break;
			    			}			    			
			    			case UA_UPDATE_TELEPHONE:
			    			{
			    				cordysUser.setTelephoneNumber(newValue);
			    				break;
			    			}	
			    			case UA_UPDATE_TELEPHONE2:
			    			{
			    				cordysUser.setFacsimileTelephoneNumber(newValue);
			    				break;
			    			}			    			
			    		}
			    		cordysUser.maintainUser(false);
			    	}
				}
	    	}
    	}
		catch (UserAdminException e)
		{
			throw e;
		}
		catch (Exception e)
		{
			throw new UserAdminException("User can not be updated ("+e.getMessage()+")");
		}   	
    }
}
