# Zavrsni_rad_RASP

# Testiranje aplikacije :
# 1. testiranje "Root detectiona":
Kako bismo testirali je li uređaj rootan, potrebno je skinuti Genymotion desktop emulator. 
On je dostupan na sljedećoj stranici: https://www.genymotion.com/blog/2-12-oreo-final/ . 
Pri dnu stranice nalazi se gumb za preuzimanje emultora. Moguće je preuzeti običnu ili trial verziju emulatora. 
![alt text](https://github.com/rackilea/Zavrsni_rad_RASP/blob/master/upute-slike/Genymotion_download.PNG)

Prije preuzimanja, potrebno je registrirati se. Potom je potrebno preuzeti emulator(Without virtualbox) te instalirati preuzeti .exe file.
![alt text](https://github.com/rackilea/Zavrsni_rad_RASP/blob/master/upute-slike/download.PNG)

Prilikom instalacije, dovoljno je podržati sve defaultne postavke. Nakon uspješne instalacije potrebno je ulogirati se ili odabrati opciju "Personal Use" u Genymotion aplikaciji. 

![alt text](https://github.com/rackilea/Zavrsni_rad_RASP/blob/master/upute-slike/personal_use.PNG)

Potom odabrati željeni emulator/uređaj na kojemu će se testirati aplikacija (preporučam uređaj "Samsung Galaxy S8 - 7.0.0 - API24 - 1440x2960). Nakon odabira uređaja, potrebno je dva puta odbrati gumb "Next" i nakon toga gubm "Finish".
![alt text](https://github.com/rackilea/Zavrsni_rad_RASP/blob/master/upute-slike/add_device.PNG)
![alt text](https://github.com/rackilea/Zavrsni_rad_RASP/blob/master/upute-slike/choose_device.PNG)

Ukoliko se emolator automatski ne pokrene, moguće ga je pokrenuti klikom na "Start".
![alt text](https://github.com/rackilea/Zavrsni_rad_RASP/blob/master/upute-slike/start_device.PNG)

Sljedeći korak je pokrenuti aplikaciju u Android Studiu. Ukoliko nemate instaliran Android Studio, on je dostupan na sljedećoj poveznici : https://developer.android.com/studio/index.html . Također , prilikom instalacije Android Studija dovoljno je podržati sve defaultne postavke. 
Prilikom pokretanja aplikacije iz Android studija(klikom na ikonicu Run ![alt text](https://github.com/rackilea/Zavrsni_rad_RASP/blob/master/upute-slike/Run.PNG)), potrebno je odabrati Genymotion uređaj. 
![alt text](https://github.com/rackilea/Zavrsni_rad_RASP/blob/master/upute-slike/select_deployment_tagret.PNG)

Prije paljenja aplikacije pojaviti će se popup koji traži dozvolu za Superuser mogućnosti. Potrebno je potvrditi tu opciju.
![alt text](https://github.com/rackilea/Zavrsni_rad_RASP/blob/master/upute-slike/allow_SU.PNG)

Nakon pokretanja aplikacije, trebali biste vidjeti sljedeći ekran.
![alt text](https://github.com/rackilea/Zavrsni_rad_RASP/blob/master/upute-slike/device_rooted.PNG)

# 2. testiranje "Debug detectiona":
Za ovaj nam je test također potreban Android Studio te Android uređaj ili emulator (može gore navedeni Genymotion emulator).
Kako bismo testirali detekciju debugera, aplikaciju iz Android Studija moguće je pokrenuti klikom na gumb Run( ![alt text](https://github.com/rackilea/Zavrsni_rad_RASP/blob/master/upute-slike/Run.PNG)) ili klikom na gumb Debug(![alt text](https://github.com/rackilea/Zavrsni_rad_RASP/blob/master/upute-slike/Run_with_debugger.PNG)). 
Ukoliko smo aplikaciju pokrenuli s Run opcijom, nakon podizanja aplikacije potrebno je naknadno upaliti debuger pritiskom na ikonu Attach degubber to Android proccess (![alt text](https://github.com/rackilea/Zavrsni_rad_RASP/blob/master/upute-slike/Attach_debugger.PNG)). Aplikacija će svake dvije sekunde provjeravati je li debuger aktivan te će u skladu s tom informacijom mijanjeti labele i slati upozorenje. Debuger se gasni pritiskom na gumb Stop(![alt text](https://github.com/rackilea/Zavrsni_rad_RASP/blob/master/upute-slike/Stop.PNG)).
Tokom paljenja i gašenja debuggera, izmjenjivat će se sljedeća dva ekrana :
![alt text](https://github.com/rackilea/Zavrsni_rad_RASP/blob/master/upute-slike/Screenshot_20180420-172416.png)
![alt text](https://github.com/rackilea/Zavrsni_rad_RASP/blob/master/upute-slike/Screenshot_20180420-172503.png)
