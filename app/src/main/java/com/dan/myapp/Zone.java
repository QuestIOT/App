package com.dan.myapp;

/**
 * Created by dan_1 on 17-Mar-16.
 *
 * Is the getters and setters for the zones
 Copyright (C) 2016 Quest

 This program is free software; you can redistribute it and/or
 modify it under the terms of the GNU General Public License
 as published by the Free Software Foundation; either version 2
 of the License, or (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program; if not, write to the Free Software
 Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
public class Zone {

    private String name = "";
    private int maxCar = 0;
    private int curCar = 0;

    public Zone(String name, int maxCar, int curCar) {
        this.name = name;
        this.maxCar = maxCar;
        this.curCar = curCar;
    }


    public String getName() {
        return name;
    }

    public int getMaxCar() {
        return maxCar;
    }

    public int getCurCar() {
        return curCar;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaxCar(int maxCar) {
        this.maxCar = maxCar;
    }

    public void setCurCar(int curCar) {
        this.curCar = curCar;
    }
}