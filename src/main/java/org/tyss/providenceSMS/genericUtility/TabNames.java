package org.tyss.providenceSMS.genericUtility;

public enum TabNames {

	DASHBOARDTAB("Dashboard"),MYPROFILETAB("My Profile"),CLASSROOMTAB("Classroom"),GRADETAB("Grade"),SUBJECTTAB("Subject"),TEACHERTAB("Teacher"),SUBJECTROUTINGTAB("Subject Routing"),TIMETABLETAB("Timetable"),
	STUDENTTAB("Student"),STUDENTPAYMENTTAB("Student Payment"),ATTENDANCETAB("Attendance"),EXAMTAB("Exam"),PETTYCASHTAB("Petty Cash"),FRIENDSTAB("Friends"),EVENTTAB("Events"),MYSALARYTAB("My Salary"),MYSTUDENTTAB("My Student"),MYPETTYCASHTAB("My Petty Cash"),MYSONSPAYMENTSTAB("My Son's Payments");
	private String tabName;
	private TabNames(String tabName) {
		
		this.tabName = tabName;
	}
	
	public String getTabName() {
		return tabName;
	}
}
