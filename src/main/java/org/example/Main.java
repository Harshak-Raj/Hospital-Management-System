package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Hospital Management System");
            System.out.println("1. Manage Patients");
            System.out.println("2. Manage Doctors");
            System.out.println("3. Manage Appointments");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    managePatients();
                    break;
                case 2:
                    manageDoctors();
                    break;
                case 3:
                    manageAppointments();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }

    private static void managePatients() {
        while (true) {
            System.out.println("\nPatient Management");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Update Patient");
            System.out.println("4. Delete Patient");
            System.out.println("5. Go Back");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    viewPatients();
                    break;
                case 3:
                    updatePatient();
                    break;
                case 4:
                    deletePatient();
                    break;
                case 5:
                    return; // Go back to main menu
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }

    private static void manageDoctors() {
        while (true) {
            System.out.println("\nDoctor Management");
            System.out.println("1. Add Doctor");
            System.out.println("2. View Doctors");
            System.out.println("3. Update Doctor");
            System.out.println("4. Delete Doctor");
            System.out.println("5. Go Back");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addDoctor();
                    break;
                case 2:
                    viewDoctors();
                    break;
                case 3:
                    updateDoctor();
                    break;
                case 4:
                    deleteDoctor();
                    break;
                case 5:
                    return; // Go back to main menu
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }

    private static void manageAppointments() {
        while (true) {
            System.out.println("\nAppointment Management");
            System.out.println("1. Schedule Appointment");
            System.out.println("2. View Appointments");
            System.out.println("3. Update Appointment");
            System.out.println("4. Cancel Appointment");
            System.out.println("5. Go Back");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    scheduleAppointment();
                    break;
                case 2:
                    viewAppointments();
                    break;
                case 3:
                    updateAppointment();
                    break;
                case 4:
                    cancelAppointment();
                    break;
                case 5:
                    return; // Go back to main menu
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }

    private static void addPatient() {
        System.out.println("Enter patient details:");
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        System.out.print("Gender: ");
        String gender = scanner.next();

        Patient patient = new Patient(0, name, age, gender);
        patient.addPatient();
    }

    private static void viewPatients() {
        System.out.println("All Patients:");
        List<Patient> patients = Patient.getAllPatients();
        for (Patient patient : patients) {
            System.out.println("ID: " + patient.getId() + ", Name: " + patient.getName() + ", Age: " + patient.getAge() + ", Gender: " + patient.getGender());
        }
    }

    private static void updatePatient() {
        System.out.println("Enter patient ID to update:");
        int id = scanner.nextInt();
        System.out.println("Enter new details:");
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        System.out.print("Gender: ");
        String gender = scanner.next();

        Patient patient = new Patient(id, name, age, gender);
        patient.updatePatient();
    }

    private static void deletePatient() {
        System.out.println("Enter patient ID to delete:");
        int id = scanner.nextInt();
        Patient patient = new Patient(id, "", 0, "");
        patient.deletePatient();
    }

    private static void addDoctor() {
        System.out.println("Enter doctor details:");
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("Specialization: ");
        String specialization = scanner.next();
        System.out.print("Department: ");
        String department = scanner.next();

        Doctor doctor = new Doctor(0, name, specialization, department);
        doctor.addDoctor();
    }

    private static void viewDoctors() {
        System.out.println("All Doctors:");
        List<Doctor> doctors = Doctor.getAllDoctors();
        for (Doctor doctor : doctors) {
            System.out.println("ID: " + doctor.getId() + ", Name: " + doctor.getName() + ", Specialization: " + doctor.getSpecialization() + ", Department: " + doctor.getDepartment());
        }
    }

    private static void updateDoctor() {
        System.out.println("Enter doctor ID to update:");
        int id = scanner.nextInt();
        System.out.println("Enter new details:");
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("Specialization: ");
        String specialization = scanner.next();
        System.out.print("Department: ");
        String department = scanner.next();

        Doctor doctor = new Doctor(id, name, specialization, department);
        doctor.updateDoctor();
    }

    private static void deleteDoctor() {
        System.out.println("Enter doctor ID to delete:");
        int id = scanner.nextInt();
        Doctor doctor = new Doctor(id, "", "", "");
        doctor.deleteDoctor();
    }
    private static void scheduleAppointment() {
        System.out.println("Enter appointment details:");
        System.out.print("Patient ID: ");
        int patientId = scanner.nextInt();
        System.out.print("Doctor ID: ");
        int doctorId = scanner.nextInt();
        System.out.print("Date (YYYY-MM-DD): ");
        String date = scanner.next();
        System.out.print("Time (HH:MM): ");
        String time = scanner.next();

        Appointment appointment = new Appointment(0, patientId, doctorId, date, time);
        appointment.scheduleAppointment();
    }

    private static void viewAppointments() {
        List<Appointment> appointments = Appointment.getAllAppointments();
        System.out.println("All Appointments:");
        for (Appointment appointment : appointments) {
            System.out.println("ID: " + appointment.getId() + ", Patient ID: " + appointment.getPatientId() + ", Doctor ID: " + appointment.getDoctorId() + ", Date: " + appointment.getDate() + ", Time: " + appointment.getTime());
        }
    }

    private static void updateAppointment() {
        System.out.println("Enter appointment ID to update:");
        int id = scanner.nextInt();
        System.out.println("Enter new details:");
        System.out.print("Patient ID: ");
        int patientId = scanner.nextInt();
        System.out.print("Doctor ID: ");
        int doctorId = scanner.nextInt();
        System.out.print("Date (YYYY-MM-DD): ");
        String date = scanner.next();
        System.out.print("Time (HH:MM): ");
        String time = scanner.next();

        Appointment appointment = new Appointment(id, patientId, doctorId, date, time);
        appointment.updateAppointment();
    }

    private static void cancelAppointment() {
        System.out.println("Enter appointment ID to cancel:");
        int id = scanner.nextInt();
        Appointment appointment = new Appointment(id, 0, 0, "", "");
        appointment.cancelAppointment();
    }

}
