package ge.lis.sim

import io.micronaut.runtime.Micronaut.*
import java.time.LocalDateTime
import java.time.ZoneOffset

fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("ge.lis.sim")
		.start()
}

fun timeNow(): Long {
	return LocalDateTime.now().toEpochSecond(ZoneOffset.UTC)
}
