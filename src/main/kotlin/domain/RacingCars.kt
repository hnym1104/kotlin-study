package domain

interface RacingCars {

    fun initCars(number: Int)   // count 횟수 동안 number대의 자동차는 전진 가능

    fun racing(count: Int)

    fun whoIsWinner(): Int
}