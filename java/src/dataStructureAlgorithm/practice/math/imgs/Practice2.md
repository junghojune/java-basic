dataStructureAlgorithm.practice.LinearDs.linearDs_02.Practice
===

문제 설명
---

회문 또는 팰린드롬(palindrome)은 앞 뒤 방향으로 같은 순서의 문자로 구성된 문자열을 말한다.  
- 예시) ‘abba’ ‘kayak’, ‘madam’


<br/>

유사회문은 문자열 그 자체는 회문이 아니지만 한 문자를 삭제하면 회문이 되는 문자열을 말한다.  
- 예시) ‘summuus’의 5번째 또는 6번째 문자 ‘u’를 제거하면 ‘summus’인 회문을 만들 수 있다.

<br/>
주어진 문자열을 확인한 후 문자열 종류에 따라 다음과 같이 출력하는 프로그램을 작성하세요.

- 회문: 0
- 유사회문: 1
- 기타: 2


입력 예시
---
|입력|출력|
|---|---|
|abba|0|
|summuus|1|
|xabba|1|
|xabbay|2|
|comcom|2|
|comwwmoc|0|
|comwwtmoc|1|
