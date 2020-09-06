package jacare.io.cvapplication.dashboard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import jacare.io.cvapplication.R
import jacare.io.cvapplication.app.CvApp
import jacare.io.cvapplication.databinding.ActivityMainBinding
import javax.inject.Inject

class DashboardActivity : AppCompatActivity() {
    @Inject
    lateinit var state: DashboardContract.State

    @Inject
    lateinit var viewModel: DashboardContract.ViewModel

    @Inject
    lateinit var adapter: SkillAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as CvApp).component.plus(DashboardModule()).inject(this)

        DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        ).apply {
            state = this@DashboardActivity.state
            viewModel = this@DashboardActivity.viewModel
            adapter = this@DashboardActivity.adapter
        }
        
        viewModel.initialize()
    }
}