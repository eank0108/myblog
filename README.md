# 항해99 3주차 개인 과제  
1. 수정, 삭제 API의 request를 어떤 방식으로 사용하셨나요? (param, query, body)  
    - 수정: param 에 수정할 글의 id 값을 받고 body 에 json 형태로 수정할 내용과 비밀번호를 받았습니다.
    - 삭제: param 에 삭제할 글의 id 값을 받고 body 에 json 형태로 비밀번호를 받았습니다.

  
2. 어떤 상황에 어떤 방식의 request를 써야하나요?
   - param: resource 를 식별해야 할 경우(id 값 등등)
   - query: 인수의 순서가 중요할때(정렬이나 필터링)
   - body: 매우 많은 수의 데이터가 있을때(param이나 query는 url이 너무 길어짐)


  
3. RESTful한 API를 설계했나요? 어떤 부분이 그런가요? 어떤 부분이 그렇지 않나요?
   - CRUD 상황에 각각 알맞는 HTTP Method(Post,Get,Put, Delete) 를 사용함
   - 일반적으로 사용하는 json 을 통해 데이터 전달함으로써 어느 플랫폼이든 데이터 전달 가능함
   - 민감한 데이터(예를들면 비밀번호)의 암호화를 못해서 아쉽습니다. 