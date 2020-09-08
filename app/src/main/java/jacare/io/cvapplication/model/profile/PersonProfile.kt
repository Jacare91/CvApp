package jacare.io.cvapplication.model.profile

import com.google.gson.annotations.SerializedName

class PersonProfile(
    @SerializedName("name")
    val name: String,
    @SerializedName("portrait")
    val portrait: String,
    @SerializedName("role")
    val role: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("shortBio")
    val shortBio: String,
    @SerializedName("knownSkills")
    val knownSkills: String
)