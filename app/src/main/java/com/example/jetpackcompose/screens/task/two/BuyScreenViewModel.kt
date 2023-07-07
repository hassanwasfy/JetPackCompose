package com.example.jetpackcompose.screens.task.two

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.flow.updateAndGet
import javax.inject.Inject
import kotlin.random.Random

class BuyScreenViewModel @Inject constructor(): ViewModel() {
    private val _center: MutableStateFlow<List<Seat>> = MutableStateFlow(SeatsFactory().centerColum)
    private val _left: MutableStateFlow<List<Seat>> = MutableStateFlow(SeatsFactory().leftColum)
    private val _right: MutableStateFlow<List<Seat>> = MutableStateFlow(SeatsFactory().rightColum)

    val center = _center.asStateFlow()
    val left = _left.asStateFlow()
    val right = _right.asStateFlow()

    fun refresh(){
        val newFactory = SeatsFactory()
        _center.update { MutableStateFlow(newFactory.refresh()).value}
        _left.update { MutableStateFlow(newFactory.refresh()).value}
        _right.update { MutableStateFlow(newFactory.refresh()).value}

    }

}


class SeatsFactory(){
    init {
        seatFiller()
    }

    fun refresh(): List<Seat> {
        return seatFiller().shuffled().take(5)
    }

    val leftColum = seatFiller().shuffled().take(5)
    val centerColum = seatFiller().shuffled().take(5)
    val rightColum = seatFiller().shuffled().take(5)

    private fun seatFiller(): List<Seat>{
        val list = mutableListOf<Seat>()
        for (i in 0 until 25){
            val c1 = getRandomChairStatus()
            val c2 = getRandomChairStatus()
            list.add(Seat(Chair(c1),Chair(c2)))
        }
        return list.toList()
    }
    private fun getRandomChairStatus(): ChairStatus {
        val randomIndex = Random.nextInt(0, ChairStatus.values().size)
        return ChairStatus.values()[randomIndex]
    }
}