package ModernJava.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class OptionalPlayGround {

    private static Logger logger = LoggerFactory.getLogger(OptionalPlayGround.class);

    public static void main(String[] args) {
        Person person = new Person();
        person.setAge(19);
        Car car = new Car();

        Optional<Car> optCar = Optional.empty();
        logger.info("{}", optCar);


        Insurance insurance = new Insurance();
        insurance.setName("jay-Ho");

        car.setInsurance(Optional.ofNullable(insurance));
        person.setCar(Optional.ofNullable(car));


        // non Optional
        String name = null;
        if (insurance != null) {
            name = insurance.getName();
        }
        // use Optional
        Optional<Insurance> optInsurance = Optional.ofNullable(insurance);
        Optional<String> name2 = optInsurance.map(Insurance::getName);

        logger.info("{} {}", name, name2);

        // 이것이 옵셔녈의 핵심이 아닐까 싶다.
        // null 체크 하기 위해 여러단계의 조건 분기문을 추가하여 복잡해지지 않고 가독성 있게 처리할 수 있게.
        // flatMap을 이용해 Optional의 제네릭 타입을 같은 차원(1차원)으로 평준화 한다.
        // 그냥 Map을 사용할 경우 Optional<Optional<Car>> .. Optional<Optional<Optional<Insurance>>> 와 같이 랩핑 되서 가독성을 해치고 복잡해진다.
        String r1 = Optional.ofNullable(person).flatMap(Person::getCar)
                                               .flatMap(Car::getInsurance)
                                               .map(Insurance::getName).orElse("UnKnown");

        logger.info(r1);

        // Optional 필터링
        String r2 = Optional.ofNullable(person).filter(p -> p.getAge() >= 20)
                                               .flatMap(Person::getCar)
                                               .flatMap(Car::getInsurance)
                                               .map(Insurance::getName)
                                               .orElse("UnKnown");


        logger.info(r2);

    }
}
