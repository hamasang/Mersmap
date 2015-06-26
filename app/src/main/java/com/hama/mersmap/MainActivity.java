package com.hama.mersmap;

import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.Map;

public class MainActivity extends ActionBarActivity {

    private static final double EARTH_RADIUS = 6378100.0;
    private int offset;

    private GoogleMap googleMap;
    //국가
    static final LatLng Korea = new LatLng(35.8615124,127.096405);//대한민국
    //지역//
    //서울특별시
    static final LatLng  sfg= new LatLng(37.504741,127.1144649);//송파구
    static final LatLng  smh= new LatLng(37.504741,127.1144649);//삼성서울병원
    static final LatLng  scg= new LatLng(37.476026,127.0372019);//서초구
    static final LatLng  ysh= new LatLng(37.518179,126.936614);//여의도성모병원
    static final LatLng  gkh= new LatLng(37.540607, 127.071669);//건국대학교병원
    static final LatLng  sjg= new LatLng(37.5576747,126.9941653);//서울중구
    static final LatLng  ych= new LatLng(37.561452,126.996412);//윤창옥내과의원
    static final LatLng  hah= new LatLng(37.567686, 127.008155);//하나로의원
    static final LatLng  sdh= new LatLng(37.579686, 126.998956);//서울대병원
    //경기도
    static final LatLng  nsh= new LatLng(36.9605528,127.0453664);//새서울병원
    static final LatLng  pph= new LatLng(36.9920804,127.0875371);//평택푸른의원
    static final LatLng  peh= new LatLng(36.9926246,127.0879394);//박애병원
    static final LatLng  gmh= new LatLng(36.990663,127.120277);//굿모닝병원
    static final LatLng  vil= new LatLng(36.9963951,127.1029797);//연세허브가정의학과
    static final LatLng  psh= new LatLng(37.0096154,127.0732654);//평택성모병원
    static final LatLng  pt= new LatLng(37.007698, 126.977842);//평택
    static final LatLng  psyo= new LatLng(37.0524668,127.0573277);//365연합의원
    static final LatLng  dongtan= new LatLng(37.216611,127.080086);//한림대학교동탄성심병원
    static final LatLng  cmc= new LatLng(37.2776946,127.0277108);//성빈센트병원
    static final LatLng  cmh= new LatLng(37.285625,126.980227);//차민내과의원
    static final LatLng  mdc= new LatLng(37.291819,126.996309);//경기도의료원 수원병원
    static final LatLng  gss= new LatLng(37.3033594,127.0763731);//용인지역
    static final LatLng  krh= new LatLng(37.390491, 127.149662);//국군수도병원
    static final LatLng  gdd= new LatLng(37.390491, 127.149662);//군포시 당동
    static final LatLng  kkx= new LatLng(37.416522,126.884789);//광명역 KTX
    static final LatLng  brhh= new LatLng(37.50045,126.785);//로하스부천요양병원
    static final LatLng  bfh= new LatLng(37.487208,126.793323);//부천성모장례식장
    static final LatLng  bsfh= new LatLng(37.486544, 126.792717);//부천성모병원 외부진료소
    static final LatLng  onbs= new LatLng(37.485236,126.813321);//온누리보석사우나
    static final LatLng  bch= new LatLng(37.50045,126.785);//부천지역
    static final LatLng  ash= new LatLng(37.014913,127.257402);//경기도립의료원안성병원
    static final LatLng  wsh= new LatLng(37.347848,127.945875);//원주세브란스기독병원
    //강원도
    static final LatLng  grh= new LatLng(37.749326,128.888779);//강릉의료원
    //충청도
    static final LatLng  cnuh= new LatLng(36.3169463,127.414983);//충남대학교병원
    static final LatLng  syo= new LatLng(36.352596, 126.592286);//삼육오연합의원
    static final LatLng  boryung= new LatLng(36.3487,126.6028);//보령시
    static final LatLng  dkuh= new LatLng(36.3487,126.6028);//단국대학교병원
    static final LatLng  dkuhs= new LatLng(36.841746,127.1692912);//단국대학교부속병원
    static final LatLng  ads= new LatLng(36.928391,127.038287);//아산 둔포 서울의원
    //대전
    static final LatLng  kyuh= new LatLng(36.306506,127.342572);//건양대학교병원
    static final LatLng  dch= new LatLng(36.308314,127.370351);//대청병원
    //전라도
    static final LatLng CSY = new LatLng(35.377913,127.141429);//최선영내과의원
    static final LatLng SCH = new LatLng(35.4284945,127.0845758);//순창군
    static final LatLng Gimjae = new LatLng(35.79965,126.89135);//김제시
    //경상도
    static final LatLng BusanStation = new LatLng(35.114979,129.041549);//부산역
    static final LatLng Busan = new LatLng(35.1784009,129.0800632);//부산
    static final LatLng Damc = new LatLng(35.119977,129.017565);//동아대학병원
    static final LatLng ImHong = new LatLng(35.1008356,128.9953721);//임홍섭내과의원
    static final LatLng GJungStation = new LatLng(35.100533,128.993894);//괴정역
    static final LatLng amc = new LatLng(36.5627,128.7268);//경북 안동의료원
    static final LatLng dongkuk = new LatLng(35.8534,129.20435);//동국대학교 경주병원
    static final LatLng yy = new LatLng(36.6888466,129.147851);//영양군
    //자기위치
    static final LatLng SEOUL = new LatLng( 37.56, 126.97);//서울

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        googleMap = mapFragment.getMap();

        //현재 위치로 가는 버튼 표시
        googleMap.setMyLocationEnabled(true);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom( SEOUL, 15));//초기 위치...수정필요

        MyLocation.LocationResult locationResult = new MyLocation.LocationResult() {
            @Override
            public void gotLocation(Location location) {

                String msg = "lon: "+location.getLongitude()+" -- lat: "+location.getLatitude();
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
                drawMarker(location);

            }
        };

        MyLocation myLocation = new MyLocation();
        myLocation.getLocation(getApplicationContext(), locationResult);

        //SupportMapFragment supportMapFragment =
        //(SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        MapFragment mfm = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        //googleMap = supportMapFragment.getMap();
        googleMap = mfm.getMap();
        //이동
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Korea, 6.9f));
        //마커
        //서울특별시
        googleMap.addMarker(new MarkerOptions().position(sfg).title("서울 송파구지역[방문]"));
        googleMap.addMarker(new MarkerOptions().position(smh).title("삼성서울병원[확진]").icon(BitmapDescriptorFactory.fromResource(R.drawable.df)));
        googleMap.addMarker(new MarkerOptions().position(scg).title("서초구지역[방문]"));
        googleMap.addMarker(new MarkerOptions().position(ysh).title("여의도성모병원[방문]"));
        googleMap.addMarker(new MarkerOptions().position(gkh).title("건국대학교병원[방문]"));
        googleMap.addMarker(new MarkerOptions().position(sjg).title("서울 중구 지역[확진]").icon(BitmapDescriptorFactory.fromResource(R.drawable.df)));
        googleMap.addMarker(new MarkerOptions().position(ych).title("윤창옥내과의원[방문]"));
        googleMap.addMarker(new MarkerOptions().position(hah).title("하나로의원[방문]"));
        googleMap.addMarker(new MarkerOptions().position(sdh).title("서울대병원[이송,확진]").icon(BitmapDescriptorFactory.fromResource(R.drawable.df)));
        //경기도
        googleMap.addMarker(new MarkerOptions().position(nsh).title("새서울병원[방문]"));
        googleMap.addMarker(new MarkerOptions().position(pph).title("평택푸른의원[방문]"));
        googleMap.addMarker(new MarkerOptions().position(peh).title("박애병원[방문]"));
        googleMap.addMarker(new MarkerOptions().position(gmh).title("굿모닝병원[방문]"));
        googleMap.addMarker(new MarkerOptions().position(vil).title("연세허브가정의학과[방문]"));
        googleMap.addMarker(new MarkerOptions().position(psh).title("평택성모병원[폐쇄]").icon(BitmapDescriptorFactory.fromResource(R.drawable.rp)));
        googleMap.addMarker(new MarkerOptions().position(pt).title("평택지역[완치]").icon(BitmapDescriptorFactory.fromResource(R.drawable.gp)));
        googleMap.addMarker(new MarkerOptions().position(psyo).title("365연합의원[방문]"));
        googleMap.addMarker(new MarkerOptions().position(dongtan).title("한림대학교동탄성심병원[확진]").icon(BitmapDescriptorFactory.fromResource(R.drawable.df)));
        googleMap.addMarker(new MarkerOptions().position(cmc).title("성빈센트병원[방문]"));
        googleMap.addMarker(new MarkerOptions().position(cmh).title("차민내과의원[방문]"));
        googleMap.addMarker(new MarkerOptions().position(mdc).title("경기도의료원 수원병원[확진]").icon(BitmapDescriptorFactory.fromResource(R.drawable.df)));
        googleMap.addMarker(new MarkerOptions().position(gss).title("용인지역[양성판정]"));
        googleMap.addMarker(new MarkerOptions().position(krh).title("국군수도병원[이송,확진]").icon(BitmapDescriptorFactory.fromResource(R.drawable.df)));
        googleMap.addMarker(new MarkerOptions().position(gdd).title("군포시 당동[확진]").icon(BitmapDescriptorFactory.fromResource(R.drawable.df)));
        googleMap.addMarker(new MarkerOptions().position(kkx).title("광명역 KTX[방문]"));
        googleMap.addMarker(new MarkerOptions().position(brhh).title("로하스부천요양병원[방문]"));
        googleMap.addMarker(new MarkerOptions().position(bfh).title("부천성모장례식장[방문]"));
        googleMap.addMarker(new MarkerOptions().position(bsfh).title("부천성모병원 외부진료소[확진]").icon(BitmapDescriptorFactory.fromResource(R.drawable.df)));
        googleMap.addMarker(new MarkerOptions().position(onbs).title("온누리보석사우나[방문]"));
        googleMap.addMarker(new MarkerOptions().position(bch).title("부천지역[확진]").icon(BitmapDescriptorFactory.fromResource(R.drawable.df)));
        googleMap.addMarker(new MarkerOptions().position(ash).title("경기도립의료원안성병원[확진]").icon(BitmapDescriptorFactory.fromResource(R.drawable.df)));
        googleMap.addMarker(new MarkerOptions().position(wsh).title("원주세브란스기독병원[확진]").icon(BitmapDescriptorFactory.fromResource(R.drawable.df)));
        //강원도
        googleMap.addMarker(new MarkerOptions().position(grh).title("강릉의료원[확진]").icon(BitmapDescriptorFactory.fromResource(R.drawable.df)));
        //충청도
        googleMap.addMarker(new MarkerOptions().position(cnuh).title("충남대학교병원[이송,확진]").icon(BitmapDescriptorFactory.fromResource(R.drawable.df)));
        googleMap.addMarker(new MarkerOptions().position(syo).title("삼육오연합의원[방문]"));
        googleMap.addMarker(new MarkerOptions().position(boryung).title("보령지역[확진]").icon(BitmapDescriptorFactory.fromResource(R.drawable.df)));
        googleMap.addMarker(new MarkerOptions().position(dkuh).title("단국대학교병원[확진]").icon(BitmapDescriptorFactory.fromResource(R.drawable.df)));
        googleMap.addMarker(new MarkerOptions().position(dkuhs).title("단국대학교부속병원[방문]"));
        googleMap.addMarker(new MarkerOptions().position(ads).title("아산 둔포 서울의원[방문]"));
        //대전
        googleMap.addMarker(new MarkerOptions().position(kyuh).title("건양대학교병원[이송]"));
        googleMap.addMarker(new MarkerOptions().position(dch).title("(서구) 대청 병원[확진]").icon(BitmapDescriptorFactory.fromResource(R.drawable.df)));
        //전라도
        googleMap.addMarker(new MarkerOptions().position(CSY).title("최선영내과의원[방문]"));
        googleMap.addMarker(new MarkerOptions().position(SCH).title("순창군[확진]").icon(BitmapDescriptorFactory.fromResource(R.drawable.df)));
        googleMap.addMarker(new MarkerOptions().position(Gimjae).title("김제시[양성판정]").icon(BitmapDescriptorFactory.fromResource(R.drawable.yp)));
        //경상도
        googleMap.addMarker(new MarkerOptions().position(BusanStation).title("부산역[방문]"));
        googleMap.addMarker(new MarkerOptions().position(Busan).title("부산[확진]").icon(BitmapDescriptorFactory.fromResource(R.drawable.df)));
        googleMap.addMarker(new MarkerOptions().position(Damc).title("동아대학교병원[방문]"));
        googleMap.addMarker(new MarkerOptions().position(ImHong).title("임홍섭내과의원[방문]"));
        googleMap.addMarker(new MarkerOptions().position(amc).title("안동의료원[의심]").icon(BitmapDescriptorFactory.fromResource(R.drawable.yp)));
        googleMap.addMarker(new MarkerOptions().position(GJungStation).title("괴정역[방문]"));
        googleMap.addMarker(new MarkerOptions().position(dongkuk).title("동국대학교 경주병원[이송,확진]").icon(BitmapDescriptorFactory.fromResource(R.drawable.df)));
        googleMap.addMarker(new MarkerOptions().position(yy).title("영양군[의심]").icon(BitmapDescriptorFactory.fromResource(R.drawable.yp)));
    }

    private void drawMarker(Location location) {

        //기존 마커 지우기
        ///googleMap.clear();
        LatLng currentPosition = new LatLng(location.getLatitude(), location.getLongitude());

        //currentPosition 위치로 카메라 중심을 옮기고 화면 줌을 조정한다. 줌범위는 2~21, 숫자클수록 확대
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom( currentPosition, 17));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(17), 2000, null);

        //마커 추가
        googleMap.addMarker(new MarkerOptions()
                .position(currentPosition)
                .snippet("Lat:" + location.getLatitude() + "Lng:" + location.getLongitude())
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                .title("현재위치"));
        googleMap.addCircle(new CircleOptions()
                .center(new LatLng(location.getLatitude(), location.getLongitude()))
                .radius(1000)
                .strokeColor(Color.BLUE));

    }

    private void addCircle(LatLng latLng, double radius)
    {
        double R = 6371d; // earth's mean radius in km
        double d = radius/R; //radius given in km
        double lat1 = Math.toRadians(latLng.latitude);
        double lon1 = Math.toRadians(latLng.longitude);
        PolylineOptions options = new PolylineOptions();
        for (int x = 0; x <= 360; x++)
        {
            double brng = Math.toRadians(x);
            double latitudeRad = Math.asin(Math.sin(lat1)*Math.cos(d) + Math.cos(lat1)*Math.sin(d)*Math.cos(brng));
            double longitudeRad = (lon1 + Math.atan2(Math.sin(brng)*Math.sin(d)*Math.cos(lat1), Math.cos(d)-Math.sin(lat1)*Math.sin(latitudeRad)));
            options.add(new LatLng(Math.toDegrees(latitudeRad), Math.toDegrees(longitudeRad)));
        }
        googleMap.addPolyline(options.color(Color.BLACK).width(2));
    }

    public void onMapReady(GoogleMap map) {
        map.addMarker(new MarkerOptions()
                .position(new LatLng(10, 10))
                .title("MersMap"));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if(id==R.id.action_settings){
            Intent intentSubActivity =
                    new Intent(MainActivity.this, Mersh.class);
            startActivity(intentSubActivity);
            return true;
        }
        if(id==R.id.action_mershlist){
            onRestart();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onRestart() {

        // TODO Auto-generated method stub
        super.onRestart();
        Intent i = new Intent(MainActivity.this, MainActivity.class);  //your class
        startActivity(i);
        finish();

    }
}
