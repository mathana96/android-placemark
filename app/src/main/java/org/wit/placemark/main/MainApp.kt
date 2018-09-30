package org.wit.placemark.main

import android.app.Application
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.wit.placemark.models.PlacemarkMemStore
import org.wit.placemark.models.PlacemarkModel

class MainApp : Application(), AnkoLogger {

  var placemarks = PlacemarkMemStore() //New placemarkmemstore class

  override fun onCreate() {
    super.onCreate()
    info("Placemark started")
//    placemarks.create(PlacemarkModel(0, "One", "One desc"))
//    placemarks.create(PlacemarkModel(1, "Two", "Two desc"))
//    placemarks.create(PlacemarkModel(2, "Three", "Three desc"))
//    placemarks.create(PlacemarkModel(3, "Four", "Four desc"))
  }
}