//============================================================================
// Name        : Q3_.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <cstring>

using namespace std;


class LogBuffer {

private:

    char* buffer;
    int capacity;
    int size;

    static int instanceCount;

public:

    // =========================================
    // Constructor
    // =========================================

    LogBuffer(int capacity) {

        this->capacity = capacity;
        this->size = 0;

        buffer = new char[capacity];

        buffer[0] = '\0';

        instanceCount++;

        cout << "[LogBuffer Created] capacity="
             << capacity << endl;
    }


    // Copy Constructor


    LogBuffer(const LogBuffer& other) {

        capacity = other.capacity;
        size = other.size;

        // Allocate NEW memory
        buffer = new char[capacity];

        // Deep copy
        memcpy(buffer, other.buffer, size + 1);

        instanceCount++;

        cout << "[LogBuffer Deep Copied] capacity="
             << capacity << endl;
    }


    // Copy Assignment Operator


    LogBuffer& operator=(const LogBuffer& other) {

        // Self-assignment check
        if (this == &other) {

            cout << "[Self-assignment detected — no operation]"
                 << endl;

            return *this;
        }

        // Release old memory
        delete[] buffer;

        // Copy data
        capacity = other.capacity;
        size = other.size;

        // Allocate new memory
        buffer = new char[capacity];

        // Deep copy
        memcpy(buffer, other.buffer, size + 1);

        cout << "[LogBuffer Assigned]" << endl;

        return *this;
    }



    // Destructor


    ~LogBuffer() {

        delete[] buffer;

        instanceCount--;

        cout << "[LogBuffer Destroyed]" << endl;
    }



    // append()


    void append(const char* msg) {

        int msgLength = strlen(msg);

        // Calculate available space
        int available = capacity - size - 1;

        // If message is longer than available space
        if (msgLength > available) {
            msgLength = available;
        }

        // Copy characters into buffer
        memcpy(
            buffer + size,
            msg,
            msgLength
        );

        size += msgLength;

        // Null terminate
        buffer[size] = '\0';
    }


    // print()

    void print() const {

        cout << buffer << endl;
    }



    // clear()


    void clear() {

        size = 0;
        buffer[0] = '\0';
    }



    // Static function


    static int getInstanceCount() {

        return instanceCount;
    }
};


// Initialize static member
int LogBuffer::instanceCount = 0;


int main() {


    // Objective 1 : Basic usage

    LogBuffer log1(256);

    log1.append("Server started on port 8080");

    log1.append(
        " | Request received from 192.168.1.10"
    );

    log1.print();


    // Objective 2 : Deep copy


    LogBuffer log2 = log1;

    log2.append(" | Cached response sent");

    cout << "log1 : ";
    log1.print();

    cout << "log2 : ";
    log2.print();

    // Objective 3 : Copy assignment

    LogBuffer log3(128);

    log3 = log1;

    log3.print();


    // Objective 4 : Self-assignment


    log1 = log1;

    log1.print();



    // Objective 5 : Static member


    cout << "Live LogBuffer objects : "
         << LogBuffer::getInstanceCount()
         << endl;


    return 0;
}
