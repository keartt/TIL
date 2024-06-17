
```
`한글` -> 앞뒤의 백틱은 구분을 위해 넣어둔 것으로 실제론 적지 않는다.
```

## Commit
#### 추가하고 push 하기
```bash
#. 은 모든 변경 사항 * 은 현재 디렉토리의 변경사항 (파일명을 직접 입력도 가능)
git add . 
git commit -m "메시지 작성, 엔터로 구분할 수 있음"
#origin 은 원격저장소, main 대신 원하는 브랜치명 적을 수 있음
git push origin main 
```

#### 커밋 목록 확인

```bash
git log
```

#### 원하는 커밋상태로 가기
    
```bash
#log 에서 원하는 커밋 아이디 확인
git log 

git checkout `커밋아이디`
```
    


#### 커밋메시지 변경

```bash
#최근 하나의 커밋 메시지만 수정 가능
git commit --amend
```

#### 깃 add 취소

```bash
# 현재 깃 상태 확인 브랜치 and add 되어있는거
git status

# 그거 삭제
git reset HEAD `파일명`
```


## Branch
#### 브랜치 생성

```bash
# 브랜치 생성 및 이동
git branch -b `브랜치명`

# 브랜치 원격으로 
git push origin `브랜치명`
```

#### 브랜치 삭제

```bash
git branch -d `브랜치명`
```

#### 원격 브랜치 강제 삭제

```bash
git push origin --delete `브랜치명`
```



#### 브랜치변경하기
    
```bash
git checkout `브랜치명`
```

#### 원격 레포지토리 내용을 내 로컬로 가져오기

```bash
git clone `레포지토리 주소`
```

#### 원격 저장소와 로컬 저장소 연결

```bash
git remote add origin `레포지토리주소`
```


