Meta: @simple

Narrative:
As a user
I want to be able to initialize an account
So that I can use that object

Scenario: initialize an account with values succeeds
Given a new account is created
Given account is for user Rob
Given account has number 123
Given account initial balance is 100
When I initiate the account with those values
Then the account state should reflect those values