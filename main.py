class Proceso:
    pid = ''
    tiempoEjecucion = ''
    recursos = ''

class Particion:
    numero = ''
    recursos = ''

M1 = Particion()
M1.numero=0
M1.recursos=7

M2 = Particion()
M2.numero=1
M2.recursos=5

M3 = Particion()
M3.numero=2
M3.recursos=9

P1 = Proceso()
P1.pid='0'
P1.tiempoEjecucion=5
P1.recursos=6