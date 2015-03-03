function Staqueue() {
  this.stackIn = [];
  this.stackOut = [];
}

Staqueue.prototype.fastEnqueue = function (item) {
  this.stackIn.push(item);
}

Staqueue.prototype.fastDequeue = function (item) {
  if (this.stackOut.length === 0) {
    this.reverseFromTo(this.stackIn, this.stackOut);
  }

  return this.stackOut.pop();
}

Staqueue.prototype.enqueue = function (item) {
  this.stackIn.push(item);
};

Staqueue.prototype.dequeue = function (item) {
  this.reverseFromTo(this.stackIn, this.stackOut);

  var node = this.stackOut.pop();

  this.reverseFromTo(this.stackOut, this.stackIn);

  return node;
};

Staqueue.prototype.reverseFromTo = function (from, to) {
  var currentItem;
  while (currentItem = from.pop()) {
    to.push(currentItem);
  }
}


var queue = new Staqueue();
queue.enqueue('a');
queue.enqueue('b');
queue.enqueue('c');

console.log(queue.dequeue()); // a
console.log(queue.dequeue()); // b
queue.enqueue('d');
queue.enqueue('e');
console.log(queue.dequeue()); // c
// stack flip required
console.log(queue.dequeue()); // d
console.log(queue.dequeue()); // e


var queueFast = new Staqueue();
queue.fastEnqueue('a');
queue.fastEnqueue('b');
queue.fastEnqueue('c');

console.log(queue.fastDequeue()); // a
console.log(queue.fastDequeue()); // b
queue.fastEnqueue('d');
queue.fastEnqueue('e');
console.log(queue.fastDequeue()); // c
// stack flip required
console.log(queue.fastDequeue()); // d
console.log(queue.fastDequeue()); // e
