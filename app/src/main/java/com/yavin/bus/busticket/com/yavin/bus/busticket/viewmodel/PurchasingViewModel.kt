package com.yavin.bus.busticket.com.yavin.bus.busticket.viewmodel

import androidx.lifecycle.*
import androidx.databinding.Bindable
import kotlin.math.round

class PurchasingViewModel : ViewModel() {

    /*define bindable val*/
    @Bindable
    val inputSingleJourney = MutableLiveData<String>()

    @Bindable
    val inputDayTicket = MutableLiveData<String>()

    @Bindable
    val inputWeekTicket = MutableLiveData<String>()

    @Bindable
    val totalSingleJourney = MutableLiveData<String>()

    @Bindable
    val totalDayTicket = MutableLiveData<String>()

    @Bindable
    val totalWeekTicket = MutableLiveData<String>()

    @Bindable
    var totalTicketPrice = MutableLiveData<String>()

    /*Declare observers*/
    val inputSingleJourneyObserver = Observer<String> { newValue ->
        totalSingleJourney.value =
            (round(((newValue.toInt()) * SINGLE_JOURNEY_PRICE * 100)) / 100).toString()
        var price: Double = ((totalSingleJourney.value)?.toDouble() ?: 0.0)
        price += (totalDayTicket.value)?.toDouble() ?: 0.0
        price += (totalWeekTicket.value)?.toDouble() ?: 0.0
        totalTicketPrice.value = price.toString()

    }
    val inputDayTicketObserver = Observer<String> { newValue ->
        totalDayTicket.value =
            (round(((newValue.toInt()) * DAY_TICKET_PRICE) * 100) / 100).toString()
        var price: Double = ((totalSingleJourney.value)?.toDouble() ?: 0.0)
        price += (totalDayTicket.value)?.toDouble() ?: 0.0
        price += (totalWeekTicket.value)?.toDouble() ?: 0.0
        totalTicketPrice.value = price.toString()
    }
    val inputWeekTicketObserver = Observer<String> { newValue ->
        totalWeekTicket.value =
            (round((((newValue.toInt()) * WEEK_TICKET_PRICE).toDouble()) * 100) / 100).toString()
        var price: Double = ((totalSingleJourney.value)?.toDouble() ?: 0.0)
        price += (totalDayTicket.value)?.toDouble() ?: 0.0
        price += (totalWeekTicket.value)?.toDouble() ?: 0.0
        totalTicketPrice.value = round(price).toString()
    }

    init {
        inputSingleJourney.observeForever(inputSingleJourneyObserver)
        inputDayTicket.observeForever(inputDayTicketObserver)
        inputWeekTicket.observeForever(inputWeekTicketObserver)
        totalDayTicket.value = 0.toString()
        totalWeekTicket.value = 0.toString()
        totalSingleJourney.value = 0.toString()
    }

    override fun onCleared() {
        inputSingleJourney.removeObserver(inputSingleJourneyObserver)
        super.onCleared()
    }

    companion object {
        /*define constant*/
        const val SINGLE_JOURNEY_PRICE = 1.10
        const val DAY_TICKET_PRICE = 2.50
        const val WEEK_TICKET_PRICE = 12
    }
}

class PurchasingViewModelFactory() : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PurchasingViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PurchasingViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}