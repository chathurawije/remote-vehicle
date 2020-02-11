# Getting started

	unzip 'remotevehicle-0.0.1-SNAPSHOT-distribution.zip' in the target folder
	run start.bat


# Allowed commands

	START X,Y,<DIRECTION>
	Will put the vehicle at position X, Y on the grid facing one of four directions(NORTH, SOUTH, EAST, WEST).
	
	FORWARD
	Will move the vehicle forward one space in the direction it is facing.
	
	TURN_LEFT
	Will rotate the vehicle anti-clockwise in its current position 90 degrees in the corresponding direction.
	
	TURN_RIGHT
	Will rotate the vehicle clockwise in its current position 90 degrees in the corresponding direction.
	
	PING
	Will cause the position of the vehicle to be printed out in the console.
	

--------------------------------
		
	
# Creating new distribution

	run 'mvn clean package' command in cmd on pom file location.
	'remotevehicle-0.0.1-SNAPSHOT-distribution.zip' will be created in the target folder.
	
		