package jacare.io.cvapplication.view.experience

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import jacare.io.cvapplication.R
import jacare.io.cvapplication.app.CvApp
import jacare.io.cvapplication.databinding.ActivityExperienceBinding
import javax.inject.Inject

class ExperienceActivity : AppCompatActivity() {
    @Inject
    internal lateinit var state: ExperienceContract.State
    @Inject
    internal lateinit var viewModel: ExperienceContract.ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as CvApp).component
            .plus(ExperienceModule())
            .inject(this)

        DataBindingUtil.setContentView<ActivityExperienceBinding>(
            this,
            R.layout.activity_experience
        ).apply {
            state = this@ExperienceActivity.state
            viewModel = this@ExperienceActivity.viewModel
        }

        viewModel.initialize(intent.getLongExtra(KEY_ID, -1))
    }

    companion object {
        private const val KEY_ID = "experienceId"

        fun getStartIntent(
            context: Context,
            experienceId: Long
        ) = Intent(context, ExperienceActivity::class.java).apply {
            putExtra(KEY_ID, experienceId)
        }
    }
}