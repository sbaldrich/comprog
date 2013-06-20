#include "NumberMagicEasy.h"
#include <iostream>
#include <string>

using std::cerr;
using std::cout;
using std::endl;
using std::string;

class NumberMagicEasyTest {

    static void assertEquals(int testCase, const int& expected, const int& actual) {
        if (expected == actual) {
            cout << "Test case " << testCase << " PASSED!" << endl;
        } else {
            cout << "Test case " << testCase << " FAILED! Expected: <" << expected << "> but was: <" << actual << '>' << endl;
        }
    }

    NumberMagicEasy solution;

    void testCase0() {
		string answer = "YNYY";
		int expected_ = 5;
        assertEquals(0, expected_, solution.theNumber(answer));
    }

    void testCase1() {
		string answer = "YNNN";
		int expected_ = 8;
        assertEquals(1, expected_, solution.theNumber(answer));
    }

    void testCase2() {
		string answer = "NNNN";
		int expected_ = 16;
        assertEquals(2, expected_, solution.theNumber(answer));
    }

    void testCase3() {
		string answer = "YYYY";
		int expected_ = 1;
        assertEquals(3, expected_, solution.theNumber(answer));
    }

    void testCase4() {
		string answer = "NYNY";
		int expected_ = 11;
        assertEquals(4, expected_, solution.theNumber(answer));
    }

    public: void runTest(int testCase) {
        switch (testCase) {
            case (0): testCase0(); break;
            case (1): testCase1(); break;
            case (2): testCase2(); break;
            case (3): testCase3(); break;
            case (4): testCase4(); break;
            default: cerr << "No such test case: " << testCase << endl; break;
        }
    }

};

int main() {
    for (int i = 0; i < 5; i++) {
        NumberMagicEasyTest test;
        test.runTest(i);
    }
}
