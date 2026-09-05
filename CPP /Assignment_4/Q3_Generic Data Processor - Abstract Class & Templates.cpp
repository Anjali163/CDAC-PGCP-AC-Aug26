//============================================================================
// Name        : Q3_Generic.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <stdexcept>
#include <iomanip>

using namespace std;


// ABSTRACT DATA PROCESSOR


class DataProcessor {
public:

    virtual void loadData(const string& source) = 0;

    virtual void processData() = 0;

    virtual void exportResult(
        const string& destination) = 0;

    virtual string processorType() const = 0;

    virtual int recordCount() const = 0;


    // Default implementation
    virtual void printSummary() const
    {
        cout << "Processor: "
             << processorType()
             << endl;

        cout << "Records: "
             << recordCount()
             << endl;
    }


    virtual ~DataProcessor() = default;
};


// CSV PROCESSOR


class CSVProcessor : public DataProcessor {
private:
    vector<string> records;

public:

    void loadData(const string& source) override
    {
        cout << "Loading CSV from: "
             << source << endl;

        records = {
            "name,age",
            "Anjali,21",
            "Rohan,22",
            "Priya,20",
            "Amit,23"
        };
    }


    void processData() override
    {
        for (string& record : records)
        {
            for (char& ch : record)
            {
                if (ch >= 'a' && ch <= 'z')
                    ch = ch - 'a' + 'A';
            }
        }
    }


    void exportResult(
        const string& destination) override
    {
        cout << "[CSV EXPORT → "
             << destination
             << "]"
             << endl;

        for (const string& record : records)
        {
            cout << record << endl;
        }
    }


    string processorType() const override
    {
        return "CSV Processor";
    }


    int recordCount() const override
    {
        return records.size();
    }
};


// SENSOR STREAM PROCESSOR


class SensorStreamProcessor : public DataProcessor {
private:
    vector<double> readings;

    double mean = 0;
    double minimum = 0;
    double maximum = 0;

public:

    void loadData(const string& source) override
    {
        cout << "Loading sensor data from: "
             << source << endl;

        readings = {
            23.4,
            21.8,
            25.1,
            24.6,
            22.9,
            26.3,
            23.7,
            24.2
        };
    }


    void processData() override
    {
        if (readings.empty())
            return;


        double sum = 0;

        minimum = readings[0];
        maximum = readings[0];


        for (double value : readings)
        {
            sum += value;

            if (value < minimum)
                minimum = value;

            if (value > maximum)
                maximum = value;
        }


        mean = sum / readings.size();
    }


    void exportResult(
        const string& destination) override
    {
        cout << "[SENSOR EXPORT → "
             << destination
             << "]"
             << endl;

        cout << fixed << setprecision(2);

        cout << "Mean: "
             << mean << endl;

        cout << "Min: "
             << minimum << endl;

        cout << "Max: "
             << maximum << endl;
    }


    string processorType() const override
    {
        return "Sensor Stream Processor";
    }


    int recordCount() const override
    {
        return readings.size();
    }


    double getMean() const
    {
        return mean;
    }
};


// DATA BUFFER TEMPLATE


template <typename T>
class DataBuffer {
private:

    T* data;

    int capacity;

    int head;

    int tail;

    int count;


public:

    DataBuffer(int cap)
        : capacity(cap),
          head(0),
          tail(0),
          count(0)
    {
        if (capacity <= 0)
            throw invalid_argument(
                "Capacity must be positive"
            );

        data = new T[capacity];
    }


    ~DataBuffer()
    {
        delete[] data;
    }


    void push(const T& value)
    {
        data[tail] = value;

        tail = (tail + 1) % capacity;


        if (count < capacity)
        {
            count++;
        }
        else
        {
            // Buffer was full.
            // Move head because oldest was overwritten.
            head = (head + 1) % capacity;
        }
    }


    T pop()
    {
        if (isEmpty())
        {
            throw underflow_error(
                "Buffer is empty"
            );
        }


        T value = data[head];

        head = (head + 1) % capacity;

        count--;

        return value;
    }


    T peek() const
    {
        if (isEmpty())
        {
            throw underflow_error(
                "Buffer is empty"
            );
        }

        return data[head];
    }


    bool isEmpty() const
    {
        return count == 0;
    }


    bool isFull() const
    {
        return count == capacity;
    }


    int size() const
    {
        return count;
    }


    template <typename U>
    friend ostream& operator<<(
        ostream& out,
        const DataBuffer<U>& buf
    );
};


// TEMPLATE FRIEND OPERATOR

template <typename U>
ostream& operator<<(
    ostream& out,
    const DataBuffer<U>& buf
)
{
    out << "[";


    for (int i = 0; i < buf.count; i++)
    {
        int index =
            (buf.head + i) % buf.capacity;

        out << buf.data[index];

        if (i < buf.count - 1)
            out << ", ";
    }


    out << "]";

    return out;
}


// MAIN


int main()
{

    // PART A — DATA PROCESSORS


    vector<DataProcessor*> pipeline;


    pipeline.push_back(
        new CSVProcessor()
    );


    pipeline.push_back(
        new SensorStreamProcessor()
    );


    for (auto* p : pipeline)
    {
        p->loadData("source_data");

        p->processData();

        p->printSummary();

        p->exportResult("output_dir");

        cout << "---" << endl;
    }


    // This causes a compile error because
    // DataProcessor is an abstract class.
    //
    // DataProcessor dp;


    // dynamic_cast


    cout << "\n===== DYNAMIC CAST CHECK =====\n";


    for (auto* p : pipeline)
    {
        if (auto* csv =
            dynamic_cast<CSVProcessor*>(p))
        {
            cout << "Found CSV Processor with "
                 << csv->recordCount()
                 << " records."
                 << endl;
        }
        else if (auto* sensor =
                 dynamic_cast<SensorStreamProcessor*>(p))
        {
            cout << "Found Sensor Processor — Mean: "
                 << sensor->getMean()
                 << endl;
        }
    }


    // Cleanup
    for (auto* p : pipeline)
    {
        delete p;
    }

    // PART B — INTEGER BUFFER

    cout << "\n===== INTEGER BUFFER =====\n";


    DataBuffer<int> tickBuffer(5);


    for (int i = 1; i <= 7; i++)
    {
        tickBuffer.push(i * 10);
    }


    cout << "Tick Buffer: "
         << tickBuffer
         << endl;


    // DOUBLE BUFFER

    cout << "\n===== DOUBLE BUFFER =====\n";


    DataBuffer<double> tempBuffer(4);


    tempBuffer.push(36.6);
    tempBuffer.push(37.1);
    tempBuffer.push(38.2);
    tempBuffer.push(36.9);


    cout << "Before pop: "
         << tempBuffer
         << endl;


    cout << "Popped: "
         << tempBuffer.pop()
         << endl;


    cout << "After pop: "
         << tempBuffer
         << endl;


    // STRING BUFFER

    cout << "\n===== STRING BUFFER =====\n";


    DataBuffer<string> logBuffer(3);


    logBuffer.push(
        "INFO: Server started"
    );

    logBuffer.push(
        "WARN: High memory usage"
    );

    logBuffer.push(
        "ERROR: DB connection timeout"
    );

    logBuffer.push(
        "INFO: Retry successful"
    );


    cout << "Log Buffer: "
         << logBuffer
         << endl;


    return 0;
}
