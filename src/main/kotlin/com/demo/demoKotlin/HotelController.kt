package com.demo.demoKotlin

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/hotels")
class HotelController(val hotelRepository: HotelRepository) {
    @GetMapping("/all")
    fun all(): MutableIterable<Hotel>? {
        return this.hotelRepository.findAll()
    }

    @GetMapping("/{name}")
    fun byName(@PathVariable(value = "name") name: String): List<Hotel> {
        val hotelByName = this.hotelRepository.findByName(name)
        return hotelByName
    }

    @PostMapping("/checking")
    fun checkIn(@RequestBody checkInRequest: CheckInRequest): Hotel {
        val hotel = this.hotelRepository.findByName(checkInRequest.hotelName)[0]
        var rooms = hotel.checkIn(nbGuests = checkInRequest.nbGuests)
        return hotelRepository.save<Hotel>(hotel)
    }
}