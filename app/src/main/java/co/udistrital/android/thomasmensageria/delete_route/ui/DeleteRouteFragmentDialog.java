package co.udistrital.android.thomasmensageria.delete_route.ui;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.View;
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

import co.udistrital.android.thomasmensageria.delete_route.DeleteRoutePresenter;
import co.udistrital.android.thomasmensageria.delete_route.DeleteRoutePresenterImpl;

/**
 * A simple {@link Fragment} subclass.
 */
public class DeleteRouteFragmentDialog extends DialogFragment implements DeleteRouteView, DialogInterface.OnShowListener  {


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


    private int id_guia;
    private DeleteRoutePresenter presenter;


    public DeleteRouteFragmentDialog() {
        presenter = new DeleteRoutePresenterImpl(this);
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setTitle(R.string.delete_route_message_title)
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
        hideIcon();
        return dialog;
    }

    private void hideIcon() {
        ivCodigo.setVisibility(View.INVISIBLE);
        editTxtCode.setEnabled(false);
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
    public void routeDeleted() {
        Toast.makeText(getActivity(), R.string.add_route_message_route_added, Toast.LENGTH_SHORT).show();
        dismiss();

    }

    @Override
    public void routeNotDeleted() {
        editTxtCode.setText("");
        Toast.makeText(getContext(), R.string.add_route_error_message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onShow(DialogInterface dialogInterface) {
        final AlertDialog dialog = (AlertDialog) getDialog();
        if (dialog != null) {
            editTxtCode.setText(""+this.id_guia);
            Button positiveButton = dialog.getButton(Dialog.BUTTON_POSITIVE);
            Button negativeButton = dialog.getButton(Dialog.BUTTON_NEGATIVE);

            positiveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    presenter.deleteRoute(editTxtCode.getText().toString(), editTextAdmin.getText().toString());
                    dismiss();

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

    public void setId_guia(int id_guia) {
        this.id_guia = id_guia;
    }
}
