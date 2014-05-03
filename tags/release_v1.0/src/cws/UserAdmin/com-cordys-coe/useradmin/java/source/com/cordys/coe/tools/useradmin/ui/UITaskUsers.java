/*
  This class has been generated by the Code Generator
*/

package com.cordys.coe.tools.useradmin.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import com.cordys.coe.tools.useradmin.cordys.CordysUser;
import com.cordys.coe.tools.useradmin.cordys.Task;
import com.cordys.cpc.bsf.busobject.BusObjectConfig;
import com.cordys.cpc.bsf.busobject.BusObjectIterator;


/**
 * UI class to support task based user assignments.
 * 
 * @author kekema
 *
 */
public class UITaskUsers extends UITaskUsersBase
{
    public UITaskUsers()
    {
        this((BusObjectConfig)null);
    }

    public UITaskUsers(BusObjectConfig config)
    {
        super(config);
    }

    /**
     * Get all org users plus indicator whether the given task is assigned.
     * 
     * @param taskID
     * @return
     */
    public static UITaskUsers getUITaskUsers(String taskID)
    {
    	UITaskUsers uiTaskUsers = new UITaskUsers();
    	uiTaskUsers.makeTransient();
    	uiTaskUsers.setTaskID(taskID);
    	UITaskUsers.Users taskUsers = new UITaskUsers.Users();
    	uiTaskUsers.setUsersObject(taskUsers);
    	
    	int seqNo = 0;
    	
    	ArrayList<CordysUser> cordysUsers = CordysUser.getOrgUsersList(null, true, true);
    	ArrayList<String> cordysUserDNs = new ArrayList<String>();
    	for (CordysUser cordysUser : cordysUsers)
    	{
    		cordysUserDNs.add(cordysUser.getOrgUserDN());
    	}
		HashMap<String, ArrayList<String>> tasksByUser = Task.getAssignedTasksByDN(cordysUserDNs);
    	for (CordysUser cordysUser : cordysUsers)
    	{
    		seqNo++;
    		UITaskUsers.Users.User taskUser = new UITaskUsers.Users.User();
    		taskUser.makeTransient();
    		taskUser.setSeqNo(seqNo);
    		taskUser.setOrgUserDN(cordysUser.getOrgUserDN());
    		// compose description from full user name + osidentity for non-anonymous users
    		if ("anonymous".equals(cordysUser.getDescription()))
    		{
    			taskUser.setDescription(cordysUser.getDescription());
    		}
    		else
    		{
    			taskUser.setDescription(cordysUser.getDescription() + " (" + cordysUser.getOSIdentity() + ")");
    		}
    		taskUser.setAssigned(tasksByUser.get(cordysUser.getOrgUserDN()).contains(taskID));
    		taskUsers.addUserObject(taskUser);
    	}
    	
        return uiTaskUsers;
    }

    public void onInsert()
    {
    	// N.A.
    }

    /**
     * Process any assigned/unassigned user wrt the task
     */
    public void onUpdate()
    {
    	String taskID = this.getTaskID();
    	// compose hashset of users who currently do have the task assigned
    	HashSet<String> currentAssignedUsers = new HashSet<String>();
    	UITaskUsers origUITaskUsers = (UITaskUsers)this.getOriginalObject();
    	UITaskUsers.Users origUsers = origUITaskUsers.getUsersObject();
   		BusObjectIterator<UITaskUsers.Users.User> origUserObjects = origUsers.getUserObjects();
   		while (origUserObjects.hasMoreElements())
   		{
   			UITaskUsers.Users.User origUser = (UITaskUsers.Users.User)origUserObjects.nextElement();
   			if (origUser.getAssigned())
   			{
   				currentAssignedUsers.add(origUser.getOrgUserDN());
   			}
   		}
   		// find out any required updates from the tuple/new
   		UITaskUsers.Users users = this.getUsersObject();
   		BusObjectIterator<UITaskUsers.Users.User> userObjects = users.getUserObjects();
   		while (userObjects.hasMoreElements())
   		{
   			UITaskUsers.Users.User user = (UITaskUsers.Users.User)userObjects.nextElement();
   			boolean currentlyAssigned = (currentAssignedUsers.contains(user.getOrgUserDN()));
   			if (user.getAssigned() && (!currentlyAssigned))
   			{
   				ArrayList<String> addedTaskIDs = new ArrayList<String>();
   				addedTaskIDs.add(taskID);
   				Task.maintainTasks(user.getOrgUserDN(), addedTaskIDs, null);
   			}
   			else if (!user.getAssigned() && (currentlyAssigned))
   			{
   				ArrayList<String> removedTaskIDs = new ArrayList<String>();
   				removedTaskIDs.add(taskID);
   				Task.maintainTasks(user.getOrgUserDN(), null, removedTaskIDs);
   			}
   		}
        // read back the actual list
   		UITaskUsers actualTaskUsers = UITaskUsers.getUITaskUsers(taskID);
        if (actualTaskUsers != null)
        {
        	UITaskUsers.Users actualUsers = actualTaskUsers.getUsersObject();
        	UITaskUsers.Users uiUsers = new UITaskUsers.Users(new BusObjectConfig(actualUsers, BusObjectConfig.TRANSIENT_OBJECT));
        	this.setUsersObject(uiUsers);
        }
    }

    public void onDelete()
    {
    	// N.A.    	
    }

    public static class Users extends UITaskUsers.UsersBase
    {
        public Users()
        {
            this((BusObjectConfig)null);
        }

        public Users(BusObjectConfig config)
        {
            super(config);
        }

        public void onInsert()
        {
        }

        public void onUpdate()
        {
        }

        public void onDelete()
        {
        }

        public static class User extends UITaskUsers.Users.UserBase
        {
            public User()
            {
                this((BusObjectConfig)null);
            }

            public User(BusObjectConfig config)
            {
                super(config);
            }

            public void onInsert()
            {
            }

            public void onUpdate()
            {
            }

            public void onDelete()
            {
            }

        }
    }
}