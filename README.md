# Documentation

## Website

https://docs.google.com/spreadsheets/d/1gBWmnAfm0QqMkJO-lCKmLDCUW5SPX8B8D7o5vJEK_rA/edit?usp=sharing_eil&ts=67c1bcd5

# NPL Tools Repository

## Project Structure

Project: npl

    - ToolsApi

        Main Spring Boot API

    - resources/wordlists
    
        Intended for storing wordlists for searches/matching

    - words_alpha.txt

        https://github.com/dwyl/english-words

    - testing framework

        java.co.santyx.npl.testing.npl

    - HttpRequestTest.java

        Intended for testing API HTTP endpoints


## APIs

    Current package: co.santyx.npl
    This is the personal domain of Peter Turner (Syntax753). This can be migrated once a domain is decided for NPL

    APIs are provided via Spring Boot RESTful webservices. Currently these are under version /v1/

## Endpoints

    - Letter Bank

        http://localhost:8080/v1/letter-bank

        Purpose: Filtering unique characters. Same ordering

        Example: abcabdef -> abcdef

    - Sort

        http://localhost:8080/v1/sort

        Purpose: Sorting characters

        Example: azhufrnjfe -> aeffhjnruz

    - Word Match

        http://localhost:8080/v1/word-match

        Ref: https://aaronson.org/wordlisted/

        Purpose: Regex search for words in wordlist

        Available wordlists:
            
            - words_alpha.txt

## Future state

    - GitHub Actions for Cloud deployment
    - API Gateway

## Discussions

    - [ ] Cloud Platform decision
    - [ ] Alternative wordlists  
