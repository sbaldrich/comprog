
## I used some variations of the following code to rename everything
## it is kept here for future reference in case I find out this was a very bad idea.
find . -depth -name '* *' -type f | \
while IFS= read -r f; do
   new_name=`basename $f | sed 's/^[ABCDE] - //' | tr '[:upper:]' '[:lower:]' | tr ' ' '_' | tr -cd '[:alnum:]._'`
   echo mv -i "$f" "$(dirname "$f")/$new_name"
done
