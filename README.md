# spring을 사용한 게시판 만들기
spring 개인 프로젝트

**1. 개발 목표** : CRUD를 사용하여 게시판 구현

**2. 메인 사진**
![제목 없음](https://github.com/rony-yang/public_board/assets/116271236/36e214f1-45e1-401c-b6ca-123e839b987e)

![제목 없음2](https://github.com/rony-yang/public_board/assets/116271236/e9eab006-a9b8-4feb-a5ad-8adac7594e9e)

**3. URL 주소** : 추후 게시 예정

**4. 작업기간** : 2024. 5월 ~ 6월

**5. 사용 기술**

- 언어 : java, javaScript

- 프레임워크 : Spring Framework

- 웹 개발 : JSP, HTML, CSS(bootstrap), ajax

- 서버 : Tomcat

- DB : Oracle

- IDE : sts3, sql developer, Github

**6. 주요기능**

- 회원가입 : 아이디 중복검사 기능

- 로그인 : 로그인 시 좌측 네비바에 로그인 중인 아이디를 표시하는 기능, 중복 로그인 방지 기능

- 로그아웃 : 로그아웃으로 세션 삭제 기능

- 게시판 : 글 읽기는 비회원도 가능하지만 글 쓰기는 회원만 활성화, 글 수정 기능

- 글 제목 및 내용으로 내용 검색 가능

**7. Advanced Feature**

게시판 글 작성 시 로그인 여부를 먼저 확인하는 부분입니다.

비회원은 로그인을 요청하는 에러창을 띄워주고, 회원은 글 작성 시 게시글을 저장하여 작성된 글의 상세페이지로 바로 이동합니다.

```java
// BoardController.java 일부분

@RequestMapping(value="/create", method=RequestMethod.POST)
public String postCreate(@RequestParam Map<String, Object> map,
    HttpSession session, RedirectAttributes redirectAttributes) {
		
    String loginId = (String) session.getAttribute("loginId");

    if (loginId == null || loginId.isEmpty()) {
        redirectAttributes.addFlashAttribute("error", "로그인을 먼저 해주세요.");
        return "redirect:/login";
    }
		
  map.put("loginId", loginId); // 로그인된 사용자 ID를 추가
	int boardContSeq = this.BoardService.create(map);
	return "redirect:/read/" + String.valueOf(boardContSeq);
}
```

