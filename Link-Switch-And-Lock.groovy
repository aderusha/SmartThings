/**
 *  Link Switch and Lock
 *
 *  Link state between a switch and a lock. Switch On <=> Locked, Switch Off <=> Unlocked
 *
 *  https://github.com/aderusha/SmartThings/blob/master/Link-Switch-And-Lock.groovy
 *  Copyright 2015 aderusha
 *  Version 1.0.0 - 2015-09-13 - Initial release
 *
 *  I want to be able to control a lock device from a SmartApp that can only handle switch devices.  
 *  This SmartApp will link a lock and a button/switch device such that:
 *  - Locking the lock will turn on the switch
 *  - Unlocking the lock will turn off the switch
 *  - Turning on the switch will lock the lock
 *  - Turning off the switch will unlock the lock
 *
 *  To use this SmartApp, first create a virtual device using the On/Off Button Tile device type.
 *  Install this SmartApp, select your virtual On/Off Button Tile, then your lock.  
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
 */

definition(
	name: "Link Switch and Lock",
	namespace: "aderusha",
	author: "aderusha",
	description: "Link state between a switch and a lock. Switch On <=> Locked, Switch Off <=> Unlocked",
	category: "Convenience",
	iconUrl: "https://s3.amazonaws.com/smartapp-icons/Solution/doors-locks.png",
	iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Solution/doors-locks@2x.png"
)

preferences {
	section("When this switch is turned on") {
		input "switch1", "capability.switch", multiple: false, required: true
	}
	section("Lock this lock") {
		input "lock1", "capability.lock", multiple: false, required: true
	}
}    

def installed()
{   
	subscribe(switch1, "switch.on", onHandler)
	subscribe(switch1, "switch.off", offHandler)
	subscribe(lock1, "lock.locked", lockedHandler)
	subscribe(lock1, "lock.unlocked", unlockedHandler)
}

def updated()
{
	unsubscribe()
	subscribe(switch1, "switch.on", onHandler)
	subscribe(switch1, "switch.off", offHandler)
	subscribe(lock1, "lock.locked", lockedHandler)
	subscribe(lock1, "lock.unlocked", unlockedHandler)
}

def onHandler(evt) {
	log.debug evt.value
	log.debug "Locking lock: $lock1"
	lock1.lock()
}

def offHandler(evt) {
	log.debug evt.value
	log.debug "Unlocking lock: $lock1"
	lock1.unlock()
}

def lockedHandler(evt) {
	log.debug evt.value
	log.debug "Turning on switch: $switch1"
   	switch1.on()
}

def unlockedHandler(evt) {
	log.debug evt.value
	log.debug "Turning off switch: $switch1"
   	switch1.off()
}