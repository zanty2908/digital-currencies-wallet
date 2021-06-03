# Test-Case

| ID | Action | Description | Input | Expected Output | Actual Output | Test Result |
| ------------- | ------------- | ------------- |  ------------- | ------------- |  ------------- | ------------- |
| TC01 | Open app |  Check default list of currency | Has network | <img src="/doc/img/search-default.png" width="200"/> | <img src="/doc/img/search-default.png" width="200"/> | Passed | 
| TC02 | Open app |  Check list of currency when don't have network | Disconnected network | <img src="/doc/img/search-fetch-data-error.png" width="200"/> | <img src="/doc/img/search-fetch-data-error.png" width="200"/> | Passed |
| TC03 | Open setting > Change dark theme of device > Open app |  Check dark theme on search | Change dark theme of device | <img src="/doc/img/search-dark.png" width="200"/> | <img src="/doc/img/search-dark.png" width="200"/> | Passed |
| TC04 | Open app > In Search screen, input query to search|  Check list of result after searching | Input key: "l" | <img src="/doc/img/search-items.png" width="200"/> | <img src="/doc/img/search-items.png" width="200"/> | Passed |
| TC05 | Open app > In Search screen, input query to search|  Check empty list after searching | Input key: "lll" | <img src="/doc/img/search-empty.png" width="200"/> | <img src="/doc/img/search-empty.png" width="200"/> | Passed |
| TC06 | Open app > Open favorite screen|  Check empty list on favorite screen |  | <img src="/doc/img/favorite-empty.png" width="200"/> | <img src="/doc/img/favorite-empty.png" width="200"/> | Passed |
| TC07 | Open app > Click start button on an item list to favorite this item > Open favorite screen|  Check favorite an item |  | <img src="/doc/img/favorite-items.png" width="200"/> | <img src="/doc/img/favorite-items.png" width="200"/> | Passed |
| TC08 | Open setting > Change dark theme of device > Open app > Open favorite screen|  Check dark theme on favorite | Change dark theme of device | <img src="/doc/img/favorite-dark.png" width="200"/> | <img src="/doc/img/favorite-dark.png" width="200"/> | Passed |