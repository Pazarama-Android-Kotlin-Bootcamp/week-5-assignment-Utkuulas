package com.merttoptas.retrofittutorial.ui.users.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.merttoptas.retrofittutorial.data.model.DataState
import com.merttoptas.retrofittutorial.data.model.User
import com.merttoptas.retrofittutorial.data.model.UserDTO
import com.merttoptas.retrofittutorial.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {
    private var _userLiveData = MutableLiveData<DataState<List<UserDTO>?>>()

    val userLiveData: LiveData<DataState<List<UserDTO>?>>
        get() = _userLiveData

    init {
        getUsers()
    }

    private fun getUsers() {
        _userLiveData.postValue(DataState.Loading())
        userRepository.getUsers().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if(response.isSuccessful) {
                    response.body()?.let {

                        _userLiveData.postValue(DataState.Success(it.map {safeUser ->
                            UserDTO(
                                id = safeUser.id,
                                username = safeUser.username
                            )
                        }))

                    } ?: kotlin.run {
                        _userLiveData.postValue(DataState.Error("Data Empty"))
                    }
                } else {
                    _userLiveData.postValue(DataState.Error(response.message()))
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                _userLiveData.postValue(DataState.Error(t.message.toString()))
            }
        })
    }
}