package com.capgemini.survey.beans;

public class AdminInfoBean {
	private String adminUserName;
	private String adminPassword;
    
	@Override
	public String toString() {
		String str="\n";
		return "adminUserName=" + adminUserName + str +
			   "adminPassword=" + adminPassword ;
	}

	public String getAdminUserName() {
		return adminUserName;
	}

	public void setAdminUserName(String adminUsername) {
		this.adminUserName = adminUsername;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

}
