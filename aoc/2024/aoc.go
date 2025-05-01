package main

import (
	"path/filepath"
	"runtime"
	"strings"
)

func GetInputFile() string {
	_, path, _, ok := runtime.Caller(1)
	if !ok {
		panic("Unable to determine the caller file path!")
	}
	base, file := filepath.Split(path)
	inputsLocation, inputFile := strings.ReplaceAll(base, "arena", "arena/inputs"), strings.TrimSuffix(file, filepath.Ext(file))+".in"

	return filepath.Join(inputsLocation, inputFile)
}
