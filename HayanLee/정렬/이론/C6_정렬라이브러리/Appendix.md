# 📚 정렬 라이브러리 - Arrays와 Collection
### 1️⃣ ```Arrays.sort(배열);```
- 오름차순으로 정렬하고 싶은 배열을 전달인자로 주면, 전달인자로 받은 배열이 정렬된다.
    - 문자열의 경우, 아스키코드 순(알파벳 순)으로 오름차순 정렬되며, 한글도 가나다 순으로 정렬된다.

<br>

#### Sort(Array)
- java.util.Arrays 클래스에 static 메서드로 선언되어 있다.
  ![image](https://github.com/hayannn/2L24-Algo-Study/assets/102213509/cb80e30d-1c72-4c02-8cbf-3a1ec672976c)

  ```java
  import java.util.Arrays;
  import java.util.Collections;
    
  public class ArraysTest_오름차순정렬 {
    
      public static void main(String[] args) {
          int[] intArr = {8,7,6,5,4};
          for(int i: intArr) 
              System.out.print(i + " ");
          System.out.println();
                  //8 7 6 5 4
    
          Arrays.sort(intArr); // 오름차순 정렬
          for (int i : intArr) 
              System.out.print(i + " ");
          System.out.println();
                  //4 5 6 7 8
    }
  }
  ```

<br>

#### Sort(Array, Comparator)
- 오름차순 정렬이 아닌, 임의의 정렬 기준을 적용할 경우 Comparator를 구현한 클래스를 전달인자로 주어 정렬한다.
  ```java
    import java.util.Arrays;
    import java.util.Collections;
    
    public class ArraysTest_커스텀정렬 {
    
        public static void main(String[] args) {
            int[] intArr = {8,7,6,5,4};
            for(int i: intArr) 
                System.out.print(i + " ");
            System.out.println();
                    //8 7 6 5 4

            Arrays.sort(intArr, Collections.reverseOrder()); // 내림차순 정렬
            for (int i : intArr) 
                System.out.print(i + " ");
                    // 8 7 6 5 4
        }
    }
  ```

<br>
<br>

### 2️⃣ ```Collenctions.sort()```
![image](https://github.com/hayannn/2L24-Algo-Study/assets/102213509/debbe571-0ed9-4fc9-855d-80a90732e5df)
- **T 타입의 List 객체를 전달인자로 받는 첫번째 Sort**
    - T 타입 클래스에서 Comparable을 구현하고 있어야 사용이 가능하다.
  ```java
    public interface Comparable<T> {
    public int compareTo(T o);
  }
  ```

<br>

- 전체 구조는 Arrays.sort()와 비슷하다.
    ```java
    public class CollectionsTest {
    
        public static void main(String[] args) {
            
            Integer[] intArr = {9,8,7,6,5};
            //int 배열을 List 타입으로 변환
            List<Integer> intList = Arrays.asList(intArr);
            
            for(int i : intList) 
                System.out.print(i + " ");// 9 8 7 6 5
            System.out.println();
    
            Collections.sort(intList); // 5 6 7 8 9
            for(int i : intList) 
                System.out.print(i + " ");
            
    }
    ```

<br>
<br>

### 3️⃣ ```Arrays.sort()``` VS ```Collenctions.sort()```

|               |              Arrays.sort()               |                 Collections.sort()                 |
|:-------------:|:----------------------------------------:|:--------------------------------------------------:|
|     정렬 대상     |                    배열                    |                        리스트                         |
|    인자의 형태     |          정렬할 배열을 직접 메서드의 인자로 전달          |                정렬할 리스트를 메서드의 인자로 전달                |
|    정렬 알고리즘    | 요소의 수가 적고, 배열 형태에 따라 선택된 최적의 정렬 알고리즘을 사용 |          항상 병합 정렬(Merge Sort) 사용해 리시트를 정렬          |
| 가변인자 사용 가능 여부 |      오버로드된 버전을 사용해 여러 배열을 동시에 정렬 가능      |                 오직 1개의 리스트만을 정렬 가능                 |
|     선언 형태     |    정적 메서드, Arrays.sort(T[] a)와 같이 사용됨    | 정적 메서드가 아님, Collections.sort(List<T> list)와 같이 사용됨 |

---

### 🔗 source
- [[JAVA] Sort 사용 (Arrays, Collections)](https://80000coding.oopy.io/21cb57a3-681b-404d-a4ac-8ab0e7289bc0)<br>
- ChatGPT 답변