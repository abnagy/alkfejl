# CSALÁDI BÜDZSÉ APP :moneybag:

_(Az alkalmazas egy csalad penzugyeit tudja kezelni.)_

- Az alkalmazas egy csalad penzugyeit tudja kezelni.
- A bevetelek es kiadasok osszeseget lehet kezelni az alkalmazasban katagoriak szerint minden csaladtag szamara

## Követelmények:

- funkcionális:
  - lehessen regisztrálni és bejelentkezni, különböző szerepkörönként
  - lehessen tagokat hozzáadni/törölni/szerkeszteni a családhoz
  - lehessen termékenként/családtagonként listázni
  - lehessen a kiadásokat/keresetet hozzáadni/törölni/szerkeszteni. 
  - beveteleket es kiadasokat lehessen kategorizalni pl. Bevetel: fizetes, zsebpenz. Kiadas: rezsi, elmiszer
- nem funkcionális:
  - legyen felhasználóbarát, egyszerűen kezelhető
  - jelszóval védett felhasználói felület. 
  
## Szakfogalmak:

- kereset:munkahelyen megkeresett pénz
- zsebpénz: családon belül cserélt pénz
- családi kiadás/kereset: egész család összesített kiadása/keresete
- egyéni kiadás/kereset:  egyén összesített kiadása/keresete

## Szerepkörök:

- családfő/admin:
  - látja az összes felhasználó bevételeit és kiadásait
  - tudja módosítani az összes felhasználó bevételeit és kiadásait
  - hozzáadhat új felhasználókat, szerepköröket és kategóriákat
- családtag: csak a sajátját látja és sajátját kezeli. (felhasználó)
