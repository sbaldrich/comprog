#!/bin/bash

tmux new-session -d -s cp -n comprog
tmux send-keys -t cp:comprog vim Enter C-l
tmux split-pane -v
tmux resize-pane -D 60
tmux send-keys jshell Enter
tmux split-pane -h
tmux resize-pane -L 70
tmux resize-pane -D 20
tmux attach -t cp:comprog
