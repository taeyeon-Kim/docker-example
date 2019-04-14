# Docker

![docker](https://pages.oss.navercorp.com/taeyeonkim/docker-example/static/docker.png)
 - 도커는 컨테이너를 이미지 파일로 빌드하고 배포하여 어디서나 실행할 수 있도록 해주는 오픈소스입니다.
 - 컨테이너를 git에 저장된 소스처럼 build/push/pull 할 수 있는 방법을 먼저 제공하면서 주목 받았습니다.
 - rkt, lxc, lxd 등의 경쟁자가 있지만 아직 도커 만큼 주목받지 못하고 있습니다.
 
## 도커 동작방식 (개요)

![docker-flow](https://pages.oss.navercorp.com/taeyeonkim/docker-example/static/docker-flow.png)

- 도커는 클라이언트 (docker)와 서버 (dockerd)로 구성되어 있습니다. 이를 Docker Engine이라 합니다.
- 모든 명령은 클라이언트에서 REST API로 서버에 요청되어 서버에서 수행합니다.
- 간단한 동작 방식은 아래와 같습니다.
    1. 도커 이미지를 빌드하기 위해 Dockerfile 을 작성한다.
    2. `docker build`으로 Dockerfile 과 함께 도커 빌드 요청을 보낸다.
    3. 도커 서버에서는 도커 이미지를 빌드하여 로컬 저장소에 저장한다.
    4. `docker push`으로 도커 서버는 로컬의 도커 이미지를 도커 레지스트리에 올린다.
    5. `docker run`으로 배포할 도커 서버에 전송한다.
    6. 도커 run 명령을 받은 도커 서버는 도커 레지스트리에 이미지를 로컬 저장소로 다운 받는다.
    7. 도커 이미지를 이용하여 컨테이너를 시작한다.