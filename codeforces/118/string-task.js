const readline = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout
});

readline.on('line', line => {
    console.log(line.toLowerCase().replace(/[aeiouy]+/g, '').replace(/(.)/g, ".$1"));
    readline.close();
});

