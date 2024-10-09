package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    lateinit var usernameInput : EditText
    lateinit var passwordInput : EditText
    lateinit var loginBtn : Button

    private var counter = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        usernameInput = findViewById(R.id.username_input)
        passwordInput = findViewById(R.id.password_input)
        loginBtn = findViewById(R.id.login_btn)

        loginBtn.setOnClickListener {
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()
            Log.i("Test Credential", "Usernamev: $username and Password : $password")

            if (username == "hardcodeado" && password == "hardcodeado") {
                val intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)
            } else {
                counter--
                if (counter > 0) {
                    Toast.makeText(
                        this,
                        "Incorrect username or password. Attempts left: $counter",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    loginBtn.isEnabled = false
                    Toast.makeText(
                        this,
                        "Too many incorrect attempts. Try again later.",
                        Toast.LENGTH_SHORT
                    ).show()

                    Handler(Looper.getMainLooper()).postDelayed({
                        loginBtn.isEnabled = true
                        counter = 3
                    }, 10000)
                }
            }
        }
    }
}