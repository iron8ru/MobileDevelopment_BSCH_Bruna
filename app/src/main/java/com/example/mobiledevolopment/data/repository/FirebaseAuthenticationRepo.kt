package com.example.mobiledevolopment.data.repository
import com.example.mobiledevolopment.util.Resource
import com.example.mobiledevolopment.util.await
import com.google.firebase.auth.FirebaseAuth

class FirebaseAuthenticationRepo {
    private var auth: FirebaseAuth = FirebaseAuth.getInstance()
    suspend fun register(email: String, password: String): Resource<String?> {
        return try {
            Resource.Loading
            val result = auth.createUserWithEmailAndPassword(email, password).await()
            Resource.Success(result.user?.email)
        } catch (ex: Exception) {
            Resource.Error(Throwable(ex.message))
        }
    }

    suspend fun login(email: String, password: String): Resource<String?> {
        return try {
            Resource.Loading
            val result = auth.signInWithEmailAndPassword(email, password).await()
            Resource.Success(result.user?.email)
        } catch (ex: Exception) {
            Resource.Error(Throwable(ex.message))
        }
    }
}