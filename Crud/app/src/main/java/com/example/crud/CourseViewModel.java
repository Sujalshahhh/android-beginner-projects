package com.example.crud;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import java.util.List;

public class CourseViewModel extends AndroidViewModel {

    private final CourseRepository repository;
    private final LiveData<List<CourseModal>> allCourses;

    // Constructor for ViewModel
    public CourseViewModel(@NonNull Application application) {
        super(application);
        repository = new CourseRepository(application);
        allCourses = repository.getAllCourses();
    }

    // Insert Course
    public void insert(CourseModal model) {
        repository.insert(model);
    }

    // Update Course (Fixed incorrect generic type)
    public void update(CourseModal model) {
        repository.update(model);
    }

    // Delete Course
    public void delete(CourseModal model) {
        repository.delete(model);
    }

    // Delete All Courses
    public void deleteAllCourses() {
        repository.deleteAllCourses();
    }

    // Get All Courses
    public LiveData<List<CourseModal>> getAllCourses() {
        return allCourses;
    }
}
