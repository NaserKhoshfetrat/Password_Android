# Java regex validate password examples

Secure Password requirements

1.  Password must contain at least one digit [0-9].
2.  Password must contain at least one lowercase Latin character [a-z].
3.  Password must contain at least one uppercase Latin character [A-Z].
4.  Password must contain at least one special character like  `! @ # & ( )`.
5.  Password must contain a length of at least 8 characters and a maximum of 20 characters.

Below is the regex that matches all the above requirements.

```plaintext

  ^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$
```


#
## 1. Regex password explanation

The password must contain at least one lowercase character, one uppercase character, one digit, one special character, and a length between 8 to 20. The below regex uses  [positive lookahead](https://www.regular-expressions.info/lookaround.html)  for the conditional checking.

```plaintext

^                                   # start of line
  (?=.*[0-9])                       # positive lookahead, digit [0-9]
  (?=.*[a-z])                       # positive lookahead, one lowercase character [a-z]
  (?=.*[A-Z])                       # positive lookahead, one uppercase character [A-Z]
  (?=.*[!@#&()–[{}]:;',?/*~$^+=<>]) # positive lookahead, one of the special character in this [..]
  .                                 # matches anything
  {8,20}                            # length at least 8 characters and maximum of 20 characters
$                                   # end of line

```

In regex, there is positive lookahead  `(?=)`  and negative lookahead  `(?!)`:

-   Positive lookahead  `(?=)`  ensures something  `followed by`  something else.
-   Negative lookahead  `(?!)`  ensures something  `NOT followed by`  something else.

For example,  `b(?=c)`  matches a  `b`  that is followed by a  `c`. (positive lookahead)  
For example,  `b(?!c)`  matches a  `b`  that is NOT followed by a  `c`. (negative lookahead)

[Java regex validate password refrence](https://mkyong.com/regular-expressions/how-to-validate-password-with-regular-expression/)