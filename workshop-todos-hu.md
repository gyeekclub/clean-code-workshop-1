0. A csapatotokból egy ember készítsen egy forkot erről a github repository-ról a saját github fiókjába. A fork repository-n dolgozzatok.
1. A projekt beüzemeléséhez lásd a README.md fájt. Természetesen tetszőleges IDE használható.
2. A meglévő kód alapján tervezzétek meg a teszteket, anélkül, hogy a test projektet megnéznétek. Milyen esetekkel fednétek le a program működését? Írjátok meg előre az asserteket is.
3. Nézzétek meg a meglévő teszteket, majd egészítsétek ki az általatok leírt teszt esetekkel, illetve akár a meglévő teszteket is refaktorálhatjátok, ha láttok bennük hiányosságot/hibát (néhány easter egget itt is elrejtettünk ;)).
4. Néhány előre legyártott teszt nem fut le, egészítsétek ki a kódot, hogy azok is lefussanak.
5. Refaktoráljátok a meglévő kódot! A cél: clean code és zöld tesztek!

  Iránymutatásul néhány alkalmazható refaktoring művelet:
  * extract method
  * rename variable
  * move method
  * replace temp with query
  * replace type code with state/strategy
  * replace conditional with polymorphism
  * self-encapsulate field

  Természetesen más refactoring műveletek is használhatóak, és lehet olyan jó megoldás, ahol ezek nem mindegyike van használva.
  Refactoring katalógus: https://github.com/RefactoringGuru/refactoring-examples, https://refactoring.com/catalog/

6. Commitáljátok a megoldásaitokat gyakran. Az lenne az ideális, ha az alaklamzott refactoringok külön-külön látszódnának a commitokon.
7. A végén pedig nyissatok egy Pull Request-et e repository master branch-ére, hogy lássuk, hogy melyik csapat mit alkotott. 2-3 önkéntes csapat be fogja mutatni a munkáját, utána pedig közösen kivesézzük, megnézzük, hogy miket csináltak jól és miket lehetett volna még jobban!
