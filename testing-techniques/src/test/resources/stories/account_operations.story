Meta: @financial

Narrative:
As a user
I want to be able to withdraw and debit into an account
So that I can be in control of my money

Scenario: withdrawing money
Given account has balance [current-balance]
When I withdraw [amount-withdrawn]
Then the account has a balance of [new-balance]

Examples:
|current-balance|amount-withdrawn|new-balance|
|100            |10              |90               |
|30             |2               |28               |

Scenario: depositing money
Given account has balance [current-balance]
When I deposit [amount-deposited]
Then the account has a balance of [new-balance]

Examples:
|current-balance|amount-deposited|new-balance|
|100            |10              |110        |
|30             |2               |32         |


Scenario: withdrawing money exceeding the current balance
Given account has balance [current-balance]
When I withdraw [amount-withdrawn]
Then the withdrawal is rejected

Examples:
|current-balance|amount-withdrawn|
|100            |101             |
|30             |121             |