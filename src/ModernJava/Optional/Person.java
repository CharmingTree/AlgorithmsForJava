package ModernJava.Optional;

import java.util.Optional;

public class Person {

    private Optional<Car> car;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Optional<Car> getCar() {
        return car;
    }

    public void setCar(Optional<Car> car) {
        this.car = car;
    }
}
// 도메인 모델에 Optional 사용에 대해서
// Optional 설계자 "브라이언 고츠"는 Optional 용도는 선택형 반환 값을 지원하는 것이라고 명확히 못박음
// Optional 클래스는 필드 형식으로 사용할 것을 가정하지 않았으므로 Serializable 인터페이스를 구현하지 않기 때문에
// 도메인 모델에 옵셔널을 사용할 경우 직렬화에 문제가 발생할 수 있다.
// 아래는 직렬화 문제를 해결 하는 방법중 하나이다.

class Person2 {
    private Car car;
    public Optional<Car> getCarAsOptional() {
        return Optional.ofNullable(car);
    }
}