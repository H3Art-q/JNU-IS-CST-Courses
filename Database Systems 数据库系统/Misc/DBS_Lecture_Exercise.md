# Lecture Exercise

Given the above schema, write the following query in three forms:
- SQL
- RA using Cartesian product
- RA using theta join

## Exercise 1
`User(UserID, UName, Age, JoinDate)`
`Movie(MovielD, MName, Year, Director)`
`Rating(RatingID, RUserID, RMovieID, Stars, Timestamp)`

What are the Names and Ages of all Users who has given a Rating of at least 3 Stars to some Movie made before 1975?

### SQL (Structured Query Language)
```SQL
SELECT DISTINCT UName, Age
FROM User
JOIN Rating ON User.UserID = Rating.RUserID
JOIN Movie ON Rating.RMovieID = Movie.MovieID
WHERE Stars >= 3 AND Year < 1975;
```
In this query:
- `JOIN` is used to combine rows from different tables based on a related column between them.
- `WHERE` is used to filter the results.
- `DISTINCT` is used to remove duplicate rows from the results.

### Relational Algebra using Cartesian Product
\[ \pi_{\text{UName, Age}} \left( \sigma_{\text{Stars} \geq 3 \land \text{Year} < 1975 \land \text{UserID} = \text{RUserID} \land \text{MovieID} = \text{RMovieID}} \left( \text{User} \times \text{Rating} \times \text{Movie} \right) \right) \]

In this expression:
- \( \times \) denotes the Cartesian product.
- \( \sigma \) denotes the selection operation, which is used here to filter rows based on the given conditions.
- \( \pi \) denotes the projection operation, which is used here to select the `UName` and `Age` attributes.

### Relational Algebra using Theta Join
\[ \pi_{\text{UName, Age}} \left( \sigma_{\text{Stars} \geq 3 \land \text{Year} < 1975} \left( \text{User} \bowtie_{\text{UserID} = \text{RUserID}} \left( \text{Rating} \bowtie_{\text{MovieID} = \text{RMovieID}} \text{Movie} \right) \right) \right) \]

In this expression:
- \( \bowtie \) denotes the theta join.
- The subscripts on the theta join specify the join condition.
- \( σ_{\text{Stars} >= 3 ∧ \text{Year} < 1975} \) is used to filter rows based on the given conditions.
- \( π_{\text{UName, Age}} \) is used to project the \(\text{UName}\) and \(\text{Age}\) attributes.

## Exercise 2
Given:
`Student (SID, Name, Age, Major)`
`Course(CID, Name, Credits, Department)`
`GradeReport(SID, SecID, Grade)`
`Prerequisite(CID, PreregID)`
`Section(SecID, CID, Semester, Year, Instructor)`

What are the SIDs of all Students who have taken Course "Computer Graphics" ever?

### SQL (Structured Query Language)
```SQL
SELECT DISTINCT GradeReport.SID
FROM GradeReport
JOIN Section ON GradeReport.SecID = Section.SecID
JOIN Course ON Section.CID = Course.CID
WHERE Course.Name = 'Computer Graphics';
```

### Relational Algebra using Cartesian Product
\[ \pi_{\text{SID}} \left( \sigma_{\text{Name} = 'Computer Graphics'} \left( \text{GradeReport} \times \left( \text{Section} \times \left( \text{Course} \times \sigma_{\text{Name} = 'Computer Graphics'}(\text{Course}) \right) \right) \right) \right) \]

### Relational Algebra using Theta Join
\[ \pi_{\text{SID}} \left( \text{GradeReport} \bowtie_{\text{SecID} = \text{SecID}} \left( \text{Section} \bowtie_{\text{CID} = \text{CID}} \sigma_{\text{Name} = 'Computer Graphics'}(\text{Course}) \right) \right) \]

## Exercise 3
`Student(SID, Name, Age, Major)`
`GradeReport(SID, SecID, Grade)`
`Course(CID, Name, Credits, Department)`
`Prerequisite(CID, PrereqID)`
`Section(SecID, CID, Semester, Year, Instructor)`

What are the Names of all Course which are prerequisites of "Computer Graphics"?

### SQL (Structured Query Language)
```SQL
SELECT DISTINCT C2.Name
FROM Course C1
JOIN Prerequisite ON C1.CID = Prerequisite.CID
JOIN Course C2 ON Prerequisite.PrereqID = C2.CID
WHERE C1.Name = 'Computer Graphics';
```
In this SQL query:
- `C1` and `C2` are aliases for the `Course` table, allowing us to refer to it twice in the same query.
- We use `JOIN` to combine rows from different tables based on related columns.
- `WHERE` is used to filter the results to include only the course "Computer Graphics".
- `DISTINCT` is used to remove duplicate course names from the results.

### Relational Algebra using Cartesian Product
\[ \pi_{\text{Name}} \left( \sigma_{\text{C1.Name} = 'Computer Graphics'} \left( \text{Course as C1} \times \left( \text{Prerequisite} \times \left( \text{Course as C2} \times \sigma_{\text{C1.CID} = \text{Prerequisite.CID} \land \text{Prerequisite.PrereqID} = \text{C2.CID}}(\text{Course}) \right) \right) \right) \right) \]

In this expression:
- \( \times \) represents the Cartesian product.
- \( \sigma \) represents the selection operation, with the selection condition specified as a subscript.
- \( \pi \) represents the projection operation, with the attributes to be selected specified as a subscript.

### Relational Algebra using Theta Join
\[ \pi_{\text{C2.Name}} \left( \text{Course as C1} \bowtie_{\text{C1.CID} = \text{Prerequisite.CID}} \left( \text{Prerequisite} \bowtie_{\text{Prerequisite.PrereqID} = \text{C2.CID}} \text{Course as C2} \right) \right) \]

In this expression:
- \( \bowtie \) represents the theta join, with the join condition specified as a subscript.
- \( \pi \) represents the projection operation, with the attributes to be selected specified as a subscript.

## Exercise 4
`Student(SID, Name, Age, Major)`
`GradeReport(SID, SecID, Grade)`
`Course(CID, Name, Credits, Department)`
`Prerequisite(CID, PrereqID)`
`Section(SecID, CID, Semester, Year, Instructor)`

What are the Names of all Students getting a Grade of 85 or more in CS564 who are not CS Majors?


## Exercise 5
`Student(SID, Name, Age, Major)`
`GradeReport(SID, SecID, Grade)`
`Course(CID, Name, Credits, Department)`
`Prerequisite(CID, PrereqID)`
`Section(SecID, CID, Semester, Year, Instructor)`

What are the Names of all Students who have either taken some CS course or are CS majors?

### SQL (Structured Query Language)
```SQL
SELECT DISTINCT S.Name
FROM Student S
WHERE S.Major = 'CS'
OR S.SID IN (
    SELECT G.SID
    FROM GradeReport G
    JOIN Section SE ON G.SecID = SE.SecID
    JOIN Course C ON SE.CID = C.CID
    WHERE C.Department = 'CS'
);
```
In this SQL query:
- We are selecting distinct student names from the `Student` table.
- We use a `WHERE` clause to filter students who are either CS majors or have taken courses (identified through `GradeReport`, `Section`, and `Course` tables) in the CS department.

### Relational Algebra using Cartesian Product and Union
\[ \pi_{\text{Name}}(\sigma_{\text{Major} = 'CS'}(\text{Student})) \cup \pi_{\text{Name}}(\sigma_{\text{Department} = 'CS'}(\text{Student} \times \text{GradeReport} \times \text{Section} \times \text{Course})) \]
In this expression:
- \( \cup \) represents the union of two sets.
- \( \times \) represents the Cartesian product.
- \( \sigma \) represents the selection operation.
- \( \pi \) represents the projection operation.

### Relational Algebra using Theta Join and Union
\[ \pi_{\text{S.Name}}(\sigma_{\text{S.Major} = 'CS'}(\text{Student as S})) \cup \pi_{\text{S.Name}}((\text{Student as S} \bowtie_{\text{S.SID} = \text{G.SID}} \text{GradeReport as G}) \bowtie_{\text{G.SecID} = \text{SE.SecID}} (\text{Section as SE} \bowtie_{\text{SE.CID} = \text{C.CID}} \sigma_{\text{C.Department} = 'CS'}(\text{Course as C}))) \]
In this expression:
- \( \cup \) represents the union operation.
- \( \bowtie \) represents the theta join with the join condition specified as a subscript.
- \( \sigma \) represents the selection operation.
- \( \pi \) represents the projection operation.

## Exercise 6
`Student(SID, Name, Age, Major)`
`GradeReport(SID, SecID, Grade)`
`Course(CID, Name, Credits, Department)`
`Prerequisite(CID, PrereqID)`
`Section(SecID, CID, Semester, Year, Instructor)`

What is the average Grade for each Section of any CS Course offered in the Fall of 2016?

### SQL (Structured Query Language)
```SQL
SELECT SE.SecID, AVG(G.Grade) AS AverageGrade
FROM Section SE
JOIN Course C ON SE.CID = C.CID
JOIN GradeReport G ON SE.SecID = G.SecID
WHERE C.Department = 'CS' AND SE.Semester = 'Fall' AND SE.Year = 2016
GROUP BY SE.SecID;
```
In this SQL query:
- We are joining the `Section`, `Course`, and `GradeReport` tables to relate sections to courses and grades.
- We filter the results to only CS department courses offered in the Fall of 2016.
- We group the results by `SecID` and calculate the average grade for each section.

### Relational Algebra using Cartesian Product
\[ \gamma_{\text{SE.SecID}, \text{AVG}(G.Grade) \to \text{AverageGrade}} \left( \sigma_{\text{C.Department} = 'CS' \land \text{SE.Semester} = 'Fall' \land \text{SE.Year} = 2016 \land \text{SE.CID} = \text{C.CID} \land \text{SE.SecID} = \text{G.SecID}} (\text{Section as SE} \times \text{Course as C} \times \text{GradeReport as G}) \right) \]

In this expression:
- \( \gamma \) denotes an extended aggregate operation for grouping and averaging.
- \( \sigma \) denotes the selection operation.
- \( \times \) denotes the Cartesian product.
- The selection condition filters the Cartesian product to only include the relevant tuples.

### Relational Algebra using Theta Join
\[ \gamma_{\text{SE.SecID}, \text{AVG}(G.Grade) \to \text{AverageGrade}} \left( \sigma_{\text{C.Department} = 'CS' \land \text{SE.Semester} = 'Fall' \land \text{SE.Year} = 2016} \left( \left( \text{Section as SE} \bowtie_{\text{SE.CID} = \text{C.CID}} \text{Course as C} \right) \bowtie_{\text{SE.SecID} = \text{G.SecID}} \text{GradeReport as G} \right) \right) \]

In this expression:
- \( \gamma_{\text{SE.SecID}, \text{AVG}(G.Grade) \to \text{AverageGrade}} \) represents an aggregation operation that groups by `SecID` and calculates the average of `Grade`.
- \( \sigma \) denotes the selection predicate that filters the courses by the CS department, offered in the Fall of 2016.
- \( \bowtie \) represents the theta join operation with the join condition as a subscript.