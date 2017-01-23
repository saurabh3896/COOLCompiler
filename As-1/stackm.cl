class Stack inherits IO {

  isNil() : Bool { true };                        -- return nil if stack is empty

  head()  : String { { abort(); "0"; } };         -- return top element

  tail()  : Stack { { abort(); self; } };         -- return rest of the stack

  cons(i : String) : Stack {                      -- append function (add)
    (new Substack).init(i, self)
  };

  push(element : String, stack : Stack) : Stack {  --push by calling cons to add element to stack from class Substack
    {
      stack.cons(element);                         -- call cons method of Substack class
    }
  };

  pop(curr : Stack) : Stack{                      --pop function
    {
      pop(curr);
    }
  };

};

class Substack inherits Stack {

  front : String;	                                -- The element in this Stack cell

  stack : Stack;	                                -- The rest of the Stack

  isNil() : Bool { false };                       -- return nil if stack is empty

  head()  : String { front };                     -- return top element

  tail()  : Stack { stack };                      -- return rest of the stack

  init(i : String, rest : Stack) : Stack {        -- init method to set car (front) to current element and rest to stack itself (recusive stack formation)
    {
	    front <- i;
	    stack <- rest;
	    self;
    }
  };

  pop(curr : Stack) : Stack {                     -- pop function
    {
      stack;                                      -- return cdr (rest) portion of the stack and remove top element
    }
  };

};

class Main inherits IO {

  n : Int <- 0;                                   -- n to measure current size of stack
  mystack : Stack <- new Stack;                   -- stack object
  continue : Bool <- true;                        -- while loop expression
  input : String;                                 -- rest member variables
  top : String;
  op1 : String;
  op2 : String;
  int1 : Int;
  int2 : Int;

  main() : Object {
    {
      out_string("Enter your command : \n1. <int> - push <int> to stack\n2. + - push + to stack\n3. s - push s to stack\n4. e - evaluate top of stack\n5. d - display\n6. x - stop\n");
      while continue loop {                       -- prompt
        out_string(">");
        input <- in_string();                     -- store inputstring in input
        if input = "d" then {                     -- print current stack
          out_string("Current stack content(s) : \n");
          printStack(mystack);
        }
        else if input = "e" then {                -- evaluate on the basis of stack top
          top <- mystack.head();
          mystack <- mystack.pop(mystack); n <- n - 1;
          if top = "s" then {                     -- if "s", then reverse top two elements
            reverse();
          }
          else if top = "+" then {                -- if "+", then check if >= 2 integers or not
            if n < 2 then {                       -- exit if not
              out_string("Invalid Configuration !!! Exiting...\n");
              abort();
            }
            else {
              solve();                            -- else solve
            }
            fi;
          }
          else {                                  -- if none of input matches, push simply the elements to stack
            mystack <- mystack.push(top, mystack); n <- n + 1;
          }
          fi fi;
        }
        else {
          if input = "x" then {                   -- if "x", then exit
            out_string("Exiting...\n");
            continue <- false;
          }
          else {                                  -- else push on stack
            mystack <- mystack.push(input, mystack); n <- n + 1;
          }
          fi;
        }
        fi fi;
      }
      pool;
    }
  };

  reverse() : Object {                            -- function to reverse top two contents
    {
      op1 <- mystack.head();                      --  pop top two and push in reverse order
      mystack <- mystack.pop(mystack);
      op2 <- mystack.head();
      mystack <- mystack.pop(mystack);
      mystack <- mystack.push(op1, mystack);
      mystack <- mystack.push(op2, mystack);
    }
  };

  solve() : Object {                              -- function to solve (add) the two current popped elements
    {
      op1 <- mystack.head();
      mystack <- mystack.pop(mystack); n <- n - 1;-- pop top two elements
      op2 <- mystack.head();
      mystack <- mystack.pop(mystack); n <- n - 1;
      int1 <- (new A2I).a2i(op1);                 -- apply operation to ints from strings
      int2 <- (new A2I).a2i(op2);                 -- push the result back to stack (int -> string)
      mystack <- mystack.push((new A2I).i2a(int1 + int2), mystack); n <- n + 1;
    }
  };

  printStack(l : Stack) : Object {                -- recursive method to print stack
    {
      if l.isNil() then {                         -- if null, print ""
        out_string("");
      }
      else {
  		  out_string(l.head());                     -- else print top and recursively call itself
  		  out_string("\n");
  		  printStack(l.tail());
  		}
      fi;
    }
  };

};
