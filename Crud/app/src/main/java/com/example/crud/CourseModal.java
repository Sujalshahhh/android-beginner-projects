package com.example.crud;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.util.Objects;

// Define table name for Room Database
@Entity(tableName = "course_table")
public class CourseModal {

    // Auto-incremented primary key
    @PrimaryKey(autoGenerate = true)
    private int id;

    // Define column names for better readability
    @ColumnInfo(name = "course_name")
    private String courseName;

    @ColumnInfo(name = "course_description")
    private String courseDescription;

    @ColumnInfo(name = "course_duration")
    private String courseDuration;

    // Constructor (ID is auto-generated)
    public CourseModal(String courseName, String courseDescription, String courseDuration) {
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.courseDuration = courseDuration;
    }

    // Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
    }

    // Override equals() to compare objects properly
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CourseModal that = (CourseModal) obj;
        return id == that.id &&
                Objects.equals(courseName, that.courseName) &&
                Objects.equals(courseDescription, that.courseDescription) &&
                Objects.equals(courseDuration, that.courseDuration);
    }

    // Override hashCode() for better performance in data structures
    @Override
    public int hashCode() {
        return Objects.hash(id, courseName, courseDescription, courseDuration);
    }
}
