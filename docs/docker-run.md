# 도커 실행
 - 이미지를 run하여 컨테이너를 생성해보고 컨테이너의 상태를 조절해보도록 합니다.
 
## docker run
~~~bash
# 컨테이너를 실행합니다.
docker run
~~~
~~~bash
# docker run 사용법 및 주요 옵션
docker run [OPTIONS] IMAGE [COMMAND] [ARG...]

Options:
  -d, --detach            컨테이너를 background로 실행한다.
  --name string           컨테이너의 이름을 지정한다.
  -p, --publish 외부:내부  컨테이너의 포트를 host의 포트와 연결한다.(NAT)
~~~

~~~bash
$ docker run -d --name app -p 4000:8080 duszzang/docker-app:1.0.0
~~~

## docker ps
~~~bash
# 컨테이너 리스트를 출력합니다.
docker ps
~~~

~~~bash
# docker ps 사용법
docker ps [OPTIONS]

Options:
 -a, --all 모든 컨테이너를 출력합니다. (default는 running상태인 컨테이너만 출력합니다.)
~~~

## docker inspect
~~~bash
# 컨테이너 상세 정보를 확인합니다.
docker inspect
~~~

~~~bash
# docker inspect 사용법
docker inspect [OPTIONS] NAME|ID [NAME|ID...]
~~~

~~~bash
$ docker inspect app
~~~

## docker exec
~~~bash
# 컨테이너 내부에서 bash 등의 명령을 실행한다.
docker exec
~~~

~~~bash
# docker exec 사용법 및 주요 옵션
docker exec [OPTIONS] CONTAINER COMMAND [ARG...]

Options:
  -d, --detach               새로운 터미널을 할당한다.
  -i, --interactive          STDIN을 유지한다.
  -t, --tty                  원격 세션과 상호 작용할 수있는 의사 터미널인 pseudo-TTY를 만든다.
  -u, --user                 특정 유저로 command를 실행한다
~~~

~~~bash
$ docker exec -it app bash
~~~

## docker logs
~~~bash
# docker log 콜렉터가 수집한 로그를 출력합니다.
docker logs
~~~

~~~bash
# docker logs 사용법 및 주요 옵션
docker logs [OPTIONS] CONTAINER

Options:
 -f, --follow               log 출력을 계속합니다.
 --since                    현재부터 특정 시간 이전의 로그부터 출력합니다. (e.g. 2013-01-02T13:23:37) | (e.g. 42m for 42 minutes)
~~~

~~~bash
$ docker logs -f --since 2m app
~~~

## docker stop & docker start & docker restart
~~~bash
# 컨테이너를 stop합니다.
docker stop
# stop 상태의 컨테이너를 start합니다.
docker start
# 컨테이너를 재시작합니다.
docker restart
~~~

~~~bash
# docker stop 사용법
docker stop [OPTIONS] CONTAINER [CONTAINER...]
# docker start 사용법
docker start [OPTIONS] CONTAINER [CONTAINER...]
# docker restart 사용법
docker restart [OPTIONS] CONTAINER [CONTAINER...]
~~~

~~~bash
$ docker stop app
$ docker start app
$ docker restart app
~~~

## docker rm
~~~bash
# 컨테이너를 삭제합니다.
docker rm
~~~

~~~bash
# docker rm 사용법 및 주요 옵션
docker rm [OPTIONS] CONTAINER [CONTAINER...]

Options:
 -f, --force  running중인 컨테이너를 강제로 삭제합니다.
~~~

~~~bash
$ docker rm -f app
~~~