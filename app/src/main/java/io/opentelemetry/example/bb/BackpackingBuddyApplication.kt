package io.opentelemetry.example.bb

import android.app.Application
import android.util.Log

class BackpackingBuddyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.i("bb", "Initializing the opentelemetry-android-agent")
        //TODO: Initialize otel android sdk here
    }
}