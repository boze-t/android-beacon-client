package com.boze.beacon

import android.app.Application
import android.util.Log
import org.altbeacon.beacon.BeaconManager
import org.altbeacon.beacon.BeaconParser
import org.altbeacon.beacon.Region
import org.altbeacon.beacon.startup.BootstrapNotifier
import org.altbeacon.beacon.startup.RegionBootstrap

class MyApplication : Application(), BootstrapNotifier {

    private val IBEACON_FORMAT = "m:2-3=0215,i:4-19,i:20-21,i:22-23,p:24-24"

    private lateinit var regionBootstrap: RegionBootstrap
    private lateinit var beaconManager: BeaconManager

    override fun onCreate() {
        super.onCreate()

        beaconManager = BeaconManager.getInstanceForApplication(this)
        beaconManager.beaconParsers.add(BeaconParser(IBEACON_FORMAT))

        val region = Region("896D0CC8-EEEB-45A4-BA99-140BB441B7EB", null, null, null)
        regionBootstrap = RegionBootstrap(this, region)
    }

    override fun didDetermineStateForRegion(p0: Int, p1: Region?) {
        Log.d("boze", "Determine State:" + p0)
    }

    override fun didEnterRegion(p0: Region?) {
        Log.d("boze", "Enter Region")
    }

    override fun didExitRegion(p0: Region?) {
        Log.d("boze", "Exit Region")
    }
}