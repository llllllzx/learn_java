package class_03;

public class Code_01_Array_To_Stack_Queue_Lzx {

    //使用数组实现一个栈
    public static class ArrayStack {
        private int[] arr;
        private int index;

        public ArrayStack(int initSize) {
            if (initSize == 0) {
                throw new IllegalArgumentException("need more than 0");
            }
            this.arr = new int[initSize];
            this.index = 0;
        }

        public void push(int num) {
            if (index == arr.length) {
                throw new ArrayIndexOutOfBoundsException("stack is full");
            }
            arr[index++] = num;
        }

        public Integer peek() {
            if (index == 0) {
                throw new ArrayIndexOutOfBoundsException("stack is emtpy");
            }
            return arr[index - 1];
        }

        public Integer pop() {
            if (index == 0) {
                throw new ArrayIndexOutOfBoundsException("stack is empty");
            }
            return arr[--index];
        }

    }

    //使用数组实现一个队列
    public static class ArrayQueue {
        private int[] arr;
        //使用size将start 和 end解耦
        private int size;
        private int start;
        private int end;

        public ArrayQueue(int initSize) {
            if (initSize == 0) {
                throw new IllegalArgumentException("the initSize need more than 0");
            }
            this.arr = new int[initSize];
            this.size = 0;
            this.start = 0;
            this.end = 0;
        }

        public void add(int num) {
            if (size == arr.length) {
                throw new ArrayIndexOutOfBoundsException("the queue is full");
            }
            size++;
            arr[end] = num;
            end = end == arr.length - 1 ? 0 : end + 1;
        }

        public int peek() {
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("the queue is empty");
            }
            return arr[start];
        }

        public int pop() {
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("the queue is empty.");
            }
            size--;
            int temp = start;
            start = start == arr.length - 1 ? 0 : start + 1;
            return arr[temp];
        }
    }

    public static void main(String[] args) {
        final ArrayStack arrayStack = new ArrayStack(3);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);

        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());

        final ArrayQueue arrayQueue = new ArrayQueue(3);
        arrayQueue.add(1);
        arrayQueue.add(2);
        arrayQueue.add(3);

        System.out.println(arrayQueue.pop());
        System.out.println(arrayQueue.pop());
        System.out.println(arrayQueue.pop());

    }

}
