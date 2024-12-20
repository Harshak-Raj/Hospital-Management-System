package org.example;

import org.example.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Patient {
    private int id;
    private String name;
    private int age;
    private String gender;

    // Constructor
    public Patient(int id, String name, int age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    // Getters and Setters
    // Implement getters and setters for all attributes

    // CRUD Operations

    // Create
    public void addPatient() {
        String sql = "INSERT INTO patients (name, age, gender) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, this.name);
            statement.setInt(2, this.age);
            statement.setString(3, this.gender);
            statement.executeUpdate();
            System.out.println("Patient added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read
    public static List<Patient> getAllPatients() {
        List<Patient> patients = new ArrayList<>();
        String sql = "SELECT * FROM patients";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");
                Patient patient = new Patient(id, name, age, gender);
                patients.add(patient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patients;
    }

    // Update
    public void updatePatient() {
        String sql = "UPDATE patients SET name=?, age=?, gender=? WHERE id=?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, this.name);
            statement.setInt(2, this.age);
            statement.setString(3, this.gender);
            statement.setInt(4, this.id);
            statement.executeUpdate();
            System.out.println("Patient updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void deletePatient() {
        String sql = "DELETE FROM patients WHERE id=?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, this.id);
            statement.executeUpdate();
            System.out.println("Patient deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
