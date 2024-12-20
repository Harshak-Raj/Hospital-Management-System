package org.example;

import org.example.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Appointment {
    private int id;
    private int patientId;
    private int doctorId;
    private String date;
    private String time;

    // Constructor
    public Appointment(int id, int patientId, int doctorId, String date, String time) {
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
// Getters and Setters
    // Implement getters and setters for all attributes

    // CRUD Operations

    // Create
    public void scheduleAppointment() {
        String sql = "INSERT INTO appointments (patient_id, doctor_id, date, time) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, this.patientId);
            statement.setInt(2, this.doctorId);
            statement.setString(3, this.date);
            statement.setString(4, this.time);
            statement.executeUpdate();
            System.out.println("Appointment scheduled successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update
    public void updateAppointment() {
        String sql = "UPDATE appointments SET patient_id=?, doctor_id=?, date=?, time=? WHERE id=?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, this.patientId);
            statement.setInt(2, this.doctorId);
            statement.setString(3, this.date);
            statement.setString(4, this.time);
            statement.setInt(5, this.id);
            statement.executeUpdate();
            System.out.println("Appointment updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void cancelAppointment() {
        String sql = "DELETE FROM appointments WHERE id=?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, this.id);
            statement.executeUpdate();
            System.out.println("Appointment canceled successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static List<Appointment> getAllAppointments() {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM appointments";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int patientId = resultSet.getInt("patient_id");
                int doctorId = resultSet.getInt("doctor_id");
                String date = resultSet.getString("date");
                String time = resultSet.getString("time");
                Appointment appointment = new Appointment(id, patientId, doctorId, date, time);
                appointments.add(appointment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointments;
    }
}
