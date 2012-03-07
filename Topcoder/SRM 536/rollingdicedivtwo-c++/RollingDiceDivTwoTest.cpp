#include "RollingDiceDivTwo.h"
#include <iostream>
#include <vector>

using std::cerr;
using std::cout;
using std::endl;
using std::vector;

class RollingDiceDivTwoTest {

    static void assertEquals(int testCase, const int& expected, const int& actual) {
        if (expected == actual) {
            cout << "Test case " << testCase << " PASSED!" << endl;
        } else {
            cout << "Test case " << testCase << " FAILED! Expected: <" << expected << "> but was: <" << actual << '>' << endl;
        }
    }

    RollingDiceDivTwo solution;

    void testCase0() {
        string rolls_[] = {"137", "364", "115", "724"};
        vector<string> rolls(rolls_, rolls_ + (sizeof(rolls_) / sizeof(rolls_[0])));
		int expected_ = 14;
        assertEquals(0, expected_, solution.minimumFaces(rolls));
    }

    void testCase1() {
        string rolls_[] = {"1112", "1111", "1211", "1111"};
        vector<string> rolls(rolls_, rolls_ + (sizeof(rolls_) / sizeof(rolls_[0])));
		int expected_ = 5;
        assertEquals(1, expected_, solution.minimumFaces(rolls));
    }

    void testCase2() {
        string rolls_[] = {"24412", "56316", "66666", "45625"};
        vector<string> rolls(rolls_, rolls_ + (sizeof(rolls_) / sizeof(rolls_[0])));
		int expected_ = 30;
        assertEquals(2, expected_, solution.minimumFaces(rolls));
    }

    void testCase3() {
        string rolls_[] = {"931", "821", "156", "512", "129", "358", "555"};
        vector<string> rolls(rolls_, rolls_ + (sizeof(rolls_) / sizeof(rolls_[0])));
		int expected_ = 19;
        assertEquals(3, expected_, solution.minimumFaces(rolls));
    }

    void testCase4() {
        string rolls_[] = {"3", "7", "4", "2", "4"};
        vector<string> rolls(rolls_, rolls_ + (sizeof(rolls_) / sizeof(rolls_[0])));
		int expected_ = 7;
        assertEquals(4, expected_, solution.minimumFaces(rolls));
    }

    void testCase5() {
        string rolls_[] = {"281868247265686571829977999522", "611464285871136563343229916655", "716739845311113736768779647392", "779122814312329463718383927626", "571573431548647653632439431183", "547362375338962625957869719518", "539263489892486347713288936885", "417131347396232733384379841536"};
        vector<string> rolls(rolls_, rolls_ + (sizeof(rolls_) / sizeof(rolls_[0])));
		int expected_ = 176;
        assertEquals(5, expected_, solution.minimumFaces(rolls));
    }

    public: void runTest(int testCase) {
        switch (testCase) {
            case (0): testCase0(); break;
            case (1): testCase1(); break;
            case (2): testCase2(); break;
            case (3): testCase3(); break;
            case (4): testCase4(); break;
            case (5): testCase5(); break;
            default: cerr << "No such test case: " << testCase << endl; break;
        }
    }

};

int main() {
    for (int i = 0; i < 6; i++) {
        RollingDiceDivTwoTest test;
        test.runTest(i);
    }
}
