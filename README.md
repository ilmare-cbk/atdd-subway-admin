<p align="center">
    <img width="200px;" src="https://raw.githubusercontent.com/woowacourse/atdd-subway-admin-frontend/master/images/main_logo.png"/>
</p>
<p align="center">
  <img alt="npm" src="https://img.shields.io/badge/npm-6.14.15-blue">
  <img alt="node" src="https://img.shields.io/badge/node-14.18.2-blue">
  <a href="https://edu.nextstep.camp/c/R89PYi5H" alt="nextstep atdd">
    <img alt="Website" src="https://img.shields.io/website?url=https%3A%2F%2Fedu.nextstep.camp%2Fc%2FR89PYi5H">
  </a>
  <img alt="GitHub" src="https://img.shields.io/github/license/next-step/atdd-subway-admin">
</p>

<br>

# 지하철 노선도 미션
[ATDD 강의](https://edu.nextstep.camp/c/R89PYi5H) 실습을 위한 지하철 노선도 애플리케이션

<br>

## 🚀 Getting Started

### Install
#### npm 설치
```
cd frontend
npm install
```
> `frontend` 디렉토리에서 수행해야 합니다.

### Usage
#### webpack server 구동
```
npm run dev
```
#### application 구동
```
./gradlew bootRun
```
<br>

## ✏️ Code Review Process
[텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

<br>

## 🐞 Bug Report

버그를 발견한다면, [Issues](https://github.com/next-step/atdd-subway-admin/issues) 에 등록해주세요 :)

<br>

## 📝 License

This project is [MIT](https://github.com/next-step/atdd-subway-admin/blob/master/LICENSE.md) licensed.

---

# ATDD

## 1단계 - 지하철역 인수 테스트 작성

### 기능 요구사항

- 지하철역 목록 조회 인수 테스트 작성하기
- 지하철역 삭제 인수 테스트 작성하기

### 프로그래밍 요구사항

- 인수 테스트의 재사용성과 가독성, 그리고 빠른 테스트 의도 파악을 위해 인수 테스트를 리팩터링 한다.

---

## 2단계 - 지하철 노선 기능

- 기능 구현 전에 인수 조건을 만족하는지 검증하는 인수 테스트를 먼저 만들고 기능구현을 한다.

### 기능 요구사항

1.지하철 노선 생성

- 인수 조건

    ```text
    When 지하철 노선을 생성하면
    Then 지하철 노선 목록 조회 시 생성한 노선을 찾을 수 있다
    ```

<br>
2. 지하철 노선 목록 조회

- 인수 조건

    ```text
    Given 2개의 지하철 노선을 생성하고
    When 지하철 노선 목록을 조회하면
    Then 지하철 노선 목록 조회 시 2개의 노선을 조회할 수 있다.
    ```

<br>
3. 지하철 노선 조회

- 인수 조건

    ```text
    Given 지하철 노선을 생성하고
    When 생성한 지하철 노선을 조회하면
    Then 생성한 지하철 노선의 정보를 응답받을 수 있다.
    ```

<br>
4. 지하철 노선 수정

- 인수 조건

    ```text
    Given 지하철 노선을 생성하고
    When 생성한 지하철 노선을 수정하면
    Then 해당 지하철 노선 정보는 수정된다
    ```

<br>
5. 지하철 노선 삭제

- 인수 조건

    ```text
    Given 지하철 노선을 생성하고
    When 생성한 지하철 노선을 삭제하면
    Then 해당 지하철 노선 정보는 삭제된다
    ```

### 프로그래밍 요구사항

- 다음 순서로 기능을 구현한다.
    - 인수 조건을 검증하는 인수 테스트 작성 -> 인수 테스트를 충족하는 기능 구현
- 인수 테스트의 결과가 다른 인수 테스트에 영향을 끼치지 않도록 인수 테스트를 서로 격리 시킨다.
    - @DirtiesContext, @Sql, Table Truncate
- 인수 테스트의 재사용성과 가독성, 그리고 빠른 테스트 의도 파악을 위해 인수 테스트를 리팩터링 한다.

---

## 3단계 - 구간 추가 기능

### 기능 요구사항

1. 역 사이에 새로운 역을 등록한다.

- 인수 조건

```text
Given 새로운 역 A를 생성한다.
When 지하철 노선(B역 - C역) 중간에(역 사이에) 새로운 역 A를 등록한다.
Then 지하철 노선 조회 시 등록된 새로운 역 A를 찾을 수 있다.(B역 - A역 - C역)
 ```

<br>

2. 새로운 역을 상행 종점으로 등록한다.

- 인수 조건

```text
Given 새로운 역 A를 생성한다.
When 새로운 역 A를 상행 종점으로 지하철 노선(B역 - C역)에 등록한다.
Then 지하철 노선 조회 시 새로운 역 A가 상행 종점인 것을 확인할 수 있다. (A역 - B역 - C역)
```

<br>

3. 새로운 역을 하행 종점으로 등록한다.

- 인수 조건

```text
Given 새로운 역 A를 생성한다.
When 새로운 역 A을 하행 종점으로 지하철 노선(B역 - C역)에 등록한다.
Then 지하철 노선 조회 시 새로운 역 A가 하행 종점인 것을 확인할 수 있다. (B역 - C역 - A역)
```

<br>

4. 역 사이에 새로운 역을 등록할 경우 기존 역 사이 길이보다 크거가 같으면 등록할 수 없다.

- 인수 조건

```text
Given 새로운 역 A를 생성한다.
When 지하철 노선(B역 - C역) 중간에(역 사이에) 기존 역 사이 길이보가 크거나 같도록 새로운 역 A를 등록한다.
Then 새로운 역 A 등록(구간 등록)에 실패한다.
```

<br>

5. 상행역과 하행역이 이미 노선에 모두 등록되어 있다면 추가할 수 없다.

- 인수 조건

```text
When 지하철 노선(B역 - C역)에 지하철 노선(B역 - C역)을 등록한다.
Then 지하철 구간 등록에 실패한다.
```

<br>

6. 상행역과 하행역 둘 중 하나도 포함되어있지 않으면 추가할 수 없다.

- 인수 조건

```text
Given 새로운 역 A,B를 생성한다.
When 새로운 구간 (A역 - B역) 을 기존 지하철 노선(C역 - D역)에 등록한다.
Then 지하철 구간 등록에 실패한다.
```

### 프로그래밍 요구사항

- 인수 조건을 검증하는 인수 테스트 작성 -> 인수 테스트를 충족하는 기능 구현 순으로 진행한다.
- 인수 조건은 인수 테스트 메서드 상단에 주석으로 작성한다.
- 인수 테스트의 결과가 다른 인수 테스트에 영향을 끼치지 않도록 인수 테스트를 서로 격리 시킨다.
- 인수 테스트의 재사용성과 가독성, 그리고 빠른 테스트 의도 파악을 위해 인수 테스트를 리팩터링 한다.

---

## 4단계 - 구간 제거 기능

### 기능 요구사항

1. 상행종점역이 제거될 경우 다음으로 오던 역이 상행종점역이 된다.

- 인수 조건

```text
Given 주어진 지하철 노선에 지하철역(구간)을 추가한다.
When 지하철 노선에서 상행종점역을 제거한다.
Then 제거된 상행종점역 다음 역이 새로운 상행종점역이 된다.
```

<br>

2. 하행종점역이 제거될 경우 이전에 오던 역이 하행종점역이 된다.

- 인수 조건

```text
Given 주어진 지하철 노선에 지하철역(구간)을 추가한다.
When 지하철 노선에서 하행종점역을 제거한다.
Then 제거된 하행종점역 전의 역이 새로운 하행종점역이 된다.
```

<br>

3. 중간역이 제거될 경우 재배치를 한다.

- 인수 조건

```text
Given 지하철 노선(A-B-C)를 생성한다.
When 지하철 노선(A-B-C)의 중간역(B)을 제거한다.
Then 지하철 노선은 A-C로 재배치되고, 거리는 A-B, B-C 구간 길이의 합이 된다.
```

<br>

4. 구간이 하나인 노선에서는 역을 제거할 수 없다.

- 인수 조건

```text
When 지하철 구간이 하나인 지하철 노선에서 지하철 역을 제거한다.
Then 지하철 역을 제거할 수 없다.
```

<br>

5. 예외적인 상황 추가로 테스트 하기

- 예) 노선에 등록되어있지 않은 역을 제거하려 한다.
