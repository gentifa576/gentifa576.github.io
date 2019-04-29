# APICallerManager
## What it does
```
Providing a building block for API Request and Response integration with API Manager that is able to simplify creation of API Caller
```
## Feature
```
1. Generified GET and POST HTTP Method construction (with Header)
2. Single parent class to allow for more versatile use
```
## How to Use
```
Intended structure for this is with this approach
ApiCallerBase -> SpecificApiCallerBase -> SpecificApiMethodCaller

Ex:
ApiCallerBase -> WebCallerBase -> WebDailyWeatherCaller
```
### SpecificAPICallerBase (Abstract Class)
```
This class is intended to specify how the API behaves when doing API calls, and how you want to construct your request. You can also add other abstract method for use in the Specific Method Caller.

Method that are most likely to be overridden here:
call() call flow for this specific API
```
### SpecificAPIMethodCaller
```
This class is intended to handle how the specific calls and how to handle request creation and response parsing

Method that are most likely to be overridden here:
generateRequest()
generateResponse()
generateUrl()
```
## TODO
```
1. Generifying call method so it doesn’t have to be specify by each supplier, since I believe it has generic flow (create header -> create request -> log request (optional) -> send request -> log response(optional) -> parse response)
2. Overload method which can simplify usage
3. savedCallerEvent() saving specific event of the call, can be left with no op
4. Build-in Callback (optional to use) that handles Server Errors, Client Errors, and Success Calls
5. Centralized Util for XML & JSON
6. Response parser (currently based of json, json to json and xml to json)
7. Has a build-in logging method in a form of text
8. Exploring other Http Client such as Apache, Jetty, etc
```