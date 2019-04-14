# FROM은 빌드 stage를 초기화하고 이후 instruction에 대한 base 이미지를 설정합니다.
# 가능하면 공식적으로 제공되는 이미지를 사용하세요.
FROM centos:centos7

# 라벨을 생성한다. docker inspect로 확인 가능합니다.
# 라이센스와  관리자같은 정보를 이미지에 기록하는 용도입니다.
LABEL maintainer="taeyeonkim"

ENV JAVA_TOOL_OPTIONS -Dfile.encoding=UTF8
ENV LANG ko_KR.UTF-8
ARG jdk_version=java-1.8.0-openjdk-devel.x86_64

# RUN은 명령 문자열 자체 비교만으로 캐시 효과
# command를 실제로 실행하고 결과를 commit합니다.
RUN yum install -y epel-release
RUN yum install -y wget telnet nc tar vim unzip \
    yum install -y net-tools $jdk_version make
RUN mkdir -p /app
RUN mkdir -p /app/log

# ADD COPY만 파일 내용을 비교해서 캐시 효과
# ADD는 remote URL을 지원하고 local의 tar를 풀어서 추가한다.
ADD war/*.war /app/
COPY run.sh /app/run.sh
WORKDIR /app
EXPOSE 80
# VOLUME는 지정한 이름을 가진 마운트 point를 생성합니다.
# native host나 다른 container에서 외부로 마운트된 볼륨을 보관하는 것으로 표시합니다.
VOLUME ["/app/log"]
ARG APP_VERSION
ENV APP_VERSION ${APP_VERSION:-0.0.1}

# docker run, docker start하는데 있어 main command로 사용됩니다.
# ENTRYPOINT, CMD(여러번 써봐야 마지막 CMD만 실행) 모두 한번만 사용가능합니다.
ENTRYPOINT ["/app/run.sh"]
# docker run에서 명령어를 주지 않았을 때 사용할 default 명령을 설정
# CMD ["/app/run.sh"]