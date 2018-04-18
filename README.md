# RanName

**RanName** is a random user name generator. It can generate any number of random users at one time.

## How To

There are many important parameters needed to be considered when use this generator **:**
  - (int) nameLen
  - (int) pwdLen
  - (int) userNum
  - (String) userTokens
  - (String) outPutFile

`nameLen` is the length of user name. `pwdLen` is the length of password. `userNum` is the number of users to be generated. `userTokens` is the specific string that is required to be part of the user name. `outPutFile` is the file that store all generated users.

`userTokens` can receive string with space. But in processing, the space within string will be trimed, and there will always have an underscore `_` be attached to the end of the string. For example, if the value of `userTokens` is `a b c`, then the tokens in user name will be `abc_`.

You can access generated users directly without saving to file. The class `RanNameGenerator` uses `ArrayList<ArrayList<String>>` to store all generated users, and function `getStoredUsers()` will return the result. 

### Constructor

`RanName(nameLen, pwdLen, userNum, userTokens, outPutFile)`

Here is the example of how to create users without saving to file **:**
  ```
  RanName a = new RanName(20, 20, 5, "user", "");
  RanNameGenerator b = new RanNameGenerator(a);
  b.createUsers(); // Create users
  ```
