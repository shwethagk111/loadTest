package vCareLoadTest;

import com.google.gson.Gson;

import vCareLoadTest.sample.Address;
import vCareLoadTest.sample.Bundle;
import vCareLoadTest.sample.Name;
import vCareLoadTest.sample.Patient;
import vCareLoadTest.sample.PatientEntry;
import vCareLoadTest.sample.Request;
import vCareLoadTest.sample.Telecom;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.testng.annotations.Test;


import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PatientLoader {

    public static void main(String[] args) {
        String token = "eyJraWQiOiJHcTZ3N1ZKZXo2OHVMUzZuTG9FMHc0QlFhTFJ1Y3k1NDJhUTN0TDNaTWVzPSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiIyMDJjZmY1OS0zZmYyLTQzOTctYjYwNS01ZWY5OGE4YTQ0NTEiLCJjb2duaXRvOmdyb3VwcyI6WyJwcmFjdGl0aW9uZXIiXSwiZW1haWxfdmVyaWZpZWQiOnRydWUsImlzcyI6Imh0dHBzOlwvXC9jb2duaXRvLWlkcC5hcC1zb3V0aC0xLmFtYXpvbmF3cy5jb21cL2FwLXNvdXRoLTFfQWJHNUxLWVNuIiwicGhvbmVfbnVtYmVyX3ZlcmlmaWVkIjp0cnVlLCJjdXN0b206Z3JvdXAiOiJwcmFjdGl0aW9uZXIiLCJjb2duaXRvOnVzZXJuYW1lIjoiZHJzaHdldGhhIiwib3JpZ2luX2p0aSI6IjkyMjMxODFiLTE1OTQtNGMyYy04NDhhLTE5OGMxM2Q1YTM3MSIsImN1c3RvbTp0ZW5hbnRJZCI6ImY1MjAwZGE5LTU1YzAtNDM1Ny05Zjk2LTA4ZmIwOWY0M2NkNyIsImF1ZCI6IjVuMW5hZHB0dnNqMHJuOGowaWRpYm11MmRkIiwiZXZlbnRfaWQiOiIzNDFkYjhkYy0yNGRiLTRmMmQtYmFlOS04MDA4MzFjMTA3ZWQiLCJjdXN0b206T3JpZ2luIjoic3RhZ2UiLCJ0b2tlbl91c2UiOiJpZCIsImF1dGhfdGltZSI6MTcwMTE5ODM0MywicGhvbmVfbnVtYmVyIjoiKzQ1OTE5OTk3NTgiLCJleHAiOjE3MDEyODQ3NDMsImlhdCI6MTcwMTE5ODM0MywianRpIjoiNzgwMWE1MjQtMjY4Mi00YWJkLWI2OGQtMGYzMGEwODYxNWVlIiwiZW1haWwiOiJTaHdldGhhZ2szNEBnbWFpbC5jb20ifQ.yBXZ-E8HaAaJO-qg0-cf5S3O9-ay5lllluxv9fQ0LmSB5PEUsccFdhb6qddecawBY0bNGQjhW2iXB2S_KM0CrTnuL_H7YyC9HWSEyboIL-a8OT4-Y9gKjjp-ReDR8QIJ2xteH-6IKPjGWUskVq8qkQ_ksAZrvHY5DB7GUJ5t0psQzRWrk34FthEUZQIXPnVdZ2XQAG7T_SpDkF_yJcbbvTzaSXyJavSoSFk5iSjBMAoNIH98CxiuE1Dm7-v1RmyyTepkaVT-xbcZxGbbwD4DY3X7Ov-lTZ8JqPRZETjdMsip-f1oz3PeBuKu68IgFBZ16FFzTbQtO6nVUKmoA7yI-Q"; // Replace with your bearer token
        String apiUrl = "https://gx6ojg7vs2.execute-api.ap-south-1.amazonaws.com/SB01/Bundle"; // Replace with your API endpoint

        List<PatientEntry> entries = new ArrayList<>();

        // Generate 100 fake patients
        for (int i = 0; i < 100; i++) {
            String uuid = UUID.randomUUID().toString();

            // Construct patient details (modify these details as needed)
            Patient patient = new Patient(
                    "Patient",
                    new Name("Fake" + i, "Fake"),
                    new Address("Denmark", "Lillerød", "home", "123456", "Capital Region of Denmark", "physical"),
                    new Telecom("phone", "+1234567890"),
                    "male"
            );

            // Create patient entry
            PatientEntry patientEntry = new PatientEntry("urn:uuid:" + uuid, patient, new Request("POST", "Patient"));
            entries.add(patientEntry);

            // Print ID for each patient
            System.out.println("Patient ID: " + uuid);
        }

        // Construct the Bundle
        Bundle bundle = new Bundle("transaction", entries);

        // Convert Bundle to JSON
        Gson gson = new Gson();
        String jsonBody = gson.toJson(bundle);

        // Send the JSON body to the API (implement your sending logic)
        // sendToAPI(apiUrl, token, jsonBody);
    }

    // Define the classes needed for the JSON structure (Patient, Name, Address, Telecom, Bundle, PatientEntry, Request)
    // ...

    // Remaining classes remain the same as in the previous examples
}
