## Pre-requisites
docker가 설치안되어 있다면 설치해줍니다.

 - Window: https://docs.docker.com/docker-for-windows/install/
 - mac: https://docs.docker.com/docker-for-mac/install/

app을 빌드합니다.
~~~sh
$ ./gradlew clean bootWar
~~~
빌드된 war를 docker/war에 복사합니다.
~~~sh
$ cp ./server/build/libs/*.war ./docker/war/
~~~
## [가이드](https://taeyeon-kim.github.io/docker-example/)
