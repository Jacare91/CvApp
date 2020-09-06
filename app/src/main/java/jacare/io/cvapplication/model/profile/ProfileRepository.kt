package jacare.io.cvapplication.model.profile

import io.reactivex.Single

interface ProfileRepository {
    fun fetchProfile(): Single<PersonProfile>
}

class ProfileRepositoryImpl : ProfileRepository {
    override fun fetchProfile(): Single<PersonProfile> {
        return Single.just(
            PersonProfile(
                "Tomek Spędzia",
                "https://scontent.fwaw3-1.fna.fbcdn.net/v/t31.0-8/18209228_1493012764106249_5651111117674013435_o.jpg?_nc_cat=108&_nc_sid=174925&_nc_ohc=ZtMTp4pXUhMAX-iScCv&_nc_ht=scontent.fwaw3-1.fna&oh=4ce603a378b0a5fc880779bc8935641b&oe=5F79272B"
            )
        )
    }

}