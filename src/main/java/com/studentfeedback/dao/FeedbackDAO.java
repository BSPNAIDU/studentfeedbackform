package com.studentfeedback.dao;

import com.studentfeedback.config.DBConnection;
import com.studentfeedback.model.Feedback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class FeedbackDAO {

    // Insert Feedback
    public boolean addFeedback(Feedback feedback) {

        boolean status = false;

        String sql = "INSERT INTO feedback(student_name,email,department,rating,feedback_message) VALUES(?,?,?,?,?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, feedback.getStudentName());
            statement.setString(2, feedback.getEmail());
            statement.setString(3, feedback.getDepartment());
            statement.setInt(4, feedback.getRating());
            statement.setString(5, feedback.getFeedbackMessage());

            int rows = statement.executeUpdate();

            if (rows > 0) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // View All Feedback
    public List<Feedback> getAllFeedback() {

        List<Feedback> feedbackList = new ArrayList<>();

        String sql = "SELECT * FROM feedback ORDER BY submitted_at DESC";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                Feedback feedback = new Feedback();

                feedback.setFeedbackId(resultSet.getInt("feedback_id"));
                feedback.setStudentName(resultSet.getString("student_name"));
                feedback.setEmail(resultSet.getString("email"));
                feedback.setDepartment(resultSet.getString("department"));
                feedback.setRating(resultSet.getInt("rating"));
                feedback.setFeedbackMessage(resultSet.getString("feedback_message"));

                Timestamp timestamp = resultSet.getTimestamp("submitted_at");
                feedback.setSubmittedAt(timestamp);

                feedbackList.add(feedback);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return feedbackList;
    }

    // Delete Feedback
    public boolean deleteFeedback(int feedbackId) {

        boolean status = false;

        String sql = "DELETE FROM feedback WHERE feedback_id=?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, feedbackId);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // Total Feedback
    public int getTotalFeedback() {

        String sql = "SELECT COUNT(*) FROM feedback";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            if (resultSet.next()) {
                return resultSet.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    // Average Rating
    public double getAverageRating() {

        String sql = "SELECT AVG(rating) FROM feedback";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            if (resultSet.next()) {
                return resultSet.getDouble(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    // Total Departments
    public int getDepartmentCount() {

        String sql = "SELECT COUNT(DISTINCT department) FROM feedback";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            if (resultSet.next()) {
                return resultSet.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    // Today's Feedback Count
    public int getTodayFeedbackCount() {

        String sql = "SELECT COUNT(*) FROM feedback WHERE DATE(submitted_at)=CURDATE()";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            if (resultSet.next()) {
                return resultSet.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
}