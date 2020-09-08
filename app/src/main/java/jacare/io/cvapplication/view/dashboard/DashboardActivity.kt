package jacare.io.cvapplication.view.dashboard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import io.reactivex.disposables.Disposable
import jacare.io.cvapplication.R
import jacare.io.cvapplication.app.CvApp
import jacare.io.cvapplication.databinding.ActivityMainBinding
import jacare.io.cvapplication.view.experience.ExperienceActivity
import jacare.io.cvapplication.view.experience.ExperienceAdapter
import javax.inject.Inject

class DashboardActivity : AppCompatActivity() {
    private var experienceDisposable: Disposable? = null

    @Inject
    lateinit var state: DashboardContract.State

    @Inject
    lateinit var viewModel: DashboardContract.ViewModel

    @Inject
    lateinit var skillAdapter: SkillAdapter

    @Inject
    lateinit var experienceAdapter: ExperienceAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as CvApp).component.plus(DashboardModule()).inject(this)

        DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        ).apply {
            state = this@DashboardActivity.state
            viewModel = this@DashboardActivity.viewModel
            skillAdapter = this@DashboardActivity.skillAdapter
            experienceAdapter = this@DashboardActivity.experienceAdapter
        }

        experienceDisposable = experienceAdapter.onClick
            .map { ExperienceActivity.getStartIntent(this, it) }
            .subscribe { startActivity(it) }

        viewModel.initialize()
    }
}