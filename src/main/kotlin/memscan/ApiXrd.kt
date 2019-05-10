package memscan

/**
 * memscan.XrdApi
 * provides [PlayerData]
 * provides [MatchData]
 */
interface XrdApi {

    /**
     * @return Is Xrd running and ready to serve data
     */
    fun isConnected(): Boolean

    /**
     * @return a List of the Xrd lobby's active players and their data
     */
    fun getPlayerData(): List<PlayerData>

    /**
     * @return data from current match
     */
    fun getMatchData(): MatchData

    /**
     * @return data from current lobby
     */
    fun getLobbyData(): LobbyData

}

data class PlayerData(
    val steamUserId: Long,
    val displayName: String,
    val characterId: Byte,
    val cabinetLoc: Byte,
    val playerSide: Byte,
    val matchesWon: Int,
    val matchesSum: Int,
    val loadingPct: Int
    // Lobby mini-health?
    // Lobby score marks?
    // Readied up?
)

data class MatchData(
    //val players: Pair<PlayerData, PlayerData>, TBA, maybe yoink steam id through login + DB or something
    val tension: Pair<Int, Int>,
    val health: Pair<Int, Int>,
    val burst: Pair<Boolean, Boolean>,
    val risc: Pair<Int, Int>,
    val isHit: Pair<Boolean, Boolean>
    //val beats: Pair<Int, Int>,
    //val timer: Int
    // Connection? : Int
    // Score marks? : Pair<Int, Int>
    // Damage taken? : Pair<Int, Int>
    // Button(s) pressed? : Pair<?, ?>
    // Direction pressed? : Pair<?, ?>
    // Tension Pulse? : Pair<Float, Float>
    // Stun level? : Pair<Int, Int>
)

data class LobbyData(
    val lobbyName: String
    // Open cabinets? : Int
    // Points for win? : Int
    // Time per match? : Int
    // Passworded? : Boolean
    // Winner/Loser Stays? : Int
    // Quality restriction? : Int
    // Serious/Casual match? : Boolean
    // Chat messages? : List<LobbyMessage>
)

class LobbyMessage(
    val userId: Long,
    val text: String
)

object Character {
    const val SO: Byte = 0x00 ;const val KY: Byte = 0x01 ;const val MA: Byte = 0x02 ;const val MI: Byte = 0x03 ;const val ZA: Byte = 0x04 ;const val PO: Byte = 0x05 ;const val CH: Byte = 0x06 ;const val FA: Byte = 0x07 ;const val AX: Byte = 0x08 ;const val VE: Byte = 0x09 ;const val SL: Byte = 0x0A ;const val IN: Byte = 0x0B ;const val BE: Byte = 0x0C ;const val RA: Byte = 0x0D ;const val SI: Byte = 0x0E ;const val EL: Byte = 0x0F ;const val LE: Byte = 0x10 ;const val JO: Byte = 0x11 ;const val JC: Byte = 0x12 ;const val JM: Byte = 0x13 ;const val KU: Byte = 0x14 ;const val RV: Byte = 0x15 ;const val DI: Byte = 0x16 ;const val BA: Byte = 0x17 ;const val AN: Byte = 0x18
    fun getCharacterName(byte: Byte, shortened: Boolean): String {
        when (byte) {
            SO -> if (shortened) return "SO" else return "Sol Badguy"
            KY -> if (shortened) return "KY" else return "Ky Kiske"
            MA -> if (shortened) return "MA" else return "May"
            MI -> if (shortened) return "MI" else return "Millia Rage"
            ZA -> if (shortened) return "ZA" else return "Zato=1"
            PO -> if (shortened) return "PO" else return "Potemkin"
            CH -> if (shortened) return "CH" else return "Chipp Zanuff"
            FA -> if (shortened) return "FA" else return "Faust"
            AX -> if (shortened) return "AX" else return "Axl Low"
            VE -> if (shortened) return "VE" else return "Venom"
            SL -> if (shortened) return "SL" else return "Slayer"
            IN -> if (shortened) return "IN" else return "I-No"
            BE -> if (shortened) return "BE" else return "Bedman"
            RA -> if (shortened) return "RA" else return "Ramlethal Valentine"
            SI -> if (shortened) return "SI" else return "Sin Kiske"
            EL -> if (shortened) return "EL" else return "Elpelt Valentine"
            LE -> if (shortened) return "LE" else return "Leo Whitefang"
            JO -> if (shortened) return "JO" else return "Johnny Sfondi"
            JC -> if (shortened) return "JC" else return "Jack-O Valentine"
            JM -> if (shortened) return "JM" else return "Jam Kuradoberi"
            KU -> if (shortened) return "KU" else return "Kum Haehyun"
            RV -> if (shortened) return "RV" else return "Raven"
            DI -> if (shortened) return "DI" else return "Dizzy"
            BA -> if (shortened) return "BA" else return "Baiken"
            AN -> if (shortened) return "AN" else return "Answer"
            else -> if (shortened) return "??" else return "???"
        }
    }
}