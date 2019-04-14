- docker run $image $other_command시 CMD는 override됨

- Linux Namespaces 는 프로세스에게 격리된 OS View 를 제공하는 커널 기술이다.
- cgroups (Control Group)은 어플리케이션(프로세스) 에게 하드웨어 리소스 (ex. CPU, MEM, Disk, Network, …) 를 그룹으로 묶어서 할당하는 (제한할 수 있는) 기술입니다.
- Union File System (UnionFS) 은 서로 다른 파일 시스템이나 디렉토리를 합쳐서 하나의 논리적인 파일 시스템으로 컨테이너에게 제공한다.