package com.ozika.ifto.exemploalertdialogfragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;
import java.util.List;

public class MyDialogFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
//        return super.onCreateDialog(savedInstanceState);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getLayoutInflater();
        View v = inflater.inflate(R.layout.dialog, null);
        builder.setView(v)
                .setTitle("Personalizado")
                .setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText editTextNome = v.findViewById(R.id.edit_text);
                        String nome = editTextNome.getText().toString();
                        Toast.makeText(getActivity().getApplicationContext(), nome, Toast.LENGTH_SHORT).show();
                    }
                });
        return  builder.create();
    }
//    @NonNull
//    @Override
//    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
////        return super.onCreateDialog(savedInstanceState);
//        List<String> itens = new ArrayList<>();
//        Resources resources = getResources();
//        String[] planets = resources.getStringArray(R.array.planets);
//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//    builder.setTitle("Planetas")
//            .setMultiChoiceItems(R.array.planets, null, new DialogInterface.OnMultiChoiceClickListener() {
//                @Override
//                public void onClick(DialogInterface dialogInterface, int i, boolean b) {
//                          if(b){
//                              itens.add(planets[i]);
//                          }else {
//                              itens.remove(planets[i]);
//                          }
//                }
//            })
//        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                Toast.makeText(getActivity().getApplicationContext(),itens.toString(),Toast.LENGTH_SHORT).show();
//            }
//        });
//        return builder.create();
//    }

    //    @NonNull
//    @Override
//    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
////        return super.onCreateDialog(savedInstanceState);
//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//        builder.setTitle("Escolha um dia da semana")
//                .setIcon(R.mipmap.ic_launcher)
//                .setItems(R.array.semana, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Toast.makeText(getActivity(),
//                                        recuperarItem(i), Toast.LENGTH_SHORT).show();
//                            }
//                });
//        return builder.create();
//    }
//
//    private String recuperarItem(int i) {
//        Resources resources = getResources();
//        String[] dias_semana = resources.getStringArray(R.array.semana);
//        return dias_semana[i];
//    }

    //    @NonNull
//    @Override
//    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
//        //return super.onCreateDialog(savedInstanceState);
//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//        builder.setTitle("Hello")
//                .setCancelable(false)
//                .setMessage("Como estar o clima hoje ")
//                .setIcon(R.mipmap.ic_launcher)
//                .setPositiveButton("Quente",
//                        new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//                                Toast.makeText(getActivity(),
//                                        "beba muita agua", Toast.LENGTH_SHORT).show();
//                            }
//                        })
//                .setNegativeButton("Frio", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Toast.makeText(getActivity(),
//                                "coloque uma jaqueta", Toast.LENGTH_SHORT).show();
//                    }
//                })
//                .setNeutralButton("Bom", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Toast.makeText(getActivity(),
//                                "Aproveite", Toast.LENGTH_SHORT).show();
//                    }
//                });
//        return builder.create();
//    }
}
