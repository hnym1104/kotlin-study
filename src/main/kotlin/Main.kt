import domain.impl.RacingCarsImpl
import view.impl.DisplayImpl
import java.util.Scanner

fun main(): Unit = with(Scanner(System.`in`)) {

    // 주어진 횟수, n대의 자동차 입력받기
    print("경주 횟수를 입력하세요 : ")
    val count = nextInt()
    print("자동차 갯수를 입력하세요 : ")
    val number = nextInt()

    val racingCars = RacingCarsImpl()   // 자동차 경주 서비스 로직
    val display = DisplayImpl(racingCars)
    racingCars.subscribe(display)

    racingCars.initCars(number)   // 자동차 수 만큼 생성
    racingCars.racing(count)   // 자동차 경주 시작

    display.finalResultDisplay()

    // print("hello world")
}