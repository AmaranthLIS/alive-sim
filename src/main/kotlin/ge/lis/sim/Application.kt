package ge.lis.sim

import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("ge.lis.sim")
		.start()
}

