package com.example.textracerapp.data

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import java.io.BufferedOutputStream
import java.io.OutputStream
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL

class registerClient {
    fun RegisterWith(email: String, password: String): Deferred<RegistrationResult> = GlobalScope.async(
        Dispatchers.IO) {
        // Specify the API endpoint for registration
        val apiUrl = "https://inhollandbackend.azurewebsites.net/api/Users/register"

        // JSON request body for registration
        val requestBody = """{"UserName": "$email", "Password": "$password"}"""

        try {
            // Create URL object
            val url = URL(apiUrl)

            // Open connection
            val connection = url.openConnection() as HttpURLConnection

            // Set request method to POST
            connection.requestMethod = "POST"

            // Enable input/output streams
            connection.doInput = true
            connection.doOutput = true

            // Set content type
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8")

            // Write the request body to the output stream
            val outputStream: OutputStream = BufferedOutputStream(connection.outputStream)
            val outputStreamWriter = OutputStreamWriter(outputStream, "UTF-8")
            outputStreamWriter.write(requestBody)
            outputStreamWriter.flush()
            outputStreamWriter.close()

            // Get the response code
            val responseCode = connection.responseCode
            println("Response Code: $responseCode")

            // Read the response (optional)
            val inputStream = connection.inputStream
            val response = inputStream.bufferedReader().use { it.readText() }
            println("Response: $response")

            // Close the connection
            connection.disconnect()

            // Check the response code and create a RegistrationResult accordingly
            if (responseCode == 200) {
                RegistrationResult(true, "User registered")
            } else {
                RegistrationResult(false, "Registration failed")
            }

        } catch (e: Exception) {
            e.printStackTrace()
            RegistrationResult(false, "Registration failed")
        }
    }

    data class RegistrationResult(val success: Boolean = false, val message: String = "")

}
