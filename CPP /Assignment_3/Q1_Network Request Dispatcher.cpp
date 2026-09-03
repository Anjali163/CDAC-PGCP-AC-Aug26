//============================================================================
// Name        : Q1_Network.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================
#include <iostream>
#include <string>
#include <vector>
#include <utility>

using namespace std;

// Part A: enum class
enum class HttpStatus {
    OK = 200,
    Created = 201,
    BadRequest = 400,
    Unauthorized = 401,
    NotFound = 404,
    ServerError = 500
};

// Part B: Type aliases
using Header = pair<string, string>;
using HeaderList = vector<Header>;
using Port = unsigned int;
using IPAddress = string;

typedef unsigned long long RequestId;


// Function to handle HTTP response
void handleResponse(HttpStatus status, const string& endpoint) {

    cout << "["
         << endpoint
         << "] → ";

    switch (static_cast<int>(status)) {

        case 200:
            cout << "200 OK : Request successful" << endl;
            break;

        case 201:
            cout << "201 Created : Resource created successfully" << endl;
            break;

        case 400:
            cout << "400 Bad Request : Invalid request" << endl;
            break;

        case 401:
            cout << "401 Unauthorized : Authentication required" << endl;
            break;

        case 404:
            cout << "404 Not Found : Endpoint does not exist" << endl;
            break;

        case 500:
            cout << "500 Server Error : Internal server error — retry later"
                 << endl;
            break;

        default:
            cout << "Unknown status code" << endl;
    }
}


// Function to print headers
void printHeaders(const HeaderList& headers) {

    cout << "Headers:" << endl;

    for (const auto& header : headers) {
        cout << " " << header.first
             << " : "
             << header.second
             << endl;
    }
}


int main() {

    // Part A
    handleResponse(HttpStatus::OK, "GET /api/users");

    handleResponse(HttpStatus::Unauthorized, "POST /api/login");

    handleResponse(HttpStatus::NotFound, "GET /api/products/99");

    handleResponse(HttpStatus::ServerError, "POST /api/order");


    // Part B
    HeaderList headers = {
        {"Content-Type", "application/json"},
        {"Authorization", "Bearer eyJhbGci..."},
        {"Accept-Language", "en-US"}
    };

    Port serverPort = 8080;

    RequestId requestId = 1748293847;

    cout << endl;

    cout << "Request ID : " << requestId << endl;
    cout << "Server Port : " << serverPort << endl;

    printHeaders(headers);

    return 0;
}
