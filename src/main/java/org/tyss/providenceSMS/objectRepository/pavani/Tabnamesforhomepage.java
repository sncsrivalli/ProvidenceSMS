package org.tyss.providenceSMS.objectRepository.pavani;

public enum Tabnamesforhomepage {
	DASHBOARDTAB("Dashboard"),MYPROFILETAB("My Profile"),CLASSROOMTAB("Classroom"),GRADETAB("Grade"),
	SUBJECTTAB("Subject"),TEACHERTAB("Teacher"),SUBJECTROUTINGTAB("Subject Routing"),TIMETABLETAB("Timetable"),
	STUDENTTAB("Student"),STUDENTPAYMENTTAB("Student Payment"),ATTENDANCETAB("Attendance"),EXAMTAB("Exam"),
	PETTYCASHTAB("Petty Cash"),FRIENDSTAB("Friends"),EVENTTAB("Event"),ADDTEACHERTAB(" Add Teacher"),ALLTEACHERTAB(" All Teacher"),
	ADDSTUDENTTAB(" Add Student"),ALLSTUDENTTAB(" All Student"),LEAVESTUDENTTAB(" Leave Student"),CREATEEXAMTAB("Create Exam"),
	EXAMTIMETABLETAB(" Exam Timetable"),STUDENTEXAMMARKSTAB("Student Exam Marks"),STUDENTEXAMMARKSHISTORYTAB("Student Exam Marks History"),
	ADDFRIENDSTAB(" Add Friends"),MYFRIENDSTAB(" My Friends"),MYEVENTSTAB(" My Events"),ALLEVENTSTAB(" All Events"),ADMINPIC("Abhishek K H"),
    SIGNOUTBUTTON("Sign out"),PROFILEBUTTON("Profile");
	private String tabName;
	private Tabnamesforhomepage(String tabName)
	{
		this.tabName=tabName;
		
	}
	public String getTabName()
	{
		return tabName;
		
	}
	
}
