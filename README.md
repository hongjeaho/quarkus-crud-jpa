# QUARKUS에서 JPA를 사용해 보자 

Quarkus 프로젝트는 https://code.quarkus.io 에서 쉽게 만들수 있었다. 
구성은 친숙한 Spring과 비슷하게 하기 위해서 Spring 지원 라이브러리를 추가 하였다.
driver는 H2를 선택 하였고  설정을 yaml로 하기위해 YAML Configuration 추가 하였다.
마지막으로 API 문서를 생성하기 위해서 SmallRye OpenAPI를 추가 하였다.

https://code.quarkus.io에서는 추가할 수 없어서 lombok은 별도록 추가 하였다.
자세한 내용은 build.gradle를 참고 하면 된다.

application.yml에는 database 및 jpa설정만 하였다.


## DATABASE 설치
database 설치는 docker을 이용 하였다.
귀차니즘이 심해서 docker-compose를 사용하였다.
명령어 창에 다음 명령어를 사용해서 mariaDB를 설치 해보자

```shell script
./docker-compose up -d
```

## 개발모드로 어플리케이션 실행 (라이브 코딩 가능)
DATABASE가 정성적으로 설치가 되었다면 어플리케이션을 샐행해 보자 (두근두근)

```shell script
./gradlew quarkusDev
```

## Graalvm 설치
Quarkus를 Native로 실행 하기 위해서는 먼저 Graalvm을 이용한 native image로 컴파일을 해야 한다.
Graalvm Community Edition 을 다운 받아서 설치 해자 자세한 설치 방법은  https://www.graalvm.org/docs/getting-started/를 참고 하면 된다.
아래 명령어로 native-image를 설치 해보자

```shell script
gu insall native-image
```
## native Compile
드디어 narive compile를 할 수 있다. (힘들어..)
아래 명령어로 빌드를 해보자

```shell script
./gradlew clean build -Dquarkus.package.type=native
```
빌드가 완료 되었다면 현재 디렉토리에  build 폴더에 보면 <프로젝트 이름>-runner 파일이 생성 된것을 볼 수 있다.
해당 파일을 실행된다

## 결론
Native 이미지로 만드는데 생각 보다 오래 걸렸지만 실행 속도는 아주 빨랐다.
Quarkus 프레임워크가 컨테이너에 마추어 만들어져서 메모리 사용량이 작다고 하는데 그 부분은 확인을 하지 못하였다.
현재까지 사용 하면서 느낀점은 기존 spring 처럼 모놀리식 으로 개발하기보다는 MSA  적합하다고 느꼈다.
