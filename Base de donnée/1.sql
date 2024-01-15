DROP DATABASE IF EXISTS GameList;
CREATE DATABASE IF NOT EXISTS GameList;

USE GameList;

CREATE TABLE Utilisateurs (
    UserID INT AUTO_INCREMENT PRIMARY KEY,
    NomUtilisateur VARCHAR(255) NOT NULL UNIQUE,
    MotDePasse VARCHAR(255) NOT NULL,
    Email VARCHAR(255) NOT NULL UNIQUE,
    DateCreation DATETIME DEFAULT CURRENT_TIMESTAMP,
    Nom VARCHAR(255),
    Avatar VARCHAR(255)
);

-- Table pour les amis
CREATE TABLE Amis (
    AmiID INT AUTO_INCREMENT PRIMARY KEY,
    UtilisateurID INT,
    AmiUtilisateurID INT,
    FOREIGN KEY (UtilisateurID) REFERENCES Utilisateurs(UserID),
    FOREIGN KEY (AmiUtilisateurID) REFERENCES Utilisateurs(UserID)
);

-- Table pour les jeux vidéo
CREATE TABLE JeuxVideo (
    JeuID INT AUTO_INCREMENT PRIMARY KEY,
    Titre VARCHAR(255) NOT NULL,
    Description TEXT,
    DateSortie DATE,
    NoteMoyenne DECIMAL(3, 1), 
    Plateformes VARCHAR(255), 
    StudioID INT,
    CategorieID INT,
    FOREIGN KEY (StudioID) REFERENCES StudiosJeuxVideo(StudioID),
    FOREIGN KEY (CategorieID) REFERENCES CategoriesJeux(CategorieID)
);

-- Table pour les médias des jeux vidéo
CREATE TABLE MediasJeux (
    MediaID INT AUTO_INCREMENT PRIMARY KEY,
    JeuID INT,
    TypeMedia VARCHAR(255), 
    URLMedia VARCHAR(255), 
    FOREIGN KEY (JeuID) REFERENCES JeuxVideo(JeuID)
);

-- Table pour les studios de jeux vidéo
CREATE TABLE StudiosJeuxVideo (
    StudioID INT AUTO_INCREMENT PRIMARY KEY,
    NomStudio VARCHAR(255) NOT NULL,
    AnneeFondation INT,
    SiteWeb VARCHAR(255),
    PaysOrigine VARCHAR(255)
);

-- Table pour les catégories de jeux
CREATE TABLE CategoriesJeux (
    CategorieID INT AUTO_INCREMENT PRIMARY KEY,
    NomCategorie VARCHAR(255) NOT NULL
);

-- table pour les comptes de jeux vidéo
CREATE TABLE ComptesJeuxVideo (
    CompteID INT AUTO_INCREMENT PRIMARY KEY,
    UserID INT,
    JeuID INT,
    PseudoJeu VARCHAR(255) NOT NULL,
    Plateforme VARCHAR(255) NOT NULL,
    FOREIGN KEY (UserID) REFERENCES Utilisateurs(UserID),
    FOREIGN KEY (JeuID) REFERENCES JeuxVideo(JeuID)
);

-- table pour les filtes 
CREATE TABLE PreferencesUtilisateurs (
    PreferenceID INT AUTO_INCREMENT PRIMARY KEY,
    UserID INT,
    CategorieID INT,
    FOREIGN KEY (UserID) REFERENCES Utilisateurs(UserID),
    FOREIGN KEY (CategorieID) REFERENCES CategoriesJeux(CategorieID)
);

