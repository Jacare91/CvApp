package jacare.io.cvapplication.view.experience

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import io.reactivex.disposables.Disposable
import jacare.io.cvapplication.R
import jacare.io.cvapplication.app.CvApp
import jacare.io.cvapplication.databinding.ActivityExperienceBinding
import jacare.io.cvapplication.view.dashboard.SkillAdapter
import javax.inject.Inject

class ExperienceActivity : AppCompatActivity() {
    private var productViewDisposable: Disposable? = null

    @Inject
    internal lateinit var state: ExperienceContract.State

    @Inject
    internal lateinit var viewModel: ExperienceContract.ViewModel

    @Inject
    internal lateinit var technologiesAdapter: SkillAdapter

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
            adapter = this@ExperienceActivity.technologiesAdapter
        }

        viewModel.initialize(intent.getLongExtra(KEY_ID, -1))

        productViewDisposable = viewModel.openStore.subscribe {
            viewProduct(it.first, it.second)
        }
    }

    private fun viewProduct(storeUrl: String, default: String) {
        try {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(storeUrl)))
        } catch (e: ActivityNotFoundException) {
            e.printStackTrace()
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(default)))
        }
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