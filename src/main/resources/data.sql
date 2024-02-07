-- Initialisation des tables
INSERT INTO Employe(matricule, nom, email) VALUES
    (1, 'Elyes Lamine', 'Elyes.Lamine@univ-jfc.fr'),
    (2, 'Rémi Bastide', 'Remi.Bastide@univ-jfc.fr');

INSERT INTO Employe(matricule, superieur_matricule, nom, email) VALUES
    (3, (SELECT matricule FROM Employe WHERE nom like '%Bas%'), 'Jean-Marie Pécatte', 'jean-marie.pecatte@univ-jfc.fr'),
    (4, (SELECT matricule FROM Employe WHERE nom like '%Lam%'), 'Nicolas Singer', 'nicolas.singer@univ-jfc.fr');

-- On peut fixer les clés auto-générées, mais il faut ensuite
-- réinitialiser le compteur de clé auto-générée
-- Attention : la syntaxe est différente selon le SGBD utilisé
-- Ici la syntaxe pour le SGBD H2
ALTER TABLE Employe ALTER COLUMN matricule RESTART WITH 4;

INSERT INTO Projet(nom, debut, fin) VALUES
    ('Projet 1', '2019-01-01', '2019-12-31'),
    ('Projet 2', '2019-02-01', null),
    ('Projet 3', '2019-03-01', null);

INSERT INTO Participation(id, affectation_code, contributeur_matricule, pourcentage, role) VALUES
    (default, (SELECT code FROM Projet WHERE nom LIKE '%1%'), (SELECT matricule FROM Employe WHERE nom like '%Lamine%'), 50, 'Directeur de projet'),
    (default, (SELECT code FROM Projet WHERE nom LIKE '%1%'), (SELECT matricule FROM Employe WHERE nom like '%Bastide%'), 25, 'Developpeur backend'),
    (default, (SELECT code FROM Projet WHERE nom LIKE '%1%'), (SELECT matricule FROM Employe WHERE nom like '%P%catte%'), 25, 'Developpeur frontend'),
    (default, (SELECT code FROM Projet WHERE nom LIKE '%2%'), (SELECT matricule FROM Employe WHERE nom like '%Lamine%'), 75, 'Chef de projet'),
    (default, (SELECT code FROM Projet WHERE nom LIKE '%2%'), (SELECT matricule FROM Employe WHERE nom like '%Bastide%'), 25, 'Developpeur fullstack'),
    (default, (SELECT code FROM Projet WHERE nom LIKE '%3%'), (SELECT matricule FROM Employe WHERE nom like '%P%catte%'), 100, 'Responsable projet');

INSERT INTO Administratif (matricule, diplome) VALUES
    ((SELECT matricule FROM Employe WHERE nom like '%Lamine%'), 'Master Informatique');

INSERT INTO Technique (matricule, montant_prime) VALUES
    ((SELECT matricule FROM Employe WHERE nom like '%Bastide%'), 200),
    ((SELECT matricule FROM Employe WHERE nom like '%P%catte%'), 300);

INSERT INTO Commercial (matricule, pourcentage) VALUES
    ((SELECT matricule FROM Employe WHERE nom like '%Singer%'), 10);