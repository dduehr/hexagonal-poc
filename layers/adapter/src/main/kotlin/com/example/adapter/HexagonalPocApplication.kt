package com.example.adapter

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.example"])
class HexagonalPocApplication

fun main(args: Array<String>) {
	runApplication<HexagonalPocApplication>(*args)
}
