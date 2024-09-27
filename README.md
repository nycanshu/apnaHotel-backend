
<a name="_agpuec2c69ek"></a>ApnaHotel API Documentation.

<a name="_n14m4wqy359l"></a>Introduction

This is a complete overview of my recent project apnaHotel, which I did using JAVA, SpringBoot. 

All end points that as access among Admin or User, will require JWT token to verify their identity.
# <a name="_685vupmphvio"></a>1. Registration Services 👍
- ## <a name="_4xy76ved2ron"></a>Register User 
Description: Registers a new user in the system.

|Endpoint Url|/auth/register|
| :- | :- |
|Method|Post|
|Data |<p>{</p><p>`  `"email": "string",</p><p>`  `"name": "string",</p><p>`  `"phonenumber": "string",</p><p>`  `"password": "string",</p><p>`  `"role": "ADMIN or USER(Default)"</p><p>}</p>|
|Access|Anyone (no authentication required) |

- ## <a name="_x20vubf8bevn"></a>Login User
Description: Login a registered user in the system. Returns a JWT token that contains user identity along with role.

|Endpoint Url|/auth/login|
| :- | :- |
|Method|POST|
|Data |<p>{</p><p>`  `"email": "string",</p><p>`  `"password": "string"</p><p>}</p><p></p>|
|Access|Anyone (no authentication required) |

# <a name="_1oku0mrgnyc8"></a>2. Users Service 👍
- ## <a name="_dqhexji4hg0"></a>Get all users 
Description : Retrieves a list of all users.

|Endpoint Url|/users/all|
| :- | :- |
|Method|GET|
|Data |Requires JWT token in Auth Headers.|
|Access|Only Admin|

- ## <a name="_881kn68ihfa3"></a>Get user by ID 
Description : Returns a specific user by their ID.

|Endpoint Url|/users/get-by-id/{userId}|
| :- | :- |
|Method|GET|
|Data |` `UserId [Long (path parameter)]|
|Access|Anyone|

- ## <a name="_jss7q3sm8x0v"></a>Delete a user
Description : Deletes a user by their ID.

|Endpoint Url|/users/delete/{userId}|
| :- | :- |
|Method|DELETE|
|Data |` `UserId [Long (path parameter)]|
|Access|Only Admin|



- ## <a name="_peiv1fc3p6v1"></a>Get current logged-in user
Description : Returns the profile information of the currently logged-in user.

|Endpoint Url|/users/get-logged-in-profile-info|
| :- | :- |
|Method|GET|
|Data |` `None|
|Access|Anyone (must be logged in)|

- ## <a name="_aaqmsflnqcfi"></a>Get user booking history.
Description : Returns the booking history for a specific user.

|Endpoint Url|/users/get-user-bookings/{userId}|
| :- | :- |
|Method|GET|
|Data |` `UserId (path parameter)|
|Access|Anyone|


# <a name="_noyx60f701ed"></a>3. Room Services 👍
- ## <a name="_6iffgco46wma"></a>Add a new room.
Description : Add a new room to the hotel’s inventory.

|Endpoint Url|/rooms/add|
| :- | :- |
|Method|POST|
|Data |<p>` `FormData. (photo, roomType, roomPrice, roomDescription)</p><p>(All field required)</p>|
|Access|Only Admin|

- ## <a name="_4f6rs7q4sodb"></a>Update existing room.
Description : Updates the details of added rooms.

|Endpoint Url|/rooms/update/{roomId}|
| :- | :- |
|Method|PUT|
|Data |RoomId (path parameter)<br>FormData. (photo, roomType, roomPrice, roomDescription)<br>(All fields required)|
|Access|Only Admin|

- ## <a name="_qyujttesq3vv"></a>Get all the rooms.
Description : Returns List of all the rooms.

|Endpoint Url|/rooms/all|
| :- | :- |
|Method|GET|
|Data |None|
|Access|Anyone.|

- ## <a name="_bt4ll933b72i"></a>Get room types.
Description : Returns List of all types of rooms registered.

|Endpoint Url|/rooms/types|
| :- | :- |
|Method|GET|
|Data |None|
|Access|Anyone.|




- ## <a name="_8xgbd8duqkmz"></a>Get room types.
Description : Returns a specific room by its ID.

|Endpoint Url|/rooms/rom-by-id/{roomId}|
| :- | :- |
|Method|GET|
|Data |roomId [Path parameter]|
|Access|Anyone.|

- ## <a name="_bvu8fi7se9zf"></a>Get all available rooms.
Description : Returns a list of all available rooms. (Non booked rooms)

|Endpoint Url|/rooms/all-available-rooms|
| :- | :- |
|Method|GET|
|Data |None|
|Access|Anyone.|

- ## <a name="_q8g22hlzzq7x"></a>Get available rooms by Date and Type.
Description : Returns available rooms based on the specified check-in date, check-out date, and room type.

|Endpoint Url|/rooms/available-rooms-by-date-and-type |
| :- | :- |
|Method|GET|
|Data |<p>CheckIn Date, CheckOut Date, RoomType</p><p>(All fields required)</p>|
|Access|Anyone.|





- ## <a name="_k3y9qq2adobi"></a>Delete a room.
Description : Deletes a room by its ID.

|Endpoint Url|/rooms/delete/{roomId} |
| :- | :- |
|Method|DELETE|
|Data |RoomId as path parameter.|
|Access|Admin.|

# <a name="_3wzf5bk8jwvj"></a>4. Booking Services 👍 

- ## <a name="_qy83a633xji3"></a>Book a room.
Description : Creates a new booking for a room.

|Endpoint Url|/bookings/book-room/{roomId}/{userId}|
| :- | :- |
|Method|POST|
|Data |<p>roomId (path parameter)</p><p>userId (path parameter)</p><p>Booking object in the request body.</p><p>checkInDate: LocalDate</p><p>checkOutDate: LocalDate</p>|
|Access|Admin or User|


- ## <a name="_tvid9wyk10n0"></a>Get all bookings.
Description : Retrieves a list of all bookings.

|Endpoint Url|/bookings/all|
| :- | :- |
|Method|GET|
|Data |none|
|Access|Admin only|

- ## <a name="_p0rt5yjiu73o"></a>Get booking by confirmation code.
Description : Retrieves a booking by its confirmation code.

|Endpoint Url|/bookings/get-by-confirmation-code/{confirmationCode}|
| :- | :- |
|Method|GET|
|Data |confirmationCode as path variable|
|Access|Anyone|

- ## <a name="_pxd9w2tejc69"></a>Cancel Booking.
Description : Delete a booking by booking id.

|Endpoint Url|/bookings/cancel/{bookingId}|
| :- | :- |
|Method|DELETE|
|Data |Booking id as path parameter|
|Access|Admin or User|


