package org.wit.placemark.activities

import android.os.Bundle
import android.support.v4.app.ActivityCompat.startActivityForResult
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_placemark.*
import kotlinx.android.synthetic.main.activity_placemark_list.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.startActivityForResult
import org.jetbrains.anko.toast
import org.wit.placemark.R
import org.wit.placemark.R.id.*
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
    setSupportActionBar(toolbarAdd)

    if (intent.hasExtra("placemark_edit")) {
      placemark = intent.extras.getParcelable<PlacemarkModel>("placemark_edit")
      placemarkTitle.setText(placemark.title)
      placemarkDescription.setText(placemark.description)
      val savePlacemark: String = getString(R.string.button_savePlacemark)
      btnAdd.text = savePlacemark
    }
    btnAdd.setOnClickListener() {
      placemark.title = placemarkTitle.text.toString()
      placemark.description = placemarkDescription.text.toString()



        if (placemark.title.isNotEmpty() && placemark.description.isNotEmpty()) {
          val defaultTitle: String = getString(R.string.hint_placemarkTitle)
          val defaultDesc: String = getString(R.string.hint_placemarkDescription)

          if (intent.hasExtra("placemark_edit")) {
            app.placemarks.update(placemark)
            info("Update Button Pressed: Title: $placemarkTitle Description: $placemarkDescription")
          }
          else {
            app.placemarks.create(placemark.copy())
            info("Create Button Pressed: Title: $placemarkTitle Description: $placemarkDescription")
          }
          setResult(AppCompatActivity.RESULT_OK)
          finish()
        }
        else {
          val toastTitleDesc: String = getString(R.string.toast_enterTitleandDesc)
          toast (toastTitleDesc)
        }

      }
  }

  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.menu_cancel, menu)
    return super.onCreateOptionsMenu(menu)
  }

  override fun onOptionsItemSelected(item: MenuItem?): Boolean {
    //When item has itemID, let R.id.item_add trigger (->) the new activity (assisted by anko events)
    when (item?.itemId) {
      R.id.menu_cancel -> startActivityForResult<PlacemarkListActivity>(0)
    }
    return super.onOptionsItemSelected(item)
  }
}
