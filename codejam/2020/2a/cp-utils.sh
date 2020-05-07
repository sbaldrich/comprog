function func(){
	PROB=${1:r}
	echo ":: Checking Problem '$PROB' ::"
	for F in $PROB.*.in
	do
		OUT=$(java Solution < $F)
		if cmp -s <(echo $OUT) ${F:r}.out
			then RES="\\u2713"
			else RES="\\u2717"
		fi
		echo "Test #${F:r:e}: $RES"
	done
}
