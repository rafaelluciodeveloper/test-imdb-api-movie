# Api Movies Imdb
###  - Target
The customer has requested a way to query for movie titles in IMDB.

### - Stack 
- [x] Java 1.8
- [x] Gradler(6.3)
- [x] Apacche Commons(3.0)
- [x] Jsoup (Html Parser) (1.13.1)
- [x] Junit (4.12)

### - Details
After get these content, the application convert these for a object class and so filter to get just the movies titles. At the proccess finish, the application generate the response object with base at the output definition format.

- [x] The Optional Java Class was used to evite null
- [x] The number port 37000 (TCP) is ready for requests
- [x] Support for multiple concurrent accesses
- [x] The SOLID principles was respected

### - Input Data Format
* The input is with this format 
`<query_length>:<query>`
* query_length : is the length of the query
* query : is the movie title to search 

### - Output Data Format
* The output is with this format 
`<payload_lenght>:<payload>`
* payload_length : is the length of the payload content
* payload : is the response content
* Each movie title was separated with (\n).

### - Examples input/ouput

```
Input -> 12:the avangers
OutPut -> 990:The Toxic Avanger 31 Days of Horror\nShin Evangelion Gekijôban AVANT 1 (Bôtô 10 bun 40 byô 00 koma) 0706 Ban\nStavanger - St. Svithuns by\nPassengers: Creating the Avalon\nAntonia de Rendinger - Ma vie avant ONDAR Scène Attitude\nThe Strangers, Edge of Heaven, Postal Hollywood on Set\nBattle of the Heavy Metal Headbangers Celebrity Deathmatch\nCavanaugh of the Forest Rangers\nSomewhere in Savannah (Talking to Strangers)\nThe Avengers: Kiss Marry CRUCIO Chris Pratt, Chris Evans, or Chris Hemsworth? Fantastic Geeks and Where to Find Them\nBreeding Ground/The Aviator and the President/Brain Rangers 60 Minutes\nBenedict Cumberbatch: 32 Facts on the Uber-Talented Actor, 'Sherlock', 'Doctor Strange', The Avengers Hollywood Insider\nRoy Rogers & Dale Evans, Rodney Dangerfield, Oliver, Dana Valery, Phyllis Diller, Frank Gorshin Toast of the Town\nDoctors' Exclusive: Vanessa Carlton's Health Scare/Rocco DiSpirito's Food Swaps/Exploding Head Syndrome/New Microwave Dangers The Doctors\n
```
```
Input : 3:cars
Output : 21:Invalid query lenght
```
```
Input : :titan
Output : 23:Error validating query
```
```
Input : 16:um filme diverso
Output : 16:Movie not found.
```

```
Input : 8:avengers
Output : 4380:The Avengers: Os Vingadores\nOs Vingadores da Costa Oeste\nNovgorodtsy\nVingadores: Ultimato\nVingadores: Guerra Infinita\nVingadores: Era de Ultron\nOs Vingadores Unidos\nOs Vingadores - Os Maiores Heróis da Terra\nMarvel's Avengers\nOs Vingadores\nOs Vingadores\nAvengement\nCapitão América: O Primeiro Vingador\nPassageiros\nSavaged\nAvenger\nO Vingador Tóxico\nRevenger\nThe New Avengers\nScavengers\nAvengers Grimm\nPassageiros\nSurgirá a Aurora\nBikini Avengers\nMarcados pela Vingança\nDuro de Matar 3: A Vingança\nA Lenda de Enéas\nTubarão 4: A Vingança\nThe Scavengers\nThe Messengers\nOs Mensageiros\nOs Supremos 2: Descubra o Poder da Pantera\nScavenger Hunt\nAvenger\nRevenge Ride\nTransformers: A Vingança dos Derrotados\nMister X\nAvengers: Damage Control\nMissão Perigosa\nCapitão América: Guerra Civil\nMarvel Future Avengers\nThe Revengers\nSoldier's Heart\nCombate Mortal\nLego Marvel's Avengers\nThe Scavengers\nVingança Selvagem\nAvengers of Justice: Farce Wars\nShi mei chu ma\nScavengers\niNumber Number\nAvengement\nScavengers\nO Vingador Misterioso\nAnjo Vingador\nWonder Dogs\nHämnaren\nAvengers Grimm: Time Wars\nMarvel Avengers Academy\nA Vingança de 1 Predador\nNaked Avenger\nSkavengers\nO Vingador Tóxico II\nTo Avenge\nA Vingança\nA Vingança de El Mocho\nAlien Avengers II\nBaby Avengers\nO Vingador\nThe Revenger\nOs Vingadores Mascarados\nMotoqueiro Fantasma: Espírito de Vingança\nThe Scavengers\nEu Acuso\nMarvel: Avengers Alliance\nCitizen Toxie: The Toxic Avenger IV\nA Vingança\nLa revancha\nOs Supremos: O Filme\nScavengers\nChristmas Scavenger Hunt\nAvengers S.T.A.T.I.O.N.\nAvengeance\nHissatsu Buraiken\nAvengers Plokhbuster Show\nAvengers Zoom In\nAvengers Bloody Tales\nAvengers 2 Plokhbuster Show\nAvengers Chrono-critique\nAvengers #1 REC Tv\nScavenger Killers\nScavengers\nBurka Avenger\nScavengers\nAlien Avengers\nAvenge\nAvenged\nOs Novos Vingadores: Heróis do Amanhã\nAvenge the Crows\nA Hora da Vingança\nScavengers\nThe Dark Avengers\nThe Double-D Avenger\nThe Street Avenger\nScavenger\nThe Avenging Silence\nA Vingança de Milady\nI Am Vengeance: Retaliation\nVingadores de Shaolin\nVingadores do Espaço\nAvenger Avengers Land Mystery\nAvenger The Lone Ranger\nAvenger\nAvenger\nAvenger The Assets\nAvenger Absolute Duo\nAvengers Assemble!\nThe Scavengers\nScavenger\nNinja Avengers\nThe Revengers\nDa chu tou\nScavenger\nO Anjo Vingador\nAvengers Land Mystery\nBuamdong Boksujadeul\nZemsta\nGettâ robo Jî\nOs 3 Invencíveis\nScavenger\nDoce Vingança 3: A Vingança é Minha\nScavengers\nHalloween 5: A Vingaça de Michael Myers\nComo Cães e Gatos 2: A Vingança de Kitty Galore\nOs Punhais do Vingador\nThe Toxic Avenger\nSafaibaaz - The Scavenger\nCapitão América 2: O Soldado Invernal\nAvengers: Legacy\nNinja Vengeance\nA Vingança dos Monstros\nAvengelyne\nThe Scavenger\nThe Toxic Avenger: The Musical\nRevengers Tragedy\nInvisible Avenger\nOs Mensageiros 2: O Espantalho\nDoce Vingança\nAlien Arsenal\nThe Avenger\nScavenger\nZorro, the Avenger\nScavengers\nA Daughter's Revenge\nTômei ningen\nRavenge\nBerrenger's\nAlien Space Avenger\nP.J.\nA Vingança do Águia\nEl Zorro justiciero\nThe Avengers Disneycember\nScavengers Z Cars\nThe Scavengers Crossbow: As Aventuras de Guilherme Tell\nDark Avengers Comic Book Issues\nThe Avengers Top 5 Reasons It Sucks! ...Or Does It?\nThe Avengers Must See TV\nNon-Avengers Who's the murderer\nThe Scavengers\nThe Avengers HBO First Look\nThe Avengers Wichita Town\nAvengers 1998 The Blockbuster Buster\nThe Scavengers How the West Was Won\nThe Avengers The Nostalgia Critic\nThe Avengers Really That Good\nThe Avengers Honest Trailers\nThe Avengers Destination séries\nThe Avengers Chris Stuckmann Movie Reviews\nThe Avengers Gunsmoke\nScavengers\nBlue Avengers The New Adam-12\nScavengers Ninjago: Masters of Spinjitzu\nScavengers In the End: Sketch Comedy\nScavenger Scan Chaotic\nThe Avengers O.C.: Um Estranho no Paraíso\nThe Avengers Destination séries\nThe Avengers Ask the Streetz\nSkavengers\nThe Avengers Midnight Movie Review\nAvengers #200 Atop the Fourth Wall\nThe Avengers Behind the Scenes\nThe Scavengers The Rough Riders\nScavengers Dark Oracle\nAvengers - Six Top Screen\nThe Avengers Awesome Movie Reviews\nThe Avengers #1 Comic Book Issues\nThe Avengers Screen Rant Pitch Meetings\nThe Avengers Bad Days\nThe Scavengers The Rebel\nJLA/Avengers Atop the Fourth Wall\n
```

### BUILDING/RUNNING  PROJECT
#### BUILDING

```
./gradlew build
```
* The jar file will be generated at  `<project>`/build/libs/

#### RUNING
```
./gradlew run
```
#### RUNING WITH BUILDING .JAR
```
./gradlew runJar
```

### CALLING SERVER
to get the server's response, follow some suggestions:

### 1. Using imdb-api-movie-client
open your console in the imdb-api-movie-client folder and run the following command:
* this project is for testing only and does not follow the principles of SOLID or any design pattern.
```
./gradlew runJar
```

### 2. Using PuTTY Telnet

```
apt-get install putty
```
