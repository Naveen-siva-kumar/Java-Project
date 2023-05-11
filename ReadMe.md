/**
Author : Naveen
*/

////////////////////                     for compilation classs path is needed                ////////////////////
////////////////////                   server ip number is given in client directly           ////////////////////

The services provided here are  1) Group Chat with GUI
				2)Cows and Bulls Game
				3)Convertor
				4)Graph Plotting
	---->Graph Plotting
		-- In this service user have to enter how many points he would like to plot and enter (x,y) coordinates as prompted.
		-- User will get image on screen and it will be stored as JPEG image for future use.
		-- If user enters any wrong input then this will be taken as 0.0 (default).
	
	
	---->Convertor
		-- In this service user have to enter the convertion and to which he/she want to convert as prompted.
		-- 0.0 is default answer for any wrong inputs.
	
	
	---->Cows and Bulls Game
		-- In this service 3 levels are provided depending on the size of the word eg:4,5,6
		-- User have to choose the level first.
		-- User will be given number of chances according to the levels.
		-- User have to guess the word.
		-- If the letter in the word matches exactly  then that will be given as bull and if the letter exist it some other place then it 			   is cow.
		-- Example :
			Let the assumed word be     word
				you guessed         bird    here r,d are in exact positions so they are bulls.
				you guessed         road    here o,d are in exact positions so 2 bulls and r is in some other position so it is a 								    cow.
				
		-- Default level is 1.
	---->Group chat
		-- In this service user have to enter the message in the box and click send then it will be broadcasted to all the clients 			   connected to server.
		
		
		
		
		
		
		
		//////////////////////////////////////////////// CLASS PATH ////////////////////////////
		
		Relative to main :/org/jfree/jfreechart-1.0.17.jar and org/jfree/jcommon-1.0.21.jar and path must be given till main
		
		
