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
        print("μ μ§! ")
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
            print("π")
            println()
        }
    }

    override fun finalResultDisplay() {
        val winners = racingCarsImpl.whoIsWinner() // μ°μΉμλ€ λͺ©λ‘
        print("\nβ­β­β­β­β­ μ°μΉμ ππ β­β­β­β­β­\nβ­β­β­β­β­ μΆνν©λλ€! β­β­β­β­β­\n")
        for (winner in winners) {
            println("    ${winner.name} [μμΉ : ${winner.curLocation}]    ")
        }
    }
}