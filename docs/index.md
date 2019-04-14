# Container
> [A standardized unit of software](https://www.docker.com/resources/what-container)

![container](https://taeyeon-kim.github.io/docker-example//static/container.png)

 - 컨테이너는 어플리케이션의 런타임 인스턴스입니다.
 - 컨테이너 단위로 OS, 라이브러리, 어플리케이션을 패키징 할 수 있습니다.
 - 하나의 OS 위에 여러 어플리케이션을 독립적으로 실행할 수 있도록 해줍니다.
 - 컨테이너는 여러 어플리케이션의 격리된 환경을 지원하는 가상화 기술로 볼 수 있습니다.
 
 
## Virtual Machine과 Container 비교
 - Virtual Machine과 Container 모두 리소스를 격리시키고 할당할 수 있는 장점이 있습니다. 그러나 컨테인너는 하드웨어 대신에 OS를 가상화하여 동작합니다. 그러므로 더 간편하고 효율적입니다.
 
![container-vs-vm](https://taeyeon-kim.github.io/docker-example/static/container-vs-vm.png)

|  Virtual Machine        | Container          |
|:-------------|:------------------|
| 하나의 서버를 여러 서버로 전환시키는 물리적 하드웨어(OS, 커널 전부)의 추상화입니다. | 코드와 의존성을 함께 패키징하는 애플리케이션 계층(filesystem)의 추상화입니다. |
| 하이퍼바이저를 통해 단일 시스템에서 여러 VM을 실행할 수 있습니다. | 여러 컨테이너가 동일한 시스템에서 실행되고 OS 커널을 다른 컨테이너와 공유할 수 있으며 각 컨테이너는 사용자 공간(cgroup)에서 분리된 프로세스로 실행된다.|
| 각 VM에는 수십 GB를 차지하는 운영 체제, 애플리케이션, 필요한 이진 파일 및 라이브러리의 전체 복사본이 포함되어 있습니다.| 컨테이너가 VM보다 더 적은 용량을 차지합니다.|
| 부팅이 느립니다.    | 더 많은 애플리케이션을 처리할 수 있고 더 적은 수의 VM 및 운영 체제 필요합니다.  |

