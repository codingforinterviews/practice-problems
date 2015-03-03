function Queue() {
  this.stackIn = [];
  this.stackOut = [];
}

Queue.prototype.enqueue = function (item) {
  this.stackIn.push(item);
}

Queue.prototype.dequeue = function (item) {
  if (this.stackOut.length === 0) {
    var inItem;
    while (inItem = this.stackIn.pop()) {
      this.stackOut.push(inItem);
    }
  }

  return this.stackOut.pop();
}

var queue = new Queue();
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
