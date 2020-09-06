package jacare.io.cvapplication.app

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

class CvApp: Application() {
    val component by lazy {
        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
    }
}