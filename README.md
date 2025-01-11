# 프로젝트 개요

[로고가 들어갈 예정]  
취업준비생들을 위한 이력서, 자소서 관리 서비스: **Piccup**

---

## 목차

1. [서비스 소개](#서비스-소개)
2. [팀원 소개](#팀원-소개)
3. [프로젝트 설계 및 구성](#프로젝트-설계-및-구성)  
   3-1. [ERD 및 구조](#데이터베이스-erd)  
   3-2. [사용 기술](#사용-기술)  
   3-3. [주요 기능](#주요-기능)  
   3-4. [이슈 관리](#이슈-관리)

---

# 서비스 소개

<table>
  <tr>
    <td>
      <img src="https://raw.githubusercontent.com/doh3e/piccup/refs/heads/master/back/piccup/src/main/resources/static/work_files/default.png" width="900px;" alt=""/>
      <!-- <img src="https://raw.githubusercontent.com/doh3e/piccup/refs/heads/master/back/piccup/src/main/resources/static/work_files/default.png" width="150px;" alt=""/> -->
    </td>
    <td>
      <p><b>Piccup</b>은 취업준비생들을 대상으로 취업에 도움이 될 수 있는 서비스를 제공합니다.
      이력서 작성 시 필요한 정보 정리하여 손쉽게 이력서 작성에 도움을 줍니다.
      자기소개서 문항들을 정리하고 추가하여 기업마다 필요한 항목들을 찾아보며 사용할 수 있도록 해줍니다.
      지원 접수 정보 조회하고 일정을 관리할 수 있는 캘린더를 제공합니다.
      전형 단계에 대해 한눈에 볼 수 있도록 하여 효율적으로 취업 준비를 해나가도록 합니다.
      취업 준비생들의 미래를 응원하는 마음으로 서비스를 만듭니다.  </p>
    </td>
  </tr>
</table>

---

# 🗓 프로젝트 기간

2024.12.16 ~ 2025.01.05

---

# 팀원 소개

<table align="center">
  <tr>
    <td align="center" width="20%;">
      <img src="https://avatars.githubusercontent.com/u/151860111?v=4" alt=""/>
      <br/><sub><b>정지은 (팀장)</b><br></sub>
      <a href="https://github.com/doh3e">
        <p>GITHUB</p>
      </a>
    </td>
    <td align="center" width="20%;">
      <img src="https://avatars.githubusercontent.com/u/66674138?v=4" alt=""/>
      <br/><sub><b>김수아</b><br></sub>
      <a href="https://github.com/KSAhh">
        <p>GITHUB</p> 
      </a>
    </td>
    <td align="center" width="20%;">
      <img src="https://avatars.githubusercontent.com/u/175371015?s=400&u=d73959db6eb79273347d82a801027c0b0654d160&v=4" alt=""/>
      <br/><sub><b>박수연</b><br></sub>
      <a href="https://github.com/SOOYON1122">
        <p>GITHUB</p>
      </a>
    </td>
    <td align="center" width="20%;">
      <img src="https://avatars.githubusercontent.com/u/121767620?v=4" alt=""/>
      <br/><sub><b>유보형</b><br></sub>
      <a href="https://github.com/bobobo7git">
        <p>GITHUB</p>
      </a>
    </td>
    <td align="center" width="20%;">
      <img src="https://avatars.githubusercontent.com/u/174584847?v=4" alt=""/>
      <br/><sub><b>허건</b><br></sub>
      <a href="https://github.com/Geon72">
        <p>GITHUB</p>
      </a>
    </td>
  </tr>
</table>

## 세부 역할

<table align="center">
  <tr>
    <td>정지은 (팀장)</td>
    <td></td>
  </tr>
  <tr>
    <td>김수아</td>
    <td></td>
  </tr>
  <tr>
    <td>박수연</td>
    <td></td>
  </tr>
  <tr>
    <td>유보형</td>
    <td></td>
  </tr>
  <tr>
    <td>허건</td>
    <td></td>
  </tr>
</table>

---

# 프로젝트 설계 및 구성

## 기획

<span style="font-size:18px;"><b>평균 취업 준비 기간 약 1년, 취업 준비에 체계적인 관리 서비스가 필요하다!</b></span>

**Piccup** 은 기업마다 다른 자기소개서 문항들, 이력서 요소들, 그리고 중구난방의 채용 일정들에 이리저리 치이는 취업 준비생들의 입장에서 시작했습니다.
자주 쓰이는 자기소개서 문항들을 보기 좋게 정리해놓고 싶다거나, 지원 직무 별 필요한 이력 사항들을 미리 작성해놓고 싶다는 마음은 취업 준비생들의 마음 한켠에 자리잡고 있을 것입니다.

Piccup은 이러한 취업 준비생의 한 자락의 불편과 물안을 해소해줄 수 있도록 취준 관리 프로젝트를 기획하여 탄생했습니니다.
뒤죽박죽인 채용 일정을 한눈에 정리하고 전형 단계를 확인해볼 수 있는 기능과 더불어, 자기소개서와 이력서를 정리하여 필요할 때마다다 꺼내볼 수 있는 기능을 제공하는
취업 준비생들에게 필요한 편리 서비스입니다.

---

## 데이터베이스 ERD

<img src="https://github.com/user-attachments/assets/0a7625d1-60f2-42dc-803d-92283dc8888d" width=";" alt=""/>

---

## 디렉터리 구조

### Back

```
📦piccup
 ┣ 📂.mvn
 ┃ ┗ 📂wrapper
 ┃ ┃ ┗ 📜maven-wrapper.properties
 ┣ 📂src
 ┃ ┣ 📂main
 ┃ ┃ ┣ 📂java/com/ssafy/piccup
 ┃ ┃ ┃ ┣ 📂config                   // CORS, DB, Security 설정 파일
 ┃ ┃ ┃ ┣ 📂controller               // 회원, 자소서, 이력서 기능 컨트롤러
 ┃ ┃ ┃ ┣ 📂filter                   // JWT 인증 필터
 ┃ ┃ ┃ ┣ 📂model
 ┃ ┃ ┃ ┃ ┣ 📂dao
 ┃ ┃ ┃ ┃ ┃ ┣ 📂coverletter          // 자소서 및 지원서 Dao
 ┃ ┃ ┃ ┃ ┃ ┣ 📂mydata               // 내 취준 데이터 Dao
 ┃ ┃ ┃ ┃ ┃ ┣ 📂resume               // 이력서 Dao
 ┃ ┃ ┃ ┃ ┃ ┗ 📂user                 // 회원 Dao
 ┃ ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┃ ┃ ┣ 📂coverletter          // 자소서 및 지원서 Dto
 ┃ ┃ ┃ ┃ ┃ ┣ 📂mydata               // 내 취준 데이터 Dto
 ┃ ┃ ┃ ┃ ┃ ┣ 📂resume               // 이력서 Dto
 ┃ ┃ ┃ ┃ ┃ ┗ 📂user                 // 회원 Dto
 ┃ ┃ ┃ ┃ ┗ 📂service
 ┃ ┃ ┃ ┃ ┃ ┣ 📂coverletter          // 자소서 및 지원서 service
 ┃ ┃ ┃ ┃ ┃ ┣ 📂mydata               // 내 취준 데이터 service
 ┃ ┃ ┃ ┃ ┃ ┣ 📂resume               // 이력서 service
 ┃ ┃ ┃ ┃ ┃ ┗ 📂user                 // 회원 service
 ┃ ┃ ┃ ┣ 📂util                     // 인증 기능
 ┃ ┃ ┗ 📂resources
 ┃ ┃ ┃ ┣ 📂mappers
 ┃ ┃ ┃ ┃ ┣ 📂coverletter            // 자소서 및 지원서 mapper
 ┃ ┃ ┃ ┃ ┣ 📂mydata                 // 내 취준 데이터 mapper
 ┃ ┃ ┃ ┃ ┣ 📂resume                 // 이력서 mapper
 ┃ ┃ ┃ ┃ ┗ 📂user                   // 회원 mapper
 ┃ ┃ ┃ ┣ 📂static                   // 파일 저장 경로
 ┃ ┃ ┃ ┃ ┣ 📂education_files
 ┃ ┃ ┃ ┃ ┣ 📂portfolio_files
 ┃ ┃ ┃ ┃ ┣ 📂profile_images
 ┃ ┃ ┃ ┃ ┣ 📂sql                    // sql table schema
 ┃ ┃ ┃ ┃ ┗ 📂work_files             // 마스코트 이미지
 ┃ ┃ ┃ ┗ 📜application.properties   // 서버, my batis, jwt 인증 설정
 ┗ 📜pom.xml                        // 의존성 관리
```

### Front

```
📦front
 ┣ 📂public/icons           // 아이콘
 ┣ 📂src
 ┃ ┣ 📂api
 ┃ ┃ ┗ 📜index.js
 ┃ ┣ 📂assets
 ┃ ┃ ┣ 📂css
 ┃ ┃ ┃ ┣ 📜base.css
 ┃ ┃ ┃ ┣ 📜font.css
 ┃ ┃ ┃ ┣ 📜normalize.css
 ┃ ┃ ┃ ┗ 📜tailwind.css
 ┃ ┃ ┗ 📂fonts
 ┃ ┃ ┃ ┣ 📜NotoSansKR-Black.woff
 ┃ ┃ ┃ ┣ 📜NotoSansKR-Bold.woff
 ┃ ┃ ┃ ┣ 📜NotoSansKR-ExtraBold.woff
 ┃ ┃ ┃ ┣ 📜NotoSansKR-ExtraLight.woff
 ┃ ┃ ┃ ┣ 📜NotoSansKR-Light.woff
 ┃ ┃ ┃ ┣ 📜NotoSansKR-Medium.woff
 ┃ ┃ ┃ ┣ 📜NotoSansKR-Regular.woff
 ┃ ┃ ┃ ┣ 📜NotoSansKR-SemiBold.woff
 ┃ ┃ ┃ ┣ 📜NotoSansKR-Thin.woff
 ┃ ┃ ┃ ┗ 📜NotoSansKR-VariableFont_wght.ttf
 ┃ ┣ 📂components
 ┃ ┃ ┣ 📂CoverLetter
 ┃ ┃ ┃ ┣ 📜CoverLetterSection.vue
 ┃ ┃ ┃ ┗ 📜ResumeTabView.vue
 ┃ ┃ ┣ 📂Main
 ┃ ┃ ┃ ┣ 📜Companies.vue
 ┃ ┃ ┃ ┣ 📜Features.vue
 ┃ ┃ ┃ ┣ 📜Footer.vue
 ┃ ┃ ┃ ┣ 📜Header.vue
 ┃ ┃ ┃ ┣ 📜Hero.vue
 ┃ ┃ ┃ ┣ 📜JobListings.vue
 ┃ ┃ ┃ ┣ 📜JobSearch.vue
 ┃ ┃ ┃ ┣ 📜PopularJobs.vue
 ┃ ┃ ┃ ┣ 📜QuickAccess.vue
 ┃ ┃ ┃ ┗ 📜Testimonials.vue
 ┃ ┃ ┣ 📂mydata
 ┃ ┃ ┃ ┣ 📜Calendar.vue
 ┃ ┃ ┃ ┗ 📜Dashboard.vue
 ┃ ┃ ┗ 📂Resume
 ┃ ┃ ┃ ┣ 📜AcademicAbility.vue
 ┃ ┃ ┃ ┣ 📜Awards.vue
 ┃ ┃ ┃ ┣ 📜Certifications.vue
 ┃ ┃ ┃ ┣ 📜Educations.vue
 ┃ ┃ ┃ ┣ 📜Experience.vue
 ┃ ┃ ┃ ┣ 📜InternExtraActivities.vue
 ┃ ┃ ┃ ┣ 📜PersonalInfo.vue
 ┃ ┃ ┃ ┣ 📜Portfolio.vue
 ┃ ┃ ┃ ┣ 📜ResumeBuilder.vue
 ┃ ┃ ┃ ┣ 📜Sidebar.vue
 ┃ ┃ ┃ ┗ 📜Skills.vue
 ┃ ┣ 📂router
 ┃ ┃ ┗ 📜index.js
 ┃ ┣ 📂stores
 ┃ ┃ ┣ 📜auth.js
 ┃ ┃ ┣ 📜counter.js
 ┃ ┃ ┗ 📜resume.js
 ┃ ┣ 📂utils
 ┃ ┃ ┗ 📜axios.js
 ┃ ┣ 📂views
 ┃ ┃ ┣ 📜AuthView.vue
 ┃ ┃ ┣ 📜CoverLetterBoardView.vue
 ┃ ┃ ┣ 📜CoverLetterView.vue
 ┃ ┃ ┣ 📜FAQView.vue
 ┃ ┃ ┣ 📜LoadingView.vue
 ┃ ┃ ┣ 📜MainView.vue
 ┃ ┃ ┣ 📜MydataView.vue
 ┃ ┃ ┗ 📜ResumeView.vue
 ┃ ┣ 📜App.vue
 ┃ ┗ 📜main.js
 ┣ 📜.gitignore
 ┣ 📜index.html
 ┣ 📜jsconfig.json
 ┣ 📜package-lock.json
 ┣ 📜package.json
 ┣ 📜postcss.config.js
 ┣ 📜README.md
 ┣ 📜tailwind.config.js
 ┗ 📜vite.config.js
```

---

## 사용 기술

### BackEnd

<div>
  <img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white">
  <img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">
</div>

- JAVA (JDK 17)
- Spring Boot 3.3.x (maven)
  <!-- [![My Skills](https://skillicons.dev/icons?i=java,spring&theme=light)](https://skillicons.dev) -->

### FrontEnd

<div>
  <img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black">
  <img src="https://img.shields.io/badge/vue.js-4FC08D?style=for-the-badge&logo=vuedotjs&logoColor=white">
  <img src="https://img.shields.io/badge/css3-1572B6?style=for-the-badge&logo=css3&logoColor=white">
  <img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white">
  <img src="https://img.shields.io/badge/tailwindcss-06B6D4?style=for-the-badge&logo=tailwindcss&logoColor=white">
  <img src="https://img.shields.io/badge/axios-5A29E4?style=for-the-badge&logo=axios&logoColor=white">
  <img src="https://img.shields.io/badge/pinia-e6e600?style=for-the-badge&logo=pinia&logoColor=white">
</div>

- JavaScript
- Vue.js 2.1.10 (ES6)
- CSS3
- HTML5
- Tailwind CSS
- Axios 1.7.9
- Pinia 2.3.0
  <!-- [![My Skills](https://skillicons.dev/icons?i=js,vue,css,html,tailwind,pinia&theme=light)](https://skillicons.dev) -->

### DB & WAS

<div>
  <img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white">
</div>

- MySQL 8.0.40
  <!-- [![My Skills](https://skillicons.dev/icons?i=mysql&theme=light)](https://skillicons.dev) -->

### API & OpenData

- 사람인 API

### Environment & Tool

<div>
  <img src="https://img.shields.io/badge/Windows%2010-%230079d5.svg?style=for-the-badge&logo=Windows%2011&logoColor=white">
  <img src="https://img.shields.io/badge/Windows%2011-%230079d6.svg?style=for-the-badge&logo=Windows%2011&logoColor=white">
  <img src="https://img.shields.io/badge/mac%20os-000000?style=for-the-badge&logo=macos&logoColor=F0F0F0"><br/>
  <img src="https://img.shields.io/badge/vscode-0065A9?style=for-the-badge&logo=vscode&logoColor=white">
  <img src="https://img.shields.io/badge/postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white">
  <img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white">
  <img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">
  <img src="https://img.shields.io/badge/googlesheets-34A853?style=for-the-badge&logo=googlesheets&logoColor=white">
  <img src="https://img.shields.io/badge/discord-5865F2?style=for-the-badge&logo=discord&logoColor=white">
</div>

- Window 10, 11/ Mac M2
- STS4 4.24.0 / 4.26.0
- VisualStudioCode
- Postman
- Git, GitHub
- Google Sheet, Discord
  <!-- [![My Skills](https://skillicons.dev/icons?i=vscode&theme=light)](https://skillicons.dev)
  [![My Skills](https://skillicons.dev/icons?i=postman,git,github,discord)](https://skillicons.dev)   -->

---

## 프로젝트 시작 명령어

```bash
$ git clone https://github.com/doh3e/piccup.git

// Front
$ cd front
$ npm install
$ npm run dev

// Back
//// DB password 지정
//// username : ssafy
//// password : ssafy

$ Run As - Spring Boot App
```

---

## 주요 기능

<details>
  <summary><b>⛓ 상세 API 명세서 확인</b></summary>
  <details>
  <summary>1. 회원가입</summary>
    <div>
      <b>Request</b>
      <table align="center">
        <tr align="center">
          <td>메서드</td>
          <td>요청 url</td>
        </tr>
        <tr align="center">
          <td>POST</td>
          <td>http://localhost:8080/api/v1/user/signup</td>
        </tr>
      </table>
      <b>Request Body</b><br/>
      <pre>
        {
          "email": "test1@example.com",
          "password": "password1234",
          "nickname": "별명1",
          "profileImg": "",
          "mobilePhone": "010-1234-5678" 
        }
      </pre>
      <b>Response</b>
      <pre>
        회원가입 성공
      </pre>
    </div>
  </details>
  
<details>
    <summary>2. 로그인, 로그아웃</summary>
    <div>
      <b>Login Request</b>
      <table align="center">
        <tr align="center">
          <td>메서드</td>
          <td>요청 url</td>
        </tr>
        <tr align="center">
          <td>POST</td>
          <td>http://localhost:8080/api/v1/user/login</td>
        </tr>
      </table>
      <b>Login Request Body</b><br/>
      <pre>
        {
          "email": "test1@example.com",
          "password": "password1234"
        }
      </pre>
      <b>Login Response</b>
      <pre>
        {
          "refresh-token": "[refresh token]",
          "access-token": "[access token]"
        }
      </pre>
      <b>Login Response Elements</b>
      <table align="center">
        <tr align="center">
          <td>필드</td>
          <td>타입</td>
          <td>설명</td>
        </tr>
        <tr align="center">
          <td>refresh-token</td>
          <td>String</td>
          <td>refresh 토큰<br/>이후 header에 작성 필요</td>
        </tr>
        <tr align="center">
          <td>access-token</td>
          <td>String</td>
          <td>access 토큰</td>
        </tr>
      </table>
      <hr/>
      <b>Logout Request</b>
      <table align="center">
        <tr align="center">
          <td>메서드</td>
          <td>요청 url</td>
        </tr>
        <tr align="center">
          <td>POST</td>
          <td>http://localhost:8080/api/v1/user/logout</td>
        </tr>
      </table>
      <b>Logout Request Header</b><br/>
      <table align="center">
        <tr align="center">
          <td>파라미터</td>
          <td>타입</td>
          <td>필수 여부</td>
          <td>내용</td>
          <td>설명</td>
        </tr>
        <tr align="center">
          <td>Authorization</td>
          <td>String</td>
          <td>필수</td>
          <td>Bearer [refresh-tokenn]</td>
          <td>유저 인증 키</td>
        </tr>
      </table>
      <b>Logout Response</b>
      <pre>
        로그아웃 되었습니다.
      </pre>
    </div>
  </details>

<details>
  <summary>3. 이력서</summary>
  <div>
  <details>
    <summary><b>3-1. 조회</b></summary>
    <b>Request</b>
    <table align="center">
      <tr align="center">
        <td>메서드</td>
        <td>요청 url</td>
      </tr>
      <tr align="center">
        <td>GET</td>
        <td>http://localhost:8080/api/v1/resume</td>
      </tr>
    </table>
    <b>Request Header</b><br/>
    <table align="center">
      <tr align="center">
        <td>파라미터</td>
        <td>타입</td>
        <td>필수 여부</td>
        <td>내용</td>
        <td>설명</td>
      </tr>
      <tr align="center">
        <td>Authorization</td>
        <td>String</td>
        <td>필수</td>
        <td>Bearer [refresh-tokenn]</td>
        <td>유저 인증 키</td>
      </tr>
    </table>
    <details>
    <summary><b>Response 예시</b></summary>
    <pre>
      {
        "resume": {
            "resumeId": 22,
            "userId": 1,
            "updatedAt": "2024-12-28 22:51:33"
        },
        "personalInfo": {
            "infoId": 19,
            "resumeId": 22,
            "username": "Chris Park",
            "birthDate": "1988-04-10",
            "gender": "남",
            "email": "chris.park@example.com",
            "homePhone": "02-2222-4444",
            "mobilePhone": "010-2222-4444",
            "address": "서울시 종로구",
            "addressDetail": "505동 606호",
            "postalCode": 45678,
            "profileImgPath": "c9e0156b-043c-4d3d-bce5-366ace4bf138.jpg",
            "profileImgName": "민지.jpg",
            "degree": "학사",
            "hobby": "등산",
            "specialty": "프로젝트 관리",
            "file": null
        },
        "projects": [
          {
            "projectId": 22,
            "resumeId": 22,
            "projectName": "E-learning Platform",
            "role": "Backend Developer",
            "startDate": "2022-01-01",
            "endDate": "2022-06-30",
            "description": "Developed a backend system for an e-learning platform using Node.js and MongoDB."
          }
        ],
        "languages": [
          {
            "languageId": 30,
            "resumeId": 22,
            "languageName": "Russian",
            "testName": "TORFL",
            "score": "B2",
            "certCode": "RUS89012",
            "obtainedAt": "2020-05-30"
          }
        ],
        "preference": {
            "preId": 22,
            "resumeId": 22,
            "disLevel": "1급",
            "military": "군필",
            "protected": true,
            "disabled": true,
            "veteran": true,
            "agree": true,
            "isVeteran": true,
            "isProtected": true,
            "isDisabled": true,
            "isAgree": true
        },
        "portfolios": [
          {
            "portId": 22,
            "resumeId": 22,
            "portUrl": "https://github.com/user5/portfolio11001"
          }
        ],
        "trainings": [
          {
            "trainingId": 22,
            "resumeId": 22,
            "trainingName": "Leadership Training Program",
            "institution": "Global Management Institute",
            "startDate": "2022-07-01",
            "endDate": "2022-07-15",
            "description": "Focused on developing leadership and project management skills."
          }
        ],
        "workExperiences": [
          {
            "expId": 22,
            "resumeId": 22,
            "company": "LogiTech",
            "department": "Logistics",
            "startDate": "2016-07-07",
            "endDate": "2019-06-30",
            "position": "Logistics Coordinator",
            "salary": 55000,
            "description": "Coordinated supply chain activities.",
            "current": false,
            "isCurrent": false
          }
        ],
        "educations": [
          {
            "eduId": 21,
            "resumeId": 22,
            "schoolType": "대학교(4년)",
            "schoolName": "한국외국어대학교",
            "major": "국제관계학",
            "startDate": "2014-03-01",
            "endDate": "2018-02-28",
            "status": "졸업",
            "gpa": 3.6,
            "majorGpa": 3.7,
            "gpaScale": 4.5,
            "qeYear": "2018",
            "transfer": false,
            "qe": true,
            "isTransfer": false,
            "isQe": true
          }
        ],
        "certifications": [
          {
            "certId": 22,
            "resumeId": 22,
            "certName": "JLPT N1",
            "publisher": "일본국제교육지원협회",
            "obtainedDate": "2020-08-10",
            "certCode": "JLPT-N1-2020"
          }
        ],
        "papers": [
          {
            "paperId": 22,
            "resumeId": 22,
            "paperTitle": "AI Ethics and Society",
            "journal": "Journal of Ethics in AI",
            "publishedDate": "2022-10-20",
            "description": "Explores ethical challenges in AI applications."
          }
        ],
        "overseas": [
          {
            "overseaId": 22,
            "resumeId": 22,
            "country": "South Korea",
            "startDate": "2019-03-01",
            "endDate": "2019-08-31",
            "description": "Attended a university exchange program in South Korea."
          }
        ],
        "skills": [
          {
            "skillId": 22,
            "resumeId": 22,
            "skillName": "JavaScript",
            "skillLevel": "전문가"
          }
        ],
        "activities": [
          {
            "actId": 22,
            "resumeId": 22,
            "actType": "교내활동",
            "title": "교내 신문 기자",
            "startDate": "2018-09-01",
            "endDate": "2019-02-01",
            "description": "교내 신문 기자로 활동하며 기사 작성 및 인터뷰 경험."
          }
        ],
        "awards": [
          {
            "awardId": 22,
            "resumeId": 22,
            "awardName": "Creative Solution Award",
            "awardOrganization": "Hackathon",
            "awardDate": "2021-10-05",
            "description": "Won first place for innovative solutions in a global hackathon."
          }
        ],
        "patents": [
          {
            "patentId": 21,
            "resumeId": 22,
            "patentTitle": "Augmented Reality Glasses",
            "inventor": "Henry Black",
            "patentCode": "US7654321I",
            "description": "A new design for AR glasses with enhanced features."
          }
        ],
        "files": {
            "workFile": {
                "fileId": 0,
                "resumeId": 0,
                "updatedAt": null,
                "eduFileName": null,
                "eduFilePath": null,
                "portFileName": null,
                "portFilePath": null,
                "workFileName": "민지.jpg",
                "workFilePath": "caf07c6d-00d4-444c-98f4-23a8b5346d76.jpg"
            },
            "portFiles": [
                {
                    "fileId": 0,
                    "resumeId": 0,
                    "updatedAt": null,
                    "eduFileName": null,
                    "eduFilePath": null,
                    "portFileName": "민지.jpg",
                    "portFilePath": "715e14a9-a766-4918-b764-fe6864879e21.jpg",
                    "workFileName": null,
                    "workFilePath": null
                }
            ],
            "eduFile": {
                "fileId": 0,
                "resumeId": 0,
                "updatedAt": null,
                "eduFileName": "민지.jpg",
                "eduFilePath": "90879cff-08af-41e6-b508-5c1fb38a48a6.jpg",
                "portFileName": null,
                "portFilePath": null,
                "workFileName": null,
                "workFilePath": null
            }
        }
      }
    </pre>
    </details>
    <details>
    <summary><b>Response Elements</b></summary>
    <div>
    <table align="center">
      <tr align="center">
        <td>1.</td>
        <td>필드</td>
        <td>타입</td>
        <td>설명</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>resume</td>
        <td>-</td>
        <td>이력서 정보</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>userId</td>
        <td>Integer</td>
        <td>이력서 작성한 회원 pk</td>
      </tr>
      <tr align="center">
      <td></td>
        <td>updatedAt</td>
        <td>TimeStamp</td>
        <td>이력서 작성 및 수정 날짜</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>personalInfo</td>
        <td>-</td>
        <td>개인 기본 정보</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>infoId</td>
        <td>Integer</td>
        <td>개인 기본 정보 pk</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>username</td>
        <td>String</td>
        <td>이름</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>birthDate</td>
        <td>Date</td>
        <td>생년월일</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>gender</td>
        <td>String</td>
        <td>성별</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>email</td>
        <td>String</td>
        <td>이메일</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>homePhone</td>
        <td>String</td>
        <td>전화번호</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>mobilePhone</td>
        <td>String</td>
        <td>휴대폰 번호</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>address</td>
        <td>String</td>
        <td>주소</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>addressDetail</td>
        <td>String</td>
        <td>상세 주소</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>postalCode</td>
        <td>Integer</td>
        <td>우편 번호</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>profileImgPath</td>
        <td>String</td>
        <td>취업사진 파일경로</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>profileImgName</td>
        <td>String</td>
        <td>취업사진 파일명</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>degree</td>
        <td>String</td>
        <td>학위</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>hobby</td>
        <td>String</td>
        <td>취미</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>specialty</td>
        <td>String</td>
        <td>특기</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>file</td>
        <td>String</td>
        <td>성적증명서, 포트폴리오 파일경로 및 파일명</td>
      </tr>
      </table>
      </div>
      <div>
      <table align="center">
      <tr align="center">
        <td>2.</td>
        <td>필드</td>
        <td>타입</td>
        <td>설명</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>projects</td>
        <td>-</td>
        <td>작성한 프로젝트 내용</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>projectId</td>
        <td>Integer</td>
        <td>프로젝트 pk</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>projectName</td>
        <td>String</td>
        <td>프로젝트 이름</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>role</td>
        <td>String</td>
        <td>프로젝트에서 맡은 역할</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>startDate</td>
        <td>Date</td>
        <td>프로젝트 시작일</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>endDate</td>
        <td>Date</td>
        <td>프로젝트 종료일</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>description</td>
        <td>String</td>
        <td>프로젝트 활동 내용</td>
      </tr>
      </table>
      </div>
      <div>
      <table align="center">
      <tr align="center">
        <td>3.</td>
        <td>필드</td>
        <td>타입</td>
        <td>설명</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>languages</td>
        <td>-</td>
        <td>어학</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>languageId</td>
        <td>Integers</td>
        <td>어학 pk</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>languageName</td>
        <td>String</td>
        <td>외국어 명</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>testName</td>
        <td>String</td>
        <td>시험명</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>score</td>
        <td>String</td>
        <td>점수</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>obtainedAt</td>
        <td>Date</td>
        <td>취득일자</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>certCode</td>
        <td>String</td>
        <td>자격번호</td>
      </tr>
      </table>
      </div>
      <div>
      <table align="center">
      <tr align="center">
        <td>4.</td>
        <td>필드</td>
        <td>타입</td>
        <td>설명</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>preference</td>
        <td>-</td>
        <td>취업 우대 사항</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>preId</td>
        <td>Integer</td>
        <td>취업 우대 사항 pk</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>disLevel</td>
        <td>String</td>
        <td>장애 등급</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>military</td>
        <td>String</td>
        <td>병역 정보</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>isVeteran</td>
        <td>Boolean</td>
        <td>보훈대상 여부</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>isProtected</td>
        <td>Boolean</td>
        <td>취업보호대상 여부</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>isDisabled</td>
        <td>Boolean</td>
        <td>장애 여부</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>isAgree</td>
        <td>Boolean</td>
        <td>민감정보 동의 여부</td>
      </tr>
      </table>
      </div>
      <div>
      <table align="center">
      <tr align="center">
        <td>5.</td>
        <td>필드</td>
        <td>타입</td>
        <td>설명</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>portfolios</td>
        <td>-</td>
        <td>포트폴리오</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>portId</td>
        <td>Integers</td>
        <td>포트폴리오 pk</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>portUrl</td>
        <td>String</td>
        <td>포트폴리오 url</td>
      </tr>
      </table>
      </div>
      <div>
      <table align="center">
      <tr align="center">
        <td>6.</td>
        <td>필드</td>
        <td>타입</td>
        <td>설명</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>trainings</td>
        <td>-</td>
        <td>교육</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>trainingId</td>
        <td>Integer</td>
        <td>교육 pk</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>trainingName</td>
        <td>String</td>
        <td>교육 명</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>institution</td>
        <td>String</td>
        <td>교육 기관</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>startDate</td>
        <td>Date</td>
        <td>시작 일자</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>endDate</td>
        <td>Date</td>
        <td>종료 일자</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>description</td>
        <td>String</td>
        <td>교육 내용</td>
      </tr>
      </table>
      </div>
      <div>
      <table align="center">
      <tr align="center">
        <td>7.</td>
        <td>필드</td>
        <td>타입</td>
        <td>설명</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>workExperiences</td>
        <td>-</td>
        <td>경력</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>expId</td>
        <td>Integer</td>
        <td>경력 pk</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>company</td>
        <td>String</td>
        <td>회사명</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>department</td>
        <td>String</td>
        <td>부서명</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>startDate</td>
        <td>Date</td>
        <td>입사 년월일</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>endDate</td>
        <td>Date</td>
        <td>퇴사 년월일</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>position</td>
        <td>String</td>
        <td>직급/직책</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>salary</td>
        <td>Integer</td>
        <td>연봉</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>description</td>
        <td>String</td>
        <td>업무 내용</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>isCurrent</td>
        <td>Boolean</td>
        <td>재직 여부</td>
      </tr>
      </table>
      </div>
      <div>
      <table align="center">
      <tr align="center">
        <td>8.</td>
        <td>필드</td>
        <td>타입</td>
        <td>설명</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>educatioins</td>
        <td>-</td>
        <td>교육</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>eduId</td>
        <td>Integer</td>
        <td>교육 pk</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>schoolType</td>
        <td>String</td>
        <td>학교 구분</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>schoolName</td>
        <td>String</td>
        <td>학교명</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>major</td>
        <td>String</td>
        <td>전공명</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>startDate</td>
        <td>Date</td>
        <td>입학 년월일</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>endDate</td>
        <td>Date</td>
        <td>졸업 년월일</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>status</td>
        <td>String</td>
        <td>졸업 상태</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>gpa</td>
        <td>Decimal</td>
        <td>총 학점</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>majorGpa</td>
        <td>Decimal</td>
        <td>전공 학점</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>gpaScale</td>
        <td>Decimal</td>
        <td>총점 기준</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>isQe</td>
        <td>Boolean</td>
        <td>검정고시 여부</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>qeYear</td>
        <td>Year</td>
        <td>검정고시 합격 년도</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>isTransfer</td>
        <td>Boolean</td>
        <td>편입 여부</td>
      </tr>
      </table>
      </div>
      <div>
      <table align="center">
      <tr align="center">
        <td>9.</td>
        <td>필드</td>
        <td>타입</td>
        <td>설명</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>certificatioins</td>
        <td>-</td>
        <td>자격증</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>certId</td>
        <td>Integer</td>
        <td>자격증 pk</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>certName</td>
        <td>String</td>
        <td>자격증명</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>publisher</td>
        <td>String</td>
        <td>발행처</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>obtainedDate</td>
        <td>Date</td>
        <td>취득일</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>certCode</td>
        <td>String</td>
        <td>자격번호</td>
      </tr>
      </table>
      </div>
      <div>
      <table align="center">
      <tr align="center">
        <td>10.</td>
        <td>필드</td>
        <td>타입</td>
        <td>설명</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>papers</td>
        <td>-</td>
        <td>논문</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>paperId</td>
        <td>Integers</td>
        <td>논문 pk</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>paperTitle</td>
        <td>String</td>
        <td>논문명</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>journal</td>
        <td>String</td>
        <td>저널명</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>publishedDate</td>
        <td>Date</td>
        <td>출판 년월일</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>description</td>
        <td>String</td>
        <td>논문 설명</td>
      </tr>
      </table>
      </div>
      <div>
      <table align="center">
      <tr align="center">
        <td>11.</td>
        <td>필드</td>
        <td>타입</td>
        <td>설명</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>overseas</td>
        <td>-</td>
        <td>해외 경험</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>overseaId</td>
        <td>Integers</td>
        <td>해외 경험 pk</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>country</td>
        <td>String</td>
        <td>국가명</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>startDate</td>
        <td>Date</td>
        <td>시작 년월일</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>endDate</td>
        <td>Date</td>
        <td>종료 년월일</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>description</td>
        <td>String</td>
        <td>활동 내용</td>
      </tr>
      </table>
      </div>
      <div>
      <table align="center">
      <tr align="center">
        <td>12.</td>
        <td>필드</td>
        <td>타입</td>
        <td>설명</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>skills</td>
        <td>-</td>
        <td>스킬</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>skillId</td>
        <td>Integers</td>
        <td>스킬 pk</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>skillName</td>
        <td>String</td>
        <td>스킬명</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>skillLevel</td>
        <td>String</td>
        <td>숙련도</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>activities</td>
        <td>-</td>
        <td>대내외 활동</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>actId</td>
        <td>Integer</td>
        <td>대내외 활동 pk</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>actType</td>
        <td>String</td>
        <td>활동 유형</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>title</td>
        <td>String</td>
        <td>기관명/활동명</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>startDate</td>
        <td>Date</td>
        <td>시작 년월일</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>endDate</td>
        <td>Date</td>
        <td>종료 년월일</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>description</td>
        <td>String</td>
        <td>활동 내용</td>
      </tr>
      </table>
      </div>
      <div>
      <table align="center">
      <tr align="center">
        <td>13.</td>
        <td>필드</td>
        <td>타입</td>
        <td>설명</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>awards</td>
        <td>-</td>
        <td>수상 내역</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>awardId</td>
        <td>Integer</td>
        <td>수상 내역 pk</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>awardName</td>
        <td>String</td>
        <td>수상명</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>awardOrganization</td>
        <td>String</td>
        <td>수여기관</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>awardDate</td>
        <td>Date</td>
        <td>수상 년월일</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>description</td>
        <td>String</td>
        <td>수여 내용</td>
      </tr>
      </table>
      </div>
      <div>
      <table align="center">
      <tr align="center">
        <td>14.</td>
        <td>필드</td>
        <td>타입</td>
        <td>설명</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>patents</td>
        <td>-</td>
        <td>특허</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>patentId</td>
        <td>Integer</td>
        <td>특허 pk</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>patentTitle</td>
        <td>String</td>
        <td>특허명</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>inventor</td>
        <td>String</td>
        <td>발명자</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>patentCode</td>
        <td>String</td>
        <td>특허번호</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>description</td>
        <td>String</td>
        <td>설명</td>
      </tr>
      </table>
      </div>
      <div>
      <table align="center">
      <tr align="center">
        <td>15.</td>
        <td>필드</td>
        <td>타입</td>
        <td>설명</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>fileId</td>
        <td>Integer</td>
        <td>파일 pk</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>workFile</td>
        <td>-</td>
        <td>경력증명서 파일</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>workFileName</td>
        <td>String</td>
        <td>경력증명서 파일명</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>workFilePath</td>
        <td>String</td>
        <td>성적증명서 파일경로</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>portFiles</td>
        <td>-</td>
        <td>포트폴리오 파일</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>portFileName</td>
        <td>String</td>
        <td>포트폴리오 파일명</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>portFilePath</td>
        <td>String</td>
        <td>포트폴리오 파일경로</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>eduFile</td>
        <td>-</td>
        <td>성적증명서 파일</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>eduFileName</td>
        <td>String</td>
        <td>성적증명서 파일명</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>eduFilePath</td>
        <td>String</td>
        <td>성적증명서 파일경로</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>createdAt</td>
        <td>Date</td>
        <td>생성 일자</td>
      </tr>
      <tr align="center">
        <td></td>
        <td>updatedAt</td>
        <td>Date</td>
        <td>수정 일자</td>
      </tr>
    </table>
    </div>
    </details>
  </details>
    <hr/>
  <details>
    <summary><b>3-2. 이력서 생성</b></summary>
    <b>Request</b>
    <table align="center">
      <tr align="center">
        <td>메서드</td>
        <td>요청 url</td>
      </tr>
      <tr align="center">
        <td>POST</td>
        <td>http://localhost:8080/api/v1/resume</td>
      </tr>
    </table>
    <b>Request Header</b><br/>
    <table align="center">
      <tr align="center">
        <td>파라미터</td>
        <td>타입</td>
        <td>필수 여부</td>
        <td>내용</td>
        <td>설명</td>
      </tr>
      <tr align="center">
        <td>Authorization</td>
        <td>String</td>
        <td>필수</td>
        <td>Bearer [refresh-tokenn]</td>
        <td>유저 인증 키</td>
      </tr>
    </table>
    <details>
    <summary><b>Request Body</b><br/></summary>
    <pre>
      {
        "personalInfo": {
          "username": "Chris Park",
          "birthDate": "1988-04-10",
          "gender": "남",
          "email": "chris.park@example.com",
          "homePhone": "02-2222-4444",
          "mobilePhone": "010-2222-4444",
          "address": "서울시 종로구",
          "addressDetail": "505동 606호",
          "postalCode": 45678,
          "degree": "학사",
          "hobby": "등산",
          "specialty": "프로젝트 관리"
        },
        "projects": [
          {
            "projectName": "E-learning Platform",
            "role": "Backend Developer",
            "startDate": "2022-01-01",
            "endDate": "2022-06-30",
            "description": "Developed a backend system for an e-learning platform using Node.js and MongoDB."
          }
        ],
        "languages": [
          {
            "languageName": "Russian",
            "testName": "TORFL",
            "score": "B2",
            "certCode": "RUS89012",
            "obtainedAt": "2020-05-30"
          }
        ],
        "preference": {
          "disLevel": "1급",
          "military": "군필",
          "protected": true,
          "disabled": true,
          "veteran": true,
          "agree": true,
          "isVeteran": true,
          "isProtected": true,
          "isDisabled": true,
          "isAgree": true
        },
        "portfolios": [
          {
            "portUrl": "https://github.com/user5/portfolio11001"
          }
        ],
        "trainings": [
          {
            "trainingName": "Leadership Training Program",
            "institution": "Global Management Institute",
            "startDate": "2022-07-01",
            "endDate": "2022-07-15",
            "description": "Focused on developing leadership and project management skills."
          }
        ],
        "workExperiences": [
          {
            "company": "LogiTech",
            "department": "Logistics",
            "startDate": "2016-07-07",
            "endDate": "2019-06-30",
            "position": "Logistics Coordinator",
            "salary": 55000,
            "description": "Coordinated supply chain activities.",
            "current": false,
            "isCurrent": false
          }
        ],
        "educations": [
          {
            "schoolType": "대학교(4년)",
            "schoolName": "한국외국어대학교",
            "major": "국제관계학",
            "startDate": "2014-03-01",
            "endDate": "2018-02-28",
            "status": "졸업",
            "gpa": 3.6,
            "majorGpa": 3.7,
            "gpaScale": 4.5,
            "qeYear": "2018",
            "transfer": false,
            "qe": true,
            "isTransfer": false,
            "isQe": true
          }
        ],
        "certifications": [
          {
            "certName": "JLPT N1",
            "publisher": "일본국제교육지원협회",
            "obtainedDate": "2020-08-10",
            "certCode": "JLPT-N1-2020"
          }
        ],
        "papers": [
          {
            "paperTitle": "AI Ethics and Society",
            "journal": "Journal of Ethics in AI",
            "publishedDate": "2022-10-20",
            "description": "Explores ethical challenges in AI applications."
          }
        ],
        "overseas": [
          {
            "country": "South Korea",
            "startDate": "2019-03-01",
            "endDate": "2019-08-31",
            "description": "Attended a university exchange program in South Korea."
          }
        ],
        "skills": [
          {
            "skillName": "JavaScript",
            "skillLevel": "전문가"
          }
        ],
        "activities": [
          {
            "actType": "교내활동",
            "title": "교내 신문 기자",
            "startDate": "2018-09-01",
            "endDate": "2019-02-01",
            "description": "교내 신문 기자로 활동하며 기사 작성 및 인터뷰 경험."
          }
        ],
        "awards": [
          {
            "awardName": "Creative Solution Award",
            "awardOrganization": "Hackathon",
            "awardDate": "2021-10-05",
            "description": "Won first place for innovative solutions in a global hackathon."
          }
        ],
        "patents": [
          {
            "patentTitle": "Augmented Reality Glasses",
            "inventor": "Henry Black",
            "patentCode": "US7654321I",
            "description": "A new design for AR glasses with enhanced features."
          }
        ]
      }
    </pre>
  </details>
  <b>Response</b>
  <pre>
    {
    "message": "이력서 생성 성공하였습니다."
    }
  </pre>
</details>
<hr/>
<details>
  <summary><b>3-3. 이력서 파일 등록</b></summary>
    <b>Request</b>
    <table align="center">
      <tr align="center">
        <td>메서드</td>
        <td>요청 url</td>
      </tr>
      <tr align="center">
        <td>POST</td>
        <td>http://localhost:8080/api/v1/resume/files</td>
      </tr>
    </table>
    <b>Request Header</b><br/>
    <table align="center">
      <tr align="center">
        <td>파라미터</td>
        <td>타입</td>
        <td>필수 여부</td>
        <td>내용</td>
        <td>설명</td>
      </tr>
      <tr align="center">
        <td>Authorization</td>
        <td>String</td>
        <td>필수</td>
        <td>Bearer [refresh-tokenn]</td>
        <td>유저 인증 키</td>
      </tr>
    </table>
    <b>Request Body</b><br/>
    <table align="center">
      <tr align="center">
        <td>Key</td>
        <td>타입</td>
        <td>Value</td>
        <td>설명</td>
      </tr>
      <tr align="center">
        <td>personalFile</td>
        <td>File</td>
        <td>{{파일 업로드}}</td>
        <td>파일 업로드</td>
      </tr>
      <tr align="center">
        <td>portFile</td>
        <td>File</td>
        <td>{{포트폴리오 파일 업로드}}</td>
        <td>포트폴리오 파일 업로드</td>
      </tr>
      <tr align="center">
        <td>eduFile</td>
        <td>File</td>
        <td>{{성적증명서 파일 업로드}}</td>
        <td>성적증명서 파일 업로드</td>
      </tr>
      <tr align="center">
        <td>workFile</td>
        <td>File</td>
        <td>{{경력증명서 파일 업로드}}</td>
        <td>경력증명서 파일 업로드</td>
      </tr>
    </table>
    <b>Response</b>
  <pre>
    {
    "message": "이력서 내 파일 저장 성공하였습니다."
    }
  </pre>
  </details>
<hr/>
<details>
  <summary><b>3-4. 이력서 삭제</b></summary>
    <b>Request</b>
    <table align="center">
      <tr align="center">
        <td>메서드</td>
        <td>요청 url</td>
      </tr>
      <tr align="center">
        <td>DELETE</td>
        <td>http://localhost:8080/api/v1/resume</td>
      </tr>
    </table>
    <b>Request Header</b><br/>
    <table align="center">
      <tr align="center">
        <td>파라미터</td>
        <td>타입</td>
        <td>필수 여부</td>
        <td>내용</td>
        <td>설명</td>
      </tr>
      <tr align="center">
        <td>Authorization</td>
        <td>String</td>
        <td>필수</td>
        <td>Bearer [refresh-tokenn]</td>
        <td>유저 인증 키</td>
      </tr>
    </table>
    <b>Response</b>
  <pre>
    {
    "message": "이력서 삭제 성공하였습니다."
    }
  </pre>
  </details>
  </div>
</details>

<details>
  <summary>4. 자기소개서</summary>
  <div>
  </div>
</details>

<details>
    <summary>5. 내 취준데이터</summary>
    <div>
    </div>
  </details>
</details>

### 1. 회원 가입 및 로그인

- 이메일을 아이디로 회원가입합니다.
- 프로필 사진과 전화번호를 선택적으로 기입할 수 있습니다.
- 회원가입 시 등록한 이메일과 비밀번호로 로그인합니다.

### 2. 이력서 관리

<table>
  <tr>
    <td width="30%">
      <img src="https://raw.githubusercontent.com/doh3e/piccup/refs/heads/develop/front/src/assets/icons/resume.gif" alt=""/> 
    </td>
    <td>
      <ul>
      <li>이력서를 직접 작성할 수 있습니다.</li>
      <li>추가하고 싶은 문항을 직접 추가, 삭제 가능합니다.</li>
      <li>직접 작성한 이력서를 조회하고 수정, 삭제할 수 있습니다.</li>
      </ul>
    </td>
  </tr>
</table>

### 3. 자소서 관리

<table>
  <tr>
    <td width="30%">
      <img src="https://raw.githubusercontent.com/doh3e/piccup/refs/heads/develop/front/src/assets/icons/coverletter.gif" alt=""/> 
    </td>
    <td>
      <ul>
      <li>자기소개서를 직접 작성할 수 있습니다.</li>
      <li>자기소개서 문항을 직접 추가하고 삭제할 수 있습니다.</li>
      <li>직접 작성한 이력서를 조회하고 수정, 삭제할 수 있습니다.</li>
      </ul>
    </td>
  </tr>
  <tr>
    <td width="30%">
      <img src="https://raw.githubusercontent.com/doh3e/piccup/refs/heads/develop/front/src/assets/icons/board.gif" alt=""/> 
    </td>
    <td>
      <ul>
      <li>내가 작성한 자기소개서들을 전체 조회하고 확인할 수 있습니다.</li>
      <li>내가 지원한 서류들과 일정들을 입력하고 모아볼 수 있습니다.</li>
      <li>접수 일정들과 내가 지원한 기업에 대한 피드백들을 입력하고 모아볼 수 있습니다.</li>
      </ul>
    </td>
  </tr>
</table>

### 4. 마이 페이지

<table>
  <tr>
    <td width="30%;">
      <img src="https://raw.githubusercontent.com/doh3e/piccup/refs/heads/develop/front/src/assets/icons/calendar.gif" alt=""/>  
    </td>
    <td>
      <ul>
        <li>내 일정을 입력하고 수정, 삭제할 수 있습니다.</li>
        <li>내가 입력한 일정은 캘린더를 통해 한눈에 확인할 수 있습니다.</li>
        <li>취업 현황과 관련된 정보를 입력하고 수정, 삭제할 수 있습니다.</li>
        <li>단계별 합불 현황과 전형 진행 중의 피드백을 스스로 남길 수 있습니다.</li>
        <li>내가 지원한 회사에 대한 정보(직무별 / 기업별)를 제공합니다.</li>
      </ul>
    </td>
  </tr>
</table>

### 5. 헬프 데스크

- 서비스 공지사항과 문의 게시판을 제공합니다.
- 문의 사항을 조회하고 직접 작성하여 문의를 남길 수 있습니다.
- 남긴 문의 사항에 대한 답변을 받을 수 있습니다.

---

## 이슈 관리
