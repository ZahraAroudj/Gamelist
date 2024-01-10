package com.example.myapplication.data;

import java.util.regex.Pattern;

public class UserBean {

    private String name;

    private String email;

    private String password;

    private String confirmPassword;

    private int id = -1;

    public String getConfirmPassword() {
        return confirmPassword;
    }


    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    // Constructeur pour la classe UserBean.
    public UserBean(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    // Constructeur pour la classe UserBean avec ID.
    public UserBean(int id, String name, String email, String password) {
        this(name, email, password);
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (isValidEmail(email)) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Format d'email invalide");
        }
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        if (isValidPassword(password)) {
            this.password = password;
        } else {
            throw new IllegalArgumentException("Mot de passe invalide");
        }
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Méthode pour vérifier si l'email est valide.
    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    // Méthode pour vérifier si le mot de passe est valide.
    private boolean isValidPassword(String password) {
        return password.length() >= 8;
    }

    // Surcharge de la méthode toString pour afficher les informations de l'utilisateur.
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                '}';
    }
}



