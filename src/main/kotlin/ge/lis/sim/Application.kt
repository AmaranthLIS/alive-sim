package ge.lis.sim

import io.micronaut.runtime.Micronaut.run
import java.time.LocalDateTime
import java.time.ZoneOffset

fun main(args: Array<String>) {
	run(*args)
}



fun today(): Long {
	return LocalDateTime.now().toEpochSecond(ZoneOffset.UTC)
}
