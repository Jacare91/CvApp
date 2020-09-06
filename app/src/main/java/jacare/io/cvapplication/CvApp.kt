package jacare.io.cvapplication

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

class CvApp: Application() {
    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
    }
}