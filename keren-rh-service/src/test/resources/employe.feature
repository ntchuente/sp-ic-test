Feature: Gestion des Employes

  Scenario: Création
    Given Nous avons  N Employees
    When Je crée une nouveau emplye
    Then J'obtiens N+1 employes

  Scenario: Suppression
    Given La BD contient l'employe test2
    When Je supprime l'employé 2
    Then La BD contient  N-1 Employé

  Scenario Outline: Lecture
    Given Nous avons  N Employees
    When Je recupère l'employé <id>
    Then J'obtiens l'employe  d'identifiant <id> contenant les données <firstName>, <lastName>, <email>

    Examples: 
      | id | firstName | lastName | email          |
      |  1 | test1     | test1    | test1@yahoo.fr |

  Scenario Outline: Modification
    Given Nous avons l'employe suivants
      | id | firstName | lastName | email          |
      |  3 | test3     | test3    | test3@yahoo.fr |
    When Je modifie l'employe  <firstName>
    Then J'obtiens la Personne d'identifiant <id> contenant les données <firstName>, <lastName>, <email>

    Examples: 
      | id | prenom | nom   | naissance      |
      |  3 | test3  | test3 | test3@yahoo.fr |
