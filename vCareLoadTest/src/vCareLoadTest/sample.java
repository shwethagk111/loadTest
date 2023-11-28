package vCareLoadTest;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class sample {

    public static void main(String[] args) {
        List<PatientEntry> entries = new ArrayList<>();
        
        // Creating two patient entries
        entries.add(createPatientEntry("Jameson", "Matt", "+917411555320"));
        entries.add(createPatientEntry("Smith", "John", "+917411555320"));
        entries.add(createPatientEntry("Smith", "John", "+917411555320"));

        // Constructing the Bundle
        Bundle bundle = new Bundle("transaction", entries);

        // Convert the Bundle to JSON
        Gson gson = new Gson();
        String jsonBody = gson.toJson(bundle);

        // Output the constructed JSON body
        System.out.println(jsonBody);
    }

    // Method to create a patient entry
    private static PatientEntry createPatientEntry(String familyName, String givenName, String phoneNumber) {
        String uuid = UUID.randomUUID().toString();
        String fullUrl = "urn:uuid:" + uuid;

        Patient patient = new Patient(
                "Patient",
                new Name(familyName, givenName),
                new Address("Denmark", "Lillerød", "home", "123456", "Capital Region of Denmark", "physical"),
                new Telecom("phone", phoneNumber),
                "male"
        );

        return new PatientEntry(fullUrl, patient, new Request("POST", "Patient"));
    }

    // Classes to model the provided JSON structure
    static class Bundle {
        private String resourceType;
        private String type;
        private List<PatientEntry> entry;

        public Bundle(String type, List<PatientEntry> entry) {
            this.resourceType = "Bundle";
            this.type = type;
            this.entry = entry;
        }
    }

    static class PatientEntry {
        private String fullUrl;
        private Patient resource;
        private Request request;

        public PatientEntry(String fullUrl, Patient resource, Request request) {
            this.fullUrl = fullUrl;
            this.resource = resource;
            this.request = request;
        }
    }

    static class Patient {
        private String resourceType;
        private Name name;
        private Address address;
        private Telecom telecom;
        private String gender;

        public Patient(String resourceType, Name name, Address address, Telecom telecom, String gender) {
            this.resourceType = resourceType;
            this.name = name;
            this.address = address;
            this.telecom = telecom;
            this.gender = gender;
        }
    }

    static class Name {
        private String family;
        private String[] given;

        public Name(String family, String givenName) {
            this.family = family;
            this.given = new String[]{givenName};
        }
    }

    static class Address {
        private String country;
        private String city;
        private String use;
        private String postalCode;
        private String state;
        private String type;

        public Address(String country, String city, String use, String postalCode, String state, String type) {
            this.country = country;
            this.city = city;
            this.use = use;
            this.postalCode = postalCode;
            this.state = state;
            this.type = type;
        }
    }

    static class Telecom {
        private String system;
        private String value;

        public Telecom(String system, String value) {
            this.system = system;
            this.value = value;
        }
    }

    static class Request {
        private String method;
        private String url;

        public Request(String method, String url) {
            this.method = method;
            this.url = url;
        }
    }
}
