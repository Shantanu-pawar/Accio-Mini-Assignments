Create a social media platform,
User = UserId, Name, Age, List<Post>, List<Notification>
Post = Content, Time , User,  Like;
Notification = Post, Time                                                
Description: A user will create a post and will receive notification wrt the post
(for likes).

POST API - Add a User

POST API - Add a Post under given user - done 
[by addding DTO save para- also set user into post]

POST API - Send a notification each time a post
is liked. [requesting dto also have user input and
updates into Posts]

PUT API - Like a given post [we'll do this by 
g etting uesrId as dto and then see each time 
in our post [likecount] ]

GET API - Find the user who got most overall 
likes over all posts [get all users]

