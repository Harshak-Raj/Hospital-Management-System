package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Doctor {
    private int id;
    private String name;
    private String specialization;
    private String department;

    // Constructor
    public Doctor(int id, String name, String specialization, String department) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
// Getters and Setters
    // Implement getters and setters for all attributes

    // CRUD Operations

    // Create
    public void addDoctor() {
        String sql = "INSERT INTO doctors (name, specialization, department) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, this.name);
            statement.setString(2, this.specialization);
            statement.setString(3, this.department);
            statement.executeUpdate();
            System.out.println("Doctor added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read
    public static List<Doctor> getAllDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        String sql = "SELECT * FROM doctors";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String specialization = resultSet.getString("specialization");
                String department = resultSet.getString("department");
                Doctor doctor = new Doctor(id, name, specialization, department);
                doctors.add(doctor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctors;
    }

    // Update
    public void updateDoctor() {
        String sql = "UPDATE doctors SET name=?, specialization=?, department=? WHERE id=?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, this.name);
            statement.setString(2, this.specialization);
            statement.setString(3, this.department);
            statement.setInt(4, this.id);
            statement.executeUpdate();
            System.out.println("Doctor updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void deleteDoctor() {
        String sql = "DELETE FROM doctors WHERE id=?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, this.id);
            statement.executeUpdate();
            System.out.println("Doctor deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
