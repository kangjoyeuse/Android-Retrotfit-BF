package com.kangjoyeuse.submissionbfaa2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kangjoyeuse.submissionbfaa2.api.ApiConfig
import com.kangjoyeuse.submissionbfaa2.model.EventResponse
import com.kangjoyeuse.submissionbfaa2.model.ListEventsItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EventViewModel : ViewModel() {
    private val _events = MutableLiveData<List<ListEventsItem>>()
    val events: LiveData<List<ListEventsItem>> = _events

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun getEvents(active: Int) {
        _isLoading.value = true
        val client = ApiConfig.getApiService().getEvents(active)
        client.enqueue(object : Callback<EventResponse> {
            override fun onResponse(call: Call<EventResponse>, response: Response<EventResponse>) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    _events.value = response.body()?.listEvents
                } else {
                    _error.value = "Error: ${response.code()}"
                }
            }

            override fun onFailure(call: Call<EventResponse>, t: Throwable) {
                _isLoading.value = false
                _error.value = "Error: ${t.message}"
            }
        })
    }
}