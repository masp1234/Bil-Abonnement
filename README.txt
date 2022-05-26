# Bil-Abonnement

Sørg for at have en github konto, Git Bash, IntelliJ, en heroku konto og heroku CLI installeret.
Tryk på  “Fork” knappen oppe i højre hjørne.
Tryk på “Code” og kopier URL’en, som står i tekstboksen
Naviger til din projektmappe (valgfri mappe) i din valgte terminal.
Indtast “git clone <remote URL>”, hvor du indsætter den kopierede URL fra trin 3 på <remote URL>’s plads.
Log ind på Heroku’s hjemmeside, opret en ny applikation og giv denne et navn.
Gå ind i “Resources” og tilføj ClearDB Ignite version (gratis version) til applikationen.
Gå ind i “Settings”, gå ned til Config Vars, og klik dernæst “Reveral Config Vars”.
Kopier feltet til højre for CLEARDB_DATABASE_URL, som ligner mysql://b2de123f08f1c9:eb27545@eu-cdbr-west-02.cleardb.net/heroku_2e8e7368abaf0c3?
 Opret en ny Config Var med navnet db_user og værdien som står på “b2de123f08f1c9” ’s plads
Opret en ny Config Var med navnet db_password og værdien, som står på 
“eb27545”’s plads
Opret en sidste Config Var med navnet db_url og hele værdien som står ovenover + “jdbc:” foran, så det kommer til at se sådan her ud:
jdbc:mysql://b2de123f08f1c9:eb27545@eu-cdbr-west-02.cleardb.net/heroku_2e8e7368abaf0c3?

Gå ind i IntelliJ og naviger til filen “BilAbonnementApplication” og kør main-metoden. Du får en fejl når du prøver, men det er forventeligt, da programmet ikke er konfigureret endnu. 
klik “run”, som ligger på navigations baren oppe i venstre side, og vælg derefter “edit configurations”
 Vælg “Edit environment variables” (Shift+Enter), klik derefter på “+” (Alt + Insert).
 Gentag trin 9, 10 og 11 med samme navne og værdier som inde på Heroku
Når du er færdig med trin 16, så tryk “OK”, efterfulgt af “Apply” og derefter “OK” igen
 Åben enten Git Bash eller IntelliJ’s terminal.
 Indtast “heroku git:remote -a <app name>”, hvor “app name” er det navn du valgte til din applikation i trin 6. Hvis du får en besked om at du skal logge ind, så tryk på en vilkårlig tast. Der vil nu blive åbnet en browser, hvor du kan indtaste dine login informationer.
  Du burde nu kunne se, at dit git projekt er tilknyttet et remote repository på Heroku ved at skrive “git remote -v”
 Såfremt punkt 18 gik godt, kan du nu deploye din applikation ved at skrive “git push heroku main”
