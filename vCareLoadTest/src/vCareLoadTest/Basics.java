package vCareLoadTest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Basics {

    public static void main(String[] args) {
        String apiUrl = "https://gx6ojg7vs2.execute-api.ap-south-1.amazonaws.com/SB01/Bundle"; // Replace with your API endpoint
        String token = "eyJraWQiOiJHcTZ3N1ZKZXo2OHVMUzZuTG9FMHc0QlFhTFJ1Y3k1NDJhUTN0TDNaTWVzPSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiIyMDJjZmY1OS0zZmYyLTQzOTctYjYwNS01ZWY5OGE4YTQ0NTEiLCJjb2duaXRvOmdyb3VwcyI6WyJwcmFjdGl0aW9uZXIiXSwiZW1haWxfdmVyaWZpZWQiOnRydWUsImlzcyI6Imh0dHBzOlwvXC9jb2duaXRvLWlkcC5hcC1zb3V0aC0xLmFtYXpvbmF3cy5jb21cL2FwLXNvdXRoLTFfQWJHNUxLWVNuIiwicGhvbmVfbnVtYmVyX3ZlcmlmaWVkIjp0cnVlLCJjdXN0b206Z3JvdXAiOiJwcmFjdGl0aW9uZXIiLCJjb2duaXRvOnVzZXJuYW1lIjoiZHJzaHdldGhhIiwib3JpZ2luX2p0aSI6ImFlZmRkZDcwLTljMTAtNGExMy1iODUwLTkzYzVjYWRjZDY5NSIsImN1c3RvbTp0ZW5hbnRJZCI6ImY1MjAwZGE5LTU1YzAtNDM1Ny05Zjk2LTA4ZmIwOWY0M2NkNyIsImF1ZCI6IjVuMW5hZHB0dnNqMHJuOGowaWRpYm11MmRkIiwiZXZlbnRfaWQiOiI0ZWFjYjQ1My0yNjI4LTQ4ZDktYWU0OS0wY2U4ZjVhZDcwMjUiLCJjdXN0b206T3JpZ2luIjoic3RhZ2UiLCJ0b2tlbl91c2UiOiJpZCIsImF1dGhfdGltZSI6MTcwMDgwOTYzNiwicGhvbmVfbnVtYmVyIjoiKzQ1OTE5OTk3NTgiLCJleHAiOjE3MDA4OTYwMzYsImlhdCI6MTcwMDgwOTYzNiwianRpIjoiNTI1NTcxNTQtNTU4My00ZWVmLThiNDMtNmQ5OGYyM2RmNTA4IiwiZW1haWwiOiJTaHdldGhhZ2szNEBnbWFpbC5jb20ifQ.saPmvRrVsH57QWNXUxqJ4Lc2QrG5b8QZGs3DLuLqUHrjRT7QC2OdJ-5HP49SKf931_W0ppR2y_nq9mWwd7T4-6V7_YoFJaiXWmaqt8nii2Yb7jnqtQaofhhepNdhTSuycjDqDKQvWwkg6DP27JOkspOhpedLs0wKdaJ4crvqa78NnoeI-KjPXI9N6Rg_PHS236z4p9LLUfZk2ydlcZBTZ1NhnUq4ddH6oeKWVjSpsOyHE3P29fExCVvXb3LIZGKo3CAs4YE0mIaZ7ZdhtlYfTC5I7YmglNd6QDJW-KbuaKIsoXBnJXbKbqaRV2A6WdCySkYQng0O-UiG9svrK4uvsQ"; // Replace with your bearer token

        String jsonInput = "{\n" +
                "  \"resourceType\": \"Bundle\",\n" +
                "  \"type\": \"transaction\",\n" +
                "  \"entry\": [\n" +
                "    {\n" +
                "      \"fullUrl\": \"urn:uuid:8cafa46d-08b4-4ee4-b51b-803e20ae8126\",\n" +
                "      \"resource\": {\n" +
                "        \"resourceType\": \"Patient\",\n" +
                "        \"name\": [\n" +
                "          {\n" +
                "            \"family\": \"watt\",\n" +
                "            \"given\": [\n" +
                "              \"Matt\"\n" +
                "            ]\n" +
                "          }\n" +
                "        ],\n" +
                "        \"address\": [\n" +
                "          {\n" +
                "            \"country\": \"Denmark\",\n" +
                "            \"city\": \"Lillerød\",\n" +
                "            \"use\": \"home\",\n" +
                "            \"postalCode\": \"123456\",\n" +
                "            \"state\": \"Capital Region of Denmark\",\n" +
                "            \"type\": \"physical\"\n" +
                "          }\n" +
                "        ],\n" +
                "        \"telecom\": [\n" +
                "          {\n" +
                "            \"system\": \"phone\",\n" +
                "            \"value\": \"+917411555320\"\n" +
                "          }\n" +
                "        ],\n" +
                "        \"gender\": \"male\"\n" +
                "      },\n" +
                "      \"request\": {\n" +
                "        \"method\": \"POST\",\n" +
                "        \"url\": \"Patient\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"fullUrl\": \"urn:uuid:another-unique-identifier\",\n" +
                "      \"resource\": {\n" +
                "        \"resourceType\": \"Patient\",\n" +
                "        \"name\": [\n" +
                "          {\n" +
                "            \"family\": \"Smith\",\n" +
                "            \"given\": [\n" +
                "              \"John\"\n" +
                "            ]\n" +
                "          }\n" +
                "        ],\n" +
                "        \"address\": [\n" +
                "          {\n" +
                "            \"country\": \"Denmark\",\n" +
                "            \"city\": \"Lillerød\",\n" +
                "            \"use\": \"home\",\n" +
                "            \"postalCode\": \"123456\",\n" +
                "            \"state\": \"Capital Region of Denmark\",\n" +
                "            \"type\": \"physical\"\n" +
                "          }\n" +
                "        ],\n" +
                "        \"telecom\": [\n" +
                "          {\n" +
                "            \"system\": \"phone\",\n" +
                "            \"value\": \"+917411555320\"\n" +
                "          }\n" +
                "        ],\n" +
                "        \"gender\": \"male\"\n" +
                "      },\n" +
                "      \"request\": {\n" +
                "        \"method\": \"POST\",\n" +
                "        \"url\": \"Patient\"\n" +
                "      }\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Bearer " + token);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(jsonInput.getBytes());
            outputStream.flush();

            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}