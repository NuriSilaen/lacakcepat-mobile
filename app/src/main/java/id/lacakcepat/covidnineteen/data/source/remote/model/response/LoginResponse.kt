package id.lacakcepat.covidnineteen.data.source.remote.model.response

import com.google.gson.annotations.SerializedName
import id.lacakcepat.covidnineteen.data.source.remote.model.response.LoginData

data class LoginResponse(
    @SerializedName("code")
    val code: Int,
    @SerializedName("status")
    val status: String,
    @SerializedName("token")
    val token: String,
    @SerializedName("users_data")
    val loginData: LoginData
)