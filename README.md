### Design
1. Simple RulesEngine `com.example.myntcostapi.engine.RulesEngine` implementation:
    * adding rules by creating java class which extends Rule `com.example.myntcostapi.interfaces.Rule` interface, and add it on Beans `com.example.myntcostapi.configuration.Beans`, take note that the order is defined when adding it.
    * removing rules by just remove it on Beans and you can also remove the java file
    * priority update on rules by just adjusting the order how rule will be added
    * update of condition and other stuff on rules can be achieved by updating in the specific rule implementation
    * (Future plans) - rules can be external or maybe some portion of it.
2. ControllerAdvice - this will handle all the exceptions and create error responses
3. Validation - validations on the request body
4. Dependency Injection - uses spring's dependency injection for auto initialization and dependency injection of classes

### Testing
API URL
```shell
POST http://localhost:8080/api/v1/deliveryCost
{
    "weight": 49,
    "height": 10,
    "width": 10,
    "length": 10,
    "voucherCode": "MYNT"
}
```

Sample Responses:
1. Success with no voucher code
```shell
{
    "weight": 49.0,
    "volume": 1000.0,
    "cost": 980.0
}
```
2. Success with voucher code
```shell
{
    "weight": 49.0,
    "volume": 1000.0,
    "cost": 967.75,
    "originalCost": 980.0,
    "discount": 12.25,
    "discounted": true
}
```
3. Validation errors on fields
```json
{
    "code": "VALIDATION_EXCEPTION",
    "message": "[width must not be null; length must not be null; weight must not be null; height must not be null]"
}
```
4. If weight field exceed 50
```shell
{
    "code": "RUNTIME_EXCEPTION",
    "message": "Rejected - Parcel exceed 50kgs"
}
```
5. Error on fetching from voucher client
```shell
{
    "code": "RUNTIME_EXCEPTION",
    "message": "Error on getting voucher details: I/O error on GET request for \"https://mynt-exam.mocklab.ioa/voucher/MYNT\": mynt-exam.mocklab.ioa; nested exception is java.net.UnknownHostException: mynt-exam.mocklab.ioa"
}
```

### Unit Test
Haven't added it since it would take more time, but if you let me I am capable of doing unit testing in Mockito and Powermock