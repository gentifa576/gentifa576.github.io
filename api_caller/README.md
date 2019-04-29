# APICallerManager
## What it does
```
Providing a building block for API Request and Response integration with API Manager that is able to simplify creation of API Caller
```
## Feature
```
1. Has a build-in logging method in a form of text
2. Response parser (currently based of json, json to json and xml to json)
3. Generified GET and POST HTTP Method construction (with Header)
4. Has Build-in Callback (optional to use) that handles Server Errors, Client Errors, and Success Calls
5. Centralized Util for XML & JSON
```
## How to Use
```
Intended structure for this is with this approach
APICallerBase -> SpecificAPICallerBase -> SpecificAPIMethodCaller

Ex:
APICallerBase -> WebCallerBase -> WebDailyWeatherCaller
```
### SpecificAPICallerBase (Abstract Class)
```
This class is intended to specify how the API behaves when doing API calls, and how you want to construct your request. You can also add other abstract method for use in the Specific Method Caller.

Method that are most likely to be overridden here:
call() call flow for this specific API
generateFetchRequest() can be overridden to append header
```
### SpecificAPIMethodCaller
```
This class is intended to handle how the specific calls and how to handle request creation and response parsing

Method that are most likely to be overridden here:
savedCallerEvent() saving specific event of the call, can be left with no op
createFetcherRequest() 
For POST HTTP method construct according to the supplier requirement (could be JSON, XML, XML RPC, Query String, etc)
For GET HTTP method do construct it as ObjectNode and return it with objectNode.toString() so it can be parsed to Query String
getResponseObject() if the response will be in JSON or XML format, do expect it to be returned as json(you can transform this to JsonNode with objectMapper.readTree(body)) and construct the result object from there
getErrorResponseObject() can be left NO OP, is used to construct result object in case of failure, to ease error identification
```
## TODO
```
Generifying call method so it doesn’t have to be specify by each supplier, since I believe it has generic flow (create header -> create request -> log request (optional) -> send request -> log response(optional) -> parse response)
Overload method which can simplify usage
```