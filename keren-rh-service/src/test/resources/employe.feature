Feature: Gestion des Employes

  Scenario: Création
    Given Nous avons  N Employees
    When Je crée une nouveau emplye
    Then J'obtiens l'ID de l'emplyé créée et la BD contient plus de N employes

  Scenario: Suppression
    Given La BD contient la Personnes TOTO
    When Je supprime l'employé 1
    Then La BD contient moins de N Employé

  Scenario Outline: Lecture
    Given Nous avons  N Employees
    When Je recupère l'employé <id>
    Then J'obtiens la Personne d'identifiant <id> contenant les données <prenom>, <nom>, <email>

    Examples: 
      | id | firstName | lastName | email               |
      | 10 | test1     | test1    | ntchhuente@yahoo.fr |
      | 20 | test2     | test2    | ntchhuente@yahoo.fr |
      | 30 | test3     | test3    | ntchhuente@yahoo.fr |

  Scenario Outline: Modification
    Given Nous avons  les Employees suivants
      | id | prenom | nom   | naissance           |
      | 30 | test3  | test3 | ntchhuente@yahoo.fr |
    When Je modifie la Personne <id> avec <nom>
    Then J'obtiens la Personne d'identifiant <id> contenant les données <prenom>, <nom>, <email>

    Examples: 
      | id | prenom | nom   | naissance           |
      | 30 | test3  | test3 | ntchhuente@yahoo.fr |
