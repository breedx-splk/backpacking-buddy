package io.opentelemetry.example.bb

import android.app.Application
import android.util.Log
import io.opentelemetry.android.OpenTelemetryRum
import io.opentelemetry.android.OpenTelemetryRumBuilder
import io.opentelemetry.android.config.OtelRumConfig
import io.opentelemetry.android.features.diskbuffering.DiskBufferingConfiguration

class BackpackingBuddyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.i("bb", "Initializing the opentelemetry-android-agent")
        val diskBufferingConfig = DiskBufferingConfiguration.builder()
            .setEnabled(true)
            .build()
        val config = OtelRumConfig()
            .setDiskBufferingConfiguration(diskBufferingConfig)
        val otelRumBuilder: OpenTelemetryRumBuilder = OpenTelemetryRum.builder(this, config)
        try {
            val rum = otelRumBuilder.build()
            Log.d("bb", "RUM session started: " + rum.rumSessionId)
        } catch (e: Exception) {
            Log.e("bb", "Oh no!", e)
        }
    }
}