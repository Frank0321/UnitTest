# UnitTest

## Mockito
### Mock
  - 創建一個已受控制的對象，也可以說是一個假的對象，主要是模擬 spring 管理的 bean、返回值、拋出 exception 等
  - 由於要測試的對象為 classA ，但是他會引用 classB 的方法，甚至 classB 會用到 classD 的方法...
    ![圖片](https://kucw.github.io/images/blog/unittest_mock1.png)
  - 如果直接使用到 classB、classC 之類的其他 class，測試結果會受到其他 class 的影響；
    有可能今天 classA 測試過了，但明天有改到 classB，然後測試就失敗了...
  - 因此會使用到 mock 來產生假的 classB、和 classC，確保 classA 的結果不會受到其他引響
    ![圖片](https://kucw.github.io/images/blog/unittest_mock2.png)
  - Ｍock 物件從頭都是假的，被需要的時候，都不會做任何事情
  
### Spy
  - 是屬於一個半真實的存在
    - 如果設定 mock 的回傳資料，則會以 mock 資料回傳
    - 無任何設定時，會以真實的方式進行回傳

## 範例程式介紹
- 設定一個 model、一個 Repository (interface)、一個 interface 的方法，和一個 service

### MockitoDefaultValuesDemo
- Demo 為一個 interface
- 在 default 的情況下，這些型別預設的值如範例所示
- Integer.intValue() : 將 Integer 轉換為 int 的方法
  ```java
  Integer obj = new Integer(15);
  // returns the value of this Integer as an int
  int i = obj.intValue();
  System.out.println("Value of i = " + i);
  ```
- Assert.assertEquals(expected, actual, delta)
  - delta 是預期與實際之間的最大差異
  
### doReturn().when() 與 when().thenReturn() 差異

- when().thenReturn() 
  - 會先執行一次此方法，在修改回傳條件
- doReturn().when()
  - 不執行此方法，直接回傳結果



- [doReturn().when()与when().thenReturn()](https://segmentfault.com/a/1190000021709812)
- [Mockito 中的差異](https://www.cnblogs.com/lanqi/p/7865163.html)

- [make the assertion between floats](https://stackoverflow.com/questions/7554281/junit-assertions-make-the-assertion-between-floats)
- [Integer.intValue()方法實例](http://tw.gitbook.net/java/lang/integer_intvalue.html)




## 參考資料
- [A Unit Testing Practitioner's Guide to Everyday Mockito](https://www.toptal.com/java/a-guide-to-everyday-mockito)
- [SpringBoot - 單元測試工具 Mockito](https://kucw.github.io/blog/2020/2/spring-unit-test-mockito/)
- [doReturn 和 when 的差異](https://stackoverflow.com/questions/20353846/mockito-difference-between-doreturn-and-when)
