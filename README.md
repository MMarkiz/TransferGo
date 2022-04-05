
**API**  
[https://my.transfergo.com/api/fx-rates?from=EUR&to=DKK&amount=100](https://my.transfergo.com/api/fx-rates?from=EUR&to=DKK&amount=100)

**Supported currencies**  
DKK, EUR, GBP, HUF, NOK, PLN, RON, SEK

**Project**  
There is skeleton project, invitation to repository sent to your email 

**We would expect you to**  
1.  Finish/improve/refactor existing project (please, create separate branch for your work)
2.  Keep using selected technologies: MVVM, Dagger Hilt, RxJava, DataBinding
3.  Follow Clean Architecture principles
4.  Write some unit tests

**How we review**  
Your application will be reviewed by a senior engineer. We do take into consideration your experience level.  
We value quality over feature-completeness. It is fine to leave things aside provided you call them out in your project’s README. The goal of this code sample is to help us identify what you consider production-ready code. You should consider this code ready for final review with your colleague, i.e. this would be the last step before deploying to production.  
The aspects of your code we will assess include:  

-   Clarity: does the README clearly and concisely explains the problem and solution? Are technical tradeoffs explained?
-   Correctness: does the application do what was asked? If there is anything missing, does the README explain why it is missing?
-   Code quality: is the code simple, easy to understand, and maintainable? Are there any code smells or other red flags? Does object-oriented code follows principles such as the single responsibility principle? Is the coding style consistent with the language’s guidelines? Is it consistent throughout the codebase?
-   Testing: are there minimum sufficient unit / integration tests? Are those extensible?
-   Technical choices: do choices of libraries, databases, architecture etc. seem appropriate for the chosen application?
-   Design quality: is your system design addressing the scope (functional enough)? Do you recognise key non-functional aspects (quality of service)?

**Design**  
**![](https://github.com/TransferGo/android-trial-day/blob/master/698885ab-d97a-4c36-a86f-4907192db174.png)**


**Task feedback**

Due to the amount of time needed for this feature to fully work with the correct architecture, I chose to focus on architecture and refactoring. Below are some points, what has been done and what needs to be done to make this feature works as it should be.

**DONE** 
1. Moved hardcoded strings, dimens, colors to strings.xml, dimens.xml, and colors.xml
2. Added input types
3. Added domain layer
4. Renamed classes to more appropriate names 
5. Enabled minifyEnabled in release mode
6. Removed operation on Service in Fragment (added layers Service -> Repository -> UseCase -> ViewModel -> Fragment)
7. Disabled convert button when api call is ongoing
8. Removed unused dimens.xml for specific variants (Support for those variants can be added later)
9. Changed Amount Input type to numberDecimal
11. Added example UT

**TODO**
1. Add dropdown menu for currencies (create adapter etc.)
2. Add Amount validation
3. Handle UI for Tablets and Land mode
4. Modularize project (Most important separate data/domain/android layers)
5. Add proguard rules
6. Move BASE_URL to gradle and add flavours Prod/Staging etc.
7. Update libraries versions
8. Handle Loading and error states
9. Add IT tests
10. Add missing UT
11. Api error handling (status codes etc. on data layer)
12. Update Night mode

**IDEAS**
1. Add some accessibility modifiers
2. Change DataBinding approach to ViewBinding (Better readability, not exposing MutableLivedata)