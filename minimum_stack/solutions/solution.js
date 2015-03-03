function Stack() {
  this.valueStack = [];
  this.minimumStack = [];
}

Stack.prototype.getMinimum = function () {
  return this.minimumStack.length === 0 ?
    null : this.minimumStack[this.minimumStack.length - 1];
};

Stack.prototype.peek = function () {
  return this.valueStack[this.valueStack.length - 1];
};

Stack.prototype.push = function (item) {
  this.valueStack.push(item);

  var currentMin = this.minimumStack.length > 0 ?
    this.minimumStack[this.minimumStack.length - 1] : item;

  if (item < currentMin) {
    this.minimumStack.push(item);
  } else {
    this.minimumStack.push(currentMin)
  }
};

Stack.prototype.pushAll = function (items) {
  items.forEach(function(item) {
    this.push(item);
  }, this);
};

var stack = new Stack();
stack.pushAll([1 ,2 ,3, 5, 0]);
console.log(stack.getMinimum());
