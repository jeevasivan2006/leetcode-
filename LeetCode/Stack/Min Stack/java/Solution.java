class MinStack {
Stack<Integer> Stack;
Stack<Integer> minStack;
    public MinStack() {
        Stack=new Stack<>();
        minStack=new Stack<>();
    }
    
    public void push(int value) {
        Stack.push(value);
        if(minStack.isEmpty() || value<=minStack.peek()){
            minStack.push(value);
        }
    }
    
    public void pop() {
        if(Stack.peek().equals(minStack.peek())) minStack.pop();{
            Stack.pop();
        }
    }
    
    public int top() {
        return Stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */