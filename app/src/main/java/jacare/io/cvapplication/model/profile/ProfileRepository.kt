package jacare.io.cvapplication.model.profile

import jacare.io.cvapplication.domain.profile.LoadProfileUsecase
import jacare.io.cvapplication.domain.profile.LoadProfileUsecaseImpl

interface ProfileRepository {
    fun fetchProfile(): LoadProfileUsecase
}

class ProfileRepositoryImpl(
    private val profileApi: ProfileApi
) : ProfileRepository {
    override fun fetchProfile() =
        LoadProfileUsecaseImpl(profileApi)
}