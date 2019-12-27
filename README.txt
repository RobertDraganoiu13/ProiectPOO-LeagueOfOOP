// Copyright Robert Draganoiu 322CA - Proiect POO - Etapa 1

Detalii implementare:

Input:
-inputul este citit cu ajutorul clasei GameInputLoader, care utilizeaza un
obiect de tipul FileSystem din API-ul FileIO;
-datele primitive in care se salveaza inputul sunt pasate catre clasa
GameInput, care genereaza tipuri de date folosite mai departe in
aplicatie(GameMap, Hero);
-eroii sunt creati cu ajutorul instantei de tip singleton a clasei HeroFactory,
in functie de clasa din care fac parte (Knight, Pyromancer, Rogue, Wizard);
-datele din obiectul GameInput sunt pasate catre o instanta a clasei Game,
care implementeaza logica jocului.

Modelul:
-au fost implementate clase de constante pentru fiecare tip de erou, pentru a
asigura un management bun al valorilor de baza si al modificatorilor;
-cele 4 tipuri clase de eroi extind clasa abstracta Hero, care detine field-uri
si implementeaza metode realizate de fiecare dintre ei (field-uri: hp, maxHp etc.
metode: addXp, move etc.); 
-metodele abstracte sunt cele 2 abilitati diferite pentru fiecare tip de erou
si cele care implementeaza conceptul de double dispatch.

Double dispatch:
-am ales sa folosesc double dispatch pentru a gestiona race modifier-urile de
abilitati pentru fiecare tip de erou; astfel, fiecare clasa care extinde Hero
implementeaza urmatoarele metode:

-provideFirstAbilityRaceModifier(final Hero enemy Hero)
-getFirstAbilityRaceModifier(final Knight/Pyromancer/Rogue/Wizard enemyHero)
*analog pentru second ability

-astfel, pentru ca un erou sa utilizeze raceModifier-ul pentru tipul de erou
pe care aplica abilitatea, se apeleaza prima metoda(care primeste referinta
la Hero), care o apeleaza pe a doua pe obiectul curent, avand ca parametru
tipul de erou explicit;

-daca se doreste implementarea altor tipuri de eroi, se pot, deci, adauga noi
metode de tiput getRaceModifier, fara a modifica nimic din implementarea
existenta.

Logica jocului:
-logica jocului este implementata in clasa Game, unde fiecare runda urmeaza
urmatorii pasi:
	a. mutarea eroilor - se realizeaza tot timpul, mai putin in situatiile
in care eroul este incapacitat din cauza unei abilitati;
	b. aplicarea efectelor over time - se aplica damage-ul pentru efectele
over time, daca eroii se afla sub influenta lor;
	c. sustinerea luptelor - jucatorii vii aflati in aceeasi celula se lupta.

Output:
-datele pentru fiecare erou sunt scrise in fisierul de iesire prin intermediul
unei instante a clasei FileWriter din API-ul FileIO.