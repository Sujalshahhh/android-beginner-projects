package com.example.crud;

import android.app.Application;
import androidx.lifecycle.LiveData;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CourseRepository {

    private final Dao dao;
    private final LiveData<List<CourseModal>> allCourses;
    private final ExecutorService executorService;

    // Constructor
    public CourseRepository(Application application) {
        CourseDatabase database = CourseDatabase.getInstance(application);
        dao = database.Dao();
        allCourses = dao.getAllCourses();
        executorService = Executors.newSingleThreadExecutor();  // Efficient background thread execution
    }

    // Insert Course
    public void insert(CourseModal model) {
        executorService.execute(() -> dao.insert(model));
    }

    // Update Course
    public void update(CourseModal model) {
        executorService.execute(() -> dao.update(model));
    }

    // Delete Course
    public void delete(CourseModal model) {
        executorService.execute(() -> dao.delete(model));
    }

    // Delete All Courses
    public void deleteAllCourses() {
        executorService.execute(dao::deleteAllCourses);
    }

    // Fetch All Courses
    public LiveData<List<CourseModal>> getAllCourses() {
        return allCourses;
    }
}
