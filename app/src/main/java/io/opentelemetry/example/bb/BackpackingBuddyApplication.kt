package io.opentelemetry.example.bb

import android.annotation.SuppressLint
import android.app.Application
import android.util.Log
import io.opentelemetry.android.OpenTelemetryRum
import io.opentelemetry.android.OpenTelemetryRumBuilder
import io.opentelemetry.android.config.OtelRumConfig
import io.opentelemetry.android.features.diskbuffering.DiskBufferingConfiguration
import io.opentelemetry.android.internal.services.ServiceManager
import io.opentelemetry.api.trace.Tracer
import io.opentelemetry.exporter.otlp.http.trace.OtlpHttpSpanExporter
import io.opentelemetry.exporter.otlp.trace.OtlpGrpcSpanExporter

class BackpackingBuddyApplication : Application() {

    @SuppressLint("RestrictedApi")
    override fun onCreate() {
        super.onCreate()
        Log.i("bb", "Initializing the opentelemetry-android-agent")
        val diskBufferingConfig = DiskBufferingConfiguration.builder()
            .setEnabled(true)
            .setMaxCacheSize(10_000_000)
            .build()
        val config = OtelRumConfig()
            .setDiskBufferingConfiguration(diskBufferingConfig)
        val otelRumBuilder: OpenTelemetryRumBuilder = OpenTelemetryRum.builder(this, config)
            .addSpanExporterCustomizer {
                OtlpHttpSpanExporter.builder()
                    // I don't yet know of a good way to configure the local docker address...
                    // The emulator is a different VM and "localhost" doesn't work.
//                    .setEndpoint("http://localhost:4318/v1/traces")
                    .setEndpoint("http://192.168.66.1:4318/v1/traces")
                    .build()
            }
        try {
            rum = otelRumBuilder.build()
//            ServiceManager.get().start();
            Log.d("bb",  "RUM session started: " + rum!!.rumSessionId)
        } catch (e: Exception) {
            Log.e("bb", "Oh no!", e)
        }
    }

    companion object {
        var rum: OpenTelemetryRum? = null
        fun tracer(name: String): Tracer? {
            return rum?.openTelemetry?.tracerProvider?.get(name)
        }
    }
}