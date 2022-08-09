package domain

import view.Display

interface RacingCars {

    fun initCars(number: Int)   // count 횟수 동안 number대의 자동차는 전진 가능

    fun racing(count: Int)

    fun subscribe(display: Display)

    fun notifyRacing()

    fun whoIsWinner(): List<Car>

    fun getCars(): List<Car>

    fun getGo(): List<Boolean>

    fun getRandomMove(): List<Int>
}