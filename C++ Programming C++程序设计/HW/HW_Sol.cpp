#include <iostream>
#include <stdexcept>

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

  // Copy constructor
  vector(const vector &other) {
    size = other.size;
    v = new int[size];
    for (int i = 0; i < size; i++) {
      v[i] = other.v[i];
    }
  }

  // Overload the operator =
  vector &operator=(const vector &other) {
    if (this == &other) {
      return *this; // Prevent the self-assignment
    }

    // Clear old values
    delete[] v;

    size = other.size;
    v = new int[size];

    for (int i = 0; i < size; i++) {
      v[i] = other.v[i];
    }

    return *this;
  }

  // Overload the operator +
  vector operator+(const vector &other) {
    if (size != other.size) {
      throw std::invalid_argument("Vectors must have the same size for addition");
    }

    vector result(size);

    for (int i = 0; i < size; i++) {
      result.v[i] = v[i] + other.v[i];
    }

    // Return the instance of result √
    // Return the reference of result -> Undefined behavior ×
    return result;
  }

  // Overload the operator []
  int &operator[](int index) {
    if (index < 0 || index >= size) {
      throw std::out_of_range("Index out of range");
    }

    // Return the reference for assignment
    return v[index];
  }

  // Operator << can only be overloaded as friend function
  friend std::ostream &operator<<(std::ostream &, const vector &);
};

// Overload the ostream operator << for convenient test
std::ostream &operator<<(std::ostream &os, const vector &vec) {
  os << "Size of vector: " << vec.size << '\n' << "Vector: {";
  int len = vec.size;
  for (int i = 0; i < len; i++) {
    if (i < len - 1)
      std::cout << vec.v[i] << ", ";
    else
      std::cout << vec.v[i] << "}";
  }

  return os;
}

int main(int argc, char *argv[]) {
  vector v1(3);
  // Test operator [] assigment
  v1[0] = 100, v1[1] = 114514, v1[2] = 1919810;
  // Test operator [] access
  std::cout << v1[1] << ' ' << v1[2] << std::endl;

  // Test copy constructor
  vector v2 = v1;
  // Test operator +
  vector v3 = v1 + v2;

  std::cout << v1 << '\n' << v2 << '\n' << v3 << std::endl;

  // Test error handling
  vector *v4 = new vector(4);
  try {
    std::cout << v3 + *v4;
  } catch (std::invalid_argument e) {
    std::cout << e.what() << std::endl;
  }
  delete v4;

  return 0;
}