package org.androidtown.maphistory;

        import com.nhn.android.maps.NMapActivity;
        import com.nhn.android.maps.NMapController;
        import com.nhn.android.maps.NMapOverlayItem;
        import com.nhn.android.maps.NMapView;
        import com.nhn.android.maps.NMapView.OnMapStateChangeListener;
        import com.nhn.android.maps.NMapView.OnMapViewTouchEventListener;
        import com.nhn.android.maps.maplib.NGeoPoint;
        import com.nhn.android.maps.nmapmodel.NMapError;
        import com.nhn.android.maps.overlay.NMapPOIdata;
        import com.nhn.android.maps.overlay.NMapPOIitem;
        import com.nhnnhnnhn.android.mapviewer.NMapPOIflagType;
        import com.nhnnhnnhn.android.mapviewer.NMapViewerResourceProvider;

        import com.nhn.android.mapviewer.overlay.NMapOverlayManager;
        import com.nhn.android.mapviewer.overlay.NMapPOIdataOverlay;



        import android.os.Bundle;
        import android.util.Log;

        import android.view.MotionEvent;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;

        import android.widget.LinearLayout;




public class MapActivity extends NMapActivity implements OnMapStateChangeListener,
        NMapPOIdataOverlay.OnStateChangeListener
        ,OnMapViewTouchEventListener{
    Button b1;
    Button b4;
    Button b3;
    Button b2;
    Button b5;


    LinearLayout layout ; //layout = new FrameLayout(this); onCreate 밖에서 객체화하면 오류가 난다. 이유는 뭘까?
    LinearLayout layoutbutton ;

    private final String CLIENT_ID = "blO41_0EXnmayxa7ZJwQ";

    NMapView mMapView ;
    NMapController mMapController = null;
    NMapViewerResourceProvider mMapViewerResourceProvider;
    NMapOverlayManager mOverlayManager ;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);// create map view

        layout = new LinearLayout(this);
        b1 = new Button(this);
        b2 = new Button(this);
        b3 = new Button(this);
        b4 = new Button(this);
        b5 = new Button(this);
        layoutbutton = new LinearLayout(this);

        b1.setText("고대");

        b2.setText("중세");
        b3.setText("근세");
        b4.setText("근현대");
        b5.setText("전체");
        LinearLayout.LayoutParams bp = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT,1);
        layoutbutton.setOrientation(LinearLayout.HORIZONTAL);
        layoutbutton.addView(b1,bp);
        layoutbutton.addView(b2,bp);
        layoutbutton.addView(b3,bp);
        layoutbutton.addView(b4,bp);
        layoutbutton.addView(b5,bp);



        mMapView = new NMapView(this);// set a registered API key for Open MapViewer Library
        mMapViewerResourceProvider = new NMapViewerResourceProvider(this);

        LinearLayout.LayoutParams nparam = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT,2
        );
        LinearLayout.LayoutParams tparam = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT,1

        );
        layout.setOrientation(LinearLayout.VERTICAL);
        //tparam.gravity= Gravity.RIGHT;    //동적으로 생성한 view 위치 옮기기
        layout.addView(mMapView,nparam);
        layout.addView(layoutbutton,tparam);
        this.setContentView(layout);// initialize map view

        mOverlayManager = new NMapOverlayManager(this,mMapView,mMapViewerResourceProvider);
        mMapView.setClientId("blO41_0EXnmayxa7ZJwQ");// set the activity content to the map view

        mMapView.setClickable(true);// register listener for map state changes
        mMapView.setFocusable(true);
        mMapView.setFocusableInTouchMode(true);
        mMapView.requestFocus();
        mMapView.setOnMapStateChangeListener(this);
        mMapView.setOnMapViewTouchEventListener(this);// use map controller to zoom in/out, pan and set map center, zoom level etc.
        mMapView.setBuiltInZoomControls(false, null);
        mMapController = mMapView.getMapController();

        mMapView.setOnMapStateChangeListener(this);

        mMapView.setOnMapViewTouchEventListener(this);

        final int markerId = NMapPOIflagType.PIN;
        final NMapPOIdata poiData = new NMapPOIdata(176, mMapViewerResourceProvider); //전체 POI 아이템의 개수와 NMapResourceProvider를 상속받은 클래스를 인자로 전달한다.
        poiData.beginPOIdata(176); //POI 아이템 추가를 시작한다.

// 근세
        final   NMapPOIitem item1 = poiData.addPOIitem( 127.009567,37.571343, "흥인지문", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item2 = poiData.addPOIitem(126.975313,37.560191, "숭례문", markerId, 0);
        final   NMapPOIitem item3 = poiData.addPOIitem(126.958227,37.582076, "서울 한양 도성", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item4 = poiData.addPOIitem(126.977077,37.580034,  "경복궁 근정전", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item5 = poiData.addPOIitem(126.991010,37.579618,  "창덕궁", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item6 = poiData.addPOIitem( 126.994859,37.578958, "창경궁", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item7 = poiData.addPOIitem(126.975114, 37.566026, "덕수궁", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item8 = poiData.addPOIitem(127.009652, 37.564445,  "광희문", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item9 = poiData.addPOIitem(127.003712,37.588081, "혜화문", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item10 = poiData.addPOIitem(126.958157,37.598060, "홍지문", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item11 = poiData.addPOIitem( 126.998756,37.578466,  "경모궁", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item12 = poiData.addPOIitem(126.994197,37.574796, "종묘", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item13 = poiData.addPOIitem(126.967554,37.575864, "사직단 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item14 = poiData.addPOIitem(127.188487,37.480456,  "남한산성", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item15 = poiData.addPOIitem(127.205065,37.658099,  "광해군 묘", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item16 = poiData.addPOIitem(126.533352,37.717003,  "문수산성", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item17 = poiData.addPOIitem(127.032058,37.581189,  "선농단 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item18 = poiData.addPOIitem(127.107060,37.503504, "삼전도비", markerId, 0); //POI아이템 설정item31.setRightButton(true); //마커 선택 시 표시되는 말풍선의 오른쪽 버튼을 설정한다.
        final   NMapPOIitem item19 = poiData.addPOIitem(127.018183,37.573350, "동관왕묘(동묘)", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item20= poiData.addPOIitem(127.045939,37.553897, "살곶이다리", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item21= poiData.addPOIitem(126.987063,37.576281, "운현궁 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item22 = poiData.addPOIitem(127.018025,37.287954, "수원화성", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item23= poiData.addPOIitem(126.524298,37.649566, "강화 덕진진", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item24 = poiData.addPOIitem(126.532549,37.632784, "강화 초지진", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item25 = poiData.addPOIitem(126.869604,37.865744, "자운서원", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item26 = poiData.addPOIitem( 126.530126,37.665199, "강화 광성보 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item27 = poiData.addPOIitem(127.207582,37.639215,  "홍유릉", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item28 = poiData.addPOIitem(126.463457,37.666723,  "곤릉", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item29 = poiData.addPOIitem(127.082330,37.464578,  "헌인릉", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item30 = poiData.addPOIitem(127.051412,37.508245,  "정릉", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item31 = poiData.addPOIitem( 127.045887,37.508466,  "선릉", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item32 = poiData.addPOIitem(127.055694,37.605647,  "의릉 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item33 = poiData.addPOIitem(127.048987,37.510202,  "정현왕후 묘", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item34 = poiData.addPOIitem(126.709490,37.612890,  "장릉 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item35 = poiData.addPOIitem(126.951113,37.718990,  "온릉 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item36 = poiData.addPOIitem(126.868728,37.663743,   "서삼릉", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item37 = poiData.addPOIitem(126.897584, 37.628179,   "서오릉", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item38 = poiData.addPOIitem(126.824700,37.600100, "행주산성", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item39 = poiData.addPOIitem(127.016692, 37.277778, "팔달문", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item40 = poiData.addPOIitem(128.580226 , 36.925816,  "소수서원" , markerId, 0); //POI아이템 설정
        final   NMapPOIitem item41 = poiData.addPOIitem(128.843272 , 36.727319, "도산서원", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item42 = poiData.addPOIitem(126.525927,33.510624, "오현단", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item43 = poiData.addPOIitem(126.799657,33.386630,  "성읍 민속마을", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item44 = poiData.addPOIitem(127.339014,34.907338,  "낙안읍성", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item45 = poiData.addPOIitem(126.314057, 34.584658,  "명량대첩비", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item46 = poiData.addPOIitem(127.012135,35.184551,   "소쇄원", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item47 = poiData.addPOIitem(126.847103 ,34.923097,"불회사석장승", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item48 = poiData.addPOIitem(126.751739,35.310954, "필암서원", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item49 = poiData.addPOIitem(128.002889 , 35.474407, "영암사지", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item50 = poiData.addPOIitem(128.517957  , 36.539256, "화회마을", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item51 = poiData.addPOIitem(128.667914 , 36.657986, "개목사 원통전 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item52 = poiData.addPOIitem(128.744681 , 36.565258, "임청각", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item53 = poiData.addPOIitem(128.552762 , 36.540600,  "병산서원", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item54 = poiData.addPOIitem(129.254341  , 36.001093,  "양동마을", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item55 = poiData.addPOIitem(129.163133 , 36.011980,  "옥산서원", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item56 = poiData.addPOIitem(127.811912 , 36.668336,  "송시열유적", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item57 = poiData.addPOIitem(128.082423  , 37.161006, "배론성지", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item58 = poiData.addPOIitem(128.878129 , 37.779688,   "오죽헌", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item59 = poiData.addPOIitem(128.879802  , 37.779348,  "신사임당 초충도병", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item60 = poiData.addPOIitem(128.885011  , 37.786901, "강릉 선교장", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item61 = poiData.addPOIitem(126.979674 , 37.424408,  "조선방역지도", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item62 = poiData.addPOIitem(127.149219 , 35.813523,  "정동성당", markerId, 0); //POI아이템 설정

//중세
        // final  NMapPOIitem item19 = poiData.addPOIitem( 126.424364,37.781935,  "석조여래입상", markerId, 0); //POI아이템 설정
        final  NMapPOIitem item63 = poiData.addPOIitem(126.473392,37.754651,  "강화산성", markerId, 0); //POI아이템 설정
        final  NMapPOIitem item64 = poiData.addPOIitem(127.022510,37.661619,  "연산군묘", markerId, 0); //POI아이템 설정item32.setRightButton(true); //마커 선택 시 표시되는 말풍선의 오른쪽 버튼을 설정한다.item32.showRightButton(); //마커 선택 시 표시되는 말풍선의 오른쪽 버튼 설정 여부를 반환한다.
        final  NMapPOIitem item65 = poiData.addPOIitem(127.105242,37.845633,  "회암사지", markerId, 0); //POI아이템 설정
        final  NMapPOIitem item66 = poiData.addPOIitem(126.988141,37.571806, "경천사지 10층석탑", markerId, 0); //POI아이템 설정
        final  NMapPOIitem item67= poiData.addPOIitem(126.981643,37.523061, "홍제동 5층석탑", markerId, 0); //POI아이템 설정

        final   NMapPOIitem item68 = poiData.addPOIitem( 126.856580,37.768696, "윤관장군 묘", markerId, 0); //POI아이템 설정

        final   NMapPOIitem item69 = poiData.addPOIitem(126.885908,37.701534, "최영장군 묘", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item70 = poiData.addPOIitem(127.840045 , 37.132716, "충주 청룡사지 보각국사탑", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item71 = poiData.addPOIitem(127.833674  , 36.542648, "법주사", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item72 = poiData.addPOIitem(126.597864, 33.529359, "불탑사 5층 석탑", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item73 = poiData.addPOIitem(126.431664,34.640587,  "해남잔산리 청자요지", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item74 = poiData.addPOIitem( 126.715656,35.032342, "나주 금성관", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item75 = poiData.addPOIitem(126.982701,35.185581,   "개선사지 석등", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item76 = poiData.addPOIitem( 126.992428 , 35.320777,  "객사리 석당간", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item77 = poiData.addPOIitem(128.104526 , 35.805769, "청량사 석조가여래좌상", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item78 = poiData.addPOIitem(128.705579 , 36.606646,   " 마애여래입상", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item79 = poiData.addPOIitem(127.966970 , 35.722526,  "둔마리 고분 벽화", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item80 = poiData.addPOIitem(129.227724 , 35.834008, "백률사 금동약사여래입상", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item81 = poiData.addPOIitem(129.255786 , 35.826614, "경주 보문사지", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item82 = poiData.addPOIitem(129.232190 , 35.838141,  "경주 황룡사지", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item83 = poiData.addPOIitem(129.349669 , 35.795387, "석굴암", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item84 = poiData.addPOIitem(129.332103 , 35.790376, "불국사 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item85 = poiData.addPOIitem(128.230445 , 37.148015, "제천 모전7층 석탑", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item86 = poiData.addPOIitem(128.485006 , 37.057809,  "온달산성", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item87 = poiData.addPOIitem(128.321616 , 36.945187, "단양적성비", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item88 = poiData.addPOIitem(128.331644  , 36.969317, " 수양개 선사유적", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item89 = poiData.addPOIitem(127.793386 , 37.193596, "거돈사원공국사승표탑비", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item90 = poiData.addPOIitem(127.764720 , 37.207943, "흥법사지 3층석탑", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item91 = poiData.addPOIitem(127.764720 , 37.207943, "법천사지", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item92 = poiData.addPOIitem(128.797082 , 37.763460,  "명주군왕릉", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item93 = poiData.addPOIitem(128.545144 , 38.123124,  "진전사 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item94 = poiData.addPOIitem(128.628013 , 38.124835,  "낙산사", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item95 = poiData.addPOIitem(128.516593 , 37.945115, "선림원지", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item96 = poiData.addPOIitem(129.266377 , 37.326237,  "공양왕릉", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item97 = poiData.addPOIitem(128.128359  , 37.770653, "홍천 물걸리 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item98 = poiData.addPOIitem(128.592026  , 37.731846, "평창 월정사 팔각구층석탑", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item99 = poiData.addPOIitem(126.859741 , 36.417610, "장곡사", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item100 = poiData.addPOIitem(126.656399 , 37.558400, "녹청자박물관", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item101 = poiData.addPOIitem(129.219117 ,35.834961,  "첨성대 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item102 = poiData.addPOIitem(128.687427  , 36.999155, " 영주 부석사", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item103 = poiData.addPOIitem(128.098034  , 35.801439, "해인사", markerId, 0); //POI아이템 설정







//고대
        final  NMapPOIitem item104 = poiData.addPOIitem(127.061425,38.015662, "연천전곡리 유적", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item105 = poiData.addPOIitem(126.842476,37.991461, "경순왕릉", markerId, 0); //POI아이템 설정
        final  NMapPOIitem item106 = poiData.addPOIitem(127.130167,37.560760, "암사동 유적", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item107 = poiData.addPOIitem(127.103784,37.571747, "아차산 일대 보루군", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item108 = poiData.addPOIitem(127.120745, 37.522345,  "몽촌토성", markerId, 0); //POI아이템 설정item25.setRightAccessory(true, NMapPOIflagType.CLICKABLE_ARROW); //마커 선택 시 표시되는 말풍선의 오른쪽 아이콘을 설정한다.item25.hasRightAccessory(); //마커 선택 시 표시되는 말풍선의 오른쪽 아이콘 설정 여부를 반환한다.item25.setRightButton(true); //마커 선택 시 표시되는 말풍선의 오른쪽 버튼을 설정한다.item25.showRightButton(); //마커 선택 시 표시되는 말풍선의 오른쪽 버튼 설정 여부를 반환한다.
        final    NMapPOIitem item109 = poiData.addPOIitem(127.120936,37.539300,  "풍납토성", markerId, 0); //POI아이템 설정item26.setRightAccessory(true, NMapPOIflagType.CLICKABLE_ARROW); //마커 선택 시 표시되는 말풍선의 오른쪽 아이콘을 설정한다.item26.hasRightAccessory(); //마커 선택 시 표시되는 말풍선의 오른쪽 아이콘 설정 여부를 반환한다.item26.setRightButton(true); //마커 선택 시 표시되는 말풍선의 오른쪽 버튼을 설정한다.item26.showRightButton(); //마커 선택 시 표시되는 말풍선의 오른쪽 버튼 설정 여부를 반환한다.
        final   NMapPOIitem item110 = poiData.addPOIitem(127.102276,37.502811, "석촌동 고분군", markerId, 0); //POI아이템 설정item27.setRightAccessory(true, NMapPOIflagType.CLICKABLE_ARROW); //마커 선택 시 표시되는 말풍선의 오른쪽 아이콘을 설정한다.item27.hasRightAccessory(); //마커 선택 시 표시되는 말풍선의 오른쪽 아이콘 설정 여부를 반환한다.item27.setRightButton(true); //마커 선택 시 표시되는 말풍선의 오른쪽 버튼을 설정한다.item27.showRightButton(); //마커 선택 시 표시되는 말풍선의 오른쪽 버튼 설정 여부를 반환한다.
        final    NMapPOIitem item111 = poiData.addPOIitem(127.118802,37.508050, "방이동 고분군", markerId, 0); //POI아이템 설정item28.setRightAccessory(true, NMapPOIflagType.CLICKABLE_ARROW); //마커 선택 시 표시되는 말풍선의 오른쪽 아이콘을 설정한다.item28.hasRightAccessory(); //마커 선택 시 표시되는 말풍선의 오른쪽 아이콘 설정 여부를 반환한다.item28.setRightButton(true); //마커 선택 시 표시되는 말풍선의 오른쪽 버튼을 설정한다.item28.showRightButton(); //마커 선택 시 표시되는 말풍선의 오른쪽 버튼 설정 여부를 반환한다.
        final   NMapPOIitem item112 = poiData.addPOIitem(127.102918, 37.554709,  "아차산성", markerId, 0); //POI아이템 설정item29.setRightAccessory(true, NMapPOIflagType.CLICKABLE_ARROW); //마커 선택 시 표시되는 말풍선의 오른쪽 아이콘을 설정한다.item29.hasRightAccessory(); //마커 선택 시 표시되는 말풍선의 오른쪽 아이콘 설정 여부를 반환한다item29.setRightButton(true); //마커 선택 시 표시되는 말풍선의 오른쪽 버튼을 설정한다.item29.showRightButton(); //마커 선택 시 표시되는 말풍선의 오른쪽 버튼 설정 여부를 반환한다.
        final  NMapPOIitem item113 = poiData.addPOIitem(126.972575,37.631532, "승가사 석조승가대사좌상", markerId, 0); //POI아이템 설정item30.setRightAccessory(true, NMapPOIflagType.CLICKABLE_ARROW); //마커 선택 시 표시되는 말풍선의 오른쪽 아이콘을 설정한다.item30.hasRightAccessory(); //마커 선택 시 표시되는 말풍선의 오른쪽 아이콘 설정 여부를 반환한다.item30.setRightButton(true); //마커 선택 시 표시되는 말풍선의 오른쪽 버튼을 설정한다.item30.showRightButton(); //마커 선택 시 표시되는 말풍선의 오른쪽 버튼 설정 여부를 반환한다.
        final    NMapPOIitem item114 = poiData.addPOIitem(126.973209,37.647051, "북한산성 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item115 = poiData.addPOIitem(126.214170,41.145080,   "광개토대왕릉비 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item116 = poiData.addPOIitem(126.226271 ,41.157832,  "장군총 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item117 = poiData.addPOIitem(125.414998,41.329329,   "오녀산성 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item118 = poiData.addPOIitem(126.893872, 33.415392, "혼인지 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item119 = poiData.addPOIitem(126.587885,33.523356,  " 삼양동 선사 유적 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item120 = poiData.addPOIitem(126.529188,33.504608,    "삼성혈 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item121 = poiData.addPOIitem(135.851917, 34.598286,   "칠지도 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item122 = poiData.addPOIitem(127.497634,35.256766, "화엄사 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item123 = poiData.addPOIitem(127.588043 ,35.254982,  "연곡사 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item124 = poiData.addPOIitem(126.880008,34.925872,   "운주사 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item125 = poiData.addPOIitem(127.059336,34.887880,  "쌍봉사 철감선사탑 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item126 = poiData.addPOIitem(127.275927 ,35.002441,   "송광사 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item127 = poiData.addPOIitem(127.330445,34.996309,  "선암사 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item128 = poiData.addPOIitem(126.822922, 34.908672, "불회사 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item129 = poiData.addPOIitem(126.647003 ,34.912295,   "나주 대안리 고분군 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item130 = poiData.addPOIitem(128.737012 , 36.564305,   "법흥사지 7층 전탑 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item131 = poiData.addPOIitem(128.662491  , 36.653531,  "봉정사 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item132 = poiData.addPOIitem(129.227912 , 35.829625,   "임신서기석 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item133 = poiData.addPOIitem(129.210440  , 35.839014,   "천마총 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item134 = poiData.addPOIitem(129.320150 , 35.759991,   "원서왕릉 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item135 = poiData.addPOIitem(129.232618 , 35.853076,   "탈해왕릉 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item136 = poiData.addPOIitem(128.675599 , 36.274010, "경덕왕릉 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item137 = poiData.addPOIitem(129.250769 , 35.832707,  "진평왕릉 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item138 = poiData.addPOIitem(129.213531 , 35.836869,   "미추왕릉  ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item139 = poiData.addPOIitem(129.245340 , 35.843813,  "헌덕왕릉 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item140 = poiData.addPOIitem(129.207336 , 36.018273,  "흥덕왕릉 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item141 = poiData.addPOIitem(129.187741 , 35.825224,  "무열왕릉 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item142 = poiData.addPOIitem(129.218422  , 35.833327,  "내물왕릉 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item143 = poiData.addPOIitem(129.192138 , 35.847339,   "김유신 묘 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item144 = poiData.addPOIitem(129.477678 , 35.749860, "감은사지 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item145 = poiData.addPOIitem(129.274484 , 35.925173,   "회유토기요지  ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item146 = poiData.addPOIitem(129.227156 , 35.830175,  "선덕대왕신종  ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item147 = poiData.addPOIitem(129.262319 , 35.841890,  "명활성  ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item148 = poiData.addPOIitem(128.252614  , 35.724892,  "지산동 고분군 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item149 = poiData.addPOIitem(127.848462 , 37.028446,   "충주고구려비 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item150 = poiData.addPOIitem(128.219047 , 37.200994,  "점말동굴 유적 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item151 = poiData.addPOIitem(128.570746 , 38.191161,  "조양동 선사유적 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item152 = poiData.addPOIitem(127.710600  , 37.891224,   " 춘천 중도 적석총 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item153 = poiData.addPOIitem(128.660423 , 38.086192,   "오산리 유적 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item154 = poiData.addPOIitem(127.378250 , 36.361031,   "둔산선사유적지 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item155 = poiData.addPOIitem(126.917944 , 36.278516,   "금동대향로 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item156 = poiData.addPOIitem(126.917923  , 36.278498,   "사택지적비 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item157 = poiData.addPOIitem(127.112656 , 36.461104,    "무령왕릉 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item158 = poiData.addPOIitem(126.917976 , 36.278524,    "군수리 금동보살입상 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item159 = poiData.addPOIitem(126.914126 , 36.279193,  "정림사지  ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item160 = poiData.addPOIitem(126.914840 , 36.285039,     "부소산성 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item161 = poiData.addPOIitem(126.915211 , 36.284671,    "능산리 고분군  ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item162 = poiData.addPOIitem(126.693390 , 36.317417,   "무량사  ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item163 = poiData.addPOIitem(126.602733 , 36.761999,   "보원사 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item164 = poiData.addPOIitem(127.189739  , 36.454916,   "공주 석장리 유적 ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item165 = poiData.addPOIitem(127.012426  , 36.559239,   "마곡사  ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item166 = poiData.addPOIitem(127.112760 , 36.461698,    " 송산리 고분   ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item167 = poiData.addPOIitem(126.775583 , 36.592592,    "임존성  ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item168 = poiData.addPOIitem(129.306861 , 36.251437,  "보경사   ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item169 = poiData.addPOIitem(128.960246 , 35.661552,     "운문사     ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item170 = poiData.addPOIitem(128.005615 , 36.700560,   "봉암사   ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item171 = poiData.addPOIitem(128.270920  , 35.716154,    "고아리 고분 벽화   ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item172 = poiData.addPOIitem(129.178348 , 35.604166,    " 울주 반구대 암각화  ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item173 = poiData.addPOIitem(128.878391 , 35.235540,   "수로왕릉  ", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item174 = poiData.addPOIitem(127.030037 , 36.011016,    "미륵사지   ", markerId, 0); //POI아이템 설정


//근현대
        final   NMapPOIitem item175= poiData.addPOIitem(126.956082,37.574492, "서대문 형무소", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item176 = poiData.addPOIitem(126.891583, 37.126514, "3.1 운동 순국 유적", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item177 = poiData.addPOIitem(126.291161,33.203721,   "일제 진지동굴", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item178= poiData.addPOIitem(127.308561 , 36.760238,  "유관순 열사 유적지", markerId, 0); //POI아이템 설정
        final   NMapPOIitem item179= poiData.addPOIitem(126.652216  , 36.685527,  "윤봉길 의사 생터", markerId, 0); //POI아이템 설정



        poiData.endPOIdata(); //POI 아이템 추가를 종료한다.
        NMapPOIdataOverlay poiDataOverlay = mOverlayManager.createPOIdataOverlay(poiData, null); //POI 데이터를 인자로 전달하여 NMapPOIdataOverlay 객체를 생성한다.






        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {    //onclick 내부에선 item 생성
                // 같은 액티비티 수정 못함
                mMapView.setFocusable(true);
                item1.setVisibility(NMapOverlayItem.INVISIBLE);
                item2.setVisibility(NMapOverlayItem.INVISIBLE);
                item3.setVisibility(NMapOverlayItem.INVISIBLE);
                item4.setVisibility(NMapOverlayItem.INVISIBLE);
                item5.setVisibility(NMapOverlayItem.INVISIBLE);
                item6.setVisibility(NMapOverlayItem.INVISIBLE);
                item7.setVisibility(NMapOverlayItem.INVISIBLE);
                item8.setVisibility(NMapOverlayItem.INVISIBLE);
                item9.setVisibility(NMapOverlayItem.INVISIBLE);
                item10.setVisibility(NMapOverlayItem.INVISIBLE);
                item11.setVisibility(NMapOverlayItem.INVISIBLE);
                item12.setVisibility(NMapOverlayItem.INVISIBLE);
                item13.setVisibility(NMapOverlayItem.INVISIBLE);
                item14.setVisibility(NMapOverlayItem.INVISIBLE);
                item15.setVisibility(NMapOverlayItem.INVISIBLE);
                item16.setVisibility(NMapOverlayItem.INVISIBLE);
                item17.setVisibility(NMapOverlayItem.INVISIBLE);
                item18.setVisibility(NMapOverlayItem.INVISIBLE);
                item19.setVisibility(NMapOverlayItem.INVISIBLE);
                item20.setVisibility(NMapOverlayItem.INVISIBLE);
                item21.setVisibility(NMapOverlayItem.INVISIBLE);
                item22.setVisibility(NMapOverlayItem.INVISIBLE);
                item23.setVisibility(NMapOverlayItem.INVISIBLE);
                item24.setVisibility(NMapOverlayItem.INVISIBLE);
                item25.setVisibility(NMapOverlayItem.INVISIBLE);
                item26.setVisibility(NMapOverlayItem.INVISIBLE);
                item27.setVisibility(NMapOverlayItem.INVISIBLE);
                item28.setVisibility(NMapOverlayItem.INVISIBLE);
                item29.setVisibility(NMapOverlayItem.INVISIBLE);
                item30.setVisibility(NMapOverlayItem.INVISIBLE);
                item31.setVisibility(NMapOverlayItem.INVISIBLE);
                item32.setVisibility(NMapOverlayItem.INVISIBLE);
                item33.setVisibility(NMapOverlayItem.INVISIBLE);
                item34.setVisibility(NMapOverlayItem.INVISIBLE);
                item35.setVisibility(NMapOverlayItem.INVISIBLE);
                item36.setVisibility(NMapOverlayItem.INVISIBLE);
                item37.setVisibility(NMapOverlayItem.INVISIBLE);
                item38.setVisibility(NMapOverlayItem.INVISIBLE);
                item39.setVisibility(NMapOverlayItem.INVISIBLE);
                item40.setVisibility(NMapOverlayItem.INVISIBLE);
                item41.setVisibility(NMapOverlayItem.INVISIBLE);
                item42.setVisibility(NMapOverlayItem.INVISIBLE);
                item43.setVisibility(NMapOverlayItem.INVISIBLE);
                item44.setVisibility(NMapOverlayItem.INVISIBLE);
                item45.setVisibility(NMapOverlayItem.INVISIBLE);
                item46.setVisibility(NMapOverlayItem.INVISIBLE);
                item47.setVisibility(NMapOverlayItem.INVISIBLE);
                item48.setVisibility(NMapOverlayItem.INVISIBLE);
                item49.setVisibility(NMapOverlayItem.INVISIBLE);
                item50.setVisibility(NMapOverlayItem.INVISIBLE);
                item51.setVisibility(NMapOverlayItem.INVISIBLE);
                item52.setVisibility(NMapOverlayItem.INVISIBLE);
                item53.setVisibility(NMapOverlayItem.INVISIBLE);
                item54.setVisibility(NMapOverlayItem.INVISIBLE);
                item55.setVisibility(NMapOverlayItem.INVISIBLE);
                item56.setVisibility(NMapOverlayItem.INVISIBLE);
                item57.setVisibility(NMapOverlayItem.INVISIBLE);
                item58.setVisibility(NMapOverlayItem.INVISIBLE);
                item59.setVisibility(NMapOverlayItem.INVISIBLE);
                item60.setVisibility(NMapOverlayItem.INVISIBLE);
                item61.setVisibility(NMapOverlayItem.INVISIBLE);
                item62.setVisibility(NMapOverlayItem.INVISIBLE);
                item63.setVisibility(NMapOverlayItem.INVISIBLE);
                item64.setVisibility(NMapOverlayItem.INVISIBLE);
                item65.setVisibility(NMapOverlayItem.INVISIBLE);
                item66.setVisibility(NMapOverlayItem.INVISIBLE);
                item67.setVisibility(NMapOverlayItem.INVISIBLE);
                item68.setVisibility(NMapOverlayItem.INVISIBLE);
                item69.setVisibility(NMapOverlayItem.INVISIBLE);
                item70.setVisibility(NMapOverlayItem.INVISIBLE);
                item71.setVisibility(NMapOverlayItem.INVISIBLE);
                item72.setVisibility(NMapOverlayItem.INVISIBLE);
                item73.setVisibility(NMapOverlayItem.INVISIBLE);
                item74.setVisibility(NMapOverlayItem.INVISIBLE);
                item75.setVisibility(NMapOverlayItem.INVISIBLE);
                item76.setVisibility(NMapOverlayItem.INVISIBLE);
                item77.setVisibility(NMapOverlayItem.INVISIBLE);
                item78.setVisibility(NMapOverlayItem.INVISIBLE);
                item79.setVisibility(NMapOverlayItem.INVISIBLE);
                item80.setVisibility(NMapOverlayItem.INVISIBLE);
                item81.setVisibility(NMapOverlayItem.INVISIBLE);
                item82.setVisibility(NMapOverlayItem.INVISIBLE);
                item83.setVisibility(NMapOverlayItem.INVISIBLE);
                item84.setVisibility(NMapOverlayItem.INVISIBLE);
                item85.setVisibility(NMapOverlayItem.INVISIBLE);
                item86.setVisibility(NMapOverlayItem.INVISIBLE);
                item87.setVisibility(NMapOverlayItem.INVISIBLE);
                item88.setVisibility(NMapOverlayItem.INVISIBLE);
                item89.setVisibility(NMapOverlayItem.INVISIBLE);
                item90.setVisibility(NMapOverlayItem.INVISIBLE);
                item91.setVisibility(NMapOverlayItem.INVISIBLE);
                item92.setVisibility(NMapOverlayItem.INVISIBLE);
                item93.setVisibility(NMapOverlayItem.INVISIBLE);
                item94.setVisibility(NMapOverlayItem.INVISIBLE);
                item95.setVisibility(NMapOverlayItem.INVISIBLE);
                item96.setVisibility(NMapOverlayItem.INVISIBLE);
                item97.setVisibility(NMapOverlayItem.INVISIBLE);
                item98.setVisibility(NMapOverlayItem.INVISIBLE);
                item99.setVisibility(NMapOverlayItem.INVISIBLE);
                item100.setVisibility(NMapOverlayItem.INVISIBLE);
                item101.setVisibility(NMapOverlayItem.INVISIBLE);
                item102.setVisibility(NMapOverlayItem.INVISIBLE);
                item103.setVisibility(NMapOverlayItem.INVISIBLE);
                item104.setVisibility(NMapOverlayItem.VISIBLE);
                item105.setVisibility(NMapOverlayItem.VISIBLE);
                item106.setVisibility(NMapOverlayItem.VISIBLE);
                item107.setVisibility(NMapOverlayItem.VISIBLE);
                item108.setVisibility(NMapOverlayItem.VISIBLE);
                item109.setVisibility(NMapOverlayItem.VISIBLE);
                item110.setVisibility(NMapOverlayItem.VISIBLE);
                item111.setVisibility(NMapOverlayItem.VISIBLE);
                item112.setVisibility(NMapOverlayItem.VISIBLE);
                item113.setVisibility(NMapOverlayItem.VISIBLE);
                item114.setVisibility(NMapOverlayItem.VISIBLE);
                item115.setVisibility(NMapOverlayItem.VISIBLE);
                item116.setVisibility(NMapOverlayItem.VISIBLE);
                item117.setVisibility(NMapOverlayItem.VISIBLE);
                item118.setVisibility(NMapOverlayItem.VISIBLE);
                item119.setVisibility(NMapOverlayItem.VISIBLE);
                item120.setVisibility(NMapOverlayItem.VISIBLE);
                item121.setVisibility(NMapOverlayItem.VISIBLE);
                item122.setVisibility(NMapOverlayItem.VISIBLE);
                item123.setVisibility(NMapOverlayItem.VISIBLE);
                item124.setVisibility(NMapOverlayItem.VISIBLE);
                item125.setVisibility(NMapOverlayItem.VISIBLE);
                item126.setVisibility(NMapOverlayItem.VISIBLE);
                item127.setVisibility(NMapOverlayItem.VISIBLE);
                item128.setVisibility(NMapOverlayItem.VISIBLE);
                item129.setVisibility(NMapOverlayItem.VISIBLE);
                item130.setVisibility(NMapOverlayItem.VISIBLE);
                item131.setVisibility(NMapOverlayItem.VISIBLE);
                item132.setVisibility(NMapOverlayItem.VISIBLE);
                item133.setVisibility(NMapOverlayItem.VISIBLE);
                item134.setVisibility(NMapOverlayItem.VISIBLE);
                item135.setVisibility(NMapOverlayItem.VISIBLE);
                item136.setVisibility(NMapOverlayItem.VISIBLE);
                item137.setVisibility(NMapOverlayItem.VISIBLE);
                item138.setVisibility(NMapOverlayItem.VISIBLE);
                item139.setVisibility(NMapOverlayItem.VISIBLE);
                item140.setVisibility(NMapOverlayItem.VISIBLE);
                item141.setVisibility(NMapOverlayItem.VISIBLE);
                item142.setVisibility(NMapOverlayItem.VISIBLE);
                item143.setVisibility(NMapOverlayItem.VISIBLE);
                item144.setVisibility(NMapOverlayItem.VISIBLE);
                item145.setVisibility(NMapOverlayItem.VISIBLE);
                item146.setVisibility(NMapOverlayItem.VISIBLE);
                item147.setVisibility(NMapOverlayItem.VISIBLE);
                item148.setVisibility(NMapOverlayItem.VISIBLE);
                item149.setVisibility(NMapOverlayItem.VISIBLE);
                item150.setVisibility(NMapOverlayItem.VISIBLE);
                item151.setVisibility(NMapOverlayItem.VISIBLE);
                item152.setVisibility(NMapOverlayItem.VISIBLE);
                item153.setVisibility(NMapOverlayItem.VISIBLE);
                item154.setVisibility(NMapOverlayItem.VISIBLE);
                item155.setVisibility(NMapOverlayItem.VISIBLE);
                item156.setVisibility(NMapOverlayItem.VISIBLE);
                item157.setVisibility(NMapOverlayItem.VISIBLE);
                item158.setVisibility(NMapOverlayItem.VISIBLE);
                item159.setVisibility(NMapOverlayItem.VISIBLE);
                item160.setVisibility(NMapOverlayItem.VISIBLE);
                item161.setVisibility(NMapOverlayItem.VISIBLE);
                item162.setVisibility(NMapOverlayItem.VISIBLE);
                item163.setVisibility(NMapOverlayItem.VISIBLE);
                item164.setVisibility(NMapOverlayItem.VISIBLE);
                item165.setVisibility(NMapOverlayItem.VISIBLE);
                item166.setVisibility(NMapOverlayItem.VISIBLE);
                item167.setVisibility(NMapOverlayItem.VISIBLE);
                item168.setVisibility(NMapOverlayItem.VISIBLE);
                item169.setVisibility(NMapOverlayItem.VISIBLE);
                item170.setVisibility(NMapOverlayItem.VISIBLE);
                item171.setVisibility(NMapOverlayItem.VISIBLE);
                item172.setVisibility(NMapOverlayItem.VISIBLE);
                item173.setVisibility(NMapOverlayItem.VISIBLE);
                item174.setVisibility(NMapOverlayItem.VISIBLE);
                item175.setVisibility(NMapOverlayItem.INVISIBLE);
                item176.setVisibility(NMapOverlayItem.INVISIBLE);
                item177.setVisibility(NMapOverlayItem.INVISIBLE);
                item178.setVisibility(NMapOverlayItem.INVISIBLE);
                item179.setVisibility(NMapOverlayItem.INVISIBLE);
                mMapView.invalidate();

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {    //onclick 내부에선 item 생성
                // 같은 액티비티 수정 못함
                mMapView.setFocusable(true);
                item1.setVisibility(NMapOverlayItem.INVISIBLE);
                item2.setVisibility(NMapOverlayItem.INVISIBLE);
                item3.setVisibility(NMapOverlayItem.INVISIBLE);
                item4.setVisibility(NMapOverlayItem.INVISIBLE);
                item5.setVisibility(NMapOverlayItem.INVISIBLE);
                item6.setVisibility(NMapOverlayItem.INVISIBLE);
                item7.setVisibility(NMapOverlayItem.INVISIBLE);
                item8.setVisibility(NMapOverlayItem.INVISIBLE);
                item9.setVisibility(NMapOverlayItem.INVISIBLE);
                item10.setVisibility(NMapOverlayItem.INVISIBLE);
                item11.setVisibility(NMapOverlayItem.INVISIBLE);
                item12.setVisibility(NMapOverlayItem.INVISIBLE);
                item13.setVisibility(NMapOverlayItem.INVISIBLE);
                item14.setVisibility(NMapOverlayItem.INVISIBLE);
                item15.setVisibility(NMapOverlayItem.INVISIBLE);
                item16.setVisibility(NMapOverlayItem.INVISIBLE);
                item18.setVisibility(NMapOverlayItem.INVISIBLE);
                item19.setVisibility(NMapOverlayItem.INVISIBLE);
                item20.setVisibility(NMapOverlayItem.INVISIBLE);
                item21.setVisibility(NMapOverlayItem.INVISIBLE);
                item22.setVisibility(NMapOverlayItem.INVISIBLE);
                item23.setVisibility(NMapOverlayItem.INVISIBLE);
                item24.setVisibility(NMapOverlayItem.INVISIBLE);
                item25.setVisibility(NMapOverlayItem.INVISIBLE);
                item26.setVisibility(NMapOverlayItem.INVISIBLE);
                item27.setVisibility(NMapOverlayItem.INVISIBLE);
                item28.setVisibility(NMapOverlayItem.INVISIBLE);
                item29.setVisibility(NMapOverlayItem.INVISIBLE);
                item30.setVisibility(NMapOverlayItem.INVISIBLE);
                item31.setVisibility(NMapOverlayItem.INVISIBLE);
                item32.setVisibility(NMapOverlayItem.INVISIBLE);
                item33.setVisibility(NMapOverlayItem.INVISIBLE);
                item34.setVisibility(NMapOverlayItem.INVISIBLE);
                item35.setVisibility(NMapOverlayItem.INVISIBLE);
                item36.setVisibility(NMapOverlayItem.INVISIBLE);
                item37.setVisibility(NMapOverlayItem.INVISIBLE);
                item38.setVisibility(NMapOverlayItem.INVISIBLE);
                item39.setVisibility(NMapOverlayItem.INVISIBLE);
                item40.setVisibility(NMapOverlayItem.INVISIBLE);
                item41.setVisibility(NMapOverlayItem.INVISIBLE);
                item42.setVisibility(NMapOverlayItem.INVISIBLE);
                item43.setVisibility(NMapOverlayItem.INVISIBLE);
                item44.setVisibility(NMapOverlayItem.INVISIBLE);
                item45.setVisibility(NMapOverlayItem.INVISIBLE);
                item46.setVisibility(NMapOverlayItem.INVISIBLE);
                item47.setVisibility(NMapOverlayItem.INVISIBLE);
                item48.setVisibility(NMapOverlayItem.INVISIBLE);
                item49.setVisibility(NMapOverlayItem.INVISIBLE);
                item50.setVisibility(NMapOverlayItem.INVISIBLE);
                item51.setVisibility(NMapOverlayItem.INVISIBLE);
                item52.setVisibility(NMapOverlayItem.INVISIBLE);
                item53.setVisibility(NMapOverlayItem.INVISIBLE);
                item54.setVisibility(NMapOverlayItem.INVISIBLE);
                item55.setVisibility(NMapOverlayItem.INVISIBLE);
                item56.setVisibility(NMapOverlayItem.INVISIBLE);
                item57.setVisibility(NMapOverlayItem.INVISIBLE);
                item58.setVisibility(NMapOverlayItem.INVISIBLE);
                item59.setVisibility(NMapOverlayItem.INVISIBLE);
                item60.setVisibility(NMapOverlayItem.INVISIBLE);
                item61.setVisibility(NMapOverlayItem.INVISIBLE);
                item62.setVisibility(NMapOverlayItem.INVISIBLE);
                item63.setVisibility(NMapOverlayItem.VISIBLE);
                item64.setVisibility(NMapOverlayItem.VISIBLE);
                item65.setVisibility(NMapOverlayItem.VISIBLE);
                item66.setVisibility(NMapOverlayItem.VISIBLE);
                item67.setVisibility(NMapOverlayItem.VISIBLE);
                item68.setVisibility(NMapOverlayItem.VISIBLE);
                item69.setVisibility(NMapOverlayItem.VISIBLE);
                item70.setVisibility(NMapOverlayItem.VISIBLE);
                item71.setVisibility(NMapOverlayItem.VISIBLE);
                item72.setVisibility(NMapOverlayItem.VISIBLE);
                item73.setVisibility(NMapOverlayItem.VISIBLE);
                item74.setVisibility(NMapOverlayItem.VISIBLE);
                item75.setVisibility(NMapOverlayItem.VISIBLE);
                item76.setVisibility(NMapOverlayItem.VISIBLE);
                item77.setVisibility(NMapOverlayItem.VISIBLE);
                item78.setVisibility(NMapOverlayItem.VISIBLE);
                item79.setVisibility(NMapOverlayItem.VISIBLE);
                item80.setVisibility(NMapOverlayItem.VISIBLE);
                item81.setVisibility(NMapOverlayItem.VISIBLE);
                item82.setVisibility(NMapOverlayItem.VISIBLE);
                item83.setVisibility(NMapOverlayItem.VISIBLE);
                item84.setVisibility(NMapOverlayItem.VISIBLE);
                item85.setVisibility(NMapOverlayItem.VISIBLE);
                item86.setVisibility(NMapOverlayItem.VISIBLE);
                item87.setVisibility(NMapOverlayItem.VISIBLE);
                item88.setVisibility(NMapOverlayItem.VISIBLE);
                item89.setVisibility(NMapOverlayItem.VISIBLE);
                item90.setVisibility(NMapOverlayItem.VISIBLE);
                item91.setVisibility(NMapOverlayItem.VISIBLE);
                item92.setVisibility(NMapOverlayItem.VISIBLE);
                item93.setVisibility(NMapOverlayItem.VISIBLE);
                item94.setVisibility(NMapOverlayItem.VISIBLE);
                item95.setVisibility(NMapOverlayItem.VISIBLE);
                item96.setVisibility(NMapOverlayItem.VISIBLE);
                item97.setVisibility(NMapOverlayItem.VISIBLE);
                item98.setVisibility(NMapOverlayItem.VISIBLE);
                item99.setVisibility(NMapOverlayItem.VISIBLE);
                item100.setVisibility(NMapOverlayItem.VISIBLE);
                item101.setVisibility(NMapOverlayItem.VISIBLE);
                item102.setVisibility(NMapOverlayItem.VISIBLE);
                item103.setVisibility(NMapOverlayItem.VISIBLE);
                item104.setVisibility(NMapOverlayItem.INVISIBLE);
                item105.setVisibility(NMapOverlayItem.INVISIBLE);
                item106.setVisibility(NMapOverlayItem.INVISIBLE);
                item107.setVisibility(NMapOverlayItem.INVISIBLE);
                item108.setVisibility(NMapOverlayItem.INVISIBLE);
                item109.setVisibility(NMapOverlayItem.INVISIBLE);
                item110.setVisibility(NMapOverlayItem.INVISIBLE);
                item111.setVisibility(NMapOverlayItem.INVISIBLE);
                item112.setVisibility(NMapOverlayItem.INVISIBLE);
                item113.setVisibility(NMapOverlayItem.INVISIBLE);
                item114.setVisibility(NMapOverlayItem.INVISIBLE);
                item115.setVisibility(NMapOverlayItem.INVISIBLE);
                item116.setVisibility(NMapOverlayItem.INVISIBLE);
                item117.setVisibility(NMapOverlayItem.INVISIBLE);
                item118.setVisibility(NMapOverlayItem.INVISIBLE);
                item119.setVisibility(NMapOverlayItem.INVISIBLE);
                item120.setVisibility(NMapOverlayItem.INVISIBLE);
                item121.setVisibility(NMapOverlayItem.INVISIBLE);
                item122.setVisibility(NMapOverlayItem.INVISIBLE);
                item123.setVisibility(NMapOverlayItem.INVISIBLE);
                item124.setVisibility(NMapOverlayItem.INVISIBLE);
                item125.setVisibility(NMapOverlayItem.INVISIBLE);
                item126.setVisibility(NMapOverlayItem.INVISIBLE);
                item127.setVisibility(NMapOverlayItem.INVISIBLE);
                item128.setVisibility(NMapOverlayItem.INVISIBLE);
                item129.setVisibility(NMapOverlayItem.INVISIBLE);
                item130.setVisibility(NMapOverlayItem.INVISIBLE);
                item131.setVisibility(NMapOverlayItem.INVISIBLE);
                item132.setVisibility(NMapOverlayItem.INVISIBLE);
                item133.setVisibility(NMapOverlayItem.INVISIBLE);
                item134.setVisibility(NMapOverlayItem.INVISIBLE);
                item135.setVisibility(NMapOverlayItem.INVISIBLE);
                item136.setVisibility(NMapOverlayItem.INVISIBLE);
                item137.setVisibility(NMapOverlayItem.INVISIBLE);
                item138.setVisibility(NMapOverlayItem.INVISIBLE);
                item139.setVisibility(NMapOverlayItem.INVISIBLE);
                item140.setVisibility(NMapOverlayItem.INVISIBLE);
                item141.setVisibility(NMapOverlayItem.INVISIBLE);
                item142.setVisibility(NMapOverlayItem.INVISIBLE);
                item143.setVisibility(NMapOverlayItem.INVISIBLE);
                item144.setVisibility(NMapOverlayItem.INVISIBLE);
                item145.setVisibility(NMapOverlayItem.INVISIBLE);
                item146.setVisibility(NMapOverlayItem.INVISIBLE);
                item147.setVisibility(NMapOverlayItem.INVISIBLE);
                item148.setVisibility(NMapOverlayItem.INVISIBLE);
                item149.setVisibility(NMapOverlayItem.INVISIBLE);
                item150.setVisibility(NMapOverlayItem.INVISIBLE);
                item151.setVisibility(NMapOverlayItem.INVISIBLE);
                item152.setVisibility(NMapOverlayItem.INVISIBLE);
                item153.setVisibility(NMapOverlayItem.INVISIBLE);
                item154.setVisibility(NMapOverlayItem.INVISIBLE);
                item155.setVisibility(NMapOverlayItem.INVISIBLE);
                item156.setVisibility(NMapOverlayItem.INVISIBLE);
                item157.setVisibility(NMapOverlayItem.INVISIBLE);
                item158.setVisibility(NMapOverlayItem.INVISIBLE);
                item159.setVisibility(NMapOverlayItem.INVISIBLE);
                item160.setVisibility(NMapOverlayItem.INVISIBLE);
                item161.setVisibility(NMapOverlayItem.INVISIBLE);
                item162.setVisibility(NMapOverlayItem.INVISIBLE);
                item163.setVisibility(NMapOverlayItem.INVISIBLE);
                item164.setVisibility(NMapOverlayItem.INVISIBLE);
                item165.setVisibility(NMapOverlayItem.INVISIBLE);
                item166.setVisibility(NMapOverlayItem.INVISIBLE);
                item167.setVisibility(NMapOverlayItem.INVISIBLE);
                item168.setVisibility(NMapOverlayItem.INVISIBLE);
                item169.setVisibility(NMapOverlayItem.INVISIBLE);
                item170.setVisibility(NMapOverlayItem.INVISIBLE);
                item171.setVisibility(NMapOverlayItem.INVISIBLE);
                item172.setVisibility(NMapOverlayItem.INVISIBLE);
                item173.setVisibility(NMapOverlayItem.INVISIBLE);
                item174.setVisibility(NMapOverlayItem.INVISIBLE);
                item175.setVisibility(NMapOverlayItem.INVISIBLE);
                item176.setVisibility(NMapOverlayItem.INVISIBLE);
                item177.setVisibility(NMapOverlayItem.INVISIBLE);
                item178.setVisibility(NMapOverlayItem.INVISIBLE);
                item179.setVisibility(NMapOverlayItem.INVISIBLE);

                mMapView.invalidate();

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {    //onclick 내부에선 item 생성
                // 같은 액티비티 수정 못함
                mMapView.setFocusable(true);
                item1.setVisibility(NMapOverlayItem.VISIBLE);item2.setVisibility(NMapOverlayItem.VISIBLE);item3.setVisibility(NMapOverlayItem.VISIBLE);item4.setVisibility(NMapOverlayItem.VISIBLE);item5.setVisibility(NMapOverlayItem.VISIBLE);item6.setVisibility(NMapOverlayItem.VISIBLE);item7.setVisibility(NMapOverlayItem.VISIBLE);item8.setVisibility(NMapOverlayItem.VISIBLE);item9.setVisibility(NMapOverlayItem.VISIBLE);item10.setVisibility(NMapOverlayItem.VISIBLE);item11.setVisibility(NMapOverlayItem.VISIBLE);item12.setVisibility(NMapOverlayItem.VISIBLE);item13.setVisibility(NMapOverlayItem.VISIBLE);item14.setVisibility(NMapOverlayItem.VISIBLE);item15.setVisibility(NMapOverlayItem.VISIBLE);item16.setVisibility(NMapOverlayItem.VISIBLE);
                item17.setVisibility(NMapOverlayItem.VISIBLE);item18.setVisibility(NMapOverlayItem.VISIBLE);item19.setVisibility(NMapOverlayItem.VISIBLE);item20.setVisibility(NMapOverlayItem.VISIBLE);item21.setVisibility(NMapOverlayItem.VISIBLE);item22.setVisibility(NMapOverlayItem.VISIBLE);item23.setVisibility(NMapOverlayItem.VISIBLE);item24.setVisibility(NMapOverlayItem.VISIBLE);item25.setVisibility(NMapOverlayItem.VISIBLE);item26.setVisibility(NMapOverlayItem.VISIBLE);item27.setVisibility(NMapOverlayItem.VISIBLE);item28.setVisibility(NMapOverlayItem.VISIBLE);
                item29.setVisibility(NMapOverlayItem.VISIBLE);item30.setVisibility(NMapOverlayItem.VISIBLE);item31.setVisibility(NMapOverlayItem.VISIBLE);item32.setVisibility(NMapOverlayItem.VISIBLE);item33.setVisibility(NMapOverlayItem.VISIBLE);item34.setVisibility(NMapOverlayItem.VISIBLE);item35.setVisibility(NMapOverlayItem.VISIBLE);item36.setVisibility(NMapOverlayItem.VISIBLE);item37.setVisibility(NMapOverlayItem.VISIBLE);item38.setVisibility(NMapOverlayItem.VISIBLE);item39.setVisibility(NMapOverlayItem.VISIBLE);item40.setVisibility(NMapOverlayItem.VISIBLE);item41.setVisibility(NMapOverlayItem.VISIBLE);item42.setVisibility(NMapOverlayItem.VISIBLE);item43.setVisibility(NMapOverlayItem.VISIBLE);item44.setVisibility(NMapOverlayItem.VISIBLE);item45.setVisibility(NMapOverlayItem.VISIBLE);item46.setVisibility(NMapOverlayItem.VISIBLE);item47.setVisibility(NMapOverlayItem.VISIBLE);item48.setVisibility(NMapOverlayItem.VISIBLE);item49.setVisibility(NMapOverlayItem.VISIBLE);item50.setVisibility(NMapOverlayItem.VISIBLE);item51.setVisibility(NMapOverlayItem.VISIBLE);item52.setVisibility(NMapOverlayItem.VISIBLE);item53.setVisibility(NMapOverlayItem.VISIBLE);item54.setVisibility(NMapOverlayItem.VISIBLE);item55.setVisibility(NMapOverlayItem.VISIBLE);item56.setVisibility(NMapOverlayItem.VISIBLE);item57.setVisibility(NMapOverlayItem.VISIBLE);item58.setVisibility(NMapOverlayItem.VISIBLE);item59.setVisibility(NMapOverlayItem.VISIBLE);item60.setVisibility(NMapOverlayItem.VISIBLE);item61.setVisibility(NMapOverlayItem.VISIBLE);item62.setVisibility(NMapOverlayItem.VISIBLE);item63.setVisibility(NMapOverlayItem.INVISIBLE);item64.setVisibility(NMapOverlayItem.INVISIBLE);item65.setVisibility(NMapOverlayItem.INVISIBLE);item66.setVisibility(NMapOverlayItem.INVISIBLE);item67.setVisibility(NMapOverlayItem.INVISIBLE);item68.setVisibility(NMapOverlayItem.INVISIBLE);item69.setVisibility(NMapOverlayItem.INVISIBLE);item70.setVisibility(NMapOverlayItem.INVISIBLE);item71.setVisibility(NMapOverlayItem.INVISIBLE);item72.setVisibility(NMapOverlayItem.INVISIBLE);item73.setVisibility(NMapOverlayItem.INVISIBLE);item74.setVisibility(NMapOverlayItem.INVISIBLE);item75.setVisibility(NMapOverlayItem.INVISIBLE);item76.setVisibility(NMapOverlayItem.INVISIBLE);item77.setVisibility(NMapOverlayItem.INVISIBLE);item78.setVisibility(NMapOverlayItem.INVISIBLE);item79.setVisibility(NMapOverlayItem.INVISIBLE);item80.setVisibility(NMapOverlayItem.INVISIBLE);item81.setVisibility(NMapOverlayItem.INVISIBLE);item82.setVisibility(NMapOverlayItem.INVISIBLE);item83.setVisibility(NMapOverlayItem.INVISIBLE);item84.setVisibility(NMapOverlayItem.INVISIBLE);item85.setVisibility(NMapOverlayItem.INVISIBLE);item86.setVisibility(NMapOverlayItem.INVISIBLE);item87.setVisibility(NMapOverlayItem.INVISIBLE);item88.setVisibility(NMapOverlayItem.INVISIBLE);item89.setVisibility(NMapOverlayItem.INVISIBLE);item90.setVisibility(NMapOverlayItem.INVISIBLE);item91.setVisibility(NMapOverlayItem.INVISIBLE);item92.setVisibility(NMapOverlayItem.INVISIBLE);item93.setVisibility(NMapOverlayItem.INVISIBLE);item94.setVisibility(NMapOverlayItem.INVISIBLE);item95.setVisibility(NMapOverlayItem.INVISIBLE);item96.setVisibility(NMapOverlayItem.INVISIBLE);item97.setVisibility(NMapOverlayItem.INVISIBLE);item98.setVisibility(NMapOverlayItem.INVISIBLE);item99.setVisibility(NMapOverlayItem.INVISIBLE);item100.setVisibility(NMapOverlayItem.INVISIBLE);item101.setVisibility(NMapOverlayItem.INVISIBLE);item102.setVisibility(NMapOverlayItem.INVISIBLE);item103.setVisibility(NMapOverlayItem.INVISIBLE);item104.setVisibility(NMapOverlayItem.INVISIBLE);item105.setVisibility(NMapOverlayItem.INVISIBLE);item106.setVisibility(NMapOverlayItem.INVISIBLE);item107.setVisibility(NMapOverlayItem.INVISIBLE);item108.setVisibility(NMapOverlayItem.INVISIBLE);item109.setVisibility(NMapOverlayItem.INVISIBLE);item110.setVisibility(NMapOverlayItem.INVISIBLE);item111.setVisibility(NMapOverlayItem.INVISIBLE);item112.setVisibility(NMapOverlayItem.INVISIBLE);item113.setVisibility(NMapOverlayItem.INVISIBLE);item114.setVisibility(NMapOverlayItem.INVISIBLE);item115.setVisibility(NMapOverlayItem.INVISIBLE);item116.setVisibility(NMapOverlayItem.INVISIBLE);item117.setVisibility(NMapOverlayItem.INVISIBLE);item118.setVisibility(NMapOverlayItem.INVISIBLE);item119.setVisibility(NMapOverlayItem.INVISIBLE);item120.setVisibility(NMapOverlayItem.INVISIBLE);item121.setVisibility(NMapOverlayItem.INVISIBLE);item122.setVisibility(NMapOverlayItem.INVISIBLE);item123.setVisibility(NMapOverlayItem.INVISIBLE);item124.setVisibility(NMapOverlayItem.INVISIBLE);item125.setVisibility(NMapOverlayItem.INVISIBLE);item126.setVisibility(NMapOverlayItem.INVISIBLE);item127.setVisibility(NMapOverlayItem.INVISIBLE);item128.setVisibility(NMapOverlayItem.INVISIBLE);item129.setVisibility(NMapOverlayItem.INVISIBLE);item130.setVisibility(NMapOverlayItem.INVISIBLE);item131.setVisibility(NMapOverlayItem.INVISIBLE);item132.setVisibility(NMapOverlayItem.INVISIBLE);item133.setVisibility(NMapOverlayItem.INVISIBLE);item134.setVisibility(NMapOverlayItem.INVISIBLE);item135.setVisibility(NMapOverlayItem.INVISIBLE);item136.setVisibility(NMapOverlayItem.INVISIBLE);item137.setVisibility(NMapOverlayItem.INVISIBLE);item138.setVisibility(NMapOverlayItem.INVISIBLE);item139.setVisibility(NMapOverlayItem.INVISIBLE);item140.setVisibility(NMapOverlayItem.INVISIBLE);item141.setVisibility(NMapOverlayItem.INVISIBLE);item142.setVisibility(NMapOverlayItem.INVISIBLE);item143.setVisibility(NMapOverlayItem.INVISIBLE);item144.setVisibility(NMapOverlayItem.INVISIBLE);item145.setVisibility(NMapOverlayItem.INVISIBLE);item146.setVisibility(NMapOverlayItem.INVISIBLE);item147.setVisibility(NMapOverlayItem.INVISIBLE);item148.setVisibility(NMapOverlayItem.INVISIBLE);item149.setVisibility(NMapOverlayItem.INVISIBLE);item150.setVisibility(NMapOverlayItem.INVISIBLE);item151.setVisibility(NMapOverlayItem.INVISIBLE);item152.setVisibility(NMapOverlayItem.INVISIBLE);item153.setVisibility(NMapOverlayItem.INVISIBLE);item154.setVisibility(NMapOverlayItem.INVISIBLE);item155.setVisibility(NMapOverlayItem.INVISIBLE);item156.setVisibility(NMapOverlayItem.INVISIBLE);item157.setVisibility(NMapOverlayItem.INVISIBLE);item158.setVisibility(NMapOverlayItem.INVISIBLE);item159.setVisibility(NMapOverlayItem.INVISIBLE);item160.setVisibility(NMapOverlayItem.INVISIBLE);item161.setVisibility(NMapOverlayItem.INVISIBLE);item162.setVisibility(NMapOverlayItem.INVISIBLE);item163.setVisibility(NMapOverlayItem.INVISIBLE);item164.setVisibility(NMapOverlayItem.INVISIBLE);item165.setVisibility(NMapOverlayItem.INVISIBLE);item166.setVisibility(NMapOverlayItem.INVISIBLE);item167.setVisibility(NMapOverlayItem.INVISIBLE);item168.setVisibility(NMapOverlayItem.INVISIBLE);item169.setVisibility(NMapOverlayItem.INVISIBLE);item170.setVisibility(NMapOverlayItem.INVISIBLE);item171.setVisibility(NMapOverlayItem.INVISIBLE);item172.setVisibility(NMapOverlayItem.INVISIBLE);item173.setVisibility(NMapOverlayItem.INVISIBLE);item174.setVisibility(NMapOverlayItem.INVISIBLE);item175.setVisibility(NMapOverlayItem.INVISIBLE);item176.setVisibility(NMapOverlayItem.INVISIBLE);item177.setVisibility(NMapOverlayItem.INVISIBLE);item178.setVisibility(NMapOverlayItem.INVISIBLE);item179.setVisibility(NMapOverlayItem.INVISIBLE);

                mMapView.invalidate();

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {    //onclick 내부에선 item 생성
                // 같은 액티비티 수정 못함
                mMapView.setFocusable(true);
                item1.setVisibility(NMapOverlayItem.INVISIBLE);item2.setVisibility(NMapOverlayItem.INVISIBLE);item3.setVisibility(NMapOverlayItem.INVISIBLE);item4.setVisibility(NMapOverlayItem.INVISIBLE);item5.setVisibility(NMapOverlayItem.INVISIBLE);item6.setVisibility(NMapOverlayItem.INVISIBLE);item7.setVisibility(NMapOverlayItem.INVISIBLE);item8.setVisibility(NMapOverlayItem.INVISIBLE);item9.setVisibility(NMapOverlayItem.INVISIBLE);item10.setVisibility(NMapOverlayItem.INVISIBLE);item11.setVisibility(NMapOverlayItem.INVISIBLE);item12.setVisibility(NMapOverlayItem.INVISIBLE);item13.setVisibility(NMapOverlayItem.INVISIBLE);item14.setVisibility(NMapOverlayItem.INVISIBLE);item15.setVisibility(NMapOverlayItem.INVISIBLE);item16.setVisibility(NMapOverlayItem.INVISIBLE);
                item17.setVisibility(NMapOverlayItem.INVISIBLE);item18.setVisibility(NMapOverlayItem.INVISIBLE);item19.setVisibility(NMapOverlayItem.INVISIBLE);item20.setVisibility(NMapOverlayItem.INVISIBLE);item21.setVisibility(NMapOverlayItem.INVISIBLE);item22.setVisibility(NMapOverlayItem.INVISIBLE);item23.setVisibility(NMapOverlayItem.INVISIBLE);item24.setVisibility(NMapOverlayItem.INVISIBLE);item25.setVisibility(NMapOverlayItem.INVISIBLE);item26.setVisibility(NMapOverlayItem.INVISIBLE);item27.setVisibility(NMapOverlayItem.INVISIBLE);item28.setVisibility(NMapOverlayItem.INVISIBLE);
                item29.setVisibility(NMapOverlayItem.INVISIBLE);item30.setVisibility(NMapOverlayItem.INVISIBLE);item31.setVisibility(NMapOverlayItem.INVISIBLE);item32.setVisibility(NMapOverlayItem.INVISIBLE);item33.setVisibility(NMapOverlayItem.INVISIBLE);item34.setVisibility(NMapOverlayItem.INVISIBLE);item35.setVisibility(NMapOverlayItem.INVISIBLE);item36.setVisibility(NMapOverlayItem.INVISIBLE);item37.setVisibility(NMapOverlayItem.INVISIBLE);item38.setVisibility(NMapOverlayItem.INVISIBLE);item39.setVisibility(NMapOverlayItem.INVISIBLE);item40.setVisibility(NMapOverlayItem.INVISIBLE);item41.setVisibility(NMapOverlayItem.INVISIBLE);item42.setVisibility(NMapOverlayItem.INVISIBLE);item43.setVisibility(NMapOverlayItem.INVISIBLE);item44.setVisibility(NMapOverlayItem.INVISIBLE);item45.setVisibility(NMapOverlayItem.INVISIBLE);item46.setVisibility(NMapOverlayItem.INVISIBLE);item47.setVisibility(NMapOverlayItem.INVISIBLE);item48.setVisibility(NMapOverlayItem.INVISIBLE);item49.setVisibility(NMapOverlayItem.INVISIBLE);item50.setVisibility(NMapOverlayItem.INVISIBLE);item51.setVisibility(NMapOverlayItem.INVISIBLE);item52.setVisibility(NMapOverlayItem.INVISIBLE);item53.setVisibility(NMapOverlayItem.INVISIBLE);item54.setVisibility(NMapOverlayItem.INVISIBLE);item55.setVisibility(NMapOverlayItem.INVISIBLE);item56.setVisibility(NMapOverlayItem.INVISIBLE);item57.setVisibility(NMapOverlayItem.INVISIBLE);item58.setVisibility(NMapOverlayItem.INVISIBLE);item59.setVisibility(NMapOverlayItem.INVISIBLE);item60.setVisibility(NMapOverlayItem.INVISIBLE);item61.setVisibility(NMapOverlayItem.INVISIBLE);item62.setVisibility(NMapOverlayItem.INVISIBLE);item63.setVisibility(NMapOverlayItem.INVISIBLE);item64.setVisibility(NMapOverlayItem.INVISIBLE);item65.setVisibility(NMapOverlayItem.INVISIBLE);item66.setVisibility(NMapOverlayItem.INVISIBLE);item67.setVisibility(NMapOverlayItem.INVISIBLE);item68.setVisibility(NMapOverlayItem.INVISIBLE);item69.setVisibility(NMapOverlayItem.INVISIBLE);item70.setVisibility(NMapOverlayItem.INVISIBLE);item71.setVisibility(NMapOverlayItem.INVISIBLE);item72.setVisibility(NMapOverlayItem.INVISIBLE);item73.setVisibility(NMapOverlayItem.INVISIBLE);item74.setVisibility(NMapOverlayItem.INVISIBLE);item75.setVisibility(NMapOverlayItem.INVISIBLE);item76.setVisibility(NMapOverlayItem.INVISIBLE);item77.setVisibility(NMapOverlayItem.INVISIBLE);item78.setVisibility(NMapOverlayItem.INVISIBLE);item79.setVisibility(NMapOverlayItem.INVISIBLE);item80.setVisibility(NMapOverlayItem.INVISIBLE);item81.setVisibility(NMapOverlayItem.INVISIBLE);item82.setVisibility(NMapOverlayItem.INVISIBLE);item83.setVisibility(NMapOverlayItem.INVISIBLE);item84.setVisibility(NMapOverlayItem.INVISIBLE);item85.setVisibility(NMapOverlayItem.INVISIBLE);item86.setVisibility(NMapOverlayItem.INVISIBLE);item87.setVisibility(NMapOverlayItem.INVISIBLE);item88.setVisibility(NMapOverlayItem.INVISIBLE);item89.setVisibility(NMapOverlayItem.INVISIBLE);item90.setVisibility(NMapOverlayItem.INVISIBLE);item91.setVisibility(NMapOverlayItem.INVISIBLE);item92.setVisibility(NMapOverlayItem.INVISIBLE);item93.setVisibility(NMapOverlayItem.INVISIBLE);item94.setVisibility(NMapOverlayItem.INVISIBLE);item95.setVisibility(NMapOverlayItem.INVISIBLE);item96.setVisibility(NMapOverlayItem.INVISIBLE);item97.setVisibility(NMapOverlayItem.INVISIBLE);item98.setVisibility(NMapOverlayItem.INVISIBLE);item99.setVisibility(NMapOverlayItem.INVISIBLE);item100.setVisibility(NMapOverlayItem.INVISIBLE);item101.setVisibility(NMapOverlayItem.INVISIBLE);item102.setVisibility(NMapOverlayItem.INVISIBLE);item103.setVisibility(NMapOverlayItem.INVISIBLE);item104.setVisibility(NMapOverlayItem.INVISIBLE);item105.setVisibility(NMapOverlayItem.INVISIBLE);item106.setVisibility(NMapOverlayItem.INVISIBLE);item107.setVisibility(NMapOverlayItem.INVISIBLE);item108.setVisibility(NMapOverlayItem.INVISIBLE);item109.setVisibility(NMapOverlayItem.INVISIBLE);item110.setVisibility(NMapOverlayItem.INVISIBLE);item111.setVisibility(NMapOverlayItem.INVISIBLE);item112.setVisibility(NMapOverlayItem.INVISIBLE);item113.setVisibility(NMapOverlayItem.INVISIBLE);item114.setVisibility(NMapOverlayItem.INVISIBLE);item115.setVisibility(NMapOverlayItem.INVISIBLE);item116.setVisibility(NMapOverlayItem.INVISIBLE);item117.setVisibility(NMapOverlayItem.INVISIBLE);item118.setVisibility(NMapOverlayItem.INVISIBLE);item119.setVisibility(NMapOverlayItem.INVISIBLE);item120.setVisibility(NMapOverlayItem.INVISIBLE);item121.setVisibility(NMapOverlayItem.INVISIBLE);item122.setVisibility(NMapOverlayItem.INVISIBLE);item123.setVisibility(NMapOverlayItem.INVISIBLE);item124.setVisibility(NMapOverlayItem.INVISIBLE);item125.setVisibility(NMapOverlayItem.INVISIBLE);item126.setVisibility(NMapOverlayItem.INVISIBLE);item127.setVisibility(NMapOverlayItem.INVISIBLE);item128.setVisibility(NMapOverlayItem.INVISIBLE);item129.setVisibility(NMapOverlayItem.INVISIBLE);item130.setVisibility(NMapOverlayItem.INVISIBLE);item131.setVisibility(NMapOverlayItem.INVISIBLE);item132.setVisibility(NMapOverlayItem.INVISIBLE);item133.setVisibility(NMapOverlayItem.INVISIBLE);item134.setVisibility(NMapOverlayItem.INVISIBLE);item135.setVisibility(NMapOverlayItem.INVISIBLE);item136.setVisibility(NMapOverlayItem.INVISIBLE);item137.setVisibility(NMapOverlayItem.INVISIBLE);item138.setVisibility(NMapOverlayItem.INVISIBLE);item139.setVisibility(NMapOverlayItem.INVISIBLE);item140.setVisibility(NMapOverlayItem.INVISIBLE);item141.setVisibility(NMapOverlayItem.INVISIBLE);item142.setVisibility(NMapOverlayItem.INVISIBLE);item143.setVisibility(NMapOverlayItem.INVISIBLE);item144.setVisibility(NMapOverlayItem.INVISIBLE);item145.setVisibility(NMapOverlayItem.INVISIBLE);item146.setVisibility(NMapOverlayItem.INVISIBLE);item147.setVisibility(NMapOverlayItem.INVISIBLE);item148.setVisibility(NMapOverlayItem.INVISIBLE);item149.setVisibility(NMapOverlayItem.INVISIBLE);item150.setVisibility(NMapOverlayItem.INVISIBLE);item151.setVisibility(NMapOverlayItem.INVISIBLE);item152.setVisibility(NMapOverlayItem.INVISIBLE);item153.setVisibility(NMapOverlayItem.INVISIBLE);item154.setVisibility(NMapOverlayItem.INVISIBLE);item155.setVisibility(NMapOverlayItem.INVISIBLE);item156.setVisibility(NMapOverlayItem.INVISIBLE);item157.setVisibility(NMapOverlayItem.INVISIBLE);item158.setVisibility(NMapOverlayItem.INVISIBLE);item159.setVisibility(NMapOverlayItem.INVISIBLE);item160.setVisibility(NMapOverlayItem.INVISIBLE);item161.setVisibility(NMapOverlayItem.INVISIBLE);item162.setVisibility(NMapOverlayItem.INVISIBLE);item163.setVisibility(NMapOverlayItem.INVISIBLE);item164.setVisibility(NMapOverlayItem.INVISIBLE);item165.setVisibility(NMapOverlayItem.INVISIBLE);item166.setVisibility(NMapOverlayItem.INVISIBLE);item167.setVisibility(NMapOverlayItem.INVISIBLE);item168.setVisibility(NMapOverlayItem.INVISIBLE);item169.setVisibility(NMapOverlayItem.INVISIBLE);item170.setVisibility(NMapOverlayItem.INVISIBLE);item171.setVisibility(NMapOverlayItem.INVISIBLE);item172.setVisibility(NMapOverlayItem.INVISIBLE);item173.setVisibility(NMapOverlayItem.INVISIBLE);item174.setVisibility(NMapOverlayItem.VISIBLE);item175.setVisibility(NMapOverlayItem.VISIBLE);item176.setVisibility(NMapOverlayItem.VISIBLE);item177.setVisibility(NMapOverlayItem.VISIBLE);item178.setVisibility(NMapOverlayItem.VISIBLE);item179.setVisibility(NMapOverlayItem.VISIBLE);

                mMapView.invalidate();

            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {    //onclick 내부에선 item 생성
                // 같은 액티비티 수정 못함
                mMapView.setFocusable(true);
                item1.setVisibility(NMapOverlayItem.VISIBLE);item2.setVisibility(NMapOverlayItem.VISIBLE);item3.setVisibility(NMapOverlayItem.VISIBLE);item4.setVisibility(NMapOverlayItem.VISIBLE);item5.setVisibility(NMapOverlayItem.VISIBLE);item6.setVisibility(NMapOverlayItem.VISIBLE);item7.setVisibility(NMapOverlayItem.VISIBLE);item8.setVisibility(NMapOverlayItem.VISIBLE);item9.setVisibility(NMapOverlayItem.VISIBLE);item10.setVisibility(NMapOverlayItem.VISIBLE);item11.setVisibility(NMapOverlayItem.VISIBLE);item12.setVisibility(NMapOverlayItem.VISIBLE);item13.setVisibility(NMapOverlayItem.VISIBLE);item14.setVisibility(NMapOverlayItem.VISIBLE);item15.setVisibility(NMapOverlayItem.VISIBLE);item16.setVisibility(NMapOverlayItem.VISIBLE);
                item17.setVisibility(NMapOverlayItem.VISIBLE);item18.setVisibility(NMapOverlayItem.VISIBLE);item19.setVisibility(NMapOverlayItem.VISIBLE);item20.setVisibility(NMapOverlayItem.VISIBLE);item21.setVisibility(NMapOverlayItem.VISIBLE);item22.setVisibility(NMapOverlayItem.VISIBLE);item23.setVisibility(NMapOverlayItem.VISIBLE);item24.setVisibility(NMapOverlayItem.VISIBLE);item25.setVisibility(NMapOverlayItem.VISIBLE);item26.setVisibility(NMapOverlayItem.VISIBLE);item27.setVisibility(NMapOverlayItem.VISIBLE);item28.setVisibility(NMapOverlayItem.VISIBLE);
                item29.setVisibility(NMapOverlayItem.VISIBLE);item30.setVisibility(NMapOverlayItem.VISIBLE);item31.setVisibility(NMapOverlayItem.VISIBLE);item32.setVisibility(NMapOverlayItem.VISIBLE);item33.setVisibility(NMapOverlayItem.VISIBLE);item34.setVisibility(NMapOverlayItem.VISIBLE);item35.setVisibility(NMapOverlayItem.VISIBLE);item36.setVisibility(NMapOverlayItem.VISIBLE);item37.setVisibility(NMapOverlayItem.VISIBLE);item38.setVisibility(NMapOverlayItem.VISIBLE);item39.setVisibility(NMapOverlayItem.VISIBLE);item40.setVisibility(NMapOverlayItem.VISIBLE);item41.setVisibility(NMapOverlayItem.VISIBLE);item42.setVisibility(NMapOverlayItem.VISIBLE);item43.setVisibility(NMapOverlayItem.VISIBLE);item44.setVisibility(NMapOverlayItem.VISIBLE);item45.setVisibility(NMapOverlayItem.VISIBLE);item46.setVisibility(NMapOverlayItem.VISIBLE);item47.setVisibility(NMapOverlayItem.VISIBLE);item48.setVisibility(NMapOverlayItem.VISIBLE);item49.setVisibility(NMapOverlayItem.VISIBLE);item50.setVisibility(NMapOverlayItem.VISIBLE);item51.setVisibility(NMapOverlayItem.VISIBLE);item52.setVisibility(NMapOverlayItem.VISIBLE);item53.setVisibility(NMapOverlayItem.VISIBLE);item54.setVisibility(NMapOverlayItem.VISIBLE);item55.setVisibility(NMapOverlayItem.VISIBLE);item56.setVisibility(NMapOverlayItem.VISIBLE);item57.setVisibility(NMapOverlayItem.VISIBLE);item58.setVisibility(NMapOverlayItem.VISIBLE);item59.setVisibility(NMapOverlayItem.VISIBLE);item60.setVisibility(NMapOverlayItem.VISIBLE);item61.setVisibility(NMapOverlayItem.VISIBLE);item62.setVisibility(NMapOverlayItem.VISIBLE);item63.setVisibility(NMapOverlayItem.VISIBLE);item64.setVisibility(NMapOverlayItem.VISIBLE);item65.setVisibility(NMapOverlayItem.VISIBLE);item66.setVisibility(NMapOverlayItem.VISIBLE);item67.setVisibility(NMapOverlayItem.VISIBLE);item68.setVisibility(NMapOverlayItem.VISIBLE);item69.setVisibility(NMapOverlayItem.VISIBLE);item70.setVisibility(NMapOverlayItem.VISIBLE);item71.setVisibility(NMapOverlayItem.VISIBLE);item72.setVisibility(NMapOverlayItem.VISIBLE);item73.setVisibility(NMapOverlayItem.VISIBLE);item74.setVisibility(NMapOverlayItem.VISIBLE);item75.setVisibility(NMapOverlayItem.VISIBLE);item76.setVisibility(NMapOverlayItem.VISIBLE);item77.setVisibility(NMapOverlayItem.VISIBLE);item78.setVisibility(NMapOverlayItem.VISIBLE);item79.setVisibility(NMapOverlayItem.VISIBLE);item80.setVisibility(NMapOverlayItem.VISIBLE);item81.setVisibility(NMapOverlayItem.VISIBLE);item82.setVisibility(NMapOverlayItem.VISIBLE);item83.setVisibility(NMapOverlayItem.VISIBLE);item84.setVisibility(NMapOverlayItem.VISIBLE);item85.setVisibility(NMapOverlayItem.VISIBLE);item86.setVisibility(NMapOverlayItem.VISIBLE);item87.setVisibility(NMapOverlayItem.VISIBLE);item88.setVisibility(NMapOverlayItem.VISIBLE);item89.setVisibility(NMapOverlayItem.VISIBLE);item90.setVisibility(NMapOverlayItem.VISIBLE);item91.setVisibility(NMapOverlayItem.VISIBLE);item92.setVisibility(NMapOverlayItem.VISIBLE);item93.setVisibility(NMapOverlayItem.VISIBLE);item94.setVisibility(NMapOverlayItem.VISIBLE);item95.setVisibility(NMapOverlayItem.VISIBLE);item96.setVisibility(NMapOverlayItem.VISIBLE);item97.setVisibility(NMapOverlayItem.VISIBLE);item98.setVisibility(NMapOverlayItem.VISIBLE);item99.setVisibility(NMapOverlayItem.VISIBLE);item100.setVisibility(NMapOverlayItem.VISIBLE);item101.setVisibility(NMapOverlayItem.VISIBLE);item102.setVisibility(NMapOverlayItem.VISIBLE);item103.setVisibility(NMapOverlayItem.VISIBLE);item104.setVisibility(NMapOverlayItem.VISIBLE);item105.setVisibility(NMapOverlayItem.VISIBLE);item106.setVisibility(NMapOverlayItem.VISIBLE);item107.setVisibility(NMapOverlayItem.VISIBLE);item108.setVisibility(NMapOverlayItem.VISIBLE);item109.setVisibility(NMapOverlayItem.VISIBLE);item110.setVisibility(NMapOverlayItem.VISIBLE);item111.setVisibility(NMapOverlayItem.VISIBLE);item112.setVisibility(NMapOverlayItem.VISIBLE);item113.setVisibility(NMapOverlayItem.VISIBLE);item114.setVisibility(NMapOverlayItem.VISIBLE);item115.setVisibility(NMapOverlayItem.VISIBLE);item116.setVisibility(NMapOverlayItem.VISIBLE);item117.setVisibility(NMapOverlayItem.VISIBLE);item118.setVisibility(NMapOverlayItem.VISIBLE);item119.setVisibility(NMapOverlayItem.VISIBLE);item120.setVisibility(NMapOverlayItem.VISIBLE);item121.setVisibility(NMapOverlayItem.VISIBLE);item122.setVisibility(NMapOverlayItem.VISIBLE);item123.setVisibility(NMapOverlayItem.VISIBLE);item124.setVisibility(NMapOverlayItem.VISIBLE);item125.setVisibility(NMapOverlayItem.VISIBLE);item126.setVisibility(NMapOverlayItem.VISIBLE);item127.setVisibility(NMapOverlayItem.VISIBLE);item128.setVisibility(NMapOverlayItem.VISIBLE);item129.setVisibility(NMapOverlayItem.VISIBLE);item130.setVisibility(NMapOverlayItem.VISIBLE);item131.setVisibility(NMapOverlayItem.VISIBLE);item132.setVisibility(NMapOverlayItem.VISIBLE);item133.setVisibility(NMapOverlayItem.VISIBLE);item134.setVisibility(NMapOverlayItem.VISIBLE);item135.setVisibility(NMapOverlayItem.VISIBLE);item136.setVisibility(NMapOverlayItem.VISIBLE);item137.setVisibility(NMapOverlayItem.VISIBLE);item138.setVisibility(NMapOverlayItem.VISIBLE);item139.setVisibility(NMapOverlayItem.VISIBLE);item140.setVisibility(NMapOverlayItem.VISIBLE);item141.setVisibility(NMapOverlayItem.VISIBLE);item142.setVisibility(NMapOverlayItem.VISIBLE);item143.setVisibility(NMapOverlayItem.VISIBLE);item144.setVisibility(NMapOverlayItem.VISIBLE);item145.setVisibility(NMapOverlayItem.VISIBLE);item146.setVisibility(NMapOverlayItem.VISIBLE);item147.setVisibility(NMapOverlayItem.VISIBLE);item148.setVisibility(NMapOverlayItem.VISIBLE);item149.setVisibility(NMapOverlayItem.VISIBLE);item150.setVisibility(NMapOverlayItem.VISIBLE);item151.setVisibility(NMapOverlayItem.VISIBLE);item152.setVisibility(NMapOverlayItem.VISIBLE);item153.setVisibility(NMapOverlayItem.VISIBLE);item154.setVisibility(NMapOverlayItem.VISIBLE);item155.setVisibility(NMapOverlayItem.VISIBLE);item156.setVisibility(NMapOverlayItem.VISIBLE);item157.setVisibility(NMapOverlayItem.VISIBLE);item158.setVisibility(NMapOverlayItem.VISIBLE);item159.setVisibility(NMapOverlayItem.VISIBLE);item160.setVisibility(NMapOverlayItem.VISIBLE);item161.setVisibility(NMapOverlayItem.VISIBLE);item162.setVisibility(NMapOverlayItem.VISIBLE);item163.setVisibility(NMapOverlayItem.VISIBLE);item164.setVisibility(NMapOverlayItem.VISIBLE);item165.setVisibility(NMapOverlayItem.VISIBLE);item166.setVisibility(NMapOverlayItem.VISIBLE);item167.setVisibility(NMapOverlayItem.VISIBLE);item168.setVisibility(NMapOverlayItem.VISIBLE);item169.setVisibility(NMapOverlayItem.VISIBLE);item170.setVisibility(NMapOverlayItem.VISIBLE);item171.setVisibility(NMapOverlayItem.VISIBLE);item172.setVisibility(NMapOverlayItem.VISIBLE);item173.setVisibility(NMapOverlayItem.VISIBLE);item174.setVisibility(NMapOverlayItem.VISIBLE);item175.setVisibility(NMapOverlayItem.VISIBLE);item176.setVisibility(NMapOverlayItem.VISIBLE);item177.setVisibility(NMapOverlayItem.VISIBLE);item178.setVisibility(NMapOverlayItem.VISIBLE);item179.setVisibility(NMapOverlayItem.VISIBLE);

                mMapView.invalidate();

            }
        });

        poiDataOverlay.setOnStateChangeListener(new NMapPOIdataOverlay.OnStateChangeListener() {
            @Override
            public void onFocusChanged(NMapPOIdataOverlay nMapPOIdataOverlay, NMapPOIitem nMapPOIitem) {

            }

            @Override
            public void onCalloutClick(NMapPOIdataOverlay nMapPOIdataOverlay, NMapPOIitem nMapPOIitem) {

            }
        });
        poiDataOverlay.showAllPOIdata(0);

    }




    public void onZoomLevelChange(NMapView arg0, int arg1) {
    }
    // TODO Auto-generated method stub

    public void onMapInitHandler(NMapView arg0, NMapError errorInfo) {
        if (errorInfo == null) { // success
            mMapController.setMapCenter(new NGeoPoint(126.958227,37.582076), 2);
            mMapView.setEnabled(true);
        } else { // fail
            Log.e("NMAP", "onMapInitHandler: error=" + errorInfo.toString());
        }
    }


    public void onAnimationStateChange(NMapView arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub

    }

    public void onMapCenterChange(NMapView arg0, NGeoPoint arg1) {
        // TODO Auto-generated method stub

    }

    public void onMapCenterChangeFine(NMapView arg0) {
        // TODO Auto-generated method stub

    }



    public void onLongPress(NMapView arg0, MotionEvent arg1) {
        // TODO Auto-generated method stub

    }
    public void onLongPressCanceled(NMapView arg0) {
        // TODO Auto-generated method stub

    }
    public void onScroll(NMapView arg0, MotionEvent arg1, MotionEvent arg2) {
        // TODO Auto-generated method stub

    }
    public void onSingleTapUp(NMapView arg0, MotionEvent arg1) {
        // TODO Auto-generated method stub

    }
    public void onTouchDown(NMapView arg0, MotionEvent arg1) {
        // TODO Auto-generated method stub

    }
    public void onTouchUp(NMapView arg0, MotionEvent arg1) {
        // TODO Auto-generated method stub

    }


    @Override
    public void onFocusChanged(NMapPOIdataOverlay nMapPOIdataOverlay, NMapPOIitem nMapPOIitem) {

    }

    @Override
    public void onCalloutClick(NMapPOIdataOverlay nMapPOIdataOverlay, NMapPOIitem nMapPOIitem) {

    }

}