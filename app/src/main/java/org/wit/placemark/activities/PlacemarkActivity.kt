package org.wit.placemark.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_placemark.*
import kotlinx.android.synthetic.main.activity_placemark_list.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.toast
import org.wit.placemark.R
import org.wit.placemark.main.MainApp
import org.wit.placemark.models.PlacemarkModel


class PlacemarkActivity : AppCompatActivity(), AnkoLogger {

  var placemark = PlacemarkModel()
  lateinit var app : MainApp

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_placemark)
    app = application as MainApp
    toolbarAdd.title = title

    btnAdd.setOnClickListener() {
      placemark.title = placemarkTitle.text.toString()
      placemark.description = placemarkDescription.text.toString()

      if (placemark.title.isNotEmpty() && placemark.description.isNotEmpty()) {
        app.placemarks.add(placemark.copy())
        info("add Button Pressed: Title: $placemarkTitle Description: $placemarkDescription")
        app.placemarks.forEach { info("add Button pressed: $it") }
        setResult(AppCompatActivity.RESULT_OK)
        finish()
      }
      else {
        toast ("Please enter a title and description")
      }
    }
  }
}
