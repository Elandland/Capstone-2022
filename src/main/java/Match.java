import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/*              안드로이드 스튜디오에서 vibrate 기능 작성하기.

<uses-permission android:name="android.permission.VIBRATE" />           //AndroidManifest.xml에 추가

private Vibrator vibrator; //vibrator 객체 만들기

vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);        //객체 정의

vibrator.vibrate(10000); // 10초간 진동

long[] pattern = {5000, 1000, 5000, 1000}; // 5초진동, 1초 대기, 5초 진동, 1초 대기
vibrator.vibrate(pattern, -1);      // -1은 반복시키지 않겠다는 뜻


 */





public class Match {

    //대충 취향 10개라고 가정하고
    int[] Like = new int [10];
    //애초에 받아올때부터 {0,1,1,1,0,0,0,0,1,1}이런식의 json으로 받아오기

    //json값을 배열로 치환

    public ArrayList<String> list = new ArrayList<String>();



    JSONArray jsonArray = new JSONArray();

    if (jsonArray != null) {
        int len = jsonArray.length();
        for (int i=0;i<len;i++){
            list.add(jsonArray.get(i).toString());
        }
    }

    //client에 UserDB로 저장 후 메인 서버 DB로 이동
    int[] UserDB = new int[10];

    //userDB = json 받은거;
    //항상 자기 휴대폰에는 UserDB가 존재. 상대방거는 OtherDB로 받아옴
    int[] OtherDB = new int[10];


    public void Match_like(UserDB, OtherDB);

    //UserDB, OtherDB 연산은 비트 연산 처리.
    public void Match_like(UserDB, OtherDB) {
        //비트 연산
        //Match[] = 1 인게 서로 취향 겹치는 거.

        int[] counter = new int[2];
        int[] Match = new int [10];

        for(int i=0; i<10; i++)
        {
            if(UserDB[i]==OtherDB[i])
            {
                counter[1]++;
            }
        }

        for (int i=0; i<Match.length; i++)
            counter[Match[i]]++;

        if(counter[1]>=7){
            vibrator.vibrate(10000);    //10초 진동
            //휴대폰 진동 시키는 함수;
        }
        //cnt.Match[]해서 7이상 이면 진동 (vibrate)
    }

    public void blacklist();

}





