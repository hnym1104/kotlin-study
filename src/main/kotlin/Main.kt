import domain.RacingCars
import domain.impl.RacingCarsImpl
import view.impl.DisplayImpl
import java.util.Scanner

fun main(): Unit = with(Scanner(System.`in`)) {

    // 주어진 횟수, n대의 자동차 입력받기
    print("경주 횟수를 입력하세요 : ")
    val count = nextInt()
    print("자동차 갯수를 입력하세요 : ")
    val number = nextInt()

    val racingCars = RacingCarsImpl()
    racingCars.initCars(count)
    racingCars.racing(number)

    val display = DisplayImpl(racingCars)
    display.display()

    // print("hello world")
}