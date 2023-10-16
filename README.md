<style>
    .tb{
            border: 2px;
            width: 100%;
            border-collapse: collapse;
            border: 1px solid #444444;
    }
    .tr{
        border:1px solid #444444;
    }
    .tr > td 
    {
        border:1px solid #444444;
    }

</style>


# Emoji-Maker
> **이모티콘 자동 생성 사이트** <br/> **개발기간: 2022.06 ~ 2023.06** 
<br/>

## 프로젝트 소개 

사용자의 다양한 입력을 바탕으로 사용자 개인에게 맞춘 개성있는 이모티콘을 AI파이프라인을 통해 제작하는 서비스입니다. 
<br>
입력을 받은 사용자 이미지를 기반으로 생성된 이모티콘의 여러 화풍을 사용자에게 제공하는 것이 목표입니다.
<br>
선택한 화풍에 대해서 instructPix2Pix를 통해 개인화된 이모티콘을 제작하여 사용자에게 제공합니다.
<br>
저희 서비스를 통하여 생성된 이모티콘을 통해 SNS 상의 자신만의 표현수단을 만들어 커뮤니케이션의 다양화를 이룩하는 기대가 있습니다. 

**다음은 [프론트엔드 프로젝트](https://github.com/nulzi/MaroMaro)**  페이지입니다. 

<br/>

## 웹개발팀 소개 

|육마로|정의현|김성준|김도건|
|:---:|:---:|:---:|:---:|
|<img width="130px" src="https://avatars.githubusercontent.com/u/55569476?v=4"/>|<img width="130px" src="https://avatars.githubusercontent.com/u/98465697?v=4"/>|<img width="130px" src="https://avatars.githubusercontent.com/u/90247223?v=4"/>|<img width="130px" src="https://avatars.githubusercontent.com/u/102578327?v=4"/>|
|[@RDDCat](https://github.com/RDDcat)|[@Euihyunee](https://github.com/Euihyunee)|[@kim-song-jun](https://github.com/kim-song-jun)|[@dogeonK](https://github.com/dogeonK)|
|한국공학대학교 소프트웨어학과 4학년|한국공학대학교 소프트웨어학과 4학년|한국공학대학교 소프트웨어학과 4학년|한국공학대학교 소프트웨어학과 4학년|
|||||


### 팀원 역활 

||||
|:---:|:---:|:---|
|육마로(팀장)|프로젝트 기획 및 어플리케이션 구조설계|팀의 팀장으로 프로젝트의 전체 구성과 관리 그리고 기획을 담당했습니다.|
|김도건| 백엔드 개발 및 배포 파이프라인 구성|AI 파이프라인 개발 / Django 백엔드 서버와 해당 서버와 통신을 위한 api 개발과 배포를 담당했습니다.|
|김성준| 프론트 엔드 개발 및 디자인 시안 작성|Vue.js와 NginX 기반의 프론트엔드 서버의 개발과 배포 담당하였으며 사용자 UI/UX 기획과 디자인을 담당했습니다.|
|정의현| 메인 백엔드 프로젝트 개발|요청 도메인의 전반적인 부분을 담당했습니다. Spring Boot와 MariaDB로 이루어진 백엔드 서버와 DB의 설계와 구현을 담당했습니다.|
||||



### 개발 환경 


<table class="tb"> 
    <tr class="tr">
        <td> CDN</td>
        <td> cafe24</td>
        <td> Linux</td>
        <td> 500GB</td>
    </tr>
    <tr class="tr">
        <td> 서버</td>
        <td> EC2</td>
        <td> Linux</td>
        <td> 50GIB</td>
    </tr>
    <tr class="tr">
        <td rowspan='7'> 소프트웨어</td>
        <td rowspan='4' > 프레임워크</td>
        <td> Vue.js</td>
        <td> 3</td>
    </tr>
    <tr class="tr">
        <td> Node.js</td>
        <td> 16.17</td>
    </tr>
    <tr class="tr">
        <td> Spring Boot</td>
        <td> 2.7.3</td>
    </tr>
    <tr class="tr">
        <td> Django</td>
        <td> 4.1</td>
    </tr>
    <tr class="tr">
        <td rowspan='2'> 언어 </td>
        <td> Java</td>
        <td> 1.8</td>
    </tr >
    <tr class="tr">
        <td> Python</td>
        <td> 3.9 </td>
    </tr>
    <tr class="tr">
        <td> 데이터베이스</td>
        <td> MariaDB</td>
        <td> 10.6</td>
    </tr>
</table>

- Django 서버에서 입력된 데이터를 기반으로 개인화된 이모티콘을 생성하면 이미지 데이터 를 저장할 공간이 필요하기 때문에 cafe24호스팅 업체에서 500GB CDN 서버를 빌려 저장한다.
Django 서버와 Spring 서버, MariaDB를 AWS EC2서버를 통해 배포한다. Vue.js프레임워크를 이용한 프론트엔드 프로젝트또한 EC2서버에 Nginx를 이용하여 배포하며 이 서버를 각 도메인 을 이어주는 api gateway로써 활용한다.
- 다양한 소프트웨어를 활용하여 프로젝트를 구성한다. 프론트엔드 프로젝트는 Vue.js 3버전 과 Node.js 16.17버전을 활용하며 JS 언어를 사용한다. 백엔드의 경우 이미지처리와 조회, 데 이터베이스 접근등의 요청을 처리하기 위해 2개의 서버를 활용하며 Spring 2.7.3, Django 4.1 버전의 프레임워크를 사용한다. Spring은 Java 1.8, Django는 Python 3.9를 이용한다. 데이터 베이스로는 MariaDB 10.6버전을 사용한다.

### 개발 내용 

#### 1. 아키텍쳐

- Back-end는 Django와 Spring으로 나누어 각각의 도메인을 구현했습니다. 
- DB는 하나의 데이터베이스로 모놀리틱하게 운영했습니다. 
- Nginx Front-end 서버를 api gateway로써 사용했습니다. 
- 웹을 기반으로 개발하되 모바일에서 동작할수 있게 웹뷰와 네이티브 파일권한을 Front-end에서 개발한다. 

#### 2. 동작 과정 

- [데모 영상](https://www.youtube.com/watch?v=AVws_wapf8M)
- 사용자 이미지 업로드 및 back-end 데이터 요청
- 이미지를 화풍별로 변환 
    - 화풍 선택후 다음 페이지로 이동
- 선택한 화풍으로 이모지 세트 생성 


#### 3. API Documentation

<table class='tb'> 
    <tr class="tr">
        <td> API 제공</td>
        <td> 설명 </td>
    </tr>
    <tr class="tr">
        <td rowspan='2'> Java-Spring</td>
        <td> 이미지 업로드 및 ai 처리 요청 기능 </td>
    </tr>
    <tr class="tr">
        <td>  http://3.39.22.13:8080/image/upload</td>
    </tr>
    <tr class="tr">
        <td rowspan='2'> Java-Spring</td>
        <td>  화풍이 변환된 이미지 리스트 요청</td>
    </tr>
    <tr class="tr">
        <td>  http://3.39.22.13:8080/tag/status/{requestId}</td>
    </tr>
    <tr class="tr">
        <td rowspan='2'> Java-Spring</td>
        <td>  특정 화풍으로 이미지를 이모티콘으로 변환 요청</td>
    </tr>
    <tr class="tr">
        <td>  http://3.39.22.13:8080/tag/api/{requestId}/{tagName} </td>
    </tr>
    <tr class="tr">
        <td rowspan='2'> Java-Spring</td>
        <td>  특정 화풍으로 변환된 이모티콘 url 리스트 가져오기</td>
    </tr>
    <tr class="tr">
        <td>  http://3.39.22.13:8080/tag/select/{requestId}/{tagName}</td>
    </tr>
    <tr class="tr">
        <td rowspan='2'> Java-Spring</td>
        <td>  업로드된 이미지 가져오기</td>
    </tr>
    <tr class="tr">
        <td>  http://3.39.22.13:8080/image/api/{requestId}</td>
    </tr>
    <tr class="tr">
        <td rowspan='2'> Django-Python(ai)</td>
        <td> 이미지 화풍 변환</td>
    </tr>
    <tr class="tr">
        <td> http://13.114.204.13:8000/tag/{requestId}/{img_url}</td>
    </tr>
        <tr class="tr">
        <td rowspan='2'> Django-Python(ai)</td>
        <td> 화풍 변환된 이미지 JSON 데이터 POST 요청 보내기</td>
    </tr>
    <tr class="tr">
        <td> http://13.114.204.13:8000/api/picture/{requestId}</td>
    </tr>
    <tr>
        <tr class="tr">
        <td rowspan='2'> Django-Python(ai)</td>
        <td> 선택된 화풍 기반으로 이모티콘 생성</td>
    </tr>
    <tr class="tr">
        <td> http://13.114.204.13:8000/stable/{requestId}/{img_url}/{tag_name}</td>
    </tr>
        <tr class="tr">
        <td rowspan='2'> Django-Python(ai)</td>
        <td> 생성된 이모티콘 JSON 데이터 POST 요청 보내기</td>
    </tr>
    <tr class="tr">
        <td> http://13.114.204.13:8000/api/emoji/{requestId}</td>
    </tr>
    <tr class="tr">
        <td rowspan='2'> Django-Python(ai)</td>
        <td> DB 테이블에 저장된 화풍 변환된 이미지 띄우기</td>
    </tr>
    <tr class="tr">
        <td> http://13.114.204.13:8000/showImg/{requestId}/{tag_name}/{setNum}</td>
    </tr>
    <tr class="tr">
        <td rowspan='2'> Django-Python(ai)</td>
        <td> DB 테이블에 저장된 이모티콘 gif 띄우기</td>
    </tr>
    <tr class="tr">
        <td> http://13.114.204.13:8000/showEmojiGif/{requestId}/{tag_name}/{emojiTa g}/{setNum}</td>
    </tr>
    
</table>

