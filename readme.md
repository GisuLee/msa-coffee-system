# 마이크로서비스 아키텍처로 구현한 커피주문 시스템

## Introduction

> 커피주문 시스템을 모델링하고, 필요한 서비스들을 마이크로서비스 아키텍처 기반으로 시스템을 구축한다.
 마이크로서비스 사이의 통신을 하기위한 feign, hystrix와 같은 라이브러리를 이해한다.
 마이크로서비스들을 관리하고 라우팅하기 위한 Eureka, Zuul 서버를 구축한다.

## Skill

### Spring

- 

```
Kafka
SpringBoot
SpringCloud config, Eureka, zuul, ribbon, turbine, hystrix, feign
Mybatis
H2 DB
Lombok
github

```

## **커피 주문 시스템 구상도**

![https://raw.githubusercontent.com/GisuLee/msa-coffee-system/master/msa_component.jpg](https://raw.githubusercontent.com/GisuLee/msa-coffee-system/master/msa_component.jpg)

## **커피 주문 시스템 상세 구성도**

![https://raw.githubusercontent.com/GisuLee/msa-coffee-system/master/msa_arcitecture.jpg](https://raw.githubusercontent.com/GisuLee/msa-coffee-system/master/msa_arcitecture.jpg)

## **커피 주문 시스템 구성 요소**

```
깃 허브(git repository) : 마이크로서비스 소스 관리 및 프로파일 관리
설정 서버(Config Server) : 깃 허브에 저장된 프로파일과 연동
유레카 서버(Eureka Server) : 마이크로서비스 등록 및 탐지
줄 서버(zuul Server) : 마이크로서비스 부하 분산 및 서비스 라우팅
커피주문 마이크로서비스(Order Microservice) : 커피 주문 처리서비스
회원확인 마이크로서비스(member Microservice) :  회원 가입 여부 확인 서비스
주문처리 마이크로서비스(status Microservice) : 주문 처리 상태 확인 서비스
큐잉 시스템(Queueing System) : 마이크로서비스 간 메시지 발행 및 구독
터빈 서버(Turbine Server) : 마이크로서비스의 스트림 데이터 수집
히스트릭스 대시보드(Hystrix Dashboard) : 마이크로서비스 스트림 데이터 모니터링 및 시각화
```

# **마이크로서비스 아키텍처로 구현한 커피주문 시스템**
