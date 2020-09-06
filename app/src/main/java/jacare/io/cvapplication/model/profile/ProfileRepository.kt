package jacare.io.cvapplication.model.profile

import jacare.io.cvapplication.domain.LoadProfileUsecase
import jacare.io.cvapplication.domain.LoadProfileUsecaseImpl

interface ProfileRepository {
    fun fetchProfile(): LoadProfileUsecase
}

class ProfileRepositoryImpl(
    private val profileApi: ProfileApi
) : ProfileRepository {
    override fun fetchProfile() = LoadProfileUsecaseImpl(profileApi)
}