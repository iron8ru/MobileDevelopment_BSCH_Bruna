package com.example.mobiledevolopment.data.repository
import com.example.mobiledevolopment.util.Resource
import com.example.mobiledevolopment.util.await
import com.google.firebase.auth.FirebaseAuth


// This class is responsible for handling Firebase authentication operations.
class FirebaseAuthenticationRepo {
    // Firebase authentication instance
    private var auth: FirebaseAuth = FirebaseAuth.getInstance()

    // Function to register a user with the provided email and password
    suspend fun register(email: String, password: String): Resource<String?> {
        return try {
            // Indicate that the operation is in progress (loading)
            Resource.Loading
            // Attempt to create a new user with the provided email and password
            val result = auth.createUserWithEmailAndPassword(email, password).await()
            // Return a success result with the user's email if registration is successful
            Resource.Success(result.user?.email)
        } catch (ex: Exception) {
            // Return an error result with the exception message if registration fails
            Resource.Error(Throwable(ex.message))
        }
    }

    // Function to log in a user with the provided email and password
    suspend fun login(email: String, password: String): Resource<String?> {
        return try {
            Resource.Loading
            val result = auth.signInWithEmailAndPassword(email, password).await()
            Resource.Success(result.user?.email)
        } catch (ex: Exception) {
            // Return an error result with the exception message if login fails
            Resource.Error(Throwable(ex.message))
        }
    }
}