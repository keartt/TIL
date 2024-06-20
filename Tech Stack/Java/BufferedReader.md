# BufferedReader

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


StringTokenizer st = new StringTokenizer(br.readLine());
st.hasMoreTokens()
st.nextToken();

```


### EOF
st 로 마지막 더 이상 입력값이 없는지 확인하려면
(백준에서는 OK but IDE 에서는 안댐(Ctrl + D))
```java
 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

String str;
while ((str = br.readLine()) != null){
    StringTokenizer st = new StringTokenizer(str);
}
```
