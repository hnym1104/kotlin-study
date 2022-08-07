package domain.impl

import domain.Car
import domain.RacingCars
import java.util.*

class RacingCarsImpl: RacingCars {

    private val cars: MutableList<Car> = arrayListOf()

    override fun initCars(number: Int) = with(Scanner(System.`in`)) {
        for (i in 1..number) {
            print("${i}번쨰 자동차의 이름을 5자 이하로 입력하세요 : ")
            var name = nextLine()
            while (name.length > 5) {
                print("자동차의 이름은 5자를 초과할 수 없습니다. 이름을 다시 입력하세요 : " )
                name = nextLine()
            }
            println("자동차 이름 : $name")
            cars.add(Car(name, 0))
        }

        for (car in cars) {
            println("이름 : ${car.name}, 출발위치 : ${car.curLocation}")
        }
    }

    override fun racing(count: Int) {
        TODO("지정 횟수동안 경기 진행")
    }

    override fun whoIsWinner(): Int {
        TODO("우승자 전달")
    }
}