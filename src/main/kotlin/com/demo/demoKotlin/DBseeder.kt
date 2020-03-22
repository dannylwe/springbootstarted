package com.demo.demoKotlin

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DBseeder(val hotelRepository: HotelRepository): CommandLineRunner {
    override fun run(vararg p0: String?) {
        this.hotelRepository.deleteAll()

        val ibis = Hotel("Ibis", 3, 40)
        val theContinental = Hotel("The Continental", 4, 90)
        val sheraton = Hotel(name="The Sheraton Hotel", classification = 5, nbRooms = 70)

        val hotels = mutableListOf(ibis, theContinental, sheraton)
//        hotels.add(ibis)
//        hotels.add(theContinental)
//        hotels.add(sheraton)

        this.hotelRepository.saveAll(hotels)
        println("-- Database has been created")
    }
}