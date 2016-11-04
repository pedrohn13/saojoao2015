package br.edu.ufcg.embedded.saojoao.activity.fragments;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;

import br.edu.ufcg.embedded.saojoao.R;

/**
 * Created by Victor on 6/2/2015.
 */
public class MapDialogFragment extends DialogFragment {
    private CheckBox ckbxEnter;
    private CheckBox ckbxEmergency;
    private CheckBox ckbxStages;
    private CheckBox ckbxTuristic;
    private CheckBox ckbxIsland;
    private CheckBox ckbxBarraca;
    private CheckBox ckbxBar;
    private CheckBox ckbxRestaurant;
    private CheckBox ckbxKiosk;
    private CheckBox ckbxRestroom;
    private CheckBox ckbxTransporte;
    private CheckBox ckbxPolicia;
    private CheckBox ckbxBombeiro;
    //private CheckBox ckbxHidro;
    private CheckBox ckbxSaude;

    private Bundle saved;

    private Button btOk;
    private Button btCancel;
    private MapsFragment mapsFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        saved = savedInstanceState;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_dialog_maps, container, false);

        Window window = getDialog().getWindow();
        window.setTitle(getString(R.string.pinpoint));
        window.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);

        ckbxEnter = (CheckBox) rootView.findViewById(R.id.checkBoxEnter);
        ckbxEmergency = (CheckBox) rootView.findViewById(R.id.checkBoxEmergencyExit);
        ckbxStages = (CheckBox) rootView.findViewById(R.id.checkBoxStage);
        ckbxTuristic = (CheckBox) rootView.findViewById(R.id.checkBoxInteresting);
        ckbxIsland = (CheckBox) rootView.findViewById(R.id.checkBoxIsland);
        ckbxBarraca = (CheckBox) rootView.findViewById(R.id.checkBoxBarraca);
        ckbxBar = (CheckBox) rootView.findViewById(R.id.checkBoxBar);
        ckbxRestaurant = (CheckBox) rootView.findViewById(R.id.checkBoxRestaurant);
        ckbxKiosk = (CheckBox) rootView.findViewById(R.id.checkBoxKiosk);
        ckbxRestroom = (CheckBox) rootView.findViewById(R.id.checkBoxRestroom);
        ckbxTransporte = (CheckBox) rootView.findViewById(R.id.checkBoxTransport);
        ckbxPolicia = (CheckBox) rootView.findViewById(R.id.checkBoxPolicePoint);
        ckbxBombeiro = (CheckBox) rootView.findViewById(R.id.checkBoxFireMan);
        //ckbxHidro = (CheckBox) rootView.findViewById(R.id.checkHydro);
        ckbxSaude = (CheckBox) rootView.findViewById(R.id.checkBoxHealth);


        btOk = (Button) rootView.findViewById(R.id.bt_ok);
        btCancel = (Button) rootView.findViewById(R.id.bt_cancel);

        btOk.setOnClickListener(onBtClick);
        btCancel.setOnClickListener(onBtClick);
        //savedState = savedInstanceState;

        return rootView;
    }

    private Button.OnClickListener onBtClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.bt_ok:
                    if (!ckbxEnter.isChecked()) {
                        mapsFragment.removeMarkers(R.id.checkBoxEnter);
                    } else {
                        mapsFragment.setMarkers(R.id.checkBoxEnter);
                    }

                    if (!ckbxEmergency.isChecked()) {
                        mapsFragment.removeMarkers(R.id.checkBoxEmergencyExit);
                    } else {
                        mapsFragment.setMarkers(R.id.checkBoxEmergencyExit);
                    }

                    if (!ckbxStages.isChecked()) {
                        mapsFragment.removeMarkers(R.id.checkBoxStage);
                    } else {
                        mapsFragment.setMarkers(R.id.checkBoxStage);
                    }

                    if (!ckbxTuristic.isChecked()) {
                        mapsFragment.removeMarkers(R.id.checkBoxInteresting);
                    } else {
                        mapsFragment.setMarkers(R.id.checkBoxInteresting);
                    }

                    if (!ckbxIsland.isChecked()) {
                        mapsFragment.removeMarkers(R.id.checkBoxIsland);
                    } else {
                        mapsFragment.setMarkers(R.id.checkBoxIsland);
                    }

                    if (!ckbxBarraca.isChecked()) {
                        mapsFragment.removeMarkers(R.id.checkBoxBarraca);
                    } else {
                        mapsFragment.setMarkers(R.id.checkBoxBarraca);
                    }

                    if (!ckbxBar.isChecked()) {
                        mapsFragment.removeMarkers(R.id.checkBoxBar);
                    } else {
                        mapsFragment.setMarkers(R.id.checkBoxBar);
                    }

                    if (!ckbxRestaurant.isChecked()) {
                        mapsFragment.removeMarkers(R.id.checkBoxRestaurant);
                    } else {
                        mapsFragment.setMarkers(R.id.checkBoxRestaurant);
                    }

                    if (!ckbxKiosk.isChecked()) {
                        mapsFragment.removeMarkers(R.id.checkBoxKiosk);
                    } else {
                        mapsFragment.setMarkers(R.id.checkBoxKiosk);
                    }

                    if (!ckbxRestroom.isChecked()) {
                        mapsFragment.removeMarkers(R.id.checkBoxRestroom);
                    } else {
                        mapsFragment.setMarkers(R.id.checkBoxRestroom);
                    }

                    if (!ckbxTransporte.isChecked()) {
                        mapsFragment.removeMarkers(R.id.checkBoxTransport);
                    } else {
                        mapsFragment.setMarkers(R.id.checkBoxTransport);
                    }

                    if (!ckbxPolicia.isChecked()) {
                        mapsFragment.removeMarkers(R.id.checkBoxPolicePoint);
                    } else {
                        mapsFragment.setMarkers(R.id.checkBoxPolicePoint);
                    }

                    if (!ckbxBombeiro.isChecked()) {
                        mapsFragment.removeMarkers(R.id.checkBoxFireMan);
                    } else {
                        mapsFragment.setMarkers(R.id.checkBoxFireMan);
                    }

                   /* if (!ckbxHidro.isChecked()) {
                        mapsFragment.removeMarkers(R.id.checkHydro);
                    } else {
                        mapsFragment.setMarkers(R.id.checkHydro);
                    }*/

                    if (!ckbxSaude.isChecked()) {
                        mapsFragment.removeMarkers(R.id.checkBoxHealth);
                    } else {
                        mapsFragment.setMarkers(R.id.checkBoxHealth);
                    }
                    mapsFragment.hideMarkerDescription();
                case R.id.bt_cancel:
                    setChecked(saved);
                    getDialog().dismiss();
                    break;
                default:
                    break;
            }

        }
    };

    private void setChecked(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            ckbxEnter.setChecked(!mapsFragment.isEmpty(R.id.checkBoxEnter));
            ckbxEmergency.setChecked(!mapsFragment.isEmpty(R.id.checkBoxEmergencyExit));
            ckbxStages.setChecked(!mapsFragment.isEmpty(R.id.checkBoxStage));
            ckbxTuristic.setChecked(!mapsFragment.isEmpty(R.id.checkBoxInteresting));
            ckbxIsland.setChecked(!mapsFragment.isEmpty(R.id.checkBoxIsland));
            ckbxBarraca.setChecked(!mapsFragment.isEmpty(R.id.checkBoxBarraca));
            ckbxBar.setChecked(!mapsFragment.isEmpty(R.id.checkBoxBar));
            ckbxRestaurant.setChecked(!mapsFragment.isEmpty(R.id.checkBoxRestaurant));
            ckbxKiosk.setChecked(!mapsFragment.isEmpty(R.id.checkBoxKiosk));
            ckbxRestroom.setChecked(!mapsFragment.isEmpty(R.id.checkBoxRestroom));
            ckbxTransporte.setChecked(!mapsFragment.isEmpty(R.id.checkBoxTransport));
            ckbxPolicia.setChecked(!mapsFragment.isEmpty(R.id.checkBoxPolicePoint));
            ckbxBombeiro.setChecked(!mapsFragment.isEmpty(R.id.checkBoxFireMan));
           // ckbxHidro.setChecked(!mapsFragment.isEmpty(R.id.checkHydro));
            ckbxSaude.setChecked(!mapsFragment.isEmpty(R.id.checkBoxHealth));
        } else {
            ckbxEnter.setChecked(savedInstanceState.getBoolean("entradas"));
            ckbxEmergency.setChecked(savedInstanceState.getBoolean("emergencia"));
            ckbxStages.setChecked(savedInstanceState.getBoolean("palco"));
            ckbxTuristic.setChecked(savedInstanceState.getBoolean("interesse"));
            ckbxIsland.setChecked(savedInstanceState.getBoolean("ilha"));
            ckbxBarraca.setChecked(savedInstanceState.getBoolean("barraca"));
            ckbxBar.setChecked(savedInstanceState.getBoolean("bar"));
            ckbxRestaurant.setChecked(savedInstanceState.getBoolean("restaurante"));
            ckbxKiosk.setChecked(savedInstanceState.getBoolean("quiosque"));
            ckbxRestroom.setChecked(savedInstanceState.getBoolean("banheiro"));
            ckbxTransporte.setChecked(savedInstanceState.getBoolean("transporte"));
            ckbxPolicia.setChecked(savedInstanceState.getBoolean("policia"));
            ckbxBombeiro.setChecked(savedInstanceState.getBoolean("bombeiros"));
           // ckbxHidro.setChecked(savedInstanceState.getBoolean("hidrometro"));
            ckbxSaude.setChecked(savedInstanceState.getBoolean("saude"));

        }

    }

    public MapsFragment getMapsFragment() {
        return mapsFragment;
    }

    public void setMapsFragment(MapsFragment mapsFragment) {
        this.mapsFragment = mapsFragment;
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        setChecked(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("entradas", !mapsFragment.isEmpty(R.id.checkBoxEnter));
        outState.putBoolean("emergencia", !mapsFragment.isEmpty(R.id.checkBoxEmergencyExit));
        outState.putBoolean("palco", !mapsFragment.isEmpty(R.id.checkBoxStage));
        outState.putBoolean("interesse", !mapsFragment.isEmpty(R.id.checkBoxInteresting));
        outState.putBoolean("ilha", !mapsFragment.isEmpty(R.id.checkBoxIsland));
        outState.putBoolean("barraca", !mapsFragment.isEmpty(R.id.checkBoxBarraca));
        outState.putBoolean("bar", !mapsFragment.isEmpty(R.id.checkBoxBar));
        outState.putBoolean("restaurante", !mapsFragment.isEmpty(R.id.checkBoxRestaurant));
        outState.putBoolean("quiosque", !mapsFragment.isEmpty(R.id.checkBoxKiosk));
        outState.putBoolean("banheiro", !mapsFragment.isEmpty(R.id.checkBoxRestroom));
        outState.putBoolean("transporte", !mapsFragment.isEmpty(R.id.checkBoxTransport));
        outState.putBoolean("policia", !mapsFragment.isEmpty(R.id.checkBoxPolicePoint));
        outState.putBoolean("bombeiros", !mapsFragment.isEmpty(R.id.checkBoxFireMan));
        //outState.putBoolean("hidrometro", !mapsFragment.isEmpty(R.id.checkHydro));
        outState.putBoolean("saude", !mapsFragment.isEmpty(R.id.checkBoxHealth));
    }
}
