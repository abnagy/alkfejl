# CSALÁDI BÜDZSÉ APP :moneybag:

- Az alkalmazás egy család pénzügyeit tudja kezelni.
- A bevételek és kiadások összességét lehet kezelni az alkalmazásban katagóriák szerint minden családtag számára.
  - bevétel: fizetés, zsebpénz, ajándék...
  - kiadás: élelmiszer, ruha, nyaralás, autó, egészség, háztartás, oktatás, sport, bevásárlás, közlekedés, rezsi, lakbér...

## Követelmények:

- funkcionális:
  - lehet regisztrálni és bejelentkezni, különböző szerepkörönként
  - lehet tagokat hozzáadni/törölni/szerkeszteni a családhoz
  - lehet termékenként/családtagonként listázni
  - lehet a kiadásokat/keresetet hozzáadni/törölni/szerkeszteni
  - bevételeket es kiadásokat lehet kategorizalni pl. Bevétel: fizetés, zsebpénz. Kiadás: rezsi, élelmiszer
- nem funkcionális:
  - legyen felhasználóbarát, egyszerűen kezelhető
  - jelszóval védett felhasználói felület 
  
## Szakfogalmak:

- fizetés: munkahelyen megkeresett pénzösszeg
- zsebpénz: családon belül cserélt pénzösszeg
- családi kiadás/kereset: egész család összesített kiadása/keresete pl: nyaralás, bevásárlás ??
- egyéni kiadás/kereset:  egyén összesített kiadása/keresete

## Szerepkörök:

- családfő/admin:
  - látja az összes felhasználó bevételeit és kiadásait
  - tudja módosítani az összes felhasználó bevételeit és kiadásait
  - hozzáadhat új szerepköröket és kategóriákat
- családtag/felhasználó:
  - látja a saját bevételeit és kiadásait
  - módosíthatja a saját bevételeit és kiadásait
  - a többi felhasználó bevételeit és kiadásait nem láthatja és nem módosíthatja
  - nem adhat hozzá kategóriákat, szerepköröket
 
