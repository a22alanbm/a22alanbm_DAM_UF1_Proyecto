package com.example.uf1_proyecto.character

class Personaje {
    companion object{ var usedIds: Int? = 0}
    var owner: String? = ""
    var id: String? = ""
    var imagePath: String? = ""
    var master: String? = ""
    var notas: Notas? = Notas()
    var datos: Datos? = Datos()
    var hitos: String? = ""
    var drama: Drama? = Drama()
    var distorsion: Distorsion? = Distorsion()
    var cordura: Estado? = Estado()
    var salud: Estado? = Estado()
    var caracteristicas: Caracteristicas? = Caracteristicas()
    var habilidades: Habilidades? = Habilidades()
    var habilidadesArcanas: HabilidadesArcanas? = HabilidadesArcanas()
    var lazos: Lazos? = Lazos()
    var equipo: String? = ""
    var combate: Combate? = Combate()

    constructor(){
        id = usedIds.toString()
        usedIds = usedIds?.plus(1)
    }
    constructor(owner: String?) {
        this.owner = owner
    }

    fun hasMaster(): Boolean {
        return master != null
    }
}
