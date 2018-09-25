package org.wit.placemark.main

import android.app.Application
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.wit.placemark.models.PlacemarkModel

class MainApp : Application(), AnkoLogger {

  var placemarks = ArrayList<PlacemarkModel>()

  override fun onCreate() {
    super.onCreate()
    info("Placemark started")
    placemarks.add(PlacemarkModel("One", "Desc one"))
    placemarks.add(PlacemarkModel("Two", "Two desc"))
    placemarks.add(PlacemarkModel("Three", "Three desc"))
    placemarks.add(PlacemarkModel("Four", "Four desc"))
  }
}