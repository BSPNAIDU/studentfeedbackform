package com.studentfeedback.model;

import java.sql.Timestamp;

public class Feedback {

    private int feedbackId;
    private String studentName;
    private String email;
    private String department;
    private int rating;
    private String feedbackMessage;
    private Timestamp submittedAt;

    // Default Constructor
    public Feedback() {
    }

    // Constructor without ID
    public Feedback(String studentName,
                    String email,
                    String department,
                    int rating,
                    String feedbackMessage) {

        this.studentName = studentName;
        this.email = email;
        this.department = department;
        this.rating = rating;
        this.feedbackMessage = feedbackMessage;
    }

    // Full Constructor
    public Feedback(int feedbackId,
                    String studentName,
                    String email,
                    String department,
                    int rating,
                    String feedbackMessage,
                    Timestamp submittedAt) {

        this.feedbackId = feedbackId;
        this.studentName = studentName;
        this.email = email;
        this.department = department;
        this.rating = rating;
        this.feedbackMessage = feedbackMessage;
        this.submittedAt = submittedAt;
    }

    // Getters and Setters

    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getFeedbackMessage() {
        return feedbackMessage;
    }

    public void setFeedbackMessage(String feedbackMessage) {
        this.feedbackMessage = feedbackMessage;
    }

    public Timestamp getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(Timestamp submittedAt) {
        this.submittedAt = submittedAt;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "feedbackId=" + feedbackId +
                ", studentName='" + studentName + '\'' +
                ", email='" + email + '\'' +
                ", department='" + department + '\'' +
                ", rating=" + rating +
                ", feedbackMessage='" + feedbackMessage + '\'' +
                ", submittedAt=" + submittedAt +
                '}';
    }
}