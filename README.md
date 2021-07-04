# Kotlin Scripts 🚀 
Before you running several command in your terminal, please ensure you have installed the Kotlin compiler. For more details please read kotlin documentation here [Kotlin command-line compiler](https://kotlinlang.org/docs/command-line.html). I want to highlight for how to install the Kotlin compiler in your local machine, please following steps below :

📝 Install Kotlin on UNIX-based systems such as OS X, Linux, Cygwin, FreeBSD, and Solaris is [SDKMAN!](https://sdkman.io/)! To install the Kotlin compiler via SDKMAN!, run the following command in a terminal :

```$sdk install kotlin```

📝 Alternatively, on OS X you can install the compiler via [Homebrew](https://brew.sh/) from the command line :

```
$brew update
$brew install kotlin
```
📝 If you use [Snap](https://snapcraft.io/) on Ubuntu 16.0.4 or later, you can install the compiler from the command line :

``` $sudo snap install --classic kotlin ```

### Testing API Endpoints using Terminal Android Studio without Postman
1. If you have kotlin scripts file inside other directory. Please ensure navigate up one directory level, run the following command in a terminal for example : ```cd scripts``` scripts is directory name.

2. Execute kotlin scripts file, run the following command in a terminal : ```kotlin api-endpoint-test.main.kts```

3. Input host url type *(e.g.: github, spotify)*. For this case we provide [github](https://docs.github.com/en/rest/overview/endpoints-available-for-github-apps) and [spotify](https://developer.spotify.com/documentation/web-api/reference/#category-users-profile) endpoints as host url type. Run the following command in a terminal : 
   
   <img width="536" alt="Screen Shot 2021-07-04 at 14 26 29" src="https://user-images.githubusercontent.com/17380222/124375242-d41fdc00-dcd3-11eb-8031-229882897de3.png">
   
4. Input endpoint that you will testing. For example in this case, we input ```events``` as endpoint github apps.
      
      <img width="545" alt="Screen Shot 2021-07-04 at 14 28 45" src="https://user-images.githubusercontent.com/17380222/124375307-25c86680-dcd4-11eb-8120-de2974380c8a.png">
      
5. Input OAuth Token (if using spotify API), this section you can skip for input token if you choosing github API.

      <img width="559" alt="Screen Shot 2021-07-04 at 14 33 57" src="https://user-images.githubusercontent.com/17380222/124375460-e0586900-dcd4-11eb-9354-73682aa3fa0a.png">

6. After input oAuth token section is done. Script will show information to waiting response from API. Then, we will see response success or failure.

      <img width="645" alt="Screen Shot 2021-07-04 at 14 37 24" src="https://user-images.githubusercontent.com/17380222/124375543-5c52b100-dcd5-11eb-9f96-661bd7814961.png">


