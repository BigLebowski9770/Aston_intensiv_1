package com.kipreev.aston_intensiv_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.kipreev.aston_intensiv_1.domain.User
import com.kipreev.aston_intensiv_1.presentation.SecondActivity

class MainActivity : AppCompatActivity() {

    private lateinit var buttonToast: Button
    private lateinit var inputFirstName: TextView
    private lateinit var inputLastName: TextView
    private lateinit var buttonLogIn: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputFirstName = findViewById(R.id.input_first_Name)
        inputLastName = findViewById(R.id.input_last_Name)
        buttonLogIn = findViewById(R.id.log_in)

        infoInLogsAboutDataAndScopeFun()

        buttonLogIn.setOnClickListener {
            if (inputFirstName.text.toString() == "" || (inputLastName.text.toString() == "")
            ) {
                Toast.makeText(this, "Empty field", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, SecondActivity::class.java)
                startActivity(intent)
            }
        }

    }

    private fun infoInLogsAboutDataAndScopeFun() {
        val user = User("Max", "Kipreev", 25)
        val user1 = User("Den", "Mineev", 54)
        Log.d(TAG, (user == user1).toString())
        Log.d(TAG, user.hashCode().toString())
        Log.d(TAG, user1.hashCode().toString())

        val user3: String? = "This is a nullability test for Let Scope Fun"
        user3?.let {
            if (it.length > 5) Log.d(TAG, "Length String user3 > 5")
        }


        val user4 = User("Sam", "Ivanov", 43)
        with(user4) {
            firstName = "Maxim"
            Log.d(TAG, this.toString())
        }

        var user5 = User("Nick", "Nikitin", 30)
        var user6 = User("Vick", "Vikitin", 35)
        user5 = user6.also { user6 = user5 }
        Log.d(TAG, "user5 = $user5 and user6 = $user6")

        val user7 = User("Marina", "Arakadabra", 27)
        user7.run {
            firstName = "Irina"
            Log.d(TAG, user7.toString())
        }

        val user8 = User("50").apply {
            lastName = "Cent"
            age = 47
        }
        Log.d(TAG, user8.toString())


    }

    companion object {
        const val TAG = "On Main Activity example"
        private const val TAG1 = "Test Expression Fun"
    }
}
