#include "RabbitVoting.h"
#include <iostream>
#include <string>
#include <vector>

using std::cerr;
using std::cout;
using std::endl;
using std::string;
using std::vector;

class RabbitVotingTest {

    static void assertEquals(int testCase, const string& expected, const string& actual) {
        if (expected == actual) {
            cout << "Test case " << testCase << " PASSED!" << endl;
        } else {
            cout << "Test case " << testCase << " FAILED! Expected: <" << '"' << expected << '"' << "> but was: <" << '"' << actual << '"' << '>' << endl;
        }
    }

    RabbitVoting solution;

    void testCase0() {
        string names_[] = {"Alice", "Bill", "Carol", "Dick"};
        vector<string> names(names_, names_ + (sizeof(names_) / sizeof(names_[0])));
        string votes_[] = {"Bill", "Dick", "Alice", "Alice"};
        vector<string> votes(votes_, votes_ + (sizeof(votes_) / sizeof(votes_[0])));
		string expected_ = "Alice";
        assertEquals(0, expected_, solution.getWinner(names, votes));
    }

    void testCase1() {
        string names_[] = {"Alice", "Bill", "Carol", "Dick"};
        vector<string> names(names_, names_ + (sizeof(names_) / sizeof(names_[0])));
        string votes_[] = {"Carol", "Carol", "Bill", "Bill"};
        vector<string> votes(votes_, votes_ + (sizeof(votes_) / sizeof(votes_[0])));
		string expected_ = "";
        assertEquals(1, expected_, solution.getWinner(names, votes));
    }

    void testCase2() {
        string names_[] = {"Alice", "Bill", "Carol", "Dick"};
        vector<string> names(names_, names_ + (sizeof(names_) / sizeof(names_[0])));
        string votes_[] = {"Alice", "Alice", "Bill", "Bill"};
        vector<string> votes(votes_, votes_ + (sizeof(votes_) / sizeof(votes_[0])));
		string expected_ = "Bill";
        assertEquals(2, expected_, solution.getWinner(names, votes));
    }

    void testCase3() {
        string names_[] = {"Alice", "Bill"};
        vector<string> names(names_, names_ + (sizeof(names_) / sizeof(names_[0])));
        string votes_[] = {"Alice", "Bill"};
        vector<string> votes(votes_, votes_ + (sizeof(votes_) / sizeof(votes_[0])));
		string expected_ = "";
        assertEquals(3, expected_, solution.getWinner(names, votes));
    }

    void testCase4() {
        string names_[] = {"WhiteRabbit", "whiterabbit", "whiteRabbit", "Whiterabbit"};
        vector<string> names(names_, names_ + (sizeof(names_) / sizeof(names_[0])));
        string votes_[] = {"whiteRabbit", "whiteRabbit", "whiteRabbit", "WhiteRabbit"};
        vector<string> votes(votes_, votes_ + (sizeof(votes_) / sizeof(votes_[0])));
		string expected_ = "whiteRabbit";
        assertEquals(4, expected_, solution.getWinner(names, votes));
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
        RabbitVotingTest test;
        test.runTest(i);
    }
}
