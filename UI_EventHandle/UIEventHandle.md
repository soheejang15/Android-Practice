# 화면 이벤트 처리 (UI Event Handle)  
## 화면 이벤트 핸들러 (UI Event Handler)  
* **"어떤 행위에 대한 요청을 처리하는 것"**
* ex) 행위(이벤트) : 버튼 누르기 → 요청 : 텍스트뷰 표시하기  
* **이벤트소스** : 이벤트가 발생하는 장소
* **핸들러** : 이벤트를 처리하는 클래스 

### 이벤트 실행 순서
1) 이벤트 발생
2) 액티비티가 이벤트 소스에 알림
3) 이벤트 소스에 등록된 핸들러 객체 생성 및 메서드 호출
4) 핸들러 메서드 실행

## 이벤트 처리 방법
### 1. 익명클래스 생성하여 이벤트 리스너로 사용
 ```java
 view.setOnClickListener(new View.onClickListener(){
  @Override
  public void onClick(View view){
    // Click Event
  }
})
 ```

 * 이벤트가 어디서 처리되는지 직관적으로 확인 가능
 * 코드의 간결성  
 → 가장 자주 사용되는 방법
 *  이벤트 소스 수가 증가하는 만큼 익명 클래스 객체를 생성
 * 

### 2. 익명클래스의 참조를 이벤트 리스너로 활용
 ```java
 View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.Gram :
                        // Click Event
                        break ;
                    case R.id.Undefined :
                        // Click Event
                        break ;
                }
            }
        } ;
 view.setOnClickListener(onClickListener) ;
 ```

 * 매번 객체를 새로 만들지 않아도 됨
* 이벤트 소스가 직관적이지 않음



## 이벤트 처리 용어
|  <center>Header1</center> |  <center>Header2</center> | 
|:----------|:----------:|
|<center>**이벤트**<br>Event</center> | <center>**정해진 행위**<br>OnClick<br>OnKey<br>OnTouch</center> |
|**<center>이벤트 소스**<br>Event Source</center> | <center>**이벤트가 발생하는 지점**<br></center> |
|**이벤트 리스너**<br>Event Listener | <center> **각 이벤트를 처리할 메서드가 선언되어 있음**<br>![Alt text](캡처.jpg) </center> |
|**이벤트 리스너**<br>Event Listener | <center> **각 이벤트를 처리할 메서드가 선언되어 있음**<br>![Alt text](캡처.jpg) </center> |