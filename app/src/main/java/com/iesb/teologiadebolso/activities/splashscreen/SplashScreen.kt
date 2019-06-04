package com.iesb.teologiadebolso.activities.splashscreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.iesb.teologiadebolso.R
import com.iesb.teologiadebolso.activities.login.LoginActivity
import com.iesb.teologiadebolso.activities.onboarding.OnboardingActivity
import com.iesb.teologiadebolso.preference.UserPreference

class SplashScreen : AppCompatActivity() {

    private var mDelayHandler: Handler? = null
    private val SPLASH_DELAY: Long = 3000 //3 seconds

    internal val mRunnable: Runnable = Runnable {
        if (!isFinishing) {

            var intent: Intent? = null
            if(!UserPreference(this).onboardingViewed()){
                intent = Intent(applicationContext, OnboardingActivity::class.java)
            }else{
                intent = Intent(applicationContext, LoginActivity::class.java)
            }
            startActivity(intent)
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        //Initialize the Handler
        mDelayHandler = Handler()

        //Navigate with delay
        mDelayHandler!!.postDelayed(mRunnable, SPLASH_DELAY)

    }

    public override fun onDestroy() {

        if (mDelayHandler != null) {
            mDelayHandler!!.removeCallbacks(mRunnable)
        }

        super.onDestroy()
    }

}