package domain.impl

import domain.Car
import domain.RacingCars
import view.Display
import java.security.SecureRandom
import java.util.*
import kotlin.Comparator

class RacingCarsImpl(
) : RacingCars {

    private val cars: MutableList<Car> = arrayListOf()   // 경주에 참여하는 자동차들
    private var randomMove: MutableList<Int> = arrayListOf()   // 랜덤 이동 수
    private var go: MutableList<Boolean> = arrayListOf()   // 전진 여부

    private var displays: MutableList<Display> = arrayListOf()   // 이 경주를 구독하고있는 디스플레이

    override fun initCars(number: Int) = with(Scanner(System.`in`)) {
        for (i in 1..number) {
            print("${i}번쨰 자동차의 이름을 5자 이하로 입력하세요(이름의 중복은 허용되지 않습니다) : ")
            var name = nextLine()
            while (name.length > 5 || cars.contains(cars.find { it.name == name })) {
                print("자동차의 이름이 5자를 초과했거나 중복 이름입니다. 이름을 다시 입력하세요 : ")
                name = nextLine()
            }
            println("자동차 이름 : $name")
            randomMove.add(0)   // 자동차 수만큼 각 자동차의 전진을 나타낼 수 있는 리스트 초기화
            go.add(false)   // 전진하는 자동차가 누구인지
            cars.add(Car(name, 0))
        }
    }

    override fun racing(count: Int) {
        val secureRandom = SecureRandom()
        println("\n경주를 시작합니다 🚙")
        for (i in 1..count) {
            go.replaceAll { false }
            randomMove = randomMove.map { secureRandom.nextInt(10) } as MutableList<Int>   // random 이동량

            cars.mapIndexed { index, car ->
                if (randomMove[index] >= 4) {
                    car.curLocation = car.curLocation + randomMove[index]
                    go[index] = true
                }
            }
            println()
            notifyRacing()
            Thread.sleep(1000)
        }
    }

    override fun subscribe(display: Display) {
        displays.add(display)   // 현재 상태를 알려줄 display
    }

    override fun notifyRacing() {
        for (display in displays) {
            display.racingDisplay()
        }
    }

    override fun whoIsWinner(): List<Car> {
        val winnerOne = cars.maxWith(Comparator.comparingInt { it.curLocation })
        return cars.filter { winnerOne.curLocation == it.curLocation }
    }

    override fun getCars(): List<Car> {
        return cars
    }

    override fun getGo(): List<Boolean> {
        return go
    }

    override fun getRandomMove(): List<Int> {
        return randomMove
    }

}