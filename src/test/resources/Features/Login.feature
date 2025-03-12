Feature: Login functionality

Background:
  Given user on login page

@Valid_credential

  Scenario Outline: User should be able to login with valid data
    When user provide <username> and <password> 
   

    Examples: 
      | username  							   |  password    | 
      #| "dev70.scriptus@gmail.com" |  "Test@123"  |  
      | "dev66.scriptus@gmail.com" |  "Test@1234" |
    
    
    
@InValid_credential

  Scenario Outline: User should be able to login with Invalid data
    When user provide invalid <username> and <password> 
   

    Examples: 
      | username  							      |  password    | 
      | "dev70+1.scriptus@gmail.com"  |  "Test@123"  |  
      | "dev66+1.scriptus@gmail.com"  |  "Test@12"   |
    