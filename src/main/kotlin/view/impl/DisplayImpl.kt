package view.impl

import domain.RacingCars
import view.Display

data class DisplayImpl(
    private val racingCarsImpl: RacingCars
) : Display {

    override fun racingDisplay() {
        val cars = racingCarsImpl.getCars()
        val go = racingCarsImpl.getGo()
        val goCars: MutableList<String> = arrayListOf()
        print("전진! ")
        cars.filterIndexed { index, _ -> go[index] }.map { goCars.add(it.name) }
        print(
            goCars.joinToString(
                separator = ", ",
                prefix = "",
                postfix = "",
                limit = -1,
                truncated = "",
                transform = null
            )
        )
        println()
        for (car in cars) {
            print("[${car.name}] ")
            for (i in 1..car.curLocation) {
                print("= ")
            }
            print("🚙")
            println()
        }
    }

    override fun finalResultDisplay() {
        val winners = racingCarsImpl.whoIsWinner() // 우승자들 목록
        print("\n⭐⭐⭐⭐⭐ 우승자 🚙🚙 ⭐⭐⭐⭐⭐\n⭐⭐⭐⭐⭐ 축하합니다! ⭐⭐⭐⭐⭐\n")
        for (winner in winners) {
            println("    ${winner.name} [위치 : ${winner.curLocation}]    ")
        }
    }
}