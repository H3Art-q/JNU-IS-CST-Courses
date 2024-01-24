#include <algorithm>
#include <iostream>
#include <vector>

typedef std::vector<int> IntVector;
typedef std::vector<IntVector> IntVector2D;

class Matrix {
   private:
    int stage;
    IntVector2D *aMatrix;
    IntVector2D *sMatrix;

    void calculateEdge(void) {
        // Assign the final row and column value of aMatrix to sMatrix
        for (int i = 0; i < stage; i++) {
            (*sMatrix)[stage - 1][i] = (*aMatrix)[stage - 1][i];
            (*sMatrix)[i][stage - 1] = (*aMatrix)[i][stage - 1];
        }
    }

    void calculateCenter(void) {
        // Use dynamic programming, sMatrix stores the size of the biggest
        // submatrix
        for (int i = stage - 2; i >= 0; i--) {
            for (int j = stage - 2; j >= 0; j--) {
                // Start from the final column
                (*sMatrix)[i][j] =
                    (*aMatrix)[i][j] == 1
                        ? 1 + minOfThreeElement((*sMatrix)[i][j + 1],
                                                (*sMatrix)[i + 1][j + 1],
                                                (*sMatrix)[i + 1][j])
                        : 0;
            }
        }
    }

    inline int minOfThreeElement(int a, int b, int c) {
        int minimum = std::min(a, b);
        return std::min(minimum, c);
    }

   public:
    Matrix() {
        std::cout << "Enter the number of rows in matrix: ";
        std::cin >> stage;

        aMatrix = new IntVector2D(stage);
        sMatrix = new IntVector2D(stage);

        for (int i = 0; i < stage; i++) {
            (*aMatrix)[i].resize(stage);
            (*sMatrix)[i].resize(stage);
        }
    }

    void inputMatrix(void) {
        std::cout << "Enter the matrix row by row: " << std::endl;

        for (int i = 0; i < stage; i++) {
            for (int j = 0; j < stage; j++) {
                // Handling the wrong input data
                try {
                    std::cin >> (*aMatrix)[i][j];
                    if ((*aMatrix)[i][j] != 0 && (*aMatrix)[i][j] != 1) {
                        throw "Only allow input 1 or 0!";
                    }
                } catch (const char *e) {
                    std::cerr << e << '\n';
                    exit(1);
                }
            }
        }
    }

    void findMaxPosition(void) {
        calculateEdge();
        calculateCenter();

        int result = 0, rowIndex = 0, colIndex = 0;

        for (int i = 0; i < stage; i++) {
            std::vector<int>::iterator tempMax =
                std::max_element((*sMatrix)[i].begin(), (*sMatrix)[i].end());
                
            if (*tempMax > result) {
                rowIndex = i;
                colIndex = std::distance((*sMatrix)[i].begin(), tempMax);
                result = *tempMax;
            }
        }

        std::cout << "The maximum square submatrix is at (" << rowIndex;
        std::cout << ", " << colIndex << ") with size " << result << std::endl;
    }
};

int main(int argc, char *argv[]) {
    Matrix matrix;
    matrix.inputMatrix();
    matrix.findMaxPosition();
    return 0;
}