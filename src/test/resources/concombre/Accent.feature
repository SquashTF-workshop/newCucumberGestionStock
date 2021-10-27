# language: fr

@MainFct
Fonctionnalité: Gestion de stock accentué !

# Equivalent d'un BeforeEach
  Contexte:
    Etant donné que j'ai 2 lot de marchandises
    Et que j'en récupère 3 autres

    # Scénario unique
    Scénario: Aucun ajouté après cont&xt&
      Quand je compte la totalité du stock
      Alors j'ai au moins 5 lots de marchandise en stock

    # Scénario unique
    Scénario: Pas d'ajout mais erroné ...
      Quand je compte la totalité du stock
      Alors j'ai au moins 9 lots de marchandise en stock

    # Boucle sur les valeurs dans Exemples
    Plan du scénario: Ajout d'élément dans le stock
      Etant donné que je dois ajouter des <élément>
      Et que je détermine sa quantité
      Quand je l'ajoute à mon stock
      Alors je dois avoir un minimum de marchandises

      Exemples:
      | élément |
      | "Echelles" |
      | "Coffres" |
      | "Planches" |