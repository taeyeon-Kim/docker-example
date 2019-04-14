# 이미지 빌드와 태깅
 - 작성한 Dockerfile을 이미지로 빌드하고 태깅해봅시다.

## docker build
~~~bash
# 도커 이미지를 빌드합니다.
docker build
# 로컬에 있는 빌드된 도커 이미지를 확인합니다.
docker image ls
~~~

~~~bash
# docker build 사용법 및 주요 옵션
docker build [OPTIONS] PATH | URL | -
-f, --file
   빌드할 Dockerfile을 지정합니다. 기본값은 Dockerfile입니다.
-t, --tag
   빌드한 이미지의 이름(name:tag)을 지정합니다. 미지정시 <none>으로 설정됩니다.
--build-arg
   빌드시에 사용할 변수를 정의합니다.
~~~

~~~bash
$ docker build -t duszzang/docker:1.0.0 --build-arg APP_VERSION=1.0 .
~~~

## docker tag
~~~bash
# 도커 이미지 태깅합니다.
# 만약 build의 t 옵션을 통해 태깅을 했다면 docker tag를 하지않아도 됩니다.
docker tag
~~~

~~~bash
# docker tag 사용법
docker tag SOURCE_IMAGE[:TAG] TARGET_IMAGE[:TAG]
~~~

~~~bash
$ docker tag duszzang/docker:1.0.0 duszzang/docker-app:1.0.0
~~~