/*Is the polygon sorted clockwise or counter-clockwise? 
  if not, I'll find you. I swear, I'll find you and fucking kill you.
*/

double area(const vector<Point> &T) {
  double area = 0.0;
  for(int i = 1; i + 1 < T.size(); i++){
    area += (T[i] - T[0]) ^ (T[i + 1] - T[0]);
  }
  return abs(area / 2.0);
}

