## 📌 auto_push.sh — Programmers 자동 업로드 스크립트

이 스크립트는 프로그래머스 문제 풀이 폴더를 자동으로 감시하여,
DONE 파일이 생성되면 GitHub에 자동 커밋 & 푸시하는 자동화 도구입니다.

Git Bash(또는 리눅스 Bash)에서 실행되며,
문제 풀이 후 DONE 파일만 만들어주면 나머지 작업은 모두 자동으로 처리됩니다.

### 🚀 기능 요약

Programmers 폴더 내부를 주기적으로 스캔

DONE 파일이 있는 문제 폴더 자동 감지

해당 폴더 기준으로 자동:

git add .

git commit -m "auto: solved <폴더명>"

git push

push 완료 후 DONE 파일 자동 삭제

3초 간격으로 계속 반복 감시 (실시간 자동화에 가까움)

---

++ bash 환경에서는 스크립트를 백그라운드에서 실행 가능하다고 한다.

git bash 를 계속 실행 시켜두는 경우에 유용할 것 같다.

* 1) 명령어 - ./auto_push.sh &
* 2) 백그라운드 job 확인 - jobs
* 3) 중지 - kill %1
