package br.edu.ufcg.embedded.saojoao.activity.fragments;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import br.edu.ufcg.embedded.saojoao.R;
import br.edu.ufcg.embedded.saojoao.utils.MarkersFactory;

/**
 * Created by Pedro on 01/06/2015.
 */
public class MapsFragment extends Fragment implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    public static final double LATITUDE_PP = -7.2236957;
    public static final double LONGITUDE_PP = -35.8878092;
    public static final double LATITUDE_NORTHEAST_IMAGE = -7.2221133;
    public static final double LONGITUDE_NORTHEAST_IMAGE = -35.8857042;
    public static final double LATITUDE_SOUTHWEST_IMAGE = -7.2259440;
    public static final double LONGITUDE_SOUTHWEST_IMAGE = -35.889090;
    public static final float ZOOM_SCALE = 17.5f;
    public static final float TRANSPARENCY_OVERLAY = 0.2f;
    private static Context mContext;
    private MarkersFactory markersFactory;
    private SupportMapFragment mMapFragment;
    private LatLng ppLocation;
    private boolean isMarkerSelected;
    private boolean myLocationWasClicked;
    private View rootView;
    private GoogleMap mMap;
    private LatLng myLocation;
    private Location mLocation;
    private final GoogleMap.OnMyLocationChangeListener mLocationListener = new GoogleMap.OnMyLocationChangeListener() {
        @Override
        public void onMyLocationChange(Location location) {
            myLocation = new LatLng(location.getLatitude(), location.getLongitude());
            mLocation = location;
            if (myLocationWasClicked) {
                myLocationWasClicked = false;
                moveToMyLocation();
            }
        }
    };
    private Activity parentActivity;
    private boolean goingToHome;
    private ArrayList<Marker> entradaMarkers;
    private ArrayList<Marker> saidaEmergenciaMarkers;
    private ArrayList<Marker> ilhaDeForroMarkers;
    private ArrayList<Marker> palcosMarkers;
    private ArrayList<Marker> banheirosMarkers;
    private ArrayList<Marker> restaurantesMarkers;
    private ArrayList<Marker> quiosquesMarkers;
    private ArrayList<Marker> barracasMarkers;
    private ArrayList<Marker> baresMarkers;
    private ArrayList<Marker> postoPolicialMarkers;
    private ArrayList<Marker> postoSaudeMarkers;
    private ArrayList<Marker> pontoTuristicoMarkers;
    private ArrayList<Marker> bombeirosMarkers;
    private ArrayList<Marker> hidrometrosMarkers;
    private ArrayList<Marker> transporteMarkers;
    private GroundOverlayOptions groundOverlayOptions;
    private Bundle saved;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMapFragment = SupportMapFragment.newInstance();
        mMap = mMapFragment.getMap();
        ppLocation = new LatLng(LATITUDE_PP, LONGITUDE_PP);
        entradaMarkers = new ArrayList<Marker>();
        saidaEmergenciaMarkers = new ArrayList<Marker>();
        ilhaDeForroMarkers = new ArrayList<Marker>();
        palcosMarkers = new ArrayList<Marker>();
        banheirosMarkers = new ArrayList<Marker>();
        restaurantesMarkers = new ArrayList<Marker>();
        quiosquesMarkers = new ArrayList<Marker>();
        barracasMarkers = new ArrayList<Marker>();
        baresMarkers = new ArrayList<Marker>();
        postoPolicialMarkers = new ArrayList<Marker>();
        postoSaudeMarkers = new ArrayList<Marker>();
        pontoTuristicoMarkers = new ArrayList<Marker>();
        bombeirosMarkers = new ArrayList<Marker>();
        hidrometrosMarkers = new ArrayList<Marker>();
        transporteMarkers = new ArrayList<Marker>();

        mContext = getActivity();
        MapsInitializer.initialize(mContext);
        groundOverlayOptions = createGroundOverlay();
        markersFactory = new MarkersFactory(mContext);
        parentActivity = getActivity();

        saved = savedInstanceState;


    }

    public boolean isEmpty(int arrayTypeId) {
        switch (arrayTypeId) {
            case R.id.checkBoxEnter:
                return entradaMarkers.isEmpty();
            case R.id.checkBoxEmergencyExit:
                return saidaEmergenciaMarkers.isEmpty();
            case R.id.checkBoxStage:
                return palcosMarkers.isEmpty();
            case R.id.checkBoxInteresting:
                return pontoTuristicoMarkers.isEmpty();
            case R.id.checkBoxIsland:
                return ilhaDeForroMarkers.isEmpty();
            case R.id.checkBoxBarraca:
                return barracasMarkers.isEmpty();
            case R.id.checkBoxBar:
                return baresMarkers.isEmpty();
            case R.id.checkBoxRestaurant:
                return restaurantesMarkers.isEmpty();
            case R.id.checkBoxKiosk:
                return quiosquesMarkers.isEmpty();
            case R.id.checkBoxRestroom:
                return banheirosMarkers.isEmpty();
            case R.id.checkBoxTransport:
                return transporteMarkers.isEmpty();
            case R.id.checkBoxPolicePoint:
                return postoPolicialMarkers.isEmpty();
            case R.id.checkBoxFireMan:
                return bombeirosMarkers.isEmpty();
            //case R.id.checkHydro:
            //  return hidrometrosMarkers.isEmpty();
            case R.id.checkBoxHealth:
                return postoSaudeMarkers.isEmpty();
            default:
                return true;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_maps, container, false);
        if (!isNetworkAvailable()) {
            displayPromptForEnablingInternet();
        }

        setUpMapIfNeeded();

        final LocationManager manager = (LocationManager) mContext.getSystemService(Context.LOCATION_SERVICE);
        rootView.findViewById(R.id.action_b).setOnClickListener(new View.OnClickListener() {

                                                                    @Override
                                                                    public void onClick(View view) {

                                                                        if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) { //if gps is disabled
                                                                            myLocationWasClicked = true;
                                                                            displayPromptForEnablingGPS();
                                                                            // startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                                                                        } else if (myLocation == null) {
                                                                            myLocationWasClicked = true;
                                                                            Toast.makeText(getActivity(), getString(R.string.carregando_localizacao), Toast.LENGTH_LONG).show();
                                                                            //loadMyLocation();
                                                                        } else {
                                                                            moveToMyLocation();

                                                                        }

                                                                    }
                                                                }

        );
        rootView.findViewById(R.id.action_c).

                setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {
                                           CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(ppLocation, ZOOM_SCALE);
                                           mMap.animateCamera(cameraUpdate);
                                       }
                                   }


                );

        return rootView;
    }

    private void moveToMyLocation() {
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(myLocation, ZOOM_SCALE);
        mMap.animateCamera(cameraUpdate);
    }

    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMapFragment = SupportMapFragment.newInstance();
            FragmentTransaction fragmentTransaction =
                    getFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.map_container, mMapFragment);
            fragmentTransaction.commit();
            mMapFragment.getMapAsync(this);

        }
    }

    public void removeMarkers(int idTipoMap) {
        switch (idTipoMap) {
            case R.id.checkBoxEnter:
                for (Marker marker : entradaMarkers) {
                    marker.remove();
                }
                entradaMarkers.clear();
                break;
            case R.id.checkBoxEmergencyExit:
                for (Marker marker : saidaEmergenciaMarkers) {
                    marker.remove();
                }
                saidaEmergenciaMarkers.clear();
                break;
            case R.id.checkBoxStage:
                for (Marker marker : palcosMarkers) {
                    marker.remove();
                }
                palcosMarkers.clear();
                break;
            case R.id.checkBoxInteresting:
                for (Marker marker : pontoTuristicoMarkers) {
                    marker.remove();
                }
                pontoTuristicoMarkers.clear();
                break;
            case R.id.checkBoxIsland:
                for (Marker marker : ilhaDeForroMarkers) {
                    marker.remove();
                }
                ilhaDeForroMarkers.clear();
                break;

            case R.id.checkBoxBarraca:
                for (Marker marker : barracasMarkers) {
                    marker.remove();
                }
                barracasMarkers.clear();
                break;

            case R.id.checkBoxBar:
                for (Marker marker : baresMarkers) {
                    marker.remove();
                }
                baresMarkers.clear();
                break;
            case R.id.checkBoxRestaurant:
                for (Marker marker : restaurantesMarkers) {
                    marker.remove();
                }
                restaurantesMarkers.clear();
                break;
            case R.id.checkBoxKiosk:
                for (Marker marker : quiosquesMarkers) {
                    marker.remove();
                }
                quiosquesMarkers.clear();
                break;
            case R.id.checkBoxRestroom:
                for (Marker marker : banheirosMarkers) {
                    marker.remove();
                }
                banheirosMarkers.clear();
                break;
            case R.id.checkBoxTransport:
                for (Marker marker : transporteMarkers) {
                    marker.remove();
                }
                transporteMarkers.clear();
                break;
            case R.id.checkBoxPolicePoint:
                for (Marker marker : postoPolicialMarkers) {
                    marker.remove();
                }
                postoPolicialMarkers.clear();
                break;
            case R.id.checkBoxFireMan:
                for (Marker marker : bombeirosMarkers) {
                    marker.remove();
                }
                bombeirosMarkers.clear();
                break;
            /*case R.id.checkHydro:
                for (Marker marker : hidrometrosMarkers) {
                    marker.remove();
                }
                hidrometrosMarkers.clear();
                break;*/
            case R.id.checkBoxHealth:
                for (Marker marker : postoSaudeMarkers) {
                    marker.remove();
                }
                postoSaudeMarkers.clear();
                break;
            default:
                break;
        }
    }

    public void setMarkers(int idTipoMap) {
        switch (idTipoMap) {
            case R.id.checkBoxEnter:
                for (MarkerOptions markerOptions : markersFactory.getEntradaMarkers()) {
                    entradaMarkers.add(mMap.addMarker(markerOptions));
                }
                break;
            case R.id.checkBoxEmergencyExit:
                for (MarkerOptions markerOptions : markersFactory.getSaidaEmergenciaMarkers()) {
                    saidaEmergenciaMarkers.add(mMap.addMarker(markerOptions));
                }
                break;
            case R.id.checkBoxStage:
                for (MarkerOptions markerOptions : markersFactory.getPalcosMarkers()) {
                    palcosMarkers.add(mMap.addMarker(markerOptions));
                }
                break;
            case R.id.checkBoxInteresting:
                for (MarkerOptions markerOptions : markersFactory.getPontoTuristicoMarkers()) {
                    pontoTuristicoMarkers.add(mMap.addMarker(markerOptions));
                }
                break;
            case R.id.checkBoxIsland:
                for (MarkerOptions markerOptions : markersFactory.getIlhaDeForroMarkers()) {
                    ilhaDeForroMarkers.add(mMap.addMarker(markerOptions));
                }
                break;
            case R.id.checkBoxBarraca:
                for (MarkerOptions markerOptions : markersFactory.getBarracasMarkers()) {
                    barracasMarkers.add(mMap.addMarker(markerOptions));
                }
                break;
            case R.id.checkBoxBar:
                for (MarkerOptions markerOptions : markersFactory.getBaresMarkers()) {
                    baresMarkers.add(mMap.addMarker(markerOptions));
                }
                break;
            case R.id.checkBoxRestaurant:
                for (MarkerOptions markerOptions : markersFactory.getRestaurantesMarkers()) {
                    restaurantesMarkers.add(mMap.addMarker(markerOptions));
                }
                break;
            case R.id.checkBoxKiosk:
                for (MarkerOptions markerOptions : markersFactory.getQuiosquesMarkers()) {
                    quiosquesMarkers.add(mMap.addMarker(markerOptions));
                }
                break;
            case R.id.checkBoxRestroom:
                for (MarkerOptions markerOptions : markersFactory.getBanheirosMarkers()) {
                    banheirosMarkers.add(mMap.addMarker(markerOptions));
                }
                break;
            case R.id.checkBoxTransport:
                for (MarkerOptions markerOptions : markersFactory.getTransporteMarkers()) {
                    transporteMarkers.add(mMap.addMarker(markerOptions));
                }
                break;
            case R.id.checkBoxPolicePoint:
                for (MarkerOptions markerOptions : markersFactory.getPostoPolicialMarkers()) {
                    postoPolicialMarkers.add(mMap.addMarker(markerOptions));
                }
                break;
            case R.id.checkBoxFireMan:
                for (MarkerOptions markerOptions : markersFactory.getBombeirosMarkers()) {
                    bombeirosMarkers.add(mMap.addMarker(markerOptions));
                }
                break;
            /*case R.id.checkHydro:
                for (MarkerOptions markerOptions : markersFactory.getHidrometrosMarkers()) {
                    hidrometrosMarkers.add(mMap.addMarker(markerOptions));
                }
                break;*/
            case R.id.checkBoxHealth:
                for (MarkerOptions markerOptions : markersFactory.getPostoSaudeMarkers()) {
                    postoSaudeMarkers.add(mMap.addMarker(markerOptions));
                }
                break;
            default:
                break;
        }

    }

    public void setUpMap() {
        try {
            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
            transaction.replace(R.id.map_container, mMapFragment).commit();
        } catch (IllegalStateException excep) {
            excep.printStackTrace();
        }

        mMap.setMyLocationEnabled(true);

        //Move camera para o parque do povo
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(ppLocation, ZOOM_SCALE);
        mMap.moveCamera(cameraUpdate);


        //Cria GroundOverlay
        mMap.addGroundOverlay(groundOverlayOptions);

        mMap.setOnMyLocationChangeListener(mLocationListener);

        mMap.getUiSettings().setMyLocationButtonEnabled(false);
        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setMapToolbarEnabled(false);

        mMap.setOnMarkerClickListener(this);

        View parteTotalView = (View) rootView.findViewById(R.id.tela_total);
        parteTotalView.setVisibility(View.INVISIBLE);
        View parte1View = (View) rootView.findViewById(R.id.tela_parte1);
        disable(parte1View);
        View parte2View = (View) rootView.findViewById(R.id.tela_parte2);
        disable(parte2View);
        View parte3View = (View) rootView.findViewById(R.id.tela_parte3);
        disable(parte3View);
        View parte4View = (View) rootView.findViewById(R.id.tela_parte4);
        disable(parte4View);
        View parte5View = (View) rootView.findViewById(R.id.tela_parte5);
        disable(parte5View);
        View parte6View = (View) rootView.findViewById(R.id.tela_parte6);
        disable(parte6View);
        View parte7View = (View) rootView.findViewById(R.id.tela_parte7);
        disable(parte7View);


    }

    private void restoreMarkers(Bundle savedInstanceState) {
        if (savedInstanceState.getBoolean("entradas")) {
            setMarkers(R.id.checkBoxEnter);
        }
        if (savedInstanceState.getBoolean("emergencia")) {
            setMarkers(R.id.checkBoxEmergencyExit);
        }
        if (savedInstanceState.getBoolean("palco")) {
            setMarkers(R.id.checkBoxStage);
        }
        if (savedInstanceState.getBoolean("interesse")) {
            setMarkers(R.id.checkBoxInteresting);
        }
        if (savedInstanceState.getBoolean("ilha")) {
            setMarkers(R.id.checkBoxIsland);
        }
        if (savedInstanceState.getBoolean("barraca")) {
            setMarkers(R.id.checkBoxBarraca);
        }
        if (savedInstanceState.getBoolean("bar")) {
            setMarkers(R.id.checkBoxBar);
        }
        if (savedInstanceState.getBoolean("restaurante")) {
            setMarkers(R.id.checkBoxRestaurant);
        }
        if (savedInstanceState.getBoolean("quiosque")) {
            setMarkers(R.id.checkBoxKiosk);
        }
        if (savedInstanceState.getBoolean("banheiro")) {
            setMarkers(R.id.checkBoxRestroom);
        }
        if (savedInstanceState.getBoolean("transporte")) {
            setMarkers(R.id.checkBoxTransport);
        }
        if (savedInstanceState.getBoolean("policia")) {
            setMarkers(R.id.checkBoxPolicePoint);
        }
        if (savedInstanceState.getBoolean("bombeiros")) {
            setMarkers(R.id.checkBoxFireMan);
        }
       /* if (savedInstanceState.getBoolean("hidrometro")) {
            setMarkers(R.id.checkHydro);
        }*/
        if (savedInstanceState.getBoolean("saude")) {
            setMarkers(R.id.checkBoxHealth);
        }
        isMarkerSelected = savedInstanceState.getBoolean("isMarkerSelected");
        myLocationWasClicked = savedInstanceState.getBoolean("myLocationWasClicked");
    }

    private GroundOverlayOptions createGroundOverlay() {
        BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.fromResource(R.drawable.moldura01);
        LatLng northEast = new LatLng(LATITUDE_NORTHEAST_IMAGE, LONGITUDE_NORTHEAST_IMAGE);
        LatLng southWest = new LatLng(LATITUDE_SOUTHWEST_IMAGE, LONGITUDE_SOUTHWEST_IMAGE);
        LatLngBounds latLngBounds = new LatLngBounds(southWest, northEast);
        GroundOverlayOptions groundOverlayOptionsAux = new GroundOverlayOptions();
        groundOverlayOptionsAux.positionFromBounds(latLngBounds);
        groundOverlayOptionsAux.image(bitmapDescriptor);
        groundOverlayOptionsAux.transparency(TRANSPARENCY_OVERLAY);
        return groundOverlayOptionsAux;
    }

    private void disable(View parte1View) {
        final View parteTotalView = (View) rootView.findViewById(R.id.tela_total);
        final FloatingActionsMenu floatingActionsMenu = (FloatingActionsMenu) rootView.findViewById(R.id.multiple_actions);


        parte1View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (parteTotalView.getVisibility() == View.VISIBLE) {
                    parteTotalView.setVisibility(View.INVISIBLE);
                    floatingActionsMenu.setVisibility(View.VISIBLE);

                }
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (mMap != null) {
            setUpMap();
            if (saved != null) {
                restoreMarkers(saved);
            }
        }
    }

    @Override
    public boolean onMarkerClick(Marker markerAux) {

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(markerAux.getPosition())
                .zoom(mMap.getCameraPosition().zoom)
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        View parteTotalView = (View) rootView.findViewById(R.id.tela_total);
        FloatingActionsMenu floatingActionsMenu = (FloatingActionsMenu) rootView.findViewById(R.id.multiple_actions);
        parteTotalView.setVisibility(View.VISIBLE);
        floatingActionsMenu.setVisibility(View.INVISIBLE);
        isMarkerSelected = true;
        parteTotalView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });


        preencheCaixa(markerAux);
        return true;
    }

    private void preencheCaixa(final Marker markerAux) {
        TextView tvNome = ((TextView) rootView.findViewById(R.id.nomeDialog));
        tvNome.setText(markerAux.getTitle());
        TextView tvDescricao = ((TextView) rootView.findViewById(R.id.nomeDescription));
        tvDescricao.setText(markerAux.getSnippet());
        ImageView ivRota = ((ImageView) rootView.findViewById(R.id.iv_rota));
        TextView ivRotaName = ((TextView) rootView.findViewById(R.id.iv_rota_name));

        View.OnClickListener onTracarClick = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tracar(markerAux);
            }
        };

        ivRota.setOnClickListener(onTracarClick);
        ivRotaName.setOnClickListener(onTracarClick);
    }

    private void tracar(final Marker markerAux) {
        final LocationManager manager = (LocationManager) mContext.getSystemService(Context.LOCATION_SERVICE);
        if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) { //if gps is disabled
            displayPromptForEnablingGPS();
        } else {
            new TracaRota().execute(markerAux);
        }
    }

    public boolean isGoingToHome() {
        return goingToHome;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.findItem(R.id.action_location).setVisible(false);
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void displayPromptForEnablingInternet() {
        final AlertDialog.Builder builder =
                new AlertDialog.Builder(parentActivity);
        final String actionWifiSettings = Settings.ACTION_WIFI_SETTINGS;
        final String actionWirelessSettings = Settings.ACTION_WIRELESS_SETTINGS;
        final String message = getString(R.string.enable_network);

        builder.setMessage(message)
                .setPositiveButton(getString(R.string.bt_wifi),
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int idButton) {
                                parentActivity.startActivity(new Intent(actionWifiSettings));
                                dialog.dismiss();
                            }
                        })
                .setNegativeButton(getString(R.string.bt_mobile_network),
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int idButton) {
                                parentActivity.startActivity(new Intent(actionWirelessSettings));
                                dialog.dismiss();
                            }
                        })
                .setNeutralButton(getString(R.string.bt_cancel),
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int idButton) {
                                dialog.cancel();
                            }
                        });
        builder.create().show();
    }

    public void displayPromptForEnablingGPS() {
        final AlertDialog.Builder builder =
                new AlertDialog.Builder(parentActivity);
        final String action = Settings.ACTION_LOCATION_SOURCE_SETTINGS;
        final String message = getString(R.string.enable_gps);

        builder.setMessage(message)
                .setPositiveButton(getString(R.string.bt_ok),
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int idButton) {
                                parentActivity.startActivity(new Intent(action));
                                dialog.dismiss();
                            }
                        })
                .setNegativeButton(getString(R.string.bt_cancel),
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int idButton) {
                                dialog.cancel();
                            }
                        });
        builder.create().show();
    }

    public void backPressed() {

        if (isMarkerSelected) {
            isMarkerSelected = false;
            hideMarkerDescription();

        } else {
            goingToHome = true;
            getActivity().onBackPressed();

        }
    }

    public void hideMarkerDescription() {
        View parteTotalView = (View) rootView.findViewById(R.id.tela_total);
        FloatingActionsMenu floatingActionsMenu = (FloatingActionsMenu) rootView.findViewById(R.id.multiple_actions);
        parteTotalView.setVisibility(View.INVISIBLE);
        floatingActionsMenu.setVisibility(View.VISIBLE);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("entradas", !isEmpty(R.id.checkBoxEnter));
        outState.putBoolean("emergencia", !isEmpty(R.id.checkBoxEmergencyExit));
        outState.putBoolean("palco", !isEmpty(R.id.checkBoxStage));
        outState.putBoolean("interesse", !isEmpty(R.id.checkBoxInteresting));
        outState.putBoolean("ilha", !isEmpty(R.id.checkBoxIsland));
        outState.putBoolean("barraca", !isEmpty(R.id.checkBoxBarraca));
        outState.putBoolean("bar", !isEmpty(R.id.checkBoxBar));
        outState.putBoolean("restaurante", !isEmpty(R.id.checkBoxRestaurant));
        outState.putBoolean("quiosque", !isEmpty(R.id.checkBoxKiosk));
        outState.putBoolean("banheiro", !isEmpty(R.id.checkBoxRestroom));
        outState.putBoolean("transporte", !isEmpty(R.id.checkBoxTransport));
        outState.putBoolean("policia", !isEmpty(R.id.checkBoxPolicePoint));
        outState.putBoolean("bombeiros", !isEmpty(R.id.checkBoxFireMan));
        //outState.putBoolean("hidrometro", !isEmpty(R.id.checkHydro));
        outState.putBoolean("saude", !isEmpty(R.id.checkBoxHealth));
        outState.putBoolean("isMarkerSelected", isMarkerSelected);
        outState.putBoolean("myLocationWasClicked", myLocationWasClicked);
    }

    private class TracaRota extends AsyncTask<Marker, Void, Location> {

        private Marker markerAsync;
        private ProgressDialog dialog;
        private boolean locationIsNull = true;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = ProgressDialog.show(getActivity(),
                    "Aguarde", "Estamos capturando sua posição");
            dialog.setCancelable(true);
        }

        @Override
        protected Location doInBackground(Marker... params) {
            markerAsync = params[0];

            while (locationIsNull) {
                locationIsNull = mLocation == null;
            }
            return mLocation;
        }

        @Override
        protected void onPostExecute(Location myActualLocation) {
            super.onPostExecute(myActualLocation);
            LatLng markerPosition = markerAsync.getPosition();
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://maps.google.com/maps?saddr=" + myActualLocation.getLatitude() + "," + myActualLocation.getLongitude()
                            + "&daddr=" + markerPosition.latitude + "," + markerPosition.longitude));
            intent.setComponent(new ComponentName("com.google.android.apps.maps",
                    "com.google.android.maps.MapsActivity"));
            myLocation = null;
            dialog.dismiss();
            startActivity(intent);
        }
    }

    public static Context getContext() {
        return mContext;
    }


}
