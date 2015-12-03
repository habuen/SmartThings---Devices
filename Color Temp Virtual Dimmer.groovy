/**
 *  Copyright 2015 SmartThings
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 *  Color Temp Virtual Dimmer - to be used with Color Temp via Virtual Dimmer SmartApp to make color temp adjustments in common SmartApps
 *
 *  Author: Scott Gibson
 *
 *  Date: 2015-03-12
 */
metadata {
	definition (name: "Color Temp Virtual Dimmer", namespace: "sticks18", author: "Scott Gibson") {
		capability "Actuator"
        capability "Switch Level"
	
	}

	// simulator metadata
	simulator {
	}

	// UI tile definitions
	tiles {
    	valueTile("level", "device.level", inactiveLabel: false, decoration: "flat") {
			state "level", label: 'Level ${currentValue}%'
		}
        controlTile("levelSliderControl", "device.level", "slider", height: 1, width: 2, inactiveLabel: false) {
			state "level", action:"switch level.setLevel"
		}
		main "level"
		details "levelSliderControl", "level"
	}
}

def parse(String description) {
}

def setLevel(value) {
	sendEvent(name: "level", value: value)
    parent.setLevel(this, value)
}
