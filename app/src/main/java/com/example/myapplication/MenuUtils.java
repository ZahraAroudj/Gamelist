package com.example.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

public class MenuUtils {
    void showMenuDialog(final Context context) {
        final String[] menuOptions = {"Accueil", "Top", "Communauté", "Compte", "Paramètre",  "Recherche", "Deconnexion"};

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Menu")
                .setItems(menuOptions, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                // Accueil
                                // Rafraîchir la page actuelle
                                Intent refreshIntent = new Intent(context, context.getClass());
                                context.startActivity(refreshIntent);
                                context.startActivity(new Intent(context, AccueilActivity.class));
                                break;

                            case 1:
                                // Top
                                context.startActivity(new Intent(context, TopActivity.class));
                                break;
                            case 2:
                                // Communauté
                                context.startActivity(new Intent(context, CommunauteActivity.class));
                                break;
                            case 3:
                                // Compte
                                context.startActivity(new Intent(context, CompteActivity.class));
                                break;
                            case 4:
                                // Paramètre
                                context.startActivity(new Intent(context, ParametreActivity.class));
                                break;
                            case 5:
                                // Connexion
                                context.startActivity(new Intent(context, RechercheActivity.class));
                                break;
                            case 6:
                                // recherche
                                context.startActivity(new Intent(context, LoginActivity.class));
                                break;


                        }
                    }
                });
        builder.create().show();
    }
}
