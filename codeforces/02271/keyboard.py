kb = 'qwertyuiopasdfghjkl;zxcvbnm,./'
direction = input()
shift = -1 if direction == 'R' else 1
message = input()
ans = [ kb[kb.index(c) + shift] for c in message]
print(''.join(ans))