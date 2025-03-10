package kotlinsource.chap3

data class Member(
    var name: String,
    var address: String
) {

    fun saveV1(member: Member) {
        val (name, address) = member
        if (name.isEmpty()) {
            throw IllegalArgumentException()
        }
        if (address.isEmpty()) {
            throw IllegalArgumentException()
        }
        // save in db
    }

    fun saveV2(member: Member) {
        fun validate(value: String) {
            if (value.isEmpty()) throw IllegalArgumentException()
        }

        validate(this.name)
        validate(this.address)
        // save in db
    }

    fun saveV3(member: Member) {
        validateMember()
        // save in db
    }
}

fun Member.validateMember() {
    fun validate(value: String) {
        if (value.isEmpty()) throw IllegalArgumentException()
    }

    validate(this.name)
    validate(this.address)
}

