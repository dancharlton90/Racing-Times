# Racing-Times
Simple website to show racing laptimes

## Users `~/api/user`

`GET` - Returns list of all users including ID

`POST` - Add a new user
- `firstName` - First name of user (Required)
- `lastName` - Last name of user (Required)


## Venues `~/api/venue`

`GET` - Returns list of all venues including ID

`POST` - Add a new venue
- `name` - Name of venue (Required)
- `location` - Location of venue (Required)


## Races `~/api/race`

`GET` - Returns list of all races including ID

`POST` - Add a new race
- `date` - Date of the race (Must be formatted yyyy-MM-dd) (Required)
- `raceNumber` - Session number (One race consists of multiple sessions) (Required)
- `venueId` - Id number of the venue race was held (Required)
- `userIds` - List of users in the race (Optional)