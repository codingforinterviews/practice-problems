var closersToOpeners = {
  ']': '[',
  ')': '(',
  '}': '{'
};

function isCloser(character) {
  return closersToOpeners.hasOwnProperty(character);
}

function isOpener(character) {
  for (var key in closersToOpeners) {
    if (closersToOpeners.hasOwnProperty(key) && closersToOpeners[key] === character) {
      return true;
    }
  }

  return false;
}

function isBalanced(delimiterString) {
  var openerStack = [];

  for (var i = 0; i < delimiterString.length; i++) {
    var currentChar = delimiterString[i];

    if (isOpener(currentChar)) {
      openerStack.push(currentChar);
    } else if (isCloser(currentChar)) {
      var expectedOpener = openerStack.pop();
      if (closersToOpeners[currentChar] !== expectedOpener) {
        return false;
      }
    } else {
      throw "Non-delimiter character in input";
    }
  }

  return openerStack.length === 0;
}

console.log(isBalanced("{}()[]"));
console.log(isBalanced("([)]"));
console.log(isBalanced("([omg)]")); // exception
