# SmartThings
Scripts and tools for SmartThings

### [Send-Events-to-EventGhost.groovy](https://github.com/aderusha/SmartThings/blob/master/Send-Events-to-EventGhost.groovy)
This SmartApp will send selected events to an EventGhost server running the Webserver plugin.

EventGhost is a Windows application used for event automation, find out more here: http://www.eventghost.org/

How to setup the EventGhost Webserver plugin: http://www.eventghost.org/mediawiki/index.php?title=Webserver

### [Link-Switch-And-Lock.groovy](https://github.com/aderusha/SmartThings/blob/master/Link-Switch-And-Lock.groovy)
I want to be able to control a lock device from a SmartApp that can only handle switch devices.  This SmartApp will link a lock and a button/switch device such that:
 *  Locking the lock will turn on the switch
 *  Unlocking the lock will turn off the switch
 *  Turning on the switch will lock the lock
 *  Turning off the switch will unlock the lock

### [Send-Trigger-to-Blue-Iris.groovy](https://github.com/aderusha/SmartThings/blob/master/Send-Trigger-to-Blue-Iris.groovy)
This SmartApp will send selected events to a Blue Iris server on the local network.

This requires the Blue Iris web server to allow un-authenticated connections.  In settings > Web Server > Advanced > Authentication select "Non-LAN only" (preferred) or "No" to disable authentication altogether.
