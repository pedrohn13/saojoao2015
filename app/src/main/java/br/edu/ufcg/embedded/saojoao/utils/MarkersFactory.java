package br.edu.ufcg.embedded.saojoao.utils;

import android.content.Context;
import android.util.Log;

import br.edu.ufcg.embedded.saojoao.R;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

/**
 * Created by Pedro on 09/06/2015.
 */
public class MarkersFactory {

    public static final double LATITUDE_GATE_1 = -7.222896;
    public static final double LONGITUDE_GATE_1 = -35.887679;
    public static final double LATITUDE_GATE_2 = -7.223665;
    public static final double LONGITUDE_GATE_2 = -35.887167;
    public static final double LATITUDE_GATE_3 = -7.225588;
    public static final double LONGITUDE_GATE_3 = -35.885794;
    public static final double LATITUDE_GATE_4 = -7.225602;
    public static final double LONGITUDE_GATE_4 = -35.886493;
    public static final double LATITUDE_GATE_5 = -7.224388;
    public static final double LONGITUDE_GATE_5 = -35.887439;
    public static final double LATITUDE_GATE_6 = -7.223732;
    public static final double LONGITUDE_GATE_6 = -35.888545;
    public static final double LATITUDE_GATE_7 = -7.223001;
    public static final double LONGITUDE_GATE_7 = -35.888782;
    public static final double LATITUDE_EMERG_1 = -7.223933;
    public static final double LONGITUDE_EMERG_1 = -35.888074;
    public static final double LATITUDE_EMERG_2 = -7.223356;
    public static final double LONGITUDE_EMERG_2 = -35.887497;
    public static final double LATITUDE_EMERG_3 = -7.223940;
    public static final double LONGITUDE_EMERG_3 = -35.887901;
    public static final double LATITUDE_EMERG_4 = -7.223475;
    public static final double LONGITUDE_EMERG_4 = -35.887666;
    public static final double LATITUDE_PALCO_PRINCIPAL = -7.222679;
    public static final double LONGITUDE_PALCO_PRINCIPAL = -35.888300;
    public static final double LATITUDE_PALCO_PIRAMIDE = -7.223873;
    public static final double LONGITUDE_PALCO_PIRAMIDE = -35.887762;
    public static final double LATITUDE_PALCO_CARRETA = -7.225219;
    public static final double LONGITUDE_PALCO_CARRETA = -35.886908;
    public static final double LATITUDE_CASSINO = -7.225732;
    public static final double LONGITUDE_CASSINO = -35.885761;
    public static final double LATITUDE_CINE = -7.225289;
    public static final double LONGITUDE_CINE = -35.886772;
    public static final double LATITUDE_CATEDRAL = -7.225087;
    public static final double LONGITUDE_CATEDRAL = -35.887020;
    public static final double LATITUDE_VILA = -7.224836;
    public static final double LONGITUDE_VILA = -35.886980;
    public static final double LATITUDE_TELE = -7.224801;
    public static final double LONGITUDE_TELE = -35.886717;
    public static final double LATITUDE_FOGUEIRA = -7.224505;
    public static final double LONGITUDE_FOGUEIRA = -35.887116;
    public static final double LATITUDE_ILHA_1 = -7.224309;
    public static final double LONGITUDE_ILHA_1 = -35.887189;
    public static final double LONGITUDE_ILHA_2 = -35.886328;
    public static final double LATITUDE_ILHA_2 = -7.225498;
    public static final double LATITUDE_ILHA_3 = -7.225634;
    public static final double LONGITUDE_ILHA_3 = -35.885988;
    public static final double LATITUDE_BARRACA_1 = -7.223547;
    public static final double LONGITUDE_BARRACA_1 = -35.887439;
    public static final double LATITUDE_BARRACA_2 = -7.223746;
    public static final double LONGITUDE_BARRACA_2 = -35.887323;
    public static final double LATITUDE_BARRACA_3 = -7.225172;
    public static final double LONGITUDE_BARRACA_3 = -35.886959;
    public static final double LATITUDE_BARRACA_4 = -7.225302;
    public static final double LONGITUDE_BARRACA_4 = -35.886690;
    public static final double LATITUDE_BARRACA_5 = -7.224921;
    public static final double LONGITUDE_BARRACA_5 = -35.886941;
    public static final double LATITUDE_BARRACA_6 = -7.224741;
    public static final double LONGITUDE_BARRACA_6 = -35.886721;
    public static final double LATITUDE_BARRACA_7 = -7.224606;
    public static final double LONGITUDE_BARRACA_7 = -35.886775;
    public static final double LATITUDE_BARRACA_8 = -7.224874;
    public static final double LONGITUDE_BARRACA_8 = -35.886955;
    public static final double LATITUDE_BARRACA_9 = -7.224791;
    public static final double LONGITUDE_BARRACA_9 = -35.886991;
    public static final double LATITUDE_BAR_1 = -7.223302;
    public static final double LONGITUDE_BAR_1 = -35.888369;
    public static final double LATITUDE_BAR_2 = -7.223459;
    public static final double LONGITUDE_BAR_2 = -35.888352;
    public static final double LATITUDE_BAR_3 = -7.223811;
    public static final double LONGITUDE_BAR_3 = -35.888216;
    public static final double LATITUDE_BAR_4 = -7.223787;
    public static final double LONGITUDE_BAR_4 = -35.888027;
    public static final double LATITUDE_BAR_5 = -7.223615;
    public static final double LONGITUDE_BAR_5 = -35.887946;
    public static final double LATITUDE_BAR_6 = -7.224029;
    public static final double LONGITUDE_BAR_6 = -35.887139;
    public static final double LATITUDE_BAR_7 = -7.224084;
    public static final double LONGITUDE_BAR_7 = -35.887299;
    public static final double LATITUDE_BAR_8 = -7.224148;
    public static final double LONGITUDE_BAR_8 = -35.887527;
    public static final double LATITUDE_BAR_9 = -7.224412;
    public static final double LONGITUDE_BAR_9 = -35.887262;
    public static final double LATITUDE_BAR_10 = -7.224366;
    public static final double LONGITUDE_BAR_10 = -35.886944;
    public static final double LATITUDE_BAR_11 = -7.225387;
    public static final double LONGITUDE_BAR_11 = -35.886524;
    public static final double LATITUDE_BAR_12 = -7.225704;
    public static final double LONGITUDE_BAR_12 = -35.886347;
    public static final double LATITUDE_BAR_13 = -7.225590;
    public static final double LONGITUDE_BAR_13 = -35.886144;
    public static final double LATITUDE_BAR_14 = -7.225436;
    public static final double LONGITUDE_BAR_14 = -35.885975;
    public static final double LATITUDE_BAR_15 = -7.225249;
    public static final double LONGITUDE_BAR_15 = -35.886283;
    public static final double LATITUDE_BAR_16 = -7.225830;
    public static final double LONGITUDE_BAR_16 = -35.886043;
    public static final double LATITUDE_RESTAURANTE_1 = -7.225387;
    public static final double LONGITUDE_RESTAURANTE_1 = -35.886524;
    public static final double LATITUDE_RESTAURANTE_2 = -7.225704;
    public static final double LONGITUDE_RESTAURANTE_2 = -35.886347;
    public static final double LATITUDE_RESTAURANTE_3 = -7.225590;
    public static final double LONGITUDE_RESTAURANTE_3 = -35.886144;
    public static final double LATITUDE_RESTAURANTE_4 = -7.225436;
    public static final double LONGITUDE_RESTAURANTE_4 = -35.885975;
    public static final double LATITUDE_RESTAURANTE_5 = -7.225249;
    public static final double LONGITUDE_RESTAURANTE_5 = -35.886283;
    public static final double LATITUDE_RESTAURANTE_6 = -7.225830;
    public static final double LONGITUDE_RESTAURANTE_6 = -35.886043;
    public static final double LATITUDE_QUIOSQUE_1 = -7.223078;
    public static final double LONGITUDE_QUIOSQUE_1 = -35.887584;
    public static final double LATITUDE_QUIOSQUE_2 = -7.223486;
    public static final double LONGITUDE_QUIOSQUE_2 = -35.887367;
    public static final double LATITUDE_QUIOSQUE_3 = -7.223680;
    public static final double LONGITUDE_QUIOSQUE_3 = -35.887254;
    public static final double LATITUDE_QUIOSQUE_4 = -7.223963;
    public static final double LONGITUDE_QUIOSQUE_4 = -35.887084;
    public static final double LATITUDE_QUIOSQUE_5 = -7.224234;
    public static final double LONGITUDE_QUIOSQUE_5 = -35.886911;
    public static final double LATITUDE_QUIOSQUE_7 = -7.224744;
    public static final double LONGITUDE_QUIOSQUE_7 = -35.886995;
    public static final double LATITUDE_BANHEIRO_1 = -7.223653;
    public static final double LONGITUDE_BANHEIRO_1 = -35.888405;
    public static final double LATITUDE_BANHEIRO_2 = -7.223803;
    public static final double LONGITUDE_BANHEIRO_2 = -35.887935;
    public static final double LATITUDE_BANHEIRO_3 = -7.224035;
    public static final double LONGITUDE_BANHEIRO_3 = -35.887807;
    public static final double LATITUDE_BANHEIRO_4 = -7.224751;
    public static final double LONGITUDE_BANHEIRO_4 = -35.887163;
    public static final double LATITUDE_INTEGRACAO = -7.220920;
    public static final double LONGITUDE_INTEGRACAO = -35.889009;
    public static final double LATITUDE_TAXI =  -7.222099;
    public static final double LONGITUDE_TAXI = -35.888117;
    public static final double LATITUDE_MOTOTAXI =  -7.222204;
    public static final double LONGITUDE_MOTOTAXI = -35.888080;
    public static final double LATITUDE_POLICIA = -7.224975;
    public static final double LONGITUDE_POLICIA = -35.886416;
    public static final double LATITUDE_BOMBEIRO = -7.224930;
    public static final double LONGITUDE_BOMBEIRO = -35.886447;
    public static final double LATITUDE_HIDRO_1 = -7.222720;
    public static final double LONGITUDE_HIDRO_1 = -35.888568;
    public static final double LATITUDE_HIDRO_2 = -7.223131;
    public static final double LONGITUDE_HIDRO_2 = -35.888417;
    public static final double LATITUDE_HIDRO_3 = -7.222602;
    public static final double LONGITUDE_HIDRO_3 = -35.888095;
    public static final double LATITUDE_HIDRO_4 = -7.223629;
    public static final double LONGITUDE_HIDRO_4 = -35.888304;
    public static final double LATITUDE_HIDRO_5 = -7.223511;
    public static final double LONGITUDE_HIDRO_5 = -35.887747;
    public static final double LATITUDE_HIDRO_6 = -7.223973;
    public static final double LONGITUDE_HIDRO_6 = -35.887494;
    public static final double LATITUDE_SAUDE_1 = -7.223085;
    public static final double LONGITUDE_SAUDE_1 = -35.888513;
    public static final double LATITUDE_SAUDE_2 = -7.223804;
    public static final double LONGITUDE_SAUDE_2 = -35.887281;

    private Context mContext;

    private ArrayList<MarkerOptions> entradaMarkers;
    private ArrayList<MarkerOptions> saidaEmergenciaMarkers;
    private ArrayList<MarkerOptions> ilhaDeForroMarkers;
    private ArrayList<MarkerOptions> palcosMarkers;
    private ArrayList<MarkerOptions> banheirosMarkers;
    private ArrayList<MarkerOptions> restaurantesMarkers;
    private ArrayList<MarkerOptions> quiosquesMarkers;
    private ArrayList<MarkerOptions> barracasMarkers;
    private ArrayList<MarkerOptions> baresMarkers;
    private ArrayList<MarkerOptions> postoPolicialMarkers;
    private ArrayList<MarkerOptions> postoSaudeMarkers;
    private ArrayList<MarkerOptions> pontoTuristicoMarkers;
    private ArrayList<MarkerOptions> bombeirosMarkers;
    private ArrayList<MarkerOptions> hidrometrosMarkers;
    private ArrayList<MarkerOptions> transporteMarkers;

    public static final float HUE_VERDON = 210f;
    public static final float HUE_GOLD = 78f;
    public static final float HUE_CREAM = 60f;
    public static final float HUE_PURPLE = 285f;
    public static final float HUE_SALMOM = 0f;

    public MarkersFactory(Context context) {
        this.mContext = context;

        entradaMarkers = new ArrayList<MarkerOptions>();
        saidaEmergenciaMarkers = new ArrayList<MarkerOptions>();
        palcosMarkers = new ArrayList<MarkerOptions>();
        pontoTuristicoMarkers = new ArrayList<MarkerOptions>();
        ilhaDeForroMarkers = new ArrayList<MarkerOptions>();

        banheirosMarkers = new ArrayList<MarkerOptions>();
        restaurantesMarkers = new ArrayList<MarkerOptions>();
        quiosquesMarkers = new ArrayList<MarkerOptions>();
        barracasMarkers = new ArrayList<MarkerOptions>();
        baresMarkers = new ArrayList<MarkerOptions>();
        postoPolicialMarkers = new ArrayList<MarkerOptions>();
        postoSaudeMarkers = new ArrayList<MarkerOptions>();
        bombeirosMarkers = new ArrayList<MarkerOptions>();
        hidrometrosMarkers = new ArrayList<MarkerOptions>();
        transporteMarkers = new ArrayList<MarkerOptions>();


        createEnters();
        createEmergencyExit();
        createPalcos();
        createIlhas();
        createPontosTuristicos();
        createBarracas();
        createBares();
        createRestaurantes();
        createQuiosques();
        createBanheiros();
        createPontosTransporte();
        createPostoPolicia();
        createBombeiros();
        //createHidro();
        createPostosSaude();
    }

    public void createEnters() {
        entradaMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_GATE_1, LONGITUDE_GATE_1))
                .title(mContext.getString(R.string.gate_1)).snippet(mContext.getString(R.string.d_gate_1))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        entradaMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_GATE_2, LONGITUDE_GATE_2))
                .title(mContext.getString(R.string.gate_2)).snippet(mContext.getString(R.string.d_gate_2))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        entradaMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_GATE_3, LONGITUDE_GATE_3))
                .title(mContext.getString(R.string.gate_3)).snippet(mContext.getString(R.string.d_gate_3))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        entradaMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_GATE_4, LONGITUDE_GATE_4))
                .title(mContext.getString(R.string.gate_4)).snippet(mContext.getString(R.string.d_gate_4))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        entradaMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_GATE_5, LONGITUDE_GATE_5))
                .title(mContext.getString(R.string.gate_5)).snippet(mContext.getString(R.string.d_gate_5))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        entradaMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_GATE_6, LONGITUDE_GATE_6))
                .title(mContext.getString(R.string.gate_6)).snippet(mContext.getString(R.string.d_gate_6))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        entradaMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_GATE_7, LONGITUDE_GATE_7))
                .title(mContext.getString(R.string.gate_7)).snippet(mContext.getString(R.string.d_gate_7))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
    }

    public void createEmergencyExit() {
        saidaEmergenciaMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_GATE_1, LONGITUDE_GATE_1))
                .title(mContext.getString(R.string.gate_1)).snippet(mContext.getString(R.string.d_gate_1))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        saidaEmergenciaMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_GATE_2, LONGITUDE_GATE_2))
                .title(mContext.getString(R.string.gate_2)).snippet(mContext.getString(R.string.d_gate_2))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        saidaEmergenciaMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_GATE_3, LONGITUDE_GATE_3))
                .title(mContext.getString(R.string.gate_3)).snippet(mContext.getString(R.string.d_gate_3))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        saidaEmergenciaMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_GATE_4, LONGITUDE_GATE_4))
                .title(mContext.getString(R.string.gate_4)).snippet(mContext.getString(R.string.d_gate_4))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        saidaEmergenciaMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_GATE_5, LONGITUDE_GATE_5))
                .title(mContext.getString(R.string.gate_5)).snippet(mContext.getString(R.string.d_gate_5))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        saidaEmergenciaMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_GATE_6, LONGITUDE_GATE_6))
                .title(mContext.getString(R.string.gate_6)).snippet(mContext.getString(R.string.d_gate_6))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        saidaEmergenciaMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_GATE_7, LONGITUDE_GATE_7))
                .title(mContext.getString(R.string.gate_7)).snippet(mContext.getString(R.string.d_gate_7))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        saidaEmergenciaMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_EMERG_1, LONGITUDE_EMERG_1))
                .title(mContext.getString(R.string.emerg_exit_1)).snippet(mContext.getString(R.string.d_emerg_exit_1))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        saidaEmergenciaMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_EMERG_2, LONGITUDE_EMERG_2))
                .title(mContext.getString(R.string.emerg_exit_2)).snippet(mContext.getString(R.string.d_emerg_exit_2))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        saidaEmergenciaMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_EMERG_3, LONGITUDE_EMERG_3))
                .title(mContext.getString(R.string.emerg_exit_3)).snippet(mContext.getString(R.string.d_emerg_exit_3))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        saidaEmergenciaMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_EMERG_4, LONGITUDE_EMERG_4))
                .title(mContext.getString(R.string.emerg_exit_4)).snippet(mContext.getString(R.string.d_emerg_exit_4))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
    }

    public void createPalcos() {
        palcosMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_PALCO_PRINCIPAL, LONGITUDE_PALCO_PRINCIPAL))
                .title(mContext.getString(R.string.palco_principal)).snippet(mContext.getString(R.string.d_palco_principal))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        palcosMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_PALCO_PIRAMIDE, LONGITUDE_PALCO_PIRAMIDE))
                .title(mContext.getString(R.string.piramide)).snippet(mContext.getString(R.string.d_palco_piramide))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        palcosMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_PALCO_CARRETA, LONGITUDE_PALCO_CARRETA))
                .title(mContext.getString(R.string.carreta)).snippet(mContext.getString(R.string.d_carreta))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
    }

    public void createPontosTuristicos() {
        pontoTuristicoMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_CASSINO, LONGITUDE_CASSINO))
                .title(mContext.getString(R.string.cassino)).snippet(mContext.getString(R.string.d_cassino))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
        pontoTuristicoMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_CINE, LONGITUDE_CINE))
                .title(mContext.getString(R.string.capitolio)).snippet(mContext.getString(R.string.d_capitolio))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
        pontoTuristicoMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_CATEDRAL, LONGITUDE_CATEDRAL))
                .title(mContext.getString(R.string.catedral)).snippet(mContext.getString(R.string.d_catedral))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
        pontoTuristicoMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_VILA, LONGITUDE_VILA))
                .title(mContext.getString(R.string.vila_nova)).snippet(mContext.getString(R.string.d_vila_nova))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
        pontoTuristicoMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_PALCO_CARRETA, LONGITUDE_PALCO_CARRETA))
                .title(mContext.getString(R.string.abrigo)).snippet(mContext.getString(R.string.d_carreta))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
        pontoTuristicoMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_TELE, LONGITUDE_TELE))
                .title(mContext.getString(R.string.telegrafo)).snippet(mContext.getString(R.string.d_telegrafo))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
        pontoTuristicoMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_FOGUEIRA, LONGITUDE_FOGUEIRA))
                .title(mContext.getString(R.string.fogueira)).snippet(mContext.getString(R.string.d_fogueira))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
    }

    public void createIlhas() {
        ilhaDeForroMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_ILHA_1, LONGITUDE_ILHA_1))
                .title(mContext.getString(R.string.ilha_1)).snippet(mContext.getString(R.string.d_ilha))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
        ilhaDeForroMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_ILHA_2, LONGITUDE_ILHA_2))
                .title(mContext.getString(R.string.ilha_2)).snippet(mContext.getString(R.string.d_ilha))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
        ilhaDeForroMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_ILHA_3, LONGITUDE_ILHA_3))
                .title(mContext.getString(R.string.ilha_3)).snippet(mContext.getString(R.string.d_ilha))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
    }

    public void createBarracas() {
        barracasMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_BARRACA_1, LONGITUDE_BARRACA_1))
                .title(mContext.getString(R.string.barracas)).snippet(mContext.getString(R.string.d_barraca))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        barracasMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_BARRACA_2, LONGITUDE_BARRACA_2))
                .title(mContext.getString(R.string.barracas)).snippet(mContext.getString(R.string.d_barraca))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        barracasMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_BARRACA_3, LONGITUDE_BARRACA_3))
                .title(mContext.getString(R.string.barracas)).snippet(mContext.getString(R.string.d_barraca))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        barracasMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_BARRACA_4, LONGITUDE_BARRACA_4))
                .title(mContext.getString(R.string.barracas)).snippet(mContext.getString(R.string.d_barraca))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        barracasMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_BARRACA_5, LONGITUDE_BARRACA_5))
                .title(mContext.getString(R.string.barracas)).snippet(mContext.getString(R.string.d_barraca))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        barracasMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_BARRACA_6, LONGITUDE_BARRACA_6))
                .title(mContext.getString(R.string.barracas)).snippet(mContext.getString(R.string.d_barraca))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        barracasMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_BARRACA_7, LONGITUDE_BARRACA_7))
                .title(mContext.getString(R.string.barracas)).snippet(mContext.getString(R.string.d_barraca))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        barracasMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_BARRACA_8, LONGITUDE_BARRACA_8))
                .title(mContext.getString(R.string.barracas)).snippet(mContext.getString(R.string.d_barraca))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        barracasMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_BARRACA_9, LONGITUDE_BARRACA_9))
                .title(mContext.getString(R.string.barracas)).snippet(mContext.getString(R.string.d_barraca))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

    }

    public void createBares() {
        baresMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_BAR_1, LONGITUDE_BAR_1))
                .title(mContext.getString(R.string.bares)).snippet(mContext.getString(R.string.d_bar))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        baresMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_BAR_2, LONGITUDE_BAR_2))
                .title(mContext.getString(R.string.bares)).snippet(mContext.getString(R.string.d_bar))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        baresMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_BAR_3, LONGITUDE_BAR_3))
                .title(mContext.getString(R.string.bares))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        baresMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_BAR_4, LONGITUDE_BAR_4))
                .title(mContext.getString(R.string.bares)).snippet(mContext.getString(R.string.d_bar))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        baresMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_BAR_5, LONGITUDE_BAR_5))
                .title(mContext.getString(R.string.bares)).snippet(mContext.getString(R.string.d_bar))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        baresMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_BAR_6, LONGITUDE_BAR_6))
                .title(mContext.getString(R.string.bares)).snippet(mContext.getString(R.string.d_bar))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        baresMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_BAR_7, LONGITUDE_BAR_7))
                .title(mContext.getString(R.string.bares)).snippet(mContext.getString(R.string.d_bar))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        baresMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_BAR_8, LONGITUDE_BAR_8))
                .title(mContext.getString(R.string.bares)).snippet(mContext.getString(R.string.d_bar))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        baresMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_BAR_9, LONGITUDE_BAR_9))
                .title(mContext.getString(R.string.bares)).snippet(mContext.getString(R.string.d_bar))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        baresMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_BAR_10, LONGITUDE_BAR_10))
                .title(mContext.getString(R.string.bares)).snippet(mContext.getString(R.string.d_bar))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        baresMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_BAR_11, LONGITUDE_BAR_11))
                .title(mContext.getString(R.string.bares)).snippet(mContext.getString(R.string.d_bar))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        baresMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_BAR_12, LONGITUDE_BAR_12))
                .title(mContext.getString(R.string.bares)).snippet(mContext.getString(R.string.d_bar))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        baresMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_BAR_13, LONGITUDE_BAR_13))
                .title(mContext.getString(R.string.bares)).snippet(mContext.getString(R.string.d_bar))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        baresMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_BAR_14, LONGITUDE_BAR_14))
                .title(mContext.getString(R.string.bares)).snippet(mContext.getString(R.string.d_bar))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        baresMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_BAR_15, LONGITUDE_BAR_15))
                .title(mContext.getString(R.string.bares)).snippet(mContext.getString(R.string.d_bar))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        baresMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_BAR_16, LONGITUDE_BAR_16))
                .title(mContext.getString(R.string.bares)).snippet(mContext.getString(R.string.d_bar))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        baresMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_CASSINO, LONGITUDE_CASSINO))
                .title(mContext.getString(R.string.bares)).snippet(mContext.getString(R.string.d_bar))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

    }

    public void createRestaurantes() {
        restaurantesMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_RESTAURANTE_1, LONGITUDE_RESTAURANTE_1))
                .title(mContext.getString(R.string.restaurantes)).snippet(mContext.getString(R.string.d_restaurante))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)));
        restaurantesMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_RESTAURANTE_2, LONGITUDE_RESTAURANTE_2))
                .title(mContext.getString(R.string.restaurantes)).snippet(mContext.getString(R.string.d_restaurante))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)));
        restaurantesMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_RESTAURANTE_3, LONGITUDE_RESTAURANTE_3))
                .title(mContext.getString(R.string.restaurantes)).snippet(mContext.getString(R.string.d_restaurante))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)));
        restaurantesMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_RESTAURANTE_4, LONGITUDE_RESTAURANTE_4))
                .title(mContext.getString(R.string.restaurantes)).snippet(mContext.getString(R.string.d_restaurante))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)));
        restaurantesMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_RESTAURANTE_5, LONGITUDE_RESTAURANTE_5))
                .title(mContext.getString(R.string.restaurantes)).snippet(mContext.getString(R.string.d_restaurante))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)));
        restaurantesMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_RESTAURANTE_6, LONGITUDE_RESTAURANTE_6))
                .title(mContext.getString(R.string.restaurantes)).snippet(mContext.getString(R.string.d_restaurante))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)));
        restaurantesMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_CASSINO, LONGITUDE_CASSINO))
                .title(mContext.getString(R.string.restaurantes)).snippet(mContext.getString(R.string.d_restaurante))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)));

    }

    public void createQuiosques() {
        quiosquesMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_QUIOSQUE_1, LONGITUDE_QUIOSQUE_1))
                .title(mContext.getString(R.string.quiosques)).snippet(mContext.getString(R.string.d_quiosque))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));
        quiosquesMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_QUIOSQUE_2, LONGITUDE_QUIOSQUE_2))
                .title(mContext.getString(R.string.quiosques)).snippet(mContext.getString(R.string.d_quiosque))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));
        quiosquesMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_QUIOSQUE_3, LONGITUDE_QUIOSQUE_3))
                .title(mContext.getString(R.string.quiosques)).snippet(mContext.getString(R.string.d_quiosque))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));
        quiosquesMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_QUIOSQUE_4, LONGITUDE_QUIOSQUE_4))
                .title(mContext.getString(R.string.quiosques)).snippet(mContext.getString(R.string.d_quiosque))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));
        quiosquesMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_QUIOSQUE_5, LONGITUDE_QUIOSQUE_5))
                .title(mContext.getString(R.string.quiosques)).snippet(mContext.getString(R.string.d_quiosque))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));
        quiosquesMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_QUIOSQUE_7, LONGITUDE_QUIOSQUE_7))
                .title(mContext.getString(R.string.quiosques)).snippet(mContext.getString(R.string.d_quiosque))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));

    }

    public void createBanheiros() {
        banheirosMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_BANHEIRO_1, LONGITUDE_BANHEIRO_1))
                .title(mContext.getString(R.string.banheiros)).snippet(mContext.getString(R.string.d_bath_1))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));
        banheirosMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_BANHEIRO_2, LONGITUDE_BANHEIRO_2))
                .title(mContext.getString(R.string.banheiros)).snippet(mContext.getString(R.string.d_bath_p))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));
        banheirosMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_BANHEIRO_3, LONGITUDE_BANHEIRO_3))
                .title(mContext.getString(R.string.banheiros)).snippet(mContext.getString(R.string.d_bath_p))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));
        banheirosMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_BANHEIRO_4, LONGITUDE_BANHEIRO_4))
                .title(mContext.getString(R.string.banheiros)).snippet(mContext.getString(R.string.d_bath_4))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));

    }

    public void createPontosTransporte() {
        transporteMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_INTEGRACAO, LONGITUDE_INTEGRACAO))
                .title(mContext.getString(R.string.tra_integracao)).snippet(mContext.getString(R.string.d_integracao))
                .icon(BitmapDescriptorFactory.defaultMarker(MarkersFactory.HUE_VERDON)));
        transporteMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_TAXI, LONGITUDE_TAXI))
                .title(mContext.getString(R.string.tra_taxi)).snippet(mContext.getString(R.string.d_taxi))
                .icon(BitmapDescriptorFactory.defaultMarker(MarkersFactory.HUE_VERDON)));
        transporteMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_MOTOTAXI, LONGITUDE_MOTOTAXI))
                .title(mContext.getString(R.string.tra_moto_taxi)).snippet(mContext.getString(R.string.d_mototaxi))
                .icon(BitmapDescriptorFactory.defaultMarker(MarkersFactory.HUE_VERDON)));

    }

    public void createPostoPolicia() {
        postoPolicialMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_POLICIA, LONGITUDE_POLICIA))
                .title(mContext.getString(R.string.policia)).snippet(mContext.getString(R.string.d_policia))
                .icon(BitmapDescriptorFactory.defaultMarker(MarkersFactory.HUE_PURPLE)));

    }

    public void createBombeiros() {
        bombeirosMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_BOMBEIRO, LONGITUDE_BOMBEIRO))
                .title(mContext.getString(R.string.bombeiro)).snippet(mContext.getString(R.string.d_bombeiro))
                .icon(BitmapDescriptorFactory.defaultMarker(MarkersFactory.HUE_SALMOM)));

    }

    /*public void createHidro() {
        hidrometrosMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_HIDRO_1, LONGITUDE_HIDRO_1))
                .title(mContext.getString(R.string.hidrometros)).snippet(mContext.getString(R.string.d_hidrometro))
                .icon(BitmapDescriptorFactory.defaultMarker(MarkersFactory.HUE_CREAM)));
        hidrometrosMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_HIDRO_2, LONGITUDE_HIDRO_2))
                .title(mContext.getString(R.string.hidrometros)).snippet(mContext.getString(R.string.d_hidrometro))
                .icon(BitmapDescriptorFactory.defaultMarker(MarkersFactory.HUE_CREAM)));
        hidrometrosMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_HIDRO_3, LONGITUDE_HIDRO_3))
                .title(mContext.getString(R.string.hidrometros)).snippet(mContext.getString(R.string.d_hidrometro))
                .icon(BitmapDescriptorFactory.defaultMarker(MarkersFactory.HUE_CREAM)));
        hidrometrosMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_HIDRO_4, LONGITUDE_HIDRO_4))
                .title(mContext.getString(R.string.hidrometros)).snippet(mContext.getString(R.string.d_hidrometro))
                .icon(BitmapDescriptorFactory.defaultMarker(MarkersFactory.HUE_CREAM)));
        hidrometrosMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_HIDRO_5, LONGITUDE_HIDRO_5))
                .title(mContext.getString(R.string.hidrometros)).snippet(mContext.getString(R.string.d_hidrometro))
                .icon(BitmapDescriptorFactory.defaultMarker(MarkersFactory.HUE_CREAM)));
        hidrometrosMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_HIDRO_6, LONGITUDE_HIDRO_6))
                .title(mContext.getString(R.string.hidrometros)).snippet(mContext.getString(R.string.d_hidrometro))
                .icon(BitmapDescriptorFactory.defaultMarker(MarkersFactory.HUE_CREAM)));

    }*/

    public void createPostosSaude() {
        postoSaudeMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_SAUDE_1, LONGITUDE_SAUDE_1))
                .title(mContext.getString(R.string.saude)).snippet(mContext.getString(R.string.d_saude_1))
                .icon(BitmapDescriptorFactory.defaultMarker(MarkersFactory.HUE_GOLD)));
        postoSaudeMarkers.add(new MarkerOptions()
                .position(new LatLng(LATITUDE_SAUDE_2, LONGITUDE_SAUDE_2))
                .title(mContext.getString(R.string.saude)).snippet(mContext.getString(R.string.d_saude_2))
                .icon(BitmapDescriptorFactory.defaultMarker(MarkersFactory.HUE_GOLD)));

    }

    public ArrayList<MarkerOptions> getEntradaMarkers() {
        return entradaMarkers;
    }

    public ArrayList<MarkerOptions> getSaidaEmergenciaMarkers() {
        return saidaEmergenciaMarkers;
    }

    public ArrayList<MarkerOptions> getPalcosMarkers() {
        return palcosMarkers;
    }

    public ArrayList<MarkerOptions> getIlhaDeForroMarkers() {
        return ilhaDeForroMarkers;
    }

    public ArrayList<MarkerOptions> getPontoTuristicoMarkers() {
        return pontoTuristicoMarkers;
    }

    public ArrayList<MarkerOptions> getBanheirosMarkers() {
        return banheirosMarkers;
    }

    public ArrayList<MarkerOptions> getRestaurantesMarkers() {
        return restaurantesMarkers;
    }

    public ArrayList<MarkerOptions> getQuiosquesMarkers() {
        return quiosquesMarkers;
    }

    public ArrayList<MarkerOptions> getBarracasMarkers() {
        return barracasMarkers;
    }

    public ArrayList<MarkerOptions> getBaresMarkers() {
        return baresMarkers;
    }

    public ArrayList<MarkerOptions> getPostoPolicialMarkers() {
        return postoPolicialMarkers;
    }

    public ArrayList<MarkerOptions> getPostoSaudeMarkers() {
        return postoSaudeMarkers;
    }

    public ArrayList<MarkerOptions> getBombeirosMarkers() {
        return bombeirosMarkers;
    }

    public ArrayList<MarkerOptions> getHidrometrosMarkers() {
        return hidrometrosMarkers;
    }

    public ArrayList<MarkerOptions> getTransporteMarkers() {
        return transporteMarkers;
    }
}
