#include <iostream>

class vector {
private:
  int *v;
  int size;

public:
  vector(int i) {
    size = i;
    v = new int[i];
  }
  ~vector() { delete[] v; }
};

int main(int argc, char *argv[]) {
  vector v1(10);
  return 0;
}