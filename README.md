# Ejercicios Acceso a Datos

## Arquivos
NOTAS IMPORTANTES

Unha vez solucionado o exercicio debes enviar o proxecto completo comprimido co nome arquivos.zip

Tamen debes enviar o fonte ( ou fontes)  .java como arquivos separados.

nota : o  numero maximo de arquivos a subir e 4  e non deben totalizar en conxunto mais de 200 MB

ENUNCIADO

Introducion a arquivos e directorios

Java dispon da clase File (java.io.File) que permite realizar operacions relativas a directorios e arquivos (ou ficheiros).
clase java.io.File:

constuctor: File(StringPath)

metodos:
exists()
canRead()
canWrite()
isDirectory()
isFile()
getName()
getPath()
getAbsolutePath()
length()
lastModified()
listRoots()
listFiles()
list()
setReadOnly()
creatreNewFile()
setWritable(true)
delete()
etc ....

OBXECTIVO:  Desenvolver  un proxecto  chamado "arquivos"  que realize as tarefas especificadas a continuacion .

Todas as tarefas deste exercicio deben desenvolverse utilizando a Clase File , o seu constructor e os seus métodos


1) metodo eDirectorio(cadea) 

   que detecte se unha cadea dada corresponde a un directorio .
   cadea  debe ser un String que contena a ruta absoluta do directorio.
   imprimirase 'e un directorio' ou 'non e un directorio'

2) metodo eFicheiro(cadea) 

   que comprobe se unha cadea  dada corresponde a  un ficheiro.
   cadea  debe ser un String que contena a ruta absoluta do directorio
   imprimirase 'e un ficheiro' ou 'non e un ficheiro'

3) metodo creaDirectorio(String) 

   debe crear un  directorio  a partir da ruta absoluta do mesmo que se lle debe pasar coma un String . So debe crearse  dito directorio cando non exista previamente

4) metodo  creaFicheiro(dirName, fileName) 

   debe crear un  ficheiro nunha ruta absoluta que exista previamente ,  estos dous valores deben pasarse ao metodo como valores String. So debe crearse  dito ficheiro en dita ruta  cando non exista previamente

5) metodo  modoAcceso (dirName, fileName) 

   dado a ruta absoluta  e nome dun archivo ,este metodo debe imprimir a palabra:
   "escritura si" se se pode escribir nel
   "escritura non" se non se pode escribir nel
   "lectura si" se se pode ler nel
   "lectura non" se non se pode ler nel

6) metodo   calculaLonxitude(dirName, fileName) 

   dado a ruta absoluta  e nome dun archivo ,este metodo  debe : imprimir a lonxitude en bytes do mesmo

7) metodo  mLectura (dirName, fileName) 

   dado a ruta absoluta  e nome dun archivo ,este metodo  debe facer o arquivo de so lectura

8) metodo  mEscritura (dirName, fileName) 

   dado a ruta e nome dun archivo ,este metodo debe facer posible escribir no arquivoo.

9) metodo  borraFicheiro(dirName, fileName) 

    dado a ruta e nome dun archivo debe eliminalo se e que existe senon lanzar a mensaxe ficheiro inexistente

10) metodo  borraDirectorio(dirName) 

    dada una ruta debe eliminala se e que existe senon lanzar a mensaxe 'ruta inexistente ou con descencencia'

11) metodo mContido(dirName) que amose arquivos e directorios de primeiro nivel dunha ruta absoluta dada 


12)(Opcional) metodo recur(File) que amose arquivos e subdirectorios do directorio que se lle pase como obxecto File. 
                                        

Usando os metodos que creache anteriormente :

1) crear o directorio 'arquivosdir' na ruta '/home/oracle/NetBeansProjects/arquivos/' sempre e cando dito directorio non exista previamente .
   Comprobar que se trata  dun directorio mediante o metodo eDirectorio que creache anteriormente
   (Comprobar que o directorio foi creado ou existe,  mediante os comandos do sistema operativo (modo texto) , ou mediante o entorno grafico) .

2) crear  o arquivo Products1.txt no directorio mencionado anteriormente (arquivosdir) sempre e cando dito arquivo non exista.
   Comprobar que se trata  dun ficheiro mediante o metodo eFicheiro que creache anteriormente.
   (Comprobar que o arquivo foi creado ou existe mediante comandos do sistema operativo (modo texto) ou mediante o entorno grafico.)

3)Crear o directorio 'subdir'  na ruta '/home/oracle/NetBeansProjects/arquivos/arquivosdir/' creada anteriormente
Crear o arquivo Products2.txt no directorio mencionado anteriormente (subdir)

4)Amosar arquivos e subdirectorios de primeiro nivel da ruta  '/home/oracle/NetBeansProjects/arquivos/arquivosdir/'
Debería amosarse o seguinte resultado: 

Products1.txt 

subdir

5)amosar a seguinte informacion sobre o primeiro  arquivo (Products1.txt) creado:
si e posible ou non escribir nel
si e posible ou non ler del
a sua lonxitude en bytes
(a continuacion debes editar manualmente  o arquivo co editor de texto e escribir un texto calquera, por exemplo a palabra  'ola', e volver a amosar a sua lonxitude en bytes (deberia ter cambiado))

6) Forzar a que o mesmo arquivo referido no apartado anterior   sexa de so lectura
   (comprobar intentanto editar o arquivo manualmente  que no se pode escribir nada en dito arquivo)

7)forzar a que o arquivo referido no apartado anterior pase de novo a ser de novo de  escritura
(comprobar dendo o sistema operativo que se pode escribir de novo no  arquivo)

8)borrar o arquivo referido no apartado anterior
(comprobar manualmente dende o sistema operativo que o arquivo foi borrado)

9)borrar os o resto de arquivos e directorios creados anteriormente

10)(opcional) amosa usando o metodo recur(File) todos  os subdirectorios e arquivos que colgan do directorio '/home/oracle/NetBeansProjects/arquivos/arquivosdir/'

## CopyBytesTexto
NOTAS IMPORTANTES

Unha vez solucionado o exercicio debes enviar o proxecto completo comprimido co nome arquivos.zip

Tamen debes enviar o fonte ( ou fontes)  .java como arquivos separados.

nota : o  numero maximo de arquivos a subir e 4  e non deben totalizar en conxunto mais de 200 MB

* Neste exercicio trataremos os fluxos de Bytes (binary streams) mediante as clases  FileInputStream, FileOutputStream

Por cada modificacion que se pide deixa comentada a linea como estaba antes da modificacion para deixar constancia de todas as modificacions desenvolvidas no exercicio.

A clase   FileInputStream permite ler bytes dende un ficheiro do sistema .
Para elo imos utilizar o metodo read() de dita clase que leera byte a byte . Cando se pase ao fin do ficheiro devoltara un valor -1 ( polo tanto deberedes preguntar por este valor para detectar o fin do ficheiro,  e non facer mais lecturas que darian un erro)


FileOutputStream e unha clase que permite facer xusto o contrario, escribir bytes nun ficheiro do sistema.
Para elo imos utilizar o metodo write() de dita clase.

nota: a clase FileOutputStream acepta nun dos seus  contructores un segundo parametro tipo boolean que si e “true” indica que  o ficheiro se abre en modo append (engadir) , e dicir que se usamos este parametro co valor “true”  cando voltemos escribir neste ficheiro o seu contido non se sobreescribe

nota IMPORTANTE : lembrar pechar o obxecto OutputStream co seu metodo close() deste xeito os datos que poidan quedar no buffer son trasladados ao ficheiro destino.

1)crea a man cun editor de texto simple (un editor de texto plano de Centos e “gedit” por exemplo) un pequeno ficheiro de texto chamado texto1.txt con tres lineas :
ola
adeus
cecais

APLICACION :

2_1)Desenvolve unha pequena aplicacion  chamada 'copybytestexto'  que usando somente estas duas clases e os metodos indicados  copie  byte a byte o contido do  ficheiro de texto chamado texto1.txt noutro ficheiro chamado texto2.txt

2_2) Fai a modificacion necesaria na aplicacion anterior para que se engada de novo o texto do ficheiro texto1.txt ao ficheiro texto2.txt ( e dicir facer o cambio necesario para que non o sobreescriba , polo que cada vez que executemos a apliciacion , o ficheiro de texto texto2.txt vera aumentado o seu contido cas tres palabras do texto1.txt de novo) 

## CopyBytesImaxe
vai constar de dous exercicios : copybytesimaxe e copybytesimaxe2

unha vez solucionados estes exercicios   debes enviar as fontes .java como arquivos separados.

nota : o  numero maximo de arquivos a subir e 4  e non deben totalizar en conxunto mais de 200 MB

APLICACION  copybytesimaxe:

Imos partir do exercicio anterior para desenvolver este asi que crea un proxecto denominado copybytesimaxe co mesmo codigo do exercicio anterior

a) agora fai a proba de utilizar como fichero orixen a copiar a imaxe foto.jpg (en vez de texto1.txt) e como ficheiro destino da copia un que se chame foto2.jpg (en vez de texto2.jpg.
Canto ocupa foto2.jpg ? ocupa o mesmo que a imaxe orixinal ?

b) executa por segunda vez a aplicacion para que se engada de novo a imaxe foto.jpg  á imaxe foto2.jpg. ¿que ocorre se abrimos a imaxe, vese a imaxe repetida? , Canto ocupa agora o arquivo foto2.jpg?

c) o que estamos facendo  ata o de agora  e traballar con fluxos de datos tipo byte, sen diferenciar se o contido do ficheiro a copiar conten
datos de texto ou binarios.

(Veremos mais adiante que cando se traballa con fluxos de datos tipo  texto normalmente se garda un byte por caracter , pero cando se traballa fluxos de datos de tipo binario se almacenan imaxenes byte a byte ou caracteres en un formato que pode  escribir diferentes tipos primitivos de datos ).

E dicir,  en canto o que o que fixemos ate o de agora, para o sistema non hai diferencia entre copiar un ficheiro de texto ou unha imaxe posto que non interpreta o contido de cada byte senon que simplesmente o lé e o copia byte a byte ( un byte de cada vez).

Isto e aparentemente rapido pero se o ficheiro orixen e grande  e queremos mellorar a velocidade de copia debemos recurrir a outras clases que combinadas con as clases anteriores  (FileInputStream e FileOutputStream ) van permitirnos mellorar a velocidade dos fluxos de datos.

Para traballar con ficheiros binarios  temos duas clases que melloran a velociade de entrada e salida do fluxo de datos.
Estas clases son as clases BufferedInputStream e BuffferedOutputStream.
A ventaxa de usar  buffers e que se reduce o numero de operacions de entrada saida que son feitas por o disco.
Asi,por exemplo , se un buffer pode conter 4000 bytes , so se fará a operación de escritura ou lectura cando dito buffer se encha ou cando o fluxo sexa pechado (close). En caso de non usar buffers a grabacion dos 4000 bytes requriria centos de operacions de entrada saida , e xa que cada operacion require a recolocacion das cabezas do disco  isto leva moito tempo.

Para poder  facer isto Java permite  combinar dous ou mais fluxos de datos (Streams) para engadir a funcionalidade que se necesita par unha aplicación  ( FileInputStream  e BufferedInputStream son fluxos de datos que se poden combinar ) .
Para combinar fluxos de datos  en Java debes usar un obxecto de unha das clases como argumento para o constuctor da outra clase .

APLICACION copybytesimaxe2:

Sabendo que  a clase BufferedInputStream acepta como argumento do seu constructor a un obxecto da clase FileInputStream, e que a clase BuffferedOutputStream  acepta como argumento do seu constructor a un obxecto da clase FileInputStream, fai outro proxecto chamdo copybytesimaxe2  para  aumentar a velocidade de copia facendo uso de ditas clases.

IMPORTANTE:
Ten en conta que a clase BufferedInputStream  ten un metodo read() que permite ler un byte de cada vez e que do mesmo xeito que a clase FileInputStream permite detectar o fin do ficheiro mediante a consulta do valor devolto na lectura: si e -1 indica o fin do ficheiro .
Ten en conta tamen que a clase BufferedOutputStream ten un metodo write() que permite escribir un byte

una vez que executes o exercicio:
Notaches a diferenza en velocidade a hora de facer a copia da imaxen con respecto a cando NON usaches as clases BufferedInputStream e BufferedOutputStream ?
Se non a notas escolle unha imaxe de maior numero de bytes que a proporcionada (foto.jpg) ou executa varias veces o proxecto copybytesimaxe para facer crecer en bytes a imaxe foto2.jpg  e despois usa esta  como orixen de copia neste proxecto (copybytesimaxe2)

## PrimitiveWriteUtf
Neste exercicio seguiremos traballando os fluxos binarios de datos pero abora tratandoos como soporte de tipos de dato primitivos e valores String

DataOutputStream é unha clase que dispon dunha serie de  métodos  para que partindo  de fluxos binaros de datos  podamos escribir tipos primitivos de datos e valores String

DataInputStream é unha clase que dispon  dunha serie de  métodos  para que partindo  de fluxos binaros de datos  podamos ler tipos primitivos de datos e valores String  que previamente foron codificados nestes fluxos mediante DataOutputStream

Dado que DatainputStream admite como parámetro calquer clase herdada de InputStream , e BufferedInputStream cumpre este requisito,  o único que temos que facer para poder usar os metodos de DataInputStream e pasarlle como parmaetro un obxecto BufferedInputStream coma o traballado no exercicio anterior (exercicio3 : copybytesimaxe2)

Dado que DataOutputStream admite como parametro calquer clase herdada de OutputStream , e BufferedOutputStream cumpre este requisito o único que temos que facer para poder usar os metodos de DataOutputStream e pasarlle como parmaetro un obxecto BufferedOutputStream coma o traballado no exercicio anterior (exercicio3 : copybytesimaxe2)

APLICACION

Obxectivo: Propoñovos un desenvolver un proxecto chamado primitiveWriteUTF que consistirá grabar a mesma cadea  de texto tres veces consecutivas nun ficheiro denominado texto3.txt usando o metodo writeUTF e amosar o tamaño do ficheiro cada vez que grabamos unha cadea , para posteriormente recuperalos (ler ditas cadeas dende o ficheiro).

cadea a grabar : "o tempo está xélido"

IMPORTANTE:

para saber se cando desenvolvemos a lectura alcanzamos o fin do ficheiro podemos usar o metodo .available() da clase DataInputStream que devolvera o valor 0 cando xa non quede nada por ler .


metodos a usar :

da clase DataOutputStream :  size(), writeUTF(String)

	o metodo size() devolve o tamaño en bytes do ficheiro no que estamos a escribir
	o metodo writeUTF(String) escribe a cadea que se pasa como parametro

da clase DataInputStream : available(), readUTF()

	o metodo available() devolta o valor 0 se xa se leron todos os bytes do ficheiro
	o metodo readUTF() lee calquera  String que fose grabado previamente nun ficheiro co  metodo  writeUTF(String)


Ter en cota que writeUTF(String) escribe tipicamente 1 byte por cada caracter do String que lle pasamos como parámetro  ( pero pode escribir ata 3 bytes por caracter  dependendo do caracter ) e antepon a dito String  2 bytes que conteñen a lonxitude en numero de bytes do String.

E dicir que se por exemplo o String a grabar é o texto "o tempo está xélido" a sua escritura ocupara 23 bytes porque os caracteres normais e os blancos ocupan  1 byte por caracter , namentras que e as vogais con acento ocupan 2 bytes cada unha. Vexamos o cálculo a ollo :
"o tempo está xélido": 14 caracteres normais  + 3 blancos  + 2 vogais  acentuados =>

2 bytes (que antepoñen a cadea para indicar a sua lonxitude) + 14 + 3 + 2*2 = 23 bytes

o resultado da execucion podería  ser o seguinte:

escribindo a cadea: o tempo está xélido 

tamano do ficheiro: 23 bytes 

escribindo a cadea: o tempo está xélido 

tamano do ficheiro: 46 bytes 

escribindo a cadea: o tempo está xélido 

tamano do ficheiro: 69 bytes 

tamano final  do ficheiro: 69 bytes 

quedan: 69 bytes por ler 

cadea: o tempo está xélido 

quedan: 46 bytes por ler 

cadea: o tempo está xélido 

quedan: 23 bytes por ler 

cadea: o tempo está xélido 

Xa non queda nada por ler 


Observacions :
Podemos comprobar que se intentamos abrir a o ficheiro de texto  text3.txt co editor gedit non o permite. debemos usar nano , vi , emacs ou outro editor non grafico  e comprobaremos a forma en que foron grabadas as  cadeas.
podemos ver o contido do ficheiro de texto en hexadecimal e en codigo ASCII  dende unha terminal con:  hexdump -C nome_ficheiro  ou ben en binario puro : xxd -b nome_ficheiro
mostrar lonxitude en bytes do ficheiro: wc -c nome_ficheiro

## PrimitiveWriteChars
Neste exercicio seguiremos tratando os fluxos binarios de datos pero agora tratandoos como soporte de tipos de datos primitivos e valores String

DataInputStream dispon dunha serie de  métodos  para que partindo  de fluxos binaros de datos  podamos ler tipos primitivos de datos e valores String

DataOutputStream dispon dunha serie de  métodos  para que partindo  de fluxos binaros de datos  podamos escribir tipos primitivos de datos e valores String que previamente foron codificados nestes fluxos mediante DataInputStream

Dado que DataInputStream admite como parametro calquer clase herdada de InputStream , e BufferedInputStream cumpre este requisito,  o único que temos que facer para poder usar os metodos de DataInputStream e pasarlle como parmaetro un obxecto BufferedInputStream coma o traballado no exercicio anterior (exercicio 3)

Dado que DataOutputStream admite como parametro calquer clase herdada de OutputStream , e BufferedOutputStream cumpre este requisito o único que temos que facer para poder usar os metodos de DataOutputStream e pasarlle como parmaetro un obxecto BufferedOutputStream coma o traballado no exercicio anterior (exercicio 3)

APLICACION

Propoñovos un exercicio que consistirá grabar unha mesma cadea  de texto duas veces usando o metodo  writeChars(String) da clase DataOutputStream  nun ficheiro denominado text5.dat para posteriormente recuperalas (voltalas a ler) mediante o metodo readChar() da clase DataInputStream .

Ter en cota que writeChars(String) escribe 2 bytes por caracter  (podemos cambiar calquera vogal da cadea por esa mesma vogal acentuada ou unha letra ñ e veremos que a lonxitude da cadea non varia (ao contrario do que ocorria con writeUTF() onde si variaba)

Ter en cota que readChar() lé un caracter de cada vez co cal haberá que facer un bucle que  execute esta instruccion tantas veces como letras ten a cadea que que quermos ler

cadea a grabar : "o tempo está xélido"

metodos a usar :

metodo length()  -- aplicado a calquera String danos a sua lonxitude en numero de caracteres.

clase DataInputStream:
metodo readChar() -- lee un caracter de cada vez (2 bytes)
metodo .available() --dinos cantos bytes quedan por ler dun ficheiro

clase DataOutputStream:
metodo writeChars(String) -- escribe o String (ocupa 2 bytes por caracter)
metodo size() aplicado a un obxecto de tipo DataOutputStream devolvenos o que ocupa este en bytes

## PrimitiveUtfChars
Neste exercicio seguiremos tratando os fluxos binarios de datos pero abora tratandoos como soporte de tipos de dato primitivos e valores String

DataInputStream dispon dunha serie de  métodos  para que partindo  de fluxos binaros de datos  podamos ler tipos primitivos de datos e valores String

DataOutputStream dispon dunha serie de  métodos  para que partindo  de fluxos binaros de datos  podamos escribir tipos primitivos de datos e valores String que previamente foron codificados nestes fluxos mediante DataInputStream

Dado que DatainputStream admite como parametro calquer clase herdada de InputStream , e BufferedInputStream cumpre este requisito,  o único que temos que facer para poder usar os metodos de DataInputStream e pasarlle como parmaetro un obxecto BufferedInputStream coma otraballado no exercicio anterior

Dado que DataOutputStream admite como parametro calquer clase herdada de OutputStream , e BufferedOutputStream cumpre este requisito o único que temos que facer para poder usar os metodos de DataOutputStream e pasarlle como parmaetro un obxecto BufferedOutputStream coma o traballado no exercicio anterior

APLICACION 

Propoñovos un exercicio que consistirá grabar unha mesma cadea  de texto tres veces usando dous metodos distintos (writeUTF e writeChars) nun ficheiro denominado text6.dat para posteriormente recuperalos.
Lembrade que para recuperar unha cadea de gravada con witeUTF debedes usar readUTF
Pero para recuperar unha cadea escrita con writeChars debedes usar readChar() que so lé un caracter de cada vez , isto implca que debedes usar un bucle que faga tantas lecturas como caracteres ten a cadea orixinal.

cadea a grabar : “Está en casa”

a primeira vez debe grabase usando writeUTF(String)
a segunda usando writeChars(String)
a terceira usando de novo writeUTF(String)

o resultado da execucion debería ser o seguinte:

writeUTF escribindo: Está en casa
bytes totais escritos: 16 bytes
writeChars escribindo: Está en casa
bytes totais escritos :  42bytes
writeUTF escribindo: Está en casa
bytes totais escritos  58 bytes
bytes totais por ler = 58 bytes
lemos a primeira cadea en UTF: Está en casa
numero de bytes por ler: 42 bytes.
lemos a segunda cadea  con readChar() en bucle:  Está en casa
numero de bytes por ler : 16
lemos a terceira cadea  mediante readUTF:  Está en casa
numero de bytes por ler : 0

Podemos comprobar que se intentamos abrir a o ficheiro de texto   co editor gedit non o permite.
debemos usar nano , vi , emacs ou outro editor non grafico  e comprobaremos a forma en que
foron grabadas as  cadeas.

## ProductsStream
Crear un novo proxecto denominado productsStream  cunha una clase denominada Product e una clase principal  tal como se describen a continuacion:

a)Clase Product: debe ter tres variables privadas
codigo   tipo String
descricion tipo String
prezo  tipo Double
O contructor por defecto introducira  cadeas nulas nas variables codigo e descricion e un cero no prezo.
A clase debe ter outro constructor con pase de tres parametros (codigo, descricion e prezo)

Os metodos da clase Product son os basicos de calquera clase , e dicir os necesarios para poder realizar as seguintes operacions sobres as tres variables

cambiar o codigo : setCodigo(String codigo)
obter o codigo: getCodigo()
cambiar a descricion setDescricion(String descricion)
obter a descricion: getDescricion()
cambiar o prezo : setPrezo(Double prezo)
obter o prezo: getPrezo()

* Dende a  clase principal: 

1. crear un  obxecto da clase Product  cos argumentos: "cod1", "parafusos", 3
2. gardar os valores do producto creado   nun ficheiro denominado produtos.txt mediante os metodos adecuados de  DataOutputStream (amosados ao final deste texto)
3. crear outro  obxecto da clase Product  cos argumentos: "cod2","cravos",4
4. gardar os valores do producto creado no ficheiro produtos.txt 
5. despois  crear un obxecto tipo “producto” novo chamado po3 sen argumentos e cargar os seus atributos  a partires dos datos  dos productos que estan gardados  no ficheiro produtos.txt mediante DataInputSream, imprimindo os valores de ditas productos ( enténdese que primeiro cargo os datos de primeiro producto lido no obxecto po3 , e imprimo os valores e  e despois cargo os datos do seguinte  producto lido no mesmo obxecto po3 e volto imprimir os seus valores )

O resultado da execucion debe ser :
lista de productos gardados no ficheiro produtos.txt 

cod1 , parafusos , 1.0 

cod2 , cravos , 6.0

Metodos usados : cando gardedes os datos no ficheiro produtos.txt utilizar o metodo writeUtf para gardar os datos do codigo e a descripcion , e o metodo writeDouble para gardar o prezo      

## CopyCaracteres 

Imos traballar con fluxos de caracteres para o cal imos seguir a utilizar a clases da xerarquia Writer. 

FileWriter permite que conectemos o fluxo de caracteres a un ficheiro en modo escritura
Utilizando exclusivamente os metodos read() and write() das clases FileReader e FileWriter. 

Copia o contido dun ficheiro de texto  denominado  texto1.txt noutro denominado texto2.txt.
notas:
read()   retorna un caracter como un int. 
Se se tenta ler fora do ficheiro lese un -1
write(int c)     c e un int que representa o caracter a ser escrito        
O contido do ficheiro texto1.txt  podes crealo con calquera editor de texto plano e o seu
contido debe ser o seguinte:
 
a arbore 

o libro 

o neno 

## CopyCaracteresDos
copycaracteres2

BufferedWriter permite crear un buffer usando como argumento calquera obxecto heredadeo da clase Writer como FileWriter. 

PrintWriter admite tamen como argumento calquera obxecto heredado da clase Writer, como FileWriter ou BufferedWriter , e permite escribir datos no fluxo de salida  como tiras de caracteres usando os metodos print(argument)  e println (argument). 

print(argument) escribe a representacion en modo  caracter do argumento 
println (argument) escribe a representacion en modo  caracter do argumento seguido dun caracter de retorno de linea.
        
BufferedReader permite crear un buffer usando como argumento calquera obxecto heredadeo da clase Reader como FileReader, e dispon dos metodos readLine() e read()
readLine() le unha linea de texto e a retorna como un String. 

read() le un so caracter o retorna como un int que represnta o codigo ASCII para ese caraacter, cando tenta ler pasado o fin do ficheiro retorna un -1. 

Desenvolver  o que se pide no  exercicio anterior (copycaracteres) pero agora utilizando os metodos:
readLine() da   clase BufferedReader. 

println(argument) da clase PrintWriter que a sua vez  fara uso de BufferedWriter

## TextoDelimitado
graba nun ficheiro de texto delimitado mediante os metodos print e println da clase PrintWriter ,
os contidos dos tres arrays seguintes tendo en conta que cada tres elementos que  ocupan
a mesma posicion nos arrays representan a os campos dun rexistro dunha taboa de produtos,
onde cada produto ten un codigo unha descricion e un prezo:
 
String[] cod={"p1","p2","p3"}; 

String[] desc ={"parafusos","cravos","tachas"}; 

int[] prezo ={3,4,5};

Ten en conta que debes usar como separadores de campo  tabuladores : \t
e que os separadores de rexistros deben ser  retornos de linea : o metodo println(argumento)
da clase PrintWriter (BufferedWriter(FileWriter(File)) convirte o argumento nunha  cadea de
texto e inclue un cambio de linea ao final.
      
Despois de grabados ditos valores debes voltalos a ler rexistro a rexisto  mediante ao metodo readLine() da clase BufferedReader a cal lle pasamos como parametro a clase FilerReader cargando os seus valores nun obxecto da clase Product  e imprimindo os valores dos atributos de dito obxecto mediante un metodo da clase product que sobeescriba o seu metodo toString() da clase 

notas: cada vez que leas unha linea do ficheiro debes pasar  os valores de cada campo  a un array mediante a funcion de cadea "split()" ,  cargalos no   obxecto da clase Product para imprimilos a continuacion.
debes investigar na interede como usar a funcion de cadea split para separar os valores dun ha cadea
opcional: se observas o resultado impreso veras que os precios estan escritos co simbolo €   Podes investigar como facer isto (hai varios xeitos de facelo. Pista:  tes a clase NumberFormat que ten o metodo getCurrencyInstance() que te permite crear un obxecto NumberFormat con formato monetario , co cal podes dar formato monetario a un numero

run:
Codigo:        p1 

Descricion: parafusos 

Prezo:       3,00 € 


Codigo:        p2 

Descricion: cravos 

Prezo:       4,00 € 


Codigo:        p3 

Descricion: tachas 

Prezo:       5,00 € 

## Aleatorio
Gardar os contidos dos tres arrays seguintes nun ficheiro aleatorio (creado en modo lectura escritura)  tendo en conta que cada tres elementos que  ocupan a mesma posicion nos arrays representan un codigo unha descricion e un prezo:  
String[] codes={"p1","p2","p3"};   
String[] descricion ={"parafusos","cravos ","tachas"};   
int[] prices ={3,4,5};

nota: ter en conta que asignaremos unha lonxitude fixa a cada rexistro
así para o codigo asignaremos 3 caracteres(6 bytes), para a descrición 10caracteres(20bytes),  e o prezo por ser un  enteiro terá asignados 4 bytes, sendo o tamaño total do rexistro de 30 bytes
nota: a clase a usar e RandomAcessFile e os seus metodos para escritura e lectura de tipos primitivos de datos (writeChars(..)  , writeInt(..) , readChar()..readInt()) 

Antes de gravar os datos dun rexistro deberá  utilizarse   un método que encha cos espazos que faltan os campos   codigo e descricion ata completar as lonxitudes de ditos campos cun caracter calquera.
Pista : A clase String ten un metodo denonimado format que permite dar formato a unha cadea cadea :  format("%" + width + "s", t)  
onde:
width:   e o ancho final da cadea en numero de caracteres
t  :        e a cadea  
"%" : enche con blancos pola esquerda  (con "%"- encheria con blancos pola dereita)
se ademais lle aplicamos ao metodo format  o metodo   replace(' ', '0')     cambiara os blancos por ceros ( esto e interesante se nun primeiro momento queremos ver o efecto de aplicar ‘format’ porque os blancos non se ven na impresión pero os cero si)


Unha vez almacenados os tres rexistros no ficheiro aleatorio deberemos ler e amosar o contido dos campos do rexistro que ocupa a posicion numero 2  utilizando o metodo seek(int n  ) da clase RandomAccessFile que permite posicionarnos no byte indicado dentro de dito ficheiro.

Ter en conta que ao ler o rexistro deberemos voltar a separar os seus contidos e quitarlle os blancos ás cadeas de texto para poder poder  cargar correctamente ditos valores en variables java  adecuadas ( String)  excepto o valor que foi grabado con enteiro que simplemente debe ser convertido a enteiro mediante csteo.

e decir o resultado da consulta  deberia amosarse algo parecido a isto: 

p2  
cravos  
4

## SerializaciónUno
Crear unha clase chamada mclase que implemente a interfaz serializable  (implements Serializable). Dita clase debe ter tres atributos  :
unha variable String  (nome)  outra int (numero1) e outra double (numero2)

Dende  a  clase principal (a do proxecto) instanciar un obxecto da clase mclase
con tres valores:  "ola",-7, 2.7E10,   e almacenar dito obxecto  nun ficheiro denominado  'serial'
mediante o metodo writeObject(obxecto_a_grabar) da clase  ObjectOutputStream ( que debe recibir como parametro un obxecto da clase FileOutputStream("ruta do ficheiro a escribir”). Pecha o ficheiro .

Despois crea outro obxecto baleiro da clase mclase e carga posteriormente os seus atributos cos valores almacenados no ficheiro 'serial' anteriormente creado . Para isto debes usar o metodo readObject() da clase ObjectInputStream.

se todo funciona correctamente facer un cambio (deixando comentados as lineas que modifiquedes para facer este cambio) e repetir a execucion do proxecto : o cambio consistirá en  marcar a variable tipo int da clase mclase
como 'transient'  e comprobar que poñamos  o valor que poñamos nese campo int do obxecto a gardar   o resultado devolto será '0' (sería un nullo se a
variable transient fora a de tipo String

execucion antes do cambio
object1: s=ola; i=-7; d=2.7E10

execucion despois do cambio
object2: s=ola; i=0; d=2.7E10  
fin da comprobacion: recuperanse os  datos excepto i por ser transient

## SerializaciónDos
Utilizando  a serializacion de obxectos e partindo do array seguinte:  
String[] cod={"p1","p2","p3"};  
String[] desc ={"parafusos","cravos ","tachas"};   
int[] prezo ={3,4,5};

Crea tres obxectos tipo product e almacenaos nun ficheiro secuencial binario (FileOutputStream) utilizando os metodos adecuados da case ObjectOutputStream
para despois leelos dende dito ficheiro e imprimilos . facer este exercicio utilizando o bucle while para ler os obxectos almacenados
suponse que non sabemos cantos obxectos hai almacenados .

nota : o  metodo close() do ObjectOutputStream  non mete un null cando se executa dito metodo polo que se uso un  bucle while para lelo ata o final  non teño forma de saber onde remata, dandome o erro "/Exception during deserialization: java.io.EOFException "
O que podemos facer e gardar un null xusto antes de lanzar o close(()  deste xeito
cando lea os obxectos podo preguntar se o obxecto lido e un  null para deter o bucle de lectura.
(outra cousa que podemos facer e usar o metodo available() para ver canto queda por ler do ficheiro, se non queda nada rematamos e xa esta . pero CUIDADO : o metodo available() da clase ObjectInputStream non devolve o numero de bytes que quedan por ler senon o numero de bytes bloqueados , pero podemos usar o metodo available() da clase File InputStream porque ao fin e ao cabo ObjectInputStream esta  lendo os obxectos serializados  a traves de dita clase.)

# POSTGRES SQL

## BaseRelacionalAPostgres

Tratase de conectar dende java a Postres para efectuar operacions de consulta e manipulacion de datos contra taboas (select,insert,update, delete)

### PARTE 1

- dende o cliente psql lanzar o script produtos.sql como usuario oracle contra a base de datos postgres:

 'psql postgres'


\i *ruta do ficheiro produtos.sql*



isto creara una taboa chamda productos ca seguinte estructura:

	CODIGO     VARCHAR2(3)  primary key
	DESCRICION  VARCHAR2(15)
	PREZO	integer
	DATAC Date

- Comprobar dende sqlplus que a taboa  foi creada correctamente :

  \d produtos

### PARTE 2  APLICACION baserelacionalA


- engadir o  driver de postgres  á libreria do proxecto

- crear un metodo de nome 'conexion'  que devolva un obxecto tipo Connection chamado conn 
  que se conecte a base de datos postgres meiante o usuario oracle , con password oracle. 
  O obxecto Connection crease así:  
            
  String driver = "jdbc:postgresql:";

  String host = "//localhost:"; // tamen poderia ser una ip como "192.168.1.14"

  String porto = "5432";

  String sid = "postgres";

  String usuario = "oracle";

  String password = "oracle";

  String url = driver + host+ porto + "/" + sid;

  Connection conn = DriverManager.getConnection(url,usuario,password);
            


- Crear un metodo de nome 'insireProduto'  que permita inserir na taboa produtos unha fila pasandolle como parametros o codigo o nome e o prezo e a data de caducidade  dun produto

- Crear un metodo chamdo 'listaProdutos' que amose o contido dos rexistros que hai na base  (debe usarse crearse un resulSet e volcar o contido do mesmo ) 

- Crear un método de nome 'actualizaPre' tal que pasandolle o codigo e prezo dun rexistro actualize o campo  prezo do rexistro  que corresponde a dito  codigo.
	
- Crear un método de nome 'eliminaProduto' tal que pasandolle o codigo  dun rexistro elimine o rexistro  que corresponde a dito  codigo.


COMPROBACION :
- inserir varios rexistros na taboa mediante o metodo insireProduto creado anteriormente usando sentencias sql standard   
os rexistros a  inserir son
p1 , parafusos, 3, 27/12/2020
p2 , cravos , 4, 6/4/2020
p3, tachas, 6, 3/7/2020

- Comprobar dende sqlplus que os rexistros foron creados e que podemos actualizar ou borrar algun deles usando os metodos creados anteriormente. e dicir :
	
- ler os rexistros da taboa produtos do usuario hr mediante o metodo listaProdutos() creado anteriormente
- modifica o rexistro de codigo p2 poñendo o seu prezo ao dobre do que ten actualmente
- borra o rexistro de codigo p3


nota: facer todas as comprobacions que precisedes para asegurarvos que funcionan todos as tarefas mencionadas


METODOS  necesarios para desenvolver esta aplicacion:

para inserir , borrar ou modificar datos debemos crea previamente un obxecto Statement mediante o metodo createStatement() do obxecto Connection. Despois  en funcion do que queramos facer escolleremos unha ou outro opcion de entre os seguintesmetodos do obxecto Statement creado anteriormente
- inserir : metodo executeUpdate("orde_de_insercion_sql")
- consultar (mediante resulset fordwar_only, read_only (por defecto)): crear un obxecto ResultSet a partir de aplicar o metodo executeQuery("consulta") a o obxecto Statement e recorrelo cun bucle
- borrar : metodo executeUpdate("orde_de_borrado_sql")
- modificar: metodo executeUpdate("orde_de_modificacion_sql")