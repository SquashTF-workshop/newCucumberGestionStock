# language: fr

@MainFct
Fonctionnalité: Gestion de stock

# Equivalent d'un BeforeEach
  Contexte:
    Etant donné que j'ai 1 lot de marchandises
    Et que j'en récupère 2 autres

    # Scénario unique
    Scénario: Aucun ajout
      Quand je compte la totalité du stock
      Alors j'ai au moins 2 lots de marchandise en stock

    # Boucle sur les valeurs dans Exemples
    Plan du scénario: Ajout de stock
      Etant donné que je dois ajouter des <élément>
      Et que je détermine sa quantité
      Quand je l'ajoute à mon stock
      Alors je dois avoir un minimum de marchandises

      Exemples:
      | élément |
      | "Echelles" |
      | "Coffres" |
      | "Planches" |