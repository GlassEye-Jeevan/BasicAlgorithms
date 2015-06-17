Tables:
Courses: CourseID, CourseName, TeacherID
Teachers: TeacherID, TeacherName
Students: StudentID, StudentName
StudentCourses: CourseID, StudentID

1. 

/* Display a list of students and a count of courses each has enrolled in */
SELECT studentname, studentid, count_course
FROM students JOIN 
(
	SELECT studentid AS sid, count(courseid) AS count_course
	FROM StudentCourses
	GROUP BY studentid) a ON studentid = sid
) 
GROUP BY studentid, studentname;

2. Get class sizes for each teacher
SELECT TeacherID, SUM(counts)
FROM Courses
	JOIN (SELECT CourseID, count(StudentID) AS counts
		  FROM StudentCourses
		  GROUP BY CourseID) a 
  	ON a.CourseID = Teachers.CourseID
GROUP BY TeacherID;

TABLES:
Apartments: AptID, UnitNumber, BuildingID
Buildings: BuildingID, ComplexID, BuildingName, Address
Tenants: TenantID, TenantName
Complexes: ComplexID, ComplexName
AptTenants: TenantID, AptID
Requests: RequestID, Status, AptID, Description

1. List of tenants who are renting more than one apartment
SELECT TenantName 
FROM Tenants 
	JOIN	(SELECT TenantID, COUNT(AptID)
			FROM AptTenants
			HAVING COUNT(AptID) > 1
			GROUP BY TenantID) a
	ON Tenants.TenantID = a.TenantID
GROUP BY TenantID

2. List all buildings and the no. of 'open' requests
SELECT BuildingID, SUM(Counts)
FROM Apartments
	JOIN (SELECT AptID, COUNT(RequestID) AS Counts
			FROM Requests
			WHERE Status = 'Open'
			GROUP BY AptID) a
	ON a.AptID = Apartments.AptID
GROUP BY BuildingID

3. Write a query to close all requests from apartments in this building

UPDATE Requests
SET Status = 'Closed'
WHERE AptID IN (SELECT AptID FROM Apartments WHERE BuildingID = 11) 
      AND Status = 'Open'; 






