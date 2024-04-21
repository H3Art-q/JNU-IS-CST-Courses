#include <iostream>

using namespace std;

class Time {
   private:
    int hour = 0;
    int minute = 0;
    int second = 0;

   public:
    void showTime(void) {
        cout << "The time is:" << endl;
        cout << hour << ":";
        cout << minute << ":";
        cout << second << endl;
        return;
    }

    void getTime(void) {
        cout << "Please enter a time data(format:hour minute second)" << endl;
        cin >> hour >> minute >> second;
        return;
    }

    Time operator+(Time const &another) {
        Time result;
        result.second = (this->second + another.second) % 60;
        result.minute = (this->second + another.second) / 60;
        result.minute += (this->minute + another.minute) % 60;
        result.hour = (this->minute + another.minute) / 60;
        result.hour += (this->hour + another.hour);
        return result;
    }
};

int main(void) {
    Time t1, t2;
    t1.getTime();
    t2.getTime();
    (t1 + t2).showTime();
    return 0;
}