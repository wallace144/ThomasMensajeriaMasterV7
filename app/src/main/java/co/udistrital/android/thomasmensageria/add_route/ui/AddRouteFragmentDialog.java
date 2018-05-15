package co.udistrital.android.thomasmensageria.add_route.ui;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import co.udistrital.android.thomasmensageria.R;
import co.udistrital.android.thomasmensageria.add_route.AddRoutePresenter;
import co.udistrital.android.thomasmensageria.add_route.AddRoutePresenterImpl;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddRouteFragmentDialog extends DialogFragment implements AddRouteView, DialogInterface.OnShowListener {

    private static final String BS_PACKAGE = "com.google.zxing.client.android";
    private static final int REQUEST_CODE = 24;

    @BindView(R.id.editTxtCode)
    EditText editTxtCode;
    @BindView(R.id.ivCodigo)
    ImageView ivCodigo;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    Unbinder unbinder;
    @BindView(R.id.editTextAdmin)
    EditText editTextAdmin;


    private AddRoutePresenter presenter;

    public AddRouteFragmentDialog() {
       presenter = new AddRoutePresenterImpl(this);
    }



    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setTitle(R.string.add_route_message_title)
                .setPositiveButton(R.string.add_route_message_add, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setNegativeButton(R.string.add_route_message_cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

        View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_add_route, null);
        unbinder = ButterKnife.bind(this, view);
        builder.setView(view);
        AlertDialog dialog = builder.create();
        dialog.setOnShowListener(this);
        return dialog;
    }




    @Override
    public void showInput() {
        this.editTxtCode.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideInput() {
        this.editTxtCode.setVisibility(View.GONE);
    }

    @Override
    public void showProgress() {
        this.progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        this.progressBar.setVisibility(View.GONE);
    }

    @Override
    public void routeAdded() {
        Toast.makeText(getActivity(), R.string.add_route_message_route_added, Toast.LENGTH_SHORT).show();
        dismiss();

    }

    @Override
    public void routeNotAdded() {
        editTxtCode.setText("");
        Toast.makeText(getContext(), R.string.add_route_error_message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.ivCodigo)
    public void addCodeBar() {
        try {
            Intent intent = new Intent(BS_PACKAGE + ".SCAN");
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

            intent.putExtra("SCAN_WIDTH", 1780);
            intent.putExtra("SCAN_HEIGHT", 1070);

            startActivityForResult(intent, REQUEST_CODE);

        } catch (Exception e) {
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == REQUEST_CODE) {
            if (resultCode == getActivity().RESULT_OK) {
                String content = intent.getStringExtra("SCAN_RESULT").trim();
                editTxtCode.setText(content);
            } else if (resultCode == getActivity().RESULT_CANCELED) {
            }
        }
    }


    @Override
    public void onShow(DialogInterface dialogInterface) {
        final AlertDialog dialog = (AlertDialog) getDialog();
        if (dialog != null) {
            Button positiveButton = dialog.getButton(Dialog.BUTTON_POSITIVE);
            Button negativeButton = dialog.getButton(Dialog.BUTTON_NEGATIVE);

            positiveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    presenter.addRoute(editTxtCode.getText().toString(), editTextAdmin.getText().toString());

                }
            });

            negativeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dismiss();
                }
            });
        }
        presenter.onShow();
    }

    @Override
    public void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }
}
