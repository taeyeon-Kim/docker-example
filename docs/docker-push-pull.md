# 이미지 push & pull
이미지를 registry에 올려 이미지를 공유해보도록 합니다.
 
> registry: repositories의 모음

> repository: images의 모음

## docker push
~~~bash
# 이미지를 registry에 push합니다.
docker push
~~~

~~~bash
# docker push 사용법
docker push [OPTIONS] NAME[:TAG]
~~~

~~~bash
$ docker push duszzang/docker-app:1.0.0
~~~

## docker pull
~~~bash
# registry에 있는 이미지를 local에 pull합니다.
docker pull
~~~

~~~bash
# docker pull 사용법
docker pull [OPTIONS] NAME[:TAG|@DIGEST]
~~~

~~~bash
$ docker pull duszzang/docker-app:1.0.0
~~~