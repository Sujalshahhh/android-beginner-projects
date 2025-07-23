package com.example.crud;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class CourseRVAdapter extends ListAdapter<CourseModal, CourseRVAdapter.ViewHolder> {

    private OnItemClickListener listener;

    // Properly defined DiffUtil callback
    private static final DiffUtil.ItemCallback<CourseModal> DIFF_CALLBACK = new DiffUtil.ItemCallback<CourseModal>() {
        @Override
        public boolean areItemsTheSame(@NonNull CourseModal oldItem, @NonNull CourseModal newItem) {
            return oldItem.getId() == newItem.getId();  // Use unique ID comparison
        }

        @Override
        public boolean areContentsTheSame(@NonNull CourseModal oldItem, @NonNull CourseModal newItem) {
            return oldItem.equals(newItem);  // Ensure CourseModal overrides equals()
        }
    };

    // Constructor
    public CourseRVAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate layout using LayoutInflater
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CourseModal course = getItem(position);
        holder.bind(course);
    }

    // Method to get CourseModal at a specific position
    public CourseModal getCourseAt(int position) {
        return getItem(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView courseNameTV, courseDescTV, courseDurationTV;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            // Initializing views
            courseNameTV = itemView.findViewById(R.id.idTVCourseName);
            courseDescTV = itemView.findViewById(R.id.idTVCourseDescription);
            courseDurationTV = itemView.findViewById(R.id.idTVCourseDuration);

            // Click listener for RecyclerView items
            itemView.setOnClickListener(v -> {
                int position = getAbsoluteAdapterPosition();
                if (listener != null && position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(getItem(position));
                }
            });
        }

        // Method to bind data to views
        public void bind(CourseModal course) {
            courseNameTV.setText(course.getCourseName());
            courseDescTV.setText(course.getCourseDescription());
            courseDurationTV.setText(course.getCourseDuration());
        }
    }

    // Interface for item click handling
    public interface OnItemClickListener {
        void onItemClick(CourseModal model);
    }

    // Setter for listener
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
