# 프로젝트 개요
[로고가 들어갈 예정]  
취업준비생들을 위한 이력서, 자소서 관리 서비스: __Piccup__

---
## 목차
1. [서비스 소개](#서비스-소개)
2. [팀원 소개](#팀원-소개)
3. [프로젝트 설계 및 구성](#프로젝트-설계-및-구성)  
3-1. [ERD 및 구조](#데이터베이스-erd)  
3-2. [사용 기술](#사용-기술)  
3-3. [주요 기능](#주요-기능)
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
# 프로젝트 기간
2024.12.16 ~ 2025.01.05

---
# 팀원 소개
<table align="center">
  <tr>
    <td align="center">
      <a href="https://github.com/doh3e">
        <img src="https://avatars.githubusercontent.com/u/151860111?v=4" width="150px;" alt=""/>
        <br/><sub><b>정지은 (팀장)</b><br></sub>
      </a>
      <p></p>
      <ul align="left">
        <li>
          GitHub 관리
        </li>
        <li>
          취준데이터(마이페이지) 백엔드
        </li>
        <li>
          프론트엔드
        </li>
      </ul>
    </td>
    <td align="center">
      <a href="https://github.com/KSAhh">
        <img src="https://avatars.githubusercontent.com/u/66674138?v=4" width="150px;" alt=""/>
        <br/><sub><b>김수아</b><br></sub>
      </a>
      <p></p> 
      <ul align="left">
        <li>
          ERD 설계
        </li>
        <li>
          이력서 관리 백엔드
        </li>
        <li>
          GitHub naming 관리
        </li>
      </ul>
    </td>
    <td align="center">
      <a href="https://github.com/SOOYON1122">
        <img src="https://avatars.githubusercontent.com/u/175371015?s=400&u=d73959db6eb79273347d82a801027c0b0654d160&v=4" width="150px;" alt=""/>
        <br/><sub><b>박수연</b><br></sub>
      </a>
      <p></p>
      <ul align="left">
        <li>
          회원 백엔드
        </li>
        <li>
          api 명세서 작성 
        </li>
      </ul>
    </td>
    <td align="center">
      <a href="https://github.com/bobobo7git">
        <img src="https://avatars.githubusercontent.com/u/121767620?v=4" width="150px;" alt=""/>
        <br/><sub><b>유보형</b><br></sub>
      </a>
      <p></p>
      <ul align="left">
        <li>
          자소서 관리 백엔드
        </li>
        <li>
          //
        </li>
      </ul>
    </td>
    <td align="center">
      <a href="https://github.com/Geon72">
        <img src="https://avatars.githubusercontent.com/u/174584847?v=4" width="150px;" alt=""/>
        <br/><sub><b>허건</b><br></sub>
      </a>
      <p></p>
      <ul align="left">
        <li>
          프론트엔드
        </li>
        <li>
          UI 설계 
        </li>
      </ul>
    </td>
  </tr>
</table>

---
# 프로젝트 설계 및 구성
## 기획
평균 취업 준비 기간 약 1년, 취업 준비에 체계적인 관리 서비스가 필요하다!  
  
__Piccup__ 은 기업마다 다른 자기소개서 문항들, 이력서 요소들, 그리고 중구난방의 채용 일정들에 이리저리 치이는 취업 준비생들의 입장에서 시작했습니다. 
자주 쓰이는 자기소개서 문항들을 보기 좋게 정리해놓고 싶다거나, 지원 직무 별 필요한 이력 사항들을 미리 작성해놓고 싶다는 마음은 취업 준비생들의 마음 한켠에 자리잡고 있을 것입니다.  

  
Piccup은 이러한 취업 준비생의 한 자락의 불편과 물안을 해소해줄 수 있도록 취준 관리 프로젝트를 기획하여 탄생했습니니다. 
뒤죽박죽인 채용 일정을 한눈에 정리하고 전형 단계를 확인해볼 수 있는 기능과 더불어, 자기소개서와 이력서를 정리하여 필요할 때마다다 꺼내볼 수 있는 기능을 제공하는 
취업 준비생들에게 필요한 편리 서비스입니다.

---
## 데이터베이스 ERD

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
 ┃ ┃ ┃ ┣ 📂filter                   // JWT 인증 필터터
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
### 백엔드
- JAVA (JDK 17)
- Spring Boot 3.3.x (maven)  
[![My Skills](https://skillicons.dev/icons?i=java,spring)](https://skillicons.dev)

### 프론트엔드
- JavaScript
- Vue.js 2.1.10 (ES6)
- CSS3
- HTML5
- Tailwind CSS
- Axios 1.7.9
- Pinia 2.3.0  
[![My Skills](https://skillicons.dev/icons?i=js,vue,css,html,tailwind,pinia)](https://skillicons.dev)


### DB & WAS
- MySQL 8.0.40  
[![My Skills](https://skillicons.dev/icons?i=mysql)](https://skillicons.dev)

### API & OpenData
- 사람인 API


### Environment & Tool
- Window 10, 11/ Mac M2
- STS4 4.24.0 / 4.26.0
- VisualStudioCode
- Postman
- Git, GitHub
- Google Sheet, Discord  
[![My Skills](https://skillicons.dev/icons?i=postman,git,github,discord)](https://skillicons.dev)  

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
  <summary><b>상세 API 명세서 확인</b></summary>
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
      <h4>3-1. 조회</h4>
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
      <b>Response Elements</b>
      <table align="center">
        <tr align="center">
          <td>필드</td>
          <td>타입</td>
          <td>설명</td>
        </tr>
        <tr align="center">
          <td>resume</td>
          <td>-</td>
          <td>이력서 정보</td>
        </tr>
        <tr align="center">
          <td>userId</td>
          <td>Integer</td>
          <td>이력서 작성한 회원 pk</td>
        </tr>
        <tr align="center">
          <td>updatedAt</td>
          <td>TimeStamp</td>
          <td>이력서 작성 및 수정 날짜</td>
        </tr>
        <tr align="center">
          <td>personalInfo</td>
          <td>-</td>
          <td>개인 기본 정보</td>
        </tr>
        <tr align="center">
          <td>infoId</td>
          <td>Integer</td>
          <td>개인 기본 정보 pk</td>
        </tr>
        <tr align="center">
          <td>username</td>
          <td>String</td>
          <td>이름</td>
        </tr>
        <tr align="center">
          <td>birthDate</td>
          <td>Date</td>
          <td>생년월일</td>
        </tr>
        <tr align="center">
          <td>gender</td>
          <td>String</td>
          <td>성별</td>
        </tr>
        <tr align="center">
          <td>email</td>
          <td>String</td>
          <td>이메일</td>
        </tr>
        <tr align="center">
          <td>homePhone</td>
          <td>String</td>
          <td>전화번호</td>
        </tr>
        <tr align="center">
          <td>mobilePhone</td>
          <td>String</td>
          <td>휴대폰 번호</td>
        </tr>
        <tr align="center">
          <td>address</td>
          <td>String</td>
          <td>주소</td>
        </tr>
        <tr align="center">
          <td>addressDetail</td>
          <td>String</td>
          <td>상세 주소</td>
        </tr>
        <tr align="center">
          <td>postalCode</td>
          <td>Integer</td>
          <td>우편 번호</td>
        </tr>
        <tr align="center">
          <td>profileImgPath</td>
          <td>String</td>
          <td>취업사진 파일경로</td>
        </tr>
        <tr align="center">
          <td>profileImgName</td>
          <td>String</td>
          <td>취업사진 파일명</td>
        </tr>
        <tr align="center">
          <td>degree</td>
          <td>String</td>
          <td>학위</td>
        </tr>
        <tr align="center">
          <td>hobby</td>
          <td>String</td>
          <td>취미</td>
        </tr>
        <tr align="center">
          <td>specialty</td>
          <td>String</td>
          <td>특기</td>
        </tr>
        <tr align="center">
          <td>file</td>
          <td>String</td>
          <td>성적증명서, 포트폴리오 파일경로 및 파일명</td>
        </tr>
        <tr align="center">
          <td>projects</td>
          <td>-</td>
          <td>작성한 프로젝트 내용</td>
        </tr>
        <tr align="center">
          <td>projectId</td>
          <td>Integer</td>
          <td>프로젝트 pk</td>
        </tr>
        <tr align="center">
          <td>projectName</td>
          <td>String</td>
          <td>프로젝트 이름</td>
        </tr>
        <tr align="center">
          <td>role</td>
          <td>String</td>
          <td>프로젝트에서 맡은 역할</td>
        </tr>
        <tr align="center">
          <td>startDate</td>
          <td>Date</td>
          <td>프로젝트 시작일</td>
        </tr>
        <tr align="center">
          <td>endDate</td>
          <td>Date</td>
          <td>프로젝트 종료일</td>
        </tr>
        <tr align="center">
          <td>description</td>
          <td>String</td>
          <td>프로젝트 활동 내용</td>
        </tr>
        <tr align="center">
          <td>languages</td>
          <td>-</td>
          <td>어학</td>
        </tr>
        <tr align="center">
          <td>languageId</td>
          <td>Integers</td>
          <td>어학 pk</td>
        </tr>
        <tr align="center">
          <td>languageName</td>
          <td>String</td>
          <td>외국어 명</td>
        </tr>
        <tr align="center">
          <td>testName</td>
          <td>String</td>
          <td>시험명</td>
        </tr>
        <tr align="center">
          <td>score</td>
          <td>String</td>
          <td>점수</td>
        </tr>
        <tr align="center">
          <td>obtainedAt</td>
          <td>Date</td>
          <td>취득일자</td>
        </tr>
        <tr align="center">
          <td>certCode</td>
          <td>String</td>
          <td>자격번호</td>
        </tr>
        <tr align="center">
          <td>preference</td>
          <td>String</td>
          <td>자격번호</td>
        </tr>
      </table>
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
    <td>
      <img src="https://raw.githubusercontent.com/doh3e/piccup/refs/heads/develop/front/src/assets/icons/resume.gif" width="300;" alt=""/> 
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
    <td>
      <img src="https://raw.githubusercontent.com/doh3e/piccup/refs/heads/develop/front/src/assets/icons/coverletter.gif" width="300;" alt=""/> 
    </td>
    <td>
      <ul>
      <li>자기소개서를 직접 작성할 수 있습니다.</li>
      <li>자기소개서 문항을 직접 추가하고 삭제할 수 있습니다.</li>
      <li>직접 작성한 이력서를 조회하고 수정, 삭제할 수 있습니다.</li>
      </ul>
    </td>
  </tr>
</table>

### 4. 마이 페이지
<table>
  <tr>
    <td>
      <img src="https://raw.githubusercontent.com/doh3e/piccup/refs/heads/develop/front/src/assets/icons/calendar.gif" width="300;" alt=""/>  
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
<table>
  <tr>
    <td>
      <img src="https://raw.githubusercontent.com/doh3e/piccup/refs/heads/develop/front/src/assets/icons/board.gif" width="300;" alt=""/> 
    </td>
    <td>
      <ul>
      <li>서비스 공지사항과 문의 게시판을 제공합니다.</li>
      <li>문의 사항을 조회하고 직접 작성하여 문의를 남길 수 있습니다.</li>
      <li>남긴 문의 사항에 대한 답변을 받을 수 있습니다.</li>
      </ul>
    </td>
  </tr>
</table>

---
## 이슈 관리
