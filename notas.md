fonte de datos que pode ser un array xml bbdd recuso web
adaptador arrayadapter neste caso
view a vista na que presentar os datos mediante o adapter
lonxitude ne tempo de compilacion array
lonxitude en tempo de execucion arraylist
os adaptadores fan a funcion de non ter cambiar a loxica para usalo na capa de presentacion
tipos de gardado de ficheiros na memoria
os recursos van todos en minuscula
raw xa esta creado e esta en so lectura a idea é non empezar a creacion da bbdd non ten sentido, ficheiros prefeitos
interna /data/data/package/files
___
sd app dires
+ storage/sdcard/nome
+ /"/"/Android/data/package/files/fich

___
#fluxos
coidado co reader xa que non mete o token
openfileOutput() xa pon por nos na ruta da sd da app o ficheiro
os modos son interesantes
  mode_private
  append
  world read
  world write
___
getFilesDir dinos a ruta por defecto da app igual para o open que a crea ahi
```getExternalFilesDir()``` datos a ruta da app na sd idem

na interna /data/data/packageName/files

para borrar é metodo de **JAVA SE** de File delete
listar os contidos dos dires é usar **JAVA SE PLANO**
