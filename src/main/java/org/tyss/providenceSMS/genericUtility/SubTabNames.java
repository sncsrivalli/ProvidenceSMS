package org.tyss.providenceSMS.genericUtility;

public enum SubTabNames {
	
	AddTeacherTab(" Add Teacher"),AllTeacherTab(" All Teacher"),AddStudentTab(" Add Student"),AllStudentTab(" All Student"),LeaveStudentTab(" Leave Student"),AddAttendanceTab(" Add Attendance"),
	StudentAttendanceHistoryTab("Student Attendance History "),TeacherAttendanceHistoryTab(" Teacher Attendance History"),CreateExamTab("Create Exam"),ExamTimetableTab("Exam Timetable"),StudentExamMarkstab("Student Exam Marks"),
	StudentExamMarksHistoryTab("Student Exam Marks History"),AddFriends(" Add Friends"),MyFriendsTab(" My Friends"),MyEventsTab(" My Events"),AllEventsTab(" All Events"),MySubjectTab(" My Subject"),AllSubjectTab(" All Subject"),MyTimetableTab(" My Timetable"),
	AllTimetableTab("All Timetable"),MyAttendance(" My Attendance"),MyAttendanceHistoryTab("My Attendance History"),MyStudentMarksTab(" My Student Exam Marks"),MyStudentExamMarksHistoryTab(" My Student Exam Marks History"),MyProfileTab(" My Profile"),MySonsProfileTab(" My Son's Profiler"),
	MySonsTeacherTab(" My Son's Teacher"),MySonsSubjectTab(" My Son's Subject"),MySonsTimetableTab(" My Son's Timetable"),MySonsAttendanceTab(" My Son's Attendance"),MySonsAttendanceHistory(" My Son's Attendance History"),MySonsExamMarksTab(" My Son's Exam Marks"),MySonsExamMarksHistoryTab(" My Son's  Exam Marks History"),
	MySonsExamTimetableTab("My Son's Exam Timetable");
	private String subTabName;
	private SubTabNames(String subTabName) {
		this.subTabName = subTabName;
	}
	
	public String getSubTabName() {
		return subTabName;
	}

}
